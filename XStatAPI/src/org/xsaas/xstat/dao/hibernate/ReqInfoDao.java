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
import org.xsaas.xstat.dao.IReqInfoDao;
import org.xsaas.xstat.po.ReqInfo;



public class ReqInfoDao extends HibernateDaoSupport implements
		IReqInfoDao {

	@Override
	public void deleteReqInfo(ReqInfo data) {
		this.getHibernateTemplate().delete(data);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ReqInfo> findReqInfoByPage(final int firstResult,final
			int maxResult) {
		List<ReqInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ReqInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("reqID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ReqInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<ReqInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ReqInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("reqID"));
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
		Criteria query = this.getSession().createCriteria(ReqInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("reqID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
	@Override
	public ReqInfo getReqInfo(Long reqID) {
		
		return (ReqInfo) this.getHibernateTemplate().get(ReqInfo.class, reqID);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ReqInfo> getReqInfoList() {
		List<ReqInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ReqInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public int getReqInfoTotal() {
		Criteria query = this.getSession().createCriteria(ReqInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("reqID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}

	@Override
	public void saveReqInfo(ReqInfo data) {
		
		this.getHibernateTemplate().save(data);
	}

	@Override
	public void updateReqInfo(ReqInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
}
