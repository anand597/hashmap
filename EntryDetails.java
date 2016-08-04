
public class EntryDetails {
 private String key;
 private String value;
 private EntryDetails nextNode;
 public EntryDetails(String key,String value,EntryDetails next){
	 this.key=key;
	 this.value=value;
	 this.nextNode=next;
 }
 
public String getKey() {
	return key;
}
public void setKey(String key) {
	this.key = key;
}
public String getValue() {
	return value;
}
public void setValue(String value) {
	this.value = value;
}
public EntryDetails getNextNode() {
	return nextNode;
}
public void setNextNode(EntryDetails nextNode) {
	this.nextNode = nextNode;
}
 
	
}
