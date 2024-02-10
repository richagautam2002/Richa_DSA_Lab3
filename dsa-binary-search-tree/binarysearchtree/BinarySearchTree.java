package dsa.binarysearchtree;

public class BinarySearchTree {
	
	private Node root;
	
	public BinarySearchTree() {
		root =null;
	}
	
	public Node getRoot() {
		return root;
	}
	
	public void insert(Integer value) {
		insertInternal(root, value);
	}
	
	private void insertInternal(Node currentNode,Integer value) {
		Node newNode =newNode(value);
		
		if (root == null) {
			root = newNode;
		}
		
		else {
			NodeInsertionDetails nid = calculateNodeInsertionDetails(currentNode, value);
			
			Node parentNode =nid.getParentNode();
			NodeDirection nodeDirection = nid.getNodeDirection();
			
			if(nodeDirection.equals(NodeDirection.LEFT)) {
				parentNode.setLeftNode(newNode);
				
			}
			else {
				parentNode.setRightNode(newNode);
			}
		}
	}
	
	private Node newNode(Integer value) {
		Node newNode = new Node(value);
		return newNode;
	}
	
	private NodeInsertionDetails calculateNodeInsertionDetails( Node currentNode,int value) {
		NodeInsertionDetails nid =new NodeInsertionDetails();
		
		traverseTree(currentNode, value, nid);
		return nid;
	}
	
	private void traverseTree (Node currentNode , int value, NodeInsertionDetails nid) {
		
		if (value <= currentNode.getData()) {
			
			Node leftNode = currentNode.getLeftNode();
			
			if (leftNode !=null) {
				traverseTree(leftNode, value, nid);
			}
			else {
				nid.set(currentNode, NodeDirection.LEFT);
			}
		}
			
		else {
				
			Node rightNode = currentNode.getRightNode();
				
				
			if (rightNode != null) {
					
				traverseTree(rightNode, value, nid);
			}
			else {
				nid.set(currentNode, NodeDirection.RIGHT);
				
			}
		}
	}
	
}
