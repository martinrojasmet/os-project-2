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
public class RaceSimulator{
    Semaphore mutex;
    AI processor;
    Administrator administrator;
    Plant bugatti;
    Plant lamborghini;

    public RaceSimulator() {
        this.processor = new AI(10);
        this.bugatti = new Plant("Bugatti");
        this.lamborghini = new Plant("Lamborghini");
        this.administrator = new Administrator(this.processor, this.bugatti, this.lamborghini);
    }
    
    public void start() {
        this.bugatti.generateFirstTenCars();
        this.lamborghini.generateFirstTenCars();
        this.administrator.start();
    }

    public AI getProcessor() {
        return processor;
    }

    public void setProcessor(AI processor) {
        this.processor = processor;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Plant getBugatti() {
        return bugatti;
    }

    public void setBugatti(Plant bugatti) {
        this.bugatti = bugatti;
    }

    public Plant getLamborghini() {
        return lamborghini;
    }

    public void setLamborghini(Plant lamborghini) {
        this.lamborghini = lamborghini;
    }
    
    
}
