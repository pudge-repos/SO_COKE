package uap.iweb.psndoc;

/**
 * �ĵ���дMyEclipse
 * 
 * @author liulibo
 * 
 */
public interface IPsndocManagerService {
	/**
	 * ����ۺ�VO
	 * 
	 * @param psn
	 * @return
	 */
	String save(PsnAggVO psn);

	/**
	 * ��ѯ�ۺ�VO
	 * 
	 * @param pk
	 * @return
	 */
	PsnAggVO query(String pk);
}
