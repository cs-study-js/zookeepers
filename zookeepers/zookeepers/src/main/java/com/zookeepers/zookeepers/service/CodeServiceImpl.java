package com.zookeepers.zookeepers.service;

import org.springframework.stereotype.Service;

import com.zookeepers.zookeepers.repository.CodeRepository;

@Service
public class CodeServiceImpl implements CodeService {

    private final CodeRepository codeRepository;

    public CodeServiceImpl(CodeRepository codeRepository){
        this.codeRepository = codeRepository;
    }

    @Override
    public String getCodeName(String code) {
        return codeRepository.findByCode(code).getCodeName();
    }
    
}
