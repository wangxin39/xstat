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
import org.xsaas.xstat.dao.IThemeInfoDao;
import org.xsaas.xstat.po.ThemeInfo;


public class ThemeInfoDao extends HibernateDaoSupport implements
		IThemeInfoDao {
	/**
	 * 删除问卷部分信息
	 */
	public void delete(ThemeInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	/**
	 * 根据编号获取信息列表
	 */
	public ThemeInfo getThemeInfo(Long statID) {
		
		return (ThemeInfo) this.getHibernateTemplate().get(ThemeInfo.class, statID);
	}
	/**
	 * 保存问卷部分信息
	 */
	public void save(ThemeInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	/**
	 * 更新问卷部分信息
	 */
	public void update(ThemeInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	/**
	 * 获取列表信息
	 */
	
	@SuppressWarnings("unchecked")
	public List<ThemeInfo> getThemeInfoList() {
		List<ThemeInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ThemeInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("themeID"));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ThemeInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<ThemeInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ThemeInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("themeID"));
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
		Criteria query = this.getSession().createCriteria(ThemeInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("themeID"));
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
	 * @return list<ThemeInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<ThemeInfo> findByPage(final int firstResult,final int maxResult) {
		List<ThemeInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ThemeInfo.class);
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("themeID"));
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
		Criteria query = this.getSession().createCriteria(ThemeInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("themeID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
	
}
