
public class HashThread implements Runnable{
	private HashMapImpl hashMap=null;
	public HashThread(){
		hashMap=new HashMapImpl();
	}
	@Override
	public void run() {
		 try{
			 for(int i=1;i<=10000;i++){
				 String key=String.valueOf(i);
				 hashMap.put(key, key);
			 }
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
	}
   public static void main(String[] args){
	   HashThread hashThread=new HashThread();
	   Thread thread=new Thread(hashThread);
	   thread.start();
	   thread.run();
	   HashThread1 hashThread1=new HashThread1(hashThread.hashMap);
	   Thread thread1=new Thread(hashThread1);
	   thread1.start();
	   thread1.run();
	   
   }
}
