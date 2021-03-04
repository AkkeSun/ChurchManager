package churchManager;

import java.util.ArrayList;
import java.util.Scanner;

import Church.Church;
import program.Add;
import program.Delete;
import program.Fix;
import program.Load;
import program.Print;
import program.Program;
import program.Save;
import program.Search;
import singleton.Singleton;

public class ChurchManager {
	private Scanner sc = new Scanner(System.in);
	private Program p;
	
	public ChurchManager() {dataLoad(); menu();}

	public void dataLoad() {

		p = new Load();
		Church c;                                     
		Singleton s = Singleton.getInstance();           // 여기에 Master list 있음 
		ArrayList<?>alist = ((Load) p).fileLoad();       // Load 클래스 리턴값 저장
		
		for (int i = 0; i < alist.size(); i++) {
			String str = (String) alist.get(i);          // String에 저장
			String [] load = str.split("-");             // "-" 잘라서 String[] 저장
			
			int parish = Integer.parseInt(load[0]);
			String ministry = load[1] ;
			String date = load[2];
			String name = load[3];
			int age = Integer.parseInt(load[4]);
			String gender = load[5];
			String job = load[6];
			String phone = load[7];
			
			c = new Church (parish, ministry, date, name, // 객채 만들어 저장
							age, gender, job, phone);
			s.list.add(c);                                // Master list에 저장 
		}
		
	}
	
	public void menu() {

		while(true) { 
			try {

				System.out.println("==================menu====================");
				System.out.println();
				System.out.println("  (1)등록");
				System.out.println("  (2)수정");
				System.out.println("  (3)삭제");
				System.out.println("  (4)이름 검색");
				System.out.println("  (5)전체보기");
				System.out.println("  (6)저장");
				System.out.println("  (0)종료");
				System.out.println();
				System.out.print("  [입력] : ");
				int choice = sc.nextInt();
				System.out.println();
				System.out.println("==========================================");


				switch(choice) {
				case 1 :
					p = new Add();
					break;
				case 2 : 
					p = new Fix();
					break;
				case 3 : 
					p = new Delete();
					break;
				case 4 : 
					p = new Search();
					break;
				case 5 : 
					p = new Print();
					break;
				case 6 : 
					p = new Save();
					break;
				case 0 :
					dataLoad();
					System.exit(0);
					System.out.println("==========================================");
					break;
				default : 
					System.out.println("잘못 입력하였습니다");
					break;
				}

			} catch (Exception e) {
				System.out.println("잘 못 입력하였습니다");
			}

		} // while
	} // church

	
} // class
