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
import org.xsaas.xstat.dao.IPublishInfoDao;
import org.xsaas.xstat.po.PublishInfo;


public class PublishInfoDao extends HibernateDaoSupport implements
		IPublishInfoDao {
	/**
	 * 删除问卷部分信息
	 */
	public void delete(PublishInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	/**
	 * 根据编号获取信息列表
	 */
	public PublishInfo getPublishInfo(Long markID) {
		
		return (PublishInfo) this.getHibernateTemplate().get(PublishInfo.class, markID);
	}
	/**
	 * 保存问卷部分信息
	 */
	public void save(PublishInfo data) {
		this.getHibernateTemplate().save(data);
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PublishInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<PublishInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PublishInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("publishID"));
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
		Criteria query = this.getSession().createCriteria(PublishInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("publishID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
	/**
	 * 更新问卷部分信息
	 */
	public void update(PublishInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	/**
	 * 获取列表信息
	 */
	
	@SuppressWarnings("unchecked")
	public List<PublishInfo> getPublishInfoList() {
		List<PublishInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PublishInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("publishID"));
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
	 * @return list<PublishInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<PublishInfo> findByPage(final int firstResult,final int maxResult) {
		List<PublishInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PublishInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("publishID"));
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
	public int getTotal() {
		Criteria query = this.getSession().createCriteria(PublishInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("publishID"));
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
	public List<PublishInfo> findByPage(final int type,final  int firstResult,final  int maxResult) {
		List<PublishInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PublishInfo.class);
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("type",type));
				 query.addOrder(Order.desc("publishID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PublishInfo> findByPage(final int type,final  Long smgkID,final  int firstResult,final 	int maxResult) {
		List<PublishInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PublishInfo.class);
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("type",type));
				 query.add(Restrictions.eq("smgkID",smgkID));
				 query.addOrder(Order.desc("publishID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getTotal(int type) {
		Criteria query = this.getSession().createCriteria(PublishInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.add(Restrictions.eq("type",type));
		query.setProjection(Projections.count("publishID"));
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
	public int getTotal(int type, Long smgkID) {
		Criteria query = this.getSession().createCriteria(PublishInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.add(Restrictions.eq("type",type));
		query.add(Restrictions.eq("smgkID",smgkID));
		query.setProjection(Projections.count("publishID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
}
