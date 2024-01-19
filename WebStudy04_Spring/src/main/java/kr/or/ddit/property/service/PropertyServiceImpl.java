package kr.or.ddit.property.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.property.dao.PropertyDAO;
import kr.or.ddit.vo.PropertyVO;

@Service
public class PropertyServiceImpl implements PropertyService {
	
	@Inject
	private PropertyDAO dao;

	@Override
	public boolean createProperty(PropertyVO newProp) {
		int rowcnt = dao.insertProperty(newProp);
		return rowcnt>0;
	}

	@Override
	public PropertyVO retrieveProperty(String propertyName) {
		return dao.selectProperty(propertyName);
	}

	@Override
	public List<PropertyVO> retrieveProperties() {
		return dao.selectProperties();
	}

	@Override
	public Set<String> retireveKeySet() {
		return retrieveProperties().stream()
				.map(PropertyVO::getPropertyName)
				.collect(Collectors.toSet());
	}

	@Override
	public boolean updateProperty(PropertyVO modifyProp) {
		return dao.updateProperty(modifyProp) > 0;
	}

	@Override
	public boolean deleteProperty(String propertyName) {
		int rowcnt = dao.deleteProperty(propertyName);
		return rowcnt>0;
	}
}