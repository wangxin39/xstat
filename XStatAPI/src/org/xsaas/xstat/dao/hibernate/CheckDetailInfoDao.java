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
import org.xsaas.xstat.dao.ICheckDetailInfoDao;
import org.xsaas.xstat.po.CheckDetailInfo;


public class CheckDetailInfoDao extends HibernateDaoSupport implements
		ICheckDetailInfoDao {

	@Override
	public void deleteCheckDetailInfo(CheckDetailInfo data) {
		this.getHibernateTemplate().delete(data);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CheckDetailInfo> findCheckDetailInfoByPage(final int firstResult,final
			int maxResult) {
		List<CheckDetailInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(CheckDetailInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("checkDetailID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<CheckDetailInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<CheckDetailInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(CheckDetailInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("checkDetailID"));
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
		Criteria query = this.getSession().createCriteria(CheckDetailInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("checkDetailID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
	@Override
	public CheckDetailInfo getCheckDetailInfo(Long clientID) {
		
		return (CheckDetailInfo) this.getHibernateTemplate().get(CheckDetailInfo.class, clientID);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CheckDetailInfo> getCheckDetailInfoList() {
		List<CheckDetailInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(CheckDetailInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("checkDetailID"));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public int getCheckDetailInfoTotal() {
		Criteria query = this.getSession().createCriteria(CheckDetailInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("checkDetailID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}

	@Override
	public void saveCheckDetailInfo(CheckDetailInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	@Override
	public void updateCheckDetailInfo(CheckDetailInfo data) {
		
		this.getHibernateTemplate().update(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CheckDetailInfo> findByPage(final Long issueID,final Long informantID,final Long inquisitionID,final int firstResult,final int maxResult) {
		List<CheckDetailInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(CheckDetailInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("informantID", informantID));
				 query.add(Restrictions.eq("inquisitionID", inquisitionID));
				 query.add(Restrictions.eq("issueID", issueID));
				 query.addOrder(Order.desc("checkDetailID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getTotal(Long issueID, Long informantID, Long inquisitionID) {
		Criteria query = this.getSession().createCriteria(CheckDetailInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.add(Restrictions.eq("informantID", informantID));
		query.add(Restrictions.eq("inquisitionID", inquisitionID));
		query.add(Restrictions.eq("issueID", issueID));
		query.setProjection(Projections.count("checkDetailID"));
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
	public List<CheckDetailInfo> findCheckDetailInfoByPage(final Long clientID,final int firstResult,final int maxResult) {
		List<CheckDetailInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(CheckDetailInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("clientID", clientID));
				 query.addOrder(Order.desc("checkDetailID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getCheckDetailInfoTotal(Long clientID) {
		Criteria query = this.getSession().createCriteria(CheckDetailInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.add(Restrictions.eq("clientID", clientID));
		query.setProjection(Projections.count("checkDetailID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}


}
