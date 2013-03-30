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
import org.xsaas.xstat.dao.IPartRecordInfoDao;
import org.xsaas.xstat.po.PartRecordInfo;


public class PartRecordInfoDao extends HibernateDaoSupport implements IPartRecordInfoDao{

	/**
	 * ɾ���ʾ���Ϣ
	 */
	public void delete(PartRecordInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	/**
	 * ���ݱ�Ż�ȡ��Ϣ�б�
	 */
	public PartRecordInfo getInfo(Long partRecordID) {
		
		return (PartRecordInfo) this.getHibernateTemplate().get(PartRecordInfo.class, partRecordID);
	}
	/**
	 * �����ʾ���Ϣ
	 */
	public void save(PartRecordInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	/**
	 * �����ʾ���Ϣ
	 */
	public void update(PartRecordInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	/**
	 * ��ȡ�б���Ϣ
	 */
	
	@SuppressWarnings("unchecked")
	public List<PartRecordInfo> getList() {
		List<PartRecordInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PartRecordInfo.class);		 
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
	public List<PartRecordInfo> findByPage(final int firstResult,final int maxResult) {
		List<PartRecordInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(PartRecordInfo.class);		 
				 query.addOrder(Order.desc("partRecordID"));
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
		Criteria query = this.getSession().createCriteria(PartRecordInfo.class);
		query.setProjection(Projections.count("partRecordID"));
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
	public List<PartRecordInfo> findByPlan(Long planID) {
		 Criteria query = this.getSession().createCriteria(PartRecordInfo.class);
		 query.add(Restrictions.eq("planID",planID));
		 query.add(Restrictions.gt("selectID",new Long(0)));
		 query.setMaxResults(Integer.MAX_VALUE);
		return query.list();
	}



}
