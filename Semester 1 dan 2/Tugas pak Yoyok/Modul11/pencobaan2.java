public class pencobaan2 {
    static class Node{
        private int data;
        private Node leftchild;
        private Node rightchild;

        public Node (int data){this.data = data;}
        void display(){System.out.println(data);}
        public void setData(int data){this.data = data;}
        public int getData(){return data;}
        public void setLeftChild(Node node){leftchild = node;}
        public Node getLeftChild(){return leftchild;}
        public void setRightChild(Node node){rightchild = node;}
        public Node getRightChild(){return rightchild;}
    }

    static class tree{
        static private Node root;

        public tree(){root = null;}
        public tree(Node node){root = node;}

        public Node find (int key){
            Node current = root;
            if(current != null){
                while(current.data != key){
                    if(key < current.data){
                        current = current.leftchild;
                    }else{
                        current = current.rightchild;
                    }

                    if (current == null) {
                        return null;
                    }
                }
                return current;
            }
            return null;
        }

        public void insert(Node new_node){
            if(root == null){
                root = new_node;
            }else{
                Node current = root;
                Node parent = null;
                while(true){
                    parent = current;
                    if (new_node.data < current.data){
                        current = current.leftchild;
                        if (current == null) {
                            parent.leftchild = new_node;
                            break;
                        }
                    }else{
                        current = current.rightchild;
                        if(current == null){
                            parent.rightchild = new_node;
                            break;
                        }
                    }
                }
            }
        }

        public void inOrderTraversal(Node node){
            if (node != null) {
                inOrderTraversal(node.leftchild);
                System.out.println(node.data + " ");
                inOrderTraversal(node.rightchild);
            }
        }

        public void displayTree(){
            inOrderTraversal(root);
        }
    }
    public static void main(String[] args) {
        tree t = new tree();

        t.insert(new Node(50));
        t.insert(new Node(20));
        t.insert(new Node(75));
        t.insert(new Node(12));
        t.insert(new Node(37));
        t.insert(new Node(43));
        t.insert(new Node(30));
        t.insert(new Node(33));
        t.insert(new Node(87));
        t.insert(new Node(93));
        t.insert(new Node(97));

        t.displayTree();
        System.out.println();

        Node n = t.find(37);
        if(n != null){
            System.out.println("Key ditemukan : "); n.display();
            System.out.println();
        }else{
            System.out.println("Node tidak ditemukan!!!");
        }

        n = t.find(90);
        if(n != null){
            System.out.println("Key ditemukan : "); n.display();
            System.out.println();
        }else{
            System.out.println("Node tidak ditemukan!!!");
        }
    }
}