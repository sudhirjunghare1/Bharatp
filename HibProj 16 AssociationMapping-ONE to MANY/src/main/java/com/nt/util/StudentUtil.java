package com.nt.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentUtil {
	private static SessionFactory sf;
	static {
		Configuration cfg = new Configuration().configure();
		sf = cfg.buildSessionFactory();
	}

	public static SessionFactory getsf() {
		return sf;
	}
}
