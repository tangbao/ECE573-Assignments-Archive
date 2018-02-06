import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String args[]){
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

        //make sure the input is sorted
        Collections.sort(data);

        //test data
        System.out.println("The data:");
        for(int i:data)
            System.out.print(i+" ");

        NanoTimer nt = new NanoTimer();
        int length = data.size();
        int cnt = 0;
        for(int i = 0; i<length - 2; i++){
            int start = i+1;
            int end = length - 1;
            while(start < end){
                int sum = data.get(i) + data.get(start) + data.get(end);
                if(sum == 0){
                    //cnt++;
                    //Suppose that there can be duplicate triplets in result.
                    int start_offset = 1;
                    int end_offset = 1;
                    while(start+start_offset<end && data.get(start+start_offset).equals(data.get(start))){
                        start_offset++;
                    }
                    while(end-end_offset>start && data.get(end-end_offset).equals(data.get(end))){
                        end_offset++;
                    }
                    cnt = cnt + start_offset*end_offset;
                    start = start + start_offset;
                    end = end - end_offset;
                }else if(sum<0) {
                    //too small
                    start++;
                }else{
                    //too large
                    end--;
                }
            }
        }

        long time = nt.calc();
        System.out.println("The time is "+time+" ns");
        System.out.println("The result of 3-sum is "+cnt);
    }
}
