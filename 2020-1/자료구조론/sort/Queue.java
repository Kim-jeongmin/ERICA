package sort;

public class Queue {
    
    /*
     * [Class] Node
     *   1) ����
     *     - Queue�� data�� ��� ���
     *     - �� ���� ���� ��带 ����Ű�� �־�� ��
     *     - data type�� ���ڶ�� ����
     *   2) �ʼ� operation
     *     - ������
     *     - getData(): ���� ��尡 ������ �ִ� data�� ��ȯ�ϴ� �Լ�
     *     - getNext(): ���� ��尡 ����Ű�� �ִ� Node�� ��ȯ�ϴ� �Լ�
     *     - setNext(): ���� ����� ����Ű�� �ִ� Node�� �����ϴ� �Լ�
     */
    
    private static class Node {
        private int data;   // Node���� �����ϴ� data
        private Node next;  // Node�� ����Ű�� �ִ� ���� ���
        
        /* [�ʼ�] ������ */
        public Node(int d) {
            data = d;
            next = null;
        }
        
        /* [�ʼ�] getData() */
        public int getData() {
            return data;
        }
        
        /* [�ʼ�] getNext() */
        public Node getNext() {
            return next;
        }
        
        /* [�ʼ�] setNext() */
        public void setNext(Node n) {
            next = n;
        }
    }
    
    /*
     * [Class] Queue
     *   1) ����
     *     - Queue�� �� ���� ����Ű�� first�� ����
     *     - Queue�� �� �ڸ� ����Ű�� last�� ����
     *     - data�� �߰��� ���� queue�� last�� �߰�
     *     - data�� ������ ���� queue�� first�� �ִ� ������ ����
     *   2) �ʼ� operation
     *     - enqueue(): queue�� �������� data�� �߰��ϴ� �Լ�
     *     - dequeue(): queue�� ���� ���� ��带 �����ϰ� data�� ��ȯ�ϴ� �Լ�
     *     - first(): queue�� �� ���� data�� ��ȯ�ϴ� �Լ�
     *     - size(): queue�� �� ���� data�� ����ִ��� ��ȯ�ϴ� �Լ�
     *     - isEmpty(): queue�� ������� Ȯ��
     *   3) �߰� operation
     *     - popAll(): stack�� ��� data�� ����
     */
    
    private Node first;     // queue�� ���� �� �κ��� ����Ű�� ���
    private Node last;      // queue�� ���� �� �κ��� ����Ű�� ���
    private int size;       // queue�� ũ�� ����
    
    /* [�ʼ�] ������ */
    public Queue() {
        first = null;
        last = null;
        size = 0;
    }
    
    /* [�ʼ�] size() */
    public int size() {
        return size;
    }
    
    /* [�ʼ�] isEmpty() */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /* 
     * [�ʼ�] enqueue()
     *    - �����͸� �Է¹޾Ƽ� queue�� ���� ���� �߰�
     */
    public void enqueue(int data) {
        Node n = new Node(data);
        if (isEmpty()) {
            first = n;
        } else {
            last.setNext(n);
        }
        last = n;
        size++;
    }
    
    /*
     * [�ʼ�] dequeue()
     *    - queue�� ���� �� ��带 �����ϰ� data�� ��ȯ
     *    - ���� ���� ��� '-' ����
     */
    public int dequeue() {
        if (isEmpty()) {
            return -1;
        }
        Node n = first;
        first = n.getNext();
        n.setNext(null);
        size--;
        return n.getData();
    }
    
    /*
     * [�ʼ�] first()
     *  - queue�� ���� �� ����� data�� ��ȯ
     *  - ���� ���� ��� '-' ����
     */
    public int first() {
        if (isEmpty()) {
            return -1;
        }
        Node n = first;
        return n.getData();
    }
    
    /*
     *  dequeueAll()
     *    - queue�� ��� ��带 ����
     *    - ������ ��� data�� ���
     *    - ������ ������ ���� ���� (������ ���� ����)
     *      > 1 2 3 4 5 
     */
    public void dequeueAll() {
        while (!isEmpty()) {
            System.out.print(dequeue() + " ");
        }
        System.out.println();
    }
}
