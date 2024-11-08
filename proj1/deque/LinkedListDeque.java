package deque;

public class LinkedListDeque<T> implements Deque<T>{

    private LinkNode headNode;
    private int size;

    private class LinkNode {
        private T item;
        private LinkNode pre;
        private LinkNode next;

        public LinkNode(T i, LinkNode p, LinkNode n) {
            item = i;
            pre = p;
            next = n;
        }
    }

    public LinkedListDeque() {
        headNode = new LinkNode(null, null, null);
        headNode.pre = headNode;
        headNode.next = headNode;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        LinkNode newNode = new LinkNode(item, headNode, headNode.next);
        headNode.next.pre = newNode;
        headNode.next = newNode;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        LinkNode newNode = new LinkNode(item, headNode.pre, headNode);
        headNode.pre.next = newNode;
        headNode.pre = newNode;
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        if (isEmpty()) {
            return;
        }
        LinkNode Node = headNode.next;
        while (Node != headNode) {
            System.out.print(Node.item + " ");
            Node = Node.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        LinkNode resultNode = headNode.next;
        headNode.next = headNode.next.next;
        headNode.next.pre = headNode;
        size = size - 1;
        return resultNode.item;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        LinkNode resultNode = headNode.pre;
        headNode.pre = headNode.pre.pre;
        headNode.pre.next = headNode;
        size = size - 1;
        return resultNode.item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        LinkNode Node = headNode.next;
        while (index != 0) {
            Node = Node.next;
            index = index - 1;
        }
        return Node.item;
    }

    private T getRecursiveHelp(int index, LinkNode p) {
        if (index == 0) {
            return p.item;
        }
        return getRecursiveHelp(index - 1, p.next);
    }

    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelp(index, headNode.next);
    }
}
