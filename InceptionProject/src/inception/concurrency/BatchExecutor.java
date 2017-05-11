/*
Inception Concurrency
*/
package inception.concurrency;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pedro
 */
public class BatchExecutor extends GroupExecutor {
    
    @Override
    public void run() {
        getSteps().forEach((step) -> {
            try {
                step.start();
                step.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
