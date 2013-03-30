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
import org.xsaas.xstat.dao.IRealityCheckInfoDao;
import org.xsaas.xstat.po.RealityCheckInfo;


public class RealityCheckInfoDao extends HibernateDaoSupport implements
		IRealityCheckInfoDao {

	@Override
	public void deleteRealityCheckInfo(RealityCheckInfo data) {
		this.getHibernateTemplate().delete(data);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<RealityCheckInfo> findRealityCheckInfoByPage(final int firstResult,final
			int maxResult) {
		List<RealityCheckInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(RealityCheckInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("realityCheckID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<RealityCheckInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<RealityCheckInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(RealityCheckInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("realityCheckID"));
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
		Criteria query = this.getSession().createCriteria(RealityCheckInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("realityCheckID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
	@Override
	public RealityCheckInfo getRealityCheckInfo(Long clientID) {
		
		return (RealityCheckInfo) this.getHibernateTemplate().get(RealityCheckInfo.class, clientID);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<RealityCheckInfo> getRealityCheckInfoList() {
		List<RealityCheckInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(RealityCheckInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public int getRealityCheckInfoTotal() {
		Criteria query = this.getSession().createCriteria(RealityCheckInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("realityCheckID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}

	@Override
	public void saveRealityCheckInfo(RealityCheckInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	@Override
	public void updateRealityCheckInfo(RealityCheckInfo data) {
		
		this.getHibernateTemplate().update(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RealityCheckInfo> findByPage(final Long issueID, final Long inquisitionID,final int firstResult,final int maxResult) {
		List<RealityCheckInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(RealityCheckInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("inquisitionID", inquisitionID));
				 query.add(Restrictions.eq("issueID", issueID));
				 query.addOrder(Order.desc("realityCheckID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getTotal(Long issueID, Long inquisitionID) {
		Criteria query = this.getSession().createCriteria(RealityCheckInfo.class);
	    query.add(Restrictions.eq("status", 1));
		query.add(Restrictions.eq("inquisitionID", inquisitionID));
		query.add(Restrictions.eq("issueID", issueID));
		query.setProjection(Projections.count("realityCheckID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public int getRealityCheckInfoTotal(Long clientID) {
		Criteria query = this.getSession().createCriteria(RealityCheckInfo.class);
		 query.add(Restrictions.eq("status", 1));
		 query.add(Restrictions.eq("clientID",clientID));
		query.setProjection(Projections.count("realityCheckID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<RealityCheckInfo> findRealityCheckInfoByPage(final Long clientID,final int firstResult,final
			int maxResult) {
		List<RealityCheckInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(RealityCheckInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("clientID",clientID));
				 query.addOrder(Order.desc("realityCheckID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}

}
