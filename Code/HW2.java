/**
 * Created by Shaina Mainar on 7/8/2018.
 * HW2 Summer 2018
 * Count number of ones in binary representation of decimal number using recursion
 */
public class HW2 extends HW2_AbstractClass {

    @Override
    public int countOfOnes(int n) {
        //base case if n = 0 or 1, because they are the digits of the first bit
        if(n < 2){
            return n;
        }
        else{
            int count = 0;
            //test even
            if(n%2 == 0){
                return count + countOfOnes(n/2);
            }
            //test odd
            else{
                return count + countOfOnes(n/2) + 1;
            }
        }

    }
    public static void main(String[] args) {
        HW2 hw2 = new HW2();
        int[] array = new int[] {44,22,11,5,2,1,33,16,18,0,100,99};
        for(int i = 0; i < array.length; i++){
            int count = hw2.countOfOnes(array[i]);
            System.out.println("Number of ones in " + array[i] + " is " + count);
        }
    }
}
