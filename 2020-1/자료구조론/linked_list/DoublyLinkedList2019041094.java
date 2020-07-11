package linked_list;



public class DoublyLinkedList2019041094 {



/*

* [Class] Node

*  1) ����

*   - DoublyLinkedList�� data�� ��� ���

*   - �� ���� ���� �� ���� ��带 ����Ű�� �־�� ��

*   - data type�� ������� ����

*  2) �ʼ� operation

*   - ������

*   - getData(): ���� ��尡 ������ �ִ� data�� ��ȯ�ϴ� �Լ�

*   - getNext(): ���� ��尡 ����Ű�� �ִ� ���� Node�� ��ȯ�ϴ� �Լ�

*   - getPrev(): ���� ��尡 ����Ű�� �ִ� ���� Node�� ��ȯ�ϴ� �Լ�

*   - setNext(): ���� ����� ������ ����Ű�� �ϴ� Node�� �����ϴ� �Լ�

*   - setPrev(): ���� ����� ������ ����Ű�� �ϴ� Node�� �����ϴ� �Լ�

*/



private static class Node {

private int data; // Node���� �����ϴ� data

private Node next; // Node�� ����Ű�� �ִ� ���� ���

private Node prev; // Node�� ����Ű�� �ִ� ���� ���



/* [�ʼ�] ������ */

public Node(int d) {

	data = d;
	next = null;
	prev = null;

}



/* [�ʼ�] getData() */

public int getData() {

	return this.data;

}



/* [�ʼ�] getNext() */

public Node getNext() {

	return this.next;

}



/* [�ʼ�] getPrev() */

public Node getPrev() {

	return this.prev;

}



/* [�ʼ�] setNext() */

public void setNext(Node n) {

	this.next = n;

}



/* [�ʼ�] setPrev() */

public void setPrev(Node n) {

	this.prev = n;

}

}



/*

* [Class] DoublyLinkedList

*  1) ����

*   - DoublyLinked�� ù ��° ��带 ����Ű�� head�� ������ ��带 ����Ű�� tail�� ����

*    -> head/tail�� dummy ���� ���� ����, �����͸� ���� ���� ���� ����

*   - data�� ó��/�������� �߰�, �����ϴ� �Լ��� ����� ��

*  2) �ʼ� operation

*   - getFirst(): linked list�� ù ��° ����� data�� ��ȯ�ϴ� �Լ�

*   - getLast(): linked list�� ������ ����� data�� ��ȯ�ϴ� �Լ�

*   - addFirst(): linked list�� �� �տ� �����͸� �߰�

*   - addLast(): linked list�� �� �ڿ� �����͸� �߰�

*   - addBetween(): linked list�� �� ��� ���̿� �����͸� �߰�

*  3) �߰� operation

*   - removeFirst(): linked list�� �� ���� ��带 ����

*   - removeLast(): linked list�� �� ���� ��带 ����

*   - remove(): linked list�� Ư�� ��带 ����

*   - printList(): linked list�� ��� �����͸� ���

*/



private Node head; // data�� ù �κ��� ����Ű�� ���

private Node tail; // data�� ������ �κ��� ����Ű�� ���

private int size; // ����Ʈ�� ũ�⸦ ����ϴ� ��� (�ʿ�� ���)



/* [�ʼ�] ������ */

public DoublyLinkedList() {

	head = new Node(-1);
	tail = new Node(-1);
	head.setNext(tail);
	tail.setPrev(head);
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

*  - ���� ���� ��� -1 ����w

*/

public int getFirst() {

	return head.getNext().data;

}



/* [�ʼ�] getLast() */

public int getLast() {

	return tail.getPrev().data;

}



/* 

* [�ʼ�] addFirst()

*  - �����͸� �Է¹޾Ƽ� �߰�

*  - addBetween() operation ����ؼ� ����

*/

public void addFirst(int data) {

addBetween(head,head.getNext(), data);

}



/* 

* [�ʼ�] addLast()

*  - addBetween() operation ����ؼ� ����

*/

public void addLast(int data) {

addBetween(tail.getPrev(), tail, data);

}



/* 

* [�ʼ�] addBetween()

*  - Node prev�� next ���̿� data�� �߰��ؾ� ��

*/

public void addBetween(Node prev, Node next, int data) {

	Node n = new Node(data);
	n.setNext(next);
	n.setPrev(prev);
	next.setPrev(n);
	prev.setNext(n);
	size++;

}



/*

* removeFirst()

*  - ù ��° ��带 �����ϰ� data�� ��ȯ

*  - remove() operation ����ؼ� ����

*  - ���� ���� ��� -1 ����

*/

public int removeFirst() {
	
	if(head.getNext() == null) return -1;
	return remove(head.next);

}



/* 

* removeLast()

*  - remove() operation ����ؼ� ����

*/

public int removeLast() {

	if(tail.getPrev() == null) return -1;
	return remove(tail.prev);

}



/* 

* remove()

*  - Node n�� ����

*  - n�� ������ �ִ� �����͸� ����

*/

public int remove(Node n) {
	
	if(isEmpty()) return -1;
	n.getNext().setPrev(n.getPrev());
	n.getPrev().setNext(n.getNext());
	size--;
	return n.data;

}



/*

* printList() : ����Լ��� �ݺ������� ����

*  - ������ ������ ���� ���� (������ ���� ����)

*  > 1 2 3 4 5 

*/

public void printList() {
	
	Node n = head.getNext();

	for(int i=0;i<size;i++) {
		System.out.print(n.data + " ");
		n = n.getNext();
	}
	System.out.println();

}

}

