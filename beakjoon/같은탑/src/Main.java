import java.io.FileInputStream;
import java.util.Scanner;

class Main {
	static final int NEGINF = -987654321;
	static int N;
	static int d[][];
	static int a[];
	public static int go(int n, int diff) {
		if(diff > 250000)
			return NEGINF;
		if(n > N) {
			if(diff == 0)
				return 0;
			else
				return NEGINF;
		}
		
		if(d[n][diff] != -1) {
			return d[n][diff];
		}
		int temp;
		d[n][diff] = go(n+1, diff); //블록을 안 놓는 경우
		temp = go(n+1, diff+a[n]); // 블록을 높은 탑에 놓는 경우
		d[n][diff] = Math.max(d[n][diff], temp);
		
		//블록을 낮은 탑에 놓는 경우
		if(a[n] < diff) { //블록이 두 탑의 높이 차이보다 작은 경우
			temp = go(n+1, diff-a[n]) + a[n];
			d[n][diff] = Math.max(d[n][diff], temp);
		}
		if(a[n] >= diff) { //블록이 두 탑의 높이 차이보다 크거나 같은 경우
			temp = go(n+1, a[n]-diff) + diff;
			d[n][diff] = Math.max(d[n][diff], temp);
		}
		
		return d[n][diff];
	}
	
	public static void main(String args[]) throws Exception	{
		
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("src/input.txt"));
		N = sc.nextInt();
		a = new int[N+1];
		d = new int[N+1][250001];
		for(int i=1; i<=N; i++) {
			a[i] = sc.nextInt();
		}
		for(int i=0; i<=N; i++) {
			for(int j=0; j<=250000; j++) {
				d[i][j] = -1;
			}
		}
		
		int ans = go(1,0);
		if(ans == 0)
			System.out.println("-1");
		else
			System.out.println(ans);
		
		
	}
}