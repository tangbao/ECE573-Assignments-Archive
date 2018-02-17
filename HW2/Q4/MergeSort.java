/*
    A basic mergesort for Q2
 */

import java.util.List;

public class MergeSort {

    public void topdown(List<Integer> list){
        int start = 0;
        int end = list.size();
        int mid = start + (end - start)/2;
        td(list, start, end);
        merge(list, start, mid, end);
    }

    private void td(List<Integer> list, int start, int end){
        if(end - start == 0){
            return;
        }else if(end - start == 1){
            if(list.get(start) > list.get(end)){
                int temp = list.get(start);
                list.set(start, list.get(end));
                list.set(end, temp);
            }
            return;
        }

        int mid = start + (end - start)/2;
        td(list, start, mid);
        td(list, mid+1, end);
        merge(list, start, mid, end);
    }

    private void merge(List<Integer> list, int start, int mid, int end){
        int left = start;
        int right = mid+1;
        while(left<=mid && right <= end){
            if(list.get(left)>list.get(right)){
                
            }
        }
    }

    public void bottomup(List<Integer> list){

    }

}
