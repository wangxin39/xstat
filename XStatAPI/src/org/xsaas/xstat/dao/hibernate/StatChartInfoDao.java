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
import org.xsaas.xstat.dao.IStatChartInfoDao;
import org.xsaas.xstat.po.StatChartInfo;


public class StatChartInfoDao extends HibernateDaoSupport implements
		IStatChartInfoDao {
	/**
	 * ɾ���ʾ�����Ϣ
	 */
	public void delete(StatChartInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	/**
	 * ���ݱ�Ż�ȡ��Ϣ�б�
	 */
	public StatChartInfo getStatChartInfo(Long chartID) {
		
		return (StatChartInfo) this.getHibernateTemplate().get(StatChartInfo.class, chartID);
	}
	/**
	 * �����ʾ�����Ϣ
	 */
	public void save(StatChartInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	/**
	 * �����ʾ�����Ϣ
	 */
	public void update(StatChartInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	/**
	 * ��ȡ�б���Ϣ
	 */
	
	@SuppressWarnings("unchecked")
	public List<StatChartInfo> getStatChartInfoList() {
		List<StatChartInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(StatChartInfo.class);		 
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
	 * @return list<StatChartInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<StatChartInfo> findByPage(final int firstResult,final int maxResult) {
		List<StatChartInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(StatChartInfo.class);		 
				 query.addOrder(Order.desc("chartID"));
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	/**
	 * ͨ��ָ������ʼ����ȡ�ܼ���
	 * @return ��������
	 */
	@SuppressWarnings("unchecked")
	public int getTotal() {
		Criteria query = this.getSession().createCriteria(StatChartInfo.class);
		query.setProjection(Projections.count("chartID"));
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
	
}
