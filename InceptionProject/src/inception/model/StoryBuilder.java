/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.model;

import inception.model.Frame;
import inception.model.Story;
import javafx.collections.ObservableList;

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
    private int totalFrameCount = -1;
    
    public void selectFrame(int i) {
        selectedFrame = i;
    }
    
    public int addFrame() {
        Frame frame = new Frame();
        story.add(frame);
        totalFrameCount++; 
        return totalFrameCount;
    }
    
    public int deleteFrame(){
        if(selectedFrame!=-1){
            story.remove(selectedFrame);
            totalFrameCount--;
        }
        return selectedFrame;
    }
    
    public Frame selectedFrame() {
        if (selectedFrame == -1){
            return null;
        }
        return story.getFrames().get(selectedFrame);
    }
    
    public ObservableList<Frame> getFrames(){
        return story.getFrames();
    } 
    
    public Frame getFrame(int index){
        return story.getFrames().get(index);
    }
    
    public void playStory(){
        story.play();
    }
    
    public void stopStory(){
        story.end();
    }
    
}
