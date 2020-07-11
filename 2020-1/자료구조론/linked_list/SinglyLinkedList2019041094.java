package linked_list;



public class SinglyLinkedList2019041094 {



/*

* [Class] Node

*  1) ����

*   - SinglyLinkedList�� data�� ��� ���

*   - �� ���� ���� ��带 ����Ű�� �־�� ��

*   - data type�� ������� ����

*  2) �ʼ� operation

*   - ������

*   - getData(): ���� ��尡 ������ �ִ� data�� ��ȯ�ϴ� �Լ�

*   - getNext(): ���� ��尡 ����Ű�� �ִ� Node�� ��ȯ�ϴ� �Լ�

*   - setNext(): ���� ����� ����Ű�� �ִ� Node�� �����ϴ� �Լ�

*/



private static class Node {

private int data; // Node���� �����ϴ� data

private Node next; // Node�� ����Ű�� �ִ� ���� ���



/* [�ʼ�] ������ */

public Node(int d) {

	data = d;
	next = null;

}



/* [�ʼ�] getData() */

public int getData() {

	return this.data;

}



/* [�ʼ�] getNext() */

public Node getNext() {

	return this.next;

}



/* [�ʼ�] setNext() */

public void setNext(Node n) {

	this.next = n;

}

}



/*

* [Class] SinglyLinkedList

*  1) ����

*   - LinkedList�� ù ��° ��带 ����Ű�� head�� ������ ��带 ����Ű�� tail�� ����

*    -> head/tail�� dummy ���� ���� ����, �����͸� ���� ���� ���� ����

*   - data�� ó��/�������� �߰�, �����ϴ� �Լ��� ����� ��

*  2) �ʼ� operation

*   - getFirst(): linked list�� ù ��° ����� data�� ��ȯ�ϴ� �Լ�

*   - getLast(): linked list�� ������ ����� data�� ��ȯ�ϴ� �Լ�

*   - addFirst(): linked list�� �� �տ� �����͸� �߰�

*   - addLast(): linked list�� �� �ڿ� �����͸� �߰�

*  3) �߰� operation

*   - removeFirst(): linked list�� �� ���� ��带 ����

*   - printList(): linked list�� ��� �����͸� ���

*/



private Node head; // data�� ù �κ��� ����Ű�� ���

private Node tail; // data�� ������ �κ��� ����Ű�� ���

private int size; // ����Ʈ�� ũ�⸦ ����ϴ� ��� (�ʿ�� ���)



/* [�ʼ�] ������ */

public SinglyLinkedList() {
	
	Node head = null;
	Node tail = null;
	size = 0;

}



/* �ʿ�� ���� */

public int size() {

	return size;

}



/* �ʿ�� ���� */

public boolean isEmpty() {

	return size == 0;

}



/* 

* [�ʼ�] getFirst()

*  - ��尡 �ƴ϶� �����͸� ��ȯ�ؾ� ��

*  - ���� ���� ��� -1 ����

*/

public int getFirst() {
	
	if(head == null) return -1;
	return head.data;

}



/* [�ʼ�] getLast() */

public int getLast() {
	
	if(tail == null) return -1;
	return tail.data;

}



/* 

* [�ʼ�] addFirst()

*  - �����͸� �Է¹޾Ƽ� �߰�

*/

public void addFirst(int data) {

	Node n = new Node(data);
	n.setNext(head);
	head = n;
	if(size == 0) tail = n;
	size++;
	

}



/* [�ʼ�] addLast() */

public void addLast(int data) {

	Node n = new Node(data);
	tail.setNext(n);
	tail = n;
	if(size == 0) head = n;
	size++;

}



/*

* removeFirst()

*  - ù ��° ��带 �����ϰ� data�� ��ȯ

*  - ���� ���� ��� -1 ����

*/

public int removeFirst() {
	
	if(isEmpty()) {
		tail = null;
		return -1;
	}
	Node n1 = head;
	head = head.getNext();
	n1.setNext(null);
	size--;
	return n1.data;
	
}



/*

* printList() : ����Լ��� �ݺ������� ����

*  - ������ ������ ���� ���� (������ ���� ����)

*  > 1 2 3 4 5 

*/

public void printList() {
	Node n = head;
	for(int i=0;i<size;i++) {
		System.out.print(n.data + " ");
		n = n.getNext();
	}
	System.out.println();

}

}

