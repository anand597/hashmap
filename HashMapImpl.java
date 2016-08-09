
public class HashMapImpl implements HashMap{
	static EntryDetails[] bucketArray;
	static int bucketSize=100000;
	public HashMapImpl(){
		bucketArray=new EntryDetails[bucketSize];
	}
	
	@Override
	public void put(String key, String value) {
		if(key==null){
			return;
		}
		int hashIndex=key.hashCode()%bucketSize;
		if(bucketArray[hashIndex]==null){
			bucketArray[hashIndex]=new EntryDetails(key,value,null);
		}
		else{
			EntryDetails prevNode=null;
			EntryDetails currentNode=null;
			EntryDetails iteratingNode=bucketArray[hashIndex];
			while(iteratingNode!=null){
				if(iteratingNode.getNextNode()==null){
					prevNode=iteratingNode;
					currentNode=new EntryDetails(key,value,null);
					prevNode.setNextNode(currentNode);
					break;
				}
				iteratingNode=iteratingNode.getNextNode();
			}
			
		}
	}

	@Override
	public String get(String key) {
		String returnVal=null;
		if(key==null){
			return null;
		}
		int hashIndex=key.hashCode()%bucketSize;
		EntryDetails iteratingNode=bucketArray[hashIndex];
		while(iteratingNode!=null){
			if(iteratingNode.getKey().equalsIgnoreCase(key)){
				returnVal=iteratingNode.getValue();
			}
			iteratingNode=iteratingNode.getNextNode();
		}
		return returnVal;
	}
 public static void main(String[] args){
	 HashMapImpl hashMap=new HashMapImpl();
	 for(int i=1;i<=1000000;i++){
		 String key=String.valueOf(i);
		 hashMap.put(key,key);
	 }
	 long startTime=System.currentTimeMillis();
	 String lastval=hashMap.get("1000000");
	 long endTime=System.currentTimeMillis();
	 System.out.println(lastval);
	 System.out.println(endTime-startTime);
	 
 }
}
