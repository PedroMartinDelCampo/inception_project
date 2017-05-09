/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.model;

import javafx.animation.SequentialTransition;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Pedro
 */
public class Story implements Animatable {

    private final StringProperty nameProperty = new SimpleStringProperty();
    private final ObservableList<Frame> frames = FXCollections.observableArrayList();
    private final SequentialTransition transition = new SequentialTransition();

    public StringProperty nameProperty() {
        return nameProperty;
    }

    public String getName() {
        return nameProperty.get();
    }

    public Story setName(String name) {
        nameProperty.set(name);
        return this;
    }

    public ObservableList<Frame> getFrames() {
        return frames;
    }

    public Story add(Frame frame) {
        frames.add(frame);
        transition.getChildren().add(frame.asAnimation());
        return this;
    }

    public Frame remove(int i) {
        transition.getChildren().remove(i);
        return frames.remove(i);
    }

    @Override
    public void play() {
        transition.play();
    }

    @Override
    public void pause() {
        transition.pause();
    }

    @Override
    public void stop() {
        transition.stop();
    }

}
