import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int N = 7;

    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        List<Integer> data = new ArrayList<>();

        if(args.length == 0){
            //no filename input
            System.out.println("Error: You have to determine the data source.");
            return;
        }else{
            for(String file:args){
                //read data from files
                data.addAll(dataReader.readFile(file));
            }
            if(data.size() == 0){
                System.out.println("Error: no data.");
                return;
            }
        }

        List<Integer> data2 = new ArrayList<>(data);
        MergeSort ms = new MergeSort();
        QuickSort qs = new QuickSort();
        SortTest st = new SortTest();

        ms.cutoff(data, N);
        st.check(data,1);

        qs.sort_mO3(data2);
        st.check(data2,1);
    }
}
