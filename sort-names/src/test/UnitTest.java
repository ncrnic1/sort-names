package test;

import main.App;
import main.InvalidLineInFileException;
import main.Name;
import main.NameComparator;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class UnitTest {
	Name name1 = new Name("JOHN", "DOE"), name2;
	NameComparator comparator = new NameComparator();
	String line;
	
	@SuppressWarnings("deprecation")
	ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testNameConcat() {
		String result = name1.GetName();
		assertEquals("DOE, JOHN", result);
	}
	
	@Test
	public void testComparatorLastName() {
		name2 = new Name("JOHN", "ZEBRA");
		int result = comparator.compare(name1, name2);
		assertEquals(true, result < 0);
	}
	
	@Test
	public void testComparatorLastNameSecondaryLetters() {
		name2 = new Name("JOHN", "DOUGLAS");
		int result = comparator.compare(name1, name2);
		assertEquals(true, result < 0);
	}
	
	@Test
	public void testComparatorFirstName() {
		name2 = new Name("APPLE", "DOE");
		int result = comparator.compare(name1, name2);
		assertEquals(false, result < 0);
	}
	
	@Test
	public void testComparatorFirstNameSecondaryLetters() {
		name2 = new Name("JOEY", "DOE");
		int result = comparator.compare(name1, name2);
		assertEquals(false, result < 0);
	}
	
	@Test
	public void testComparatorSameName() {
		name2 = new Name("JOHN", "DOE");
		int result = comparator.compare(name1, name2);
		assertEquals(true, result == 0);
	}
	
	@Test
	public void testParse2Names() {
		line = "DOE, JOHN";
		String[] result = App.parseLine(line);
		assertEquals(true, result.length == 2 && result[0].equals("DOE") && result[1].equals("JOHN"));
	}

	@Test
	public void testParseMoreThan2Names() {
		line = "DOE, JOHN, APPLE, ZEBRA";
		String[] result = App.parseLine(line);
		assertEquals(true, result.length == 2 && result[0].equals("DOE") && result[1].equals("JOHN, APPLE, ZEBRA"));
	}
	
	@Test
	public void testParseLessThan2Names() {
		line = "DOE, ";
		String[] result = App.parseLine(line);
		assertEquals(true, result.length == 2 && result[0].equals("DOE") && result[1].equals(""));
	}
	
	@Test
	public void testInvalidLineInFileExceptionIfInvalidSplit() {
		line = "DOE;JOHN";
		exception.expect(InvalidLineInFileException.class);
		exception.expectMessage("Invalid line in file: " + line);
		App.parseLine(line);
	}
	
	@Test
	public void testInvalidLineInFileExceptionIfEmptyLine() {
		line = "\n";
		exception.expect(InvalidLineInFileException.class);
		exception.expectMessage("Invalid line in file: " + line);
		App.parseLine(line);
	}
	
	@Test
	public void testReplaceExtension() {
		String result = App.replaceExtension("file.abcdefg", ".txt");
		assertEquals("file.txt", result);
	}
	
	@Test
	public void testReplaceExtensionNoPeriod() {
		String result = App.replaceExtension("file", ".txt");
		assertEquals("file.txt", result);
	}
}
