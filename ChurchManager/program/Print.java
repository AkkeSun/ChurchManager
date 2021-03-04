package program;

import java.util.Scanner;

import Church.Church;
import singleton.Singleton;

public class Print extends Program{

	public Print() { print(); };

	public void print() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Singleton s = Singleton.getInstance();

		try {
			System.out.println();
			System.out.print("교구(1)/전체보기(2) : ");
			int choice = sc.nextInt();
			System.out.println();

			switch(choice) {
			
			// 보고싶은 교구만 보기
			case 1 :
				System.out.print("보고싶은 교구 : ");
				int parish = sc.nextInt();

				for (int i = 0; i < s.list.size(); i++) {
					Church c = s.list.get(i);
					if(c.getParish() == parish) 
						System.out.println(c);
						System.out.println();
				} 
				break;
				
			// 전체보기	
			case 2 : 
				for (int i = 0; i < s.list.size(); i++) {
					System.out.println(s.list.get(i));
					System.out.println();
				}
				break;
				
			// 잘못 입력했을 때 	
			default :
				System.out.println("잘못 입력했습니다");
				break;
				
			} 

		} catch (Exception e) {
			System.out.println("잘못 입력했습니다");
		}
	}
}
