package stack;



public class Main {

   

  /* 

   * 4) ���ʽ� operation (��ȣ üũ)

   *   - �������� �ʾƵ� A �޴µ� ���� ����

   *   - ������ �� �ּ� Ǯ�� �����ϸ� ��

   *   - ���� ������ �����ϸ� �� �ּ�ó��

   *   - checkMatching(): ���ڿ��� �Է¹޾Ƽ� �ش� ���ڿ��� ��ȣ�� ����� �����ִ� ���� Ȯ�����ִ� �Լ� ����

   *   - ���ڿ��� ��ȣ�θ� �̷�����ִٰ� ����

   *   - ex) (()()) >> True

   *   - ex2) (()(())()))() >> False

   */

  public static boolean checkMatching(String str) {

    Stack s = new Stack();

    for(int i=0;i<str.length();i++) {
    	if(str.charAt(i) == '(') {
    		s.push(str.charAt(i));
    	}
    	else {
    		if(s.top() == '(') s.pop();
    		else return false;
    	}
    }
    
    if(s.isEmpty()) return true;
    else return false;

  }



  public static void main(String[] args) {

    // TODO Auto-generated method stub

    /* Stack �ʼ� operation test */

    boolean flag = true;

    char tmp;

     

    Stack s = new Stack();

     

    if (s.top() != '-')

      flag = false;

    System.out.println(s.top());

    if (s.size() != 0)

      flag = false;

    System.out.println(s.size());

    tmp = s.pop();

    if (tmp != '-')

      flag = false;

    System.out.println(tmp);

     

    s.push('5');

    s.push('3');

     

    if (s.size() != 2)

      flag = false;

    System.out.println(s.size());

    tmp = s.pop();

    if (tmp != '3')

      flag = false;

    System.out.println(tmp);

    if (s.isEmpty() != false)

      flag = false;

    System.out.println(s.isEmpty());

    tmp = s.pop();

    if (tmp != '5')

      flag = false;

    System.out.println(tmp);

    if (s.isEmpty() != true)

      flag = false;

    System.out.println(s.isEmpty());

    tmp = s.pop();

    if (tmp != '-')

      flag = false;

    System.out.println(tmp);

     

    s.push('7');

    s.push('9');

     

    if (s.top() != '9')

      flag = false;

    System.out.println(s.top());

     

    s.push('4');

     

    if (s.size() != 3)

      flag = false;

    System.out.println(s.size());

    tmp = s.pop();

    if (tmp != '4')

      flag = false;

    System.out.println(tmp);

     

    s.push('6');

    s.push('8');

     

    tmp = s.pop();

    if (tmp != '8')

      flag = false;

    System.out.println(tmp);

     

    if (flag) {

      System.out.println("�� ������ ���̸� �ʼ� Stack operation ������ ������ �� �Դϴ�.");

    } else {

      System.out.println("�� ������ ���̸� �ʼ� Stack operation ������ ������ �� �Դϴ�.");

    }

     

    /*

     * Stack ��ü operation test

     * - ����� ���� ���� ���θ� ������ ���� �ʽ��ϴ�.

     * - ���� ����� �ּ����� �޾Ƴ������� �����Ͻñ� �ٶ��ϴ�.

     */

     

    s.popAll();   // 6 9 7

     

    s.push('1');

    s.push('2');

     

    System.out.println(s.size());  // 2

     

    s.popAll();   // 2 1

    s.popAll();   // 

     

    System.out.println(s.size());  // 0

     

    // ���� Ȯ���� �� �ּ� Ǯ�� Ȯ���ϸ� ��

    System.out.println(checkMatching("(())()"));                  // true

    System.out.println(checkMatching("((((())))())"));               // true

    System.out.println(checkMatching(")(()()())"));                 // false

    System.out.println(checkMatching("(((((()))))"));                // false

    System.out.println(checkMatching("()(())((()))()()(())((()))(())((((()))))")); // true

  }



}

