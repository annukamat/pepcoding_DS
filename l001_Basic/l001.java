import java.util.*;

public class l001 {

// SCANNER CLASS
public static Scanner scn = new Scanner(System.in);    

//   
// 29 November, 20 -
//
    public static void printHello() {
        System.out.println("Hiiii!");
    }

    public static void workWithDataTpes() {
        int a = 10;

        System.out.println("value of a =>" + a);
    }
//
// 1 December, 20 -
//
    public static void printFibonacci(int n){
        int a = 0, b = 1;

        for(int i=1; i<=n; i++){
            System.out.println(a);

            int sum = a+b;
            a=b;
            b=sum;
        }
    }

    public static void countDig(int n){
        int dig = 0;
        int num = n;

        while(num != 0){
            num /= 10;
            dig++;
        }
         System.out.println(dig);
    }

    public static void digitsOfNum(int n){
        //calclate no. of digits
        countDig();

        //make diviser(10 to the power)
        int div = (int)Math.power(10, dig-1);

        //divide by diviser get no.
        while(div != 0){
            int q = n/div;
            System.out.println(q);

            n = n % div;
            div = div/10;
        } 
    }

//
// 6 December, 20
//

// Digit Frequency
public static void digitFreq(int n, int d){
        int rv = 0;
        while(n>0){
            int dig = n%10;
            n = n/10;

            if(dig == d){
                rv++;
            }
        }
        return rv; 
}

// Sum of two arrays
 public static void sumOfTwoArray(int[] a1, int[]a2, int n1, int n2){
        
    int[] sum = new int[n1>n2 ? n1: n2];
    int c = 0;

    int i = a1.length - 1;
    int j = a2.length - 1;
    int k = sum.length - 1;

    while(k >= 0){
        int d = c;

        if(i>=0){
            d += a1[i];
        }
        if(j>=0){
            d += a2[j];
        }

        c = d/10;
        d = d%10;

        sum[k] = d;

        i--;
        j--;
        k--;
    }

    if(c != 0){
        System.out.println(c);
    }

    for(int val: sum){
        System.out.println(val);
    }
    }

//
// MAIN FUNCTION
//
    public static void main(String[] args) {

        printHello();

        //
        // 6 December, 20
        //
        int n = nextInt();
        int r = nextInt();

        int nFact = fact(n);
        int nmrFact = fact(n-r);

        int npr = nFact/nmrFact;

        System.out.println(npr);
    }

    // Sum of two arrays
    int n1 = scn.nextInt();
    int[] a1 = new int[n1];
    for(int i=0; i<a1.length; i++){
        a1[i] = scn.nextInt();
    }

    int n2 = scn.nextInt();
    int[] a2 = new int[n2];
    for(int i=0; i<a2.length; i++){
        a2[i] = scn.nextInt();
    }
    
    sumOfTwoArray(a1, a2, n1, n2);




}