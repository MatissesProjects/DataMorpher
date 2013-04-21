package mathResources;

import structure.DataNode;

/**
 * Thank you! <br />
 * http://introcs.cs.princeton.edu/java/95linear/Matrix.java.html
 * 
 * @author Robert Sedgewick and Kevin Wayne.
 * 
 */
final public class Matrix {
	private final int M; // number of rows
	private final int N; // number of columns
	private final DataNode[][] data; // M-by-N array

	// create M-by-N matrix of 0's
	public Matrix(int M, int N) {
		this.M = M;
		this.N = N;
		data = new DataNode[M][N];
	}

	// create matrix based on 2d array
	public Matrix(DataNode[][] data) {
		M = data.length;
		N = data[0].length;
		this.data = new DataNode[M][N];
		for (int i = 0; i < M; i++)
			for (int j = 0; j < N; j++)
				this.data[i][j] = data[i][j];
	}

	// create and return a random M-by-N matrix with values between 0 and 1
	public static Matrix random(int M, int N, int max) {
		Matrix A = new Matrix(M, N);
		for (int i = 0; i < M; i++)
			for (int j = 0; j < N; j++)
				A.data[i][j] = new DataNode(MathHelper.rand.nextDouble() * max);
		return A;
	}

	// create and return the N-by-N identity matrix
	public static Matrix identity(int N) {
		Matrix I = new Matrix(N, N);
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				I.data[i][j] = new DataNode(0);
			}
			I.data[i][i].setData(new DataNode(1));
		}
		return I;
	}

	// swap rows i and j
	private void swap(int i, int j) {
		DataNode[] temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	// create and return the transpose of the invoking matrix
	public Matrix transpose() {
		Matrix A = new Matrix(N, M);
		for (int i = 0; i < M; i++)
			for (int j = 0; j < N; j++)
				A.data[j][i] = this.data[i][j];
		return A;
	}

	// return C = A + B
	public Matrix plus(Matrix B) {
		Matrix A = this;
		if (B.M != A.M || B.N != A.N)
			throw new RuntimeException("Illegal matrix dimensions.");
		Matrix C = new Matrix(M, N);
		for (int i = 0; i < M; i++)
			for (int j = 0; j < N; j++)
				C.data[i][j] = new DataNode((char) (A.data[i][j].value() + B.data[i][j].value()));
		return C;
	}

	// return C = A - B
	public Matrix minus(Matrix B) {
		Matrix A = this;
		if (B.M != A.M || B.N != A.N)
			throw new RuntimeException("Illegal matrix dimensions.");
		Matrix C = new Matrix(M, N);
		for (int i = 0; i < M; i++)
			for (int j = 0; j < N; j++)
				C.data[i][j] = new DataNode(A.data[i][j].value() - B.data[i][j].value());
		return C;
	}

	// does A = B exactly?
	public boolean eq(Matrix B) {
		Matrix A = this;
		if (B.M != A.M || B.N != A.N)
			throw new RuntimeException("Illegal matrix dimensions.");
		for (int i = 0; i < M; i++)
			for (int j = 0; j < N; j++)
				if (A.data[i][j] != B.data[i][j])
					return false;
		return true;
	}

	// return C = A * B
	public Matrix times(Matrix B) {
		Matrix A = this;
		if (A.N != B.M)
			throw new RuntimeException("Illegal matrix dimensions.");
		Matrix C = new Matrix(A.M, B.N);
		// for (int i = 0; i < C.M; i++)
		for (int j = 0; j < C.N; j++)
			for (int k = 0; k < A.N; k++)
				// C.data[i][j] = new DataNode(A.data[i][k].value() * B.data[k][j].value() +
				// "");
				C.data[k][j] = new DataNode(A.data[k][j].value() * B.data[k][j].value());
		return C;
	}

	// return C = A * B
	public Matrix times(int B) {
		Matrix A = this;
		Matrix C = new Matrix(A.M, A.N);
		for (int j = 0; j < C.N; j++)
			for (int k = 0; k < A.N; k++)
				C.data[k][j] = new DataNode(data[k][j].value() * B);
		return C;
	}

	// return x = A^-1 b, assuming A is square and has full rank
	// public Matrix solve(Matrix rhs) {
	// if (M != N || rhs.M != N || rhs.N != 1)
	// throw new RuntimeException("Illegal matrix dimensions.");
	//
	// // create copies of the data
	// // Matrix A = new Matrix(this);
	// // Matrix b = new Matrix(rhs);
	//
	// // Gaussian elimination with partial pivoting
	// for (int i = 0; i < N; i++) {
	//
	// // find pivot row and swap
	// int max = i;
	// for (int j = i + 1; j < N; j++)
	// if (Math.abs(data[j][i].value()) > Math.abs(data[max][i].value()))
	// max = j;
	// swap(i, max);
	// rhs.swap(i, max);
	//
	// // singular
	// if (data[i][i].value() == 0.0)
	// throw new RuntimeException("Matrix is singular.");
	//
	// // pivot within b
	// for (int j = i + 1; j < N; j++)
	// rhs.data[j][0] -= rhs.data[i][0] * data[j][i] / data[i][i];
	//
	// // pivot within A
	// for (int j = i + 1; j < N; j++) {
	// double m = data[j][i] / data[i][i];
	// for (int k = i + 1; k < N; k++) {
	// data[j][k] -= data[i][k] * m;
	// }
	// data[j][i] = 0.0;
	// }
	// }
	//
	// // back substitution
	// Matrix x = new Matrix(N, 1);
	// for (int j = N - 1; j >= 0; j--) {
	// double t = 0.0;
	// for (int k = j + 1; k < N; k++)
	// t += data[j][k] * x.data[k][0];
	// x.data[j][0] = (b.data[j][0] - t) / data[j][j];
	// }
	// return x;
	//
	// }

	// print matrix to standard output
	public void show() {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(data[i][j] + " ");
			System.out.println();
		}
	}

	// test client
	public static void main(String[] args) {
		DataNode[][] d = { { new DataNode(1), new DataNode(2), new DataNode(3) },
				{ new DataNode(4), new DataNode(5), new DataNode(6) },
				{ new DataNode(7), new DataNode(8), new DataNode(9) } };
		Matrix D = new Matrix(d);
		D.show();
		System.out.println();

		Matrix A = Matrix.random(5, 5, 10);
		A.show();
		System.out.println();

		A.swap(MathHelper.rand.nextInt(A.M), MathHelper.rand.nextInt(A.N));
		A.show();
		System.out.println();

		Matrix B = A.transpose();
		B.show();
		System.out.println();

		Matrix C = Matrix.identity(5);
		C.show();
		System.out.println();

		B.times(4).show();
		System.out.println();

		A.plus(B).show();
		System.out.println();

		A.times(C).show();

		// B.times(A).show();
		System.out.println();

		// shouldn't be equal since AB != BA in general
		System.out.println(A.times(B).eq(B.times(A)));
		System.out.println();

		Matrix E = Matrix.random(5, 5, 10);
		E.show();
		// System.out.println();

		// Matrix x = A.solve(b);
		// x.show();
		System.out.println();
		A.times(E).show();

	}
}