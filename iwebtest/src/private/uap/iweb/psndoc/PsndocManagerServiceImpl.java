package uap.iweb.psndoc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import nc.bs.dao.BaseDAO;
import nc.bs.dao.DAOException;
import nc.bs.logging.Logger;
import nc.vo.bd.psn.PsndocVO;
import nc.vo.bd.psn.PsnjobVO;
import nc.vo.pub.CircularlyAccessibleValueObject;
import nc.vo.pub.SuperVO;

public class PsndocManagerServiceImpl implements IPsndocManagerService {

	@Override
	public String save(PsnAggVO psn) {
		BaseDAO dao = new BaseDAO();
		try {
			String pk_psn = dao.insertVO((SuperVO) psn.getParentVO());
			List<PsnjobVO> jobs = new ArrayList<PsnjobVO>();
			for( CircularlyAccessibleValueObject child  : psn.getChildrenVO()){
				PsnjobVO job = 	(PsnjobVO) child;
				job.setPk_psndoc(pk_psn);
				jobs.add(job);
			}
			
			dao.insertVOArray(jobs.toArray(new PsnjobVO[]{}));
			return pk_psn;
		} catch (DAOException e) {
			Logger.error(e.getMessage(), e);
		}
		
		return null;
	}

	@Override
	public PsnAggVO query(String pk)   {
		BaseDAO dao = new BaseDAO();
		PsndocVO  docs = null;
		try {
			docs =(PsndocVO) dao.retrieveByPK(PsndocVO.class, pk);
		} catch (Exception e) {
			Logger.error(e.getMessage(), e);
		}
		if(docs == null)
			return null;
		PsnAggVO psn = new PsnAggVO ();
		psn.setParentVO(docs );
	
		try {
			Collection jobcoll = dao.retrieveByClause(PsnjobVO.class, "pk_psndoc='" + docs .getPk_psndoc() + "'");
			PsnjobVO[] jobs = (PsnjobVO[]) jobcoll.toArray(new PsnjobVO[]{});
			psn.setChildrenVO(jobs);
		} catch (Exception e) {
			Logger.error(e.getMessage(), e);
		}
		
		return psn;
	}

}
