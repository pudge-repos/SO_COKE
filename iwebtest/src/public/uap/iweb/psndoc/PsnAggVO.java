package uap.iweb.psndoc;

import nc.vo.bd.psn.PsndocVO;
import nc.vo.bd.psn.PsnjobVO;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.pub.CircularlyAccessibleValueObject;

/**
 * 
 * @author liulibo
 * 
 */
public class PsnAggVO extends AggregatedValueObject {
	private static final long serialVersionUID = 7920296400960258226L;
	PsndocVO head;
	PsnjobVO[] jobs;

	@Override
	public CircularlyAccessibleValueObject[] getChildrenVO() {
		return jobs;
	}

	@Override
	public CircularlyAccessibleValueObject getParentVO() {
		return head;
	}

	@Override
	public void setChildrenVO(CircularlyAccessibleValueObject[] arg0) {
		this.jobs = (PsnjobVO[]) arg0;
	}

	@Override
	public void setParentVO(CircularlyAccessibleValueObject arg0) {
		this.head = (PsndocVO) arg0;
	}

}
