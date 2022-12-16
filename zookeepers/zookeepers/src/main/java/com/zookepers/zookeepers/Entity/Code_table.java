package com.zookepers.zookeepers.Entity;

import javax.persistence.*;

@Entity
@Table(name="code_table")
public class Code_table {

    @Id
    @Column(name="code")
    private String code;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name="code_name")
    private String CodeName;

    public String getCodeName() {
        return this.CodeName;
    }

    public void setCodeName(String CodeName) {
        this.CodeName = CodeName;
    }
    
}
