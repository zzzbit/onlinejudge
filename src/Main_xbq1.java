import java.util.Scanner;

public class Main_xbq1 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        in.close();
        int real = M;
        int tax = 0;
        //1500
        if (real > 1500*0.03){
        	tax += (int)(1500);
        	real -= 1500*0.03;
        }
        else {
        	tax += (int)(real/0.03);
			real = 0;
		}
        
        //4500
        if (real > 3000*0.1){
        	tax += (int)(3000);
        	real -= 3000*0.1;
        }
        else {
        	tax += (int)(real/0.1);
			real = 0;
		}
       	
       	//9000
        if (real > 4500*0.2){
        	tax += (int)(4500);
        	real -= 4500*0.2;
        }
        else {
        	tax += (int)(real/0.2);
			real = 0;
		}
       	
        //35000
        if (real > 26000*0.25){
        	tax += (int)(26000);
        	real -= 26000*0.25;
        }
        else {
        	tax += (int)(real/0.25);
			real = 0;
		}
        
        //55000
        if (real > 20000*0.3){
        	tax += (int)(20000);
        	real -= 20000*0.3;
        }
        else {
        	tax += (int)(real/0.3);
			real = 0;
		}
        
        //80000
        if (real > 25000*0.35){
        	tax += (int)(25000);
        	real -= 25000*0.35;
        }
        else {
        	tax += (int)(real/0.35);
			real = 0;
		}
        
        //>80000
        tax += (int)(real/0.45);
        System.out.println(tax+3500);
    }
}