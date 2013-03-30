package org.xsaas.xstat.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.xsaas.xstat.dao.IGradeRelationInfoDao;
import org.xsaas.xstat.po.GradeRelationInfo;


public class GradeRelationInfoDao extends HibernateDaoSupport implements
		IGradeRelationInfoDao {

	@Override
	public void delete(GradeRelationInfo data) {
		this.getHibernateTemplate().delete(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GradeRelationInfo> findByPage(int firstResult, int maxResult) {
		Criteria query = this.getSession().createCriteria(GradeRelationInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.addOrder(Order.desc("gradeRelationID"));
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResult);
		return query.list();
	}

	@Override
	public GradeRelationInfo getGradeRelationInfo(Long gradeRelationID) {		
		return (GradeRelationInfo)this.getHibernateTemplate().get(GradeRelationInfo.class, gradeRelationID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getTotal() {
		Criteria query = this.getSession().createCriteria(GradeRelationInfo.class);
		query.setProjection(Projections.rowCount());
		query.add(Restrictions.eq("status", 1));
		int result = 0;
		List list = query.list();
		if(list.size() > 0) {
			Object obj = list.get(0);
			if(obj != null) {
				result = (Integer)obj;
			}
		}
		return result;	
	}

	@Override
	public void save(GradeRelationInfo data) {
		this.getHibernateTemplate().save(data);		
	}

	@Override
	public void update(GradeRelationInfo data) {
		this.getHibernateTemplate().update(data);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public GradeRelationInfo findByIssue(Long issueID, Long informantID) {
		Criteria query = this.getSession().createCriteria(GradeRelationInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.add(Restrictions.eq("issueID",issueID));
		query.add(Restrictions.eq("informantID",informantID));	
		query.addOrder(Order.desc("gradeRelationID"));
		query.setMaxResults(1);
		GradeRelationInfo info = null;
		List list = query.list();
		if(list != null && list.size() > 0) {
			Object obj = list.get(0);
			if(obj != null) {
				info = (GradeRelationInfo)obj;
			}
		}		
		return info;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GradeRelationInfo> findByIssue(Long issueID) {
		Criteria query = this.getSession().createCriteria(GradeRelationInfo.class);
		query.add(Restrictions.eq("issueID",issueID));
		query.add(Restrictions.eq("status", 1));
		query.addOrder(Order.desc("gradeRelationID"));
		query.setMaxResults(Integer.MAX_VALUE);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getTotal(Long issueID, Long informantID) {
		Criteria query = this.getSession().createCriteria(GradeRelationInfo.class);
		query.setProjection(Projections.rowCount());
		query.add(Restrictions.eq("issueID",issueID));
		query.add(Restrictions.eq("informantID",informantID));		
		query.add(Restrictions.eq("status", 1));
		int result = 0;
		List list = query.list();
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
	public int getTotal(Long issueID) {
		Criteria query = this.getSession().createCriteria(GradeRelationInfo.class);
		query.setProjection(Projections.rowCount());
		query.add(Restrictions.eq("issueID",issueID));
		query.add(Restrictions.eq("status", 1));
		int result = 0;
		List list = query.list();
		if(list.size() > 0) {
			Object obj = list.get(0);
			if(obj != null) {
				result = (Integer)obj;
			}
		}
		return result;	
	}

}
