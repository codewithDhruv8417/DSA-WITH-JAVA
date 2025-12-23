import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinaryTree {

    static Scanner sc = new Scanner(System.in);

    // Build tree using level order (Scanner input)
    static Node buildTree() {
        System.out.print("Enter root value: ");
        int data = sc.nextInt();

        if (data == -1) return null;

        Node root = new Node(data);
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            System.out.print("Enter left child of " + curr.data + ": ");
            int left = sc.nextInt();
            if (left != -1) {
                curr.left = new Node(left);
                q.add(curr.left);
            }

            System.out.print("Enter right child of " + curr.data + ": ");
            int right = sc.nextInt();
            if (right != -1) {
                curr.right = new Node(right);
                q.add(curr.right);
            }
        }
        return root;
    }

    // Inorder Traversal
    static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Preorder Traversal
    static void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder Traversal
    static void postorder(Node root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {

        Node root = buildTree();

        System.out.println("\nInorder Traversal:");
        inorder(root);

        System.out.println("\nPreorder Traversal:");
        preorder(root);

        System.out.println("\nPostorder Traversal:");
        postorder(root);
    }
}
