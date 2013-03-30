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
import org.xsaas.xstat.dao.ISelectWeightInfoDao;
import org.xsaas.xstat.po.SelectWeightInfo;


public class SelectWeightInfoDao extends HibernateDaoSupport implements	ISelectWeightInfoDao {

	public void delete(SelectWeightInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	public SelectWeightInfo getSelectWeightInfo(Long selectWeightID) {
		
		return (SelectWeightInfo) this.getHibernateTemplate().get(SelectWeightInfo.class, selectWeightID);
	}
	public void save(SelectWeightInfo data) {
		this.getHibernateTemplate().save(data);
		
	}
	public void update(SelectWeightInfo data) {		
		this.getHibernateTemplate().update(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SelectWeightInfo> findByPage(final int firstResult,final int maxResult) {
		List<SelectWeightInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(SelectWeightInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("selectWeightID"));
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
		Criteria query = this.getSession().createCriteria(SelectWeightInfo.class);
		query.setProjection(Projections.rowCount());
		query.add(Restrictions.eq("status", 2));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			Object obj = list.get(0);
			if(obj != null) {
				result = (Integer)obj;				
			}
		}		
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getTotal() {
		Criteria query = this.getSession().createCriteria(SelectWeightInfo.class);
		query.setProjection(Projections.count("selectWeightID"));
		query.add(Restrictions.eq("status",1));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			Object obj = list.get(0);
			if(obj != null) {
				result = (Integer)obj;				
			}
		}		
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getCountWeight(Long inquisitionID, Long partID) {
		Criteria query = this.getSession().createCriteria(SelectWeightInfo.class);
		query.setProjection(Projections.sum("weight"));
		query.add(Restrictions.eq("inquisitionID", inquisitionID));
		query.add(Restrictions.eq("partID", partID));
		query.add(Restrictions.eq("status",1));
		query.setMaxResults(1);
		List list = query.list();		
		int result = 0;
		if(list.size() > 0) {
			Object obj = list.get(0);					
			if(obj != null) {
				result = (Integer)obj;
			}
		}
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<SelectWeightInfo> findByDelStatus(final int firstResult, final int maxResult) {
		List<SelectWeightInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(SelectWeightInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("selectWeightID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<SelectWeightInfo> findByPage(Long inquisitionID,int firstResult, int maxResult) {
		 Criteria query = this.getSession().createCriteria(SelectWeightInfo.class);		 
		 query.add(Restrictions.eq("inquisitionID", inquisitionID));
		 query.add(Restrictions.eq("status",1));
		 query.setFirstResult(firstResult);
		 query.setMaxResults(maxResult);
		 return query.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<SelectWeightInfo> findByPage(Long inquisitionID, Long partID,
			int firstResult, int maxResult) {
		 Criteria query = this.getSession().createCriteria(SelectWeightInfo.class);		 
		 query.add(Restrictions.eq("inquisitionID", inquisitionID));
		 query.add(Restrictions.eq("partID", partID));
		 query.add(Restrictions.eq("status",1));
		 query.setFirstResult(firstResult);
		 query.setMaxResults(maxResult);
		 return query.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<SelectWeightInfo> findByPart(Long inquisitionID, Long partID) {
		 Criteria query = this.getSession().createCriteria(SelectWeightInfo.class);		 
		 query.add(Restrictions.eq("inquisitionID", inquisitionID));
		 query.add(Restrictions.eq("partID", partID));
		 query.add(Restrictions.eq("status",1));
		 query.setMaxResults(Integer.MAX_VALUE);
		 return query.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<SelectWeightInfo> findByPartQuestion(Long inquisitionID,Long partQuestionID) {
		 Criteria query = this.getSession().createCriteria(SelectWeightInfo.class);		 
		 query.add(Restrictions.eq("inquisitionID", inquisitionID));
		 query.add(Restrictions.eq("partQuestionID", partQuestionID));
		 query.add(Restrictions.eq("status",1));
		 query.setMaxResults(Integer.MAX_VALUE);
		 return query.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public SelectWeightInfo getSelectWeightInfo(Long inquisitionID,	Long partQuestionID, Long selectID) {
		 Criteria query = this.getSession().createCriteria(SelectWeightInfo.class);
		 query.add(Restrictions.eq("inquisitionID", inquisitionID));
		 query.add(Restrictions.eq("partQuestionID", partQuestionID));
		 query.add(Restrictions.eq("selectID",selectID));
		 query.add(Restrictions.eq("status",1));
		 query.setMaxResults(Integer.MAX_VALUE);
		 SelectWeightInfo swi = null;
		 List list = query.list();
		 if(list != null && list.size() > 0 ) {
			 swi = (SelectWeightInfo)list.get(0);
		 }		 
		return swi;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getTotal(Long inquisitionID, Long partID) {
		Criteria query = this.getSession().createCriteria(SelectWeightInfo.class);
		query.setProjection(Projections.rowCount());
		query.add(Restrictions.eq("inquisitionID", inquisitionID));
		query.add(Restrictions.eq("partID", partID));
		query.add(Restrictions.eq("status",1));
		query.setMaxResults(1);
		List list = query.list();		
		int result = 0;
		if(list.size() > 0) {
			Object obj = list.get(0);					
			if(obj != null) {
				result = (Integer)obj;
			}
		}
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getTotal(Long inquisitionID) {
		Criteria query = this.getSession().createCriteria(SelectWeightInfo.class);
		query.setProjection(Projections.rowCount());
		query.add(Restrictions.eq("inquisitionID", inquisitionID));
		query.add(Restrictions.eq("status",1));
		query.setMaxResults(1);
		List list = query.list();		
		int result = 0;
		if(list.size() > 0) {
			Object obj = list.get(0);					
			if(obj != null) {
				result = (Integer)obj;
			}
		}
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getSumWeightByQuestion(Long inquisitionID, Long partQuestionID) {
		Criteria query = this.getSession().createCriteria(SelectWeightInfo.class);
		query.setProjection(Projections.sum("weight"));
		query.add(Restrictions.eq("inquisitionID", inquisitionID));
		query.add(Restrictions.eq("partQuestionID", partQuestionID));
		query.add(Restrictions.eq("status",1));
		query.setMaxResults(1);
		List list = query.list();		
		int result = 0;
		if(list.size() > 0) {
			Object obj = list.get(0);					
			if(obj != null) {
				result = (Integer)obj;
			}
		}
		return result;
	}
}
