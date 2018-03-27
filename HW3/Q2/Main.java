import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    private final static int TRAIL_NUM = 100;

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192};

        for(int num:nums){
            double avelen1 = 0.0;
            double avelen2 = 0.0;
            for(int i = 0; i<TRAIL_NUM; i++){
                TwoThreeTree<Integer, Integer> ttt1 = getOrderedInput(num);
                avelen1 += ttt1.getLenSumWithoutRed() * 1.0 / num;
                TwoThreeTree<Integer, Integer> ttt2 = getRandomInput(num);
                avelen2 += ttt2.getLenSumWithoutRed() * 1.0 / num;
            }
            avelen1 = avelen1/TRAIL_NUM;
            avelen2 = avelen2/TRAIL_NUM;
            System.out.println("Number of nodes = " + num);
            System.out.println("The ave len of ordered input = "+avelen1);
            System.out.println("The ave len of random input = "+avelen2);
        }
    }


    private static TwoThreeTree<Integer, Integer> getOrderedInput(int num){
        TwoThreeTree<Integer, Integer> r = new TwoThreeTree<>();
        for(int i=0;i<num;i++){
            r.put(i, i);
        }
        return r;
    }

    /*
        A function to get %num% random inputs
    */
    private static TwoThreeTree<Integer, Integer> getRandomInput(int num){
        TwoThreeTree<Integer, Integer> r = new TwoThreeTree<>();
        int[] inputs = new int[num];
        for(int i=0;i<num;i++){
            inputs[i] = i;
        }
        shuffle(inputs);
        for (int i=0;i<num;i++){
            r.put(inputs[i], i);
        }
        return r;
    }

    private static void shuffle(int[] ar){
        /*
            See
            https://stackoverflow.com/questions/1519736/random-shuffling-of-an-array
         */
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

}
