import java.util.Random;
import java.util.Scanner;
public class HW1 extends  HW1_AbstractClass{

    //Use simple selection sort for this one.
    @Override
    public int selection1(int N) {
        //create random values of N length
        int[] a = new int[N];
        int K = N/2;
        Random rand = new Random();
        for (int i = 0; i < N; ++i) {
            int val = rand.nextInt(200);
            a[i] = val;
        }
        //sort
        int k;
        for (int m = N; m >= 0; m--) {
            for (int i = 0; i < N - 1; i++) {
                k = i + 1;
                if (a[i] < a[k]) {
                    int temp;
                    temp = a[i];
                    a[i] = a[k];
                    a[k] = temp;
                }
            }
        }
        //test

/*        System.out.println("Your array is:");
        for(int i = 0; i < N; ++i){
            System.out.print(a[i] + " ");
        }*/


        System.out.println();
        return a[K -1];
    }

    @Override
    public int selection2(int N) {
        //create array with k values
        int K = N / 2;
        int[] a = new int[K];
        Random rand = new Random();
        for (int i = 0; i < K; ++i) {
            int val = rand.nextInt(200);
            a[i] = val;
        }

        int k;
        for (int m = K; m >= 0; m--) {
            for (int i = 0; i < K - 1; i++) {
                k = i + 1;
                if (a[i] < a[k]) {
                    int temp;
                    temp = a[i];
                    a[i] = a[k];
                    a[k] = temp;

                }
            }
        }

        //sorting after comparing k with next element
        for (int next = K; next < N; next++) {
            int val = rand.nextInt(200);
            if ( val >= a[K-1]) {
                a[K-1] = val;
                for(int i=0; i < K; i++){
                    if(a[K-1] > a[K-i-1]){
                        int temp1;
                        temp1 = a[K-1];
                        a[K-1] = a[K-i-1];
                        a[K-i-1] = temp1;
                    }

                }
            }

        }



            //test
            System.out.println();
//           System.out.println("Your new array is:");
//            for (int i = 0; i < K; ++i) {
//            System.out.print(a[i] + " ");
        //}
            System.out.println();

            return a[K - 1];

        }


    public static void main(String[] args){
        //testing the two selection algs.
        HW1 hw1 = new HW1();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int in = sc.nextInt();
        sc.close();
        long start1 = System.currentTimeMillis();
        int k1 = hw1.selection1(in);
        long end1 = System.currentTimeMillis();
        System.out.println("Selection 1 kth element = " + k1);
        System.out.println("Selection 1 time duration = " + (end1 - start1) + " millisecs");
        long start2 = System.currentTimeMillis();
        int k2 = hw1.selection2(in);
        long end2 = System.currentTimeMillis();
        System.out.println("Selection 2 kth element = " + k2);
        System.out.println("Selection 2 time duration = " + (end2 - start2) + " millisecs");
    }

}

