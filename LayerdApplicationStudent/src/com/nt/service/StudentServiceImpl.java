package com.nt.service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dao.StudentDAOImpl;
import com.nt.dto.StudentDTO;

public class StudentServiceImpl implements StudentService {

	@Override
	public String generateResult(StudentDTO dto) throws Exception {
		int total = 0;
		float avg = 0.0f;
		String result = null;
		StudentBO bo = null;
		StudentDAO dao = null;
		int count = 0;
		// business logic
		total = dto.getM1() + dto.getM2() + dto.getM3();
		avg = total / 3.0f;

		if (dto.getM1() < 35 && dto.getM2() < 35 && dto.getM3() < 35)
			result = "Fail";
		else if (dto.getM1() < 50 && dto.getM2() < 50 && dto.getM3() < 50)
			result = "Second Division";
		else if (dto.getM1() < 75 && dto.getM2() < 75 && dto.getM3() < 75)
			result = "First Division";
		else
			result = "1st Rank";
		// Bo object
		bo = new StudentBO();
		bo.setSno(dto.getSno());
		bo.setSname(dto.getSname());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		// use DAO
		dao = new StudentDAOImpl();
		count = dao.insert(bo);

		if (count == 1)
			return "Register Success" + result;
		else
			return "Register Failed";

	}

}
