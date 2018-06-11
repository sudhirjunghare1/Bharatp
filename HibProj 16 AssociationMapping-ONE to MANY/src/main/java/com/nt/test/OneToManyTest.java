package com.nt.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.model.Employee;
import com.nt.model.PhoneNumber;
import com.nt.util.StudentUtil;

public class OneToManyTest {

	public static void main(String[] args) {
		Session ses = StudentUtil.getsf().openSession();
		Transaction tx = ses.beginTransaction();
		// Person Object
		// save operation
		PhoneNumber phone = new PhoneNumber();
		phone.setPhone(123);
		phone.setTypeSim("prepaid");
		phone.setExpDate(new Date());

		Employee emp = new Employee();
		emp.setEmpId(1);
		emp.seteName("raaz");
		emp.setPhone(phone);

		/*Employee emp1 = new Employee();
		emp1.setEmpId(100);
		emp1.seteName("Sandeep");
		

		Employee emp2 = new Employee();
		emp2.setEmpId(10);
		emp2.seteName("rishi");
*/		
		ses.save(emp);
		/*ses.save(emp1);
		ses.save(emp2);
*/
		ses.save(phone);
		// transaction Commit
		tx.commit();
		// close session
		ses.close();
	}// main

}// class
