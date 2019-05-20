import java.util.ArrayList;

public class ThreadRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 Queue queue = new Queue();
	 final int count = 10;
	 final int THREADS = 10;
	 
	 for (int i = 1; i <= THREADS; i++)
	   {
	      Producer p = new Producer(queue, count);
	      Consumer c = new Consumer(queue, count);
	      
	      Thread pt = new Thread(p);
	      Thread ct = new Thread(c);
	      
	      pt.start();
	      ct.start();
	   }
	 
	}

}
