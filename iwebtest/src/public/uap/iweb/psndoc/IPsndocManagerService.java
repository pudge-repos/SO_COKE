package uap.iweb.psndoc;

/**
 * 阿斯顿发生的eclipse
 * 文本描述eclipse
 * 描述备注MyEclipse
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
