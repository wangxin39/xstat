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
import org.xsaas.xstat.dao.IClientPopedomInfoDao;
import org.xsaas.xstat.po.ClientPopedomInfo;


public class ClientPopedomInfoDao extends HibernateDaoSupport implements
		IClientPopedomInfoDao {

	@Override
	public void deleteClientPopedomInfo(ClientPopedomInfo data) {
		
		this.getHibernateTemplate().delete(data);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ClientPopedomInfo> findClientPopedomInfoByPage(
			final int firstResult,final int maxResult) {
		List<ClientPopedomInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ClientPopedomInfo.class);
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("clientPopedomID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}

	@Override
	public ClientPopedomInfo getClientPopedomInfo(Long clientPopedomID) {
		
		return (ClientPopedomInfo) this.getHibernateTemplate().get(ClientPopedomInfo.class, clientPopedomID);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ClientPopedomInfo> getClientPopedomInfoList() {
		List<ClientPopedomInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ClientPopedomInfo.class);
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("clientPopedomID"));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public int getClientPopedomInfoTotal() {
		Criteria query = this.getSession().createCriteria(ClientPopedomInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.rowCount());
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
		
	}

	@Override
	public void saveClientPopedomInfo(ClientPopedomInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	@Override
	public void updateClientPopedomInfo(ClientPopedomInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ClientPopedomInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<ClientPopedomInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ClientPopedomInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("clientPopedomID"));
				 query.addOrder(Order.desc("clientPopedomID"));
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
		Criteria query = this.getSession().createCriteria(ClientPopedomInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("clientPopedomID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
}
