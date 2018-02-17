/*
    To test if an ArrayList is sorted correctly.

    order = 1 for ascending order, = 0 for descending order

    Written by Zhongze Tang for DSA HW
 */

import java.util.List;

public class SortTest {
    public void check(List<Integer> list, int order){
        int length = list.size();
        if(order == 1){
            for(int i = 0; i<length-1; i++){
                if(list.get(i) > list.get(i+1)){
                    System.out.println("Not ascending order");
                    return;
                }
            }
            System.out.println("ascending order");
        }else if(order == 0){
            for(int i = 0; i<length-1; i++){
                if(list.get(i) < list.get(i+1)){
                    System.out.println("Not descending order");
                    return;
                }
            }
            System.out.println("descending order");
        }else{
            System.out.println("Error: Wrong order.");
        }
    }
}
