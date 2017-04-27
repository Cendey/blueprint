package com.mit.lab.norm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word {
	private Set<String> NON_WORDS = new HashSet<String>() {
		private static final long serialVersionUID = -8523340994399415120L;

		{
			add("the");
			add("and");
			add("of");
			add("to");
			add("a");
			add("i");
			add("it");
			add("in");
			add("or");
			add("is");
			add("d");
			add("s");
			add("as");
			add("so");
			add("but");
			add("be");
		}
	};

	public List<String> regexToList(String words, String regex) {
		List<String> wordList = new ArrayList<>();
		Matcher m = Pattern.compile(regex).matcher(words);
		while (m.find())
			wordList.add(m.group());
		return wordList;
	}

	public Map<String, Integer> wordFreq(String words) {
		Map<String, Integer> wordMap = new TreeMap<String, Integer>();
		regexToList(words, "\\w+").stream().map(String::toLowerCase).filter(word -> !NON_WORDS.contains(words))
				.forEach(word -> wordMap.put(String.valueOf(word), wordMap.getOrDefault(word, 0) + 1));
		return wordMap;
	}
}
