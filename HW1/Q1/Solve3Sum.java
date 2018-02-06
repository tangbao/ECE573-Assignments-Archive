
import java.util.Collections;
import java.util.List;

import static java.util.Collections.binarySearch;

public class Solve3Sum {

/*
    The "naive" implementation (O(N^3))
 */

    public void naive3Sum(List<Integer> data){
        NanoTimer nt = new NanoTimer();
        int cnt = 0;
        int length = data.size();
        for(int i = 0; i<length; i++ ){
            for(int j = i+1; j<length; j++){
                for (int k = j+1; k<length; k++){
                    if(data.get(i) + data.get(j) + data.get(k) == 0){
                        cnt++;
                    }
                }
            }
        }

        long time = nt.calc();
        System.out.println("The time is " + time + " ns");
        System.out.println("The result of naive 3-sum is "+cnt);
    }

/*
    The "sophisticated" implementation (O(N^2 lg N))
    Suppose that the numbers are distinct.
 */

    public void optim3Sum(List<Integer> data){
        NanoTimer nt = new NanoTimer();
        int cnt = 0;
        int length = data.size();
        Collections.sort(data); //MergeSort, O(nlgn)
        for(int i=0; i<length;i++){
            for (int j=i+1;j<length;j++){
                int index = binarySearch(data, -(data.get(i)+data.get(j)));
                if(index>j)
                    cnt++;
            }
        }

        long time = nt.calc();
        System.out.println("The time is " + time + " ns");
        System.out.println("The result of optimized 3-sum is "+cnt);
    }
}
