//Brandon Soncarty

package brandon_soncarty_00874311_cscd300_prog8;

//interface code given during class
//changed some return variables and parameters to fit the program needs
public interface Queue {

    public int size();  // return the number of items currently in the queue.

    public BSTNode front(); // return the item at the head of the queue, but do not remove it from the queue.

    public void enqueue(BSTNode item); // insert the new item into the tail of the queue.

    public BSTNode dequeue(); // return and remove the item at the head of queue.

}

