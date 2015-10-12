import java.lang.reflect.Array;
import java.util.*;

public class Main_Qunar2
{
    public static void main(String args[])
    {
    	Scanner in = new Scanner(System.in);
    	// 处理输入
    	int num1 = in.nextInt();
    	int[] array1 = new int[num1];
    	for (int i = 0; i < num1; i++) {
			array1[i] = in.nextInt();
		}
    	int num2 = in.nextInt();
    	int[] array2 = new int[num2];
    	for (int i = 0; i < num2; i++) {
			array2[i] = in.nextInt();
		}
    	int num3 = in.nextInt();
    	int[] array3 = new int[num3];
    	for (int i = 0; i < num3; i++) {
			array3[i] = in.nextInt();
		}
    	// 进行排序
    	Arrays.sort(array1);
    	Arrays.sort(array2);
    	Arrays.sort(array3);
    	// 三个下标，依次进行比较
    	int idx1 = 0, idx2 = 0, idx3 = 0;
    	boolean first = true;	// 是否是第一个输出
    	for (; idx1 < num1; idx1++) {
    		boolean flag = false;	// flag为false表示没有找到一样的，1表示有
    		int tmp = array1[idx1];
			for (; idx2 < num2; idx2++) {
				if (tmp == array2[idx2]) {
					flag = true;
					break;
				}
				else if (tmp < array2[idx2]) {
					flag = false;
					break;
				}
			}
			// 如果array2没找到，直接跳过
			if (flag == false) {
				continue;
			}
			flag = false;
			for (; idx3 < num3; idx3++) {
				if (tmp == array3[idx3]) {
					flag = true;
					break;
				}
				else if (tmp < array3[idx3]) {
					flag = false;
					break;
				}
			}
			// 如果array3找到，输出
			if (flag) {
				if (first) {
					System.out.print(tmp);
					first = false;
				}
				else {
					System.out.print(" "+tmp);
				}
			}
		}
    	
    	System.out.println();
    }
}