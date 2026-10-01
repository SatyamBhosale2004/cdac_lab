package in.ads.practice.day1;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.NoSuchElementException;
public class StackAdtPrac {
	static String reverse(String s, StackADT<Character> stack) {
		for(char c : s.toCharArray()) stack.push(c);
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) sb.append(stack.pop());
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse("ALGORITHM" , new DequeStack<>()));
		System.out.println(reverse("ALGORITHM" , new ListStack<>()));
		
		
		StackADT<Integer> st = new DequeStack<>();
		try {
			st.pop();
		}catch(NoSuchElementException e){
			System.out.println(e.getMessage());
		}
	}
	
	
	

}

interface StackADT<T>{
	void push(T item);
	T pop();
	T peek();
	boolean isEmpty();
	int size();
}


class DequeStack<T> implements StackADT<T>{
	private final ArrayDeque<T> data = new ArrayDeque<>();
	public void push(T item) {
		data.push(item);
	}
	public T pop() {
		if(data.isEmpty()) {
			throw new NoSuchElementException("Stack is empty");
		}
		return data.pop();
	}
	public T peek() {
		if(data.isEmpty()) {
			throw new NoSuchElementException("Stack is empty");
		}
		return data.peek();
	}
	
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	public int size() {
		return data.size();
	}
}

class ListStack<T> implements StackADT<T>{
	private final ArrayList<T> data = new ArrayList<>();
	public void push(T item) {
		data.add(item);
	}
	public T pop() {
		if(data.isEmpty()) {
			throw new NoSuchElementException("Stack is empty");
		}
		return data.remove(data.size()-1);
	}
	public T peek() {
		if(data.isEmpty()) {
			throw new NoSuchElementException("Stack is empty");
		}
		return data.get(data.size()-1);
	}
	
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	public int size() {
		return data.size();
	}
}

