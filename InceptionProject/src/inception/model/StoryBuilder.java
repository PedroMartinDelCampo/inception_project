/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.model;

/**
 *
 * @author Humberto
 */
public class StoryBuilder {
    
    private static final StoryBuilder instance = new StoryBuilder();
    
    private StoryBuilder() {}
    
    public static StoryBuilder getInstance() {
        return instance;
    }
    
    private final Story story = new Story();
    private int selectedFrame = -1;
    
    public void selectFrame(int i) {
        selectedFrame = i;
    }
    
    public int addFrame() {
        Frame frame = new Frame();
        story.add(frame);
        return ++selectedFrame;
    }
    
    public Frame selectedFrame() {
        return story.getFrames().get(selectedFrame);
    }
    
}