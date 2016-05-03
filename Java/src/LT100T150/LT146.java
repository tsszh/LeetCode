package LT100T150;

import java.util.HashMap;

/**
 * 146. LRU Cache
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and set.
 * 
 * get(key) - 
 * Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * 
 * set(key, value) - 
 * Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 * 
 * @author Zehao
 *
 */
public class LT146 {

}

/*
 * Time: O(1) for both get() and set()
 * Space: O(capacity)
 */
class LRUCache {
	private int capacity;
	private DoubleLinkedList queue;
	private HashMap<Integer, ListNode> map;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		queue = new DoubleLinkedList();
		map = new HashMap<>(capacity);
	}

	public int get(int key) {
		if (!map.containsKey(key))
			return -1;
		ListNode node = map.get(key);
		queue.moveToFirst(node);
		return node.value;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			ListNode node = map.get(key);
			queue.moveToFirst(node);
			node.value = value;
			return;
		}
		if (map.size() == capacity) {
			ListNode node = queue.removeLast();
			map.remove(node.key);
		}
		ListNode node = new ListNode(key, value);
		map.put(key, node);
		queue.addFirst(node);
	}

	private class DoubleLinkedList {
		private int size;
		private ListNode head, tail;

		DoubleLinkedList() {
			head = new ListNode(0, 0);
			tail = new ListNode(0, 0);
			head.next = tail;
			tail.prev = head;
			size = 0;
		}

		ListNode addFirst(ListNode node) {
			node.next = head.next;
			head.next.prev = node;
			head.next = node;
			node.prev = head;
			size++;
			return node;
		}

		void moveToFirst(ListNode node) {
			remove(node);
			addFirst(node);
		}

		ListNode remove(ListNode node) {
			node.prev.next = node.next;
			node.next.prev = node.prev;
			size--;
			return node;
		}

		ListNode removeLast() {
			return size>0 ? remove(tail.prev) : null;
		}
	}

	private class ListNode {
		int key, value;
		ListNode prev, next;

		ListNode(int key, int value) {
			this.value = value;
			this.key = key;
		}
	}
}