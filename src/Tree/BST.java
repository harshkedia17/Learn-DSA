package Tree;

import Tree.Binary_Tree;
import Tree.Node;

public class BST {
    public static void main(String[] args) {
        int[] values = {5, 1, 3, 4, 2, 7};

        Node root = null;
        for (int i = 0; i < values.length; i++) {
            insert(root, values[i]);
        }

    }

    public Node search(Node node, int val) {
        while (node != null && node.data != val) {
            node = val < node.data ? node.left : node.right;
        }
        return node;
    }

    public static Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        else if (root.data > val) {
            insert(root.left, val);
        } else {
            insert(root.right, val);
        }
        return root;
    }

    public static Node delete(Node root, int val) {
        if (root.data > val) {
            delete(root.left, val);
        } else if (root.data < val) {
            delete(root.right, val);
        } else {
            //case1
            if (root.left == null && root.right == null) {
                return null;
            }
            // case 2
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            //case 3
            Node IS = inorder_succcesor(root.right);
            root.data = IS.data;
            delete(root.right,IS.data);
        }
        return root;
    }



    public static Node inorder_succcesor(Node root) {
        while(root.left!=null) root = root.left;
        return root;
    }





    static Node insert_itter(Node root, int key)
    {
        // Create a new Node containing
        // the new element
        Node newnode = new Node(key);

        // Pointer to start traversing from root and
        // traverses downward path to search
        // where the new node to be inserted
        Node x = root;

        // Pointer y maintains the trailing
        // pointer of x
        Node y = null;

        while (x != null) {
            y = x;
            if (key < x.data)
                x = x.left;
            else
                x = x.right;
        }

        // If the root is null i.e the tree is empty
        // The new node is the root node
        if (y == null)
            y = newnode;

            // If the new key is less than the leaf node key
            // Assign the new node to be its left child
        else if (key < y.data)
            y.left = newnode;

            // else assign the new node its right child
        else
            y.right = newnode;

        // Returns the pointer where the
        // new node is inserted
        return y;
    }




    // Iterative Function to delete
    // 'key' from the BST.
    static Node deleteIterative(Node root, int key)
    {
        Node curr = root;
        Node prev = null;

        // Check if the key is actually
        // present in the BST.
        // the variable prev points to
        // the parent of the key to be deleted.
        while (curr != null && curr.data != key) {
            prev = curr;
            if (key < curr.data)
                curr = curr.left;
            else
                curr = curr.right;
        }

        if (curr == null) {
            System.out.println("Key " + key
                    + " not found in the"
                    + " provided BST.");
            return root;
        }

        // Check if the node to be
        // deleted has atmost one child.
        if (curr.left == null || curr.right == null) {

            // newCurr will replace
            // the node to be deleted.
            Node newCurr;

            // if the left child does not exist.
            if (curr.left == null)
                newCurr = curr.right;
            else
                newCurr = curr.left;

            // check if the node to
            // be deleted is the root.
            if (prev == null)
                return newCurr;

            // check if the node to be deleted
            // is prev's left or right child
            // and then replace this with newCurr
            if (curr == prev.left)
                prev.left = newCurr;
            else
                prev.right = newCurr;
        }

        // node to be deleted has
        // two children.
        else {
            Node p = null;
            Node temp;

            // Compute the inorder successor
            temp = curr.right;
            while (temp.left != null) {
                p = temp;
                temp = temp.left;
            }

            // check if the parent of the inorder
            // successor is the curr or not(i.e. curr=
            // the node which has the same data as
            // the given data by the user to be
            // deleted). if it isn't, then make the
            // the left child of its parent equal to
            // the inorder successor'd right child.
            if (p != null)
                p.left = temp.right;

                // if the inorder successor was the
                // curr (i.e. curr = the node which has the
                // same data as the given data by the
                // user to be deleted), then make the
                // right child of the node to be
                // deleted equal to the right child of
                // the inorder successor.
            else
                curr.right = temp.right;

            curr.data = temp.data;
        }
        return root;
    }

    
}
