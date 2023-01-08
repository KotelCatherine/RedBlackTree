public class RedBlackTree {

    private static Node root;

    Node rightSwap(Node node) {
        Node child = node.rightChild;
        Node childLeft = child.leftChild;

        child.leftChild = node;
        node.rightChild = childLeft;

        return child;
    }

    public Node leftSwap(Node node) {
        Node child = node.leftChild;
        Node childRight = child.rightChild;

        child.rightChild = node;
        node.leftChild = childRight;

        return child;
    }

    public boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return (node.color == Color.RED);
    }

    public void swapColors(Node node1, Node node2) {
        Color temp = node1.color;
        node1.color = node2.color;
        node2.color = temp;
    }

    public Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.leftChild = insert(node.leftChild, value);
        }else if (value > node.value) {
            node.rightChild = insert(node.rightChild, value);
        }else {
            return node;
        }

        if (isRed(node.rightChild) && !isRed(node.leftChild))
        {
            node = rightSwap(node);
            swapColors(node, node.leftChild);
        }

        if (isRed(node.leftChild) && isRed(node.leftChild.leftChild))
        {
            node = leftSwap(node);
            swapColors(node, node.rightChild);
        }

        if (isRed(node.leftChild) && isRed(node.rightChild))
        {
            if (node.color == Color.RED) {
                node.color = Color.BLACK;
            } else if (node.color == Color.BLACK) {
                node.color = Color.RED;
            }

            node.leftChild.color = Color.BLACK;
            node.rightChild.color = Color.BLACK;
        }

        return node;
    }

    public Node find(int value) {
        Node cur = root;
        while (cur != null) {
            if(cur.value == value) {
                return cur;
            }

            if (cur.value < value) {
                cur = cur.rightChild;
            } else {
                cur = cur.leftChild;
            }
        }
        System.out.println(cur);
        return null;
    }

    public void inorder(Node node) {
        if (node != null)
        {
            inorder(node.leftChild);
            System.out.print(node.value + " ");
            inorder(node.rightChild);
        }
    }

    public static void main(String[] args) {
        RedBlackTree node = new RedBlackTree();

        root = node.insert(root, 60);
        root.color = Color.BLACK;

        root = node.insert(root, 20);
        root.color = Color.BLACK;

        root = node.insert(root, 30);
        root.color = Color.BLACK;

        root = node.insert(root, 40);
        root.color = Color.BLACK;

        root = node.insert(root, 50);
        root.color = Color.BLACK;

        root = node.insert(root, 25);
        root.color = Color.BLACK;

        root = node.find(25);
        node.inorder(root);
    }

}