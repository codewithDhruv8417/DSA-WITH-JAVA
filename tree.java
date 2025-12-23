class Node
{
     int data;
     Node left;
     Node right;
     Node(int data)
     {
        this.data=data;
        left = null;
        right = null;
     
    }
}
public class tree 
{ //inorder
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
    
    public static void main(String args[])
  {


    

    Node a = new Node(1);
    a.left = new Node(2);
    a.right =  new Node(3);
    a.left.left = new Node(4);
    a.left.right = new Node(5);
    a.left.right.right = new Node(8);
    a.left.right.right.left = new Node(9);
    a.right.left = new Node(6);
    a.right.right = new Node(7);
    a.right.right.right = new Node(10);
    a.right.right.right.left = new Node(11);


    // System.out.println("Root : " + a.data);
    // System.out.println("Left Root : " + a.left.data);
    // System.out.println("Right Root : " + a.right.data);
  }

    
}
