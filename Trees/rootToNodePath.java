// import java.util.ArrayList;

public class l001 {
    public static class Node {
        int data = 0;
        Node left = null;
        Node right = null;

        Node(int data){
            this.data = data;
        }
    } 

    public static boolean rootTonodePath(Node root, ArayList<Integer> ans, int data){
        if(root == null){
            return false;
        }

        boolean res = (root.data == data) || (rootTonodePath(root.left, ans, data) || rootTonodePath(root.right), ans, data);

        if(res){
            ans.add(root);
        }
        return ans;

    }

    public static void printAtDepthK(Node root, Node block, int k, ArrayList<Integer> ans){
        if(root == null || root == block || k<0){
            return
        }

        if(k==0){
            ans.add(root.data);
            return;
        }

        printAtDepthK(root.left, block, k - 1, ans);
        printAtDepthK(root.right, block, k - 1, ans);
    }

}

