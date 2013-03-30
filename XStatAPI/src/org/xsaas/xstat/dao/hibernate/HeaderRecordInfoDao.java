package org.xsaas.xstat.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.xsaas.xstat.dao.IHeaderRecordInfoDao;
import org.xsaas.xstat.po.HeaderRecordInfo;


public class HeaderRecordInfoDao extends HibernateDaoSupport implements	IHeaderRecordInfoDao{

	/**
	 * 删除问卷信息
	 */
	public void delete(HeaderRecordInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	/**
	 * 根据编号获取信息列表
	 */
	public HeaderRecordInfo getInfo(Long headerRecordID) {
		
		return (HeaderRecordInfo) this.getHibernateTemplate().get(HeaderRecordInfo.class, headerRecordID);
	}
	/**
	 * 保存问卷信息
	 */
	public void save(HeaderRecordInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	/**
	 * 更新问卷信息
	 */
	public void update(HeaderRecordInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	/**
	 * 获取列表信息
	 */
	
	@SuppressWarnings("unchecked")
	public List<HeaderRecordInfo> getList() {
		List<HeaderRecordInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(HeaderRecordInfo.class);	
				 query.addOrder(Order.desc("headerRecordID"));
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
	 * @return list<InquisitionRecordInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<HeaderRecordInfo> findByPage(final int firstResult,final int maxResult) {
		List<HeaderRecordInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(HeaderRecordInfo.class);		 
				 query.addOrder(Order.desc("headerRecordID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	/**
	 * 通过指定的起始数获取总集合
	 * @return \集合总数
	 */
	@SuppressWarnings("unchecked")
	public int getTotal() {
		Criteria query = this.getSession().createCriteria(HeaderRecordInfo.class);
		query.setProjection(Projections.count("headerRecordID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}



}
