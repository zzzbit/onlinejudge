import java.util.*;

class InputNode{
	int no;
	List<Integer> owner = new ArrayList<>();
	List<Integer> wait = new ArrayList<>();
}
public class Main
{
	static int count = 0;
	static ArrayList<Integer> visited = new ArrayList<>();
	static int map[][];
	public static void find(int v){
		if (visited.indexOf(v) != -1) {
			count++;
			return;
		}
		visited.add(v);
		for (int i = 0; i < map.length; i++) {
			if (map[v][i] == 1)	find(i);
		}
	}
	
    public static void main(String args[])
    {
    	List<InputNode> list = new ArrayList<>();
    	
    	Scanner in = new Scanner(System.in);
    	// 处理输入
    	int num = in.nextInt();
    	map = new int[num][num];	// 初始化，没有边的连接
    	for (int i = 0; i < num; i++) {	
			for (int j = 0; j < num; j++) {
				map[i][j] = 0;
			}
		}
    	in.nextLine();
    	for (int i = 0; i < num; i++) {
			String tmp = in.nextLine();
			String[] result = tmp.split("	");
			int key;
			if (result.length > 0) {
				key = Integer.parseInt(result[0]);
			}
			else {
				continue;
			}
			InputNode inputNode = new InputNode();
			inputNode.no = key;
			
			if (result.length >= 2) {
				String[] node = result[1].split(",");
				for (String string : node) {
					if (!"".equals(string)) {
						inputNode.owner.add(Integer.parseInt(string));
					}
				}
			}
			if (result.length >= 3) {
				String[] node = result[2].split(",");
				for (String string : node) {
					if (!"".equals(string)) {
						inputNode.wait.add(Integer.parseInt(string));
					}
				}
			}
			list.add(inputNode);
		}
    	// 构成图
    	for (int i = 0; i < list.size(); i++) {
    		InputNode inputNode = list.get(i);
    		List<Integer> owner = inputNode.owner;
    		for (Integer integer : owner) {
    			for (int j = 0;j < list.size(); j++) {
    				if (i == j) {
						continue;
					}
    				InputNode targetinputNode = list.get(j);
    	    		List<Integer> targetwait = targetinputNode.wait;
    	    		for (Integer target : targetwait) {
    	    			if (target == integer) {
							map[i][j] = 1;
						}
    	    		}
    			}
			}
		}
    	// 查找
    	find(0);
    	System.out.println(count);
    }
}