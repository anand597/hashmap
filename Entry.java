package tree;


public class Entry<K,V> {
	private Object key;
	private Object value;
	public Entry(K key,V v){
		this.key=key;
		this.value=v;
	}
	public Object getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
	
	
}
