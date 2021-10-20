package com.greatlearning.datastructure;

public class BSTRightSkew {

	// A linked list node
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	};

	// A binary tree node
	static class treeNode {
		int data;
		treeNode left;
		treeNode right;

		treeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	};

	static void printElements(Node head) {
		if (head == null) {
			return;
		}
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	static Node sortedList(Node head, treeNode root) {
		// return head if root is null
		if (root == null) {
			return head;
		}

		head = sortedList(head, root.left);
		Node newNode = new Node(root.data);
		Node temp = head;
		Node prev = null;

		// If linked list is empty add the node to the head
		if (temp == null) {
			head = newNode;
		} else {
			while (temp != null) {
				if (temp.data > root.data) {
					break;
				} else {
					prev = temp;
					temp = temp.next;
				}
			}

			// Node is to be attached at the end of the list
			if (temp == null) {
				prev.next = newNode;
			} else {
				// Node is to be attached at the head of the list
				if (prev == null) {
					newNode.next = temp;
					head = newNode;
				} else {
					// Insertion in between the list
					newNode.next = temp;
					prev.next = newNode;
				}
			}
		}

		// Add the nodes of the right sub-tree to the sorted linked list
		head = sortedList(head, root.right);
		return head;
	}

	public static void main(String[] args) {
		treeNode root = new treeNode(50);
		root.left = new treeNode(30);
		root.right = new treeNode(60);
		root.left.left = new treeNode(10);
		root.right.left = new treeNode(40);

		Node head = sortedList(null, root);
		printElements(head);
	}

}
