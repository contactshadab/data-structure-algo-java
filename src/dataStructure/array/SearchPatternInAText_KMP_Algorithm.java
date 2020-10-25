package dataStructure.array;

public class SearchPatternInAText_KMP_Algorithm {
	
	public int searchByBruteForceMethod(char[] text, char[] pattern){
		int startingPos = 0;
		int i = 0;
		int j = 0;
		while(startingPos<=text.length-pattern.length) {
			if(text[i] == pattern[j]){
				
				if(j == pattern.length-1)
					return startingPos;
				
				i++;
				j++;
			}else{
				startingPos += 1;
				i = startingPos;
				j = 0;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		String text = "abcbcfgm";
		String pattern = "bcfg";
		
		SearchPatternInAText_KMP_Algorithm searchPattern = new SearchPatternInAText_KMP_Algorithm();
		int index = searchPattern.searchByBruteForceMethod(text.toCharArray(), pattern.toCharArray());
		System.out.println(index);
	}

}
