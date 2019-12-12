package multithreading.forkjoin;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BinaryOperator;

public class TestApp {

	public static void main(String[] args) {
		int size = 10006;
		Integer[] ints = new Integer[size];
		Random ran = new Random();
		for (int i = 0; i < ints.length; i++) {
			ints[i] = ran.nextInt(size);
		}
		Arrays.asList(ints).forEach(System.out::println);

		ForkJoinPool pool = new ForkJoinPool();

		FindTheMaximumNumberInArray task = new FindTheMaximumNumberInArray(ints, 0, ints.length);

		Integer result = pool.invoke(task);

		System.out.println("Maximum Integer in array is " + result);

		System.out.println(Arrays.stream(ints).max(Integer::compare).get());

		// System.out.println(Arrays.stream(ints).max(Math::max).get());

		// System.out.println(Arrays.stream(ints).parallel().max(Math::max).get());

		System.out.println(Arrays.stream(ints).parallel().max((x, y) -> x > y ? 1 : -1).get());

	}

}
