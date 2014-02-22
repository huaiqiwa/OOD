import java.util.LinkedList;

public class HashTable<K, V> {
	private LinkedList<Pair<K, V>>[] items;
	private int size;
	private final static int DEFAULT_SIZE = 100;
	
	public HashTable() {
		items = (LinkedList<Pair<K, V>>[])new LinkedList[DEFAULT_SIZE];
		this.size = DEFAULT_SIZE;
	}
	
	public HashTable(int size) {
		items = (LinkedList<Pair<K, V>>[])new LinkedList[size];
		this.size = size;
	} 
	
	public void put(K key, V value) {
		int k = key.hashCode() % size;
		if(items[k] == null) items[k] = new LinkedList<Pair<K, V>>();
		for(Pair<K, V> p : items[k]) {
			if(p.key.equals(key)) {
				items[k].remove(p);
				break;
			}
		}
		items[k].add(new Pair<K, V>(key, value));
	}
	
	public V get(K key) {
		int k = key.hasCode() % size;
		if(items[k] == null) return null;
		for(Pair<K, V> p : items[k]) {
			if(p.key.equals(key)) return p.value;
		}
		return null;
	}
	
	private class Pair<K, V> {
		K key;
		V value;	
		Pair(K k, V v) {
			key = k;
			value = v;
		}
	}
}	