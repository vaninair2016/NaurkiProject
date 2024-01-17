package selenium.studies;

import java.util.Calendar;

public class TestJQueryDatefieldHandling {
	static int currentDay=0,
			currentMonth=0,
			currentYear=0;
	static int targetDay=0,
			targetMonth=0,
			targetYear=0;
	static int jumpMonthsBy=0;
	
	
	
	public static void getCurrentDay() {
		Calendar cal = Calendar.getInstance();
		currentDay=cal.get(Calendar.DAY_OF_MONTH);
		currentMonth=cal.get(Calendar.MONTH)+1;
		currentYear=cal.get(Calendar.YEAR);
	}
			
	

	public static void main(String[] args) {
		getCurrentDay();
		System.out.println(currentDay + " " +currentMonth + " " +currentYear );

	}

}
