package org.xsaas.xstat.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.xsaas.xstat.dao.IGradeStdInfoDao;
import org.xsaas.xstat.po.GradeStdInfo;


public class GradeStdInfoDao extends HibernateDaoSupport implements
		IGradeStdInfoDao {

	@Override
	public void delete(GradeStdInfo data) {
		this.getHibernateTemplate().delete(data);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GradeStdInfo> findByPage(int firstResult, int maxResult) {
		Criteria query = this.getSession().createCriteria(GradeStdInfo.class);		
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResult);
		return query.list();
	}

	@Override
	public GradeStdInfo getGradeStdInfo(Long gradeStdID) {		
		return (GradeStdInfo)this.getHibernateTemplate().get(GradeStdInfo.class, gradeStdID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getTotal() {
		Criteria query = this.getSession().createCriteria(GradeStdInfo.class);		
		query.setProjection(Projections.rowCount());
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
	public void save(GradeStdInfo data) {
		this.getHibernateTemplate().save(data);		
	}

	@Override
	public void update(GradeStdInfo data) {
		this.getHibernateTemplate().update(data);		
	}

}
