package com.zbodya;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Letters
{
	Set<Character> characters = new LinkedHashSet<>();
	String keyword =  "";
	public Letters(String chars) 
	{
		keyword = chars;
		for(char c:chars.toCharArray()) 
		{
			characters.add(c);
		}
		System.out.println(characters);
	}
	
	
}
