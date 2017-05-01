/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.model;

/**
 *
 * @author Pedro
 */
public class Main {
    
    public static void main(String... args) {
        Story story = new Story()
                .add(
                        new Frame()
                                .add(new DummyStimulus())
                                .add(new DummyStimulus())
                ).add(
                        new Frame()
                                .add(new DummyStimulus())
                );
        story.play();
    }
    
}
