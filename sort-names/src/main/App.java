package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {
	private static String outputFilePath;
	private static File inputFile;
	private static List<Name> names = new ArrayList<Name>();
	private static String root = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
	
	public static void run(String[] args) throws FileNotFoundException, UnsupportedEncodingException, InvalidLineInFileException {
		outputFilePath = replaceExtension(root.toString() + "\\src\\test-files\\" + args[0], "-sorted.txt");
		
		readFile(args[0]);
		writeFile(args[0]);

		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i).lastName + ", " + names.get(i).firstName);
		}
		System.out.println("Finished: created " + replaceExtension(inputFile.getName(), "") + "-sorted.txt");
		names.clear();
	}
	
	private static void readFile(String filePath) throws FileNotFoundException, InvalidLineInFileException {
		inputFile = new File(root.toString() + "\\src\\test-files\\" + filePath);
		try (Scanner file = new Scanner(inputFile)) {
			while (file.hasNextLine()) {
				String line = file.nextLine();
				String[] name = parseLine(line);
				if (name.length < 2) {
					throw new InvalidLineInFileException("Invalid line in file: " + line);
				} else {
					names.add(new Name(name[1], name[0]));
				}
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("File not found: " + filePath);
		}
		Collections.sort(names, new NameComparator());
	}
	
	private static void writeFile(String filePath) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(outputFilePath, "UTF-8");
		for (int i = 0; i < names.size(); i++) {
			writer.println(names.get(i).GetName());
		}
		writer.close();
	}
	
	public static String[] parseLine(String line) {
		return line.split(", ", 2);
	}
	
	public static String replaceExtension(String filePath, String replacement) {
		return filePath.replaceFirst("[.][^.]+$", "") + replacement;
	}
}
