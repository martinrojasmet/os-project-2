package primitives;

import classes.Vehicle;

/**
 *
 * @author marti
 */
public class Queue {
    private NodeQueue front, rear;
    private int length;

    public Queue(){
        this.front = null;
        this.rear = null;
        this.length = 0;       
    }

    public NodeQueue getFront() {
        return front;
    }

    public void setFront(NodeQueue front) {
        this.front = front;
    }

    public NodeQueue getRear() {
        return rear;
    }

    public void setRear(NodeQueue rear) {
        this.rear = rear;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void enQueue(Object element) {
        NodeQueue node = new NodeQueue(element);
        if(isEmpty()) {
            setFront(node);
            setRear(node);
        } else {
            getRear().setNext(node);
            setRear(node);
        }
        setLength(getLength() + 1);
    }

    public void deQueue1() {
        if(!isEmpty()) {
            if (getLength() == 1){
                setFront(null);
                setRear(null);
            } else {
                NodeQueue temp = getFront();
                setFront(temp.getNext());
                temp.setNext(null);
            }
            setLength(getLength() - 1);
        } 
    }
    
    public boolean isEmpty() {
        return getFront() == null;
    }

    public Object getPeak() {
        return getFront().getElement();
    }

    public Vehicle deQueue() {
        Object temp = getPeak();
        deQueue1();
        return ((Vehicle) temp);
    }
    
    public void displayCars() {
        if (this.isEmpty()) {
            System.out.println("Cola esta vacia");
        } else {
            NodeQueue pointer = this.front;
            while (pointer != null) {
                ((Vehicle) pointer.getElement()).printCarId();
                NodeQueue temp = pointer.getNext();
                pointer = temp;
            }
        }
    }
    
    public void moveCars(Queue nextQueue) {
        if (!this.isEmpty()) {
            NodeQueue pointer = this.front;
            while (pointer != null) {
                int previousCount1 = ((Vehicle) pointer.getElement()).getCounter()+1;
                ((Vehicle) pointer.getElement()).setCounter(previousCount1);
                if (((Vehicle) pointer.getElement()).getCounter() == 8) {
                    this.deQueue();
                }
                NodeQueue temp = pointer.getNext();
                pointer = temp;
            }
        }
    }
}
