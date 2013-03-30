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
import org.xsaas.xstat.dao.ISmgkInfoDao;
import org.xsaas.xstat.po.SmgkInfo;


public class SmgkInfoDao extends HibernateDaoSupport implements
		ISmgkInfoDao {

	@Override
	public void deleteSmgkInfo(SmgkInfo data) {
		
		this.getHibernateTemplate().delete(data);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SmgkInfo> findSmgkInfoByPage(final int firstResult,final int maxResult) {
		List<SmgkInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(SmgkInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("smgkID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<SmgkInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<SmgkInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(SmgkInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("smgkID"));
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
		Criteria query = this.getSession().createCriteria(SmgkInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("smgkID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
	@Override
	public SmgkInfo getSmgkInfo(Long smgkID) {
		
		return (SmgkInfo) this.getHibernateTemplate().get(SmgkInfo.class,smgkID);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SmgkInfo> getSmgkInfoList() {
		List<SmgkInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(SmgkInfo.class);		
				 query.add(Restrictions.eq("status", 1));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public int getSmgkInfoTotal() {
		Criteria query = this.getSession().createCriteria(SmgkInfo.class);
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
	public void saveSmgkInfo(SmgkInfo data) {
		
		this.getHibernateTemplate().save(data);
	}

	@Override
	public void updateSmgkInfo(SmgkInfo data) {
		
		this.getHibernateTemplate().update(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public SmgkInfo isLogin(String username, String password) {
		SmgkInfo info = null;
		Criteria query = this.getSession().createCriteria(SmgkInfo.class);
		query.add(Restrictions.eq("userName", username));
		query.add(Restrictions.eq("passWord", password));		
		query.setMaxResults(1);
		List list = query.list();
		if(list.size() > 0) {
			info = (SmgkInfo)list.get(0);
		}
		return info;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isRegister(String userName) {
		boolean yes = false;
		Criteria query = this.getSession().createCriteria(SmgkInfo.class);
		query.add(Restrictions.eq("userName", userName));
		query.setProjection(Projections.rowCount());
		query.setMaxResults(1);
		List list = query.list();
		if(list.size() > 0) {
//			当数据库有记录时，返回值为已注册过此用户，如果为0，则表示没有注册
			int num = (Integer) list.get(0);
			if(num > 0){
				yes = true;
			}
		}
		return yes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SmgkInfo> findSmgkInfoByPage(final Integer status,final int firstResult,final int maxResult) {
		List<SmgkInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(SmgkInfo.class);	
				 
				 query.add(Restrictions.eq("status",status));
				 query.addOrder(Order.desc("smgkID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getSmgkInfoTotal(Integer status) {
		Criteria query = this.getSession().createCriteria(SmgkInfo.class);
		query.add(Restrictions.eq("status",status));
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
