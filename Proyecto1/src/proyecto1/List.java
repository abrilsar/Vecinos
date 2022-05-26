
package proyecto1;

public class List {
    private Nodo head;
    private int length;
    
    public List(Nodo head){
        if (head == null) {
        length = 0;
        } else {
        length = 1;
        }
        this.head = head;
    }
    public Nodo getHead(){
        return head;
    }
    
    public void setHead(Nodo head){
        this.head = head;
    }
    
    public int getLength(){
        return length;
    }
    
    public boolean isEmpty(){
        return getHead() == null;
    }
    
//    Insertar principio
    public void insertFirst(Object element){
        Nodo nodo = new Nodo(element);
        if (isEmpty()){
            setHead(nodo);
        } else {
            nodo.setNext(getHead());
            setHead(nodo);
        }
        length++;  
    }
    
//   Insertar al final
    public void insertLast(Object element){
        Nodo nodo = new Nodo(element);
        if (isEmpty()){
            setHead(nodo);
        } else {
            Nodo pointer = getHead();
            while (pointer.getNext() != null){
                pointer = pointer.getNext();
            }
            pointer.setNext(nodo);
        } length ++;
    }
    
// Insertar en un índice
    public void insertIndex(int position, Object element){
        Nodo nodo = new Nodo(element);
        if (isEmpty()){
            setHead(nodo);
        } else{
            Nodo pointer = getHead();
            int count = 0;
            while (count < (position -1) && pointer.getNext() != null){
                pointer = pointer.getNext();
                count++;
            }
        nodo.setNext(pointer.getNext());
        pointer.setNext(nodo);
        }length ++;
    }
    
//    Eliminar al principio
    public void deleteFirst(){
        if (!isEmpty()){
            Nodo pointer = getHead();
            setHead(pointer.getNext());
            pointer.setNext(null);
            length --;
        } else {
            System.out.println("La lista está vacía.");
        }
    }
    
//    Eliminar al final
    public void deleteLast(){
        if (!isEmpty()){
            Nodo pointer = getHead();
            while (pointer.getNext().getNext() != null){
               pointer = pointer.getNext();
            }
            pointer.setNext(null);
            length--;
        } else {
            System.out.println("La lista está vacía.");
        }
    }
    
//    Eliminar en posición
    public void deleteIndex(int position){
        if (!isEmpty()){
            Nodo pointer = getHead();
            int count = 0;
            while (count < (position -1) && pointer.getNext() != null){
                pointer = pointer.getNext();
                count++;
            }
            Nodo aux = pointer.getNext();
            pointer.setNext(aux.getNext());
            aux.setNext(null);
            length--;
        }
    }
    
//    RETORNAR NODO Y EN EL MAIN SE OBTIENE EL ELEMENTO
    public Object getElement(int position){
        if (isEmpty()){
            return null;
        } else {
            Nodo pointer = getHead();
            int count = 0;
            while (count < position && pointer.getNext()!= null){
                pointer = pointer.getNext();
                count++;
            }
            if (count == position){
                return pointer.getElement();
            } else {
                return null;
            }
        }
    }
}   
