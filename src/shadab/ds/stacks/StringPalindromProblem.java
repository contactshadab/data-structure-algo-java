package shadab.ds.stacks;

public class StringPalindromProblem {
	
	public static boolean isPunctuation(char c) {
		if(c >= 'a' && c <= 'z')
			return false;
		
		return true;
	}
	
	public static boolean isPalindrom(String text) {
		
		LinkedStack<Character> stack = new LinkedStack<Character>();
		
		for(int i=0; i<text.length(); i++) {
			char c = Character.toUpperCase(text.charAt(i));
			
			if(! isPunctuation(c))
				stack.push(c);
		}
		
		for(int i=0; i < text.length(); i++) {
			char c = Character.toUpperCase(text.charAt(i));
			
			if(! isPunctuation(c)) {
				if(stack.pop() != c)
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String text = "Race.,car";
		System.out.println(isPalindrom(text));
	}

}
