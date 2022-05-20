package com.banabook.web.domain.inquiry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banabook.web.domain.inquiry.domain.InquiryDTO;
import com.banabook.web.domain.inquiry.mapper.InquiryDAO;



@Service // component써도 되는데 service에는 service쓰는게 관행이다
public class InquiryServiceImpl implements InquiryService {

	@Autowired
	InquiryDAO inquiryDAO;
	
	@Override
	public List<InquiryDTO> selectProctDetailPage(String code) {
		
		return inquiryDAO.selectProctDetailPage(code);
	}

	@Override
	public InquiryDTO selectToInquiry_id(int inquiry_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
