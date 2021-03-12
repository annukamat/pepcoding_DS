import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printKPC(str, "", 0);
    }
    
    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs","tu", "vwx", "yz"};

    // WAY UP APPROACH
    public static void printKPC(String str, String ans, int idx) {
        //BC
        if(idx == str.length()){
            System.out.println(ans);
            return;
        }
        
        char ch = str.charAt(idx);
        String code = codes[ch - '0'];
        
        for(int i=0; i<code.length(); i++){
            char c = code.charAt(i);
            printKPC(str, ans + c, idx+1);
        }
        
    }

    // RETURN TYPE WITH ARRAYLIST
    public static ArrayList <String> getKPC(String str, int idx){
        //BC


        ArrayList<String> recAns = getKPC(str, idx+1);
        ArrayList<String> myAns = new ArrayList<>();

        char ch = str.charAt(idx);
        String code = codes[ch - '0'];
        
        for(int i=0; i<code.length(); i++){
            char c = code.charAt(i);

            for(String s: recAns){
                myAns.add(c + s)
            }
        }
    }
    return myAns;

}