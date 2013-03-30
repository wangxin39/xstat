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
import org.xsaas.xstat.dao.IEmailDraftInfoDao;
import org.xsaas.xstat.po.EmailDraftInfo;


public class EmailDraftInfoDao extends HibernateDaoSupport implements
		IEmailDraftInfoDao {

	@Override
	public void deleteEmailDraftInfo(EmailDraftInfo data) {
		
		this.getHibernateTemplate().delete(data);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EmailDraftInfo> findEmailDraftInfoByPage(final int firstResult,final
			int maxResult) {
		List<EmailDraftInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(EmailDraftInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("draftID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}

	@Override
	public EmailDraftInfo getEmailDraftInfo(Long draftID) {
		
		return (EmailDraftInfo) this.getHibernateTemplate().get(EmailDraftInfo.class, draftID);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EmailDraftInfo> getEmailDraftInfoList() {
		List<EmailDraftInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(EmailDraftInfo.class);
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("draftID"));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public int getEmailDraftInfoTotal() {
		Criteria query = this.getSession().createCriteria(EmailDraftInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("draftID"));
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
	public List<EmailDraftInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<EmailDraftInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(EmailDraftInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("draftID"));
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
		Criteria query = this.getSession().createCriteria(EmailDraftInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("draftID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
	@Override
	public void saveEmailDraftInfo(EmailDraftInfo data) {
		
		this.getHibernateTemplate().save(data);
	}

	@Override
	public void updateEmailDraftInfo(EmailDraftInfo data) {
		
		this.getHibernateTemplate().update(data);
	}

}
