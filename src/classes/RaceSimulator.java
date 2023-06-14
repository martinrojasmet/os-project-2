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

    public RaceSimulator() {
        this.mutex =new Semaphore(1);
        //this.AI
        //this.Administrator
    }
    
}
