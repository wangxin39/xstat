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
import org.xsaas.xstat.dao.IInquisitionHeaderInfoDao;
import org.xsaas.xstat.po.InquisitionHeaderInfo;


public class InquisitionHeaderInfoDao extends HibernateDaoSupport implements
		IInquisitionHeaderInfoDao{

	/**
	 * 删除问卷信息
	 */
	public void delete(InquisitionHeaderInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	/**
	 * 根据编号获取信息列表
	 */
	public InquisitionHeaderInfo getInquisitionHeaderInfo(Long headerID) {
		
		return (InquisitionHeaderInfo) this.getHibernateTemplate().get(InquisitionHeaderInfo.class, headerID);
	}
	/**
	 * 保存问卷信息
	 */
	public void save(InquisitionHeaderInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	/**
	 * 更新问卷信息
	 */
	public void update(InquisitionHeaderInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	/**
	 * 获取列表信息
	 */
	
	@SuppressWarnings("unchecked")
	public List<InquisitionHeaderInfo> getInquisitionHeaderInfoList() {
		List<InquisitionHeaderInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(InquisitionHeaderInfo.class);
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("headerID"));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}
	/**
	 * 通过指定的起始数和结束数得到一个集合
	 * @param firstResult
	 * @param maxResult
	 * @return list<InquisitionHeaderInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<InquisitionHeaderInfo> findByPage(final int firstResult,final int maxResult) {
		List<InquisitionHeaderInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(InquisitionHeaderInfo.class);
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("headerID"));
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
		Criteria query = this.getSession().createCriteria(InquisitionHeaderInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("headerID"));
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
	public List<InquisitionHeaderInfo> getInquisitionHeaderInfoList(final Long inquisitionID) {
		List<InquisitionHeaderInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(InquisitionHeaderInfo.class);
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("inquisitionID", inquisitionID));
				 query.addOrder(Order.desc("headerID"));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<InquisitionHeaderInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<InquisitionHeaderInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(InquisitionHeaderInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("headerID"));
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
		Criteria query = this.getSession().createCriteria(InquisitionHeaderInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("headerID"));
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
	public int getInquisitionHeaderInfoTotal(long inquisitionID) {
		Criteria query = this.getSession().createCriteria(InquisitionHeaderInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.add(Restrictions.eq("inquisitionID", inquisitionID));
		query.setProjection(Projections.count("headerID"));
	
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
	public List<InquisitionHeaderInfo> findInquisitionHeaderInfoByPage(final long inquisitionID,final int firstResult,final int maxResult) {
		List<InquisitionHeaderInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(InquisitionHeaderInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("inquisitionID", inquisitionID));
				 query.addOrder(Order.desc("headerID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getNewShowOrder(Long inquisitionID) {
		Criteria query = this.getSession().createCriteria(InquisitionHeaderInfo.class);
		query.add(Restrictions.eq("inquisitionID", inquisitionID));
		query.setProjection(Projections.property("showOrder"));
		query.addOrder(Order.desc("showOrder"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 1;
		if(list.size() > 0) {
			Object obj = list.get(0);
			if(obj != null) {
				result += (Integer)obj;				
			}			
		}		
		return result;
	}
}
