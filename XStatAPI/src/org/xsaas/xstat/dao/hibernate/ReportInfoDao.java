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
import org.xsaas.xstat.dao.IReportInfoDao;
import org.xsaas.xstat.po.ReportInfo;


public class ReportInfoDao extends HibernateDaoSupport implements
		IReportInfoDao {
	/**
	 * ɾ����������Ϣ
	 */
	public void delete(ReportInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	/**
	 * ���ݱ�Ż�ȡ��Ϣ�б�
	 */
	public ReportInfo getReportInfo(Long reportID) {
		
		return (ReportInfo) this.getHibernateTemplate().get(ReportInfo.class, reportID);
	}
	/**
	 * �����������Ϣ
	 */
	public void save(ReportInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	/**
	 * ���±��淭����Ϣ
	 */
	public void update(ReportInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	/**
	 * ��ȡ�б���Ϣ
	 */
	
	@SuppressWarnings("unchecked")
	public List<ReportInfo> getReportInfoList() {
		List<ReportInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ReportInfo.class);	
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
	 * @return list<ThemeInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<ReportInfo> findByPage(final int firstResult,final int maxResult) {
		List<ReportInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ReportInfo.class);		 
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("reportID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ReportInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<ReportInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ReportInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("reportID"));
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
		Criteria query = this.getSession().createCriteria(ReportInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("reportID"));
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
		Criteria query = this.getSession().createCriteria(ReportInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("reportID"));
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
	public List<ReportInfo> findByPage(final Long issueID,final Long informantID,final int firstResult,final int maxResult) {
		List<ReportInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ReportInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("issueID", issueID));
				 query.add(Restrictions.eq("informantID", informantID));
				 query.addOrder(Order.desc("reportID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getTotal(Long issueID, Long informantID) {
		Criteria query = this.getSession().createCriteria(ReportInfo.class);
		 query.add(Restrictions.eq("status", 1));
		 query.add(Restrictions.eq("issueID", issueID));
		 query.add(Restrictions.eq("informantID", informantID));
		query.setProjection(Projections.count("reportID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
	
}
