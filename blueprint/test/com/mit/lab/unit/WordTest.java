package com.mit.lab.unit;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mit.lab.init.DataProviderFactory;
import com.mit.lab.norm.Word;

public class WordTest {
	@Parameters({ "start-info" })
	@BeforeTest(groups = "worlds")
	public void startTest(String startInfo) {
		System.out.println(startInfo);
	}

	@Parameters({ "open-info" })
	@BeforeMethod(groups = "worlds")
	public void startSession(String openInfo, Method method) {
		System.out.println(String.format(openInfo, method.toGenericString()));
	}

	@Test(dataProvider = "worlds-factory", dataProviderClass = DataProviderFactory.class, groups = { "worlds" })
	public void testWordFreq(Word contents, String words) throws Exception {
		Map<String, Integer> record = contents.wordFreq(words);
		System.out.println();
		for (Map.Entry<String, Integer> item : record.entrySet()) {
			System.out.println(item.getKey() + " -> " + item.getValue());
		}
	}

	@Parameters({ "close-info" })
	@AfterMethod(groups = "worlds")
	public void closeSession(String closeInfo, Method method) {
		System.out.println(String.format(closeInfo, method.toGenericString()));
	}

	@Parameters({ "finish-info" })
	@AfterTest(groups = "worlds")
	public void finishTest(String finishInfo) {
		System.out.println(finishInfo);
	}
}
