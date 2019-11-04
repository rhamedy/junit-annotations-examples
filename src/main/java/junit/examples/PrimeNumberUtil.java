package junit.examples;

/**
 * A utility class with a method to check if a given
 * number is prime or not.
 *
 * @author Rafiullah Hamedy
 */
public class PrimeNumberUtil {
	public boolean isPrime(int num) {
		if (num <= 1) {
			return false;
		}
		for (int i = 2; i < Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
