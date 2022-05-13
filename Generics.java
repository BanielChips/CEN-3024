import java.util.*;

public class Generics {
	// find the maximum of first, second, and third
	public static <T extends Comparable<T>> T raptorMax(T first, T second, T third) {
		T max = first;

		if (max.compareTo(second) < 0)
			max = second;

		if (max.compareTo(third) < 0)
			max = third;

		return max;
	}

	public static void main(String[] args) {
		System.out.println(raptorMax(11, 88, 96));
		System.out.println(raptorMax("raptor", "radical", "dogs"));

	}
}
