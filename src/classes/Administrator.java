package classes;

import java.util.logging.Level;
import java.util.logging.Logger;
import primitives.Queue;

/**
 *
 * @author samer
 */
public class Administrator extends Thread {
    private AI processor;
    private double addNewVehicleProbability;
    private double leaveReinforcementQueueProbability;
    private Plant bugattiPlant;
    private Plant lamborghiniPlant;
    private int revisionCycles;
    private int bugattiWins;
    private int lamborghiniWins;
    private String[] winners;
    private int totalQtyWins;

    public Administrator(AI processor, Plant bugattiPlant, Plant lamborghiniPlant) {
        this.processor = processor;
        this.addNewVehicleProbability = Utils.addNewVehicleProbability;
        this.leaveReinforcementQueueProbability = Utils.leaveReinforcementQueueProbability;
        this.bugattiPlant = bugattiPlant;
        this.lamborghiniPlant = lamborghiniPlant;
        this.revisionCycles = Utils.revisionCycles;
        this.bugattiWins = 0;
        this.lamborghiniWins = 0;
        this.totalQtyWins = -1;
        this.winners = new String[100];
    }
    
    public Vehicle chooseVehicleToRace(Plant plant) {
        Vehicle vehicle = null;
        if (!plant.getFirstPriorityQueue().isEmpty()) {
            vehicle = plant.getFirstPriorityQueue().deQueue();
        } else if (!plant.getSecondPriorityQueue().isEmpty()) {
            vehicle = plant.getSecondPriorityQueue().deQueue();
        } else if (!plant.getThirdPriorityQueue().isEmpty()) {
            vehicle = plant.getThirdPriorityQueue().deQueue();
        }
        return vehicle;
    }
    
    public void raceWin(Vehicle bugatti, Vehicle lamborghini) {
        Vehicle winner = this.processor.getRaceWinner();
        if (winner.getId().equals(bugatti.getId())) {
            this.bugattiWins++;
        } else {
            this.lamborghiniWins++;
        }
        this.totalQtyWins++;
        this.winners[this.totalQtyWins] = winner.getId();
    }
    
    public void raceDraw(Vehicle bugatti, Vehicle lamborghini) {
        this.bugattiPlant.getFirstPriorityQueue().enQueue(bugatti);
        this.lamborghiniPlant.getFirstPriorityQueue().enQueue(lamborghini);
    }
    
    public void notAbleToRace(Vehicle bugatti, Vehicle lamborghini) {
        this.bugattiPlant.getReinforcementQueue().enQueue(bugatti);
        this.lamborghiniPlant.getReinforcementQueue().enQueue(lamborghini);
    }
    
    public void dispatchReinforcementVehicle(Plant plant) {
        double randomNum = Math.random();
        if (randomNum <= this.leaveReinforcementQueueProbability && !plant.getReinforcementQueue().isEmpty()) {
            // Se saca de la cola de refuerzo y se pone en la cola de prioridad 1
            Vehicle vehicle = plant.getReinforcementQueue().deQueue();
            plant.getFirstPriorityQueue().enQueue(vehicle);
        }
    }
    
    public void updateVehicleCounters(Plant plant) { //cambiar el nombre y mover a queue (revisar)
        Queue firstPriorityQueue = plant.getFirstPriorityQueue();
        Queue secondPriorityQueue = plant.getSecondPriorityQueue();
        Queue thirdPriorityQueue = plant.getThirdPriorityQueue();
        
        Vehicle[] secondPriority = plant.getSecondPriorityQueue().getItems();
        Vehicle[] thirdPriority = plant.getThirdPriorityQueue().getItems();
        
        // Se actualizan los contadores de los carros de prioridad 2
        if (!secondPriorityQueue.isEmpty()) {
            for (int i = secondPriorityQueue.getFront(); i <= secondPriorityQueue.getRear(); i++) {
                secondPriority[i].setCounter(secondPriority[i].getCounter() + 1);
                if (secondPriority[i].getCounter() == Utils.counterVehicle) {
                    Vehicle vehicle = secondPriorityQueue.deQueue();
                    vehicle.setCounter(0);
                    firstPriorityQueue.enQueue(vehicle);
                    i--;
                } 
            } 
        }
        
        // Se actualizan los contadores de los carros de prioridad 3
        if (!thirdPriorityQueue.isEmpty()) {
            for (int i = thirdPriorityQueue.getFront(); i <= thirdPriorityQueue.getRear(); i++) {
                thirdPriority[i].setCounter(thirdPriority[i].getCounter() + 1);
                if (thirdPriority[i].getCounter() == Utils.counterVehicle) {
                    Vehicle vehicle = thirdPriorityQueue.deQueue();
                    vehicle.setCounter(0);
                    secondPriorityQueue.enQueue(vehicle);
                    i--;
                }
            } 
        }
    }
    
    public void addNewVehicle() {
        double randomNum = Math.random();
        if (randomNum <= Utils.addNewVehicleProbability) {
            // Se crea un carro bugatti
            int bugattiCounter = this.bugattiPlant.getCounterCars();
            Vehicle bugatti = new Vehicle(bugattiCounter, this.bugattiPlant.getName());
            if (bugatti.getPriority() == 1) {
                this.bugattiPlant.getFirstPriorityQueue().enQueue(bugatti);
                this.bugattiPlant.setCounterCars(bugattiCounter + 1);
            } else if (bugatti.getPriority() == 2) {
                this.bugattiPlant.getSecondPriorityQueue().enQueue(bugatti);
                this.bugattiPlant.setCounterCars(bugattiCounter + 1);
            } else if (bugatti.getPriority() == 3) {
                this.bugattiPlant.getThirdPriorityQueue().enQueue(bugatti);
                this.bugattiPlant.setCounterCars(bugattiCounter + 1);
            } else {
                System.out.println("Error en la prioridad del carro");
            }
            
            // Se crea un carro lamborghini
            int lamborghiniCounter = this.lamborghiniPlant.getCounterCars();
            Vehicle lamborghini = new Vehicle(lamborghiniCounter, this.lamborghiniPlant.getName());
            if (lamborghini.getPriority() == 1) {
                this.lamborghiniPlant.getFirstPriorityQueue().enQueue(lamborghini);
                this.lamborghiniPlant.setCounterCars(lamborghiniCounter + 1);
            } else if (lamborghini.getPriority() == 2) {
                this.lamborghiniPlant.getSecondPriorityQueue().enQueue(lamborghini);
                this.lamborghiniPlant.setCounterCars(lamborghiniCounter + 1);
            } else if (lamborghini.getPriority() == 3) {
                this.lamborghiniPlant.getThirdPriorityQueue().enQueue(lamborghini);
                this.lamborghiniPlant.setCounterCars(lamborghiniCounter + 1);
            } else { //quitar (revisar)
                System.out.println("Error en la prioridad del carro");
            }
        }
        this.revisionCycles = Utils.revisionCycles;
    }
    
    public void printWinners() {
        System.out.println("\nWinners:");
        for (int i=0; i <= this.totalQtyWins; i++) {
            System.out.println(this.winners[i]);
        }
    }
    
    public boolean emptyQueues(Plant plant) {
        return plant.getFirstPriorityQueue().isEmpty() && plant.getSecondPriorityQueue().isEmpty() && plant.getThirdPriorityQueue().isEmpty();
    }
    
    @Override
    public void run() {
        while(true) {
            if (!emptyQueues(this.bugattiPlant) && !emptyQueues(this.lamborghiniPlant)) {
                Vehicle bugatti = chooseVehicleToRace(this.bugattiPlant);
                Vehicle lamborghini = chooseVehicleToRace(this.lamborghiniPlant);
                if (bugatti != null && lamborghini != null) {
                    this.processor.race(bugatti, lamborghini);
                    if (this.processor.getRaceStatus().equals(Utils.win)) {
                        raceWin(bugatti, lamborghini);
                        printWinners();
                    } else if (this.processor.getRaceStatus().equals(Utils.draw)) {
                        raceDraw(bugatti, lamborghini);
                    } else if (this.processor.getRaceStatus().equals(Utils.notAbleToRace)) {
                        notAbleToRace(bugatti, lamborghini);
                    }
                    updateVehicleCounters(this.bugattiPlant);
                    updateVehicleCounters(this.lamborghiniPlant);
                    dispatchReinforcementVehicle(this.bugattiPlant);
                    dispatchReinforcementVehicle(this.lamborghiniPlant);
                }  
                this.revisionCycles--;
                if (this.revisionCycles == 0) {
                    addNewVehicle();
                }  
            } else {
                // Se agregan mas carros a la carrera
                addNewVehicle();
                addNewVehicle();
                addNewVehicle();
            }
            
        }
    }
    
    // Getters and setters
    public AI getProcessor() {
        return processor;
    }

    public void setProcessor(AI processor) {
        this.processor = processor;
    }

    public double getAddNewVehicleProbability() {
        return addNewVehicleProbability;
    }

    public void setAddNewVehicleProbability(double addNewVehicleProbability) {
        this.addNewVehicleProbability = addNewVehicleProbability;
    }

    public Plant getBugattiPlant() {
        return bugattiPlant;
    }

    public void setBugattiPlant(Plant bugattiPlant) {
        this.bugattiPlant = bugattiPlant;
    }

    public Plant getLamborghiniPlant() {
        return lamborghiniPlant;
    }

    public void setLamborghiniPlant(Plant lamborghiniPlant) {
        this.lamborghiniPlant = lamborghiniPlant;
    }

    public double getLeaveReinforcementQueueProbability() {
        return leaveReinforcementQueueProbability;
    }

    public void setLeaveReinforcementQueueProbability(double leaveReinforcementQueueProbability) {
        this.leaveReinforcementQueueProbability = leaveReinforcementQueueProbability;
    }

    public int getRevisionCycles() {
        return revisionCycles;
    }

    public void setRevisionCycles(int revisionCycles) {
        this.revisionCycles = revisionCycles;
    }

    public int getBugattiWins() {
        return bugattiWins;
    }

    public void setBugattiWins(int bugattiWins) {
        this.bugattiWins = bugattiWins;
    }

    public int getLamborghiniWins() {
        return lamborghiniWins;
    }

    public void setLamborghiniWins(int lamborghiniWins) {
        this.lamborghiniWins = lamborghiniWins;
    }

    public String[] getWinners() {
        return winners;
    }

    public void setWinners(String[] winners) {
        this.winners = winners;
    }

    public int getTotalQtyWins() {
        return totalQtyWins;
    }

    public void setTotalQtyWins(int totalQtyWins) {
        this.totalQtyWins = totalQtyWins;
    }
    
}
