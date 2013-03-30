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
import org.xsaas.xstat.dao.ISmgkPopedomInfoDao;
import org.xsaas.xstat.po.SmgkPopedomInfo;


public class SmgkPopedomInfoDao extends HibernateDaoSupport implements ISmgkPopedomInfoDao {

	@Override
	public void deleteSmgkPopedomInfo(SmgkPopedomInfo data) {
		
		this.getHibernateTemplate().delete(data);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SmgkPopedomInfo> findSmgkPopedomInfoByPage(final int firstResult,final int maxResult) {
		List<SmgkPopedomInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(SmgkPopedomInfo.class);		 
				 query.addOrder(Order.desc("smgkPopedomID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}

	@Override
	public SmgkPopedomInfo getSmgkPopedomInfo(Long smgkPopedomID) {
		
		return (SmgkPopedomInfo) this.getHibernateTemplate().get(SmgkPopedomInfo.class, smgkPopedomID);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SmgkPopedomInfo> getSmgkPopedomInfoList() {
		List<SmgkPopedomInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(SmgkPopedomInfo.class);		 
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public int getSmgkPopedomInfoTotal() {
		Criteria query = this.getSession().createCriteria(SmgkPopedomInfo.class);
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
	public void saveSmgkPopedomInfo(SmgkPopedomInfo data) {
		
		this.getHibernateTemplate().save(data);
	}

	@Override
	public void updateSmgkPopedomInfo(SmgkPopedomInfo data) {
		
		this.getHibernateTemplate().update(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SmgkPopedomInfo> findSmgkPopedomInfoByPage(final long smgkID,final int firstResult,final int maxResult) {
		List<SmgkPopedomInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(SmgkPopedomInfo.class);	
				 query.add(Restrictions.eq("smgkID", smgkID));
				 query.addOrder(Order.desc("smgkPopedomID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getSmgkPopedomInfoTotal(long smgkID) {
		Criteria query = this.getSession().createCriteria(SmgkPopedomInfo.class);
		query.add(Restrictions.eq("smgkID", smgkID));
		query.setProjection(Projections.rowCount());
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}

}
