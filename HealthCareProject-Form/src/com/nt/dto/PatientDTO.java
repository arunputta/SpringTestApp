package com.nt.dto;

import java.io.Serializable;
import java.util.Date;

public class PatientDTO implements Serializable {

	private Integer srNo;
	private String fName;
	private String lName;
	private String eMailId;
	private Integer age;
	private String hiredate;
	private Long MobNo;
	private String gender;
	public Integer getSrNo() {
		return srNo;
	}
	public void setSrNo(Integer srNo) {
		this.srNo = srNo;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String geteMailId() {
		return eMailId;
	}
	public void seteMailId(String eMailId) {
		this.eMailId = eMailId;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public Long getMobNo() {
		return MobNo;
	}
	public void setMobNo(Long mobNo) {
		MobNo = mobNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
