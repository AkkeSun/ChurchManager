package program;

import singleton.Singleton;

public class Search extends Program {
	
	public Search() { search(); }
	
	public void search() {
		Singleton s = Singleton.getInstance();
		int index = findIndex();
		
		// 동일인이 존재하는경우 전화번호로 찾기
		if(index == -2)
			index = findNumIndex();
		
		// 값이 없을 때
		if(index == -1)
			System.out.println("찾을 수 없습니다.");
		
		// 이름으로 찾았으면
		else { 
			System.out.println(s.list.get(index));
		}
	}
}
