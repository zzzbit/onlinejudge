import java.util.Scanner;

public class Main_xbq3 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int M = in.nextInt();
        int scores[] = new int[N];
        int recommended[] = new int[M];
        int choose[] = new int[M-K];
        int map[][] = new int[N][N];
        for(int i = 0; i<N;i++){
        	for (int j = 0; j < N;j++){
        		map[i][j] = 1;
        	}
        }
        for (int i = 0; i<N; i++){
        	scores[i] = in.nextInt();
        }
        for (int i = 0; i<N; i++){
        	recommended[i] = in.nextInt();
        }
        for (int i = 0; i<N; i++){
        	int a = in.nextInt();
        	int b = in.nextInt();
        	map[a-1][b-1] = 1;
        	map[b-1][a-1] = 1;
        }
        int max = 0;
        System.out.println(isValide(choose, map));
    }
	public static int isValide(int choose[],int map[][]) {
		return 10;
	}
}