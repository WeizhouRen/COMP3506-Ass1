package comp3506.assn1.adts;

/**
 * A three-dimensional data structure that holds items in a positional
 * relationship to each other. Each cell in the data structure can hold multiple
 * items. A bounded cube has a specified maximum size in each dimension. The
 * root of each dimension is indexed from zero.
 * 
 * Memory usage: O(n)
 * 
 * @author 44939962
 *
 * @param <T> The type of element held in the data structure.
 */
public class BoundedCube<T> implements Cube<T> {
	private int size = 0;
	private Object[] Node;
	private int length;
	private int breadth;
	private int height;

	/**
	 * A node represents an element with its position
	 * 
	 */
	private class node implements Comparable<Object> {
		private int x;
		private int y;
		private int z;
		private T e;

		/**
		 * Get the value of x
		 * 
		 * @return value of x
		 */
		public int getX() {
			return x;
		}

		/**
		 * Set the value of x
		 * 
		 * @param x
		 */
		@SuppressWarnings("unused")
		public void setX(int x) {
			this.x = x;
		}

		/**
		 * Get the value of y
		 * 
		 * @return value of y
		 */
		public int getY() {
			return y;
		}

		/**
		 * Set the value of y
		 * 
		 * @param y
		 */
		@SuppressWarnings("unused")
		public void setY(int y) {
			this.y = y;
		}

		/**
		 * Get the value of z
		 * 
		 * @return value of z
		 */
		public int getZ() {
			return z;
		}

		/**
		 * Set the value of z
		 * 
		 * @param z
		 */
		@SuppressWarnings("unused")
		public void setZ(int z) {
			this.z = z;
		}

		/**
		 * Get the element in the node
		 * 
		 * @return the element
		 */
		public T getE() {
			return e;
		}

		/**
		 * Set the element e
		 * 
		 * @param e
		 */
		@SuppressWarnings("unused")
		public void setE(T e) {
			this.e = e;
		}

		public node(int x, int y, int z, T e) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
			this.e = e;
		}

		@Override
		public int compareTo(Object arg0) {
			// TODO Auto-generated method stub
			return 0;
		}
	}

	/**
	 * 
	 * @param length Maximum size in the 'x' dimension.
	 * @param breadth Maximum size in the 'y' dimension.
	 * @param height Maximum size in the 'z' dimension.
	 * @throws IllegalArgumentException If provided dimension sizes are not
	 * positive.
	 */
	public BoundedCube(int length, int breadth, int height) throws IllegalArgumentException {
		if (length < 0 || breadth < 0 || height < 0) {
			throw new IllegalArgumentException("Dimension sizes are not positive!");
		} else {
			this.length = length;
			this.breadth = breadth;
			this.height = height;
			Node = new Object[20000];
			size = 0;
		}
	}

	/**
	 * Add an element at a fixed position.
	 * 
	 * O(1)
	 * @param element The element to be added at the indicated position.
	 * @param x X Coordinate of the position of the element.
	 * @param y Y Coordinate of the position of the element.
	 * @param z Z Coordinate of the position of the element.
	 * @throws IndexOutOfBoundsException If x, y or z coordinates are out of
	 * bounds.
	 */
	@Override
	public void add(int x, int y, int z, T element) throws IndexOutOfBoundsException {
		if (x > this.length || y > this.breadth || z > this.height || x < 0 || y < 0 || z < 0) {
			throw new IndexOutOfBoundsException("Out Of Bounds!");
		} else {
			Node[size++] = new node(x, y, z, element);
		}
	}

	/**
	 * Return the 'oldest' element at the indicated position.
	 * O(n) n is the size of the Node, depends on the number of elements in this Node
	 * @param x X Coordinate of the position of the element.
	 * @param y Y Coordinate of the position of the element.
	 * @param z Z Coordinate of the position of the element.
	 * @return 'Oldest' element at this position or null if no elements at the
	 * indicated position.
	 * @throws IndexOutOfBoundsException If x, y or z coordinates are out of
	 * bounds.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T get(int x, int y, int z) throws IndexOutOfBoundsException {
		if (x > this.length || y > this.breadth || z > this.height || x < 0 || y < 0 || z < 0) {
			throw new IndexOutOfBoundsException("Out Of Bounds!");
		} else {
			for (int i = 0; i < size; i++) {
				if (((node) Node[i]).getX() == x && ((node) Node[i]).getY() == y && ((node) Node[i]).getZ() == z) {
					return ((node) Node[i]).getE();
				}
			}
			return null;

		}

	}

	/**
	 * Return all the elements at the indicated position.
	 * O(n) n is the size of the Node, depends on the number of elements in this Node
	 * @param x X Coordinate of the position of the element(s).
	 * @param y Y Coordinate of the position of the element(s).
	 * @param z Z Coordinate of the position of the element(s).
	 * @return An IterableQueue of all elements at this position or null if no
	 * elements at the indicated position.
	 * @throws IndexOutOfBoundsException If x, y or z coordinates are out of bounds.
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public IterableQueue<T> getAll(int x, int y, int z) throws IndexOutOfBoundsException {
		if (x > this.length || y > this.breadth || z > this.height || x < 0 || y < 0 || z < 0) {
			throw new IndexOutOfBoundsException("Out Of Bounds!");
		} else {
			IterableQueue<T> testQueue = new TraversableQueue<>();
			for (int i = 0; i < size; i++) {
				if (((node) Node[i]).getX() == x && ((node) Node[i]).getY() == y && ((node) Node[i]).getZ() == z) {
					testQueue.enqueue(((node) Node[i]).getE());
				}
			}
			return testQueue;
		}
	}

	/**
	 * Indicates whether there are more than one elements at the indicated
	 * position.
	 * O(n) n is the size of the Node, depends on the number of elements in this Node
	 * @param x X Coordinate of the position of the element(s).
	 * @param y Y Coordinate of the position of the element(s).
	 * @param z Z Coordinate of the position of the element(s).
	 * @return true if there are more than one elements at the indicated
	 * position, false otherwise.
	 * @throws IndexOutOfBoundsException If x, y or z coordinates are out of
	 * bounds.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean isMultipleElementsAt(int x, int y, int z) throws IndexOutOfBoundsException {
		if (x > this.length || y > this.breadth || z > this.height || x < 0 || y < 0 || z < 0) {
			throw new IndexOutOfBoundsException("Out Of Bounds!");
		} else {
			int sign = 0;
			for (int i = 0; i < size; i++) {
				if (((node) Node[i]).getX() == x && ((node) Node[i]).getY() == y && ((node) Node[i]).getZ() == z) {
					sign++;
				}
			}
			if (sign >= 2)
				return true;
			else
				return false;
		}

	}

	/**
	 * Removes the specified element at the indicated position.
	 * O(n) n is the size of the Node, depends on the number of elements in this Node
	 * @param element The element to be removed from the indicated position.
	 * @param x X Coordinate of the position.
	 * @param y Y Coordinate of the position.
	 * @param z Z Coordinate of the position.
	 * @return true if the element was removed from the indicated position,
	 * false otherwise.
	 * @throws IndexOutOfBoundsException If x, y or z coordinates are out of
	 * bounds.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(int x, int y, int z, T element) throws IndexOutOfBoundsException {
		if (x > this.length || y > this.breadth || z > this.height || x < 0 || y < 0 || z < 0) {
			throw new IndexOutOfBoundsException("Out Of Bounds!");
		} else {
			int sign = -1;
			for (int i = 0; i < size; i++) {
				if (((node) Node[i]).getX() == x && ((node) Node[i]).getY() == y && ((node) Node[i]).getZ() == z
						&& ((node) Node[i]).getE() == element) {
					sign = i;
				}
			}
			if (sign != -1) {
				for (int i = sign; i < size - 1; i++) {
					Node[i] = Node[i + 1];
				}
				size--;
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * Removes all elements at the indicated position.
	 * O(n) n is the size of the Node, depends on the number of elements in this Node
	 * @param x X Coordinate of the position.
	 * @param y Y Coordinate of the position.
	 * @param z Z Coordinate of the position.
	 * @throws IndexOutOfBoundsException If x, y or z coordinates are out of
	 * bounds.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void removeAll(int x, int y, int z) throws IndexOutOfBoundsException {
		if (x > this.length || y > this.breadth || z > this.height || x < 0 || y < 0 || z < 0) {
			throw new IndexOutOfBoundsException("Out Of Bounds!");
		} else {
			for (int i = 0; i < size; i++) {
				if (((node) Node[i]).getX() == x && ((node) Node[i]).getY() == y && ((node) Node[i]).getZ() == z) {
					remove(((node) Node[i]).getX(), ((node) Node[i]).getY(), ((node) Node[i]).getZ(),
							((node) Node[i]).getE());
					i--;
				}
			}
		}
	}

	/**
	 * O(1)
	 * Removes all elements stored in the cube.
	 */
	@Override
	public void clear() {
		size = 0;
	}

}

/**
 * Justification: 
 * 	In BoundedCube, every cell in the cube has an array (Node), and the size of Node is 20,000. 
 * 	The aircraft in each Node is represented by a node. Each node represents a aircraft with coordination.
 * 	In this way, the running time of the method depends on the number of aircraft in each node. In each method,
 * 	although the size of Node cannot be changed, but the loop only executes once depending on size. size can be 
 * 	changed. 
 * 
 */
