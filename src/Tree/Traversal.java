package Tree;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Traversal {
    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Binary_Tree tree = new Binary_Tree();
        Node root = tree.builder(nodes);
//        tree.inorder(root);
        tree.itter_inorder(root);
    }


}

class Binary_Tree {
    static int idx = -1;

    public Node builder(int[] arr){ //can only build preorder
        idx++;
        if(arr[idx]==-1){
            return null;
        }

        Node node = new Node(arr[idx]);
        node.left = builder(arr);
        node.right = builder(arr);

        return node;

    }

    public void preorder(Node root) {
        if (root == null) return;
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    public void inorder(Node root) {
        if (root == null) {
            System.out.print(-1 + " ");
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);


    }

    public void postorder(Node root) {
        if (root == null) {
            System.out.print(-1 + " ");
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }


    public void levelorder(Node root){
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while(q.size()>0){
            int count = q.size();
            for (int i = 0; i < count; i++) {
                root = q.remove();
                System.out.print(root.data+" ");
                if(root.left!=null) q.add(root.left);
                if(root.right!=null) q.add(root.right);
            }
            System.out.println();
        }

    }


    public void itter_preorder(Node root){
        Stack<Node> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            root = s.pop();
            System.out.println(root.data);
            if(root.right!=null) s.push(root.right);
            if(root.left!=null) s.push(root.left);
        }
    }

    public void itter_inorder(Node root){
        Stack<Node> st = new Stack<>();
        Node node  = root;
        while(true){
            if(node!=null){
                st.push(node);
                node=node.left;
            }
            else{
                if(st.isEmpty()) break;
                node = st.pop();
                System.out.println(node.data);
                node = node.right;
            }
        }

    }

    public void itter_postorder(Node root){
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);
        while(!st1.isEmpty()){
            root = st1.pop();
            st2.push(root);
            if(root.left!=null) st1.push(root.left);
            if(root.right!=null) st1.push(root.right);
        }
        while(!st2.isEmpty()){
            System.out.println(st2.pop().data);
        }

    }





} class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
