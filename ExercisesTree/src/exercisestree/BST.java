
package exercisestree;

public class BST {
    private NodoBST root;

    public BST() {
        this.root = null;
    }

    public NodoBST getRoot() {
        return root;
    }

    public void setRoot(NodoBST root) {
        this.root = root;
    }
    
    public boolean isEmpty(){
        return root == null;
    }
    
    public void preOrden(NodoBST root){
        if (root != null){
            System.out.println("{ "+root.getElement()+" }");
            preOrden(root.getLeftSon());
            preOrden(root.getRightSon());
        }
    }
    
    public void inOrden(NodoBST root){
        if (root != null){
            inOrden(root.getLeftSon());
            System.out.println("{ "+root.getElement()+" }");
            inOrden(root.getRightSon());
        }
    }
    
    public void postOrden(NodoBST root){
        if (root != null){
            postOrden(root.getLeftSon());
            postOrden(root.getRightSon());
            System.out.println("{ "+root.getElement()+" }");
        }
    }
    
    public NodoBST searchNodo(NodoBST root,int element){
        if (root == null) {
            return null;
        } else {
            if (root.getElement() == element) {
                return root;
            } else {
                if (root.getElement() < element) {
                    return searchNodo(root.getRightSon(), element);
                } else{
                    return searchNodo(root.getLeftSon(), element);
                }
            }
        }
    }
    
    public NodoBST insertNodoRecursive(NodoBST root, int element, NodoBST father){
        NodoBST nodo = new NodoBST(element);
        if (isEmpty()){
            setRoot(nodo);
        }else{
            if (root == null){
                nodo.setFather(father);
                return nodo;
            }else{
                if (root.getElement() > element){
                    root.setLeftSon(insertNodoRecursive(root.getLeftSon(), element, root));
                }else{
                    root.setRightSon(insertNodoRecursive(root.getRightSon(), element, root));
                }
            }
        }
        return root;
    }
    
    public void insertNodo(NodoBST root, int element){
        NodoBST nodo = new NodoBST(element);
        NodoBST aux = root;
        if (isEmpty()){
            setRoot(nodo);
        }else{
            while (true){
                if (aux.getElement() > element){
                    if (aux.getLeftSon()== null){
                        aux.setLeftSon(nodo);
                        nodo.setFather(aux);
                        break;
                    }else{
                        aux = aux.getLeftSon();
                    }
                }else{
                    if (aux.getRightSon() == null){
                        aux.setRightSon(nodo);
                        nodo.setFather(aux);
                        break;
                    }else{
                        aux = aux.getRightSon();
                    }
                }
            }
        }
    }
    
    public void deleteNodo(NodoBST root, int element){
        if (root == null) {
            System.out.println("El nodo no ha sido encontrado");
        } else {
            if (root.getElement() == element) {
                if (root.getLeftSon() == null && root.getRightSon() == null) {
                    // Es una hoja
                    if (root.getFather().getLeftSon().getElement() == element) {
                        root.getFather().setLeftSon(null);
                    } else {
                        root.getFather().setRightSon(null);
                    }
                    root.setFather(null);
                } else if(root.getLeftSon() == null) {
                    // Solo tiene hijo derecho
                    if (root.getFather().getLeftSon().getElement() == element) {
                        root.getFather().setLeftSon(root.getRightSon());
                    } else {
                        root.getFather().setRightSon(root.getRightSon());
                    }
                    root.setRightSon(null);
                    root.setFather(null);
                } else if(root.getRightSon()== null) {
                    // Solo tiene hijo izquierdo
                    if (root.getFather().getLeftSon().getElement() == element) {
                        root.getFather().setLeftSon(root.getLeftSon());
                    } else {
                        root.getFather().setRightSon(root.getLeftSon());
                    }
                    root.setLeftSon(null);
                    root.setFather(null);
                } else {
                    // Tiene dos hijos
                    NodoBST nodo = searchMin(root.getRightSon());
                    if (root.getFather().getLeftSon().getElement() == element) {
                        nodo.setLeftSon(root.getLeftSon());
                        nodo.setRightSon(root.getRightSon());
                        nodo.getFather().setLeftSon(null);
                        nodo.setFather(root.getFather());
                        root.getFather().setLeftSon(nodo);
                    } else {
                        nodo.setLeftSon(root.getLeftSon());
                        nodo.setRightSon(root.getRightSon());
                        nodo.getFather().setLeftSon(null);
                        nodo.setFather(root.getFather());
                        root.getFather().setRightSon(nodo);
                    }
                    root.setFather(null);
                    root.setLeftSon(null);
                    root.setRightSon(null);
                }
            } else if (root.getElement() < element) {
                deleteNodo(root.getRightSon(), element);
            } else {
                deleteNodo(root.getLeftSon(), element);
            }
        }
    }
    
    public NodoBST searchMin(NodoBST root) {
        while (root.getLeftSon() != null){
            root = root.getLeftSon();
        }
        return root;
    }
     
    public NodoBST searchFather(NodoBST nodo, NodoBST root){
        if (nodo == null || root == null){
            return null;
        }else if (root.getLeftSon() != null && root.getLeftSon() == nodo || root.getRightSon() != null && root.getRightSon() == nodo){
            return root;
        }else{
            NodoBST found = searchFather(nodo, root.getLeftSon());
            if (found == null){
                found = searchFather(nodo, root.getRightSon());
            }
            return found;
        }
    }
    
    public int ACMP(int val1, int val2){
        NodoBST nodo1 = new NodoBST(val1);
        NodoBST nodo2 = new NodoBST(val2);
        
        if (root.getElement() == val1 || root.getElement() == val2){
            return root.getElement();
        }
        NodoBST ancestro = Ancestro(root, nodo1, nodo2);
        return ancestro.getElement();
    }
    
    public NodoBST Ancestro(NodoBST root, NodoBST nodo1, NodoBST nodo2){
        NodoBST aux = root;
        while (aux != null){
            if (aux.getElement() == nodo1.getElement() || aux.getElement() == nodo1.getElement()){
                return aux.getFather();
            }
            if (nodo1.getElement()> aux.getElement()&& nodo2.getElement()> aux.getElement()){
                aux = aux.getRightSon();
            }else if (nodo1.getElement()< aux.getElement()&& nodo2.getElement()< aux.getElement()){
                aux = aux.getLeftSon();
            }else{
                return aux;
            }
        }
        return null;
    }
}
