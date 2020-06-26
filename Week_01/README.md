本周是算法训练营的第一周，主要讲解了数组、链表、跳表、栈、队列等数据结构。

1.数组是顺序存储，查找的时间复杂度是O(1)，增删的时间复杂度是O(n)，在数组尾部增删的时间复杂度是O(1)。

2.链表非顺序存储，查找的时间复杂度是O(n)，增删的时间复杂度是O(1)。

3.跳表是增加了向前指针的链表，跳表的查询时间复杂度为O(logN)，Redis内部就是使用跳表来实现的。

3.栈是一种 LIFO（后进先出）的数据结构，增删的时间复杂度都为O(1), 查找的时间复杂度为O(n)。

4.队列是一种FIFO（先进先出）的数据结构,在 FIFO 队列中，所有的新元素都插入队列的末尾，移除元素从队列头部移除。


在实际工程应用中较少使用Stack(栈)，使用比较多的是Deque(双端队列)，即可作为栈，也可以作为队列。

作为栈，使用Push方法入栈，使用Pop方法出栈。

作为队列，尽量避免使用add()和remove()方法，而是要使用offer()来加入元素，使用poll()来获取并移出元素。

它们的优点是通过返回值可以判断成功与否，add()和remove()方法在失败的时候会抛出异常。



用add first或add last这套新的API改写Deque的代码:

		Deque<String> deque = new LinkedList<String>();

		deque.addFirst("a");
		deque.addFirst("b");
		deque.addFirst("c");
		System.out.println(deque);

		String str = deque.peek();
		System.out.println(str);
		System.out.println(deque);

		while (deque.size() > 0) {
			System.out.println(deque.removeFirst());
		}

		System.out.println(deque);
	

分析Queue和Priority Queue的源码:

Java中Queue为一个接口，集成Collection接口，实现可以为LinkedBlockingQueue,LinkedList,PriorityQueue等。

普通队列特点，先进先出。插入队列和移出队列的时间复杂度都为O(1)。

PriorityQueue优先级队列，不同于普通队列，优先级队列默认按照元素的自然顺序排序（也可以重写comparator接口compare方法进行自定义排序）插入。移出队列和普通队列一样，但插入队列的时间复杂度与元素个数N有关，时间复杂度为O(n)。

PriorityQueue实现了Queue接口，其中的add方法源码如下：

    // add方法底层还是调用offer方法
    public boolean add(E e) {
        return offer(e);
    }
    
    public boolean offer(E e) {
        //元素为空则抛出异常
        if (e == null)
            throw new NullPointerException();
	    
	//modCount是 The number of times this priority queue has been
	//应该是插入元素的数量
        modCount++;
	
	//长度不够则扩容
        int i = size;
        if (i >= queue.length)
            grow(i + 1);  //扩容函数
        size = i + 1;
        
	
	if (i == 0)
            queue[0] = e; //长度为0，则赋值给下标为0的位置，由此可见PriorityQueue底层是对象数组
        else
            siftUp(i, e); //排序并插入元素
        
	return true;
    }




    /**
     * Inserts item x at position k, maintaining heap invariant by
     * promoting x up the tree until it is greater than or equal to
     * its parent, or is the root.
     *
     * To simplify and speed up coercions and comparisons. the
     * Comparable and Comparator versions are separated into different
     * methods that are otherwise identical. (Similarly for siftDown.)
     *
     * @param k the position to fill
     * @param x the item to insert
     */
    private void siftUp(int k, E x) {
        if (comparator != null)
            siftUpUsingComparator(k, x);  //指定比较器排序
        else
            siftUpComparable(k, x);  //插入的元素类实现Comparable接口来排序
    }

    @SuppressWarnings("unchecked")
    private void siftUpComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>) x;
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = queue[parent];
            if (key.compareTo((E) e) >= 0)
                break;
            queue[k] = e;
            k = parent;
        }
        queue[k] = key;
    }

    @SuppressWarnings("unchecked")
    private void siftUpUsingComparator(int k, E x) {
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = queue[parent];
            if (comparator.compare(x, (E) e) >= 0)
                break;
            queue[k] = e;
            k = parent;
        }
        queue[k] = x;
    }
