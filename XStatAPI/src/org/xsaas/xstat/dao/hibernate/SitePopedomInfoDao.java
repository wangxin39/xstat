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
import org.xsaas.xstat.dao.ISitePopedomInfoDao;
import org.xsaas.xstat.po.SitePopedomInfo;


public class SitePopedomInfoDao extends HibernateDaoSupport implements
		ISitePopedomInfoDao {
	/**
	 * ɾ����վȨ����Ϣ
	 */
	public void delete(SitePopedomInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	/**
	 * ���ݱ�Ż�ȡ��Ϣ�б�
	 */
	public SitePopedomInfo getSitePopedomInfo(Long sitePopedomID) {
		
		return (SitePopedomInfo) this.getHibernateTemplate().get(SitePopedomInfo.class, sitePopedomID);
	}
	/**
	 * ������վȨ����Ϣ
	 */
	public void save(SitePopedomInfo data) {
		this.getHibernateTemplate().save(data);
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<SitePopedomInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<SitePopedomInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(SitePopedomInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("sitePopedomID"));
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
		Criteria query = this.getSession().createCriteria(SitePopedomInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("sitePopedomID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
	/**
	 * ���±��淭����Ϣ
	 */
	public void update(SitePopedomInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	/**
	 * ��ȡ�б���Ϣ
	 */
	
	@SuppressWarnings("unchecked")
	public List<SitePopedomInfo> getSitePopedomInfoList() {
		List<SitePopedomInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(SitePopedomInfo.class);
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
	 * @return list<SitePopedomInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<SitePopedomInfo> findByPage(final int firstResult,final int maxResult) {
		List<SitePopedomInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(SitePopedomInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("sitePopedomID"));
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
		Criteria query = this.getSession().createCriteria(SitePopedomInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("sitePopedomID"));
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
	public List<SitePopedomInfo> findSitePopedomInfoByPage(final long employeeID,final int firstResult,final int maxResult) {
		List<SitePopedomInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(SitePopedomInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("employeeID", employeeID));
				 query.addOrder(Order.desc("sitePopedomID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getSitePopedomInfoTotal(long employeeID) {
		Criteria query = this.getSession().createCriteria(SitePopedomInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.add(Restrictions.eq("employeeID", employeeID));
		query.setProjection(Projections.rowCount());
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
	
	/**
	 * ��ȡ�б���Ϣ
	 */
	
	@SuppressWarnings("unchecked")
	public List<SitePopedomInfo> getSitePopedomInfoList(final Long employeeID) {
		List<SitePopedomInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(SitePopedomInfo.class);
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("employeeID",employeeID));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}
}
