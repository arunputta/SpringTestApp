package com.nt.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.PatientBO;

public class PatientDetailsDAOImpl implements IPatientDetailsDAO{

	private static final String DS_JNDI_NAME="java:/comp/env/Dsjndi";
	private static final String INSERT_QUERY="INSERT INTO PATIENTDETAILS VALUES(P_SEQ4.NEXTVAL,?,?,?,?,?,?,?,?)";
    
	@Override
	public int insert(PatientBO bo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int count =0;
		//get Pooled JDBC Connection
		con = getPooledJdbcConnection(DS_JNDI_NAME);
		//create prepareStatement obj from query
		ps = con.prepareStatement(INSERT_QUERY);
		//set values to query param
		ps.setInt(1, bo.getSrNo());
		ps.setString(2, bo.getfName());
		ps.setString(3, bo.getlName());
		ps.setString(4, bo.geteMailId());
		ps.setLong(5, bo.getMobNo());
		ps.setString(6, bo.getGender());
		ps.setInt(7, bo.getAge());
		ps.setString(8, bo.getHiredate());
		//evaluate sql query
		count = ps.executeUpdate();
		return count;
	}

	private Connection getPooledJdbcConnection(String jndi) throws Exception{
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		//create InitialContext Object
		ic = new InitialContext();
		//get the DataSource obj from JNDI
		ds = (DataSource) ic.lookup(jndi);
		//get Pooled JDBC Connection
		con = ds.getConnection();
		return con;
	}
}
