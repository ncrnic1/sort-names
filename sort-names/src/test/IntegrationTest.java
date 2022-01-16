package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import main.App;
import main.InvalidLineInFileException;

public class IntegrationTest {
	static Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
	
	@SuppressWarnings("deprecation")
	ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testCase_basic() throws IOException, InvalidLineInFileException {
		String file1 = "1-test", file2 = "1-result";
		
		Path file2Path = getPath(file2);
		String[] args = {file1 + ".txt"};
		App.run(args);
		
		assertEquals(true, sameContent(file2Path, getPath(file1 + "-sorted")));
	}
	
	@Test
	public void testCase_complex() throws IOException, InvalidLineInFileException {
		String file1 = "2-test", file2 = "2-result";
		
		Path file2Path = getPath(file2);
		String[] args = {file1 + ".txt"};
		App.run(args);
		
		assertEquals(true, sameContent(file2Path, getPath(file1 + "-sorted")));
	}
	
	@Test
	public void testCase_moreThan2Names() throws IOException, InvalidLineInFileException {
		String file1 = "3-test", file2 = "3-result";
		
		Path file2Path = getPath(file2);
		String[] args = {file1 + ".txt"};
		App.run(args);
		
		assertEquals(true, sameContent(file2Path, getPath(file1 + "-sorted")));
	}
	
	@Test
	public void testCase_lessThan2Names() throws IOException, InvalidLineInFileException {
		String file1 = "4-test", file2 = "4-result";
		
		Path file2Path = getPath(file2);
		String[] args = {file1 + ".txt"};
		App.run(args);
		
		assertEquals(true, sameContent(file2Path, getPath(file1 + "-sorted")));
	}
	
	public static Path getPath(String file) {
		return Paths.get(root.toString(), "src", "test-files", file + ".txt");
	}	
	public static boolean sameContent(Path file1, Path file2) throws IOException {
		return Files.mismatch(file1,  file2) == -1;
	}
}
