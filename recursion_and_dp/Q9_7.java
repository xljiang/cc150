package recursion_and_dp;

// paintFill
public class Q9_7 {
	public static void fill(int[][] screen, int x, int y, int color){
		if (screen[y][x] == color) return;
		fill(screen, x, y, screen[y][x], color);
	}
	
	public static void fill(int[][] screen, int x, int y, int oldcolor, int color){
		if (x<0 || x > screen[0].length || y < 0 || y > screen.length) return;
		if (screen[y][x] == oldcolor){
			screen[y][x] = color;
			fill(screen, x - 1, y, oldcolor, color);
			fill(screen, x + 1, y, oldcolor, color);
			fill(screen, x, y - 1, oldcolor, color);
			fill(screen, x, y + 1, oldcolor, color);
		}
	}
}
