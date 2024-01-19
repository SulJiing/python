package kr.or.ddit.prod.service;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.common.exception.PKNotFoundException;
import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.prod.dao.ProdDAO;
import kr.or.ddit.vo.ProdVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 꼭 받아야하는 파라미터를 넣어주는 생성자 어노테이션
public class ProdServiceImpl implements ProdService {
	
	private final ProdDAO dao;
	
	@Value("#{appInfo.prodPath}")
	private Resource prodFolder;
	
	/**
		상품 등록이나 수정시 업로드된 상품 이미지 2진 데이터 저장
	 */
	private void processProdImage(ProdVO prod) {
		MultipartFile prodImage = prod.getProdImage();
		if(prodImage==null) return; // 이미지없음 리턴
		
		try {
			Resource imageFile = prodFolder.createRelative(prod.getProdImg());
			
			prodImage.transferTo(imageFile.getFile());
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	@Override
	public ServiceResult createProd(ProdVO prod) {
		processProdImage(prod);
		return dao.insertProd(prod) > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	@Override
	public List<ProdVO> retrieveProdList(PaginationInfo paging) {
		int totalRecord = dao.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecord);
		return dao.selectProdList(paging);
	}

	@Override
	public ProdVO retrieveProd(String prodId) {
		ProdVO prod = dao.selectProd(prodId);
		 if (prod == null) {
		        throw new PKNotFoundException(String.format("%s 에 해당하는 상품 없음"));
		 	}
		return prod;
	}

	@Override
	public ServiceResult modifyProd(ProdVO prod) {
		processProdImage(prod);
		return dao.updateProd(prod) > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}
}