import java.io.File;

class InsertPackage
{
	public static void main(String[] args)
	{
		String packageName = args[0];
		File file = new File(args[1]);
		SCanner reader = new Scanner(file);
	}
}
