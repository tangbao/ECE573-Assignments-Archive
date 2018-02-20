import java.util.List;

public class CountingSort {

    /*
        A simple version of counting sort
        which can only sort the dataset of this question
     */

    public void sort(List<Integer> list){
        int[] cnt = new int[]{0, 0, 0, 0};
        int length = list.size();
        for(int i = 0;i<length;i++){
            if(list.get(i) == 1){
                cnt[0]++;
            }else if (list.get(i) == 11){
                cnt[1]++;
            }else if(list.get(i) == 111){
                cnt[2]++;
            }else if(list.get(i) == 1111){
                cnt[3]++;
            }
        }

        int cnt1 = cnt[0];
        int cnt2 = cnt1 + cnt[1];
        int cnt3 = cnt2 + cnt[2];

        for (int i = 0;i<cnt1;i++){
            list.set(i, 1);
        }
        for(int i = cnt1;i<cnt2;i++){
            list.set(i, 11);
        }
        for (int i = cnt2;i<cnt3;i++){
            list.set(i, 111);
        }
        for (int i = cnt3; i<length;i++){
            list.set(i, 1111);
        }

//        for(int i = 0;i<4;i++){
//            System.out.println(cnt[i]);
//        }
    }

}
