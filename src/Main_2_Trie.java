import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
class TrieNode{
	//编号
	int no;
	//以此为根节点的个数
	int num = 1;
	//下属
	HashMap<Character, Integer> nexts = new HashMap<>();
	public TrieNode(int no) {
		this.no = no;
	}
}
public class Main_2_Trie {
	static ArrayList<TrieNode> nodes = new ArrayList<>();
	public static void main(String[] args) {
		nodes.add(new TrieNode(0));
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++){
        	String tmp = in.nextLine();
        	int tmpTrieNode = 0;
        	for (int j = 0; j < tmp.length(); j++){
        		char ch = tmp.charAt(j);
        		int index = nodes.size();
				HashMap<Character, Integer> nexts = nodes.get(tmpTrieNode).nexts;
				// 找当前节点的下属是否存在该字符
				if (nexts.containsKey(ch)) {
					int next = nexts.get(ch);
					nodes.get(next).num++;
					tmpTrieNode = next;
				}
				// 如果不存在，新建一个节点
				else {
					TrieNode node = new TrieNode(index);
					nodes.add(node);
					nexts.put(ch, index);
					tmpTrieNode = index;
				}
        	}
        }
        int m = in.nextInt();
        in.nextLine();
        for (int i = 0; i < m; i++){
        	String tmp = in.nextLine();
        	//遍历
        	int tmpTrieNode = 0;
        	int result = 0;
        	for (int j = 0; j < tmp.length(); j++){
        		char ch = tmp.charAt(j);
        		HashMap<Character, Integer> nexts = nodes.get(tmpTrieNode).nexts;
				// 找当前节点的下属是否存在该字符
				if (nexts.containsKey(ch)) {
					int next = nexts.get(ch);
					result = nodes.get(next).num;
					tmpTrieNode = next;
				}
				else {
					result = 0;
					break;
				}
        	}
        	System.out.println(result);
        }
        in.close();
    }
}