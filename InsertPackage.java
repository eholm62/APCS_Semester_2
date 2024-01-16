import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class InsertPackage
{
	public static void main(String[] args) throws IOException
	{
		String packageName = args[0];
		String fileName = args[1];

		Process process = Runtime.getRuntime()
			.exec(String.format("mv %s %s.tmp", fileName, fileName));
		File tempFile = new File(fileName + ".tmp");

		File file = new File(fileName);
		file.createNewFile();

		Scanner reader = new Scanner(tempFile);
		FileWriter writer = new FileWriter(file);

		writer.write(String.format("package %s; \n\n", packageName));
		while (reader.hasNextLine()) 
			writer.write(reader.nextLine() + "\n");
		writer.close();

		process = Runtime.getRuntime()
			.exec(String.format("rm %s.tmp", fileName));
	}
}
