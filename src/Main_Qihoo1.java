import java.io.*;
import java.util.*;

public class Main_Qihoo1
{
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        
        int num = cin.nextInt();
        for (int i = 0; i < num; i++) {
			int policy = cin.nextInt();
			int english = cin.nextInt();
			int math = cin.nextInt();
			int major = cin.nextInt();
			
			int total = policy + english + math + major;
			// 如果是Fail
			if (policy < 60 || english < 60 || math < 90|| major < 90 || total < 310){
				System.out.println("Fail");
			}
			// 如果是Zifei
			else if (total < 350) {
				System.out.println("Zifei");
			}
			// 如果是Gongfei
			else {
				System.out.println("Gongfei");
			}
		}
    }
}