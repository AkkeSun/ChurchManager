package program;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Load extends Program{

	public Load () {}	

	public ArrayList<?> fileLoad() {
		
		File file;
		ArrayList <String> list = new ArrayList<>();  // txt파일을 저장할 list
		file = new File("d:\\Church\\" + "backup" + ".txt"); 

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str = null; // 담는 그릇 

			while((str = br.readLine()) != null) {
				list.add(str); // 그릇을 list에 저장 
			}
			br.close();		

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
