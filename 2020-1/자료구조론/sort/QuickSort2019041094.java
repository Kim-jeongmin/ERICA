package sort;

import java.util.ArrayList;

public class QuickSort2019041094 {
    ArrayList<Integer> data;        // ���� ��� list
    
    /*
     * [Class] QuickSort
     *   1) ����
     *     - list�� ���� ���� ���Ҹ� pivot���� ���ؼ� pivot���� ���� �κ��� ��������, ū �κ��� ���������� �ɰ�
     *     - �� �ɰ� �κ��� �ٽ� quicksort�� ����
     *   2) �ʼ� operation
     *     - partition(): pivot�� �������� �ɰ��ִ� �Լ�
     *     - quickSort(): partition���� �ɰ��� �����ϴ� �Լ�
     */
    public QuickSort2019041094(ArrayList<Integer> data) {
        quickSort(data, 0, data.size()-1);      // list data�� index 0~size-1 ���� ���� �ִ� ������ �����ض�
        this.data = data;                       // ���� ���
    }
    
    /*
     * [�ʼ�] partition(ArrayList<Integer> data, int start, int end)
     *  - list data�� [start, end] ������ �ִ� �����͵��� pivot�� �������� �ɰ��� ���� / ���������� �����ϴ� �Լ�
     *  - ���������� pivot�� ��ġ�� return
     *    1) ���� ���� index�� pivot���� ����
     *    2) pivot���� ���� �ֵ��� ��������, ū �ֵ��� ���������� ������
     *    3) ���������� pivot�� �и��� �ֵ� ���̷� �ű� (�ش� pivot�� ���ĵ�)
     */
    private int partition(ArrayList<Integer> data, int start, int end) {
        // ����
    	int pivot = data.get(start);
    	int left = start+1;
    	int right = end;
    	while(left <= right) {
    		if(data.get(left) < pivot) {
    			left++;
    			continue;
    		}
    		if(data.get(right) > pivot) {
    			right--;
    			continue;
    		} 
   			int temp = data.get(right);
   			data.set(right, data.get(left));
   			data.set(left, temp);	
    	}
    	data.set(start, data.get(right));
    	data.set(right, pivot);
    	return right;
    	
    }
    
    /*
     * [�ʼ�-��ĭä���/? �κ��� ä��ÿ�] quickSort(ArrayList<Integer> data, int start, int end)
     *  - ���� list�� data�� [start, end] ������ �������ִ� �Լ�
     *    1) data�� partition �Լ��� ���ؼ� �� �κ����� ����
     *    2) pivot ���� ���� / pivot(���ĵ�) / pivot ������ ����
     *    3) ���� ������ ������ ������ ���ؼ� quickSort�� �ٽ� �����Ŵ
     */
    private void quickSort(ArrayList<Integer> data, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int idx = partition(data, start, end);         // 1) ä��ÿ�, idx = pivot�� ��ġ�� ��
        quickSort(data, start, idx);                   // 2) ä��ÿ�, pivot ���� ����
        quickSort(data, idx + 1, end);                   // 3) ä��ÿ�, pivot ������ ����
    }
}
