package array_and_string;

public class Q1_6 {
	public static void rotateClockwise(int[][] matrix, int n){
		for(int layer = 0; layer < n/2; ++layer){
			int first = layer;
			int last = n - 1 - layer;
			for(int i = first; i < last; ++i){
				int offset = i - first;
				int top = matrix[first][i]; // save top
				matrix[first][i] = matrix[last-offset][first]; // left -> top
				matrix[last-offset][first] = matrix[last][last-offset]; // bottom -> left
				matrix[last][last-offset] = matrix[i][last];// right -> bottom
				matrix[i][last] = top; // top -> right
			}
		}
	}
}
