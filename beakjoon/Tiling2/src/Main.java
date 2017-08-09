import java.io.FileInputStream;
import java.util.Scanner;

class Main {
	static final int MOD = 1000000007;
	static int n;
	static int cache[];
	public static void main(String args[]) throws Exception	{
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("src/input.txt"));
		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			n = sc.nextInt();
			cache = new int[n+1];
			for(int i = 0; i <=n; i++) {
				cache[i] = -1;
			}
			System.out.println(go(n));
		}
	}
	
	static int go(int n) {
		if(n <= 0)
			return 0;
		if(n == 1)
			return 1;
		if(n == 2)
			return 2;
		if(cache[n] != -1)
			return cache[n];
		cache[n] = (go(n-1) + go(n-2)) % MOD;
		return cache[n];
	}
}