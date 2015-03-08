import java.lang.Math;
import java.util.Arrays;
import java.util.Comparator;

public class BoxStacking {

    public static class Box {
	int h, w, d;
	public Box(int h, int w, int d) {
	    this.h = h;
	    this.w = w;
	    this.d = d;
	}
    }

    public static int stackBoxes(Box[] boxes) {

	// add the rest
	Box[] allBoxes = new Box[boxes.length * 3];
	int i = 0;
	for (Box b : boxes) {
	    allBoxes[i] = new Box(b.h, b.w, b.d);
	    allBoxes[i + 1] = new Box(b.w, b.d, b.h);
	    allBoxes[i + 2] = new Box(b.d, b.h, b.w);
	    i += 3;
	}

	Arrays.sort(allBoxes, new Comparator<Box>() {
	    @Override
		public int compare(Box b1, Box b2) {
		int b1Val = b1.w * b1.d;
		int b2Val = b2.w * b2.d;
		return b1Val > b2Val ? -1 : b1Val == b2Val ? 0 : 1;
	    }
	    });

	for (i = 0; i < allBoxes.length; i++) {
	    System.out.print(allBoxes[i].h + " ");
	}
	System.out.println();

	for (i = 0; i < allBoxes.length; i++) {
	    System.out.print(allBoxes[i].w * allBoxes[i].d + " ");
	}
	System.out.println();

	int [] table = new int[allBoxes.length];
	
	Arrays.fill(table, 0);
	table[0] = allBoxes[0].h;
	
	for (i = 1; i < allBoxes.length; i++) {
	    for (int j = 0; j < i; j++) {
		if (allBoxes[i].w < allBoxes[j].w && allBoxes[i].d < allBoxes[j].d) {
		    table[i] = Math.max(table[j] + allBoxes[i].h, table[i]);
		}
	    }
	}

	int result = table[0];
	for (i = 1; i < table.length; i++) {
	    result = Math.max(result, table[i]);
	}
	
	return result;
	    
    }
    
    public static void main(String[] args) {
	Box[] boxes = new Box[4];
	boxes[0] = new Box(4,6,7);  
        boxes[1] = new Box(1,2,3);  
        boxes[2] = new Box(4,5,6);  
        boxes[3] = new Box(10,12,32);  
	System.out.println(stackBoxes(boxes));
    }
}
