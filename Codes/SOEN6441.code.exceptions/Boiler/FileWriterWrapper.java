import java.io.*;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterWrapper {
	public FileWriterWrapper(String new_file) {
		try {
			file = new BufferedWriter(new FileWriter(new_file));
		} catch (IOException e) {
			System.out.println("WARNING: file cannot be opened");
		}
	}

	void close() {
		try {
			file.close();
		} catch (IOException e) {
			System.out.println("WARNING: file cannot be closed");
		}
	}

	void write(String new_string) {
		try {
			file.write(new_string);
		} catch (IOException e) {
			System.out.println("WARNING: file cannot be written");
		}
	}

	private BufferedWriter file;
}
