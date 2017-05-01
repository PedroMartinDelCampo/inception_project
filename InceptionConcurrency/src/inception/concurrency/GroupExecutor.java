/*
Inception Concurrency
*/
package inception.concurrency;

import java.util.ArrayList;
import java.util.List;

/**
 * A GroupExecutor is a step compund by other steps.
 * @author Pedro
 */
public abstract class GroupExecutor extends Step {
    
    private final List<Step> steps;
    
    public GroupExecutor() {
        steps = new ArrayList<>();
    }
    
    /**
     * 
     * @return Steps contained in this GroupExecutor
     */
    public List<Step> getSteps() {
        return steps;
    }
    
    @Override
    public abstract void run();
    
    @Override
    public void interrupt() {
        steps.forEach((step) -> {
            step.interrupt();
        });
        super.interrupt();
    }
    
    /**
     * Adds a step to the GroupExecutor
     * @param step
     * @return A self reference, for method chaining
     */
    public GroupExecutor add(Step step) {
        steps.add(step);
        return this;
    }
    
    /**
     * Removes the ith step
     * @param i
     * @return A self reference, for mwthod reference
     */
    public GroupExecutor remove(int i) {
        steps.remove(i);
        return this;
    }
    
}
