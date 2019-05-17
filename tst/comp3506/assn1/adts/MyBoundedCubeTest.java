package comp3506.assn1.adts;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyBoundedCubeTest {
	
	@Test(timeout = 500, expected = IllegalArgumentException.class)
	public void testIllegalArgumentEXP() {
		Cube<Object> testCube = new BoundedCube<>(-1,-1,-1);
	}
	
	@Test(timeout = 500)
	public void testGetWithOneElement() {
		Cube<Object> testCube = new BoundedCube<>(5, 5, 5);
		Object element = new Object();
		testCube.add(1, 1, 1, element);
		assertEquals(testCube.get(1, 1, 1), element);
	}

	@Test(timeout = 500, expected = IndexOutOfBoundsException.class)
	public void testGetWithOneElementExp() {
		Cube<Object> testCube = new BoundedCube<>(5, 5, 5);
		Object element = new Object();
		testCube.add(1, 1, 1, element);
		assertEquals(testCube.get(10, 10, 10), element);
	}

	@Test(timeout = 500)
	public void testGetWithMultipleElements() {
		Cube<Object> testCube = new BoundedCube<>(5, 5, 5);
		Object element1 = new Object();
		Object element2 = new Object();
		testCube.add(1, 1, 1, element1);
		testCube.add(1, 1, 1, element2);
		assertEquals(testCube.get(1, 1, 1), element1);
	}

	@Test(timeout = 500)
	public void testGetAllWithMultipleElementsSize() {
		Cube<Object> testCube = new BoundedCube<>(5, 5, 5);
		Object element1 = new Object();
		Object element2 = new Object();
		testCube.add(1, 1, 1, element1);
		testCube.add(1, 1, 1, element2);
		IterableQueue<Object> queue = testCube.getAll(1, 1, 1);
		assertEquals(queue.size(), 2);
	}

	@Test(timeout = 500, expected = IndexOutOfBoundsException.class)
	public void testGetAllWithMultipleElementsSizeEXP() {
		Cube<Object> testCube = new BoundedCube<>(5, 5, 5);
		Object element1 = new Object();
		Object element2 = new Object();
		testCube.add(1, 1, 1, element1);
		testCube.add(1, 1, 1, element2);
		IterableQueue<Object> queue = testCube.getAll(10, 10, 10);
	}

	@Test(timeout = 500)
	public void testClearCube() {
		Cube<Object> testCube = new BoundedCube<>(3, 3, 3);
		testCube.add(0, 0, 0, new Object());
		testCube.add(1, 1, 1, new Object());
		testCube.add(1, 1, 1, new Object());
		testCube.add(2, 2, 2, new Object());
		testCube.clear();
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				for (int k = 0; k < 3; k++)
					assertEquals(testCube.get(i, j, k), null);
	}
}
