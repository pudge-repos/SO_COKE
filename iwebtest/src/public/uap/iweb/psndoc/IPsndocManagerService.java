package uap.iweb.psndoc;

/**
 * 文本描述eclipse
 * 
 * @author liulibo
 * 
 */
public interface IPsndocManagerService {
	/**
	 * 保存聚合VO
	 * 
	 * @param psn
	 * @return
	 */
	String save(PsnAggVO psn);

	/**
	 * 查询聚合VO
	 * 
	 * @param pk
	 * @return
	 */
	PsnAggVO query(String pk);
}
