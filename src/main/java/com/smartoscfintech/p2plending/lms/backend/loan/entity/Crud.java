package com.smartoscfintech.p2plending.lms.backend.loan.entity;

import org.json.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Document("Crud")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Crud {
	@Id
	private String id;
	@NotBlank
	private String name;
	private String code;
}

