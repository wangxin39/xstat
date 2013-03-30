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
import org.xsaas.xstat.dao.IPartQuestionInfoDao;
import org.xsaas.xstat.po.PartQuestionInfo;


public class PartQuestionInfoDao extends HibernateDaoSupport implements	IPartQuestionInfoDao {
	/**
	 * 删除问卷部分信息
	 */
	public void delete(PartQuestionInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	/**
	 * 根据编号获取信息列表
	 */
	public PartQuestionInfo getPartQuestionInfo(Long partQuestionID) {
		
		return (PartQuestionInfo) this.getHibernateTemplate().get(PartQuestionInfo.class, partQuestionID);
	}

	/**
	 * 保存问卷部分信息
	 */
	public void save(PartQuestionInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	/**
	 * 更新问卷部分信息
	 */
	public void update(PartQuestionInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	/**
	 * 获取列表信息
	 */
	
	@SuppressWarnings("unchecked")
	public List<PartQuestionInfo> getPartQuestionInfoList() {
		List<PartQuestionInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PartQuestionInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("fatherPqID",  new Long(0)));
				 query.setMaxResults(Integer.MAX_VALUE);
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PartQuestionInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<PartQuestionInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PartQuestionInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("partQuestionID"));
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
		Criteria query = this.getSession().createCriteria(PartQuestionInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("partQuestionID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}
	/**
	 * 通过指定的起始数和结束数得到一个集合
	 * @param firstResult
	 * @param maxResult
	 * @return list<PartQuestionInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<PartQuestionInfo> findByPage(final Long questionID,final Long inquisitionID, final Long partID, final int firstResult,final int maxResult) {
		List<PartQuestionInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PartQuestionInfo.class);		
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("inquisitionID", inquisitionID));
				 query.add(Restrictions.eq("partID", partID));
				 query.add(Restrictions.eq("questionID", questionID));
				 query.addOrder(Order.desc("partQuestionID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	/**
	 * 通过指定的起始数获取总集合
	 * @return 集合总数
	 */
	@SuppressWarnings("unchecked")
	public int getTotal(Long partID, Long questionID, Long inquisitionID) {
		Criteria query = this.getSession().createCriteria(PartQuestionInfo.class);
		 query.add(Restrictions.eq("status", 1));
	    query.add(Restrictions.eq("inquisitionID", inquisitionID));
		query.add(Restrictions.eq("questionID", questionID));
		query.setProjection(Projections.count("partQuestionID"));
	
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
	public List<PartQuestionInfo> getPartQuestionInfoList(final Long partID,final Long questionID,final Long inquisitionID) {
		List<PartQuestionInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PartQuestionInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("inquisitionID", inquisitionID));
				 query.add(Restrictions.eq("partID", partID));
				 query.add(Restrictions.eq("questionID", questionID));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PartQuestionInfo> getPartQuestionInfoList(Long inquisitionID, Long partID) {
		 Criteria query = this.getSession().createCriteria(PartQuestionInfo.class);	
		 query.add(Restrictions.eq("status", 1));
		 query.add(Restrictions.eq("inquisitionID", inquisitionID));
		 query.add(Restrictions.eq("partID", partID));
		 query.add(Restrictions.eq("fatherPqID",  new Long(0)));
		 query.setMaxResults(Integer.MAX_VALUE);			 
		return query.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getQuestionTotal(Long inquisitionID) {
		Criteria query = this.getSession().createCriteria(PartQuestionInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.add(Restrictions.eq("inquisitionID", inquisitionID));
		query.add(Restrictions.eq("fatherPqID", new Long(0)));
		query.setProjection(Projections.count("partQuestionID"));
	
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
	public List<PartQuestionInfo> getFatherPqInfo(Long fatherPqID) {
		Criteria query = this.getSession().createCriteria(PartQuestionInfo.class);	
		query.add(Restrictions.eq("fatherPqID", fatherPqID));
		query.addOrder(Order.asc("showNum"));
		query.setMaxResults(Integer.MAX_VALUE); 
		return query.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PartQuestionInfo> findPartQuestionInfoByPage(final Long inquisitionID,final Long partID,final int firstResult,final int maxResult) {
		List<PartQuestionInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PartQuestionInfo.class);		
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("inquisitionID", inquisitionID));
				 query.add(Restrictions.eq("partID", partID));
				 query.addOrder(Order.desc("partQuestionID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getPartQuestionInfoTotal(Long partID, Long inquisitionID) {
		Criteria query = this.getSession().createCriteria(PartQuestionInfo.class);
		 query.add(Restrictions.eq("status", 1));
	    query.add(Restrictions.eq("inquisitionID", inquisitionID));
	    query.add(Restrictions.eq("partID", partID));
		query.setProjection(Projections.count("partQuestionID"));
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
	public List<PartQuestionInfo> findPartQuestionInfoByPage(final Long partID,final int firstResult,final int maxResult) {
		List<PartQuestionInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PartQuestionInfo.class);		 
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("partID", partID));
				 query.addOrder(Order.desc("partQuestionID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getPartQuestionTotal(Long partID) {
		Criteria query = this.getSession().createCriteria(PartQuestionInfo.class);
		 query.add(Restrictions.eq("status", 1));
	    query.add(Restrictions.eq("partID", partID));
		query.setProjection(Projections.count("partQuestionID"));
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
	public List<PartQuestionInfo> getList(final Long partID) {
		List<PartQuestionInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PartQuestionInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("partID", partID));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PartQuestionInfo> findByPage(final int firstResult, final int maxResult) {
		List<PartQuestionInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PartQuestionInfo.class);		 
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("partQuestionID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getTotal() {
		Criteria query = this.getSession().createCriteria(PartQuestionInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("partQuestionID"));	
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
	public int getLastShowNum(Long inquisitionID) {
		Criteria query = this.getSession().createCriteria(PartQuestionInfo.class);
		query.setProjection(Projections.property("showNum"));	
		query.add(Restrictions.eq("inquisitionID", inquisitionID));
		query.add(Restrictions.eq("status", 1));
		query.addOrder(Order.desc("showNum"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 1;
		if(list.size() > 0) {
			Object obj = list.get(0);
			if(obj != null) {
				result = (Integer)obj;
				result = result+1; // 递增
			}
		}	
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PartQuestionInfo> findByFather(Long partQuestionID) {
		Criteria query = this.getSession().createCriteria(PartQuestionInfo.class);	
		query.add(Restrictions.eq("fatherPqID", partQuestionID));
		query.add(Restrictions.eq("status", 1));
		query.setMaxResults(Integer.MAX_VALUE); 
		return query.list();
	}

}
