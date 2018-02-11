import java.util.ArrayList;
import java.util.List;

public class Main{
	public static void main(String args[]){
		DataReader dataReader = new DataReader();
		List<Integer> data1 = new ArrayList<>();
		List<Integer> data2 = new ArrayList<>();

		if(args.length == 0){
			//no filename input
			System.out.println("Error: You have to determine the data source.");
			return;
		}else{
			for(String file:args){
				//read data from files
				data1.addAll(dataReader.readFile(file));
			}
			if(data1.size() == 0){
				System.out.println("Error: no data.");
				return;
			}
		}

		data1.addAll(dataReader.readFile(args[0]));
		data2.addAll(data1);

		ShellSort ss = new ShellSort();
		SortTest st = new SortTest();

		//Shellsort
		int[] gap_ss = new int[]{7,3,1};
		ss.sort(data1, gap_ss, 1);
		st.check(data1, 1);
		//Insertion sort
		int[] gap_insert = new int[]{1};
		ss.sort(data2, gap_insert, 1);
		st.check(data2, 1);

	}
}
