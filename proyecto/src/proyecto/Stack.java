
package proyecto;


public class Stack<T> {
    private Nodo peek;
    private int length;

    public Stack() {
        this.peek = null;
        this.length = 0;
    }

    public Nodo getPeek() {
        return peek;
    }

    public void setPeek(Nodo peek) {
        this.peek = peek;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    
    public boolean isEmpty() {
        return getPeek() == null;
    }
    
    public void push(T data) {
        Nodo nodo = new Nodo(data);
        nodo.setNext(getPeek());
        setPeek(nodo);
        length++;
    }
    
     public void pop() {
        if (!isEmpty()){
            Nodo temp = getPeek();
            setPeek(getPeek().getNext());
            temp.setNext(null);
            setLength(getLength() - 1);
        }
    }
}
