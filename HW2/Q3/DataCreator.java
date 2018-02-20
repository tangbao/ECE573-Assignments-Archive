/*
	DataCreator
	Create a data set of 8192 entries which has in the following order: 1024
repeats of 1, 2048 repeats of 11, 4096 repeats of 111 and 1024 repeats of
1111 in file Q3data.txt

	Written by Zhongze Tang for DSA HW2 Q3
 */

import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class DataCreator{
	public void build(){
		//data stores in Q3data.txt
		File file = new File("Q3data.txt");
		PrintWriter writer = null;
		try{
			writer = new PrintWriter(file, "UTF-8");
			for(int i = 0; i<1024; i++){
				writer.println("1");
			}
			for(int i = 0; i<2048; i++){
				writer.println("11");
			}
			for(int i = 0; i<4096; i++){
				writer.println("111");
			}
			for(int i = 0; i<1024; i++){
				writer.println("1111");
			}
		}catch(IOException e){
			System.out.println(e.toString());
		}finally{
			if(writer != null) writer.close();
		}
	}
}
