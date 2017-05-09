/*
Inception Concurrency
*/
package inception.concurrency;

/**
 * A step is the basic unit of work.
 * @author Pedro
 */
public abstract class Step extends Thread {
    
    @Override
    public abstract void run();
    
}
