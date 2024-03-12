package com.example.journeytracker.service;


import com.example.journeytracker.payloads.CertificateDto;

import java.util.List;

public interface CertificateService {
	
	CertificateDto createCertificate(CertificateDto certificateDto, String scholar);
	
	CertificateDto updateCertificate(CertificateDto certificateDto, Integer id);
	
	void deleteCertificate(Integer id);
	
	List<CertificateDto> getCertificateByScholar(String scholar);
	
	List<CertificateDto> getAllCertificate();

}
