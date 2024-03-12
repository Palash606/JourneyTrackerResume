package com.example.journeytracker.controller;

import com.example.journeytracker.payloads.ApiResponse;
import com.example.journeytracker.payloads.CertificateDto;
import com.example.journeytracker.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("resume/certificate")
public class CertificateController {
	
	@Autowired
	private CertificateService certificateService;
	
	@PostMapping("/scholar/{scholar}")
	public ResponseEntity<CertificateDto> createCertificate(@RequestBody CertificateDto certificateDto,@PathVariable("scholar") String scholar){
		CertificateDto certi = this.certificateService.createCertificate(certificateDto, scholar);
		return new ResponseEntity<CertificateDto>(certi,HttpStatus.CREATED);
	}
	
	@PutMapping("/id/{id}")
	public ResponseEntity<CertificateDto> updateCertificate(@RequestBody CertificateDto certificateDto, @PathVariable("id") Integer id){
		CertificateDto updatedCerti = this.certificateService.updateCertificate(certificateDto, id);
		return new ResponseEntity<CertificateDto>(updatedCerti,HttpStatus.OK);
	}
	
	@GetMapping("/scholar/{scholarId}")
	public ResponseEntity<List<CertificateDto>> getCertiByScholar(@PathVariable("scholarId") String scholarId){
		List<CertificateDto> list = this.certificateService.getCertificateByScholar(scholarId);
		return new ResponseEntity<List<CertificateDto>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CertificateDto>> getAllCertificate(){
		List<CertificateDto> list = this.certificateService.getAllCertificate();
		return new ResponseEntity<List<CertificateDto>>(list,HttpStatus.OK);
	}
	
	@DeleteMapping("/id/{id}")
	public ApiResponse deleteCertificate(@PathVariable("id") Integer id) {
		this.certificateService.deleteCertificate(id);
		return new ApiResponse("Certificate deleted successfully",true);
	}

}
