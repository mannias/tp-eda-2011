package base;

public class Point {
	int x;
	int y;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Point() {
		new Point(0, 0);
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point sumPoint(Point x) {
		return new Point(this.x + x.x, this.y + x.y);
	}

	public void setPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public static Point antiDirection(Point p) {
		Point newP = new Point(p.x,p.y);
		newP.x *=(-1);
		newP.y *=(-1);
		return newP;
	}

	@Override
	public int hashCode() {
		return x * 7 + y * 13;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	public String toString(){
		return x + " " + y;
	}

}
