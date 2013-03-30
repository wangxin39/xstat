package org.xsaas.xstat.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.xsaas.xstat.dao.IClientInfoDao;
import org.xsaas.xstat.po.ClientInfo;


public class ClientInfoDao extends HibernateDaoSupport implements
		IClientInfoDao {

	@Override
	public void deleteClientInfo(ClientInfo data) {
		this.getHibernateTemplate().delete(data);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ClientInfo> findClientInfoByPage(final int firstResult,final
			int maxResult) {
		List<ClientInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ClientInfo.class);
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("clientID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}

	@Override
	public ClientInfo getClientInfo(Long clientID) {
		
		return (ClientInfo) this.getHibernateTemplate().get(ClientInfo.class, clientID);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ClientInfo> getClientInfoList() {
		List<ClientInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ClientInfo.class);
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("clientID"));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public int getClientInfoTotal() {
		Criteria query = this.getSession().createCriteria(ClientInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("clientID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}

	@Override
	public void saveClientInfo(ClientInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	@Override
	public void updateClientInfo(ClientInfo data) {
		
		this.getHibernateTemplate().update(data);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<ClientInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<ClientInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ClientInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("clientID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getTotalByDelStatus() {
		Criteria query = this.getSession().createCriteria(ClientInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("clientID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}


}
