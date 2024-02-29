class MyDate
{
	private final int year;
	private final int month;
	private final int day;

	public MyDate(int month, int day, int year)
	{
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public boolean before(MyDate other)
	{
		if (this.year < other.year) return true;
		else if (this.year > other.year) return false;
		if (this.month < other.month) return true;
		else if (this.month > other.month) return false;
		if (this.day < other.day) return true;
		return false;
	}

	public boolean after(MyDate other)
	{
		if (this.year > other.year) return true;
		else if (this.year < other.year) return false;
		if (this.month > other.month) return true;
		else if (this.month < other.month) return false;
		if (this.day > other.day) return true;
		return false;
	}

	public boolean equals(MyDate other)
	{
		if (this.year != other.year) return false;
		if (this.month != other.month) return false;
		if (this.day != other.day) return false;
		return true;
	}

	public static boolean isLeapYear(int year)
	{
		if (year % 4 != 0) return false;
		if (year % 100 == 0 && year % 400 != 0) return false;
		return true;
	}

	public boolean inLeapYear()
	{
		return isLeapYear(this.year);
	}

	private int toJulian()
	{
		int y = this.year;
		int m = this.month;
		int d = this.day;
		return (1461 * (y + 4800 + (m - 14)/12))/4 +(367 * (m - 2 - 12 * ((m - 14)/12)))/12 - (3 * ((y + 4900 + (m - 14)/12)/100))/4 + d - 32075;
	}

	public int daysTo(MyDate other)
	{
		return other.toJulian() - this.toJulian();
	}

	public String dayOfWeek()
	{
		int day = (this.toJulian() + 1) % 7;
		switch (day)
		{
			case 0:
				return "Sunday";
			case 1:
				return "Monday";
			case 2:
				return "Tuesday";
			case 3:
				return "Wednesday";
			case 4:
				return "Thursday";
			case 5:
				return "Friday";
			case 6:
				return "Saturday";
			default:
				return null;
		}
	}

	private String month()
	{
		switch (this.month)
		{
			case 1:
				return "January";
			case 2:
				return "February";
			case 3:
				return "March";
			case 4:
				return "April";
			case 5:
				return "May";
			case 6:
				return "June";
			case 7:
				return "July";
			case 8:
				return "August";
			case 9:
				return "September";
			case 10:
				return "October";
			case 11:
				return "November";
			case 12:
				return "December";
			default:
				return null;
		}
	}

	public String toString()
	{
		return String.format("%s %d, %d", this.month(), this.day, this.year);
	}

	public static void main(String[] args) 
	{
	  	MyDate dateOne = new MyDate(4, 5, 1937);
	  	MyDate dateTwo = new MyDate(9, 8, 1968);
	  	MyDate dateThree = new MyDate(4, 16, 1999);
	  	MyDate dateFour = new MyDate(8, 30, 2001);
	  	MyDate dateFive = new MyDate(1, 1, 1900);
	  	MyDate dateSix = new MyDate(1, 1, 2000);
	  	StdOut.println(dateOne);
	  	StdOut.println(dateTwo);
	  	StdOut.println(dateThree);
	  	StdOut.println(dateFour);
	  	StdOut.println(dateFive.inLeapYear());
	  	StdOut.println(dateSix.inLeapYear());
	  	StdOut.println(dateOne.before(dateTwo));
	  	StdOut.println(dateThree.after(dateFour));
	  	StdOut.println(dateOne.equals(dateOne));
	  	StdOut.println(dateOne.daysTo(dateTwo));
	  	StdOut.println(dateFour.daysTo(dateThree));
	  	StdOut.println(dateOne.dayOfWeek());
	  	StdOut.println(dateTwo.dayOfWeek());
	  	StdOut.println(dateThree.dayOfWeek());
	  	StdOut.println(dateFour.dayOfWeek());
	}
}
