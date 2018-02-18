/*
    A basic mergesort for Q2
 */

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    private int cnt = 0;

    public void topdown(List<Integer> list){
        int start = 0;
        int end = list.size()-1;
        List<Integer> temp = new ArrayList<>(list);
        cnt = 0;
        sort(list, temp, start, end);
        System.out.println("The count is : "+cnt);
    }

    private void sort(List<Integer> list, List<Integer> temp, int start, int end){
        if(end - start <= 0){
            return;
        }

        int mid = start + (end - start)/2;
        sort(temp, list, start, mid);
        sort(temp, list, mid+1, end);
        merge(list, temp, start, mid, end);
    }

    private void merge(List<Integer> list, List<Integer> temp, int start, int mid, int end){
        int left = start;
        int right = mid+1;
        for(int i = start; i<= end; i++){
            cnt++;
            if(left>mid){
                list.set(i, temp.get(right++));
            }else if(right>end){
                list.set(i, temp.get(left++));
            }else if(temp.get(left) < temp.get(right)){
                list.set(i, temp.get(left++));
            }else {
                list.set(i, temp.get(right++));
            }
        }
    }

    public void bottomup(List<Integer> list){

    }

}
