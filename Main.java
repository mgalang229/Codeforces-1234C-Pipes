import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

/*

- flow of water (to the right)
- if pipes 1 and 2 are adjacent, then we can only go in 1 direction
- (2, n) should contain either 2 or 6
- if s[2][n] is [3, 6], then s[1][n] should be also be [3, 6] (s[2][n-1] doesn't matter)
- if s[2][n] is [1, 2], then s[1][n] doesn't matter

-------------------------

1
7
1423224 
2262535

ans: NO

-------------------------

1
7
2441143
2254361

ans: NO

-------------------------

1
7
5534241
3234331

-------------------------

 */

public class Main {
	
	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt();
			char[][] s = new char[2][n];
			for (int i = 0; i < 2; i++) {
				s[i] = fs.next().toCharArray();
			}
			int row = 1;
			boolean possible = false;
			for (int i = n - 1; i >= 0; i--) {
//				System.out.print(row + " " + i);
				if (!isStraightPipe(s[row][i])) {
//					System.out.print(" here");
					row = (row == 0 ? 1 : 0); //change row
					if (isStraightPipe(s[row][i])) {
						break;
					}
				}
//				System.out.println();
				if (row == 0 && i == 0) {
					possible = true;
				}
			}
			System.out.println(possible ? "YES" : "NO");
		}
		out.close();
	}
	
	static boolean isStraightPipe(char digit) {
		return digit == '1' || digit == '2';
	}
	
	static final Random rnd = new Random();
	static void shuffleSort(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newInd = rnd.nextInt(n);
			int temp = a[newInd]; //change this
			a[newInd] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		double[] readDoubleArray(int n) {
			double[] a = new double[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextDouble();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
