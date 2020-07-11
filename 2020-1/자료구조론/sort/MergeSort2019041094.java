package sort;

import java.util.ArrayList;

public class MergeSort2019041094 {
    ArrayList<Integer> data;    // ���� ��� List
    
    /*
     * [Class] MergeSort
     *   1) ����
     *     - list�� �׻� ������ �ɰ��� �� �̻� �ɰ����� ���� �� ���� ����
     *     - ���� �۰� �����ٸ� merge�ϸ鼭 ������ ����
     *     - ������ �����ߴ� queue�� ����Ͽ� ����
     *   2) �ʼ� operation
     *     - merge(): ���ĵ� ���Ҹ� ���� queue 2���� ��ġ�� �Լ�
     *     - mergeSort(): �����͸� ������ �ɰ��� merge�� �θ��� �Լ�
     */
    
    public MergeSort2019041094(ArrayList<Integer> data) { // data: �Է����� ���� list
        Queue q = new Queue();                  // Queue q: ���� ����� ���� queue
        for (int i = 0; i < data.size(); i++) {
            q.enqueue(data.get(i));             // �Է� �� �ű�� list->queue
        }
        mergeSort(q);                           // ���� q�� �ִ� data�� �����ض�
        
        // ���� ��� �ű��
        data.clear();
        while (!q.isEmpty()) {
            data.add(q.dequeue());              // ���� ��� queue->list
        }
        this.data = data;                       // data�� ���ؼ� ���� ����� ���� ���� (Main���� Ȯ��)
    }
    
    /*
     * [�ʼ�] merge(Queue q1, Queue q2, Queue result)
     *  - q1�� q2�� ���� ������������ ���ĵ� ���·� result�� �־��ִ� �Լ�
     *    1) q1�� q2�� �տ������� �� ���� ���� result�� �־���
     *    2) �� �� �ϳ��� �� �����ٸ� ���������� �� �־��ָ� ��
     */
    private void merge(Queue q1, Queue q2, Queue result) {
        // ����
    	while(!q1.isEmpty() && !q2.isEmpty()) {
    		if(q1.first() > q2.first()) {
    			result.enqueue(q2.dequeue());
    		}
    		else {
    			result.enqueue(q1.dequeue());
    		}
    	}
    	while(q1.isEmpty() && !q2.isEmpty()) {
    		result.enqueue(q2.dequeue());
    	}
    	while(!q1.isEmpty() && q2.isEmpty()) {
    		result.enqueue(q1.dequeue());
    	}
    }
    
    /*
     * [�ʼ�-��ĭä���/? �κ��� ä��ÿ�] mergeSort(Queue q)
     *  - ���� q�� ������ �ִ� ���Ҹ� �������ִ� �Լ�
     *    1) q�� �� �κ����� ���� (������ q1, q2��� ����)
     *    2) q�� �����Ϳ� ���ؼ�, q1�� �ݸ�ŭ�� ä��� �������� q2�� ä��
     *    3) q1�� q2�� ���ؼ� ���� mergeSort�� �����Ŵ
     *       -> q1, q2�� ���� mergeSort�� ���ؼ� ������ �Ǿ� ���ƿ� ����
     *    4) ���ĵ� q1�� q2�� merge �Լ��� ���ؼ� ��ġ��, ���������� q�� �ٽ� ���Ľ�Ŵ
     */
    private void mergeSort(Queue q) {
        int size = q.size();
        if (size < 2) {                 // size�� 1�̸� ������ �ʿ䰡 ����
            return;
        }
        Queue q1 = new Queue();         // 1) q�� �ݸ�ŭ�� �ű� q1
        Queue q2 = new Queue();         // 1) q�� ������ ���� �ű� q2
        while (q1.size() < size/2) {
            q1.enqueue(q.dequeue());    // 2) �ݸ�ŭ q1�� ä��
        }
        while (!q.isEmpty()) {
            q2.enqueue(q.dequeue());    // 2) ������ ���� q2�� ä��
        }
        mergeSort(q1);                   // 3) ä��ÿ�
        mergeSort(q2);                   // 3) ä��ÿ�
        merge(q1, q2, q);                 // 4) ä��ÿ� (merge �Լ��� �����ؼ� ������ ���� �� �� ���缭 ������ ��, hint: ����� q�� �����ؾ� ��)
    }
}
