class SafePassword
{
	
	
	static boolean containsDigit(String s)
	{
		for (int i = 0; i < s.length(); i++)
		{
			if ("1234567890".contains(""+s.charAt(i)))
				return true;
		}
		return false;
	}

	static boolean containsUppercaseLett(String s)
	{
		for (int i = 0; i < s.length(); i++)
		{
			if ("QWERTYUIOPASDFGHJKLZXCVBNM".contains(""+s.charAt(i)))
				return true;
		}
		return false;
	}

	static boolean containsLowercaseLett(String s)
	{
		for (int i = 0; i < s.length(); i++)
		{
			if ("qwertyuiopasdfghjklzxcvbnm".contains(""+s.charAt(i)))
				return true;		
		}
		return false;
	}

	static boolean containsSpecialChar(String s)
	{
		String normalChars = "qwertyuiopasdfghjklzxcvbnm"
			+ "QWERTYUIOPASDFGHJKLZXCVBNM"
			+ "1234567890";
		
		for (int i = 0; i < s.length(); i++)
		{
			if (!normalChars.contains(""+s.charAt(i)))
				return true;
		}
		return false;
	}
	
	static boolean isSafePassword(String password)
	{
		if (password.length() < 8)
			return false;
		if (!containsDigit(password))
			return false;
		if (!containsUppercaseLett(password))
			return false;
		if (!containsLowercaseLett(password))
			return false;
		if (!containsSpecialChar(password))
			return false;

		return true;
	}

	public static void main(String[] args)
	{
		StdOut.print("Input a password that satisfies the following conditions: \n"
				+ " - Is at least eight characters long \n"
				+ " - Contains at least one digit \n"
				+ " - Contains at least one uppercase letter \n"
				+ " - Contains at least one lowercase letter \n"
				+ " - Contains at least one character that is not a letter or a digit \n"
				+ "\n"
				+ "Password: ");

		String password;
		if (args.length > 0)
			password = args[0];
		else	
			password = StdIn.readLine();
		
		if (isSafePassword(password))
			StdOut.println("Password is safe");
		else
			StdOut.println("Password is not safe");
	}
}
