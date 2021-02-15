package program;

import java.util.Scanner;
import Church.Church;
import singleton.Singleton;


public class Program {
	private Singleton s = Singleton.getInstance();;
	private Scanner sc = new Scanner(System.in);
	
	public Program() {}

	public int findIndex () {
		
		
		int index = -1;            // 찾는 값이 없을 때 -1 출력 
		boolean compare = false;   // 동일이름이 있는지 확인
	
		System.out.print("이름 : ");
		String name = sc.next().trim();

		for (int i = 0; i < s.list.size(); i++) {
			Church c = s.list.get(i);
					
			// 동일이름 존재유무 확인
			if(c.getName().contains(name) && compare){
				System.out.println("동일인이 존재합니다.");
				index = -2;
				break;
			}
			
			//하나 찾았으면 저장하고 다시 돌기 
			if(c.getName().contains(name)) {
				compare = true;
				index = i;
				continue;
			}
		} 
		
		return index;
	}
	
	public int findNumIndex() {
		int index =1;
		for (int j = 0; j < s.list.size(); j++) {
			Church c = s.list.get(j);
			System.out.print("전화번호 : ");
			String num = sc.next();
			
			if(c.getPhone().contains(num)) {
				System.out.println(j);
				index = j;
				break;
			}
		}
		return index;
	}
}
