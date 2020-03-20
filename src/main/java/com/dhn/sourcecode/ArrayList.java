//package com.dhn.sourcecode;
//
///**
// * @description:
// * @author: Dong HuaNan
// * @date: 2020/3/19 17:25
// */
//import java.util.*;
//import java.util.function.Consumer;
//import java.util.function.Predicate;
//import java.util.function.UnaryOperator;
//import sun.misc.SharedSecrets;
//
//public class ArrayList {
//    private static final long serialVersionUID = 8683452581122892189L;
//
//    /**
//     * 默认初始化容量
//     */
//    private static final int DEFAULT_CAPACITY = 10;
//
//    /**
//     * 空的数组实例
//     */
//    private static final Object[] EMPTY_ELEMENTDATA = {};
//
//    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
//
//    /**
//     * 存储ArrayList元素的数组缓冲区
//     */
//    transient Object[] elementData;
//
//    /**
//     * ArrayList的元素个数
//     */
//    private int size;
//
//    /**
//     * 构造具有指定容量的空list
//     *
//     * @param initialCapacity
//     */
//    public ArrayList(int initialCapacity) {
//        if (initialCapacity > 0) {
//            this.elementData = new Object[initialCapacity];
//        } else if (initialCapacity == 0) {
//            this.elementData = EMPTY_ELEMENTDATA;
//        } else {
//            throw new IllegalArgumentException("Illegal Capacity: " +
//                    initialCapacity);
//        }
//    }
//
//    /**
//     * 构造一个初始容量为10的空列表
//     */
//    public ArrayList() {
//        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
//    }
//
//    /**
//     * Constructs a list containing the elements of the specified
//     * collection, in the order they are returned by the collection's
//     * iterator.
//     *
//     * @param c the collection whose elements are to be placed into this list
//     * @throws NullPointerException if the specified collection is null
//     */
//    public ArrayList(Collection<? extends E> c) {
//        elementData = c.toArray();
//        if ((size = elementData.length) != 0) {
//            // c.toArray might (incorrectly) not return Object[] (see 6260652)
//            if (elementData.getClass() != Object[].class)
//                elementData = Arrays.copyOf(elementData, size, Object[].class);
//        } else {
//            // replace with empty array.
//            this.elementData = EMPTY_ELEMENTDATA;
//        }
//    }
//
//    /**
//     * Trims the capacity of this <tt>ArrayList</tt> instance to be the
//     * list's current size.  An application can use this operation to minimize
//     * the storage of an <tt>ArrayList</tt> instance.
//     */
//    public void trimToSize() {
//        modCount++;
//        if (size < elementData.length) {
//            elementData = (size == 0)
//                    ? EMPTY_ELEMENTDATA
//                    : Arrays.copyOf(elementData, size);
//        }
//    }
//
//    /**
//     * 确保它至少可以容纳最小容量参数指定的元素数量
//     *
//     * @param minCapacity
//     */
//    public void ensureCapacity(int minCapacity) {
//        int minExpand = (elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
//                // any size if not default element table
//                ? 0
//                // larger than default for default empty table. It's already
//                // supposed to be at default size.
//                : DEFAULT_CAPACITY;
//
//        if (minCapacity > minExpand) {
//            ensureExplicitCapacity(minCapacity);
//        }
//    }
//
//    /**
//     * 计算容量
//     *
//     * @param elementData
//     * @param minCapacity
//     * @return
//     */
//    private static int calculateCapacity(Object[] elementData, int minCapacity) {
//        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
//            return Math.max(DEFAULT_CAPACITY, minCapacity);
//        }
//        return minCapacity;
//    }
//
//    private void ensureCapacityInternal(int minCapacity) {
//        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
//    }
//
//    private void ensureExplicitCapacity(int minCapacity) {
//        modCount++;
//
//        // overflow-conscious code
//        if (minCapacity - elementData.length > 0)
//            grow(minCapacity);
//    }
//
//    /**
//     * The maximum size of array to allocate.
//     * Some VMs reserve some header words in an array.
//     * Attempts to allocate larger arrays may result in
//     * OutOfMemoryError: Requested array size exceeds VM limit
//     */
//    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
//
//    /**
//     * 增加容量以确保它至少可以容纳*最小容量参数指定的元素数
//     *
//     * @param minCapacity
//     */
//    private void grow(int minCapacity) {
//        // overflow-conscious code
//        int oldCapacity = elementData.length;
//        int newCapacity = oldCapacity + (oldCapacity >> 1);
//        if (newCapacity - minCapacity < 0)
//            newCapacity = minCapacity;
//        if (newCapacity - MAX_ARRAY_SIZE > 0)
//            newCapacity = hugeCapacity(minCapacity);
//        // minCapacity is usually close to size, so this is a win:
//        elementData = Arrays.copyOf(elementData, newCapacity);
//    }
//
//    private static int hugeCapacity(int minCapacity) {
//        if (minCapacity < 0) // overflow
//            throw new OutOfMemoryError();
//        return (minCapacity > MAX_ARRAY_SIZE) ?
//                Integer.MAX_VALUE :
//                MAX_ARRAY_SIZE;
//    }
//
//
//    public int size() {
//        return size;
//    }
//
//
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//
//    public boolean contains(Object o) {
//        return indexOf(o) >= 0;
//    }
//
//
//    public int indexOf(Object o) {
//        if (o == null) {
//            for (int i = 0; i < size; i++)
//                if (elementData[i] == null)
//                    return i;
//        } else {
//            for (int i = 0; i < size; i++)
//                if (o.equals(elementData[i]))
//                    return i;
//        }
//        return -1;
//    }
//
//
//    public int lastIndexOf(Object o) {
//        if (o == null) {
//            for (int i = size - 1; i >= 0; i--)
//                if (elementData[i] == null)
//                    return i;
//        } else {
//            for (int i = size - 1; i >= 0; i--)
//                if (o.equals(elementData[i]))
//                    return i;
//        }
//        return -1;
//    }
//
//
//    public Object clone() {
//        try {
//            java.util.ArrayList<?> v = (java.util.ArrayList<?>) super.clone();
//            v.elementData = Arrays.copyOf(elementData, size);
//            v.modCount = 0;
//            return v;
//        } catch (CloneNotSupportedException e) {
//            // this shouldn't happen, since we are Cloneable
//            throw new InternalError(e);
//        }
//    }
//
//
//    public Object[] toArray() {
//        return Arrays.copyOf(elementData, size);
//    }
//
//
//    @SuppressWarnings("unchecked")
//    public <T> T[] toArray(T[] a) {
//        if (a.length < size)
//            // Make a new array of a's runtime type, but my contents:
//            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
//        System.arraycopy(elementData, 0, a, 0, size);
//        if (a.length > size)
//            a[size] = null;
//        return a;
//    }
//
//
//    @SuppressWarnings("unchecked")
//    E elementData(int index) {
//        return (E) elementData[index];
//    }
//
//
//    public E get(int index) {
//        rangeCheck(index);
//
//        return elementData(index);
//    }
//
//
//    public E set(int index, E element) {
//        rangeCheck(index);
//
//        E oldValue = elementData(index);
//        elementData[index] = element;
//        return oldValue;
//    }
//
//    /**
//     * 将指定的元素追加到此列表的末尾
//     *
//     * @param e
//     * @return
//     */
//    public boolean add(E e) {
//        ensureCapacityInternal(size + 1);
//        elementData[size++] = e;
//        return true;
//    }
//
//    /**
//     * Inserts the specified element at the specified position in this
//     * list. Shifts the element currently at that position (if any) and
//     * any subsequent elements to the right (adds one to their indices).
//     *
//     * @param index   index at which the specified element is to be inserted
//     * @param element element to be inserted
//     * @throws IndexOutOfBoundsException {@inheritDoc}
//     */
//    public void add(int index, E element) {
//        rangeCheckForAdd(index);
//
//        ensureCapacityInternal(size + 1);  // Increments modCount!!
//        System.arraycopy(elementData, index, elementData, index + 1,
//                size - index);
//        elementData[index] = element;
//        size++;
//
//    }
//}
