package org.xsaas.xstat.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.xsaas.xstat.dao.IOptionRelationInfoDao;
import org.xsaas.xstat.po.OptionRelationInfo;


public class OptionRelationInfoDao extends HibernateDaoSupport implements IOptionRelationInfoDao {

	@Override
	public void delete(OptionRelationInfo data) {
		this.getHibernateTemplate().delete(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OptionRelationInfo> getList(int firstResult, int maxResult) {
		Criteria query = this.getSession().createCriteria(OptionRelationInfo.class);
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResult);
		return query.list();
	}

	@Override
	public OptionRelationInfo getOptionRelationInfo(Long optionRelationID) {		
		return (OptionRelationInfo)this.getHibernateTemplate().get(OptionRelationInfo.class, optionRelationID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getTotal() {
		Criteria query = this.getSession().createCriteria(OptionRelationInfo.class);
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
	public void save(OptionRelationInfo data) {
		this.getHibernateTemplate().save(data);		
	}

	@Override
	public void update(OptionRelationInfo data) {
		this.getHibernateTemplate().update(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OptionRelationInfo> getList(Long optionTemplateID) {
		Criteria query = this.getSession().createCriteria(OptionRelationInfo.class);
		query.add(Restrictions.eq("optionTemplateID", optionTemplateID));
		query.setFirstResult(0);
		query.setMaxResults(Integer.MAX_VALUE);
		return query.list();
	}

}
