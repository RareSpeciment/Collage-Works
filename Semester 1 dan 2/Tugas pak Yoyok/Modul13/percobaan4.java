class Node {
    private int data;
    private Node leftChild;
    private Node rightChild;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}

public class percobaan4 {
    private Node root;
    
    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while(current != null && current.getData() != key) {
            parent = current;
            if(key < current.getData()) {
                isLeftChild = true;
                current = current.getLeftChild();
            } else {
                isLeftChild = false;
                current = current.getRightChild();
            }
        }

        if(current == null) {
            return false;
        }

        if(current.getLeftChild() == null && current.getRightChild() == null) {
            if(current == root) {
                root = null;
            } else if(isLeftChild) {
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }
        }
        else if(current.getLeftChild() == null) {
            if(current == root) {
                root = current.getRightChild();
            } else if(isLeftChild) {
                parent.setLeftChild(current.getRightChild());
            } else {
                parent.setRightChild(current.getRightChild());
            }
        }
        else if(current.getRightChild() == null) {
            if(current == root) {
                root = current.getLeftChild();
            } else if(isLeftChild) {
                parent.setLeftChild(current.getLeftChild());
            } else {
                parent.setRightChild(current.getLeftChild());
            }
        }
        else {
            Node successor = getSuccessor(current);
            
            if(current == root) {
                root = successor;
            } else if(isLeftChild) {
                parent.setLeftChild(successor);
            } else {
                parent.setRightChild(successor);
            }
            
            successor.setLeftChild(current.getLeftChild());
        }
        
        return true;
    }

    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.getRightChild();
        
        while(current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }
        
        if(successor != delNode.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(delNode.getRightChild());
        }
        
        return successor;
    }
}
