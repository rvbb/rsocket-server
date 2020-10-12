package com.smartoscfintech.p2plending.lms.backend.loan.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.HashSet;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "transactions_demo")
public class Transaction {

//    @ApiModelProperty(notes = "MongoDB Objectid(). This is default of MongoDB unique Id")    
//    @Field("_id")
//    private String id;

    @ApiModelProperty(notes = "name", example = "VPBank")
    private String name;
    
    @ApiModelProperty(notes = "describe transaction")
    private String mark;
    
    @ApiModelProperty(notes = "Fund Transfer ID")
    @Indexed(unique=true)
    private String ft;
    
    @ApiModelProperty(notes = "created date")
    private Date created;

    @Override
    public String toString() {
        return new JSONObject(this).toString();
    }
}
