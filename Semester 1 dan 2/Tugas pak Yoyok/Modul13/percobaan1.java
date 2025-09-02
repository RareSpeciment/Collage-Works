public class percobaan1{
    class Node {
        private int data;
        private int height;
        private Node leftChild;
        private Node rightChild;
        public Node(int data) { this.data = data; height = 1; }
        public void setData(int data) { this.data = data; }
        public int getData() { return data; }
        public void setHeight(int height) { this.height = height; }
        public int getHeight() { return height; }
        public void setLeftChild(Node node) { leftChild = node; }
        public Node getLeftChild() { return leftChild; }
        public void setRightChild(Node node) { rightChild = node; }
        public Node getRightChild() { return rightChild; }
    }

    public static void main(String[] args) {
        
    }
}