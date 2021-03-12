import java.util.*;

public class l001 {

// SCANNER CLASS
public static Scanner scn = new Scanner(System.in);    


//
// 4 December, 20
//

public static void tes1(){
    int[] arr = new int[10];
    for(int i=0; i<20; i++){
        System.out.println(arr[i] + " ");
    }
}

public static void test2(){
        int n; 
        int n = scn.nextInt();
        int[] arr = new arr[n];
        for(int i=0; i<arr.length(); i++){
        arr[i] = scn.nextInt();
    }

    for(int i=0; i<arr.size(); i++){
        System.out.println(arr[i] + " ");
    }
}

//Basic Question=================================

public static int maxEle(int[] arr){
    int max = -1e8;
    for(int i=0; i<arr.length; i++){
        if(arr[i] > max){
            max = arr[i];
        }
    }
    return max;
}

public static int minEle(int[] arr){
    int min = 1e8;
    for(int i=0; i<arr.length; i++){
        if(arr[i] < min){
            min = arr[i];
        }
    }
    return min;
}

public static int findEle(int[] arr, int data){
    int idx = -1;
    for(int i=0; i<arr.length; i++){
        if(arr[i] == data){
            idx = i;
            break;
        }
    }
    return idx;
}

public static int firstIndex(int[] arr, data){
    int idx = -1;
    for(int i=0; i<arr.length; i++){
        if(arr[i] == data){
            idx = i;
            break;
        }
    }
    return idx;
}

public static int lastIndex(int[] arr, data){
    int idx = -1;
    for(int i=arr.length-1; i>=0; i--){
        if(arr[i] == data){
            idx = i;
            break;
        }
    }
    return idx;
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

// Difference of two arrays - 
public static void diffOfTwoArray(int n1, int n2, int[] a1, int[] a2){
    int[] diff = new int[n2];
    int c = 0;

    // pointers
    int i = a1.length-1;
    int j = a2.length-1;
    int k = diff.length-1;

    while(k>=0){
        int d = 0;
        a1v = i >= 0 ? a1[i] : 0;

        if(a2[j] >= a1v){
            d = a2[j] - a1v;
            c = 0;
        }else{
            d = a2[j] + c + 10 - a1v;
            c = -1;
        }

        diff[k] = d;
        i--;
        j--;
        k--;
    }

    
        int idx = 0;
        while(idx < diff.length){
            if(diff[idx] == 0){
                idx++;
            }else{
                break;
            }
        }

        while(idx < diff.length){
            System.out.println(diff[idx]);
            idx++;
        }
    
}

// Reverse an array -
public static void reverse(int[] a){
    // write your code here
    int i = 0;
    int j = a.length-1;
    
    while(i<j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        
        i++;
        j--;
    }
}

//Rotate an array -
  public static void reverse(int[] a, int i, int j){
      while(i<j){
          int temp = a[i];
          a[i] = a[j];
          a[j] = temp;
          i++;
          j--;
      }
  }

  public static void rotate(int[] a, int k){
    int n = a.length;
    k = k%n;
    
    if(k<0){
        k += n;
    }
    
    //reverse p1
    reverse(a, 0, n-k-1);
    
    //reverse p2
    reverse(a, n-k, n-1);
    
    //reverse all
    reverse(a, 0, n-1);
  }

//
// 8 December, 20
//

//Inverse of an array - 
public static int[] inverse(int[] a){
    int[] inv = new int[a.length];

    for(int i=0; i<a.length; i++){
        int v = a[i];
        inv[v] = i;
    } 
    return inv;
}

//
// MAIN FUNCTION
//
    public static void main(String[] args) {

        //
        // 4 December, 20
        //   
        
        //findEle
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<arr.length; i++){
        arr[i] = scn.nextInt();
        }
        int d = scn.nextInt();

        System.out.println(findEle(arr, d));     

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

        //Difference of two arrays
        
        int n1 = nextInt();
        int[] a1 = new int[n1];
        for(int i=0; i<a1.length; i++){
            a1[i] = scn.nextInt();
        }

        int n2 = nextInt();
        int[] a2 = new int[n2];
        for(int i=0; i<a2.length; i++){
            a2[j] = scn.nextInt();
        }

        diffOfTwoArray(n1, n2, a1, a2);

}