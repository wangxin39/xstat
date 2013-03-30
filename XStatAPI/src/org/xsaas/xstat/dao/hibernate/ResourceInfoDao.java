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
	 * ɾ���ʾ�������Դ��Ϣ
	 */
	public void delete(ResourceInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	/**
	 * ���ݱ�Ż�ȡ��Ϣ�б�
	 */
	public ResourceInfo getResourceInfo(Long resourceID) {		
		return (ResourceInfo) this.getHibernateTemplate().get(ResourceInfo.class, resourceID);
	}
	/**
	 * �����ʾ�������Դ��Ϣ
	 */
	public void save(ResourceInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	/**
	 * �����ʾ�������Դ��Ϣ
	 */
	public void update(ResourceInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	/**
	 * ��ȡ�б���Ϣ
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
	 * ͨ��ָ������ʼ���ͽ������õ�һ������
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
	 * ͨ��ָ������ʼ����ȡ�ܼ���
	 * @return ��������
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
