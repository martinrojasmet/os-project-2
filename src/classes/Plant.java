/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import primitives.Queue;

/**
 *
 * @author marti
 */
public class Plant {
    Queue firstPriorityQueue;
    Queue secondPriorityQueue;
    Queue thirdPriorityQueue;
    Queue reinforcementQueue;
    String name;
    int counterCars;

    public Plant(String name) {
        this.name = name;
        this.firstPriorityQueue = new Queue(100);
        this.secondPriorityQueue = new Queue(100);
        this.thirdPriorityQueue = new Queue(100);
        this.reinforcementQueue = new Queue(100);
        this.counterCars = 0;
    }
    
    public void generateFirstTenCars() {
        for (int i = 0; i < 10; i++) {
            Vehicle vehicle = new Vehicle(i, this.name);
            if (vehicle.getPriority() == 1) {
                this.firstPriorityQueue.enQueue(vehicle);
                this.counterCars++;
            } else if (vehicle.getPriority() == 2) {
                this.secondPriorityQueue.enQueue(vehicle);
                this.counterCars++;
            } else if (vehicle.getPriority() == 3) {
                this.thirdPriorityQueue.enQueue(vehicle);
                this.counterCars++;
            } else {
                System.out.println("Error en la prioridad del carro");
            }
        }
    }

    public String getName() {
        return name;
    }

    public Queue getFirstPriorityQueue() {
        return firstPriorityQueue;
    }

    public void setFirstPriorityQueue(Queue firstPriorityQueue) {
        this.firstPriorityQueue = firstPriorityQueue;
    }

    public Queue getSecondPriorityQueue() {
        return secondPriorityQueue;
    }

    public void setSecondPriorityQueue(Queue secondPriorityQueue) {
        this.secondPriorityQueue = secondPriorityQueue;
    }

    public Queue getThirdPriorityQueue() {
        return thirdPriorityQueue;
    }

    public void setThirdPriorityQueue(Queue thirdPriorityQueue) {
        this.thirdPriorityQueue = thirdPriorityQueue;
    }

    public Queue getReinforcementQueue() {
        return reinforcementQueue;
    }

    public void setReinforcementQueue(Queue reinforcementQueue) {
        this.reinforcementQueue = reinforcementQueue;
    }
    
}
