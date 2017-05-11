/*
Inception Concurrency
*/
package inception.concurrency;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Pedro
 */
public class ParallelExecutor extends GroupExecutor {
    
    private final Lock lock = new ReentrantLock();
    
    @Override
    public synchronized void run() {
        List<Step> steps = getSteps();
        steps.forEach(step -> {
            step.start();
        });
        lock.lock();
        try {
            while (alive()) {
                // noop
            }
        } finally {
            lock.unlock();
        }
        notifyAll();
    }
    
    private boolean alive() {
        List<Step> steps = getSteps();
        for (int i  = 0; i < steps.size(); i++) {
            Step step = steps.get(i);
            if (step.isAlive()) {
                return true;
            }
        }
        return false;
    }
    
}
