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
import org.xsaas.xstat.dao.IInquisitionTemplateInfoDao;
import org.xsaas.xstat.po.InquisitionTemplateInfo;


public class InquisitionTemplateInfoDao extends HibernateDaoSupport implements
		IInquisitionTemplateInfoDao {

	@Override
	public void delete(InquisitionTemplateInfo data) {
		
		this.getHibernateTemplate().delete(data);
	}

	@Override
	public InquisitionTemplateInfo getInquisitionTemplateInfo(Long templateID) {
		return (InquisitionTemplateInfo) this.getHibernateTemplate().get(InquisitionTemplateInfo.class,templateID);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<InquisitionTemplateInfo> getInquisitionTemplateInfoList() {
		Criteria query = this.getSession().createCriteria(InquisitionTemplateInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.addOrder(Order.desc("templateID"));
		query.setMaxResults(Integer.MAX_VALUE);
		return query.list();
	}

	@Override
	public void save(InquisitionTemplateInfo data) {
		
		this.getHibernateTemplate().save(data);
	}

	@Override
	public void update(InquisitionTemplateInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<InquisitionTemplateInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<InquisitionTemplateInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(InquisitionTemplateInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("templateID"));
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
		Criteria query = this.getSession().createCriteria(InquisitionTemplateInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("templateID"));
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
	public List<InquisitionTemplateInfo> findByPage(final int firstResult,final int maxResult) {
		List<InquisitionTemplateInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session sess)throws HibernateException, SQLException {
				Criteria query = sess.createCriteria(InquisitionTemplateInfo.class);
				query.add(Restrictions.eq("status", 1));
				query.addOrder(Order.desc("templateID"));
				query.setFirstResult(firstResult);
				query.setMaxResults(maxResult);
			return query.list();
			}
			
		});
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public int getTotal() {
		Criteria query = this.getSession().createCriteria(InquisitionTemplateInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("templateID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}


}
