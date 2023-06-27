package classes;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samer
 */
public class AI extends Thread {
    private int timeToProcess;
    private String status;
    private double winningProbability;
    private double drawProbability;
    private double notAbleToRaceProbability;
    private int qtyRounds;
    private Vehicle bugattiVehicleRacing;
    private Vehicle lamborghiniVehicleRacing;
    private String raceStatus;
    private Vehicle raceWinner;

    public AI(int timeToProcess) {
        this.timeToProcess = timeToProcess;
        this.status = Utils.waitingStatus;
        this.winningProbability = Utils.winProbability;
        this.drawProbability = Utils.drawProbability;
        this.notAbleToRaceProbability = Utils.notAbleToRaceProbability;
        this.qtyRounds = 0;
        this.bugattiVehicleRacing = null;
        this.lamborghiniVehicleRacing = null;
        this.raceWinner = null;
    }
    
    public Vehicle win(Vehicle bugatti, Vehicle lamborghini) {
        // Procedimiento para escoger ganador
        Vehicle winner;
        
        int qtyBugattiQuality = getQuality(bugatti);
        int qtyLamborghiniQuality = getQuality(lamborghini);
        
        if (qtyBugattiQuality > qtyLamborghiniQuality) {
            winner = bugatti;
        } else {
            winner = lamborghini;
        }
        
        return winner;
    }
    
    public void race(Vehicle bugatti, Vehicle lamborghini) {
        if (bugatti != null && lamborghini != null) {
            try {
                this.setBugattiVehicleRacing(bugatti);
                this.setLamborghiniVehicleRacing(lamborghini);
                this.setStatus(Utils.decidingStatus);

                sleep((this.timeToProcess * 1000) - 500) ;
                this.setStatus(Utils.announcingStatus);
                sleep(500); //para poder verlo
                double randomNum = Math.random();
                if (randomNum <= 1) {
                    Vehicle winner = win(bugatti, lamborghini);
                    this.raceStatus = Utils.win;
                    this.setRaceWinner(winner);
                } else if (randomNum <= this.winningProbability + this.drawProbability) {
                    this.raceStatus = Utils.draw;
                } else {
                    this.raceStatus = Utils.notAbleToRace;
                }
                this.qtyRounds++;
                this.setStatus(Utils.waitingStatus);
                sleep(100); //para poder verlo

            } catch (InterruptedException ex) {
                Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }   
    }
    
    public int getQuality(Vehicle vehicle) {
        // Se verifica cada parte del carro. Si es de calidad se suma su probabilidad a un contador
        // Por el contrario, si no es de calidad se suma la mitad de su probabilidad al contador
        int qtyBugattiQuality = 0;
        
        if (vehicle.isBodyworkGoodQuality()) {
            qtyBugattiQuality += 60;
        } else {
            qtyBugattiQuality += 30;
        }
        
        if (vehicle.isBodyworkGoodQuality()) {
            qtyBugattiQuality += 60;
        } else {
            qtyBugattiQuality += 30;
        }
        
        if (vehicle.isWheelsGoodQuality()) {
            qtyBugattiQuality += 40;
        } else {
            qtyBugattiQuality += 20;
        }
        
        if (vehicle.isMotorGoodQuality()) {
            qtyBugattiQuality += 50;
        } else {
            qtyBugattiQuality += 25;
        }
        
        return qtyBugattiQuality;
    }
     
    // Getters and setters
    public int getTimeToProcess() {
        return timeToProcess;
    }

    public void setTimeToProcess(int timeToProcess) {
        this.timeToProcess = timeToProcess;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getWinningProbability() {
        return winningProbability;
    }

    public void setWinningProbability(double winningProbability) {
        this.winningProbability = winningProbability;
    }

    public double getDrawProbability() {
        return drawProbability;
    }

    public void setDrawProbability(double drawProbability) {
        this.drawProbability = drawProbability;
    }

    public double getNotAbleToRaceProbability() {
        return notAbleToRaceProbability;
    }

    public void setNotAbleToRaceProbability(double notAbleToRaceProbability) {
        this.notAbleToRaceProbability = notAbleToRaceProbability;
    }

    public int getQtyRounds() {
        return qtyRounds;
    }

    public void setQtyRounds(int qtyRounds) {
        this.qtyRounds = qtyRounds;
    }

    public Vehicle getBugattiVehicleRacing() {
        return bugattiVehicleRacing;
    }

    public void setBugattiVehicleRacing(Vehicle bugattiVehicleRacing) {
        this.bugattiVehicleRacing = bugattiVehicleRacing;
    }

    public Vehicle getLamborghiniVehicleRacing() {
        return lamborghiniVehicleRacing;
    }

    public void setLamborghiniVehicleRacing(Vehicle lamborghiniVehicleRacing) {
        this.lamborghiniVehicleRacing = lamborghiniVehicleRacing;
    }

    public String getRaceStatus() {
        return raceStatus;
    }

    public void setRaceStatus(String raceStatus) {
        this.raceStatus = raceStatus;
    }

    public Vehicle getRaceWinner() {
        return raceWinner;
    }

    public void setRaceWinner(Vehicle raceWinner) {
        this.raceWinner = raceWinner;
    }
    
}
