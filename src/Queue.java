
public class Queue{
	public Object [] theArray;
	private int currentSize;
	private int front;
	private int back;
	static final int DEFAULT_CAPACITY = 7;
	
	//Construct the queue
	public Queue() {
		this (DEFAULT_CAPACITY);
	}

	//Construct the queue
	public Queue(int capacity) {
		theArray = new Object[capacity];
		makeEmpty();
	}

	//Check whether the queue is empty, if empty, return empty
	public boolean isEmpty() {
		return currentSize == 0;
	}

	//Check whether the queue is full, if full return full
	public boolean isFull() {
		return currentSize == theArray.length;
	}
	
	//Make the queue empty
	public void makeEmpty() {
		currentSize = 0;
 		front = 0;
		back = -1;
	}

	//Get the least recently inserted item
	public Object getFront() {
		if (isEmpty())
			return null;
		return theArray[front];
	}

	//Return and remove the least recently inserted item from the queue
	public Object dequeue() {
		if (isEmpty())
			return null;
		currentSize-=3;

		Object frontItem = theArray[front];
		theArray[front] = null;
		front = increment(front);
		return frontItem;
	}
	
	//Insert a new item to the queue
	//If the queue is full, exception
	public void enqueue(Object x) throws Exception {
		if (isFull()) throw new Exception();
		back = increment(back);
		theArray[back] = x;
		currentSize++;
	}

	//Increment with wrapground 
	//return 0 if it is end of the array
	private int increment(int x) {
		if (++x == theArray.length)
			x = 0;
		return x;
	}
}
