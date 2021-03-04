package program;
import java.util.Scanner;

import Church.Church;
import singleton.Singleton;

public class Fix extends Program{

	public Fix () { fix(); }

	public void fix() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Singleton s = Singleton.getInstance();
		String ministry = null;
		int index = findIndex();

		// 동일인이 존재하는경우 전화번호로 찾기
		if(index == -2)
			index = findNumIndex();

		// 값이 없을 때
		if(index == -1)
			System.out.println("찾을 수 없습니다.");

		// 이름으로 찾았으면
		else { 

			// c에 저장하고 list에서는 지우자 
			Church c = s.list.get(index);
			s.list.remove(index);


			try {
				//안바뀌는 부분은 c에서 꺼내 저장
				int age =c.getAge();
				String name = c.getName();
				String gender = c.getGender();
				String date = c.getDate();

				// 수정 내용 입력
				System.out.print("교구 : ");
				int parish = sc.nextInt();			
				System.out.print("직분 : ");
				String job = sc.next().trim();
				System.out.print("전화번호 : ");
				String phone = sc.next();
				

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
					break;
				} 

				//객채 생성
				Church ch = new Church(parish, ministry, date, name, 
						               age, gender, job, phone);
				//list에 저장
				s.list.add(ch);

				
				
			} catch (Exception e) {
				System.out.println("잘못 입력하였습니다");				
			}

			
			System.out.println("수정 되었습니다");

		}
	}

}
