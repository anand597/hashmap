package tree;

import tree.BinarySearchTree.Node;

public class TreeMap<K, V> {
	private BinarySearchTree bst=null;
	static  Node[] nodeArray=null;
	static int bucketCapacity=1000000;
	public TreeMap(){
		nodeArray=new Node[bucketCapacity];
		bst=new BinarySearchTree();
	}
	public Node put(K key,V value){
		Node rootNode=null;
		int hashIndex=key.toString().hashCode()%bucketCapacity;
		if(nodeArray[hashIndex]==null){
			Entry newEntry=new Entry(key,value);
			nodeArray[hashIndex]=new Node(newEntry);
		}
		else{
			 rootNode=nodeArray[hashIndex];
			 Entry newEntry=new Entry(key,value);
			 Node newNode=new Node(newEntry);
			 rootNode=bst.insert(rootNode, newEntry);
			 nodeArray[hashIndex]=rootNode;
		}
		return rootNode;
		
	}
	public Object get(K key){
		Object val=null;
		if(key==null){
			return null;
		}
		int hashIndex=key.toString().hashCode()%bucketCapacity;
		Node rootNode=nodeArray[hashIndex];
		val=bst.sort(rootNode, key);
		return val;
	}
  public static void main(String args[]){
	  TreeMap tm=new TreeMap();
	  BinarySearchTree bst1=new BinarySearchTree();
	  Node root=null;
	  for(int i=1;i<=1000000;i++){
		  root=tm.put(i,i);
	  }
	  System.out.println(tm.get(1000000));
	  /*bst1.inOrder(root);*/
  }
	
}
