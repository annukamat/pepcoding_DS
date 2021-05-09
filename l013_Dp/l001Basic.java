public class l001Basic {


    public static void print(int[] arr){
        for(int ele: arr){
            System.out.print(ele + " ");
        System.out.println();
        }
    }

    public static void print2D(int[][] arr) {
        for (int[] a : arr) {
            print(a);
        }

        System.out.println();
    }

    // fibo


    // climbing stairs
    public static int climbStairs_memo(int n, int[] dp){
        if(n <= 1) return 1;

        

    }









    public static void main(String[] args) {
        climbStairs();
    }

}
