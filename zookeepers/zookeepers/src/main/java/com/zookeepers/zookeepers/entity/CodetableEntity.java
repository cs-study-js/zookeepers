package com.zookeepers.zookeepers.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name="code_table")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CodetableEntity {

    @Id
    @Column(name="code")
    private String code;

    @Column(name="code_name")
    private String codeName;

}
