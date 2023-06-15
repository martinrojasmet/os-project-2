package primitives;

import classes.Vehicle;

/**
 *
 * @author marti
 */
public class Queue {
    int lenght;
    Vehicle[] items;
    int front;
    int rear;

    public Queue(int lenght) {
        this.lenght = lenght;
        this.items = new Vehicle[lenght];
        this.front = -1;
        this.rear = -1;
    }

    public boolean isFull() {
        return rear == lenght - 1;
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public void enQueue(Vehicle itemValue) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else if (isEmpty()) {
            front = rear = 0;
            items[rear] = itemValue;
        } else {
            rear++;
            items[rear] = itemValue;
        }
    }

    public Vehicle deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else if (front == rear) {
            Vehicle vehicle = items[front];
            front = rear = -1;
            return vehicle;
        } else {
            Vehicle vehicle = items[front];
            for (int i = front; i < rear; i++) {
                items[i] = items[i + 1];
            }
            rear--;
            return vehicle;
        }
        return null;
    }

//    public void display() {
//        if (isEmpty()) {
//            System.out.println("Queue is empty, underflow condition!!");
//        } else {
//            for (int i = front; i <= rear; i++) {
//                System.out.println(items[i]);
//            }
//        }
//    }
    
    public void displayCars() {
        if (isEmpty()) {
            System.out.println("Queue is empty, underflow condition!!");
        } else {
            for (int i = front; i <= rear; i++) {
                items[i].printCarId();
            }
        }
    }

    public Vehicle getPeak() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        } else {
            return items[front];
        }
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public Vehicle[] getItems() {
        return items;
    }

    public void setItems(Vehicle[] items) {
        this.items = items;
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int getRear() {
        return rear;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }
    
    
}



