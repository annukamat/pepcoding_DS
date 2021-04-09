import java.util.ArrayList;

public class l002BST {
    
    public static class Node {
        int data = 0;
        int left = null;
        int right = null;

        Node(int data){
            this.data = data;
        }
    }

    public static Node constructTree(int[] arr, int si, int ei) {
        if(si > ei){
            return null;
        }

        int mid = (si + ei)/2;
        Node node = new Node(arr[mid]);

        node.left = constructTree(arr, si, mid-1);
        node.right = constructTree(arr, mid+1, ei);

        return node;
    }

    public static Node constructTree(int[] arr) {
        return constructTree(arr, 0, arr.length-1);
    }

    public static int size(Node node) {
        // if(node == null) return 0;

        // int left = size(node.left);
        // int right = size(node.right);

        // return left + right + 1; 

        return node == null ? 0 : size(node.left) + size(node.right) + 1;

    }

    public static int height(Node node) {
        return node == null ? -1 : Math.max(height(node.left), height(node.right));
    }

    public static int maximum(Node node) {
        Node curr = node;
        while(curr.right != null){
            curr = curr.right;
        }
        return curr.data;
    }
    public static int maximumRec(Node node) {
        if(node == null){
            return node.data;
        }
        return maximumRec(node.right);
    }

    public static int minimum(Node node) {
        Node curr = node;
        while(curr.left != null){
            curr = curr.left;
        }
        return curr.data;
    }

    public static int minimumRec(Node node) {
        if(node == null){
            return node.data;
        }
        return minimumRec(node.left);
    }

    public static boolean find(Node node) {
        Node curr = node;

        while(curr != null){
            if(curr.data == data){
                return true;
            }else if(curr.data < data){
                curr = curr.right;
            }else{
                curr = curr.left;
            }
        }
        return false;
    }

    public static Node addData(Node node, int data) {
        if(node == null){
            return new Node(data)
        }

        if(node.data < data){
            node.right = addData(node.right, data);
        }else{
            node.left = addData(node.left, data);
        }
        return node; 
    }

    public static Node LCA(Node node, int p, int q) {
        Node curr = node;
        while(curr != null){
            if(curr.data < p && curr.data < q){
                curr = curr.right;
            }else if (curr.data > p && curr.data > q){
                curr = curr.left;
            }else{
                return (find(curr, p) && find(curr, q)) ? curr : null;
            }
        }
        return null;
    }

    public static Node removeNode(Node node, int data){
        if(node == null) return null;

        if(node.data < data)
            node.right = removeNode(node.right, data);
        else if(node.data > data)
            node.left = removeNode(node.left, data);
        else{
            if(node.left == null || node.right == null)
                return node.left != null ? node.left : node.right;

            // int minData = minimum(node.right);
            // node.data = minData;
            // node.right = removeNode(node.right, minData);
            int minData = minimum(node.left);
            node.data = minData;
            node.right = removeNode(node.left, minData);
        }
        return node;
    }

    // TARGET SUM
    public static void inOrder(Node node, ArrayList<Integer> list){
        if(node == null){
            return;
        }

        inOrder(node.left, list);
        list.add(node.data);
        inOrder(node.right, list)
    }

    public static void targetSum(Node node, int tar){
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(node, list);

        int i = 0, int j = list.size()-1;
        while(i<j){
            int sum = list.get(i) + list.get(j);
            if(sum < tar){
                i++;
            } else if(sum > tar) {
                j--;
            } else {
                System.out.println(list.get(i) + " " + list.get(j));
                i++;
                j--;
            }
        }
    }


} 


