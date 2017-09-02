/**
 * Created by alexanderboswell on 2/25/17.
 */
public class IsThisABinaryTree {
    public static void main(String[] args) {

    }
    class Node {
        int data;
        Node left;
        Node right;
    }
    boolean checkBST(Node root) {
        return checkData(root, null, null);
    }
    boolean checkData(Node n, Integer min, Integer max) {
        if (n == null) {
            return true;
        }
        if((min != null && n.data <= min) || (max != null && n.data > max)) {
            return false;
        }
        if(!checkData(n.left, min, n.data) || !checkData(n.right, n.data, max)) {
            return false;
        }
        return true;
    }

}
