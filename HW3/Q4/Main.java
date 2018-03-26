
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private static int RANGE_OF_N = 4719;
    private static int TRIAL_NUM = 10;

    public static void main(String[] args) {
        RedBlackBST<Integer, Integer> st;
        double[] aveLenRes = new double[RANGE_OF_N];
        double[] stdDevRes = new double[RANGE_OF_N];
        for(int num=1;num<=1;num++){
            double aveLength = 0.0;
            double stdDeviation = 0.0;
            for(int i=0;i<TRIAL_NUM;i++){
                st = getRandomInput(8896);
                System.out.println(st.getInternalPathLen()*1.0/8896);
            }

//            aveLenRes[num-1] = aveLength;
        }
//        for(int i=0;i<RANGE_OF_N;i++){
//            System.out.println("N = " + (i+1) + ", "
//                                + "ave len is "+ aveLenRes[i]
//                                + "std deviation is "+ stdDevRes[i]);
//        }
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
        int num = ar.length - 1;
        for (int i = num; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}
