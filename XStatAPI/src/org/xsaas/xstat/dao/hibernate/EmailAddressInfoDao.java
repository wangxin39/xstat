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
import org.xsaas.xstat.dao.IEmailAddressInfoDao;
import org.xsaas.xstat.po.EmailAddressInfo;


public class EmailAddressInfoDao extends HibernateDaoSupport implements
		IEmailAddressInfoDao {

	@Override
	public void deleteEmailAddressInfo(EmailAddressInfo data) {
		
		this.getHibernateTemplate().delete(data);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EmailAddressInfo> findEmailAddressInfoByPage(final int firstResult,final
			int maxResult) {
		List<EmailAddressInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(EmailAddressInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("addressID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}

	@Override
	public EmailAddressInfo getEmailAddressInfo(Long addressID) {
		
		return (EmailAddressInfo) this.getHibernateTemplate().get(EmailAddressInfo.class, addressID);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EmailAddressInfo> getEmailAddressInfoList() {
		List<EmailAddressInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(EmailAddressInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("addressID"));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public int getEmailAddressInfoTotal() {
		Criteria query = this.getSession().createCriteria(EmailAddressInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("addressID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}

	@Override
	public void saveEmailAddressInfo(EmailAddressInfo data) {
		
		this.getHibernateTemplate().save(data);
	}

	@Override
	public void updateEmailAddressInfo(EmailAddressInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<EmailAddressInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<EmailAddressInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(EmailAddressInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("addressID"));
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
		Criteria query = this.getSession().createCriteria(EmailAddressInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("addressID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
}
