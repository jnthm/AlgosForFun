import junit.framework.TestCase;
public class anagramTest extends TestCase {
	
	public void testIsAnagram0() {
		anagram ana0 = new anagram("abc","cab");
		assertTrue(ana0.detectAnagram());
	}

	public void testIsAnagram1() {
		anagram ana1 = new anagram("liril","irlil");
		assertTrue(ana1.detectAnagram());
	}
}

