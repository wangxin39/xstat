package org.xsaas.xstat.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.xsaas.xstat.dao.IOptionTemplateInfoDao;
import org.xsaas.xstat.po.OptionTemplateInfo;


public class OptionTemplateInfoDao extends HibernateDaoSupport implements IOptionTemplateInfoDao {

	@Override
	public void delete(OptionTemplateInfo data) {
		this.getHibernateTemplate().delete(data);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OptionTemplateInfo> getList(int firstResult, int maxResult) {
		Criteria query = this.getSession().createCriteria(OptionTemplateInfo.class);		
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResult);
		return query.list();
	}

	@Override
	public OptionTemplateInfo getOptionTemplateInfo(Long optionTemplateID) {
		return (OptionTemplateInfo)this.getHibernateTemplate().get(OptionTemplateInfo.class, optionTemplateID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getTotal() {
		Criteria query = this.getSession().createCriteria(OptionTemplateInfo.class);
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
	public void save(OptionTemplateInfo data) {
		this.getHibernateTemplate().save(data);
	}

	@Override
	public void update(OptionTemplateInfo data) {
		this.getHibernateTemplate().update(data);
		
	}

}
