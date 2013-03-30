package org.xsaas.xstat.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Criterion;

import org.xsaas.xstat.utils.page.Page;
import org.xsaas.xstat.utils.page.Results;

public interface IBaseDao<T> {
	
	/**
	 * ����
	 * @param data �����Ķ���
	 * @throws Exception �쳣��Ϣ
	 */
	public void save(T data) throws DaoException;
	/**
	 * ͨ��ָ���ı�Ż�ȡ����
	 * @param id ���
	 * @return ����
	 * @throws Exception �쳣��Ϣ
	 */
	public T get(long id) throws DaoException;
	/**
	 * ͨ��ָ���ı�Ż�ȡ����
	 * @param id ���
	 * @return ����
	 * @throws Exception �쳣��Ϣ
	 */
	public T get(int id) throws DaoException;

	/**
	 * ���²����Ķ�����Ϣ
	 * @param data ��������
	 * @throws Exception �׳����쳣
	 */
	public void update(T data) throws DaoException;
	/**
	 * ɾ�������Ķ�����Ϣ
	 * @param data ��������
	 * @throws Exception �׳����쳣
	 */
	public void delete(T data) throws DaoException;
	/**
	 * ����ָ����������������Ӧ�����Ķ����б�
	 * @param firstResult ��ʼ��¼
	 * @param maxResult ��෵�صļ�¼��
	 * @return ��¼����
	 * @throws Exception �׳����쳣
	 */
	public List<T> getList(final int firstResult,final int maxResult) throws DaoException;
	/**
	 * ��ȡ�ܼ�¼����
	 * @return �ܼ�¼��
	 */
	public int getTotal() throws DaoException;
	/***
	 * ��ѯ�б�,ʹ��ԭʼSQL���
	 * @param sql
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List excuteForSQLList(String sql,Page page) throws DaoException;
	/***
	 * ��ѯ�б�,ʹ��ԭʼSQL���
	 * @param sql
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List excuteForSQLList(String sql) throws DaoException;
	/***
	 * ��ѯ�б�,ʹ��hibernate SQL���
	 * @param sql
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List excuteForList(String sql,Page page) throws DaoException;
	/***
	 * ��ѯ�б�,ʹ��ԭʼSQL���
	 * @param sel_sql ��ѯSQL
	 * @param count_sql ͳ��SQL
	 * @param currentPage ��ǰҳ
	 * @param maxResult ���ҳ
	 * @return ����ʵ���б�
	 */
	public Results excuteForSQLEntityList(String sel_sql,String count_sql,int currentPage,int maxResult) throws DaoException;
	
	/***
	 * ��ѯ�б�,ʹ��ԭʼSQL���
	 * @param sql
	 * @param page
	 * @return ����ʵ���б�
	 */
	public List excuteForSQLEntityList(String sel_sql) throws DaoException;
	
	/**
	 * ��ѯ����ʹ��ԭʼSQL���
	 * @param sql
	 * @return ʵ�����
	 * @throws DaoException
	 */
	public T findSQLEntity(String sql) throws DaoException;
	/***
	 * ͨ��ԭʼSQL�������ѯ��������
	 * @param sql
	 * @return
	 */
	public int excuteForSQLCount(String sql) throws DaoException;
	/***
	 * ���ַ�ʽ������ԭʼSQL�������ȡ��Ϣ����������SQL����д���GROUP BY �ȣ�
	 * ��ֻ��ͨ���Ȳ�ѯ��Ȼ��ͨ��LIST����ȡ��������
	 * ����Ч�ʼ��ͣ��ҵ��÷���Ҫ����
	 * @param sql
	 * @return
	 */
	public int excuteForSQLCountFromList(String sql) throws DaoException;
	/****
	 * ֱ��ͨ��HQL����ȡ��������
	 * @param sql
	 * @return
	 */
	public int excuteForCount(String sql) throws DaoException;
	/***
	 * ������Ϣ
	 * @param obj
	 * @return
	 */
	public boolean saveForObject(Object obj) throws DaoException;
	/***
	 * ִ��SQL���
	 * @param obj
	 * @return
	 */
	public boolean excuteForSQLObject(String sql) throws DaoException;
	/***
	 * ��ѯ,ʹ��ԭʼSQL���
	 * @param sql
	 * @return
	 */
	public Object[] excuteForSQLUnique(String sql) throws DaoException;
	/***
	 * ��ѯ,ʹ��SQL���
	 * @param sql
	 * @param page
	 * @return
	 */
	public Object[] excuteForUnique(String sql) throws DaoException;

	/******
	 * sql��ѯ��ʹ��Spring������ǰ����
	 * @param sql
	 * @return
	 */
	public SQLQuery creatSQLQuery(String sql) throws DaoException;

	/*****
	 * ��ҳ���ϲ�ѯ
	 * @param page
	 * @param count_sql 
	 * @param sel_sql
	 * @return
	 */
	public Results Select_By_List(Page page,String count_sql,String sel_sql) throws DaoException;
	/****
	 * ��ѯ���
	 * @param page
	 * @param count_sql
	 * @param sel_sql
	 * @return
	 */
	public Results Select_ByHQL_List(Page page,String count_sql,String sel_sql) throws DaoException;

	/*****
	 * ת��Ϊ��������
	 * @param obj
	 * @param type
	 * @return
	 */	
	public Date checkForDate(Object obj,String type) throws DaoException;

	/****
	 * ��ѯ���������ؼ��� ������   2009-03-05  //by niyong
	 * @param page
	 * @param count_sql ��ѯ��ҳ����
	 * @param sel_sql   ��ѯ���
	 * @param obj       ���� 
	 * @param type      ��ѯ���ͣ�1:ԭʼSQL��ѯ��0��HQL��ѯ
	 * @return
	 */
	public Results SearchQuery(Page page,String count_sql,String sel_sql,Object[] obj,int type) throws DaoException;

	/******
	 * ��ѯ��ҳ����,   2009-03-05  //by niyong
	 * @param sql
	 * @param obj
	 * @param type 1:ԭʼSQL��ѯ��0��hql��ѯ
	 * @return
	 */	
	public int getTotalRecords(String sql,Object[] obj,int type) throws DaoException;
	/****
	 * ��ҳ��ѯ   2009-03-05  //by niyong
	 * @param sql
	 * @param obj
	 * @param beginIndex
	 * @param everyPage
	 * @param type 1:ԭʼSQL��ѯ��0��hql��ѯ
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List getResultList(String sql,Object[] obj,Page page,int type) throws DaoException;
	/**
	 * ��HQL��ѯΨһ����.
	 */
	public Object findUnique(final String hql, final Object... values) throws DaoException;

	/**
	 * ��HQL��ѯInteger���ͽ��. 
	 */
	public Integer findInt(final String hql, final Object... values) throws DaoException;

	/**
	 * ��HQL��ѯLong���ͽ��. 
	 */
	public Long findLong(final String hql, final Object... values) throws DaoException;
	/**
	* ��Criterion��ѯ�����б�.
	* 
	* @param criterion �����ɱ��Criterion.
	*/
	public List<T> findByCriteria(final Criterion... criterion) throws DaoException;	
	
	
	public Results findBySqlForMap(String sel_sql,int currentPage,int maxResult) throws DaoException;	
	
	@SuppressWarnings("unchecked")
	public List<Map> findBySqlForMap(String sel_sql) throws DaoException;	
		

	/**
	* ���ݲ�ѯHQL������б���Query����,��������.
	*/
	public Query createQuery(final String queryString, final Object... values) throws DaoException;
	/**
	 * ����Criterion��������Criteria,��������.
	 */
	public Criteria createCriteria(final Criterion... criterions) throws DaoException;		
	
}