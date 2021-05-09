import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class l001_Basic {

    public static class Edge {
        int v = 0;
        int w = 0;

        Edge(int v, int w){
            this.v = v;
            this.w = w;
        }

        public String toString(){
            return "(" + this.v + ", " + this.w + ") ";
        }
    }

    public static int N = 7;
    public static ArrayList<Edge>[] graph = new ArrayList[N];


    public static void addEdge(int u, int v, int w){
        graph[u].add(new Edge(v, w));
        graph[v].add(new Edge(u, w));
    }


    public static void display() {
        for(int i =0; i<N; i++){
            System.out.print(i + "->");
            for(Edge e: graph[i]){
                System.out.print(e);
            }
            System.out.println();
        }
    }

    public static int findEdge(int u, int v) {
        for(int i=0; i<graph[u].size(); i++){
            Edge e = graph[u].get(i);
            if(e.v == v){
                return i;
            }
        }
        return -1;
    }

    public static void removeEdge(int u, int v){
        int idx1 = findEdge(u, v);
        int idx2 = findEdge(v, u);

        graph[u].remove(idx1);
        graph[v].remove(idx2);
    }

    public static void removeVtx(int u){
        while(graph[u].size() != 0){
            int n = graph[u].size();
            Edge e = graph[u].get(n-1);
            removeEdge(u, e.v);
        }
    }

    public static boolean hasPath(int src, int des, boolean[] vis){
        if(src == des) return true;

        boolean res = false;
        vis[src] = true;
        for(Edge e: graph[src]){
            if(!vis[e.v])
                res = res || hasPath(e.v, des, vis);
        }

        return res;
    }

    public static int allPath(int src, int des, boolean[] vis, String ans){
        if(src == des){
             System.out.println(ans + des);
             return 1;
        }

        int count = 0;
        vis[src] = true;
        for(Edge e: graph[src]){
            if(!vis[e.v])
                count += allPath(e.v, des, vis, ans + src);
        }

        vis[src] = false;
        return count;
    }


    public static void printPreOrder(int src, boolean[] vis, String ans, int wsf){
        System.out.println(src + "->" + ans+src + "@" + wsf);
        vis[src] = true;
        for(Edge e : graph[src]){
            if(!vis[e.v])
                printPreOrder(e.v, vis, ans+src, wsf+e.w); 
        }
        vis[src] = false;
    }

    public static void printPostOrder(int src, boolean[] vis, String ans, int wsf){
        vis[src] = true;
        for(Edge e : graph[src]){
            if(!vis[e.v])
            printPostOrder(e.v, vis, ans+src, wsf+e.w); 
        }
        System.out.println(src + "->" + ans+src + "@" + wsf);
        vis[src] = false;
    }

    public static class Pair {
        int largestWt = -(int) 1e9;
        int smallestWt = (int) 1e9;
        String LargestPath = "";
        String smallestPath = "";

        int ceil = (int) 1e9;
        int floor = -(int) 1e9;
    }

    public static class pqPair {
        String psf = "";
        int wsf;

        pqPair(String psf, int wsf){
            this.psf = psf;
            this.wsf = wsf;
        }
    }

    static PriorityQueue<pqPair> pq = new PriorityQueue<>((a,b) -> {
        return a.wsf - b.wsf;
    });

    public static void allSoluion(int src, int des, boolean[]vis, String psf, int wsf, Pair p, int givenWt, int k){
        if(src == des){
            //largest path
            if(wsf > p.largestWt){
                p.largestWt = wsf;
                p.LargestPath = psf + des;
            }

            //smallest path
            if(wsf < p.smallestWt){
                p.smallestWt = wsf;
                p.smallestPath = psf + des;
            }
            // ceil
            if(givenWt < wsf && wsf < p.ceil){
                p.ceil = wsf;
            }
            // floor
            if(givenWt > wsf && wsf > p.floor){
                p.floor = wsf;
            }

            pq.add(new pqPair(psf+des, wsf));
            if(pq.size() > k){
                pq.remove();
            }
            
            return;

        }

        vis[src] = true;
        for(Edge e: graph[src]){
            if(!vis[e.v]){
                allSoluion(e.v, des, vis, psf+src, wsf + e.w, p, givenWt, k);
            }
        }
        vis[src] = false;
    }



    // GCC
    public static void gcc(ArrayList<ArrayList<Integer>> comps){
        boolean[] vis = new boolean[N]; 
        for(int i=0; i<N; i++){
            if(!vis[i]){
                ArrayList<Integer> comp = new ArrayList<>();
                dfs(i, comp, vis);
                comps.add(comp);
            }
        }
        System.out.println(comps);
    }
    
    public static void dfs(int src, ArrayList<Integer> comp, boolean[] vis){
        vis[src] = true;
        comp.add(src);
        for(Edge e: graph[src]){
            if(!vis[e.v]){
                dfs(e.v, comp, vis);
            }
        }
    }

    //dfs without comp[space]
    public static void dfs(int src, boolean[] vis){
        vis[src] = true;
        for(Edge e: graph[src]){
            if(!vis[e.v]){
                dfs(e.v, vis);
            }
        }
    }

    public static boolean isGraphConnected(){
        boolean[] vis = new boolean[N];
        int component = 0;
        for(int i=0; i<N; i++){
            if(!vis[i]){
                dfs(i, vis);
                component++;
            }
        }
        return component == 1;
    }

    public static void dfsIsland(int[][] mat, int[][] dir, int i, int j){
        mat[i][j] = 0;

        for(int d=0; d<4; d++){
            int r = i + dir[d][0];
            int c = j + dir[d][1];

            if(r>=0 && c>=0 && r<mat.length && c<mat[0].length && mat[r][c] == 1){
                dfsIsland(mat, dir, r, c);
            }
        }
    }

    public static int NoOfIsland(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int count = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 1){
                    dfsIsland(mat, dir, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void hamiltonianPath(int src, int osrc, boolean[] vis, int NoOfEdge, String psf){
        if(NoOfEdge == N-1){
            System.out.print(psf+src);

            int x = findEdge(osrc, src);
            if(x != -1){
                System.out.println("*");
            }else{
                System.out.println(".");
            }
            return;
        }

        vis[src] = true;
        for(Edge e: graph[src]){
            if(!vis[e.v]){
                hamiltonianPath(e.v, osrc, vis, NoOfEdge+1, psf+src);
            }
        }
        vis[src] = false;
    }

    public static int journeyToMoon(int n, List<List<Integer>> astronaut) {
        ArrayList<Integer>[] graph = new ArrayList<>();
        

        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
            
            for(int[] a: astronaut){
                graph[a[0]].add(a[1]);
                graph[a[1]].add(a[0]);
            }

            ArrayList<Integer> sizeArray = new ArrayList<>();
            boolean[] vis = new boolean[n];
            for(int i=0; i<n; i++){
                if(!vis[i])
                    sizeArray.add(moondfs(graph, i, vis));
            }

            int ssf = 0, res = 0;
            for(int ele : sizeArray){
                res += ele*ssf;
                ssf += ele;
            }
            return res;
    }

    public static int moondfs(ArrayList<Integer>[] graph, int src, boolean[] vis){
        vis[src] = true;
        int size = 0;
        for(Integer e: graph[src]){
            if(!vis[e]){
                size += moondfs(graph, e, vis);
            }
        }
        return size;
    }
    





public static void main(String[] args) {
    for(int i = 0; i < N; i++)
        graph[i] = new ArrayList<>();
    addEdge(0, 1, 10);
    addEdge(0, 3, 40);
    addEdge(1, 2, 10);
    addEdge(2, 3, 10);
    addEdge(3, 4, 2);
    addEdge(4, 5, 3);
    addEdge(4, 6, 8);
    addEdge(5, 6, 3);
    addEdge(2, 5, 5);
    addEdge(0, 6, 16);
    boolean[] vis = new boolean[N];

    // display();
    
    // System.out.println(hasPath(0, 6, vis));
    // printPreOrder(0, vis, "", 0);

    // Pair p = new Pair();
    // allSoluion(0, 6, vis, "", 0, p, 30, 4);
    // System.out.println("Smallest Path =" + p.smallestPath + "@" +
    // p.smallestWt);
    // System.out.println("Largest Path =" + p.LargestPath + "@" + p.largestWt);
    // System.out.println("Ceil of 30 =" + +p.ceil);
    // System.out.println("Floor of 30 =" + +p.floor);
    // System.out.println("Kth Largest Path =" + pq.peek().psf + "@" +
    // pq.peek().wsf);
    // System.out.println(findEdge(0,4));

    // ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
    // gcc(comps);

    // System.out.println(isGraphConnected());
    // System.out.println(findEdge(0, 1));
    hamiltonianPath(0, 0, vis, 0, "");
    
}


}