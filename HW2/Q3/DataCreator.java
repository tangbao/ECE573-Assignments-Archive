import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class DataCreator{
	public void build(){
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
