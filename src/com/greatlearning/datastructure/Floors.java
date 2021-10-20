package com.greatlearning.datastructure;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Floors {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the total no of floors in the building");
		int size = sc.nextInt();
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= size; i++) {
			System.out.println("Enter the floor size given on day : " + i);
			int floorSize = sc.nextInt();
			queue.add(floorSize);
		}
		System.out.println(queue);

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		int element = size;
		for (int i = 1; i <= size; i++) {
			int head = queue.poll();
			pq.add(head);
			if (head == element) {
				System.out.println("Day : " + i);
				Iterator<Integer> iterator = pq.iterator();
				int prev = pq.peek();
				boolean printFirst = false;
				while (iterator.hasNext()) {
					int max = pq.peek();
					if (!printFirst) {
						System.out.print(max + " ");
						pq.poll();
						printFirst = true;
						element--;
					} else {
						if (max == prev - 1) {
							System.out.print(max + " ");
							prev = pq.poll();
							element--;
						} else
							break;
					}
				}
				System.out.println();
			} else {
				System.out.println("Day : " + i);
				System.out.println();
			}
		}
	}

}
