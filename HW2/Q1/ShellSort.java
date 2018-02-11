/*
    gaps[] store the sequence for ShellSort
    order = 1 => ascending order
    order = 0 => descending order

    when gaps = {1}, it's an insertion sort.
 */

import java.util.List;

public class ShellSort{
    public void sort(List<Integer> list, int[] gaps, int order){
        int length = list.size();
        int cnt = 0;
        if(order == 1){
            for(int gap:gaps){
                for(int i = gap; i<length; i++){
                    for(int j = i-gap; j>=gap;j=j-gap){
                        if (list.get(j)<list.get(j-gap)){
                            cnt++;
                            int temp = list.get(j);
                            list.set(j, list.get(j-gap));
                            list.set(j-gap, temp);
                        }
                    }
                    cnt++;
                }
            }
            System.out.println("Compare "+cnt+" times");
        }else if(order == 0){
            for(int gap: gaps){
                    for(int i = gap; i<length; i++){
                        for(int j = i-gap; j>=gap;j=j-gap){
                            if (list.get(j)>list.get(j-gap)){
                                cnt++;
                                int temp = list.get(j);
                                list.set(j, list.get(j-gap));
                                list.set(j-gap, temp);
                            }
                        }
                        cnt++;
                    }
                }
            System.out.println("Compare "+cnt+" times");
        }else{
            System.out.println("Error: Wrong order.");
        }
    }
}
