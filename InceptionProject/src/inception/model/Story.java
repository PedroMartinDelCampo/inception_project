/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.model;

import inception.concurrency.BatchExecutor;
import java.lang.Thread.State;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Pedro
 */
public class Story implements Animatable {

    private final ObservableList<Frame> frames = FXCollections.observableArrayList();
    private final BatchExecutor executor = new BatchExecutor();

    public ObservableList<Frame> getFrames() {
        return frames;
    }

    public Story add(Frame frame) {
        frames.add(frame);
        executor.add(frame.getStep());
        return this;
    }

    public Frame remove(int i) {
        executor.remove(i);
        return frames.remove(i);
    }

    @Override
    public void play() {
        State threadState= executor.getState();
        if(threadState==Thread.State.TERMINATED||threadState== Thread.State.WAITING){
            executor.run();
        }else{
            executor.start();
        }
        
    }

    @Override
    public void end() {
        executor.interrupt();
    }

}
