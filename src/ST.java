import java.util.Iterator;

public class ST<Key extends Comparable<Key>, Value> {
//Comment for merge
	Node first;
	int count = 0;

	ST() {

	}

	void put(Key key, Value val) {
		if (key == null)
			return;
		if (isEmpty()) {
			first = new Node();
			first.key = key;
			first.value = val;
			first.next = null;
			count ++;
			return;

		}
		Node temp = first;
		while (temp != null) {
			if (temp.key.equals(key)) {
				temp.value = val;
				return;
			}
			temp = temp.next;
		}
		Node oldFirst = first;
		first = new Node();
		first.key = key;
		first.value = val;
		first.next = oldFirst;
		count ++;
	}

	Value get(Key key) {
		if (key == null)
			return null; // ����� ������ Exception
		Node temp = first;
		while (temp != null) {
			if (temp.key.equals(key)) {
				return (Value) temp.value;
			}
			temp = temp.next;
		}
		return null;
	}

	void delete(Key key) {
		if (key == null){
			return;
		}
		Node temp = first;
		if(first.key.equals(key)){
			first = first.next;
			count--;
		}
		while (temp.next != null) {
			if ((temp.next).key.equals(key)) {
				temp.next.key = null;
				temp.next.value = null;
				Node finded  = temp.next;
				Node newNext = finded.next;
				temp.next = newNext;
				count--;
				return;
			}
			temp = temp.next;
		}
		
	}

	
		

	boolean contains(Key key) {
		return get(key) != null;
	}

	boolean isEmpty() {
		return first == null;
	}

	int size() {
		if (isEmpty())
			return 0;
		else
			return count;
	}

	Key min() {// ��������� ����
		Node temp = first;
		Key minKey = (Key) first.key;
		while (temp != null) {
			if (((Key)temp.key).compareTo(minKey)<0) {
				minKey = (Key)temp.key;
			}
			temp = temp.next;
		}
		return minKey;
	}

	Key max() {// ���������� ����
		Node temp = first;
		Key maxKey = (Key) first.key;
		while (temp != null) {
			if (((Key)temp.key).compareTo(maxKey)>0) {
				maxKey = (Key)temp.key;
			}
			temp = temp.next;
		}
		return maxKey;
	}

	

	int rank(Key key) {// ��������� ������ ������ �� key
		int rez  = 0;
		Node temp = first;
		//Node min = (Node) min();
		Key minKey = min();
		while (temp != null) {
			if (((Key)temp.key).compareTo(key)<0) {
				
				rez++;
			}
			temp = temp.next;
		}
		return rez;
	}

	Key select(int k)  {//key k
		int counter = 1;
		if(k <0||k>count){
			throw new IllegalArgumentException();
		}
		Node temp = first;
			while(temp!= null){
				if(counter == k){
					return (Key)temp.key;
				}
			counter++;			
			temp = temp.next;
			}
		return (Key)temp.key;
	}

	void deleteMin() {
		Key key = min();
		if (key == null)
			return;
		delete(key);
	}

	void deleteMax() {
		Key key = max();
		if (key == null)
			return;
		delete(key);

	}
	
	Key floor(Key key) {//���������� ���� ������ ��� ������ key
	if(key == null){
		throw new IllegalArgumentException();
	}
	Node temp = first;
	Key result = (Key)temp.key;
		while(temp!=null){
			if(((Key)temp.key).compareTo(key)<=0){
			if(((Key)temp.key).compareTo(result)>0){
				result = (Key)temp.key;
			}
			}
			temp = temp.next;
		}
		return result;
	}
	
	Key ceiling(Key key) {//��������� ���� ������� ��� ������ key
		if(key == null){
			throw new IllegalArgumentException();
		}
		Node temp = first;
		Key result = (Key)temp.key;
			while(temp!=null){
				if(((Key)temp.key).compareTo(key)<=0){
				if(((Key)temp.key).compareTo(result)<0){
					result = (Key)temp.key;
				}
				}
				temp = temp.next;
			}
			return result;
	}

	int size(Key lo, Key hi) {// ��������� ������ � [lo..hi]
		int rez = 0;
		Node temp = first;
		while(temp!=null){
			if(((Key)temp.key).compareTo(hi)<=0&&((Key)temp.key).compareTo(lo)>=0){
				rez++;
			}
			temp = temp.next;
		}
		return rez;
	}
	public Iterable<Key> keys() {
		return new KeyIterator();
	}

	private class KeyIterator implements Iterator<Key>, Iterable<Key> {

		private Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Key next() {
			Key key = (Key) current.key;
			current = current.next;
			return key;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

		@Override
		public Iterator<Key> iterator() {
			return this;
		}

	}
	

	private class Node<Key, Value> {
		Key key;
		Value value;
		Node next;
		
	}
	
	
	
	
	}

