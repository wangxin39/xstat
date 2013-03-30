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
import org.xsaas.xstat.dao.IVideoInfoDao;
import org.xsaas.xstat.po.VideoInfo;


public class VideoInfoDao extends HibernateDaoSupport implements
		IVideoInfoDao {
	/**
	 * ɾ���ʾ�����Ϣ
	 */
	public void delete(VideoInfo data) {
		this.getHibernateTemplate().delete(data);
	}
	/**
	 * ���ݱ�Ż�ȡ��Ϣ�б�
	 */
	public VideoInfo getVideoInfo(Long markID) {
		
		return (VideoInfo) this.getHibernateTemplate().get(VideoInfo.class, markID);
	}
	/**
	 * �����ʾ�����Ϣ
	 */
	public void save(VideoInfo data) {
		this.getHibernateTemplate().save(data);
		
	}

	/**
	 * �����ʾ�����Ϣ
	 */
	public void update(VideoInfo data) {
		
		this.getHibernateTemplate().update(data);
	}
	/**
	 * ��ȡ�б���Ϣ
	 */
	
	@SuppressWarnings("unchecked")
	public List<VideoInfo> getVideoInfoList() {
		List<VideoInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(VideoInfo.class);
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("videoID"));
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
	 * @return list<VideoInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<VideoInfo> findByPage(final int firstResult,final int maxResult) {
		List<VideoInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(VideoInfo.class);
				 query.add(Restrictions.eq("status", 1));
				 query.addOrder(Order.desc("videoID"));
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
		Criteria query = this.getSession().createCriteria(VideoInfo.class);
		 query.add(Restrictions.eq("status", 1));
		query.setProjection(Projections.count("videoID"));
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
	public List<VideoInfo> findByPage(final Long clientID, final Long informantID,
			final int firstResult,final int maxResult) {
		List<VideoInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(VideoInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("clientID", clientID));
				 query.add(Restrictions.eq("informantID", informantID));	
				 query.addOrder(Order.desc("videoID"));			
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getTotal(Long clientID, Long informantID) {
		Criteria query = this.getSession().createCriteria(VideoInfo.class);
		query.add(Restrictions.eq("status", 1));
		query.add(Restrictions.eq("clientID", clientID));
		query.add(Restrictions.eq("informantID", informantID));	
		query.setProjection(Projections.count("videoID"));		
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
	public List<VideoInfo> findByPage(final Long clientID, final int firstResult, final
			int maxResult) {
		List<VideoInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(VideoInfo.class);	
				 query.add(Restrictions.eq("status", 1));
				 query.add(Restrictions.eq("clientID", clientID));
				 query.addOrder(Order.desc("videoID"));			
				 query.setFirstResult(firstResult);
				 query.setMaxResults(maxResult);			 
				 return query.list();
			 }
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getTotal(Long clientID) {
		Criteria query = this.getSession().createCriteria(VideoInfo.class);
		 query.add(Restrictions.eq("status", 1));
		 query.add(Restrictions.eq("clientID", clientID));
		 query.setProjection(Projections.count("videoID"));	
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
	public List<VideoInfo> findPageByDelStatus(final int firstResult,final int maxResult) {
		List<VideoInfo> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			 public Object doInHibernate(Session s) throws HibernateException, SQLException {				
				 Criteria query = s.createCriteria(VideoInfo.class);
				 query.add(Restrictions.eq("status", 2));
				 query.addOrder(Order.desc("videoID"));
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
		Criteria query = this.getSession().createCriteria(VideoInfo.class);
		query.add(Restrictions.eq("status", 2));
		query.setProjection(Projections.count("videoID"));
		query.setMaxResults(1);
		List list = query.list();
		int result = 0;
		if(list.size() > 0) {
			result = (Integer)list.get(0);
		}		
		return result;
	}

}
