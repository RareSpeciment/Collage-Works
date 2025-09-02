public class percobaan2 {
    static class Node {
        private int data;
        private int height;
        private Node leftChild;
        private Node rightChild;

        public Node(int data) {
            this.data = data;
            height = 1;
        }

        public void setData(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getHeight() {
            return height;
        }

        public void setLeftChild(Node node) {
            leftChild = node;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setRightChild(Node node) {
            rightChild = node;
        }

        public Node getRightChild() {
            return rightChild;
        }
    }

    static class AVLTree {
        private Node root;

        public void setTree(Node root) {
            this.root = root;
        }

        public Node getTree() {
            return root;
        }

        private int getDataBalanceFavtor(Node node) {
            if (node == null) {
                return 0;
            }
            return (height(node.getLeftChild()) - height(node.getRightChild()));
        }

        public int height(Node node) {
            if (node == null) {
                return 0;
            }
            return node.getHeight();
        }

        public Node rightRotation(Node pivot) {
            Node temp_1 = pivot.leftChild;
            Node temp_1r = temp_1.rightChild;

            temp_1.rightChild = pivot;
            pivot.leftChild = temp_1r;

            pivot.setHeight(Math.max(height(pivot.leftChild), height(pivot.rightChild)) + 1);
            temp_1.setHeight(Math.max(height(temp_1.leftChild), height(temp_1.rightChild)) + 1);

            return temp_1;
        }

        public Node leftRotation(Node pivot) {
            Node temp_r = pivot.rightChild;
            Node temp_rl = temp_r.leftChild;

            temp_r.leftChild = pivot;
            pivot.rightChild = temp_rl;

            pivot.setHeight(Math.max(height(pivot.leftChild), height(pivot.rightChild)) + 1);
            temp_r.setHeight(Math.max(height(temp_r.leftChild), height(temp_r.rightChild)) + 1);

            return temp_r;
        }

        public Node find(int key) {
            Node current = root;
            if (current != null) {
                while (current.data != key) {
                    if (key < current.data) {
                        current = current.leftChild;
                    } else {
                        current = current.rightChild;
                    }

                    if (current == null) {
                        return null;
                    }
                }
                return current;
            }
            return null;
        }

        public Node insert(Node root, Node new_node) {
            if (root == null) {
                return new_node;
            }

            if (new_node.data < root.data) {
                root.setLeftChild(insert(root.leftChild, new_node));
            } else if (new_node.data > root.data) {
                root.setRightChild(insert(root.rightChild, new_node));
            } else {
                return root;
            }

            root.setHeight(Math.max(height(root.leftChild), height(root.rightChild)) + 1);
            int balance_factor = getDataBalanceFavtor(root);

            // if this node become unbalanced then there is 4 cases rotation :

            // left Rotation
            if (balance_factor > 1 && new_node.data < root.leftChild.data) {
                return rightRotation(root);
            }

            // right Rotation
            if (balance_factor < -1 && new_node.data > root.rightChild.data) {
                return leftRotation(root);
            }

            // left - right rotation
            if (balance_factor > 1 && new_node.data > root.leftChild.data) {
                root.setLeftChild(leftRotation(root.leftChild));
                return rightRotation(root);
            }

            // right - left rotation
            if (balance_factor < -1 && new_node.data < root.rightChild.data) {
                root.setRightChild(rightRotation(root.rightChild));
                return leftRotation(root);
            }

            return root;
        }

        private void inOrderTraversal(Node root) {
            if(root != null){
                inOrderTraversal(root.leftChild);
                System.out.println(root.data + " ");
                inOrderTraversal(root.rightChild);
            }
        }

        public void displayTree() {
            inOrderTraversal(root);
        }

    }

    public static void main(String[] args) {
        AVLTree t = new AVLTree();

        t.setTree(t.insert(t.getTree(), new Node(1)));
        t.setTree(t.insert(t.getTree(), new Node(2)));
        t.setTree(t.insert(t.getTree(), new Node(3)));
        t.setTree(t.insert(t.getTree(), new Node(4)));
        t.setTree(t.insert(t.getTree(), new Node(5)));
        t.setTree(t.insert(t.getTree(), new Node(6)));
        t.setTree(t.insert(t.getTree(), new Node(7)));
        t.setTree(t.insert(t.getTree(), new Node(8)));
        t.setTree(t.insert(t.getTree(), new Node(9)));
        t.setTree(t.insert(t.getTree(), new Node(10)));

        t.displayTree();
        System.out.println();
        Node n = t.find(7);
        if (n != null) {
            System.out.println("Found: " + n.getData());
        } else {
            System.out.println("Data not found");
        }
    }
}