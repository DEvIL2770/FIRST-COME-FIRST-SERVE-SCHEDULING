public class BSTPriorityQueue {
    BSTNode root;

    public BSTPriorityQueue() {
        root = null;
    }

    public void insert(Process process) {
        root = _insert(root, process);
    }

    // Rest of the methods as in your previous code
    // ...
}
