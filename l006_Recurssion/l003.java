public class l003{
    public static void main (String[] args){

    }


    public static int floodFill(int sr, int sc, int er, int ec, boolean[][] vis, int[][] dir, String[] dirS, String ans){
        // bc
        if(sr == er && sc == ec){
            System.out.println(ans);
            return 1;
        }

        vis[sr][sc] = true;

        int n = vis.length;
        int m = vis[0].length;

        int count = 0;
        for(int d = 0; d < dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            // check r and c with in the boundary
            if(r >= 0 && c >= 0 && r < n && c < m && !vis[r][c]){
                count += floodFill(sr, sc, er, ec, vis, dir, dirS, ans + dirS[d]);
            }
        }

        vis[sr][sc] = false;
        return count;

    }


}