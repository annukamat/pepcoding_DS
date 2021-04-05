public class Main{
    public static Node prev = null;

    public static boolean isBST(Node node){
        if(node == null) return true;

        boolean leftRes = isBST(node.left);
        if(!leftRes) return false;

        if(prev != null && prev.data>node.data)
        return false;

        prev = node;

        boolean rightRes = isBST(node.right);
        if(!rightRes) return false;

        return true;
    }

    // ====================================================

    public static class isBSTSolPair{
        int maxEle = -(int) 1e8;
        int minEle = (int) 1e8;
        boolean isBST = true;

        boolean isBal = true;
        int height = -1;
    }

    public isBSTSolPair isBST_(Node node){
        if(node == null){
            // isBSTSolPair base = new isBSTSolPair();
            // base.isBST_ = true;
            return new isBSTSolPair();
        }

        isBSTSolPair left = isBST_(node.left);
        isBSTSolPair right = isBST_(node.right);

        isBSTSolPair myRes = new isBSTSolPair();
        myRes.isBST = false;
        if(left.isBST && right.isBST && left.maxEle < node.data && node.data < right.minEle){
            myRes.isBST = true;
            myRes.maxEle = right.maxEle;
            myRes.minEle = left.minEle;
        }

        return myRes;
    }

    public static class isBalPair {
        int height = -1;
        boolean balanceTree = true;
    }

    public static isBalPair isBal_(Node node){
        if(node === null) return new isBalPair();

        isBalPair left = isBal_(node.left);
        if(!left.balanceTree) return left;

        isBalPair right = isBal_(node.right);
        if(!right.balanceTree) return right;

        isBalPair myRes = new isBalPair();
        myRes.balanceTree = false;
        if(left.balanceTree && right.balanceTree && Math.abs(left.height - right.height) <= 1){
            myRes.balanceTree = true;
            myRes.height = Math.max(left.height, right.height) + 1;
        }

        return myRes;
    }

        public static boolean isBal(Node node) {
        isBalPair ans = isBal_(node);
        return ans.balanceTree;
    }

}