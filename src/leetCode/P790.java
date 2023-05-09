package leetCode;

public class P790 { // Domino and Tromino Tiling
	public static void main(String[] args) {
		int n = 3;
		System.out.println(numTilings(n));
	}

	public static int numTilings(int n) {
		int dp[] = new int[n <= 3 ? 4 : n + 1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 5;

		int mod = 1000000007;
		for (int i = 4; i <= n; i++) {
			dp[i] = (dp[i - 3] + 2 * dp[i - 1] % mod) % mod;
		}

		return dp[n];
	}
}
