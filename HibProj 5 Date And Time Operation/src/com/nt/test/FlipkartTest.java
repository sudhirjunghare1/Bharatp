package com.nt.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.model.Flipkart;
import com.nt.util.FlipkartUtil;

public class FlipkartTest {

	public static void main(String[] args) throws IOException {

		Session ses = FlipkartUtil.getsf().openSession();
		Transaction tx = ses.beginTransaction();
		Flipkart fpkt = new Flipkart();
		fpkt.setProductID(1253);
		fpkt.setProductName("Sony");
		fpkt.setBuyDate(new Date());
		fpkt.setDelivary(new Date());
		fpkt.setConFormation(new Date());
		// convert to BLOG
		File f = new File("C:\\Users\\patel\\Desktop\\Iphone.JPG");
		FileInputStream fis = new FileInputStream(f);
		byte[] array = new byte[fis.available()];
		fis.read(array);
		fpkt.setImage(array);
		// Convert to CLOG object
		String s = "Hello Sony is Best i LOve in Sony";
		char[] charr = s.toCharArray();
		fpkt.setText(charr);
		System.out.println("Result ::: " + fpkt.getProductID() + "," + fpkt.getProductName() + "," + fpkt.getBuyDate()
				+ "," + fpkt.getDelivary() + "," + fpkt.getConFormation() + "," + fpkt.getImage() + ","
				+ fpkt.getText());
		// save opreation
		ses.save(fpkt);
		// transaction Commit
		tx.commit();
		// close session
		ses.close();
	}//main

}//class
