package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;
import com.nt.service.StudentServiceImpl;
import com.nt.vo.StudentVO;

public class MainControllerServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/hrml");

		StudentVO vo = null;
		StudentDTO dto = null;
		String result = null;
		ServletOutputStream sos = null;
		String sno = null, sname = null, m1 = null, m2 = null, m3 = null;
		StudentService service=null;
		// read the form data
		sno = req.getParameter("sno");
		sname = req.getParameter("sname");
		m1 = req.getParameter("m1");
		m2 = req.getParameter("m2");
		m3 = req.getParameter("m3");
		// create Vo
		vo = new StudentVO();
		vo.setSno(sno);
		vo.setSname(sname);
		vo.setM1(m1);
		vo.setM2(m2);
		vo.setM3(m3);
//convert vo to dto
		dto  = new StudentDTO();
		dto.setSno(Integer.parseInt(vo.getSno()));
		dto.setSname(vo.getSname());
		dto.setM1(Integer.parseInt(vo.getM1()));
		dto.setM2(Integer.parseInt(vo.getM2()));
		dto.setM3(Integer.parseInt(vo.getM3()));
	//use service 
		service= new StudentServiceImpl();
		try {
			result=service.generateResult(dto);
			//sos= res.getOutputStream();
			pw= res.getWriter();
			res.setContentType("text/html");
			pw.println("<h1>"+result +"</h1>");
			
			pw.println("<a href='form.html'>HOME</a>");
			
			pw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
