import java.io.*;
import java.util.*;

public class Main {

    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String str = scn.next();
        System.out.println(gss(scn.nextLine()));
    }

//
//  4 january, 21
//

    public static ArrayList < String > gss(String str) {
        if(str.length() == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("")
        }

        char ch = str.charAt(0);
        String ros = str.subString(1);



        Arraylist<String> smallAns = gss(ros);
        Arraylist<String> myAns = new ArrayList<>();

        for(String s: smallAns){
            myAns.add(s);
        }
        for(String s: smallAns){
            myAns.add(ch + s);
        }
        return myAns;
    }

}