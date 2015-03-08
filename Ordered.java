public class Ordered {
	
private int a,b,c;

	public Ordered (int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public Boolean isAscending() {
		return (a<b && b<c) ? true : false;
	}

	public Boolean isDescending() {
		return (c<b && b<a) ? true : false;
	}

	public static void main(String [] args) {
			Ordered obj = new Ordered(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
			System.out.println(obj.isAscending() || obj.isDescending());
	}
}
