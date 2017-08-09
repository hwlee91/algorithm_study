import java.io.FileInputStream;
import java.util.Scanner;

class Main {
	static int T,W;
	static int A[];
	static int cache[][][];
	static int NEGINF = -987654321;
	
	public static int check(int location, int i) {
		if(location == A[i])
			return 1;
		else
			return 0;
	}
	public static int go(int i, int j, int k) {
		if(i < 0)
			return 0;
		if(j < 0)
			return NEGINF;
		if(i == 1) {
			if(j != 0 || k != 1)
				return NEGINF;
		}
		if(cache[i][j][k] != -1)
			return cache[i][j][k];
		
		int temp;
		
		switch(k)
		{
		case 0:
			cache[i][j][k] = go(i-1, j, k) + check(k,i);
			temp = go(i-1, j-1, k+1) + check(k,i);
			if(temp > cache[i][j][k])
				cache[i][j][k] = temp;
			break;
		case 1:
			cache[i][j][k] = go(i-1, j, k) + check(k,i);
			temp = go(i-1, j-1, k-1) + check(k,i);
			if(temp > cache[i][j][k])
				cache[i][j][k] = temp;
			break;
		}
		
		return cache[i][j][k];
		
	}	
	
	public static void main(String args[]) throws Exception	{
		
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("src/input.txt"));
		T = sc.nextInt();
		W = sc.nextInt();
		A = new int[T];
		cache = new int[T][W+1][2];
		int i,j,k;
		for(i = 0; i < T; i++) {
			A[i] = sc.nextInt();
		}
		for(i = 0; i < T; i++) {
			for(j = 0; j < W+1; j++) {
				for(k = 0; k < 2; k++) {
					cache[i][j][k] = -1;
				}
			}
		}
		
		int ans = 1;
		for(i = 0; i <= W; i++) {
			ans = go(T-1, W-i, 0);
			ans = Math.max(ans, go(T-1, W-i, 1));
		}
		
		System.out.println(ans);
		
		
	}
}