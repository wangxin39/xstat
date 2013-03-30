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
import org.xsaas.xstat.dao.IAddressCatalogInfoDao;
import org.xsaas.xstat.po.AddressCatalogInfo;


public class AddressCatalogInfoDao extends HibernateDaoSupport implements
		IAddressCatalogInfoDao {

	@Override
	public void deleteAddressCatalogInfo(AddressCatalogInfo data) {
		
		this.getHibernateTemplate().delete(data);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<AddressCatalogInfo> findAddressCatalogInfoByPage(
			final int firstResult,final int maxResult) {
		List<AddressCatalogInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(AddressCatalogInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("acID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}

	@Override
	public AddressCatalogInfo getAddressCatalogInfo(Long acID) {
		
		return (AddressCatalogInfo) this.getHibernateTemplate().get(AddressCatalogInfo.class, acID);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<AddressCatalogInfo> getAddressCatalogInfoList() {
		List<AddressCatalogInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(AddressCatalogInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.setMaxResults(Integer.MAX_VALUE);
				 query.addOrder(Order.desc("acID"));
				 return query.list();
			 }
		});
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public int getAddressCatalogInfoTotal() {
		Criteria query = this.getSession().createCriteria(AddressCatalogInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.rowCount());
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}

	@Override
	public void saveAddressCatalogInfo(AddressCatalogInfo data) {
		this.getHibernateTemplate().save(data);		
	}

	@Override
	public void updateAddressCatalogInfo(AddressCatalogInfo data) {
		
		this.getHibernateTemplate().update(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AddressCatalogInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<AddressCatalogInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(AddressCatalogInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("acID"));
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
		Criteria query = this.getSession().createCriteria(AddressCatalogInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("acID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
}
