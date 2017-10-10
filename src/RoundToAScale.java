import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundToAScale {

	public static void main(String[] args) {

		System.out.println(round(-2.4444d, 3));
	}

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		return new BigDecimal(value).setScale(places, RoundingMode.HALF_EVEN).doubleValue();
	}
}
