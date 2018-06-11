package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.nt.bo.StudentBO;

public class StudentDAOImpl implements StudentDAO {
	private Connection getConnection;
	private static final String Student_Search = "INSERT INTO STUDENT_LAYERED VALUES(?,?,?,?,? )";
	//private static final String Student_Search = "INSERT INTO STUDENT_LAYERED VALUES(STUDENT_SEQ IN NEXTVAL,?,?,?,? )";
	@Override
	public int insert(StudentBO bo) throws Exception {
		DataSource ds = null;
		InitialContext ic = null;
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		// create Initial Context object
		ic = new InitialContext();
		// get DataSource object data Source object and add costing
		ds = (DataSource) ic.lookup("DsJndi");
		//ds = (DataSource) ic.lookup("java:/comp/env/DsJndi");
		// Connection object
		con = ds.getConnection();
		// prapered object
		ps = con.prepareStatement(Student_Search);
		// SET VALUES to query params
		ps.setInt(1, bo.getSno());
		ps.setString(2, bo.getSname());
		ps.setInt(3, bo.getTotal());
		ps.setFloat(4, bo.getAvg());
		ps.setString(5, bo.getResult());
		// exeute query
		result = ps.executeUpdate();

		// close object
		ps.close();
		con.close();
		return result;
	}

}
