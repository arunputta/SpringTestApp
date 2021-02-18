package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.PatientDTO;
import com.nt.service.IPatientServiceDetails;
import com.nt.service.PatientServiceDetailsImpl;

@WebServlet("/controller")
public class PatientController extends HttpServlet{

	IPatientServiceDetails service;
	
	public void init() {
		service = new PatientServiceDetailsImpl();
	}
	public void destroy() {
		service =null;
	}
	protected  void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		PrintWriter pw = null;
		PatientDTO dto = null;
		//set Response Object
		pw = res.getWriter();
		//set response content type
		res.setContentType("text/html");
		// DTO data
		dto = new PatientDTO();
		dto.setSrNo(Integer.parseInt(req.getParameter("srNo")));
		dto.setfName(req.getParameter("fName"));
		dto.setlName(req.getParameter("lName"));
		dto.seteMailId(req.getParameter("MailId"));
		dto.setMobNo(Long.parseLong(req.getParameter("MobNo")));
		dto.setGender(req.getParameter("gender"));
		dto.setAge(Integer.parseInt(req.getParameter("age")));
		dto.setHiredate(req.getParameter("date"));
		try {
			String result = service.register(dto);
			pw.println("<h1 style='color:green;text-align:center'>"+result+"</h1>");
		}
		catch(Exception e) {
			e.printStackTrace();
			pw.println("<h1 style='color:red;text-align:center'>Internal Problem--Try Again</h1>");
		}
		//add hyperLink
		pw.println("<br><br><a href='result.html'>Home</a>");
	//close streams
		pw.close();
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException {
		doGet(req, res);
	}

	
}
