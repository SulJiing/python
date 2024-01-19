package kr.or.ddit.buyer.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.buyer.dao.BuyerDAO;
import kr.or.ddit.common.exception.PKNotFoundException;
import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.BuyerVO;

@Service
public class BuyerServiceImpl implements BuyerService {
	
	@Inject
	BuyerDAO dao;

	@Override
	public BuyerVO retrieveBuyer(String buyerId) {
		BuyerVO buyer = dao.selectBuyer(buyerId);
		if(buyer == null) {
			throw new PKNotFoundException(buyerId+"제조사가 존재하지 않음");
		}
		return buyer;
	}

	@Override
	public List<BuyerVO> retrieveBuyerList(PaginationInfo paging) {
		int totalRecord = dao.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecord);
		return dao.selectBuyerList(paging);
	}

	@Override
	public ServiceResult createBuyer(BuyerVO buyer) {
		ServiceResult result = null;
		result = dao.insertBuyer(buyer) > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		return result;
	}

	@Override
	public ServiceResult modifyBuyer(BuyerVO buyer) {
		ServiceResult result = null;
		result = dao.updateBuyer(buyer) > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		return result;
	}
}
