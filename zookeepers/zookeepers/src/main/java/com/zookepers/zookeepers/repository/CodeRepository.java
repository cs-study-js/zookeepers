package com.zookepers.zookeepers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zookepers.zookeepers.Entity.Code_table;

public interface CodeRepository extends JpaRepository<Code_table , String>{
    public Code_table findByCode(String code);
}
