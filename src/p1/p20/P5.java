package p1.p20;

public class P5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(P5.longestPalindrome("babad"));
//		System.out.println(P5.longestPalindrome("cbbd"));
//		System.out.println(P5.longestPalindrome("cccc"));
//		System.out.println(P5.longestPalindrome("abb"));
//		System.out.println(P5.longestPalindrome("abcda"));
//		
//		System.out.println(P5.longestP("babad"));
//		System.out.println(P5.longestP("cbbd"));
//		System.out.println(P5.longestP("cccc"));
//		System.out.println(P5.longestP("abb"));
//		System.out.println(P5.longestP("abcda"));
		System.out.println(P5.longestP("0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
	}

	public static String longestP(String s) {
		int length = s.length();
		if(length == 0)return null;
		if(length == 1)return s;
		int i, j, longest = 0;String reslut = "";
		for (i = 0; i < length - 2; i ++) {
			j = 0;
			while (i - j >= 0 && i + 1 + j < length && s.charAt(i - j) == s.charAt(i + 1 + j)) {
				j ++;
			}
			if (2 * j > longest) {
				longest = 2 * j;
				if(longest == length)return s;
				reslut = s.substring(i - j + 1, i + 1 + j);
			}
			j = 0;
			while (i - j >= 0 && i + 2 + j < length && s.charAt(i - j) == s.charAt(i + 2 + j)){
				j ++;
			}
			if (j > 0 && 2 * j + 1 > longest) {
				longest = 2 * j + 1;
				if(longest == length)return s;
				reslut = s.substring(i - j + 1, i + 2 + j);
			}
		}
		if(s.charAt(length - 1) == s.charAt(length - 2) && longest < 2){
			longest = 2;
			reslut = s.substring(length - 2, length);
		}
		return longest == 0?s.substring(0, 1):reslut;
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