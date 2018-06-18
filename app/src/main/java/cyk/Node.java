package cyk;

public class Node {
    private Production production;
    private Node left;
    private Node right;

    public Node(Production production, Node left, Node right) {
        this.production = production;
        this.left = left;
        this.right = right;
    }


    public Production getProduction() {
        return production;
    }

    public void setProduction(Production production) {
        this.production = production;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
