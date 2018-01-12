package shadab.programs.recursion;

public class AdditiveSequenceString {
	
//	public boolean isAdditiveSequence(String s, int left, int position){
//		boolean flag = false;
//		if(s.length() == 1)
//			flag = true;
//		else{
//			int left = Integer.valueOf(position);
//			int right = Integer.valueOf(position+1);
//			String substring = s.substring(position);
//			if(substring.startsWith(String.valueOf(left + right)) ){
//				left = right;
//				position++;
//				isAdditiveSequence(left, )
//			}
//			else
//				isAdditiveSequence(substring);
//		}
//		return flag;	
//	}

	public static void main(String[] args) {
		String s = "199100199";
		System.out.println("Following string is in additive sequence - " + s);
		//System.out.println(new AdditiveSequenceString().isAdditiveSequence(s));
	}

}
