package com.zbodya;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Algorithm
{
	
	public static Letters setKeyChars() 
	{
		System.out.println("Insert your letters without whitespace (if you dont want to search frequency for whtispace) for searching frequency for them!");
		Scanner scan = new Scanner(System.in);
		String chars = scan.nextLine();
		Letters letters = new Letters(chars);
		return letters;
	}	
	
	public static String[] splitInputSequence() 
	{		
		System.out.println("Insert sentence of words for searching frequency!");
		Scanner scanner = new Scanner(System.in);
		String split = scanner.nextLine();
		return split.split("\\W");
	}
	
	public static int countOfAllMatchedCharacters(String[]words, Letters letters) 
	{		
		int count = 0;
		for(char c : letters.characters) 
		{
			for(String s : words) 
			{
				for(char ch : s.toCharArray())
				{			
					String one = ch+"",two = c+"";
					if(one.equalsIgnoreCase(two))
						count++;
				}
			}
		}
		return count;
	}
	
	public static int countOfAllCharacters(String [] words) 
	{
		int count = 0;
		for(String s : words) 
		{
			count = count + s.length();
		}
		return count;
	}
	
	public static void findFrequency(String [] words, int countOfAllChars, int countOfAllMatchedChars, Letters letters) 
	{	
		boolean addWord = false;
		ArrayList<LetterFrequency> wordsFrequency = new ArrayList();
		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.UP);
		char[] keyChars = letters.keyword.toCharArray();		
		
		for(String word : words) 
		{
			LetterFrequency letter = new LetterFrequency();
			letter.setLengthOfWord(word.length());
			for(char c : word.toCharArray()) 
			{
				for(char ch : keyChars) 
				{
					String one = c+"", two = ch+"";
					if(one.equalsIgnoreCase(two)) 
					{
						addWord = true;
						letter.chars.add(one.toLowerCase().charAt(0));
						letter.countOfChars++; 
					}
						
				}
			}
			letter.setFrequency(letter.getFrequency(countOfAllMatchedChars));
			if(addWord) 
			{
				wordsFrequency.add(letter);		
			}
			addWord = false;
		}
		
		Comparator<LetterFrequency> byCountOfChars = Comparator.comparing(LetterFrequency::getCountOfChars);
		Comparator<LetterFrequency> byLengthOfWords = Comparator.comparing(LetterFrequency::getLengthOfWord);
		Comparator<LetterFrequency> byFirstChar = Comparator.comparing(LetterFrequency::getFirstChar);
		Comparator<LetterFrequency> fullComparator = byCountOfChars.thenComparing(byLengthOfWords).thenComparing(byFirstChar);
		ArrayList<LetterFrequency> sortedResults = (ArrayList<LetterFrequency>) wordsFrequency.stream().sorted(fullComparator).collect(Collectors.toList());
		
		for(LetterFrequency letter : sortedResults) 
		{
			System.out.println("{ (" + letter.chars + ")," + letter.lengthOfWord + " =" + df.format(letter.getFrequency()) + " (" + letter.countOfChars + "/" + countOfAllMatchedChars + ")");
		}		
		System.out.println("TOTAL FREQUENCY: " + df.format((double)countOfAllMatchedChars/countOfAllChars) + " (" + countOfAllMatchedChars + "/" + countOfAllChars + ")");
		writeResultsToFIle(sortedResults, countOfAllMatchedChars, countOfAllChars);
	}
	
	public static void writeResultsToFIle(ArrayList<LetterFrequency> results, int countOfAllMatchedChars, int countOfAllChars) 
	{
		try 
		{
			DecimalFormat df = new DecimalFormat("0.00");
			df.setRoundingMode(RoundingMode.UP);
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("results.txt")));
			for(LetterFrequency letter : results) 
			{				
				writer.write("{ (" + letter.chars + ")," + letter.lengthOfWord + " =" + df.format(letter.getFrequency()) + " (" + letter.countOfChars + "/" + countOfAllMatchedChars + ")");
				writer.newLine();
			}
			writer.write("TOTAL FREQUENCY: " + df.format((double)countOfAllMatchedChars/countOfAllChars) + " (" + countOfAllMatchedChars + "/" + countOfAllChars + ")");
			System.out.println("Results corectly inserted to file");
			writer.close();
		} catch (IOException e) 
		{			
			System.out.println("Problem with writing results to file!");
		}	
		
	}
	
	
	
}



