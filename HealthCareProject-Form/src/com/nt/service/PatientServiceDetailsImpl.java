package com.nt.service;

import com.nt.bo.PatientBO;
import com.nt.dao.IPatientDetailsDAO;
import com.nt.dao.PatientDetailsDAOImpl;
import com.nt.dto.PatientDTO;

public class PatientServiceDetailsImpl implements IPatientServiceDetails {

	private IPatientDetailsDAO dao;
	
	public PatientServiceDetailsImpl() {
		this.dao = new PatientDetailsDAOImpl();
	}
	
	@Override
	public String register(PatientDTO dto) throws Exception {
		PatientBO bo = null;
		bo = new PatientBO();
		bo.setSrNo(dto.getSrNo());
		bo.setfName(dto.getfName());
		bo.setlName(dto.getlName());
		bo.setAge(dto.getAge());
		bo.setHiredate(dto.getHiredate());
		bo.seteMailId(dto.geteMailId());
		bo.setGender(dto.getGender());
		bo.setMobNo(dto.getMobNo());
		
		//use DAO
		int count = dao.insert(bo);
		if(count==0)
			return "Not Registered";
		else
			return "Registered";
	}
}
