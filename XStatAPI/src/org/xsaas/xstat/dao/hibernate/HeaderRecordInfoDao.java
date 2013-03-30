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
	 * ɾ���ʾ���Ϣ
	 */
	public void delete(HeaderRecordInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	/**
	 * ���ݱ�Ż�ȡ��Ϣ�б�
	 */
	public HeaderRecordInfo getInfo(Long headerRecordID) {
		
		return (HeaderRecordInfo) this.getHibernateTemplate().get(HeaderRecordInfo.class, headerRecordID);
	}
	/**
	 * �����ʾ���Ϣ
	 */
	public void save(HeaderRecordInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	/**
	 * �����ʾ���Ϣ
	 */
	public void update(HeaderRecordInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	/**
	 * ��ȡ�б���Ϣ
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
	 * ͨ��ָ������ʼ���ͽ������õ�һ������
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
	 * ͨ��ָ������ʼ����ȡ�ܼ���
	 * @return \��������
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
