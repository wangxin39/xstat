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
import org.xsaas.xstat.dao.IReportTemplateInfoDao;
import org.xsaas.xstat.po.ReportTemplateInfo;


public class ReportTemplateInfoDao extends HibernateDaoSupport implements
		IReportTemplateInfoDao {

	@Override
	public void deleteReportTemplateInfo(ReportTemplateInfo data) {
		
		this.getHibernateTemplate().delete(data);
	}

	@Override
	public ReportTemplateInfo getReportTemplateInfo(Long templateID) {
		return (ReportTemplateInfo) this.getHibernateTemplate().get(ReportTemplateInfo.class,templateID);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ReportTemplateInfo> getReportTemplateInfoList() {
		Criteria query = this.getSession().createCriteria(ReportTemplateInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.setMaxResults(Integer.MAX_VALUE);
		return query.list();
	}

	@Override
	public void saveReportTemplateInfo(ReportTemplateInfo data) {
		
		this.getHibernateTemplate().save(data);
	}

	@Override
	public void updateReportTemplateInfo(ReportTemplateInfo data) {
		
		this.getHibernateTemplate().update(data);
	}


	@Override
	@SuppressWarnings("unchecked")
	public List<ReportTemplateInfo> findReportTemplateInfoByPage(final int firstResult,final int maxResult) {
		List<ReportTemplateInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session sess)throws HibernateException, SQLException {
				Criteria query = sess.createCriteria(ReportTemplateInfo.class);
				 query.add(Restrictions.eq("status", 1));
				query.addOrder(Order.desc("reportTemplateID"));
				query.setFirstResult(firstResult);
				query.setMaxResults(maxResult);
			return query.list();
			}
			
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ReportTemplateInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<ReportTemplateInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ReportTemplateInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("reportTemplateID"));
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
		Criteria query = this.getSession().createCriteria(ReportTemplateInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("reportTemplateID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
	@Override
	@SuppressWarnings("unchecked")
	public int getReportTemplateInfoTotal() {
		Criteria query = this.getSession().createCriteria(ReportTemplateInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("reportTemplateID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}

}
