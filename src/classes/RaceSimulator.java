/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.concurrent.Semaphore;

/**
 *
 * @author marti
 */
public class RaceSimulator {
    Semaphore mutex;
    //AI
    //Administrator
    Plant bugatti;
    Plant lamborghini;

    public RaceSimulator() {
        this.mutex =new Semaphore(1);
        //this.AI
        //this.Administrator
        this.bugatti = new Plant("Bugatti");
        this.lamborghini = new Plant("Lamborghini");
    }
    
    public void start() {
        this.bugatti.generateFirstTenCars();
        this.lamborghini.generateFirstTenCars();
        
//        System.out.println("Lamborghini");
//        System.out.println("1");
//        this.lamborghini.getFirstPriorityQueue().displayCars();
//        System.out.println("2");
//        this.lamborghini.getSecondPriorityQueue().displayCars();
//        System.out.println("3");
//        this.lamborghini.getThirdPriorityQueue().displayCars();
//        
//        System.out.println("Bugatti");
//        System.out.println("1");
//        this.bugatti.getSecondPriorityQueue().displayCars();
//        System.out.println("2");
//        this.bugatti.getFirstPriorityQueue().displayCars();
//        System.out.println("3");
//        this.bugatti.getThirdPriorityQueue().displayCars();
    }
}
