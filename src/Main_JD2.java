import java.util.*;

public class Main_JD2
{
		
    public static void main(String args[])
    {
    	Scanner in = new Scanner(System.in);
    	int SIZE = 6;
    	int prize[][] = new int[SIZE][SIZE];
    	int award[][] = new int[SIZE][SIZE];
    	// 处理循环输入
    	while (in.hasNext()) {
    		for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					prize[i][j] = in.nextInt();
				}
			}
    		//	动态规划方法进行求解
    		for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if (i == 0 && j == 0) {
						award[i][j] = prize[i][j];
					}
					else if (i == 0) {
						award[i][j] = award[i][j-1] + prize[i][j];
					}
					else if (j == 0) {
						award[i][j] = award[i-1][j] + prize[i][j]; 
					}
					else {
						int up = award[i][j-1] + prize[i][j];
						int left = award[i-1][j] + prize[i][j];
						award[i][j] = up > left?up:left;
					}
				}
			}
    		// 输出最后的结果
    		System.out.println(award[SIZE-1][SIZE-1]);
		}
    }
}