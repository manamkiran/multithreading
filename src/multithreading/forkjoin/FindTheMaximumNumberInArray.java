package multithreading.forkjoin;

import java.util.concurrent.RecursiveTask;

@SuppressWarnings("serial")
public class FindTheMaximumNumberInArray extends RecursiveTask<Integer> {

	private Integer[] input;

	private int start;

	private int end;

	public FindTheMaximumNumberInArray(Integer[] input, int start, int end) {
		this.input = input;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {

		if (end - start > 100) {
			int midPoint = (start+end)/2;
			System.out.println("Splitting the task into range of " + start + " to " + midPoint);
			System.out.println("Splitting the task into range of " + midPoint + " to " + end);
			try {
				FindTheMaximumNumberInArray task1 = new FindTheMaximumNumberInArray(input, start, midPoint);
				FindTheMaximumNumberInArray task2 = new FindTheMaximumNumberInArray(input, midPoint, end);

				task1.fork();
				task2.fork();

				return Math.max(task1.join(), task2.join());
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		} else {
			int max = -1;

			for (int i = start; i < end; i++) {
				if (input[i] > max) {
					max = input[i];
				}
			}

			return max;

		}

	}

}
