
package binarytree;

public class BinaryTree <T> {
    private NodoBT root;

    public BinaryTree(NodoBT root) {
        this.root = root;
    }

    public NodoBT getRoot() {
        return root;
    }

    public void setRoot(NodoBT root) {
        this.root = root;
    }
    
    public boolean isEmpty(){
        return root == null;
    }
    
    public void insertIzq(T father, T element){
        NodoBT nodo = search(root, father);
        NodoBT sonIzq = new NodoBT(element);
        nodo.setLeftSon(sonIzq);
    }
    
    public void insertDer(T father, T element){
        NodoBT nodo = search(root, father);
        NodoBT sonDer = new NodoBT(element);
        nodo.setRightSon(sonDer);
    }
    
    public NodoBT search(NodoBT root, T element){
        NodoBT found = null;
        if(root != null && isEmpty()==false){
            if (root.getElement()== element){
                return root;
            }
            if (root.getLeftSon() != null){
                found = search(root.getLeftSon(), element);
            }
            if (found == null){
                found = search(root.getRightSon(), element);
            }
            return found;
        }else{
            System.out.println("No se ha encontrado el padre");
            return null;
        }
    }
    
    public void printPreOrden(NodoBT root){
        if (root != null){
            System.out.println("{" + root.getElement() + "}");
            printPreOrden(root.getLeftSon());
            printPreOrden(root.getRightSon());
        }
    }
    
    public void printPostOrden(NodoBT root){
        if (root != null){
            printPostOrden(root.getLeftSon());
            printPostOrden(root.getRightSon());
            System.out.println("{" + root.getElement() + "}");
        }
    }
    
    public void printInOrden(NodoBT root){
        if (root != null){
            printInOrden(root.getLeftSon());
            System.out.println("{" + root.getElement() + "}");
            printInOrden(root.getRightSon());
        }
    }
}
