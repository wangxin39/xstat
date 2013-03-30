package org.xsaas.xstat.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.xsaas.xstat.dao.ISmgkMenuInfoDao;
import org.xsaas.xstat.po.SmgkMenuInfo;



public class SmgkMenuInfoDao extends HibernateDaoSupport implements ISmgkMenuInfoDao {

	@Override
	public void delete(SmgkMenuInfo data) {
		this.getHibernateTemplate().delete(data);	
	}

	@Override
	public SmgkMenuInfo getSmgkMenuInfo(Long menuID) {
		return (SmgkMenuInfo)this.getHibernateTemplate().get(SmgkMenuInfo.class, menuID);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public int getTotal() {
		Criteria query = this.getSession().createCriteria(SmgkMenuInfo.class);
		query.setProjection(Projections.count("menuID"));
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
	public List<SmgkMenuInfo> findByPage(final int firstResult,final int maxResult) {
		List<SmgkMenuInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(SmgkMenuInfo.class);		 
				 query.addOrder(Order.desc("menuID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@Override
	public void save(SmgkMenuInfo data) {
		this.getHibernateTemplate().save(data);
	}

	@Override
	public void update(SmgkMenuInfo data) {
		this.getHibernateTemplate().update(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SmgkMenuInfo> getSmgkMenuInfoList() {
		List<SmgkMenuInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(SmgkMenuInfo.class);		 
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;

	}

}
