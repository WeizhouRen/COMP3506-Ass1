package comp3506.assn1.adts;

import java.util.Iterator;


/**
 * Queue with ability to iterate over all the elements in the queue.
 * 
 * Memory Usage: O(1)
 * 
 * @author 44939962
 *
 * @param <T> Type of the elements held in the queue.
 */
public class TraversableQueue<T> implements IterableQueue<T> {

	private Object[] que;
	private int size = 0;
	private int front = 0;

	private class ITerator implements Iterator<T> {
		private int index = 0;

		@Override
		public boolean hasNext() {
			if (index >= size) {
				return false;
			} else {
				return true;
			}
		}

		@SuppressWarnings("unchecked")
		@Override
		public T next() {
			return (T) que[++index];
		}

	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ITerator();
	}

	public TraversableQueue() {
		que = new Object[20000];
	}

	/**
	 * Add a new element to the end of the queue. 
	 * O(1)
	 * @param element The element to be added to the queue.
	 * @throws IllegalStateException Queue cannot accept a new element (e.g.
	 * queue space is full).
	 * 
	 */
	@Override
	public void enqueue(T element) throws IllegalStateException {
		if (size >= 20000) {
			throw new IllegalStateException("Illegal State!");
		} else {
			int avail = (front + size) % que.length;
			que[avail] = element;
			size++;
		}
	}

	/**
	 * Remove and return the element at the head of the queue.
	 * O(1)
	 * @return Element at that was at the head of the queue.
	 * @throws IndexOutOfBoundsException Queue is empty and nothing can be
	 * dequeued.
	 */
	@Override
	public T dequeue() throws IndexOutOfBoundsException {
		if (size == 0) {
			throw new IndexOutOfBoundsException("Out Of Bounds!");
		} else {
			@SuppressWarnings("unchecked")
			T t = (T) que[front];
			que[front] = null;
			front = (front + 1) % que.length;
			size--;
			return t;
		}
	}

	/**
	 * O(1)
	 * @return size of elements in the queue.
	 */
	@Override
	public int size() {
		return size;
	}

}

/**
 * Justification: 
 * 	Lecture slide in week2 gives inspiration. Size can can be changed after each operation.
 * 
 * Reference:
 * 	Queues. (2014). [Week 2 Lecture Slides] (p. 14).
 */
