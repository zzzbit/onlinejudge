import java.util.*;

public class Main_Qunar1
{
    public static void main(String args[])
    {
    	Scanner in = new Scanner(System.in);
    	
    	int N = in.nextInt();
    	in.nextLine();
    	int maxmajor = -1,tmpmajor;		// 主版本
    	int maxminor = -1,tmpminor;		// 次版本
    	int maxpatchlevel = -1,tmppatchlevel;	// 修订
    	String resultversion = "no stable available";	// 保存结果
    	for (int i = 0; i < N; i++) {
			String version = in.nextLine();
			if (version == null) {
				continue;
			}
			int pos1 = version.indexOf(".");
			int pos2 = version.indexOf(".", pos1+1);
			
			if (pos1 >= 0) {
				tmpmajor = Integer.parseInt(version.substring(0, pos1));
				if (pos2 >= 0) {
					tmpminor = Integer.parseInt(version.substring(pos1+1,pos2));
					tmppatchlevel = Integer.parseInt(version.substring(pos2+1));
				}
				else {
					tmpminor = Integer.parseInt(version.substring(pos1+1));
					tmppatchlevel = -1;
				}
			}
			else {
				continue;
			}
			
			// 进行判断处理
			if (tmpmajor > maxmajor) {
				if (tmpminor % 2 == 0) {
					maxmajor = tmpmajor;
					maxminor = tmpminor;
					maxpatchlevel = tmppatchlevel;
					resultversion = version;
				}
			}
			else {	// 如果主版本相同
				if (maxminor == tmpminor){	// 如果此版本相同
					if (tmppatchlevel > maxpatchlevel) {
						maxpatchlevel = tmppatchlevel;
						resultversion = version;
					}
				}
				else if (tmpminor > tmpminor && tmpminor % 2 == 0) {	// 如果次版本要大且是偶数
					maxminor = tmpminor;
					maxpatchlevel = tmppatchlevel;
					resultversion = version;
				}
			}
		}
    	// 循环处理完后得到结果
    	System.out.println(resultversion);
    }
}