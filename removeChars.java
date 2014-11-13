/*
PROBLEM Write an efficient function that deletes characters from an ASCII
string. Use the prototype

           string removeChars( string str, string remove );

where any character existing in remove must be deleted from str. 
For example,given a str of "Battle of the Vowels: Hawaii vs. Grozny" and a remove of
"aeiou", the function should transform str to “Bttl f th Vwls: Hw vs. Grzny”.
Justify any design decisions you make, and discuss the efficiency of your solution.
*/

public class removeChars{

	public String removeChars(String str, String remove){
		char[] s = str.toCharArray();
		char[] r = remove.toCharArray();
		int src, dst = 0;

		boolean[] flags = new boolean[128];

		for(src = 0; src<r.length; src++){
			flags[r[src]] = true;
		}

		for(src = 0; src<s.length; src++){
			if(!flags[s[src]]){
				s[dst++]=s[src];
			}
		}
		return new String(s,0,dst);
	}

	public static void main(String[] args) {
		String original_str= new String("I am a student");
		String remove_str = "a";

		removeChars test = new removeChars();
		

		System.out.println(test.removeChars(original_str,remove_str));
	}
}