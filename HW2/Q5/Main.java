import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;

public class Main {

    public static void main(String[] args) throws IOException {
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

//        String[] files = new String[]{
//                "C:\\Users\\tzzma\\source\\repos\\573\\HW2\\dataset\\data0.1024",
//                "C:\\Users\\tzzma\\source\\repos\\573\\HW2\\dataset\\data0.2048",
//                "C:\\Users\\tzzma\\source\\repos\\573\\HW2\\dataset\\data0.4096",
//                "C:\\Users\\tzzma\\source\\repos\\573\\HW2\\dataset\\data0.8192",
//                "C:\\Users\\tzzma\\source\\repos\\573\\HW2\\dataset\\data0.16384",
//                "C:\\Users\\tzzma\\source\\repos\\573\\HW2\\dataset\\data0.32768",
//                "C:\\Users\\tzzma\\source\\repos\\573\\HW2\\dataset\\data1.1024",
//                "C:\\Users\\tzzma\\source\\repos\\573\\HW2\\dataset\\data1.2048",
//                "C:\\Users\\tzzma\\source\\repos\\573\\HW2\\dataset\\data1.4096",
//                "C:\\Users\\tzzma\\source\\repos\\573\\HW2\\dataset\\data1.8192",
//                "C:\\Users\\tzzma\\source\\repos\\573\\HW2\\dataset\\data1.16384",
//                "C:\\Users\\tzzma\\source\\repos\\573\\HW2\\dataset\\data1.32768"};

        List<Integer> data2;
        MergeSort ms = new MergeSort();
        QuickSort qs = new QuickSort();

//        for(String file:files){
//            System.out.println(file);

            int testtime = 5;

            //merge sort
            long r1 = 0;
            for(int t1 = 0; t1<testtime;t1++){
                data = new ArrayList<>(dataReader.readFile(args[0]));
                NanoTimer nt1 = new NanoTimer();
                ms.topdown(data);
                long time1 = nt1.calc();
                r1 = r1+time1;
            }
            r1 = r1/testtime;
            System.out.println("mergesort runs "+r1+" ns");

            //quick sort with no cutoff
            long r2 = 0;
            for(int t2 = 0; t2<testtime;t2++){
                data2 = new ArrayList<>(dataReader.readFile(args[0]));
                NanoTimer nt2 = new NanoTimer();
                qs.sort_mO3(data2, 0);
                long time2 = nt2.calc();
                r2 = r2+time2;
            }
            r2 = r2/testtime;
            System.out.println("quicksort runs "+r2+" ns");


            //test best cutoff
            int N_MAX = 15;
            for(int N=1;N<=N_MAX;N++){
                long r3 = 0;
                for(int t3 = 0; t3<testtime;t3++){
                    data2 = new ArrayList<>(dataReader.readFile(args[0]));
                    NanoTimer nt3 = new NanoTimer();
                    qs.sort_mO3(data2, N);
                    long time3 = nt3.calc();
                    r3 = r3+time3;
                }
                r3 = r3/testtime;
                System.out.println("quicksort runs " + r3 + " ns, cutoff = " + N);
                System.out.println();
//            }
        }
    }
}
