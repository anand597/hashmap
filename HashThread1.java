
public class HashThread1 implements Runnable{
	private HashMapImpl hashMap=null;
	public HashThread1(HashMapImpl map){
		this.hashMap=map;
	}
	@Override
	public void run() {
		try{
			 for(int i=1;i<=10000;i++){
				 String key=String.valueOf(i);
				 System.out.println(hashMap.get(key));
			 }
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
	}	
}
