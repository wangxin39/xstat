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
import org.xsaas.xstat.dao.IThemeStyleInfoDao;
import org.xsaas.xstat.po.ThemeStyleInfo;


public class ThemeStyleInfoDao extends HibernateDaoSupport implements
		IThemeStyleInfoDao {
	/**
	 * ɾ���ʾ�����Ϣ
	 */
	public void delete(ThemeStyleInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	/**
	 * ���ݱ�Ż�ȡ��Ϣ�б�
	 */
	public ThemeStyleInfo getThemeStyleInfo(Long statID) {
		
		return (ThemeStyleInfo) this.getHibernateTemplate().get(ThemeStyleInfo.class, statID);
	}
	/**
	 * �����ʾ�����Ϣ
	 */
	public void save(ThemeStyleInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	/**
	 * �����ʾ�����Ϣ
	 */
	public void update(ThemeStyleInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	/**
	 * ��ȡ�б���Ϣ
	 */
	
	@SuppressWarnings("unchecked")
	public List<ThemeStyleInfo> getThemeStyleInfoList() {
		List<ThemeStyleInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ThemeStyleInfo.class);
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("styleID"));
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
	 * @return list<ThemeStyleInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<ThemeStyleInfo> findByPage(final int firstResult,final int maxResult) {
		List<ThemeStyleInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ThemeStyleInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("styleID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ThemeStyleInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<ThemeStyleInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ThemeStyleInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("styleID"));
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
		Criteria query = this.getSession().createCriteria(ThemeStyleInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("styleID"));
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
		Criteria query = this.getSession().createCriteria(ThemeStyleInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("styleID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}

}
