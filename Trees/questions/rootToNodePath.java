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

    public static boolean rootToNodePath(Node root, int data, ArrayList<Node> ans) {
        if (root == null)
            return false;
        boolean res = (root.data == data) || rootToNodePath(root.left, data, ans)
                || rootToNodePath(root.right, data, ans);

        if (res)
            ans.add(root);
        return res;
    }

    public static void printAtDepthK(Node root, Node block, int k, ArrayList<Integer> ans) {
        if (root == null || root == block || k < 0)
            return;

        if (k == 0) {
            ans.add(root.data);
            return;
        }

        printAtDepthK(root.left, block, k - 1, ans);
        printAtDepthK(root.right, block, k - 1, ans);
    }


    // https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

    public ArrayList<Integer> distanceK(Node root, Node target, int k) {
        ArrayList<Node> path = new ArrayList<>();
        rootToNodePath(root, target.data, path);

        Node block = null;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < path.size(); i++) {
            printAtDepthK(path.get(i), block, k - i, ans);
            block = path.get(i);
        }

        return ans;
    }

    public static void printSingleChildNodes(Node node, Node parent) {
        if (node == null)
            return;
        if (parent != null && (parent.left == null || parent.right == null)) {
            System.out.println(node.data);
        }

        printSingleChildNodes(node.left, node);
        printSingleChildNodes(node.right, node);
    }

    public static Node removeLeaves(Node node){
        if(node == null) return null;

        if(node.left == null && node.right == null) return null;

        removeLeaves(node.left);
        removeLeaves(node.right);

        return node;
    }

    public static void removeLeaves(Node node, Node parent){
        if(node == null) return;

        if(node.left == null && node.right == null){
            if(parent.left == node){
                parent.left == null;
            }else{
                parent.right == null;
            }

            return;
        }

        removeLeaves(node.left);
        removeLeaves(node.right);
    }

    public static Node removeLeaves(Node node){

        if(node.left == null && node.right == null){
            return null;
        }
        removeLeaves(node, null);

        return node;
    }



}

