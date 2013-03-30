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
import org.xsaas.xstat.dao.IArticleInfoDao;
import org.xsaas.xstat.po.ArticleInfo;


public class ArticleInfoDao extends HibernateDaoSupport implements
		IArticleInfoDao {

	@Override
	public void deleteArticleInfo(ArticleInfo data) {
		
		this.getHibernateTemplate().delete(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ArticleInfo> findArticleInfoByPage(final String keyword,final int firstResult,final
			int maxResult) {
		List<ArticleInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ArticleInfo.class);	
				 query.add(Restrictions.like("title", "%"+keyword+"%"));
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("articleID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ArticleInfo> findArticleInfoByPage(final int firstResult,final
			int maxResult) {
		List<ArticleInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ArticleInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("articleID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}

	@Override
	public ArticleInfo getArticleInfo(Long articleID) {
		
		return (ArticleInfo) this.getHibernateTemplate().get(ArticleInfo.class, articleID);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ArticleInfo> getArticleInfoList() {
		List<ArticleInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ArticleInfo.class);		
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("articleID"));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public int getArticleInfoTotal(String keyword) {
		Criteria query = this.getSession().createCriteria(ArticleInfo.class);
		query.add(Restrictions.like("title", "%"+keyword+"%"));
		query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("articleID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}

	@Override
	public void saveArticleInfo(ArticleInfo data) {
		
		this.getHibernateTemplate().save(data);
	}

	@Override
	public void updateArticleInfo(ArticleInfo data) {
		
		this.getHibernateTemplate().update(data);
	}

	@Override
	@SuppressWarnings("unchecked")
	public int getArticleInfoTotal() {
		Criteria query = this.getSession().createCriteria(ArticleInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("articleID"));
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
	public List<ArticleInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<ArticleInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(ArticleInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("articleID"));
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
		Criteria query = this.getSession().createCriteria(ArticleInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("articleID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
}
