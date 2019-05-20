import java.util.Date;
public class Producer implements Runnable {
	private static final int DELAY = 1000; 
	private Queue queue;
	private int count;

	   /**
	      Constructs the runnable object.
	      @param aGreeting the greeting to display
	   */
	   public Producer(Queue Anqueue, int count)
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
	            String now = new Date().toString();
	            queue.add(now);
	            Thread.sleep(DELAY);         
	         }
	    	  }
	      }
	      catch (InterruptedException exception)
	      {
	      }
	      }
	   }
	   

