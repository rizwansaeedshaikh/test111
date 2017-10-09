
public class SVNUserCount {

	private static final String CURRENCY_TEXT = "Dollars";
	private static final String ZERO_TEXT="Zero";
	private static final String HUNDREDS_TEXT = "Hundred";
	private static final String[] DIGITS_TEXT = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	private static final String[] TEENS_TEXT = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fiften","Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private static final String[] TENS_TEXT = {"", "", "Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
	private static final String[] BEYONDS_TEXT = {"",  "Thousand", "Million", "Billion"};
	
	public static void main(String[] args) {
		
		int number = 2999;
		int temp = number;
		int unitsPart = 0, tensPart = 0, hundredsPart = 0, thousandsPart = 0, tenThousandsPart = 0, lacsPart = 0, tenLacsPart = 0, croresPart = 0;
		
		for(int count = 8; count > 0; count--) {
			
			if(count == 0) {
				unitsPart = temp % 10;  
			} else if (count == 1) {
				tensPart = temp % 10;
			} else if (count == 2) {
				hundredsPart = temp % 10;
			} else if (count == 3) {
				thousandsPart = temp % 10;
			} else if (count == 4) {
				tenThousandsPart = temp % 10;
			} else if (count == 5) {
				lacsPart = temp % 10;
			} else if (count == 6) {
				tenLacsPart = temp % 10;
			} else if (count == 7) {
				croresPart = temp % 10;
			}
			int lastDigit = temp % 10;
			
			temp = temp / 10; 
		}
		
		System.out.println(numberText(number));
		
	}
	
	private static String numberText(int number) {
		int temp = number;
		if(temp > 100000000) {
		//ten crores
			return "Input must be between 0 and 100000000";
		}
		if(temp == 0) {
			return ZERO_TEXT + CURRENCY_TEXT;
		}
		StringBuilder text = new StringBuilder("");
		while(temp / 1000 != 0) {
			
			text.insert(0, DIGITS_TEXT[temp / 1000] + BEYONDS_TEXT[temp / 1000] + amountPartToText(temp % 1000));
			
			temp = temp / 1000;
		}
		return text.append(CURRENCY_TEXT).toString();
	}
	
	private static String amountPartToText(int number) { //1 to 999
		
		System.out.println("amountPartToText");
		
		StringBuilder text = new StringBuilder("");
		
		if(number % 1000 >= 100) { //100 to 981
			//text.append(DIGITS_TEXT[number / 100]).append(HUNDREDS_TEXT).append(TENS_TEXT[(number % 100)/ 10]).append(DIGITS_TEXT[number % 10]);
			text.append(DIGITS_TEXT[number / 100]).append(HUNDREDS_TEXT);
			System.out.println("100 to 999");
		}
		number = number % 100;
		
		if(number >= 1 && number <= 9) {
			//text.insert(0, DIGITS_TEXT[number]);
			text.append( DIGITS_TEXT[number]);
			System.out.println("1 to 9");
		}
		
		if(number >= 10 && number <= 19) {
			//text.insert(0, TEENS_TEXT[number % 10]);
			text.append( TEENS_TEXT[number % 10]);
			System.out.println("10 to 19");
		}
		
		if(number % 100 < 100 && number > 19) { //20 to 99 
			System.out.println("First if");
			//text.insert(0, TENS_TEXT[number / 10]);
			text.append(TENS_TEXT[number / 10]);
			number = number % 10;
			text.append(DIGITS_TEXT[number]);
			System.out.println("20 to 99");
		}
		
		return text.toString();
	}
}

