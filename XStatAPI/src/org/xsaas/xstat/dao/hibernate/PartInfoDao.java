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
import org.xsaas.xstat.dao.IPartInfoDao;
import org.xsaas.xstat.po.PartInfo;


public class PartInfoDao extends HibernateDaoSupport implements
		IPartInfoDao {
	/**
	 * 删除问卷部分信息
	 */
	public void delete(PartInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	/**
	 * 根据编号获取信息列表
	 */
	public PartInfo getPartInfo(Long partID) {
		
		return (PartInfo) this.getHibernateTemplate().get(PartInfo.class, partID);
	}
	/**
	 * 保存问卷部分信息
	 */
	public void save(PartInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	/**
	 * 更新问卷部分信息
	 */
	public void update(PartInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	/**
	 * 获取列表信息
	 */
	
	@SuppressWarnings("unchecked")
	public List<PartInfo> getPartInfoList() {
		List<PartInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PartInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PartInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<PartInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PartInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("partID"));
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
		Criteria query = this.getSession().createCriteria(PartInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("partID"));
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
	 * @return list<PartInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<PartInfo> findByPage(final long inquisitionID,final int firstResult,final int maxResult) {
		List<PartInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PartInfo.class);
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("inquisitionID", inquisitionID));
				 query.addOrder(Order.desc("partID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	/**
	 * 通过指定的起始数获取总集合
	 * @return 集合总数
	 */
	@SuppressWarnings("unchecked")
	public int getTotal(long inquisitionID) {
		Criteria query = this.getSession().createCriteria(PartInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.add(Restrictions.eq("inquisitionID", inquisitionID));
		query.setProjection(Projections.count("partID"));
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
	public List<PartInfo> getPartInfoList(final Long inquisitionID) {
		List<PartInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PartInfo.class);
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("inquisitionID", inquisitionID));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PartInfo> findByPage(final int firstResult, final int maxResult) {
		List<PartInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PartInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);
				 return query.list();
			 }
		});
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int getTotal() {
		Criteria query = this.getSession().createCriteria(PartInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("partID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}

}
