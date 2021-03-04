package program;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import Church.Church;
import singleton.Singleton;

public class Add extends Program{

	public Add() {  add();  };

	public void add() {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Singleton s = Singleton.getInstance();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format1 = new SimpleDateFormat ("yyyy년 MM월 dd일");
		String ministry;

		try {

			System.out.print("교구 : ");
			int parish = sc.nextInt();
			System.out.print("이름 : ");
			String name = sc.next().trim();
			System.out.print("성별(남/여) : ");
			String gender = sc.next().trim();
			System.out.print("또래 : ");
			int age = sc.nextInt();
			System.out.print("직분 : ");
			String job = sc.next().trim();
			System.out.print("전화번호(숫자만) : ");
			String phone = sc.next();

			//날짜는 오늘 날짜로 자동 등록
			String date = format1.format(cal.getTime());


			switch(parish){
			case 1: 
				ministry = "이효상 전도사";
				break;
			case 2: 
				ministry = "양재훈 목사";
				break;
			case 3: 
				ministry = "이상억 목사";
				break;
			default:
				System.out.println("잘못 입력하였습니다");
				return;
			} 

			
			//객채생성
			Church ch = new Church(parish, ministry, date, name, 
					               age, gender, job, phone);
			//객채를 list에 저장 
			s.list.add(ch);

			System.out.println("성공적으로 추가되었습니다");

			
			
		} catch (Exception e) {
			System.out.println("잘못 입력하셨습니다.");
		}

	}

}
