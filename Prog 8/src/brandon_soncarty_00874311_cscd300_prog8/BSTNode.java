//Brandon Soncarty


public class BSTNode {

    //variable declarations
    int key;
    BSTNode parent;
    BSTNode left;
    BSTNode right;
    BSTNode next;

    //sets key to value passed and rest of variables to null
    public BSTNode(int key) {
        this.key = key;
        this.parent = null;
        this.left = null;
        this.right = null;
        this.next = null;
    }

    //getters and setters
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public BSTNode getParent() {
        return parent;
    }

    public void setParent(BSTNode parent) {
        this.parent = parent;
    }

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    public void setNext(BSTNode item) {
        this.next = item;
    }

    public BSTNode getNext() {
        return this.next;
    }
}


