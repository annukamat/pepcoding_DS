import java.util.*;

public class l001DTB {

// SCANNER CLASS
public static Scanner scn = new Scanner(System.in);    


//
// 15 December, 20
//
public static int decimalToBinary(int n){
    int res = 0, pow = 1;

    while(n != 0){
        int rem = n % 2;
        n /= 2;

        res += rem * pow;
        pow *= 10;
    }
    return res;
}

public static int decimalToAnyBase(int n, int b){
    long res = 0, pow = 1;

    while(n>0){
        int rem = n%b;
        n /= b;

        res += rem * pow;
        pow *= 10;
    }
    return res;
}

public static int anyBaseToDecimal(int n, int b){
    long res = 0, pow = 1;

    while(n>0){
        int rem = n%10;
        n /= 10;

        res += rem * pow;
        pow *= b;
    }
    return res;
}













//
// MAIN FUNCTION
//
    public static void main(String[] args) {

        //
        // 15 December, 20
        //

        //decimalToAnyBase
        int n = scn.nextInt();
        int b = scn.nextInt();

        System.out.println(decimalToAnyBase(n,b));
        

        
     

}