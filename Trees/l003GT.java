import java.util.ArrayList;

public class l003GT{
    public static class Node{
        int data = 0;
        ArrayList<Node> children = new ArrayList<>();

        Node(int data) {
            this.data = data;
        }
    }

    public static int size(Node node){
        int sz = 0;
        for(Node child: node.children){
            sz = size(child);
        }
        return sz + 1;
    }

    public static int height(Node node){
        int h = -1;
        for(Node child: node.children){
            h = Math.max(h, height(child));
        }
        return h + 1;
    }

    public static int maximum(Node node){
        int maxEle = node.data;
        for(Node child: node.children){
            maxEle = Math.max(maxEle)
        }
    }

    public static int minimum(Node node){
        
    }

    public static int find(Node node){
        
    }


}