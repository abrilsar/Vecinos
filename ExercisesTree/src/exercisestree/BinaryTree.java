
package exercisestree;

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
    
    public boolean isEmpty(NodoBT root){
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
    
    public NodoBT search(NodoBT nodo, T element){
        NodoBT found = null;
        if(nodo != null && isEmpty(root)==false){
            if (nodo.getElement()== element){
                return nodo;
            }
            if (nodo.getLeftSon() != null){
                found = search(nodo.getLeftSon(), element);
            }
            if (found == null){
                found = search(nodo.getRightSon(), element);
            }
            return found;
        }else{
//            System.out.println("No se ha encontrado el padre");
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
    
    private boolean sameStructure(NodoBT root1, NodoBT root2){
        boolean same = true;
        if (root1 == null || root2 == null){
            return false;
        }
        if ((root1.getLeftSon() != null || root2.getLeftSon() != null) && same){
            same = sameStructure(root1.getLeftSon(),root2.getLeftSon() );
        }
        if ((root1.getRightSon() != null || root2.getRightSon() != null) && same){
            same = sameStructure(root1.getRightSon(),root2.getRightSon() );
        }
        return same;
    }
    
    public boolean sameStructure(NodoBT root2){
        return sameStructure(getRoot(), root2);
    }
    
    private boolean sameValue(NodoBT root1, NodoBT root2){
        boolean same = true;
        if (root1 == null || root2 == null || root1.getElement() != root2.getElement()){
            return false;
        }
        if ((root1.getLeftSon() != null || root2.getLeftSon() != null) && same){
            same = sameValue(root1.getLeftSon(),root2.getLeftSon() );
        }
        if ((root1.getRightSon() != null || root2.getRightSon() != null) && same){
            same = sameValue(root1.getRightSon(),root2.getRightSon() );
        }
        return same;
    }
    
    public boolean sameValue(NodoBT root2){
        return sameValue(getRoot(), root2);
    }
    
    private boolean sameMirrorStructure(NodoBT root1, NodoBT root2){
        boolean same = true;
        if (root1 == null || root2 == null){
            return false;
        }
        if ((root1.getLeftSon() != null || root2.getRightSon() != null) && same){
            same = sameStructure(root1.getLeftSon(),root2.getRightSon() );
        }
        if ((root1.getRightSon() != null || root2.getLeftSon() != null) && same){
            same = sameStructure(root1.getRightSon(),root2.getLeftSon() );
        }
        return same;
    }
    
    public boolean sameMirrorStructure(NodoBT root2){
        return sameMirrorStructure(getRoot(), root2);
    }
}
