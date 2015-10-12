import java.text.DecimalFormat;
import java.util.Scanner;

public class Main_WangYi4 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String order = in.nextLine();
        String name = in.nextLine();
        int total=0,num=0;
        int friend[] = new int[10];
        int chat[] = new int[10];
        int totalfriend[] = new int[10];
        int totalchat[] = new int[10];
        for (int i = 0; i < 10; i++) {
        	friend[i] = chat[i] = 0;
		}
        int pos1 = name.indexOf("fchatnum");
        int pos2 = name.indexOf("cchatnum");
        int pos3 = name.indexOf("remark");
        int fchatnum = 0,cchatnum = 0,remark = 0;
        
        while(in.hasNext()) {
        	if (pos1 < pos2 && pos1 < pos3) {
        		fchatnum = in.nextInt();
        		if (fchatnum < 0) {
					break;
				}
        		if (pos2 < pos3) {
        			cchatnum = in.nextInt();
                	remark = in.nextInt();
				}
			}
        	else if (pos2 < pos1 && pos2 < pos3) {
        		cchatnum = in.nextInt();
        		if (pos2 < pos3) {
        			fchatnum = in.nextInt();
                	remark = in.nextInt();
				}
			}
        	else {
        		remark = in.nextInt();
        		if (pos2 < pos3) {
        			fchatnum = in.nextInt();
        			cchatnum = in.nextInt();
				}
			}
        	
        	
        	if (remark == 2) {
				num++;
				friend[fchatnum-1]++;
				chat[cchatnum-1]++;
			}
        	else {
				
			}
        	totalfriend[fchatnum-1]++;
			totalchat[cchatnum-1]++;
        	total++;
        }
        double prior = num*1.0/total;
        DecimalFormat df = new DecimalFormat("0.000");
        if (order.contains("1")) {
        	System.out.println(df.format(prior));
		}
        if (order.contains("2")) {
        	System.out.print(df.format(friend[0]*1.0/num));
            for (int i = 1; i < friend.length; i++) {
            	System.out.print(","+df.format(friend[i]*1.0/num));
    		}
            System.out.println();
		}
        if (order.contains("3")) {
	        double up8 = prior*(friend[8]*1.0*chat[8])/(num*num);
	        double down8 = (1-prior)*((totalchat[8]-chat[8])*(totalfriend[8]-friend[8])*1.0)/((total-num)*(total-num));
	        System.out.println(df.format(up8*1.0/(up8+down8)));
        }
        in.close();
        
    }
}