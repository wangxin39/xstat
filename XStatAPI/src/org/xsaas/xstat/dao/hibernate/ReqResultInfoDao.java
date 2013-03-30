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
import org.xsaas.xstat.dao.IReqResultInfoDao;
import org.xsaas.xstat.po.ReqResultInfo;


public class ReqResultInfoDao extends HibernateDaoSupport implements IReqResultInfoDao {

	@Override
	public void deleteReqResultInfo(ReqResultInfo data) {
		this.getHibernateTemplate().delete(data);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ReqResultInfo> findReqResultInfoByPage(final int firstResult,final int maxResult) {
		List<ReqResultInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ReqResultInfo.class);
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("resultID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ReqResultInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<ReqResultInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ReqResultInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("resultID"));
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
		Criteria query = this.getSession().createCriteria(ReqResultInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("resultID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
	@Override
	public ReqResultInfo getReqResultInfo(Long authID) {
		
		return (ReqResultInfo) this.getHibernateTemplate().get(ReqResultInfo.class, authID);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ReqResultInfo> getReqResultInfoList() {
		List<ReqResultInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ReqResultInfo.class);
				 query.add(Restrictions.eq("status", 1));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public int getReqResultInfoTotal() {
		Criteria query = this.getSession().createCriteria(ReqResultInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("resultID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}

	@Override
	public void saveReqResultInfo(ReqResultInfo data) {
		
		this.getHibernateTemplate().save(data);
	}

	@Override
	public void updateReqResultInfo(ReqResultInfo data) {
		this.getHibernateTemplate().update(data);
		
	}

	@Override
	public ReqResultInfo findReqResultInfoBySmgk(long smgkID) {
		return (ReqResultInfo) this.getHibernateTemplate().get(ReqResultInfo.class, smgkID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReqResultInfo> findReqResultInfoByReq(final Long reqID) {
		List<ReqResultInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ReqResultInfo.class);		
				 query.add(org.hibernate.criterion.Restrictions.eq("reqID", reqID));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}

}
