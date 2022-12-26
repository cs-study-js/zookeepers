package com.zookepers.zookeepers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zookepers.zookeepers.entity.CodetableEntity;

public interface CodeRepository extends JpaRepository<CodetableEntity , String>{
    public CodetableEntity findByCode(String code);
}
