import java.util.*;

public class MyStack implements Stack {

	ArrayList<Object> numbers;

	public MyStack() {

		numbers = new ArrayList<Object>();

	}

	public int size() {

		return numbers.size();
	}

	public boolean isEmpty() {

		return numbers.size() == 0;
	}

	public Object pop() {

		Character c = null;
		if (!isEmpty()) {

			c = (Character) numbers.get(numbers.size() - 1);
			numbers.remove(numbers.size() - 1);

		}

		return c;

	}

	public void push(Object o) {

		if (o instanceof Character) {

			Character c = (Character) o;
			numbers.add(c);
		}

	}

	public Object peek() {

		Character c = null;

		return null;

	}

	public String toString() {

		String s = " ";
		for (int i = numbers.size() - 1; i >= 0; i--) {

			s = s + numbers.get(i) + "\n";

		}

		return s;
	}

}
