import java.util.*;

public class Main_ChuangXin1
{
	static String find(String data[]){
		int max = 0;	// 记录最大次数
		String result = null;	// 保存结果
		Map<String, Integer> map = new HashMap<>();	//记录每个字符串的次数
		// 如果数据为空，返回null
		if (data == null || data.length == 0) {
			return null;
		}
		// 遍历每一个字符串
		for (String element : data) {
			Integer num = map.get(element);
			if (num != null) {
				map.put(element, num+1);
				// 记录最大值
				if (num > max) {
					max = num;
					result = element;
				}
			}
			else {
				map.put(element, 1);
			}
		}
		return result;		
	}
	
	// 查到元素所在的位置
	static int getIndex(String element,String list[],int length){
		if (element == null || list == null) {
			return -1;
		}
		for (int i = 0; i < length; i++) {
			if (element.equals(list[i])) {
				return i;
			}
		}
		return -1;
	}
	static String find2(String data[]){
		// 如果数据为空，返回null
		if (data == null || data.length == 0) {
			return null;
		}
		String list[] = new String[data.length];		// 记录每一个加入的元素
		int count[] = new int[data.length];				// 记录每一个元素的统计数量
		int length = 0;		// 加入元素的数量
		int num = 0;		// 临时统计元素数量
		int max = 0;		// 最大值
		int maxindex = 0;	// 最大值下标
		// 遍历每一个字符串
		for (int i = 0; i < data.length; i++) {
			//	查找到该元素的数量
			int result = getIndex(data[i],list,length);
			if (result == -1) {	//没有找到，则加入到列表
				list[length] = data[i];
				count[length] = 1;
				length++;
				num = 1;
			}
			else {
				count[result] += 1;
				num = count[result];
			}

			// 记录最大值
			if (num > max) {
				max = num;
				maxindex = i;
			}
		}
		if (maxindex == -1) {
			return null;			
		}
		else {
			return data[maxindex];
		}	
	}
	
    public static void main(String args[])
    {
    	String[] data = {"paper","cup","book","cup","pen","book"};
    	System.out.println(find2(data));
    }
}