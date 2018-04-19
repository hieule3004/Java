public class Queue<T> implements QueueInterface<T>{
	
	private Node<T> first;
	private Node<T> last;
	
	public boolean isEmpty() {
		return last == null;
	}
	
	//post: Adds the given item to the queue
	public void enqueue(T item) {
		Node<T> node = new Node<>(item);
		if (isEmpty()) {
			first = node;
		} else {
			last.setNext(node);
		}
		last = node;
	}
	
	//post: Removes and returns the head of the queue. It throws an 
	//      exception if the queue is empty.
	public T dequeue() throws QueueException {
		if (isEmpty()) {
			throw new QueueException("Dequeue empty queue");
		}
		Node<T> oldFirst = first;
		first = first.getNext();
		if (first == null) {
			last = null;
		}
		return oldFirst.getItem();
	}
	
}
