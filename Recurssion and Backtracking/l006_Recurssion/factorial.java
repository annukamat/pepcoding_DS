// Factorial

import java.io.*;
import java.util.*;

public class Main {

    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = scn.nextInt();
        System.out.println(factorial(n));
    }

    public static int factorial(int n) {
        if (n == 0)
        return 1;

        int ans = factorial(n - 1);
        return ans * n;
    }

// Alternate -
    public static int factorial2(int n) {
        return n == 0 ? 1 : factorial2(n - 1) * n;
    }

}