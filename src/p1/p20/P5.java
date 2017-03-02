package p1.p20;

public class P5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(P5.longestPalindrome("babad"));
		System.out.println(P5.longestPalindrome("cbbd"));
		System.out.println(P5.longestPalindrome("cccc"));
		System.out.println(P5.longestPalindrome("abb"));
		System.out.println(P5.longestPalindrome("abcda"));
	}

	public static String longestP(String s) {
		int length = s.length();
		int i, j;
		for (i = 0; i < length - 2; i ++) {
			if (s.charAt(i) == s.charAt(i + 1)){
				
			}
		}
	}
	
	public static String longestPalindrome(String s) {
		int length = s.length();
		if(length == 0){
			return null;
		}
		char[] a = s.toCharArray();
		char[] b = new char[length];
		int i,j;
		for(i = 0;i < length; i ++) {
			b[length - 1 - i] = a[i]; 
		}
		int longest = 0;
		String string = "";
		for(i = 0; i < length; i ++) {
			int longest_t = 0;
			int sequenced = 0;
			String string_t = "";
			StringBuilder sequencedStr = new StringBuilder();
			for(j = 0; j < length - i; j ++) {
				if( a[j] == b[i + j]) {
					sequenced ++;
					sequencedStr.append(String.valueOf(a[j]));
				} else {
					if ( sequenced != 0) {
						if ( sequenced > longest_t){
							longest_t = sequenced;
							string_t = sequencedStr.toString();
						}
						sequenced = 0;
						sequencedStr = new StringBuilder();
					}
				}
			}
			if( sequenced == length - i) {
				longest_t = sequenced;
				string_t = sequencedStr.toString();
			}
			sequenced = 0;sequencedStr = new StringBuilder();
			for(j = 0; j < length - i; j ++) {
				if( b[j] == a[i + j]) {
					sequenced ++;
					sequencedStr.append(String.valueOf(b[j]));
				} else {
					if ( sequenced != 0) {
						if ( sequenced > longest_t){
							longest_t = sequenced;
							string_t = sequencedStr.toString();
						}
						sequenced = 0;
						sequencedStr = new StringBuilder();
					}
				}
			}
			if( sequenced == length - i) {
				longest_t = sequenced;
				string_t = sequencedStr.toString();
			}
			if (longest_t > longest) {
				longest = longest_t;
				string = string_t;
			}
		}
		return string;
    }
}