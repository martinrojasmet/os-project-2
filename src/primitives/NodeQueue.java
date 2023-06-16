package primitives;

/**
 *
 * @author marti
 */
public class NodeQueue {
    private Object element;
   private NodeQueue next;

    public NodeQueue(Object element) {
        this.element = element;
        this.next = null;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public NodeQueue getNext() {
        return next;
    }

    public void setNext(NodeQueue next) {
        this.next = next;
    }
}
