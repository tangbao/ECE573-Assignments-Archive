
import java.io.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private static final int RANGE_OF_N = 10000;
    private static final int TRIAL_NUM = 1000;

    public static void main(String[] args) {
        RedBlackBST<Integer, Integer> st;
        double[] aveLenRes = new double[RANGE_OF_N];
        double[] stdDevRes = new double[RANGE_OF_N];
        for(int num=1;num<=RANGE_OF_N;num++){
            System.out.println("Now N = " + num);
            double[] aves = new double[TRIAL_NUM];
            for(int i=0;i<TRIAL_NUM;i++){
                st = getRandomInput(num);
                double res = st.getQ4Res();
                aveLenRes[num-1] += res;
                aves[i] = res;
            }
            aveLenRes[num-1] = aveLenRes[num-1] / (TRIAL_NUM);

            double dev = 0.0;
            for (int i=0;i<TRIAL_NUM;i++){
                double diff = aves[i] - aveLenRes[num-1];
                dev = dev + diff * diff;
            }
            dev = Math.sqrt(dev/(TRIAL_NUM*1.0-1.0));
            stdDevRes[num-1] = dev;

            try {
                File csv = new File("result.csv");
                BufferedWriter bw = new BufferedWriter(new FileWriter(csv,true));
                bw.write(num +","+aveLenRes[num-1]+","+stdDevRes[num-1]);
                bw.newLine();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(e.toString());
            }

        }


        for(int i=0;i<RANGE_OF_N;i++){
            System.out.println("N = " + (i+1) + ", "
                                + "ave len is "+ aveLenRes[i] + ", "
                                + "std deviation is "+ stdDevRes[i]);
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
