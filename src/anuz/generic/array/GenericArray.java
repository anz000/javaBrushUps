package anuz.generic.array;

interface GenericArray<T> {
	/**
	 * This method will add the element to the array
	 * @param t
	 */
    void add (T t);
    
    /**
     * This method will update the object at the given index
     * @param index
     * @param t
     * @throws Exception
     */
    void update (int index, T t) throws Exception;
    
    /**
     * This method will delete the object at the given index
     * @param index
     * @throws Exception
     */
    void delete (int index) throws Exception ;
    
    /**
     * The method will retrieve the object at the given index
     * @param index
     * @throws Exception
     */
    T get (int index) throws Exception;

	
}
