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
import org.xsaas.xstat.dao.IPartSelectInfoDao;
import org.xsaas.xstat.po.PartSelectInfo;


public class PartSelectInfoDao extends HibernateDaoSupport implements
		IPartSelectInfoDao {

	/**
	 * 删除问卷部分选项信息
	 */
	public void delete(PartSelectInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	/**
	 * 根据编号获取信息列表
	 */
	public PartSelectInfo getPartSelectInfo(Long PartSelectID) {
		
		return (PartSelectInfo) this.getHibernateTemplate().get(PartSelectInfo.class, PartSelectID);
	}
	/**
	 * 保存问卷部分选项信息
	 */
	public void save(PartSelectInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	/**
	 * 更新问卷部分选项信息
	 */
	public void update(PartSelectInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	/**
	 * 获取列表信息
	 */
	
	@SuppressWarnings("unchecked")
	public List<PartSelectInfo> getPartSelectInfoList() {
		List<PartSelectInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PartSelectInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.setMaxResults(Integer.MAX_VALUE);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PartSelectInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<PartSelectInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PartSelectInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("partSelectID"));
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
		Criteria query = this.getSession().createCriteria(PartSelectInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("partSelectID"));
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
	 * @return list<PartSelectInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<PartSelectInfo> findByPage(final long partQuestionID,final int firstResult,final int maxResult) {
		List<PartSelectInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PartSelectInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("partQuestionID", partQuestionID));
				 query.addOrder(Order.desc("partSelectID"));
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
	public int getTotal(long partQuestionID) {
		Criteria query = this.getSession().createCriteria(PartSelectInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.add(Restrictions.eq("partQuestionID", partQuestionID));
		query.setProjection(Projections.count("partSelectID"));
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
	public List<PartSelectInfo> findByQuestion(Long inquisitionID, Long partQuestionID) {		
		Criteria query = this.getSession().createCriteria(PartSelectInfo.class);
		query.add(Restrictions.eq("inquisitionID", inquisitionID));
		query.add(Restrictions.eq("partQuestionID", partQuestionID));
		query.setMaxResults(Integer.MAX_VALUE);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PartSelectInfo> findByQuestion(Long partQuestionID) {		
		Criteria query = this.getSession().createCriteria(PartSelectInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.add(Restrictions.eq("partQuestionID", partQuestionID));
		query.setMaxResults(Integer.MAX_VALUE);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PartSelectInfo> findPartSelectInfoByPage(final int firstResult,final int maxResult) {
		List<PartSelectInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PartSelectInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("partSelectID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getPartSelectInfoTotal() {
		Criteria query = this.getSession().createCriteria(PartSelectInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("partSelectID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}

}
