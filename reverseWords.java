/*
Write a function that reverses the order of the words in a string. For
example, your function should transform the string "Do or do not, there is no
try." to "try. no is there not, do or Do". Assume that all words are space delim-
ited and treat punctuation the same as letters.
*/

public class reverseWords{
	private char[] str;

	public void reverseWords(String inputarr){
		this.str = inputarr.toCharArray();
		int start = 0;
		int end = str.length-1;
		int stringBegin=0;
		int stringEnd =0;

		reverseString(str, start,end);
		printstring();

		while(stringEnd<=end){
			if(str[stringEnd] == ' '){
				// while(strBegin<=end){
					reverseString(str, stringBegin, stringEnd-1);
					stringBegin = stringEnd+1;
					stringEnd++;
					continue;
				// }	
			}
			else{
				if(stringEnd == end){
					reverseString(str, stringBegin, stringEnd);  //reverse the last word
					break;
				}
				else
					stringEnd++;
			}
		}
	}
	public void reverseString(char[] str, int start, int end){
		while(start<end){
			char temp = str[start];
			str[start++] = str[end];
			str[end--] = temp;
		}
	} 

	public void printstring(){
		for(char i:this.str)
			System.out.print(i);
		System.out.println();

	}

	public static void main(String[] args) {
		String input = new String("Hey! Come and play!");
		reverseWords test = new reverseWords();
		test.reverseWords(input);
		test.printstring();
	}

}

public class reverseWords{

	public String reverseWords(String str){
		int length, tokenReadPos, wordEnd, wordBegin= 0;
		char[] s = str.toCharArray();

		StringBuilder temp = new StringBuilder();

		if(str == null || str.isEmpty()) return null;

		tokenReadPos = s.length-1;

		while(tokenReadPos>=0){
			if(s[tokenReadPos] == ' '){
				temp.append(' ');
				tokenReadPos--;
			}
			else{
				wordEnd = tokenReadPos;
				while(tokenReadPos>=0 && s[tokenReadPos]!=' '){
					tokenReadPos--;
				}
				wordBegin = tokenReadPos+1; //back to the postion of wordBegin
				temp.append(s, wordBegin, wordEnd-wordBegin+1);
			}
		}

		return temp.toString();
	}

	public static void main(String[] args) {
		String input = new String("Hey! Come and play!");
		reverseWords test = new reverseWords();
		System.out.println(test.reverseWords(input));
	}
}