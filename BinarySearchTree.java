package tree;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.plaf.basic.BasicBorders.RolloverButtonBorder;

public class BinarySearchTree {
	 static class Node{
		Entry rootData;
		Node leftNode;
		Node rightNode;
		public Node(Entry value){
			this.rootData=value;
		}
		public Entry getRootData() {
			return rootData;
		}
		public void setRootData(Entry rootData) {
			this.rootData = rootData;
		}
		public Node getLeftNode() {
			return leftNode;
		}
		public void setLeftNode(Node leftNode) {
			this.leftNode = leftNode;
		}
		public Node getRightNode() {
			return rightNode;
		}
		public void setRightNode(Node rightNode) {
			this.rightNode = rightNode;
		}
		
		
	}
	private Node root;
	public Node insert(Node root,Entry val){
		root=formBinaryTree(root,val);
		return root;
	}
	private Node formBinaryTree(Node root,Entry data){
		if(root==null){
			root=new Node(data);
			return root;
		}
		else{
			int key1=(int) data.getKey();
			int key2=(int)(root.getRootData().getKey());
			if(key1<key2){
				Node leftNode=root.getLeftNode();
				leftNode=formBinaryTree(leftNode, data);
				root.setLeftNode(leftNode);
			}
			else{
				Node rightNode=root.getRightNode();
				rightNode=formBinaryTree(rightNode, data);
				root.setRightNode(rightNode);
			}
		}
		return root;
	}
	public Object sort(Node root,Object key){
		Object val=null;
		if(root!=null){
			sort(root.leftNode,key);
			if(root.getRootData().getKey().equals(key)){
				val=root.getRootData().getValue();
			}
			sort(root.rightNode,key);
		}
		return val;
	}
	public static void main(String args[]){
		BinarySearchTree bst=new BinarySearchTree();
		List<Integer> numberList=new ArrayList<Integer>();
		for(int i=0;i<1000000;i++){
			numberList.add(i);
		}
		Collections.shuffle(numberList);
		Node root=null;
		for(Integer a:numberList){
			Entry newObj=new Entry(a,a);
			root=bst.insert(root,newObj);
		}
		bst.inOrder(root);
		long startTime=System.currentTimeMillis();
		long endTime=System.currentTimeMillis();
		long duration = endTime - startTime;
		System.out.println("duartion"+duration);
	}
	public void inOrder(Node root){
		Object val=null;
		if(root!=null){
			inOrder(root.leftNode);
			System.out.println(root.getRootData().getKey());
			inOrder(root.rightNode);
		}
	}
}
