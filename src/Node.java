public class Node {
    Node leftChild;
    Node rightChild;
    int value;
    Color color;

    Node(int value) {
        this.value = value;
        leftChild = null;
        rightChild = null;
        color = Color.RED;
    }
}
