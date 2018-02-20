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

		List<Integer> data2 = new ArrayList<>(data);

		MergeSort ms = new MergeSort();
		NanoTimer nt1 = new NanoTimer();
		ms.chksorted(data);
		long time1 = nt1.calc();
		System.out.println("The time of mergesort is "+time1+" ns");

		CountingSort cs = new CountingSort();
        NanoTimer nt2 = new NanoTimer();
		cs.sort(data2);
		long time2 = nt2.calc();
        System.out.println("The time of countingsort is "+time2+" ns");

		SortTest st = new SortTest();
		st.check(data,1);
        st.check(data2,1);

	}
}
