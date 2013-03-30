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
import org.xsaas.xstat.dao.IInquisitionInfoDao;
import org.xsaas.xstat.po.InquisitionInfo;


public class InquisitionInfoDao extends HibernateDaoSupport implements
		IInquisitionInfoDao{

	/**
	 * 删除问卷信息
	 */
	public void delete(InquisitionInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	/**
	 * 根据编号获取信息列表
	 */
	public InquisitionInfo getInquisitionInfo(Long inquisitionID) {
		
		return (InquisitionInfo) this.getHibernateTemplate().get(InquisitionInfo.class,inquisitionID);
	}
	/**
	 * 保存问卷信息
	 */
	public void save(InquisitionInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	/**
	 * 更新问卷信息
	 */
	public void update(InquisitionInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	/**
	 * 获取列表信息
	 */
	
	@SuppressWarnings("unchecked")
	public List<InquisitionInfo> getInquisitionInfoList() {
		List<InquisitionInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(InquisitionInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("inquisitionID"));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<InquisitionInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<InquisitionInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(InquisitionInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("inquisitionID"));
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
		Criteria query = this.getSession().createCriteria(InquisitionInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("inquisitionID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
	/**
	 * 通过指定的起始数和结束数得到一个集合
	 * @param firstResult
	 * @param maxResult
	 * @return list<InquisitionInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<InquisitionInfo> findByPage(final int firstResult,final int maxResult) {
		List<InquisitionInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(InquisitionInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("inquisitionID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	/**
	 * 通过指定的起始数获取总集合
	 * @return \集合总数
	 */
	@SuppressWarnings("unchecked")
	public int getTotal() {
		Criteria query = this.getSession().createCriteria(InquisitionInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("inquisitionID"));
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
	public List<InquisitionInfo> findByPage(final int status,final int firstResult, final int maxResult) {
		List<InquisitionInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(InquisitionInfo.class);		 
				 query.add(Restrictions.eq("status",status));
				 query.addOrder(Order.desc("inquisitionID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getTotal(int status) {
		Criteria query = this.getSession().createCriteria(InquisitionInfo.class);
		query.setProjection(Projections.count("inquisitionID"));
		query.add(Restrictions.eq("status",status));
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
	public List<InquisitionInfo> getList(final Long clientID) {
		List<InquisitionInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(InquisitionInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("clientID", clientID));
				 query.addOrder(Order.desc("inquisitionID"));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}



}
