
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        RedBlackBST<Integer, Integer> st;
        int[] N_nums = {10000, 100000, 1000000};
        for(int Nnum:N_nums){
            double perc = 0.0;
            for(int i=0;i<100;i++){
                st = getRandomInput(Nnum);
                perc = perc + st.getNumOfRedNodes() * 1.0 / Nnum;
            }
            perc = perc/100;
            System.out.println("Result of "+Nnum+" is: "+perc);
        }
    }


    /*
        A function to get %num% random inputs
     */
    private static RedBlackBST<Integer, Integer> getRandomInput(int num){
        RedBlackBST<Integer, Integer> r = new RedBlackBST<>();
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
