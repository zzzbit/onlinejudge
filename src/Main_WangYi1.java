import java.util.Scanner;
import java.util.TreeSet;

public class Main_WangYi1 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        while(in.hasNext()) {
        	String str = in.nextLine();
        	String target = in.nextLine();
        	int index = str.indexOf(target);
        	int start = 0, layer = 1;
        	TreeSet<Integer> hashSet = new TreeSet<>();
        	if (index < 0) {
				System.out.println("-1");
				continue;
			}
        	else {
				while(index >= 0){
					for (int i = start; i < index; i++) {
						if (str.charAt(i) == '{') {
							layer++;
						}
						else if (str.charAt(i) == '}'){
							layer--;
						}
					}
					hashSet.add(layer);
					start = index+1;
					index = str.indexOf(target, start);
				}
			}
        	Object[] array = hashSet.toArray();
        	if (array != null && array.length>0) {
        		System.out.print(array[0]);
        		for (int i = 1; i < array.length; i++) {
            		System.out.print(","+array[i]);
    			}
            	System.out.println();
			}
        	else if (array != null ){
        		System.out.println(array[0]);
			}
        	else {
        		System.out.println("-1");
			}
        }
        in.close();
        
    }
}