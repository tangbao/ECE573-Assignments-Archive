import java.util.List;

public class QuickSort {

    private int cutoff;

    /*
        No random shuffle
     */

    public void sort_mO3(List<Integer> list, int co){
        cutoff = co;
        sort(list,0, list.size()-1);
    }

    private void sort(List<Integer> list, int lo, int hi){
        /*
            From slides advanced-sorting-s18.pdf P.71
         */

        if (hi <= lo)
            return;

        if(hi-lo<=cutoff){
            InsertionSort.sort(list,lo,hi);
            return;
        }

        int m = medianOf3(list, lo, hi);
        swap(list, lo, m);

        int j = partition(list, lo, hi);
        sort(list, lo, j-1);
        sort(list, j+1, hi);
    }

    private int partition(List<Integer> list, int lo, int hi){
        /*
            From slides advanced-sorting-s18.pdf, P56
         */

        int i = lo, j = hi+1;
        while (true)
        {
            while(list.get(++i)<list.get(lo))
                if (i == hi) break;
            while(list.get(lo)<list.get(--j))
                if (j == lo) break;
            if (i >= j) break;
            swap(list, i, j);
        }
        swap(list, lo, j);
        return j;
    }

    private int medianOf3(List<Integer> list, int lo, int hi){
        /*
            See https://stackoverflow.com/questions/7559608/median-of-three-values-strategy
            Answer 2, python implementation
         */

        int mid = lo + (hi-lo)/2;
        if(list.get(hi)<list.get(lo)){
            swap(list,lo,hi);
        }
        if(list.get(mid)<list.get(lo)){
            swap(list,mid,lo);
        }
        if(list.get(hi)<list.get(mid)){
            swap(list,hi,mid);
        }

        return mid;

    }

    private void swap(List<Integer> list, int a, int b){
        int temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }
}
