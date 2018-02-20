import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        List<Integer> data1 = new ArrayList<>();
        List<Integer> data2 = new ArrayList<>();

        if(args.length <= 1){
            //no filename input
            System.out.println("Error: Data not enough.");
            return;
        }else{
            //read data from files
            data1.addAll(dataReader.readFile(args[0]));
            data2.addAll(dataReader.readFile(args[1]));

            if(data1.size() == 0 || data2.size() == 0){
                System.out.println("Error: no data.");
                return;
            }

            if(data1.size() != data2.size()){
                System.out.println("Error: Input data size must be the same");
                return;
            }
        }

        int length = data1.size();

        long r = 0;
        for (int t = 0;t<5;t++) {
            NanoTimer nt = new NanoTimer();
            List<Integer> data1Index = new ArrayList<>(data1);
            List<Integer> data2Index = new ArrayList<>(data1);

            /*
                All the numbers are reduced by 1 when read from file to avoid out-of-range errors.
                See https://algs4.cs.princeton.edu/25applications/KendallTau.java.html
                and http://shmilyaw-hotmail-com.iteye.com/blog/2275113 (Chinese)
             */

            for (int i = 0; i < length; i++) {
                data1Index.set(data1.get(i), i);
            }

            for (int i = 0; i < length; i++) {
                data2Index.set(i, data1Index.get(data2.get(i)));
            }

            MergeSort ms = new MergeSort();
            ms.topdown(data2Index);

            long time = nt.calc();
            r = r+time;
        }

        r = r/5;
        System.out.println("The running time is "+r+" ns.");

    }
}
