import java.util.List;

public class InsertionSort {
    public static void sort(List<Integer> list, int lo, int hi){
        for(int i = lo; i<hi;i++){
            for(int j = i+1;j>lo;j--){
                if(list.get(j-1) <= list.get(j)){
                    break;
                }else{
                    int temp = list.get(j);
                    list.set(j, list.get(j-1));
                    list.set(j-1, temp);
                }
            }
        }
    }
}
