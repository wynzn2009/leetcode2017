/**
 * 
 */
package com.prisbox.one;

import java.util.LinkedList;

/**
 * @author LO
 *
 */
public class MinStackLCCI0302 {
	private LinkedList<Integer> l;
	private LinkedList<Integer> min;

	public MinStackLCCI0302() {
		l = new LinkedList();
		min = new LinkedList();
	}

	public void push(int x) {
		l.push(x);
		if (min.isEmpty()) {
			min.push(x);
		} else if (x <= min.peek()) {
			min.push(x);
		}
	}

	public void pop() {
		if (l.peek().equals(min.peek())) {
			min.pop();
		}
		l.pop();
	}

	public int top() {
		return l.peek();
	}

	public int getMin() {
		return min.peek();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStackLCCI0302 m = new MinStackLCCI0302();
		m.push(512);
		m.push(-1024);
		m.push(-1024);
		m.push(512);
		m.pop();
		m.getMin();
		m.pop();
		m.getMin();
		m.pop();
		m.getMin();

	}

}
