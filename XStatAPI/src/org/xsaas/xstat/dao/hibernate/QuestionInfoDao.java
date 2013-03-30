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
import org.xsaas.xstat.dao.IQuestionInfoDao;
import org.xsaas.xstat.po.QuestionInfo;


public class QuestionInfoDao extends HibernateDaoSupport implements IQuestionInfoDao {

	/**
	 * 删除问卷信息
	 */
	public void delete(QuestionInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	/**
	 * 根据编号获取信息列表
	 */
	public QuestionInfo getQuestionInfo(Long questionID) {
		
		return (QuestionInfo) this.getHibernateTemplate().get(QuestionInfo.class, questionID);
	}
	/**
	 * 保存问卷信息
	 */
	public void save(QuestionInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	/**
	 * 更新问卷信息
	 */
	public void update(QuestionInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	/**
	 * 获取列表信息
	 */
	
	@SuppressWarnings("unchecked")
	public List<QuestionInfo> getQuestionInfoList() {
		List<QuestionInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(QuestionInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("questionID"));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}
	/**
	 * 通过指定的起始数和结束数得到一个集合
	 * @param firstResult
	 * @param maxResult
	 * @return list<QuestionInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<QuestionInfo> findByPage(final int questionType,final String keyword, final int firstResult,final int maxResult) {
		List<QuestionInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(QuestionInfo.class);		
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("questionType",questionType));
				 query.add(Restrictions.or(Restrictions.like("question", "%"+keyword+"%"), Restrictions.like("zhExplain", "%"+keyword+"%")));
				 query.addOrder(Order.desc("questionID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<QuestionInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<QuestionInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(QuestionInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("questionID"));
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
		Criteria query = this.getSession().createCriteria(QuestionInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("questionID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
	/**
	 * 获取指定问题类型的问题列表
	 * @param questionType
	 * @param firstResult
	 * @param maxResult
	 * @return List<QuestionInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<QuestionInfo> findByPage(final int questionType, final int firstResult,final int maxResult) {
		List<QuestionInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(QuestionInfo.class);		
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("questionType",questionType));
				 query.addOrder(Order.desc("questionID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}	
	@SuppressWarnings("unchecked")
	public List<QuestionInfo> findByPage(final int firstResult,final int maxResult) {
		List<QuestionInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(QuestionInfo.class);		
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("questionID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	/**
	 * 通过指定的起始数获取总集合
	 * @return 总数
	 */
	@SuppressWarnings("unchecked")
	public int getTotal() {
		Criteria query = this.getSession().createCriteria(QuestionInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("questionID"));
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
	public int getTotal(int questionType, String keyword) {
		Criteria query = this.getSession().createCriteria(QuestionInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("questionID"));
		query.add(Restrictions.eq("questionType",questionType));
		query.add(Restrictions.or(Restrictions.like("question", "%"+keyword+"%"), Restrictions.like("zhExplain", "%"+keyword+"%")));
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
	public int getTotal(int questionType) {
		Criteria query = this.getSession().createCriteria(QuestionInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("questionID"));
		query.add(Restrictions.eq("questionType", questionType));
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
	public List<QuestionInfo> findByPage(final String keyword, final int firstResult,final int maxResult) {
		List<QuestionInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(QuestionInfo.class);		
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.or(Restrictions.like("question", "%"+keyword+"%"), Restrictions.like("zhExplain", "%"+keyword+"%")));
				 query.addOrder(Order.desc("questionID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getTotal(String keyword) {
		Criteria query = this.getSession().createCriteria(QuestionInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("questionID"));
		query.add(Restrictions.or(Restrictions.like("question", "%"+keyword+"%"), Restrictions.like("zhExplain", "%"+keyword+"%")));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
}
