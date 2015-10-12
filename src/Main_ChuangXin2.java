import java.util.*;

class Node {
public Node next;
public int value;
}


public class Main_ChuangXin2
{
	static Node swap(Node list){
		Node p = null;		// p来记录奇数的最后一位，如果没有则为null
		Node q = null;		// q来记录偶数的最后一位，如果没有则为null
		Node tmp = null;	// 记录当前访问的位置
		if (list == null || list.next == null) {	// 如果为null或者只有一个元素
			return list;
		}
		else {	// 针对第一个元素进行相应赋值
			if (list.value % 2 == 0) {
				q = list;
			}
			else {
				p = list;
			}
		}

		tmp = list.next;
		while (tmp != null) {
			if (tmp.value % 2 == 0) {	// 如果是偶数
				q = tmp;
				tmp = tmp.next;
			}
			else {
				if (p == null) {	// 如果前面拍好的全是偶数，将tmp指向的排在最前面
					q.next = tmp.next;
					p = tmp;
					p.next = list;
					list = p;
					tmp = q.next;
				}
				else if (q == null){	// 如果前面全是奇数
					p = tmp;
					tmp = tmp.next;
				}
				else {	// 如果前面有奇数有偶数，放在p指针的后面并且将p前移
					q.next = tmp.next;
					tmp.next = p.next;
					p.next = tmp;
					tmp = q.next;
				}
			}
		}
		return list;
	}
	
    public static void main(String args[])
    {
    	Node list = new Node();
    	list.value = 2;
    	Node newlist = new Node();
    	newlist.value = 1;
    	newlist.next = list;
    	list = newlist;
    	newlist = new Node();
    	newlist.value = 3;
    	newlist.next = list;
    	list = newlist;
    	newlist = new Node();
    	newlist.value = 5;
    	newlist.next = list;
    	list = newlist;
    	newlist = new Node();
    	newlist.value = 4;
    	newlist.next = list;
    	list = newlist;
    	
    	list = swap(newlist);
    	while (list != null) {
			System.out.println(list.value);
			list = list.next;
		}
    }
}