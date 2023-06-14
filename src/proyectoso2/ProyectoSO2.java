/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoso2;

import primitives.Queue;

/**
 *
 * @author samer
 */
public class ProyectoSO2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue queue = new Queue(3);
                System.out.println(queue.isFull());
        System.out.println(queue.isEmpty());
        queue.enQueue(3);
        queue.enQueue(38);
        queue.enQueue(2);
        System.out.println(queue.isFull());
                System.out.println(queue.isEmpty());
        queue.deQueue();
        queue.enQueue(2);
        queue.deQueue();
        queue.deQueue();
        queue.enQueue(345);
        queue.peak();
        System.out.println(queue.isFull());
        System.out.println(queue.isEmpty());
        queue.display();
    }
    
}
