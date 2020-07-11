package stack;



public class Stack2019041094 {

   

  /*

   * [Class] Node

   *  1) ����

   *   - SinglyLinkedList�� data�� ��� ���

   *   - �� ���� ���� ��带 ����Ű�� �־�� ��

   *   - data type�� ���ڶ�� ����

   *  2) �ʼ� operation

   *   - ������

   *   - getData(): ���� ��尡 ������ �ִ� data�� ��ȯ�ϴ� �Լ�

   *   - getNext(): ���� ��尡 ����Ű�� �ִ� Node�� ��ȯ�ϴ� �Լ�

   *   - setNext(): ���� ����� ����Ű�� �ִ� Node�� �����ϴ� �Լ�

   */

   

  private static class Node {

    private char data;  // Node���� �����ϴ� data

    private Node next; // Node�� ����Ű�� �ִ� ���� ���

     

    /* [�ʼ�] ������ */

    public Node(char d) {

      data = d;
      next = null;

    }

     

    /* [�ʼ�] getData() */

    public char getData() {

      return this.data;

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

   * [Class] Stack

   *  1) ����

   *   - Stack�� �� ���� ����Ű�� top�� ����

   *   - data�� stack�� top�� �߰��ϰ�, top�� �ִ� node�� �����ϴ� �Լ��� ����� ��

   *  2) �ʼ� operation

   *   - push(): stack�� top�� data�� �߰��ϴ� �Լ�

   *   - pop(): stack�� top ��带 �����ϰ� data�� ��ȯ�ϴ� �Լ�

   *   - top(): stack�� �� ���� data�� ��ȯ�ϴ� �Լ�

   *   - size(): stack�� �� ���� data�� ����ִ��� ��ȯ�ϴ� �Լ�

   *   - isEmpty(): stack�� ������� Ȯ��

   *  3) �߰� operation

   *   - popAll(): stack�� ��� data�� ����

   */

   

  private Node top;  // stack�� ���� �� �κ��� ����Ű�� ���

  private int size;  // stack�� ũ�� ����

   

  /* [�ʼ�] ������ */

  public Stack() {

    top = null;
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

   * [�ʼ�] push()

   *  - �����͸� �Է¹޾Ƽ� stack�� ���� ���� �߰�

   */

  public void push(char data) {

    Node n = new Node(data);
    n.setNext(top); 
    top = n;
    size++;

  }

   

  /*

   * [�ʼ�] pop()

   *  - stack�� ���� �� ��带 �����ϰ� data�� ��ȯ

   *  - ���� ���� ��� '-' ����

   */

  public char pop() {

    if(isEmpty()) return '-';
    else {
    	Node n = top;
    	size--;
    	top = top.getNext();
    	n.setNext(null);
    	return n.data;
    }

  }

   

  /*

   * [�ʼ�] top()

   * - stack�� ���� �� ����� data�� ��ȯ

   * - ���� ���� ��� '-' ����

   */

  public char top() {

    if(isEmpty()) return '-';
    else return top.data;

  }

   

  /*

   * popAll()

   *  - stack�� ��� ��带 ����

   *  - ������ ��� data�� ���

   *  - ������ ������ ���� ���� (������ ���� ����)

   *   > 1 2 3 4 5 

   */

  public void popAll() {
	  
    while(!isEmpty()) {
    	System.out.print(pop()+" ");
    }
    System.out.println();

  }

}