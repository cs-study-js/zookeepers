package com.zookepers.zookeepers.service;

import org.springframework.stereotype.Service;

import com.zookepers.zookeepers.repository.CodeRepository;

@Service
public class CodeServiceImpl implements CodeService {

    CodeRepository codeRepository;

    public CodeServiceImpl(CodeRepository codeRepository){
        this.codeRepository = codeRepository;
    }

    @Override
    public String getCodeName(String code) {
        return codeRepository.findByCode(code).getCodeName();
    }
    
}
