import java.util.*;


public class Main_JD1
{
		
    public static void main(String args[])
    {
    	Scanner in = new Scanner(System.in);
        
    	// 处理多个测试用例输入
        while (in.hasNext()) {
        	long i = 0;
        	int num = in.nextInt();
        	// 循环遍历，直到找到合适的值
	        for (; ; i++) {
				long tmp = 5 * i + 1;
				int j = 0;
				// 遍历num-1次，判断这个数值是否满足条件
				for (; j < num-1; j++) {
					if (5 * tmp % 4 == 0) {
						tmp = 5 * tmp / 4 + 1;
					}
					else {
						break;
					}
				}
				// 如果满足条件，则进行输出
				if (j == num-1) {
					System.out.println(tmp);
					break;
				}
			}
        }
    }
}