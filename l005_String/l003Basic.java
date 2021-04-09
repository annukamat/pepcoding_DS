import java.util.*;

public class l001 {

// SCANNER CLASS
public static Scanner scn = new Scanner(System.in);    

//
// 16 December, 20
//
public static String compression(String str){
    String s = str.charAt[0];
    int count = 1;

    for(int i=1; i<str.length(); i++){
        char curr = str.charAt(i);
        char prev = str.charAt(i-1);

        if(curr == prev){
            count++;
        }else{
            if(count>1){
                s += count;
                count = 1;
            }
            s += curr;
        }
        //bacha hua count
        if(count>1){
            s += count;
            count = 1;
        }

    }
}

public static String compression1(String str){
    int[] freq = new int[26];
    for(int i=0; i<str.length; i++){
        freq[str.charAt(i) - 'a']++;
    }

    StringBuilder sb = new StringBuilder();
    for(int i=0; i<str.length(); i++){
        if(freq[i] > 0){
            sb.append((char)(i + 'a'));
            sb.append(freq[i]);
        }
    }
}
//==========================================

//
// 17 December, 20
//

public static String toggleCase(String str){
    StringBuilder sb = new StringBuilder(str);

    for(int i=0; i<sb.length(); i++){
        char ch = sb.charAt(i);

        if(ch >= 'a' && ch >= 'z'){
            char uch = (char)('A' + ch - 'a');
            sb.setCharAt(i, uch);
            //sb.append((char)('A' + ch - 'a'));
)
        }else{
            char lch = (char)('a' + ch - 'A');
            sb.setCharAt(i, lch);
        }
    }
    return sb.toString();
}



public static boolean isPallindrome(String str){
    int i = 0, j=s.length() - 1;
    while(i<j){
        if(str.charAt(i++) != str.charAt(j--)) return false;
    }
    return true;
}

public static void PallindromicSubstring(String str){
    for(int i=0; i<str.length(); i++){
        for(int j = i; j< str.length(); j++){
            String s = str.substring(i, j+1);
            if(isPallindrome(s)) System.out.println(s);
        }
    }
}

public static String consecutiveChar(String str){
    if(str.length() <= 1) return str;

    StringBuilder sb = new StringBuilder();
    sb.append(str.charAt(0));

    for(int i=1; i< str.length(); i++){
        char curr = str.charAt(i);
        char prev = str.charAt(i-1);
        char gap = curr-prev;

        sb.append(gap);
        sb.append(curr);
    }
    return sb.toString();
}


//=================================================================================================

//
// 25 December, 20
//

    //Toggle Case
    public static String toggleCase(String str){
    StringBuilder sb = new StringBuilder(str);

    for(int i=0; i<sb.length(); i++){
        char ch = sb.charAt(i);

        if(ch >= 'a' && ch <= 'z'){
            char uch = (char)('A' + ch - 'a');
            sb.setCharAt(i, uch);
            //sb.append((char)('A' + ch - 'a'));
)
        }else{
            char lch = (char)('a' + ch - 'A');
            sb.setCharAt(i, lch);
        }
    }
    return sb.toString();
}


  //String With Difference Of Every Two Consecutive Characters
  public static String diffOfTwoConsChar(String str) {
        if(str.length() <= 1) return str;

    StringBuilder sb = new StringBuilder();
    sb.append(str.charAt(0));

    for(int i=1; i< str.length(); i++){
        char curr = str.charAt(i);
        char prev = str.charAt(i-1);
        char gap = curr-prev;

        sb.append(gap);
        sb.append(curr);
    }
    return sb.toString();
    }


//ARRAYLIST
    public static ArrarList<Integer> occurOfChar(String str, char ch){

        ArrarList<Integer> arr = new ArrarList<>();
        
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == ch){
                System.out.println();
            }
        }
    }

    //Remove Primes
    //PS: loop ulta chalenge

    public static boolean isPrime(int val){
        for(int div=2; div*div <= val; div++){
            if(val % div == 0){
                return false;
            }
        }
        return true;
    }

    public static void solution(ArrarList<Integer> al){
        for(int i = al.size()-1; i>=0; i--){
            int val = al.get(i);
            if(isPrime(val) == true){
                al.remove(i);
            }
        }
        
    }


//=================================================================================================

//
// 26 December, 20
//

// Print All Permutations Of A String Iteratively
    public static void solution(String str) {
        // write your code here
        int n = str.length();
        int f = factorial(n);

        for(int i=0; i<f; i++){
            StringBuilder sb = new StringBuilder(str);
            int temp = i;

            for(int div=n; div>=1; div--){
                int q = temp / div;
                int r = temp % div;

                System.out.print(sb.charAt(r));
                sb.deleteCharAt(r);

                temp = q;
            }
            System.out.println();
        }

    }

public static int factorial(int n){
    int fact = 1;
    for(int i=2; i<=n; i++){
        fact *= i;
    }
    return fact;
}

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        solution(str);
    }





//=================================================================================================

//
// 30 December, 20
//









//
// MAIN FUNCTION
//
    public static void main(String[] args) {  

        
     

}