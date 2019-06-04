package com.example.demo.bio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class FilesTest {
	
	@Test
	public void test() {
		try {
			Files.copy(Paths.get("bio.txt"),Paths.get("nioCopy.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
