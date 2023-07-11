package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COURSE_DTLS")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CID")
	@JsonProperty("cid")
	//properties file 
private Integer cid;
	
	@JsonProperty("courseName")
	@Column(name ="CNAME")
	@NotEmpty
	@Size(min = 2,message = "Couse Name Should Minimum 2 Chracters")
private String cname;

	@JsonProperty("cduration")
	@Column(name ="CDURATION")
	@NotEmpty
	@Size(min = 2,message = "Couse DURATION Should Minimum 2 Chracters")
private String cduration;
	@JsonProperty("cfee")
	@Column(name= "CFEE")
	private Integer cfee;
	
}
