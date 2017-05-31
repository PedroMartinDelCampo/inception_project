/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.model;

/**
 *
 * @author Fernando Flores García
 */


public class Test {
    public int stimulusCounter=0;
    
    private Test(){
        
    }
    
    private static final Test instance = new Test();
    
    public static Test getInstance() {
        return instance;
    }
    
    public void countStimulus(){
        stimulusCounter++;
        System.out.println("Stimulus Counter " + stimulusCounter);
    }
    
    
}
