import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        //read in N and array a[N]
        int N = 0;
        Scanner scanner = new Scanner(System.in);
        while(N<=0){
            System.out.println("Please enter the number of array:");
            N = scanner.nextInt();
        }

        System.out.println("Please enter the elements in array:");
        double[] a = new double[N];
        for(int i=0; i<N; i++){
            a[i] = scanner.nextDouble();
        }

        //find the max absolute value
        int[] r = new int[2];
        double max = Double.MIN_VALUE;
        int left = 0;
        int right = N - 1;

        while(left < right){
            double diff = Math.abs(a[left] - a[right]);
            if(diff>max){
                r[0] = left;
                r[1] = right;
                max = diff;
            }
            left++;
            right--;
        }

        System.out.println("The max absolute difference is: " + max);
        System.out.println("The pair is " + a[r[0]] + " and " + a[r[1]]);
    }
}
