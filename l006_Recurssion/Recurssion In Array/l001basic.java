import java.io.*;
import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    // MAIN FUNCTION
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }

        int max = maxOfArray(arr, 0);
        System.out.println(max);
    }

    // Display Array
    public static void main(String[] args) throws Exception {
        // write your code here
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }
        
        displayArr(arr, 0);
    }

    public static void displayArr(int[] arr, int idx) {
        if(idx == arr.length) return;

        System.out.println(arr[idx]);
        displayArr(arr, idx+1);
    }

    //display Array Reverse
    public static void displayArrReverse(int[] arr, int idx) {
        if(idx == arr.length) return;

        displayArrReverse(arr, idx+1);
        System.out.println(arr[idx]);
    }

    // Max Of Array
    public static int maxOfArray(int[] arr, int idx) {
        if(idx == arr.length) return -(int)1e9;
        int misa = maxOfArray(arr, idx+1);
        
        return Math.max(arr[idx], misa);
    }

}

    //Min of array
    public static int minOfArray(int[] arr, int idx) {
        if(idx == arr.length) return (int)1e9;
        int misa = minOfArray(arr, idx+1);
        return Math.min(arr[idx], misa);
    }


    // Find Data
    public static boolean findData(arr[], int idx, int data){
        if(idx == arr.length) return false;
        if(arr[idx] == data) return true;
        return findData(arr, idx+1, data);
    }

    // First Index
    public static int firstIndex(arr[], int idx, int data){
        if(idx == arr.length) return -1;
        if(arr[idx] == data) return idx;
        return findData(arr, idx+1, data);
    }

    // Last Index
        public static int lastIndex(arr[], int idx, int data){
        if(idx == -1) return -1;
        if(arr[idx] == data) return idx;
        return lastIndex(arr, idx-1, data);
    }
    //alt-using 0 index
        public static int lastIndex(int[] arr, int idx, int x) {
        if(idx == arr.length) return -1;

        int liisa = lastIndex(arr, idx+1, x);
        if(liisa == -1){
            if(arr[idx] == x){
                return idx;
            }else{
                return -1;
            }
        }else{
            return liisa;
        }
    }

    //all indices - Return an array of appropriate size which contains all indices at which x occurs in array a.
        public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
        
        }

}