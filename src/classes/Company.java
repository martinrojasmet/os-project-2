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
public class Company {
    Queue firstPriorityQueue;
    Queue secondPriorityQueue;
    Queue thirdPriorityQueue;
    Queue reinforcementQueue;
    String name;

    public Company(String name) {
        this.name = name;
        this.firstPriorityQueue = new Queue(100);
        this.secondPriorityQueue = new Queue(100);
        this.thirdPriorityQueue = new Queue(100);
        this.reinforcementQueue = new Queue(100);
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
