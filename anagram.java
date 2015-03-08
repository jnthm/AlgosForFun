import java.util.Arrays;


public class anagram {

		private String input;
		private String reference;
		public anagram(String InPhrase, String RefPhrase) {
			this.input = InPhrase;
			this.reference = RefPhrase;
		}
		
		public boolean detectAnagram () {
			int [] bufForRefString = new int[reference.length()];
				Arrays.fill(bufForRefString,0);
				int found=0;
				
				for (int i = 0; i < input.length(); i++) {
				    found=0;
				    for (int j = 0; j < reference.length(); j++) {
					if ((input.charAt(i) == reference.charAt(j)) && (bufForRefString[j]== 0)) {
					    bufForRefString[j] = 1;
					    found = 1;
					    break;
					}
				    }
				    if (found == 0) {	
					System.out.println("not anagram");
					return false;
				    }			
				}	
				return true;
		}
}
