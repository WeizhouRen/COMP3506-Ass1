package comp3506.assn1.adts;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

public class MyTraversableQueueTest {

	@Test(timeout = 500)
	public void testNewQueueIsEmpty() {
		IterableQueue<Object> testQueue = new TraversableQueue<>();
		assertEquals(testQueue.size(), 0);
	}

	@Test(timeout = 500, expected = IndexOutOfBoundsException.class)
	public void testDequeueEmptyQueue() {
		IterableQueue<Object> testQueue = new TraversableQueue<>();
		testQueue.dequeue(); // Nothing to dequeue.
	}

	@Test(timeout = 500)
	public void testSingleElementQueueSize() {
		IterableQueue<Object> testQueue = new TraversableQueue<>();
		testQueue.enqueue(new Object());
		assertEquals(testQueue.size(), 1);
	}

	@Test(timeout = 500, expected = IllegalStateException.class)
	public void testSingleElementQueueSizeEXP() {
		IterableQueue<Object> testQueue = new TraversableQueue<>();
		for (int i = 0; i <= 20001; i++)
			testQueue.enqueue(new Object());
	}

	@Test(timeout = 500)
	public void testSingleElementQueue() {
		IterableQueue<Object> testQueue = new TraversableQueue<>();
		Object element = new Object();
		testQueue.enqueue(element);
		assertEquals(testQueue.dequeue(), element);
	}

	@Test(timeout = 500)
	public void testIteratorHasNextOnSingleEntityQueue() {
		IterableQueue<Object> testQueue = new TraversableQueue<>();
		testQueue.enqueue(new Object());
		Iterator<Object> it = testQueue.iterator();
		assertEquals(it.hasNext(), true);
		it.next();
		assertEquals(it.hasNext(), false);
	}
}
