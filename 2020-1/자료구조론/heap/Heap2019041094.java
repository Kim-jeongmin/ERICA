package heap;

import java.util.Stack;

public class Heap2019041094 {
    private static class Node {
        private int data;      // Node���� �����ϴ� data
        private Node parent;    // ���� Node�� �θ� ����Ŵ
        private Node left;      // ���� Node�� ���� �ڽ��� ����Ŵ
        private Node right;     // ���� Node�� ������ �ڽ��� ����Ŵ
        
        /* [�ʼ�] ������ */
        public Node(int d) {
            parent = null;
            left = null;
            right = null;
            data = d;
        }
        
        /* [�ʼ�] getData() */
        public int getData() {
            return data;
        }
        
        /* [�ʼ�] getParent() */
        public Node getParent() {
            return parent;
        }
        
        /* [�ʼ�] getLeft() */
        public Node getLeft() {
            return left;
        }
        
        /* [�ʼ�] getRight() */
        public Node getRight() {
            return right;
        }
        
        /* [�ʼ�] setData() */
        public void setData(int data) {
            this.data = data;
        }
        
        /* [�ʼ�] setParent() */
        public void setParent(Node n) {
            parent = n;
        }
        
        /* [�ʼ�] setLeft() */
        public void setLeft(Node n) {
            left = n;
        }
        
        /* [�ʼ�] setRight() */
        public void setRight(Node n) {
            right = n;
        }
    }
    
    /*
     * [Class] Heap
     *   1) ����
     *     - Tree�� �� ���� ����Ű�� root�� ����
     *     - �����͸� �߰��� ���� heap�� ���� ������ �κп� �ϴ� �߰���
     *     - ���� swap �ϸ鼭 ��ġ�� ����� ����
     *   2) �ʼ� operation
     *     - size(): Heap�� ũ�⸦ ��Ÿ���� �Լ�
     *     - getRoot(): Heap�� root�� ��ȯ�ϴ� �Լ�
     *     - add(): Heap�� data�� �߰��ϴ� �Լ�
     *   3) �߰� operation
     *     - remove(): Heap�� Ư�� data�� �����ϴ� �Լ�
     *     - inorder(): inorder ������� tree�� ��ȸ�ϴ� �Լ�
     *     - preorder(): preorder ������� tree�� ��ȸ�ϴ� �Լ�
     */
    
    private Node root;      // Heap�� root
    private int size;       // Heap�� size
    Stack<Integer> s = new Stack<>();    // getNodeByIndex()�� ��� 
    
    /* [�ʼ�] ������ */
    public Heap2019041094() {
        root = null;
        size = 0;
    }
    
    /*
     * [�ʼ�] size()
     *  - BST�� size�� ����
     */
    public int size() {
        return size;
    }
    
    /*
     * [�ʼ�] getRoot()
     *  - BST�� root�� ����
     */
    public Node getRoot() {
        return root;
    }
    
    /* [����] getNodeByIndex()
     *   - heap�� index�� �ش��ϴ� node�� ��ȯ
     *   - ppt�� ����
     */
    public Node getNodeByIndex(int idx) {
        Node n = getRoot();
        
        s.clear();
        while (idx > 1) {
            s.push(idx % 2);    // ���� element�� 1�̸� ������, 0�̸� �������� �̵�
            idx /= 2;
        }
        // idx �ִ� ������ �̵�
        while (!s.isEmpty()) {
            if (s.pop() == 1) {
                n = n.getRight();
            } else {
                n = n.getLeft();
            }
        }
        
        return n;
    }
    
    /*
     * [�ʼ�] add()
     *  - Heap�� �� �߰�
     *  - �ϴ� ���� ������ ��忡 �߰�
     *  - �߰��� �����Ͱ� parent���� ũ�� �������� swap�� ��������� �ݺ�
     */
    public void add(int data) {
        // ����
    	if(size > 0) {
    		Node temp = new Node(data);
    		Node n = getNodeByIndex(++size);
    		Node parent = getNodeByIndex(size/2);
    		n = temp;
    		n.setParent(parent);
    		if(size%2 == 0) parent.setLeft(n);
    		else parent.setRight(n);
    		swapUp(n);
    	}
    	else {
    		Node n = new Node(data);
    		root = n; size++;
    	}
    }
    
    /*
     * [�ʼ�] swapUp()
     *  - ���� node�� ���� parent�� ������ ũ�� ���� �� ��ü
     *  - swap�ߴٸ� ��������� �ݺ�, �ƴϸ� ����
     */
    public void swapUp(Node n) {  
    	if(n != getRoot() && n.getData() > n.getParent().getData()) {
        	int temp = n.data;
        	n.data = n.getParent().data;
        	n.getParent().data = temp;
        	swapUp(n.getParent());
        }
    }
    
    
    /*
     *  remove()
     *    - Heap�� root�� �����ϴ� �Լ�
     *      1) root�� heap�� ������ index node�� data�� ��ȯ
     *      2) ��ȯ �� ������ index�� �ش��ϴ� node ����
     *      3) �ٲ� root�� �Ʒ��� ������ �����ؾ� ��
     *    - data�� ������ -1�� return
     */
    public int remove() {
        // ����
    	if(size != 0) {
    		Node n = getNodeByIndex(size);
    		int temp = root.data;
    		root.data = n.data;
    		n.data = temp;
    		if(size > 1) {
    			if(size % 2 == 0) n.getParent().setLeft(null);
    			else n.getParent().setRight(null);
    		}
    		n.setParent(null);
    		swapDown(getRoot());
    		size--;
    		return temp;
    	}
    	else return -1;
    	
    	
    }
    
    /*
     * swapDown()
     *  - ���� node�� ���� child�� ������ ������ ��ü
     *  - �ڽ��� �������� �� �� ���� ū ���� ��ü�ؾ� ��
     *  - swap�ߴٸ� ��������� �ݺ�, �ƴϸ� ����
     */
    public void swapDown(Node n) {
        // ����
    	if(n.getLeft() != null && n.getRight() != null) {
    		if(n.getLeft().getData() > n.getRight().getData()) {
    			int temp = n.data;
    			n.data = n.getLeft().data;
    			n.getLeft().data = temp;
    			swapDown(n.getLeft());
    		}
    		else {
    			int temp = n.data;
    			n.data = n.getRight().data;
    			n.getRight().data = temp;
    			swapDown(n.getRight());
    		}
    	}
    	else if(n.getLeft() == null && n.getRight() != null) {
    		int temp = n.data;
			n.data = n.getRight().data;
			n.getRight().data = temp;
			swapDown(n.getRight());
    	}
    	else if (n.getLeft() != null && n.getRight() == null) {
    		int temp = n.data;
			n.data = n.getLeft().data;
			n.getLeft().data = temp;
			swapDown(n.getLeft());
    	}
    }
    
    /*
     *  preorder()
     *    - Heap�� ��� �����͸� preorder ������� ���
     *    - ��� ���÷� ����
     */
    public void preorder(Node n) {
        if (n != null) {
            System.out.print(n.getData());
            System.out.print(" ");
            preorder(n.getLeft());
            preorder(n.getRight());
        }
    }
    
    /*
     *  inorder()
     *    - Heap�� ��� �����͸� inorder ������� ���
     *    - ��� ���÷� ���� (���ڰ� ���ĵǾ ��µǴ°� �����Դϴ�)
     */
    public void inorder(Node n) {
        if (n != null) {
            inorder(n.getLeft());
            System.out.print(n.getData());
            System.out.print(" ");
            inorder(n.getRight());
        }
    }
    
    /*
     *  inorder()
     *    - Heap�� ��� �����͸� postorder ������� ���
     *    - ��� ���÷� ���� (���ڰ� ���� �� �Ǿ��ִ°� �����Դϴ�)
     */
    public void postorder(Node n) {
        if (n != null) {
            postorder(n.getLeft());
            postorder(n.getRight());
            System.out.print(n.getData());
            System.out.print(" ");
        }
    }
}

