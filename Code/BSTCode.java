package brandon_soncarty_00874311_cscd300_prog8.Code;//Brandon Soncarty


public class BSTCode {

    //root variable
    BSTNode root;

    //default root is null
    BSTCode() {
        root = null;
    }

    /**
     * to find height of tree
     * height is based on the size and shape of the BST
     * n = (2^(h+1)) - 1
     * <p>
     * Time cost: O(h) = O(log n) best case
     * O(h) = O(n) worst case, height of tree
     * <p>
     * If given a whole data set then you want to randomly shuffle them to make the tree balanced
     * If given single number to insert then we need a better insert() method than the one below
     */

    //inserts an int into the BST as a leaf
    public BSTNode insert(int k) {
        //if the given key already exists, return null
        //else insert k into the BST and return the reference to the new node
        BSTNode node = new BSTNode(k);

        BSTNode y = null;
        BSTNode x = root;

        while (x != null) {
            y = x;
            if (k == x.key) { //k already exists
                return null;
            } else if (k < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;
        if (y == null) { //the tree was empty
            root = node;
        } else if (k < y.key) {
            y.left = node;
        } else {
            y.right = node;
        }
        return node;
    }


    /**
     * O(h) = O(log n) best case
     * O(h) = O(n) worst case, height of the tree
     */
    //searches the bst for a given int
    public BSTNode search(int k) {
        BSTNode temp = root;
        while (temp != null && k != temp.key) {
            if (k < temp.key) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return temp; //if the node doesn't exist in the BST then it will return null
    }


    /**
     * O(h) = O(log n) best case
     * O(h) = O(n) worst case, height of the tree
     */
    //finds the min value BSTNode in the given subtree
    public BSTNode Min(BSTNode subtree_root) { //parameter can be any node in the BST
        BSTNode temp = subtree_root;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }


    /**
     * O(h) = O(log n) best case
     * O(h) = O(n) worst case, height of the tree
     */
    //finds the max value BSTNode in the given subtree
    public BSTNode Max(BSTNode subtree_root) {
        BSTNode temp = subtree_root;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp;
    }

    //finding the next largest node of the one passed as a parameter
    //if the node passed is the largest node in the BST then we will return null
    //if the node passed does not have a right child then we climb the parent link to the next largest which will
    //be the first right turn in the climbing parents BST
    //Time cost = O(log n) best, O(n) worst
    public BSTNode Successor(BSTNode x) {
        if (x.right != null) {
            return Min(x.right);
        }
        // Find x’s lowest ancestor, such that x is in its left subtree
        BSTNode y = x.parent;
        while (y != null && x == y.right) {
            x = y;
            y = y.parent;
        }
        // If y turns out to be null, it means x does not have a successor
        return y;
    }


    //finding the next smallest node of the one passed as a parameter
    //if the node passed is the smallest node in the BST then we will return null
    //if the node passed does not have a left child then we climb the parent link to the next smallest which will
    //be the first left turn in the climbing parents BST
    //Time cost = O(log n) best, O(n) worst
    public BSTNode Predecessor(BSTNode x) {
        if (x.left != null) {
            return Max(x.getLeft());
        }
        // Find x’s lowest ancestor, such that x is in its right subtree
        BSTNode y = x.parent;
        while (y != null && x == y.left) {
            x = y;
            y = y.parent;
        }
        // If y turns out to be null, it means x does not have a predecessor
        return y;
    }


    //prints out the keys in ascending order from the subtree node passed in
    //Recursion based
    //time complexity: O(n), linear of the tree size
    public void InOrder_Traversal(BSTNode subtree_root) {
        if (subtree_root != null) {
            InOrder_Traversal(subtree_root.left);
            print(subtree_root.key);
            InOrder_Traversal(subtree_root.right);
        }
    }


    //print the root node first then the left side, then right side
    //Recursion based
    //time complexity: O(n), linear of the tree size
    public void PreOrder_Traversal(BSTNode subtree_root) {
        if (subtree_root != null) {
            print(subtree_root.key);//this line and
            PreOrder_Traversal(subtree_root.left);//this line are swapped from the InOrder. That's the only difference
            PreOrder_Traversal(subtree_root.right);
        }
    }


    //print left side, right side, then the root
    //Recursion based
    //time complexity: O(n), linear of the tree size
    public void PostOrder_Traversal(BSTNode subtree_root) {
        if (subtree_root != null) {
            PostOrder_Traversal(subtree_root.left);
            PostOrder_Traversal(subtree_root.right);
            print(subtree_root.key);//in the PostOrder, the print is the last statement
        }
    }


    //printing the nodes of each level from left to right
    public void LevelOrder_Traversal(BSTNode subtree_root) {
        ListQueue Q = new ListQueue(); //Create a new FIFO ListQueue
        Q.enqueue(subtree_root);
        while (Q.size > 0) {
            BSTNode node = Q.dequeue();
            System.out.println(node.key);
            if (node.left != null) {
                Q.enqueue(node.left);
            }
            if (node.right != null) {
                Q.enqueue(node.right);
            }
        }
    }

    /* Note: old_subtree cannot be null; new_subtree can be null. */
    public void transplant(BSTNode oldSubtree, BSTNode newSubtree) {
        //if the old subtree doesn't have a parent then it is the global root, AKA the whole BST
        if (oldSubtree.parent == null)
            //The newSubtree will be the whole BST
            root = newSubtree;
        else if (oldSubtree == oldSubtree.parent.left)
            oldSubtree.parent.left = newSubtree;
        else
            oldSubtree.parent.right = newSubtree;
        if (newSubtree != null)
            newSubtree.parent = oldSubtree.parent;
    }
    

    //O(h) time cost for all the delete functions
    public BSTNode delete(int k) {
        BSTNode z = search(k);
        if (z != null)
            delete(z);
        return z;
    }

    public void delete(BSTNode z) {
        //z is a leaf node
        //case 1
        if (z.left == null && z.right == null) //z has no child
            transplant(z, null);
            //case 1
        else if (z.left == null) //z has only a right child
            transplant(z, z.right);
            //case 2
        else if (z.right == null) //z has only a left child
            transplant(z, z.left);
            //case 3
        else { //z has two children and is replaced by its successor
            BSTNode y = Min(z.right);
            if (y.parent != z)
                transplant(y, y.right);
            y.setRight(z.right);
            y.right.parent = y;
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
        }
    }

    //prints the key
    public void print(int key) {
        System.out.println(key + " ");
    }
}


