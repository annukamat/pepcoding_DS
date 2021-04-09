import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        ArrayList<String> paths = getMazePaths(1, 1, n, m);
        System.out.println(paths);

    }
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr == dr && sc == dc){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList<String> hpaths = new ArrayList<>();
        ArrayList<String> vpaths = new ArrayList<>();

        if(sc < dc){
            hpaths = getMazePaths(sr, sc+1, dr, dc);
        }

        if(sr < dr){
            vpaths = getMazePaths(sr+1, sc, dr, dc);
        }

        ArrayList<String> paths = new ArrayList<>();

        for(String hpath: hpaths){
            paths.add("h" + hpath);
        }
        for(String vpath: vpaths){
            paths.add("v" + vpath);
        }

        return paths;

    }

    // DIAGONAL
    public static ArrayList<String> getMazePathsDiagonal(int sr, int sc, int dr, int dc){
    // BC
    if (sr == dr && sc == dc){
        ArrayList<String> base;
        base.push_back("");
        return base;
    }

    ArrayList<String> myAns = new ArrayList<>() ;
    if (sc + 1 <= dc){
         ArrayList<String> Horizontal = getMazePathsDiagonal(sr, sc + 1, dr, dc);
        for (String s : Horizontal){
            myAns.push_back("h" + s);
        }
    }

    if (sr + 1 <= dr)
    {
         ArrayList<String> Vertical = getMazePathsDiagonal(sr + 1, sc, dr, dc);
        for (String s : Vertical){
            myAns.push_back("v" + s);
        }
    }

    if (sr + 1 <= dr && sc + 1 <= dc){
         ArrayList<String> Diagonal = getMazePathsDiagonal(sr + 1, sc + 1, dr, dc);
        for (String s : Diagonal){
            myAns.push_back("d" + s);
        }
    }

    return myAns;
}

    // WAY P APPROACH
    public static int getMazePaths(int sr, int sc, int dr, int dc, String ans){
        // BC
        if(sr==dr && sc==dc){
            System.out.println(ans);
            return 1;
        }


    int count = 0;
    if (sc + 1 <= dc)
        count += getMazePaths(sr, sc + 1, dr, dc, ans + 'h');
    if (sr + 1 <= dr)
        count += getMazePaths(sr + 1, sc, dr, dc, ans + 'v');

    return count;
    }


}