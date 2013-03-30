package org.xsaas.xstat.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.xsaas.xstat.dao.IGradeStdRelationInfoDao;
import org.xsaas.xstat.po.GradeStdRelationInfo;


public class GradeStdRelationInfoDao extends HibernateDaoSupport implements
		IGradeStdRelationInfoDao {

	@Override
	public void delete(GradeStdRelationInfo data) {
		this.getHibernateTemplate().delete(data);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GradeStdRelationInfo> findByPage(int firstResult, int maxResult) {
		Criteria query = this.getSession().createCriteria(GradeStdRelationInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResult);
		return query.list();
	}

	@Override
	public GradeStdRelationInfo getGradeStdRelationInfo(Long stdRelationID) {	
		return (GradeStdRelationInfo)this.getHibernateTemplate().get(GradeStdRelationInfo.class, stdRelationID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getTotal() {
		Criteria query = this.getSession().createCriteria(GradeStdRelationInfo.class);
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
	public void save(GradeStdRelationInfo data) {
		this.getHibernateTemplate().save(data);	
	}

	@Override
	public void update(GradeStdRelationInfo data) {
		this.getHibernateTemplate().update(data);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GradeStdRelationInfo> findByGradeStd(Long gradeStdID) {
		Criteria query = this.getSession().createCriteria(GradeStdRelationInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.add(Restrictions.eq("gradeStdID", gradeStdID));
		query.setMaxResults(Integer.MAX_VALUE);
		return query.list();
	}

}
