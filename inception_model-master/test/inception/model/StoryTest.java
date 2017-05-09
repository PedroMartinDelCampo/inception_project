/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.model;

import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pedro
 */
public class StoryTest {
    
    private Story story;
    
    public StoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        story = new Story();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testNameProperty() {
        /*
        StringProperty nameProperty = story.nameProperty();
        nameProperty.addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            System.out.println("Old: " + oldValue + ", New: " + newValue);
        });
        */
        String name = "Story";
        story.setName(name);
        assertEquals(name, story.getName());
    }
    
    @Test
    public void testAddFrame() {
        Frame frame = new Frame();
        story.add(frame);
        ObservableList<Frame> frames = story.getFrames();
        assertEquals(frames.size(), 1);
    }
    
    @Test
    public void testRemoveFrame() {
        Frame frame = new Frame();
        story.add(frame);
        Frame removed = story.remove(0);
        assertEquals(removed, frame);
        assertEquals(story.getFrames().size(), 0);
    }
    
    @Test
    public void testPlay() {
        seed(story);
        story.play();
    }
    
    @Test
    public void testPause() {
        seed(story);
        story.play();
        story.pause();
    }
    
    @Test
    public void testStop() {
        seed(story);
        story.play();
        story.stop();
    }
    
    private void seed(Story story) {
        story.setName("Story")
                .add(new Frame())
                .add(new Frame());
    }
    
}
