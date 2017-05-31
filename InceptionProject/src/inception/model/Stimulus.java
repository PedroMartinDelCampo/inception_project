/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.model;

import inception.concurrency.Step;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Duration;

/**
 *
 * @author Pedro
 */
public abstract class Stimulus extends Step implements Animatable {
    
    private Duration start = Duration.ZERO;
    private final Test testCounter= Test.getInstance();
    public Duration getStart() {
        return start;
    }

    public void setStart(Duration start) {
        this.start = start;
    }

    public abstract Duration getLength();
    
    @Override
    public final void play() {
       
        try {            
            System.out.println("Stimulus initiated");
            Thread.sleep((long) start.toMillis());
            /*Thread one = new Thread() {
                @Override
                public void run() {
                    try {
                        System.out.println("Does it work?");
                        
                        Thread.sleep(1000);
                        
                    } catch(InterruptedException v) {
                        System.out.println(v);
                    }
                }
            };

        one.start();*/
            testCounter.countStimulus();
            execute();
        } catch (InterruptedException ex) {
            Logger.getLogger(Stimulus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public final void run() {
        play();
    }

    @Override
    public void interrupt() {
        end();
        super.interrupt();
    }
    
    protected abstract void execute();
    
}
