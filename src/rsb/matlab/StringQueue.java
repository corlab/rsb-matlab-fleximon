package rsb.matlab;

import java.util.concurrent.TimeUnit;

import rsb.util.QueueAdapter;

/**
 * Simple queuing callback adapting generic push-style RSBJava callback
 * interface to a simple, specialized and Matlab- compatible pull-style
 * interface.
 * 
 * @author cemmeric
 */
public class StringQueue extends QueueAdapter<String> {

	/**
	 * Delegate function to return queue objects as a list. It blocks until a
	 * result is available. Returned objects are removed from the underlying
	 * blocking queue.
	 * 
	 * @return string
	 * @throws InterruptedException
	 */
	public String take(int ms) throws InterruptedException {
		return getQueue().poll(ms, TimeUnit.MILLISECONDS);
	}

	public StringQueue(final int capacity, final boolean discardOldest) {
		super(capacity, discardOldest);
	}
	
}
