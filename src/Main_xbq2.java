import java.util.Scanner;

public class Main_xbq2 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String M = in.nextLine();
        in.close();
        M = M.replace("<red>", "1").replace("</red>", "2").replace("<yellow>", "3").replace("</yellow>", "4").replace("<blue>", "5").replace("</blue>", "6");
        int red = 0;
        int yellow = 0;
        int blue = 0;
        while(true){
        	boolean flag = true;
        	for(int i = 0; i < M.length(); i++){
        		if (M.charAt(i) == '2'){
        			//找到第一个2
        			for(int j = i; j >= 0; j--){
        				if (M.charAt(j) == '1'){
        					red = i - j - 1;
        					M = delete(M,i,j);
        					flag = false;
        					break;
        				}
        			}
        		}
        		if (flag == false){
        			break;
        		}
        		if (M.charAt(i) == '4'){
        			//找到第一个2
        			for(int j = i; j >= 0; j--){
        				if (M.charAt(j) == '3'){
        					yellow = i - j - 1;
        					M = delete(M,i,j);
        					flag = false;
        					break;
        				}
        			}
        		}
        		if (flag == false){
        			break;
        		}
        		if (M.charAt(i) == '6'){
        			//找到第一个2
        			for(int j = i; j >= 0; j--){
        				if (M.charAt(j) == '5'){
        					blue = i - j - 1;
        					M = delete(M,i,j);
        					flag = false;
        					break;
        				}
        			}
        		}
        		if (flag == false){
        			break;
        		}
        	}
        	if (flag){
        		break;
        	}
        }
        System.out.println(red+" "+yellow+" "+blue);
    }
	public static String delete(String M,int i,int j) {
		if (i >= M.length() - 1){
			return M.substring(0, j);
		}
		else {
			return M.substring(0, j)+M.substring(i+1);
		}
	}
}