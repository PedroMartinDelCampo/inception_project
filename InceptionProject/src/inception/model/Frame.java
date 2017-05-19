/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.model;

import inception.concurrency.ParallelExecutor;
import inception.concurrency.Step;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Pedro
 */
public class Frame implements Animatable {

    private final ObservableList<Stimulus> stimuli = FXCollections.observableArrayList();
    private final ParallelExecutor executor = new ParallelExecutor();
    
    @Override
    public void play() {
        executor.start();
    }

    @Override
    public void end() {
        executor.interrupt();
    }

    public Frame add(Stimulus stimulus) {
        stimuli.add(stimulus);
        executor.add(stimulus);
        return this;
    }

    public Stimulus remove(int i) {
        executor.remove(i);
        Stimulus removed = stimuli.remove(i);
        return removed;
    }
    
    public ObservableList<Stimulus> getStimuli() {
        return stimuli;
    }
    
    public Step getStep() {
        return executor;
    }
    
     public int selectedTimeline(int i){
        return i;
    }
     
     
    
}
