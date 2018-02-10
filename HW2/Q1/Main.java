import java.util.*;

public class Main{
	public static void main(String args[]){
		DataReader dataReader = new DataReader(); 
		List<Integer> data1 = new ArrayList<>();
		List<Integer> data2 = new ArrayList<>();
		data1.addAll(dataReader.readFile(args[0]));
		data2.addAll(dataReader.readFile(args[1]));	
		//for(int i=0;i<data.size();i++)
		//	System.out.println(data.get(i));

		ShellSort ss = new ShellSort();
		int[] gap_ss = new int[]{7,3,1};
		int[] gap_insert = new int[]{1};
		ss.sort(data1, gap_ss);
		for(int num:data1)
			System.out.print(num);
		System.out.println();
		ss.sort(data2, gap_insert);
		for(int num:data2)
			System.out.print(num);
		System.out.println();

	}
}
