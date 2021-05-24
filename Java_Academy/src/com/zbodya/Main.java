package com.zbodya;


public class Main {

	public static void main(String[] args) 
	{
		
		Letters letters = Algorithm.setKeyChars();		
		String [] words = Algorithm.splitInputSequence();
		int countOfAllCharacters = Algorithm.countOfAllCharacters(words);		
		int countOfAllMatchedCharacters = Algorithm.countOfAllMatchedCharacters(words, letters);
		Algorithm.findFrequency(words, countOfAllCharacters, countOfAllMatchedCharacters, letters);
	}

}
