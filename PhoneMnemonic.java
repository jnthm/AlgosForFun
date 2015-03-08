import java.util.List;
import java.util.ArrayList;

public class PhoneMnemonic {


private static final String[] M = new String[]{"0", "1", "ABC", "DEF", "GHI",
      "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

    public static List<String> phoneMnemonic(String phoneNumber) {

	char[] phoneNumArrChar = phoneNumber.toCharArray();

	List<String> output = new ArrayList<String>();
	
	phoneMnemonicHelper(phoneNumArrChar, 0, new StringBuilder(), output);
	return output;
    }

    private static void phoneMnemonicHelper(char[] phoneNum, int phoneIndex, StringBuilder curr, List<String> output) {

	// base
	if (phoneIndex == phoneNum.length) {
	    output.add(new  String(curr));
	    return;
	} 
	// else
	String temp = M[phoneNum[phoneIndex] - '0'];
	for (int i = 0; i < temp.length(); i++) {
	    curr.append(temp.substring(i, i + 1));
	    phoneMnemonicHelper(phoneNum, phoneIndex + 1, curr, output);
	    curr.deleteCharAt(curr.length() - 1);
	}
	
    }

    public static void main(String[] args) {
	
	System.out.println(phoneMnemonic("234"));
    }

}
