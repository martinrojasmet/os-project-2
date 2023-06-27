/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import classes.Utils;
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
            this.updateTime();
            this.updateCarsInfo();
            this.updateResult();
            this.updateRounds();
            this.generateRandomNumbers();
            try {
                sleep(20);
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
    
    public void updateTime() {
        int timeToProcess = Integer.parseInt(this.gui.getAITime().getText());
        this.gui.getRaceSim().getProcessor().setTimeToProcess(timeToProcess);
    }
    
    public void updateCarInfoLamborghini() {
        String carId = this.gui.getRaceSim().getProcessor().getLamborghiniVehicleRacing().getId();
        this.gui.getRacingIDLamborghini().setText(carId);
    }
    
    public void updateCarInfoBugatti() {
        String carId = this.gui.getRaceSim().getProcessor().getBugattiVehicleRacing().getId();
        this.gui.getRacingIDBugatti().setText(carId);
    }
    
    public void updateCarsInfo() {
        this.updateCarInfoBugatti();
        this.updateCarInfoLamborghini();
    }
    
    public void updateRounds() {
        String qtyRounds = Integer.toString(this.gui.getRaceSim().getProcessor().getQtyRounds());
        this.gui.getQtyRounds().setText(qtyRounds);
    }
    
    public void stopSimulation() { 
        
    }
    
    public void updateResult() {
        String raceStatus = this.gui.getRaceSim().getProcessor().getRaceStatus();
        if (raceStatus != null) {
            if (raceStatus.equals(Utils.win)) {
                String idWinner = this.gui.getRaceSim().getProcessor().getRaceWinner().getId();
                this.gui.getResult().setText("Ganador: " + idWinner);
            } else {
                this.gui.getResult().setText(raceStatus);
            }  
        } else {
            this.gui.getResult().setText("");
        }  
    }
    
    public void generateRandomNumbers() {
        String randomNumber1 = Integer.toString((int) (Math.random() * 360));
        String randomNumber2 = Integer.toString((int) (Math.random() * 360));
        this.gui.getRacingTimeBugatti().setText(randomNumber1);
         this.gui.getRacingTimeLamborghini().setText(randomNumber2);
    }
    
    public boolean isKeepRunning() {
        return keepRunning;
    }

    public void setKeepRunning(boolean keepRunning) {
        this.keepRunning = keepRunning;
    }
    
}
