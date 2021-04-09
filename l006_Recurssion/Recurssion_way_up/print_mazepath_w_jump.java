import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        printMazePaths(0, 0, n, m, "");
    }

    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        // bc
        if(sr==dr && sc==dc){
            System.out.println(psf);
            return;
        }


        for(int jump=0; sr+jump<dr; jump++){
            printMazePaths(sr+jump, sc, dr, dc, psf + 'v' + jump);
        }
        for(int jump=0; sc+jump<dc; jump++){
            printMazePaths(sr, sc+jump, dr, dc, psf + 'h' + jump);
        }
        for(int jump=0; sc+jump<dc && sr+jump<dr; jump++){
            printMazePaths(sr+jump, sc+jump, dr, dc, psf + 'd' + jump);
        }
    }

}