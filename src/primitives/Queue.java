/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitives;

/**
 *
 * @author marti
 */
public class Queue<T> {
    int len;
    T items[];
    int front;
    int rear;

    public Queue(int len) {
        this.len = len;
        this.items = (T[]) new Object[len];
        this.front = -1;
        this.rear = -1;
    }

    public boolean isFull() {
        return rear == len - 1;
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public void enQueue(T itemValue) {
        if (isFull()) {
            System.out.println("Queue is full, Overflow condition");
        } else if (isEmpty()) {
            front = rear = 0;
            items[rear] = itemValue;
        } else {
            rear++;
            items[rear] = itemValue;
        }
    }

    public void deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing to dequeue. Underflow condition!!");
        } else if (front == rear) {
            front = rear = -1;
        } else {
            for (int i = front; i < rear; i++) {
                items[i] = items[i + 1];
            }
            rear--;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty, underflow condition!!");
        } else {
            for (int i = front; i <= rear; i++) {
                System.out.println(items[i]);
            }
        }
    }

    public void peak() {
        if (isEmpty()) {
            System.out.println("Queue is empty, underflow condition!!");
        } else {
            System.out.println("Front index value is: " + items[front]);
        }
    }
}



