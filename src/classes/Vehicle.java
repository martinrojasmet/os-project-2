/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.Random;

/**
 *
 * @author marti
 */
public class Vehicle {
    String id;
    int priority;
    int counter;
    
    // La calidad del carro va a ser determinada por un nro. que va del 1 al 3.
    //Siendo el 1 la mas alta calidad y 3 la menor calidad
    int totalGoodQuality;
    boolean bodyworkGoodQuality;
    boolean chasisGoodQuality;
    boolean motorGoodQuality;
    boolean wheelsGoodQuality;
    int individualQualityCounter;
    
    int randomNumber;

    public Vehicle(String id, int priority, int counter, int totalGoodQuality, int bodyworkGoodQuality, int chasisbodyworkGoodQuality, int motorGoodQuality, int wheelsGoodQuality) {
        this.id = id;
        this.priority = priority;
        this.counter = counter;
        this.totalGoodQuality = 5;
        this.bodyworkGoodQuality = false;
        this.chasisGoodQuality = false;
        this.motorGoodQuality = false;
        this.wheelsGoodQuality = false;
        this.individualQualityCounter = 0;
        
        this.DetermineQuality();
    }
    
    public void DetermineQuality() {
        Random random = new Random();
         
        randomNumber = random.nextInt(100);
        if (randomNumber < 60) {
             this.bodyworkGoodQuality = true;
             this.individualQualityCounter++; 
        }
   
        randomNumber = random.nextInt(101);
        if (randomNumber < 70) {
             this.chasisGoodQuality = true;
             this.individualQualityCounter++; 
        }
 
        randomNumber = random.nextInt(101);
        if (randomNumber < 50) {
             this.motorGoodQuality = true;
             this.individualQualityCounter++; 
        }
        
        randomNumber = random.nextInt(101);
        if (randomNumber < 40) {
             this.wheelsGoodQuality = true;
             this.individualQualityCounter++; 
        }
        
        if (this.individualQualityCounter == 4) {
            this.totalGoodQuality = 1;
            this.priority = 1;
        } else if (this.individualQualityCounter == 3) {
            this.totalGoodQuality = 2;
            this.priority = 2;
        } else {
            this.totalGoodQuality = 3;
            this.priority = 3;
        }    
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getTotalGoodQuality() {
        return totalGoodQuality;
    }

    public void setTotalGoodQuality(int totalGoodQuality) {
        this.totalGoodQuality = totalGoodQuality;
    }

    public boolean isBodyworkGoodQuality() {
        return bodyworkGoodQuality;
    }

    public void setBodyworkGoodQuality(boolean bodyworkGoodQuality) {
        this.bodyworkGoodQuality = bodyworkGoodQuality;
    }

    public boolean isChasisGoodQuality() {
        return chasisGoodQuality;
    }

    public void setChasisGoodQuality(boolean chasisGoodQuality) {
        this.chasisGoodQuality = chasisGoodQuality;
    }

    public boolean isMotorGoodQuality() {
        return motorGoodQuality;
    }

    public void setMotorGoodQuality(boolean motorGoodQuality) {
        this.motorGoodQuality = motorGoodQuality;
    }

    public boolean isWheelsGoodQuality() {
        return wheelsGoodQuality;
    }

    public void setWheelsGoodQuality(boolean wheelsGoodQuality) {
        this.wheelsGoodQuality = wheelsGoodQuality;
    }

    public int getIndividualQualityCounter() {
        return individualQualityCounter;
    }

    public void setIndividualQualityCounter(int individualQualityCounter) {
        this.individualQualityCounter = individualQualityCounter;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }
    
}



