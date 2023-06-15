package classes;

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

    public Administrator(AI processor, Plant bugattiPlant, Plant lamborghiniPlant) {
        this.processor = processor;
        this.addNewVehicleProbability = Utils.addNewVehicleProbability;
        this.leaveReinforcementQueueProbability = Utils.leaveReinforcementQueueProbability;
        this.bugattiPlant = bugattiPlant;
        this.lamborghiniPlant = lamborghiniPlant;
    }
    
    public Vehicle chooseVehicleToRace(Plant plant) {
        Vehicle vehicle;
        if (!plant.getFirstPriorityQueue().isEmpty()) {
            vehicle = plant.getFirstPriorityQueue().deQueue();;
        } else if (!plant.getSecondPriorityQueue().isEmpty()) {
            vehicle = plant.getSecondPriorityQueue().deQueue();
        } else {
            vehicle = plant.getThirdPriorityQueue().deQueue();
        }
        return vehicle;
    }
    
    public void raceDraw(Vehicle bugatti, Vehicle lamborghini) {
        if (this.processor.getRaceStatus().equals(Utils.draw)) {
            this.bugattiPlant.getFirstPriorityQueue().enQueue(bugatti);
            this.lamborghiniPlant.getFirstPriorityQueue().enQueue(lamborghini);
        }
    }
    
    public void notAbleToRace(Vehicle bugatti, Vehicle lamborghini) {
        if (this.processor.getRaceStatus().equals(Utils.notAbleToRace)) {
            this.bugattiPlant.getReinforcementQueue().enQueue(bugatti);
            this.lamborghiniPlant.getReinforcementQueue().enQueue(lamborghini);
        }
    }
    
    public void dispatchReinforcementVehicle(Plant plant) {
        double randomNum = Math.random();
        if (randomNum <= this.leaveReinforcementQueueProbability) {
            // Se saca de la cola de refuerzo y se pone en la cola de prioridad 1
            Vehicle vehicle = plant.getReinforcementQueue().deQueue();
            plant.getFirstPriorityQueue().enQueue(vehicle);
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
    
}
