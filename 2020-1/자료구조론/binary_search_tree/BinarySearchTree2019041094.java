package binary_search_tree;



public class BinarySearchTree2019041094 {

    private static class Node {

        private int data;       // Node���� �����ϴ� data

        private Node parent;    // ���� Node�� �θ� ����Ŵ

        private Node left;      // ���� Node�� ���� �ڽ��� ����Ŵ

        private Node right;     // ���� Node�� ������ �ڽ��� ����Ŵ

        

        /*  ������ */

        public Node(int d) {

            parent = null;

            left = null;

            right = null;

            data = d;

        }

        

        /* getData() */

        public int getData() {

            return data;

        }

        

        /* getParent() */

        public Node getParent() {

            return parent;

        }

        

        /* getLeft() */

        public Node getLeft() {

            return left;

        }

        

        /* getRight() */

        public Node getRight() {

            return right;

        }

        

        /* setParent() */

        public void setParent(Node n) {

            parent = n;

        }

        

        /* setLeft() */

        public void setLeft(Node n) {

            left = n;

        }

        

        /* setRight() */

        public void setRight(Node n) {

            right = n;

        }

    }

    

    /*

     * [Class] BinarySearchTree

     *   1) ����

     *     - Tree�� �� ���� ����Ű�� root�� ����

     *     - �����͸� �߰��� ���� �������� ����, ū���� ���������� �߰��ǰ� �ؾ� ��

     *   2) �ʼ� operation

     *     - add(): BST�� data�� �߰��ϴ� �Լ�

     *   3) �߰� operation

     *     - remove(): BST�� Ư�� data�� �����ϴ� �Լ�

     *     - inorder(): inorder ������� tree�� ��ȸ�ϴ� �Լ�

     *     - preorder(): preorder ������� tree�� ��ȸ�ϴ� �Լ�

     */

    

    private Node root;      // BST�� root

    private int size;       // BST�� size

    

    /* ������ */

    public BinarySearchTree2019041094() {

        root = null;

        size = 0;

    }

    

    /*

     * size()

     *  - BST�� size�� ����

     */

    public int size() {

        return size;

    }

    

    /*

     * getRoot()

     *  - BST�� root�� ����

     */

    public Node getRoot() {

        return root;

    }

    

    /*

     * [�ʼ�] add()

     *  - BST�� �� �߰�

     *  - ������ �� ���� ��� �� �ϳ�

     *    1) root�� ������ root�� ����

     *    2-1) ���� ���� �ִ� ����� ������ ������ �������� �̵�

     *    2-2) ���� ���� �ִ� ����� ������ ũ�� ���������� �̵�

     *    3) ���� �ش� ��ġ�� ��������� �ű⿡ �߰�

     */

    public void add(int data) {
    	
    	Node newNode = new Node(data);
        Node n = root;
        if(size == 0) {
        	root = newNode;
        }
        
        else {
        	while(true) {
        		if(n.getData() > newNode.getData()) {
        			if(n.getLeft() == null) {
        				n.setLeft(newNode);
        				newNode.setParent(n);
        				break;
        			}
        			n = n.getLeft();
        		}
        		else {
        			if(n.getRight() == null) {
        				n.setRight(newNode);
        				newNode.setParent(n);
        				break;
        			}
        			n = n.getRight();
        		}
        	}
        	
        }
        size++;
    }

    

    /*

     *  rightMost()

     *    - remove ������ �� �ʿ��� operation

     *    - ���� sub-tree �߿� ���� ū ���� ���� node�� ��ȯ���ָ� ��

     *    - ��������� ȣ���ϴ� ���� ��õ

     *    - remove���� ����� �� �Ʒ��� ���� ������� �θ��� �ǰ���?

     *       > swap�� ��� = rightMost(n.getLeft());

     */

    public Node rightMost(Node n) {

    	while(n.getRight() != null) {
    		n = n.getRight();
    	}
    	return n;

    }

    

    /*

     *  leftMost()

     *    - ������ sub-tree �߿� ���� ���� ���� ���� node�� ��ȯ���ָ� ��

     *      > swap�� ��� = leftMost(n.getRight());

     */

    public Node leftMost(Node n) {

    	while(n.getLeft() != null) {
    		n = n.getLeft();
    	}
    	return n;

    }

    

    /*

     *  remove()

     *    - BST�� Ư�� data�� �����ϴ� �Լ�

     *      1) leaf node�� ��� �׳� ����

     *      2) internal node�� ��� �����ϰ� �Ʒ��� node�� �ø�

     *         - ���� sub-tree(���� ����) �߿� ���� ū �� or ������ sub-tree(ū ����) �߿� ���� ���� �� �� �ϳ��� �ø�

     *         - ���� sub-tree �߿� ���� ū ���� �켱������ �ø�

     *    - data�� ������ -1�� return

     */

    public int remove(int data) {
    	
    	size--;

        Node n = getRoot();
        while(data != n.getData()) {
        	if(data > n.getData()) {
        		if(n.getRight() == null) return -1;
        		n = n.getRight();
        	}
        	else if(data < n.getData()){
        		if(n.getLeft() == null) return -1;
        		n = n.getLeft();
        	}
        }
        if(n.getRight() == null && n.getLeft() == null) {
        	if(n.getParent().getLeft() == n) n.getParent().setLeft(null);
        	else n.getParent().setRight(null);
       		n.setParent(null);
        }
       	else {
       		if(n.getLeft() != null) {
        		Node swap = rightMost(n.getLeft());
        		if(swap.getLeft() != null) {
        			swap.getLeft().setParent(swap.getParent());
        		}
        		swap.getParent().setRight(swap.getLeft());
        		if(n != getRoot()) {
        			if(n.getParent().getLeft() == n) n.getParent().setLeft(swap);
        			else n.getParent().setRight(swap);
        		}
        		else {
        			root = swap;
        			swap.setParent(null);
        		}
       			if(n.getRight() != null) n.getRight().setParent(swap);
       			if(n.getLeft() != null) n.getLeft().setParent(swap);
       			swap.setLeft(n.getLeft());
       			swap.setRight(n.getRight());
       			n.setParent(null);
       			n.setLeft(null); 
       			n.setRight(null);
        			
        	}
        	else {
      			Node swap = leftMost(n.getRight());
      			if(swap.getRight() != null) swap.getRight().setParent(swap.getParent());
       			swap.getParent().setLeft(swap.getRight());
       			if(n != getRoot()) {
       				if(n.getParent().getLeft() == n) n.getParent().setLeft(swap);
       				else n.getParent().setRight(swap);
       			}
       			else {
       				root = swap;
       				swap.setParent(null);
       			}
       			if(n.getLeft() != null) n.getLeft().setParent(swap);
        		if(n.getRight() != null) n.getRight().setParent(swap);
        		swap.setLeft(n.getLeft());
       			swap.setRight(n.getRight());
        		n.setParent(null);
        		n.setLeft(null); 
        		n.setRight(null);
       		}
       		
       	}
       	return n.getData();
    }

    

    /*

     *  preorder()

     *    - BST�� ��� �����͸� preorder ������� ���

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

     *    - BST�� ��� �����͸� inorder ������� ���

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

     *  postorder()

     *    - BST�� ��� �����͸� postorder ������� ���

     *    - ������ preorder ����

     *      ����) 1 2 3 4 5 

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