import java.util.Date;

public class Consumer implements Runnable {
	private static final int DELAY = 1000; 
	private Queue queue;
	private int count;
	 
   public Consumer(Queue Anqueue, int count)
	   {
	      queue = Anqueue;
	      this.count = count;
	   }

	   public void run()
	   {
	      try
	      {
	    	  for (int i=0; i <= count; i++){
	         {
	            queue.remove();
	            Thread.sleep(DELAY);         
	         }
	    	  }
	      }
	      catch (InterruptedException exception)
	      {
	      }
	      }
	   }
	   

