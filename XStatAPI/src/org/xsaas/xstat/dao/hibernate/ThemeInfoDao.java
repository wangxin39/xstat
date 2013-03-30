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
	 * ɾ���ʾ�����Ϣ
	 */
	public void delete(ThemeInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	/**
	 * ���ݱ�Ż�ȡ��Ϣ�б�
	 */
	public ThemeInfo getThemeInfo(Long statID) {
		
		return (ThemeInfo) this.getHibernateTemplate().get(ThemeInfo.class, statID);
	}
	/**
	 * �����ʾ�����Ϣ
	 */
	public void save(ThemeInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	/**
	 * �����ʾ�����Ϣ
	 */
	public void update(ThemeInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	/**
	 * ��ȡ�б���Ϣ
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
	 * ͨ��ָ������ʼ���ͽ������õ�һ������
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
	 * ͨ��ָ������ʼ����ȡ�ܼ���
	 * @return ��������
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
