/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.model;

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
public class FrameTest {
    
    private Frame frame;
    
    public FrameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        frame = new Frame();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testPlay() {
        frame.add(new DummyStimulus()).play();
    }
    
    @Test
    public void testPause() {
        frame.pause();
    }
    
    @Test
    public void testStop() {
        frame.stop();
    }
    
    @Test
    public void testAddTimeline() {
        frame.add(new DummyStimulus());
        assertEquals(frame.getStimuli().size(), 1);
    }
    
    @Test
    public void testRemoveTimeline() {
        Stimulus timeline = new DummyStimulus();
        frame.add(timeline);
        Stimulus result = frame.remove(0);
        assertEquals(result, timeline);
    }
    
}
