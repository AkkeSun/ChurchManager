package program;

import java.io.*;
import java.util.ArrayList;
import Church.Church;
import singleton.Singleton;

public class Save extends Program {

	
	Singleton s = Singleton.getInstance();
	ArrayList<String> setList = new ArrayList<String>(); // 저장 String을 담을그릇
	
	
	public Save () { 
		listSetting();
		fileSave(setList);
	}
		

	// saveSet(123-456-789 형식)을 setList에 저장 
	public void listSetting() {
		for(Church c : s.list)
			setList.add(c.saveSet());
	}
	
	
	// file save
	public void fileSave(ArrayList <String> list) {		
		File file = new File("d:\\Church\\" + "backup" + ".txt"); 

		try {                                                  
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			                                                      
			for (int i = 0; i < list.size(); i++) {
				pw.println(list.get(i));
			}			
			pw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("파일에 저장되었습니다");
	}
}
