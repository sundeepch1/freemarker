package com.skc.springfreemarker.runner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Component
public class AppRunner implements CommandLineRunner{
	
	@Autowired
	private Configuration markerConfig;

	@Override
	public void run(String... args) throws Exception {
		fileBaseMarker();
		stringBaseMarker();
	}

	private void stringBaseMarker() throws IOException, TemplateException {
		String htmlftl = "<!DOCTYPE html>\n"
				+ "<html lang=\"en\">\n"
				+ "<body>\n"
				+ "    <h2>Hello ${name}!</h2>\n"
				+ "</body>\n"
				+ "</html>";
		
		StringReader reader = new StringReader(htmlftl);
		Template template = new Template("hello", reader, markerConfig);
		Map<String, String> dataMap = new HashMap<>();
		dataMap.put("name", "World");
		StringWriter writer = new StringWriter();
		template.process(dataMap, writer);
		System.out.println("New File Created ==== " + writer.toString());
		fileBaseMarker1();
	}

	private void fileBaseMarker() throws IOException, TemplateException {
		FileReader reader = new FileReader(new File("/home/sundeep/file/hello.ftl"));
		Template template = new Template("hello", reader, markerConfig);
		Map<String, String> dataMap = new HashMap<>();
		dataMap.put("name", "World");
		template.process(dataMap, new FileWriter(new File("/home/sundeep/file/test.html")));
		System.out.println("New File Created ==== ");
	}
	
	private void fileBaseMarker1() throws IOException, TemplateException {
		FileReader reader = new FileReader(new File("/home/sundeep/file/vegetables.ftl"));
		Template template = new Template("hello", reader, markerConfig);
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("title", "Vegetables");
		List<Map<String, Object>> vegList = new ArrayList<>();
		Map<String, Object> vegMap = new HashMap<>();
		vegMap.put("name", "tomato");
		vegMap.put("price", 25);
		vegList.add(vegMap);
		vegMap = new HashMap<>();
		vegMap.put("name", "potato");
		vegMap.put("price", 30);
		vegList.add(vegMap);
		vegMap = new HashMap<>();
		vegMap.put("name", "trumstick");
		vegMap.put("price", null);
		vegList.add(vegMap);
		dataMap.put("vals", vegList);
		template.process(dataMap, new FileWriter(new File("/home/sundeep/file/vegetables.html")));
		System.out.println("New File Created ==== ");
	}

}
