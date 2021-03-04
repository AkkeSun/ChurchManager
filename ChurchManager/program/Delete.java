package program;
import singleton.Singleton;

public class Delete extends Program{

	public Delete() { delete(); }

	public void delete() {

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
			s.list.remove(index);
			System.out.println("성공적으로 삭제되었습니다");
		}
	}

}
