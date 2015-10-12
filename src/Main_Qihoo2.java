import java.util.*;

public class Main_Qihoo2
{
    public static void main(String args[])
    {
    	String[] stdline1 = {" - ","   "," - "," - ","   "," - "," - "," - "," - "," - "};
    	String[] stdline2 = {"| |","  |","  |","  |","| |","|  ","|  ","  |","| |","| |"};
    	String[] stdline3 = {"   ","   "," - "," - "," - "," - "," - ","   "," - "," - "};
    	String[] stdline4 = {"| |","  |","|  ","  |","  |","  |","| |","  |","| |","  |"};
    	String[] stdline5 = {" _ ","   "," - "," - ","   "," - "," - ","   "," - "," - "};
    	
        Scanner in = new Scanner(System.in);
        int j;
        int change = 0;
        while(in.hasNext()){
        	StringBuffer line1 = new StringBuffer();
        	StringBuffer line2 = new StringBuffer();
        	StringBuffer line3 = new StringBuffer();
        	StringBuffer line4 = new StringBuffer();
        	StringBuffer line5 = new StringBuffer();
        	int flag = 0;	//如果为0说明之前没有元素
        	String input = in.nextLine();
        	// 判断合法性
        	if (input == null || input.trim().equals("") ) {
				continue;
			}
        	int num = 0;
        	try {
				num = Integer.parseInt(input);
			} catch (Exception e) {
				continue;
			}        	
        	
        	for (int i = 2; i <= num; i++) {
        		
        		// 如果能够找到，说明是其中一个素因子
				if (num % i == 0) {
					// 依次取出数字
					if (flag == 1) {
						line1.append("   ");
						line2.append("   ");
						line3.append(" * ");
						line4.append("   ");
						line5.append("   ");
					}
					StringBuffer tmp1 = new StringBuffer();
					StringBuffer tmp2 = new StringBuffer();
					StringBuffer tmp3 = new StringBuffer();
					StringBuffer tmp4 = new StringBuffer();
					StringBuffer tmp5 = new StringBuffer();
					j = i;
					while (j > 0){
						tmp1.insert(0, stdline1[j%10]);
						tmp2.insert(0, stdline2[j%10]);
						tmp3.insert(0, stdline3[j%10]);
						tmp4.insert(0, stdline4[j%10]);
						tmp5.insert(0, stdline5[j%10]);
						j /= 10;
					}
					line1.append(tmp1);
					line2.append(tmp2);
					line3.append(tmp3);
					line4.append(tmp4);
					line5.append(tmp5);
					num = num / i;
					i--;
					flag = 1;
				}
			}
        	
        	if (change == 0) {
				change = 1;
			}
        	else {
        		System.out.println();
			}
        	//输出
        	System.out.println(line1);
        	System.out.println(line2);
        	System.out.println(line3);
        	System.out.println(line4);
        	System.out.println(line5);
        }
    }
}