import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        System.out.println(printMazePaths(0,0,m,n,""));
	}

	public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
	    // BC
        if(sr == dr && sc == dc){
            System.out.println(ans);
            return;
        }

    if (sc + 1 <= dc)
        getMazePaths(sr, sc + 1, dr, dc, ans + 'h');
    if (sr + 1 <= dr)
        getMazePaths(sr + 1, sc, dr, dc, ans + 'v');

    return 0;
	}

}