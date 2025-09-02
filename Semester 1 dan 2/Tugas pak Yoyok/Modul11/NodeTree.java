public class NodeTree{
    class Node{
        private int data;
        private Node leftchild;
        private Node rightchild;

        public Node (int data){this.data = data;}
        public void setData(int data){this.data = data;}
        public int getData(){return data;}
        public void setLeftChild(Node node){leftchild = node;}
        public Node getLeftChild(){return leftchild;}
        public void setRightChild(Node node){rightchild = node;}
        public Node getRightChild(){return rightchild;}
    }
    public static void main(String[] args) {
        
    }
}