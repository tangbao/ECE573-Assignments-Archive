import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
//  Old version
//        //read in N and array a[N]
//        int N = 0;
//        Scanner scanner = new Scanner(System.in);
//        while(N<=0){
//            System.out.println("Please enter the number of array:");
//            N = scanner.nextInt();
//        }
//
//        System.out.println("Please enter the elements in array:");
//        double[] a = new double[N];
//        for(int i=0; i<N; i++){
//            a[i] = scanner.nextDouble();
//        }

        DataReader dataReader = new DataReader();
        List<Double> data = new ArrayList<>();

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

        NanoTimer nt = new NanoTimer();
        int N = data.size();
        //find the max absolute value
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;

        for(int i = 0; i<N; i++){
            if(data.get(i) > max){
                max = data.get(i);
            }
            if(data.get(i)<min){
                min = data.get(i);
            }
        }

        double diff = max - min;
        long time = nt.calc();
        System.out.println("The time is: "+time+" ns.");
        System.out.println("The max absolute difference is: " + diff);
        System.out.println("The pair is " + max+ " and " + min);
    }
}
