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
import org.xsaas.xstat.dao.ICityInfoDao;
import org.xsaas.xstat.po.CityInfo;


public class CityInfoDao extends HibernateDaoSupport implements ICityInfoDao {

	@Override
	public void deleteCityInfo(CityInfo data) {
		
		this.getHibernateTemplate().delete(data);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CityInfo> findCityInfoByPage(final int firstResult,final int maxResult) {
		List<CityInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(CityInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("cityID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}

	@Override
	public CityInfo getCityInfo(Long cityID) {
		
		return (CityInfo) this.getHibernateTemplate().get(CityInfo.class, cityID);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CityInfo> getCityInfoList() {
		List<CityInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(CityInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("cityID"));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public int getCityInfoTotal() {
		Criteria query = this.getSession().createCriteria(CityInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("cityID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}

	@Override
	public void saveCityInfo(CityInfo data) {
		
		this.getHibernateTemplate().save(data);
	}

	@Override
	public void updateCityInfo(CityInfo data) {
		
		this.getHibernateTemplate().update(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CityInfo> findCityInfoByPage(final int province, final int firstResult, final int maxResult) {
		List<CityInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(CityInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("province", province));
				 query.addOrder(Order.desc("cityID"));				
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getCityInfoTotal(int province) {
		Criteria query = this.getSession().createCriteria(CityInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.add(Restrictions.eq("province", province));
		query.setProjection(Projections.count("cityID"));
		
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
	public List<CityInfo> getCityInfoList(final int province) {
		List<CityInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(CityInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("province", province));
				 query.addOrder(Order.desc("cityID"));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<CityInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<CityInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(CityInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("cityID"));
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
		Criteria query = this.getSession().createCriteria(CityInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("cityID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}

}
