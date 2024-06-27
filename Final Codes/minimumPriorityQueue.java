package FinalProject;

public class minimumPriorityQueue {

	private int size; // The number of elements in the queue;
	private Node front; // The front of the queue;
	private Node rear;  // The rear of the queue;

	public minimumPriorityQueue() { // Constructor to initialize the queue;
		front = null;
		rear = null;
		size = 0;
	}

	public class Node {
		private String data; //The data stored in the node;
		private Node next;  //The next node in the queue;
		private int priority;
		private Node  previous;
		public Node(String data, int priority) { // Constructor to initialize a new node with the given data;;
			this.data = data;
			this.next = null;
			this.priority = priority;
			this.previous = null;
		}
	}

	/*
	 * Method that adds a element to the queue based on the priority of the node;
	 * @param element Element string type to be added to the node;
	 * @param priority To know where to add the node in the queue;
	 */
	public void insert(String element, int priority) {
		Node node = new Node (element, priority);
		if (front == null) { //If the queue is empty;
			rear = node;
			front = rear;
			size++;
		} 
		else {
	        Node visit = front;
	        while (visit != null) {
	        	//If statement to determine if there are any nodes with a higher priority than the node to be added;
	            if (visit.priority >= priority) {
	                if (visit == front) {
	                	node.next = front;
	                    front.previous = node;
	                    front = node;
	                } else {
	                    node.previous = visit.previous;
	                    node.next = visit;
	                    visit.previous.next = node;
	                    visit.previous = node;
	                }
	                size++;
	                return;
	            }
	            visit = visit.next;
	        }
	        // if priority is the highest
	        rear.next = node;
	        node.previous = rear;
	        rear = rear.next;
	        size++;
		}

	}
	
	/*
	 * Method that removes the minimum priority node from the queue;
	 */
	public void removeMin() {
		if (front != null) { //If the queue is not empty;
			front = front.next;
			size--;
		} 
		else
			System.out.println("The queue is empty there is nothing to remove!");
	}
	
	/* 
	 * Method that returns the minimum priority node (the node at the beginning of the queue); 
	 */
	public String getMin() {
		if (!isEmpty()) //If statement to check if the queue is empty or not first;
			return (String) front.data;
		else
			System.out.println("The queue is empty there is nothing to print");
		return null;
	}
	
	/* 
	 * Method check if the minimum priority queue is empty. 
	 * if its empty it return true otherwise False; 
	 */
	public boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}	
}
