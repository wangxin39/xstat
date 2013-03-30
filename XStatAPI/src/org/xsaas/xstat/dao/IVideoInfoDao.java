package org.xsaas.xstat.dao;

import java.util.List;

import org.xsaas.xstat.po.VideoInfo;



public interface IVideoInfoDao {
	/**
	 * �����ʾ���
	 * @param data �ʾ���
	 */
	public void save(VideoInfo data);
	/**
	 * �����ʾ���
	 * @param data �ʾ���
	 */
	public void update(VideoInfo data);
	/**
	 * ɾ���ʾ���
	 * @param data �ʾ���
	 */
	public void delete(VideoInfo data);	
	/**
	 * ��ȡ�ʾ���
	 * @param qpID �������ͱ��
	 * @return �ʾ���
	 */
	public VideoInfo getVideoInfo(Long qpID);
	/**
	 * ��ȡ�ʾ����б�
	 * @return �ʾ����б�
	 */
	public List<VideoInfo> getVideoInfoList();
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getTotal();
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<VideoInfo> findByPage(final int firstResult, final int maxResult);
	
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getTotal(Long clientID,Long informantID);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<VideoInfo> findByPage(Long clientID,Long informantID, final int firstResult, final int maxResult);
	/**
	 * ��Ϣ����
	 * @return ����
	 */
	public int getTotal(Long clientID);
	/**
	 * ��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<VideoInfo> findByPage(Long clientID, final int firstResult, final int maxResult);	
	/**
	 * ɾ��״̬����
	 * @return int
	 */
	public int getTotalByDelStatus();
	/**
	 * ɾ��״̬��ҳ��Ϣ
	 * @param firstResult ��ʼ��
	 * @param maxResult �����
	 * @return ��Ϣ���
	 */
	public List<VideoInfo> findPageByDelStatus(final int firstResult, final int maxResult);
}
