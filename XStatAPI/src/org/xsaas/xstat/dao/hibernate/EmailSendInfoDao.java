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
import org.xsaas.xstat.dao.IEmailSendInfoDao;
import org.xsaas.xstat.po.EmailSendInfo;


public class EmailSendInfoDao extends HibernateDaoSupport implements
		IEmailSendInfoDao {

	@Override
	public void deleteEmailSendInfo(EmailSendInfo data) {
		
		this.getHibernateTemplate().delete(data);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EmailSendInfo> findEmailSendInfoByPage(final int firstResult,final
			int maxResult) {
		List<EmailSendInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(EmailSendInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("sendID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}

	@Override
	public EmailSendInfo getEmailSendInfo(Long sendID) {
		
		return (EmailSendInfo) this.getHibernateTemplate().get(EmailSendInfo.class, sendID);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EmailSendInfo> getEmailSendInfoList() {
		List<EmailSendInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(EmailSendInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.setMaxResults(Integer.MAX_VALUE);		
				 query.addOrder(Order.desc("sendID"));
				 return query.list();
			 }
		});
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public int getEmailSendInfoTotal() {
		Criteria query = this.getSession().createCriteria(EmailSendInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("sendID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}

	@Override
	public void saveEmailSendInfo(EmailSendInfo data) {
		
		this.getHibernateTemplate().save(data);
	}

	@Override
	public void updateEmailSendInfo(EmailSendInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<EmailSendInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<EmailSendInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(EmailSendInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("sendID"));			 
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
		Criteria query = this.getSession().createCriteria(EmailSendInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("sendID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
}
