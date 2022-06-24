
package exercisestree;

public class NodoBT <T> {
    private T element;
    private NodoBT rightSon, leftSon, father;

    public NodoBT(T element) {
        this.element = element;
        this.rightSon = this.leftSon = this.father = null;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public NodoBT getRightSon() {
        return rightSon;
    }

    public void setRightSon(NodoBT rightSon) {
        this.rightSon = rightSon;
    }

    public NodoBT getLeftSon() {
        return leftSon;
    }

    public void setLeftSon(NodoBT leftSon) {
        this.leftSon = leftSon;
    }

    public NodoBT getFather() {
        return father;
    }

    public void setFather(NodoBT father) {
        this.father = father;
    }
}
