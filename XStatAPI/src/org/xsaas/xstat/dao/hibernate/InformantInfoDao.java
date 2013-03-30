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
import org.xsaas.xstat.dao.IInformantInfoDao;
import org.xsaas.xstat.po.InformantInfo;



public class InformantInfoDao extends HibernateDaoSupport implements
		IInformantInfoDao {

	@Override
	public void deleteInformantInfo(InformantInfo data) {
		
		this.getHibernateTemplate().delete(data);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<InformantInfo> findInformantInfoByPage(final int firstResult,final
			int maxResult) {
		List<InformantInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(InformantInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("informantID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}

	@Override
	public InformantInfo getInformantInfo(Long informantID) {
		
		return (InformantInfo) this.getHibernateTemplate().get(InformantInfo.class, informantID);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<InformantInfo> getInformantInfoList() {
		List<InformantInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(InformantInfo.class);
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("informantID"));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public int getInformantInfoTotal() {
		Criteria query = this.getSession().createCriteria(InformantInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("informantID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<InformantInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<InformantInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(InformantInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("informantID"));
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
		Criteria query = this.getSession().createCriteria(InformantInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("informantID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
	@Override
	public void saveInformantInfo(InformantInfo data) {
		
		this.getHibernateTemplate().save(data);
	}

	@Override
	public void updateInformantInfo(InformantInfo data) {
		
		this.getHibernateTemplate().update(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InformantInfo> findInformantInfoByPage(final long clientID,final int firstResult,final int maxResult) {
		List<InformantInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(InformantInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("clientID", clientID));
				 query.addOrder(Order.desc("informantID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getInformantInfoTotal(long clientID,long informantID) {
		Criteria query = this.getSession().createCriteria(InformantInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.add(Restrictions.eq("clientID", clientID));
		query.add(Restrictions.eq("informantID", informantID));
		query.setProjection(Projections.count("informantID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getInformantInfoTotal(long clientID) {
		Criteria query = this.getSession().createCriteria(InformantInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.add(Restrictions.eq("clientID", clientID));
		query.setProjection(Projections.count("informantID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InformantInfo> getInformantInfoList(final Long clientID) {
		List<InformantInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(InformantInfo.class);
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("clientID", clientID));
				 query.addOrder(Order.desc("informantID"));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}


}
