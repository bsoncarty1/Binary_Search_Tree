package brandon_soncarty_00874311_cscd300_prog8.Code;//Brandon Soncarty


public class ListQueue implements Queue {

    protected BSTNode head;   //the reference pointing to the head item. The head of the queue is also the head of the list
    protected BSTNode tail;   //the reference pointing to the tail item. The tail of the queue is also the tail of the list.
    protected int size;    //the number of items in the queue

    public ListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    //returns size of the ListQueue
    public int size() {
        return this.size;
    }

    //returns head of ListQueue
    public BSTNode front() {
        if (size == 0) {
            return null;
        }
        return head;
    }

    //enqueues the item into the ListQueue
    public void enqueue(BSTNode item) {
        if (item == null) {
            return;
        }

        if (size == 0) {
            head = item;
            tail = item;
        } else {
            tail.setNext(item);
            tail = item;
        }
        size++;
    }

    //dequeues the item into the ListQueue
    public BSTNode dequeue() {
        if (size == 0) {
            return null;
        }
        BSTNode ret = head;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            BSTNode oldHead = head;
            head = head.getNext();
            oldHead.setNext(null);
        }
        size--;
        return ret;
    }
}



