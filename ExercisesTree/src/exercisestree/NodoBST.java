
package exercisestree;

public class NodoBST {
    private int element;
    private NodoBST rightSon, leftSon, father;

    public NodoBST(int element) {
        this.element = element;
        this.rightSon = this.leftSon = this.father = null;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public NodoBST getRightSon() {
        return rightSon;
    }

    public void setRightSon(NodoBST rightSon) {
        this.rightSon = rightSon;
    }

    public NodoBST getLeftSon() {
        return leftSon;
    }

    public void setLeftSon(NodoBST leftSon) {
        this.leftSon = leftSon;
    }

    public NodoBST getFather() {
        return father;
    }

    public void setFather(NodoBST father) {
        this.father = father;
    }
}
