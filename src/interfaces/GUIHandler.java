/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marti
 */
public class GUIHandler extends Thread{
    private boolean keepRunning;
    private GUI gui;

    public GUIHandler(GUI gui) {
        this.keepRunning = true;
        this.gui = gui;
        
    }

    @Override
    public void run() {
        while (this.keepRunning) {
            this.updateQueues();
            this.updateWins();
            this.updateAIwork();
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(GUIHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void updateQueues () {
        this.updateBugattiQueue();
        this.updateLamborghiniQueue();
    }
    
    public void updateLamborghiniQueue() {
        String resultQueue1 = this.gui.getRaceSim().getLamborghini().getFirstPriorityQueue().displayQueue();
        String resultQueue2 = this.gui.getRaceSim().getLamborghini().getSecondPriorityQueue().displayQueue();
        String resultQueue3 = this.gui.getRaceSim().getLamborghini().getThirdPriorityQueue().displayQueue();
        String resultQueue4 = this.gui.getRaceSim().getLamborghini().getReinforcementQueue().displayQueue();
        this.gui.getQueueLamborghini1().setText(resultQueue1);
        this.gui.getQueueLamborghini2().setText(resultQueue2);
        this.gui.getQueueLamborghini3().setText(resultQueue3);
        this.gui.getQueueLamborghini4().setText(resultQueue4);
    }
    
    public void updateBugattiQueue() {
        String resultQueue1 = this.gui.getRaceSim().getBugatti().getFirstPriorityQueue().displayQueue();
        String resultQueue2 = this.gui.getRaceSim().getBugatti().getSecondPriorityQueue().displayQueue();
        String resultQueue3 = this.gui.getRaceSim().getBugatti().getThirdPriorityQueue().displayQueue();
        String resultQueue4 = this.gui.getRaceSim().getBugatti().getReinforcementQueue().displayQueue();
        this.gui.getQueueBugatti1().setText(resultQueue1);
        this.gui.getQueueBugatti2().setText(resultQueue2);
        this.gui.getQueueBugatti3().setText(resultQueue3);
        this.gui.getQueueBugatti4().setText(resultQueue4);
    }
    
    public void updateWins () {
        String resultBugatti = String.valueOf(this.gui.getRaceSim().getAdministrator().getBugattiWins());
        String resultLamborghini = String.valueOf(this.gui.getRaceSim().getAdministrator().getLamborghiniWins());
        this.gui.getWinsBugatti().setText(resultBugatti);
        this.gui.getWinsLamborghini().setText(resultLamborghini);
    }
    
    public void updateAIwork() {
        String status = this.gui.getRaceSim().getProcessor().getStatus();
        this.gui.getAIStatus().setText(status);
    }
    
    public void updateTime() { //falta
        
    }
    
    public void updateCarInfoLamborghini() { //falta
        
    }
    
    public void updateCarInfoBugatti() { //falta
        
    }
    
    public void stopSimulation() { //falta
        
    }
    
    public void updateResult() { //falta
        
    }
    
    public boolean isKeepRunning() {
        return keepRunning;
    }

    public void setKeepRunning(boolean keepRunning) {
        this.keepRunning = keepRunning;
    }
    
}
