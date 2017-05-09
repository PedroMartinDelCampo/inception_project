/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.model;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Pedro
 */
public class Frame implements Animatable {

    private final ObservableList<Stimulus> stimuli = FXCollections.observableArrayList();
    private Animation.Status status = Animation.Status.STOPPED;
    private AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            for (Stimulus s : stimuli) {
                s.play();
            }
        }
    };
    
    @Override
    public void play() {
        if (status == Animation.Status.STOPPED) {
            timer.stop();
        }
        timer.start();
    }
    
    @Override
    public void pause() {
        for (int i = 0; i < stimuli.size(); i++) {
            stimuli.get(i).pause();
        }
        timer.stop();
    }

    @Override
    public void stop() {
        for (int i = 0; i < stimuli.size(); i++) {
            stimuli.get(i).stop();
        }
        timer.stop();
    }

    public Frame add(Stimulus stimulus) {
        stop();
        stimuli.add(stimulus);
        return this;
    }

    public Stimulus remove(int i) {
        stop();
        Stimulus removed = stimuli.remove(i);
        return removed;
    }
    
    public ObservableList<Stimulus> getStimuli() {
        return stimuli;
    }
    
    public Animation asAnimation() {
        return null;
    }
    
}
