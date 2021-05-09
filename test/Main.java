import java.io.*;
import java.util.*;

    public class Main {
        public static boolean pallindrome(String ros){
            int i = 0;
            int j = ros.length()-1;
            
            while(i<=j){
                char ich = ros.charAt(i);
                char jch = ros.charAt(j);
                if(ich != jch) return false;
                i++;
                j--;
            }
        return true;
    }

	public static void solution(String str){
		for(int i=0; i<str.length(); i++){
		    for(int j=i+1; j<=str.length(); j++){
		        String ros = str.substring(i,j);
		        if(pallindrome(ros))
		            System.out.println(ros);
		    }
		}
	}

    public static void print2D(){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
         
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = scn.nextInt();
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void waveTraverse(int[][] arr){
        for(int j=0; j<arr[0].length; j++){
            if(j%2 == 0){
                for(int i=0; i<arr.length; i++)
                    System.out.println(arr[i][j]);
            }else{
                for(int i=arr.length-1; i>=0; i--)
                    System.out.println(arr[i][j]);
            }
        }
    }

    public static void spiral(int[][] arr){
        int minc = 0;
        int minr = 0;
        int maxc = arr[0].length-1;
        int maxr = arr.length-1;
        int tne = arr.length * arr[0].length;
        int count = 0;

        while(count<tne){
            // left wall
            for(int j=minc, i=minr; i<=maxr && count<tne; i++){
                System.out.println(arr[i][j]);
                count++;
            }
            minc++;

            //bottom wall
            for(int i=maxr, j=minc; j<=maxc && count<tne; j++){
                System.out.println(arr[i][j]);
                count++;
            }
            maxr--;

            // right wall
            for(int j=maxc, i=maxr; i>=minr && count<tne; i--){
                System.out.println(arr[i][j]);
                count++;
            }
            maxc--;

            // top wall
            for(int i=minr, j=maxc; j>=minc && count<tne; j--){
                System.out.println(arr[i][j]);
                count++;
            }
            minr++;
        }
    }

    public static void diagonalTraverse(int[][] arr){
        for(int g=0; g<arr.length; g++){
            for(int i=0, j=g; j<arr.length; i++, j++){
                System.out.println(arr[i][j]);
            }
        }
    }

    public static void sadlePrice(int[][] arr){
        for(int i=0; i<arr.length; i++){
            int svj = 0;
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j] < arr[i][svj])
                    svj = j;
            }

            boolean flag = true;
            for(int k=0; k<arr.length; k++){
                if(arr[k][svj] > arr[i][svj]){
                    flag = false;
                    break;
                }
            }

            if(flag){
                System.out.println(arr[i][svj]);
                return;
            }
        }
        System.out.println("Invalid Input");
    }


	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
         
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = scn.nextInt();
            }
        }

        // String str = scn.next();
        // solution(str);
	}

}