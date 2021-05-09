import java.util.Scanner;

public class basic {

    // fibonacci
    public static int fiboR(int n){
        if(n == 1 || n==0) return n;
        
        System.out.println("hello" + n);
        return fiboR(n-1) + fiboR(n-2);
    }

    public static int fiboMemo(int n, int[] dp){
        if(n == 1 || n==0) return n;

        if(dp[n] != 0){
            return dp[n];
        }
        
        System.out.println("hello" + n);
        int fibn = fiboMemo(n-1, dp) + fiboMemo(n-2, dp);
        dp[n] = fibn;

        return fibn;
    }

    // climbing stairs
    public static int climbStairs(int n){
        if(n == 0) return 1;

        if(n < 0) return 0;

        int stairs = climbStairs(n-1) + climbStairs(n-2) + climbStairs(n-3);

        return stairs;
    }

    public static int climbStairsMemo(int n, int[] dp){
        if(n == 0) return 1;

        if(n < 0) return 0;

        if(dp[n] != 0) return dp[n];

        int stairs = climbStairsMemo(n-1, dp) + climbStairsMemo(n-2, dp) + climbStairsMemo(n-3, dp);
        dp[n] = stairs;

        return stairs;
    }

    public static int climbStairsTab(int n, int[] dp){
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            if(i==1){
                dp[i] = dp[i-1];
            }else if(i==2) {
                dp[i] = dp[i-1] + dp[i-2];
            }else{
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
        }
        return dp[n];
    }

    // Climbing Stairs with variable Jumps
     public static int climbStairs_jumps(int n, int[] arr){
        int[] dp = new int[n+1];

        dp[n] = 1;
        for(int i=n-1; i>=0; i--){
            for(int j=1; j<=arr[i] && i+j < dp.length; j++){
                dp[i] += dp[i+j];
            }
        }
        return dp[0];
     }

     // Climbing Stairs with minimum variable Jumps
     public static int climbStairs_minJumps(int n, int[] arr){
        Integer[] dp = new Integer[n+1];

        dp[n] = 0;
        for(int i=n-1; i>=0; i--){
            if(arr[i] > 0){
            int min = Integer.MAX_VALUE;
                for(int j=1; j<=arr[i] && i+j < dp.length; j++){
                        if(dp[i+j] != null){
                        min = Math.min(min, dp[i+j]);
                        }
                }
                if(min != Integer.MAX_VALUE) dp[i] = min+1;
            }    
        }
        return dp[0];
     }

     // min cost in maze traversal
    public static int minCost_maze(int[][] arr, int[][] dp){
        
        for(int i=dp.length-1; i>=0; i--){
            for(int j=dp[0].length-1; j>=0; j--){
                if(i==dp.length-1 && j==dp[0].length-1){
                    dp[i][j] = arr[i][j];
                }else if(i==dp.length-1){
                    dp[i][j] = dp[i][j+1] + arr[i][j];
                }else if(j==dp[0].length-1){
                    dp[i][j] = dp[i+1][j] + arr[i][j];
                }else{
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1]) + arr[i][j];
                }
            }
        }
        
        return dp[0][0];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        // int[] arr = new int[n];

        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = scn.nextInt();
            }
        }

        // int[] dp = new int[n+1];
        int[][] dp = new int[n][m];

        // System.out.println(fiboR(n));
        // System.out.println(fiboMemo(n, dp));
        int ans = minCost_maze(arr, dp);
        System.out.println(ans);
    }

}
