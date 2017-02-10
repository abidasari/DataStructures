package string;

public class Puzzle {
	public int MAX = 100;
	
	public boolean findMatch(char[][] mat, char[] pattern, int nRows, int nCols, int patLen){
		if(patLen > nRows * nCols)
			return false;
		int used[][] = new int[MAX][MAX];
		return findMatchUtil(mat, pattern, nRows, nCols, 0, 0, 0, used);
	}
	
	public boolean findMatchUtil(char[][] mat, char[]pattern, int nRows, int nCols, int x, int y, int patIndex, int[][] used){
		if(patIndex == pattern.length)
			return true;
		if(x == nRows || y == nCols)
			return false;
		if(used[x][y] == 1)
			return false;
		if(mat[x][y] != pattern[0] && patIndex == 0){
			if(x < nRows - 1)
				return findMatchUtil(mat, pattern, nRows, nCols, x + 1, y, patIndex, used);
			else if(y < nCols - 1)
				return findMatchUtil(mat, pattern, nRows, nCols, 0, y + 1, patIndex, used);
			else
				return false;
		} else if(mat[x][y] == pattern[patIndex]){
			boolean result;
			used[x][y] = 1;
			result = (x > 0 ? findMatchUtil(mat, pattern, nRows, nCols, x - 1, y, patIndex + 1, used) : false) || 
					(x < nCols - 1 ? findMatchUtil(mat, pattern, nRows, nCols, x + 1, y, patIndex + 1, used) : false) || 
					(y > 0 ? findMatchUtil(mat, pattern, nRows, nCols, x, y - 1, patIndex + 1, used) : false) || 
					(y < nRows - 1 ? findMatchUtil(mat, pattern, nRows, nCols, x, y + 1, patIndex + 1, used) : false) || 
					((x < nRows - 1 && y < nCols - 1) ? findMatchUtil(mat, pattern, nRows, nCols, x + 1, y + 1, patIndex + 1, used) : false) || 
					((x > 0 && y > 0) ? findMatchUtil(mat, pattern, nRows, nCols, x - 1, y - 1, patIndex + 1, used) : false) || 
					((x > 0 && y < nCols - 1) ? findMatchUtil(mat, pattern, nRows, nCols, x - 1, y + 1, patIndex + 1, used) : false) || 
					((x < nRows - 1 && y > 0) ? findMatchUtil(mat, pattern, nRows, nCols, x + 1, y - 1, patIndex + 1, used) : false);
			used[x][y] = 0;
			return result;
		} else 
			return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Puzzle obj = new Puzzle();
		char[][] mat = {{'a' ,'c', 'p', 'r', 'c'}, 
						{'x' ,'s', 'o', 'p', 'c'}, 
						{'v' ,'o', 'v', 'n', 'i'}, 
						{'w' ,'g', 'f', 'm', 'n'}, 
						{'q' ,'a', 't', 'i', 't'}};
		char[] pattern = {'m', 'i', 'c', 'r', 'o', 's', 'o', 'f', 't'};
		System.out.println(obj.findMatch(mat, pattern, 5, 5, 9));
	}

}
