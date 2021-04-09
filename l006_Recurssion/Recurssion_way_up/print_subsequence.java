import java.io.*;
import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        String str = scn.nextLine();
        printSS(str, "");
        printSS(str, 0, "");
    }
    
    //WAY-UP APPROACH
        public static void printSS(String str, int idx, String ans) {
        if (idx == str.length()) {
            System.out.println(ans);
            return;
        }

        printSS(str, idx + 1, ans + str.charAt(idx));
        printSS(str, idx + 1, ans);
    }

        public static void printSS_02(String str, int idx, StringBuilder ans) {
        if (idx == str.length()) {
            System.out.println(ans);
            return;
        }

        ans.append(str.charAt(idx));
        printSS_02(str, idx + 1, ans);
        ans.deleteCharAt(ans.length() - 1);

        printSS_02(str, idx + 1, ans);
    }

     // return Type
    public static ArrayList<String> subseq_03(String str, int idx) {
        if (idx == str.length()) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> recAns = subseq_03(str, idx + 1);

        ArrayList<String> myAns = new ArrayList<>(recAns); // nahi anne ki choise dekhli.

        char ch = str.charAt(idx);
        for (String s : recAns) {
            myAns.add(ch + s);
        }

        return myAns;
    }

    // public static void printSS(String str, String s_str) {
    //     if(str.length() == 0){
    //         System.out.println(s_str);
    //         return;
    //     }

    //     char ch = str.charAt(0);
    //     String ros = str.substring(1);

    //     printSS(ros, s_str + ch);
    //     printSS(ros, s_str + "");
    // }

}