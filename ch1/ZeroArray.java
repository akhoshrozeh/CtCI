public class ZeroArray {

	public static void m_zeroMatrix(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[] rows = new boolean[m];
		boolean[] cols = new boolean[n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = true;
					cols[j] = true;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			if(rows[i])
			for (int j = 0; j < n; j++) {
				matrix[i][j] = 0;
			}
		}

		for (int i = 0; i < n; i++) {
			if(cols[i])
			for (int j = 0; j < m; j++) {
				matrix[j][i] = 0;
			}
		}

		return; 
	}

	// Space: O(m+n)
	// time: O(mn)
	public static void sol_zeroMatrix(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[] rows = new boolean[m];
		boolean[] cols = new boolean[n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = true;
					cols[j] = true;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (rows[i] || cols[j])
					matrix[i][j] = 0;				
			}
		}
		return; 
	}

	public static void print_matrix(int[][] matrix) {
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				System.out.print(matrix[i][j]);
				String space = matrix[i][j] > 9 ? ("  ") : ("   ");
				System.out.print(space);
			}
			System.out.print('\n');
		}
		System.out.print("\n");
	}

	public static void init_matrix(int[][] matrix) {
		for (int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				matrix[i][j] = (int)(Math.random() * 10);
			}
		}
	}
	public static void main(String[] args) {
		int [][] m1 = new int[4][6];
		init_matrix(m1);
		print_matrix(m1);
		System.out.println("m_ZEROED: ");
		m_zeroMatrix(m1);
		print_matrix(m1);


		init_matrix(m1);
		print_matrix(m1);
		System.out.println("sol_ZEROED: ");
		sol_zeroMatrix(m1);
		print_matrix(m1);
		return; 	
	}
}