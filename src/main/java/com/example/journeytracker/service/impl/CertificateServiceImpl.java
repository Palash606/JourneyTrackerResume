
package com.example.journeytracker.service.impl;

import com.example.journeytracker.entity.Certificate;
import com.example.journeytracker.entity.StudentPersonel;
import com.example.journeytracker.exception.ResourceNotFoundException;
import com.example.journeytracker.exception.ResourceNotFoundExceptionAll;
import com.example.journeytracker.payloads.CertificateDto;
import com.example.journeytracker.repository.CertificateRepo;
import com.example.journeytracker.repository.StudentPersonelRepo;
import com.example.journeytracker.service.CertificateService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CertificateServiceImpl implements CertificateService {

	@Autowired
	private StudentPersonelRepo studentPersonelRepo;
	
	@Autowired
	private CertificateRepo certificateRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CertificateDto createCertificate(CertificateDto certificateDto, String scholar) {
		// TODO Auto-generated method stub
		StudentPersonel student = this.studentPersonelRepo.findById(scholar).orElseThrow(()->new ResourceNotFoundException("StudentPersonel", "Id", scholar));
		Certificate certi = this.dtoToCertificate(certificateDto);
		certi.setScholarNo(student);
		Certificate savedCerti = this.certificateRepo.save(certi);
		return this.certificateToDto(savedCerti);
	}

	@Override
	public CertificateDto updateCertificate(CertificateDto certificateDto, Integer id) {
		// TODO Auto-generated method stub
		Certificate certi = this.certificateRepo.findById(id).orElseThrow(()->new ResourceNotFoundExceptionAll("Certificate", "Id", id));
		certi.setCertiName(certificateDto.getCertiName());
		certi.setCertiPlateform(certificateDto.getCertiPlateform());
		certi.setCertiUrl(certificateDto.getCertiUrl());
		certi.setCompleDate(certificateDto.getCompleDate());
		
		Certificate updatedCerti = this.certificateRepo.save(certi);
		
		return this.certificateToDto(updatedCerti);
	}

	@Override
	public void deleteCertificate(Integer id) {
		// TODO Auto-generated method stub
		Certificate certi = this.certificateRepo.findById(id).orElseThrow(()->new ResourceNotFoundExceptionAll("Certificate", "Id", id));
		this.certificateRepo.delete(certi);
		
	}

	@Override
	public List<CertificateDto> getCertificateByScholar(String scholar) {
		// TODO Auto-generated method stub
		StudentPersonel student = this.studentPersonelRepo.findById(scholar).orElseThrow(()->new ResourceNotFoundException("StudentPersonel", "Id", scholar));
		List<Certificate> list = this.certificateRepo.findByScholarNo(student);
		List<CertificateDto> dtoList = list.stream().map(cer->this.certificateToDto(cer)).collect(Collectors.toList());
		return dtoList;
	}

	@Override
	public List<CertificateDto> getAllCertificate() {
		// TODO Auto-generated method stub
		List<Certificate> list = this.certificateRepo.findAll();
		List<CertificateDto> dtoList = list.stream().map(cer->this.certificateToDto(cer)).collect(Collectors.toList());
		return dtoList;
	}

	public Certificate dtoToCertificate(CertificateDto certiDto) {
		Certificate certi = this.modelMapper.map(certiDto, Certificate.class);
		return certi;
	}

	public CertificateDto certificateToDto(Certificate certi) {
		CertificateDto certiDto = this.modelMapper.map(certi, CertificateDto.class);
		return certiDto;

	}
	
}
