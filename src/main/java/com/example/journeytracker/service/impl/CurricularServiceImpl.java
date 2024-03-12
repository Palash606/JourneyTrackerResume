package com.example.journeytracker.service.impl;

import com.example.journeytracker.entity.Curricular;
import com.example.journeytracker.entity.StudentPersonel;
import com.example.journeytracker.exception.ResourceNotFoundException;
import com.example.journeytracker.exception.ResourceNotFoundExceptionAll;
import com.example.journeytracker.payloads.CurricularDto;
import com.example.journeytracker.repository.CurricularRepo;
import com.example.journeytracker.repository.StudentPersonelRepo;
import com.example.journeytracker.service.CurricularService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurricularServiceImpl implements CurricularService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private StudentPersonelRepo studentPersonelRepo;

    @Autowired
    private CurricularRepo curricularRepo;

    @Override
    public CurricularDto createCurricular(CurricularDto curricularDto, String scholarNo) {
        // TODO Auto-generated method stub
        StudentPersonel student = this.studentPersonelRepo.findById(scholarNo)
                .orElseThrow(() -> new ResourceNotFoundException("StudentPersonel", "Id", scholarNo));
        Curricular curi = this.dtoToCurricular(curricularDto);
        curi.setScholarNo(student);
        Curricular savedCurri = this.curricularRepo.save(curi);
        return this.curricularToDto(savedCurri);
    }

    @Override
    public CurricularDto updateCurricular(CurricularDto curricularDto, Integer id) {
        Curricular curri = this.curricularRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptionAll("Curricular", "Id", id));
        curri.setCurriName(curricularDto.getCurriName());
        Curricular updatedCurri = this.curricularRepo.save(curri);
        return this.curricularToDto(updatedCurri);
    }

    @Override
    public List<CurricularDto> getCurricularByScholar(String scholar) {
        StudentPersonel student = this.studentPersonelRepo.findById(scholar)
                .orElseThrow(() -> new ResourceNotFoundException("StudentPersonel", "Id", scholar));
        List<Curricular> curriList = this.curricularRepo.findByScholarNo(student);
        List<CurricularDto> list = curriList.stream().map(curi -> this.curricularToDto(curi))
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public List<CurricularDto> getAllCurricular() {
        List<Curricular> curi = this.curricularRepo.findAll();
        List<CurricularDto> list = curi.stream().map(a -> this.curricularToDto(a)).collect(Collectors.toList());

        return list;
    }

    @Override
    public void deleteCurricular(Integer id) {
        Curricular curi = this.curricularRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptionAll("Curricular", "Id", id));
        this.curricularRepo.delete(curi);

    }

    public Curricular dtoToCurricular(CurricularDto curricularDto) {
        Curricular curi = this.modelMapper.map(curricularDto, Curricular.class);
        return curi;
    }

    public CurricularDto curricularToDto(Curricular curi) {
        CurricularDto curiDto = this.modelMapper.map(curi, CurricularDto.class);
        return curiDto;

    }

}
