package com.fnsms.main;

import com.fnsms.emp.EmpDateService;

public class Main {
	public static void main(String[] args) {
		
		EmpDateService empDateService = new EmpDateService(); // 객체 생성
        empDateService.viewByDate(); // 객체 메서드 호출

		
	}

}
