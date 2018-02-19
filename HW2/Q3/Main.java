import java.util.ArrayList;
import java.util.List;

public class Main{
	public static void main(String[] args){
		DataCreator dataCreator = new DataCreator();
		DataReader dataReader = new DataReader();
		List<Integer> data = new ArrayList<>();


		dataCreator.build();
		data.addAll(dataReader.readFile("Q3data.txt"));

		if(data.size() == 0){
			System.out.println("Error: no data.");
			return;
		}

		MergeSort ms = new MergeSort();
		ms.chksorted(data);
		SortTest st = new SortTest();
		st.check(data,1);

	}
}
