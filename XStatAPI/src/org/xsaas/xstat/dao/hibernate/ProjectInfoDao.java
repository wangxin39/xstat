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
import org.xsaas.xstat.dao.IProjectInfoDao;
import org.xsaas.xstat.po.ProjectInfo;



public class ProjectInfoDao extends HibernateDaoSupport implements IProjectInfoDao {

	@Override
	public void deleteProjectInfo(ProjectInfo data) {
		
		this.getHibernateTemplate().delete(data);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ProjectInfo> findProjectInfoByPage(final int firstResult,final int maxResult) {
		List<ProjectInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ProjectInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("projectID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ProjectInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<ProjectInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ProjectInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("projectID"));
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
		Criteria query = this.getSession().createCriteria(ProjectInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("projectID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
	@Override
	public ProjectInfo getProjectInfo(Long projectID) {		
		return (ProjectInfo) this.getHibernateTemplate().get(ProjectInfo.class,projectID);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ProjectInfo> getProjectInfoList() {
		List<ProjectInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ProjectInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("projectID"));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public int getProjectInfoTotal() {
		Criteria query = this.getSession().createCriteria(ProjectInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("projectID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}

	@Override
	public void saveProjectInfo(ProjectInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	@Override
	public void updateProjectInfo(ProjectInfo data) {
		
		this.getHibernateTemplate().update(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProjectInfo> findProjectInfoByPage(final long clientID,final  int status,final int firstResult,final  int maxResult) {
		List<ProjectInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ProjectInfo.class);	
				 query.add(Restrictions.eq("status", status));
				 query.add(Restrictions.eq("clientID", clientID));
				 query.addOrder(Order.desc("projectID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}

	@Override
	public ProjectInfo getProjectInfoClient(final long clientID) {
		return (ProjectInfo) this.getHibernateTemplate().get(ProjectInfo.class,clientID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getProjectInfoTotal(final long clientID,final  int status) {
		Criteria query = this.getSession().createCriteria(ProjectInfo.class);
		query.add(Restrictions.eq("status", status));
		 query.add(Restrictions.eq("clientID", clientID));
		query.setProjection(Projections.count("projectID"));
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
	public List<ProjectInfo> getProjectInfoList(final Long clientID) {
		List<ProjectInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ProjectInfo.class);	
				 query.add(Restrictions.eq("clientID", clientID));
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("projectID"));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}

}
