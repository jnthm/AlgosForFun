
public class ClosestStars {


    public static void onlineMedian(InputStream sequence) {
	PriorityQueue<Integer> loPQ = new PriorityQueue<Integer>(11, Collections.reverseOrder());
	PriorityQueue<Integer> hiPQ = new PriorityQueue<Integer>();

	// null cases
	if (hiPQ.size() < loPQ.size() + 2) {
	    hiPQ.add(in);
	} else {
	    if (hiPQ.peek().compareTo(loPQ.peek()) < 0) {
		int temp1 = hiPQ.poll();
		int temp2 = loPQ.poll();
		loPQ.add(temp1);
		hiPQ.add(temp2);
	    } else if (hiPQ.peek().compareTo(loPQ.peek()) > 0) {
		loPQ.add(hiPQ.poll());
	    }
	    if (in > loPQ.peek()) {
		hiPQ.add(in);
	    } else {
		loPQ.add(in);
	    }
	}
    }
    



    public static class Star implements Comparable<Star>, Serializable {
	private double x, y, z;
	public Star(double x, double y, double z) {
	    this.x = x;
	    this.y = y;
	    this.z = z;
	}
	@Override
	    public int compareTo(Star rhs) {
	    double rhsDistance = rhs.x * rhs.x + rhs.y * rhs.y + rhs.z * rhs.z;
	    double distance = x * x + y * y + z * z;
	    return Double.valueOf(distance).compareTo(rhsDistance);
	}
	@Override
	    public boolean equals(Object obj) {
	    if (!(obj instanceof Star)) {
		return false;
	    }
	    if (obj == this) {
		return true;
	    }
	    Star rhs = (Star) obj;
	    double rhsDistance = rhs.x * rhs.x + rhs.y * rhs.y + rhs.z * rhs.z;
	    double distance = x * x + y * y + z * z;
	    return distance == rhsDistance;
	}
    }

    public static List<Star> findClosestKStars(InputStream bin, int k) {
	PriorityQueue<Star> maxHeap = new PriorityQueue<Star>(k);
	try {

	    ObjectInputStream osin = new ObjectInputStream(bin);

	    // fill in the first k
	    for (int i = 0; i < k; i++) {
		maxHeap.add(osin.readObject());
	    }

	    while (true) {
		
		if (maxHeap.peek().compareTo(
	    }

	} catch (ClassNotFoundException e) {
	    System.out.println("ClassNotFoundException: " + e.getMessage());
	}
    }


    public static void main(String[] args) {

	Random r = new Random();
	for (int times = 0; times < 1000; ++times) {
	    int num, k;
	    if (args.length == 1) {
		num = Integer.parseInt(args[0]);
		k = r.nextInt(num) + 1;
	    } else if (args.length == 2) {
		num = Integer.parseInt(args[0]);
		k = Integer.parseInt(args[1]);
	    } else {
		num = r.nextInt(10000) + 1;
		k = r.nextInt(num) + 1;
	    }
	    List<Star> stars = new ArrayList<Star>();
	    // randomly generate num of stars
	    for (int i = 0; i < num; ++i) {
		stars.add(new Star(r.nextInt(100001), r.nextInt(100001), r.nextInt(100001)));
	    }
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    ByteArrayInputStream sin = null;
	    try {
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		for (Star s : stars) {
		    oos.writeObject(s);
		    // System.out.println(s.distance());
		}
		oos.close();
		sin = new ByteArrayInputStream(baos.toByteArray());
	    } catch (IOException e) {
		System.out.println("IOException: " + e.getMessage());
	    }
	    List<Star> closestStars = findClosestKStars(sin, k);
	    Collections.sort(closestStars);
	    Collections.sort(stars);
	    System.out.println("k = " + k);
	    assert (stars.get(k - 1).equals(closestStars.get(closestStars.size() - 1)));
	}
    }
    
}
