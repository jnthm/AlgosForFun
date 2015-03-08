import java.util.Random;

public class ExcelEncoding {

    public static String encodeToCol(int n) {
	
	int temp = n;
	int quo = (temp - 1) / 26;
	int strlen = (quo == 0) ? 1 : ((quo - 1) / 26) + 2;
	int rem = (temp - 1) % 26;

	char[] result = new char[strlen];

	for (int i = 0; i < strlen; i++) {
	    quo = (temp - 1) / 26;
	    rem = (temp - 1) % 26;
	    System.out.println("rem = " + rem);
	    result[i] = (char)(rem + 65); // {A, B,..., Z}
	    System.out.println("result at " + i + " = " + result[i]);
	    temp = quo;
	}

	return (new StringBuilder(String.valueOf(result)).reverse().toString());
	
    }


private static String randString(int len) {
    Random r = new Random();
    StringBuilder ret = new StringBuilder();
    while (len-- != 0) {
      ret.append((char) (r.nextInt('Z' - 'A' + 1) + 'A'));
    }
    return ret.toString();
  }

  // @include
  public static int ssDecodeColID(final String col) {
    int ret = 0;
    for (char c : col.toCharArray()) {
      ret = ret * 26 + c - 'A' + 1;
    }
    return ret;
  }
  // @exclude

  private static void simpleTest() {
    assert (1 == ssDecodeColID("A"));
    assert (79 == ssDecodeColID("CA"));
    assert (1431 == ssDecodeColID("BCA"));
  }

    public static void main(String[] args){
	simpleTest();
	System.out.println(encodeToCol(705));
    }
}
