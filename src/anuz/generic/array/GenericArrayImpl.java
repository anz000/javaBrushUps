package anuz.generic.array;

import java.util.Arrays;

public class GenericArrayImpl<T> implements GenericArray<T> {

	private static final int DEFAULT_SIZE = 1;
	private int size;
	private T[] arr;

	private int index = -1;

	// default constructor
	public GenericArrayImpl() {
		this(DEFAULT_SIZE);
	}

	// Overloaded constructor
	@SuppressWarnings("unchecked")
	public GenericArrayImpl(int length) {
		this.size = length;
		arr = (T[]) new Object[size];
	}

	/**
	 * This method will add the element to the array
	 * 
	 * @param t
	 */
	@Override
	public void add(T t) {
		if (index > -1 && arr[arr.length - 1] != null)
			increaseArraySize();
		arr[++index] = t;
	}

	/**
	 * This method will update the object at the given index
	 * 
	 * @param index
	 * @param t
	 * @throws Exception
	 */
	@Override
	public void update(int index, T t) throws Exception {
		if (index > this.index)
			throw new Exception(" The index is not present");

		arr[index] = t;
	}

	/**
	 * This method will delete the object at the given index
	 * 
	 * @param index
	 */
	@Override
	public void delete(int index) throws Exception {
		if (index > this.index)
			throw new Exception(" The index is not present");

		arr[index] = null;
		fixArray(index);

	}

	/**
	 * This method will retrieve the object at the given index
	 * 
	 * @param index
	 * @return
	 */
	@Override
	public T get(int index) throws Exception {
		if (index > this.index)
			throw new Exception(" The index is not present");

		return (T) arr[index];
	}

	/**
	 * This method will fix the array if in between index is deleted moves the
	 * deleted index to the last and shifts the remaining array to the left
	 */
	private void fixArray(int index) {
		if (arr == null || arr.length <= 1) {
			return;
		}
		// System.out.println(this);
		T start = arr[index];
		System.arraycopy(arr, index + 1, arr, index, (arr.length - 1) - index);
		arr[arr.length - 1] = start;
		// System.out.println("AFTER");
		// System.out.println(this);
	}

	/**
	 * This array will dynamically grow the size of the array
	 */
	private void increaseArraySize() {
		arr = Arrays.copyOf(arr, arr.length * 2);
	}

	/**
	 * toString
	 */
	public String toString() {
		String s = "";
		for (T temp : arr) {
			s += temp + "\n";
		}
		return s;
	}
}
