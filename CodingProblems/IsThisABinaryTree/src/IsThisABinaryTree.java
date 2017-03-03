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
    private boolean check = true;
    boolean checkBST(Node root) {

        if (root.left!=null) {
            if (root.left.data > root.data)
                check = false;
            else
                checkBST(root.left);
        }
        if(root.right!=null) {
            if (root.right.data < root.data)
                check = false;
            else
                checkBST(root.right);
        }

        return check;
    }

}
