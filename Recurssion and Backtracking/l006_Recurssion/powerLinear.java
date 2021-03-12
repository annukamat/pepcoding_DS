// Power-linear

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        int a = scn.nextInt();
        int b = scn.nextInt();
        
        power(a, b);
    }

    public static int power(int a, int b){
    return b == 0 ? 1 : a * power(a, b - 1);
    }

    public static int powerBtr(int a, int b){
    if (b == 0)
        return 1;
    int smallAns = powerBtr(a, b / 2);
    smallAns *= smallAns;
    return b % 2 == 0 ? smallAns : smallAns * a;
    }

}