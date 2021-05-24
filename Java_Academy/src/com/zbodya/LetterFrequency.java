package com.zbodya;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LetterFrequency 
{

	LinkedHashSet<Character> chars;
	double frequency;
	int lengthOfWord;
	int countOfChars;
	char firstChar;
	
	public LetterFrequency(Set<Character> chars, double frequency, int lengthOfWord, int countOfChars) {
		super();
		this.chars = (LinkedHashSet<Character>) chars;
		this.frequency = frequency;
		this.lengthOfWord = lengthOfWord;
		this.countOfChars = countOfChars;
	}
	
	public LetterFrequency() 
	{
		chars = new LinkedHashSet<>();
	}
	
	public double getFrequency(int countOfAllMatchedChars) 
	{
		return (double)countOfChars/countOfAllMatchedChars;
	}
	
	public char getFirstChar() 
	{
		Iterator<Character> iterator = chars.iterator();
		return iterator.next();
	}

	public Set<Character> getChars() {
		return chars;
	}

	public void setChars(LinkedHashSet<Character> chars) {
		this.chars = chars;
	}

	public double getFrequency() {
		return frequency;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}

	public int getLengthOfWord() {
		return lengthOfWord;
	}

	public void setLengthOfWord(int lengthOfWord) {
		this.lengthOfWord = lengthOfWord;
	}

	public int getCountOfChars() {
		return countOfChars;
	}

	public void setCountOfChars(int countOfChars) {
		this.countOfChars = countOfChars;
	}

	
	
	
}
