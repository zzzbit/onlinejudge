import java.text.DecimalFormat;
import java.util.Scanner;
/**
 * KNN结点类，用来存储最近邻的k个元组相关的信息
 * @author Rowen
 * @qq 443773264
 * @mail luowen3405@163.com
 * @blog blog.csdn.net/luowen3405
 * @data 2011.03.25
 */
class KNNNode {
	private int index; // 元组标号
	private double distance; // 与测试元组的距离
	private String c; // 所属类别
	public KNNNode(int index, double distance, String c) {
		super();
		this.index = index;
		this.distance = distance;
		this.c = c;
	}
	
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
}



public class Main_WangYi3 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        float M[][] = new float[10001][101];
        int N[] = new int[10001];
        int k = in.nextInt();
        int l = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < l; j++) {
				M[i][j] = in.nextFloat();
				
			}
		}
        
        
    }
}