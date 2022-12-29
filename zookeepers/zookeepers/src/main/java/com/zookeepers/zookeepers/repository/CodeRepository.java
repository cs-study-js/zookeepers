package com.zookeepers.zookeepers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zookeepers.zookeepers.entity.CodetableEntity;

public interface CodeRepository extends JpaRepository<CodetableEntity, String>{
    public CodetableEntity findByCode(String code);
}
