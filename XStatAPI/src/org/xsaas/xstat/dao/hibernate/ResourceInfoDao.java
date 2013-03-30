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
import org.xsaas.xstat.dao.IResourceInfoDao;
import org.xsaas.xstat.po.ResourceInfo;


public class ResourceInfoDao extends HibernateDaoSupport implements
		IResourceInfoDao {

	/**
	 * 删除问卷试题资源信息
	 */
	public void delete(ResourceInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	/**
	 * 根据编号获取信息列表
	 */
	public ResourceInfo getResourceInfo(Long resourceID) {		
		return (ResourceInfo) this.getHibernateTemplate().get(ResourceInfo.class, resourceID);
	}
	/**
	 * 保存问卷试题资源信息
	 */
	public void save(ResourceInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	/**
	 * 更新问卷试题资源信息
	 */
	public void update(ResourceInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	/**
	 * 获取列表信息
	 */
	
	@SuppressWarnings("unchecked")
	public List<ResourceInfo> getList() {
		List<ResourceInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ResourceInfo.class);	
				 query.add(Restrictions.eq("status", 1));
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
	 * @return list<QuestionResInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<ResourceInfo> findByPage(final int firstResult,final int maxResult) {
		List<ResourceInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ResourceInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("resID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ResourceInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<ResourceInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ResourceInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("resourceID"));
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
		Criteria query = this.getSession().createCriteria(ResourceInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("resourceID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
	/**
	 * 通过指定的起始数获取总集合
	 * @return 集合总数
	 */
	@SuppressWarnings("unchecked")
	public int getTotal() {
		Criteria query = this.getSession().createCriteria(ResourceInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("resourceID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
}
