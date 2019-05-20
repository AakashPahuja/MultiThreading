import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import java.util.ArrayList;

/**
   This class implements the FIFO queue data structure.
 */
public class Queue
{
   private ArrayList<String> queue;
   private int size = 0;
   private static final int DEFAULT_SIZE = 10;
   private Lock ElementChangeLock;
   private Condition ElementFullCondition;
   private Condition ElementEmptyCondition;
   /** 
      Constructs the maximum size of the queue to default size.
   */
   public Queue()
   {
      size = DEFAULT_SIZE;
      queue = new ArrayList<String>(size);
      ElementChangeLock = new ReentrantLock();
      ElementFullCondition = ElementChangeLock.newCondition();
      ElementEmptyCondition = ElementChangeLock.newCondition();
   }

   /**
      Constructs the maximum size of the queue to the given size.
      @param aSize the maximum size of the queue
   */
   public Queue(int aSize)
   {
      size = aSize;
      queue = new ArrayList<String>(size);
   }

   /**
      Adds a string into the queue.
      @param item the item to add
   */
   public void add(String item) 
		   throws InterruptedException
   {
	   ElementChangeLock.lock();
	   try{
		   while(queue.size()>=10)
		   {
			   ElementFullCondition.await();
		   }
		    queue.add(item);
		    System.out.println("Element add is:" +item);
		    ElementEmptyCondition.signalAll();
	   }
	   finally
	   {
	     ElementChangeLock.unlock();
	   }
   }

   /**
      Removes one item from the queue.
      @return the first item of the queue
   */
   public void remove()
		   throws InterruptedException
   {
	   ElementChangeLock.lock();
	   try{
		   while(queue.size()==0){
			   ElementEmptyCondition.await();
		   }
      String element = null;
      element = queue.remove(0).toString();
      System.out.println("Element removed is:" +element);
      ElementFullCondition.signalAll();
	   }
	   finally{
		   ElementChangeLock.unlock();
	   }
   }

   /**
      Check if the queue is empty.
      @return true if the queue is empty, else false
   */
   public boolean isEmpty()
   {
      return queue.isEmpty();
   }

   /** 
      Check if the queue is full.
      @return true if queue size equals to maximum size, else false
   */
   public boolean isFull()
   {
      return queue.size() == size;
   }
}
