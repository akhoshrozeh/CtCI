public class Rotate {

	// time: O(n^2)
	// space: O(1); we do it in place
	// go layer by layer and swap the indicies
	// temp=top, top=left, left=bottom, bottom=right, right=temp
	public static void m_rotate(int[][] matrix, int n) {
		for (int layer = 0; layer < n/2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				int top = matrix[first][i]; 					// save top
				matrix[first][i] = matrix[last-offset][first]; 	// top=left
				matrix[last-offset][first] = matrix[last][last-offset];		// left=bottom
				matrix[last][last-offset] = matrix[i][last];						// bottom=right
				matrix[i][last] = top;								// right=top
			}
		}
		return;
	}

	public static void print_matrix(int[][] matrix, int n) {
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				System.out.print(matrix[i][j]);
				String space = matrix[i][j] > 9 ? ("  ") : ("   ");
				System.out.print(space);
			}
			System.out.print('\n');
		}
		System.out.print("\n");
	}

	public static void init_matrix(int[][] matrix, int n) {
		int value = 0;
		for (int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				matrix[i][j] = value++;
			}
		}
	}

	public static void main(String[] args) {
		int[][] m2 = new int[2][2];
		int[][] m3 = new int[3][3];
		int[][] m4 = new int[4][4];
		int[][] m5 = new int[5][5];
		int[][] m6 = new int[6][6];

		init_matrix(m2, 2);
		init_matrix(m3, 3);
		init_matrix(m4, 4);
		init_matrix(m5, 5);
		init_matrix(m6, 6);

		print_matrix(m2, 2);
		m_rotate(m2, 2);
		print_matrix(m2, 2);

		print_matrix(m3, 3);
		m_rotate(m3, 3);
		print_matrix(m3, 3);

		print_matrix(m4, 4);
		m_rotate(m4, 4);
		print_matrix(m4, 4);

		print_matrix(m5, 5);
		m_rotate(m5, 5);
		print_matrix(m5, 5);

		print_matrix(m6, 6);
		m_rotate(m6, 6);
		print_matrix(m6, 6);

	



		
		


		return; 
	}
}