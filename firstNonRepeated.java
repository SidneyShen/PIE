/*
Write an efficient function to find the first nonrepeated character in a
string. For instance, the first nonrepeated character in “ total ” is ' o ' and the first
nonrepeated character in “ teeter ” is ' r '. Discuss the efficiency of your algorithm.
*/

import java.util.*;
import java.lang.*;

public class firstNonRepeated{

	public static Character firstNonRepeated(String str){
		HashMap<Character,Integer> charHash = new HashMap<Character,Integer>();
		int i, length;
		char c;
		length = str.length();

		//Scan str, building hash table
		for(i=0;i<length;i++){
			c = str.charAt(i);
			if(charHash.containsKey(c))	charHash.put(c,charHash.get(c)+1);
			else	charHash.put(c,1);
		}

		//Search hash table in order of str
		for(i=0;i<length;i++){
			c = str.charAt(i);
			if(charHash.get(c)==1)
				return c;
		}
		return null;
	}

	public static void main(String[] args) {
		String str = new String("aasefsfedikkia");
		firstNonRepeated test = new firstNonRepeated();

		System.out.println(test.firstNonRepeated(str));
	}


}

public static String firstNonRepeated( String str ){
	HashMap<Integer,Object> charHash = new HashMap<Integer,Object>();
	Object seenOnce = new Object(), seenMultiple = new Object();
	Object seen;
	int i;
	final int length = str.length();
	// Scan str, building hash table
	for (i = 0; i < length; ) { //increment intentionally omitted
		final int cp = str.codePointAt(i);
		i += Character.charCount(cp); //increment based on code point
		seen = charHash.get(cp);

		if (seen == null) { // not present
			charHash.put(cp, seenOnce);
		} 
		else {
			if (seen == seenOnce) {
				charHash.put(cp, seenMultiple);
			}
		}
	}
	// Search hash table in order of str
	for (i = 0; i < length; ) {
		final int cp = str.codePointAt(i);
		i += Character.charCount(cp);
		if (charHash.get(cp) == seenOnce) {
			return new String(Character.toChars(cp));
		}
	}
	return null;
}