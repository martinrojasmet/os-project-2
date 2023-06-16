/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoso2;

import classes.RaceSimulator;
import interfaces.GUI;

/**
 *
 * @author samer
 */
public class ProyectoSO2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        
//        Vehicle vehicle = new Vehicle(0, "Bugatti");
//        Vehicle vehicle1 = new Vehicle(1, "Bugatti");
//        Vehicle vehicle2 = new Vehicle(2, "Bugatti");
//        Vehicle vehicle3 = new Vehicle(3, "Bugatti");
//        Queue queue = new Queue(3);
//        System.out.println(queue.isFull());
//        System.out.println(queue.isEmpty());
//        queue.enQueue(vehicle);
//        queue.enQueue(vehicle1);
//        queue.enQueue(vehicle2);
//        System.out.println(queue.isFull());
//        System.out.println(queue.isEmpty());
//        queue.deQueue();
//        queue.enQueue(vehicle3);
//        queue.deQueue();
//        queue.enQueue(vehicle2);
//        ((Vehicle) queue.peak()).printCarId();
//        System.out.println(queue.isFull());
//        System.out.println(queue.isEmpty());
//        queue.displayCars();
        GUI gui = new GUI();
        gui.setVisible(true);
        RaceSimulator race = new RaceSimulator();
        race.start();
    }
    
}
