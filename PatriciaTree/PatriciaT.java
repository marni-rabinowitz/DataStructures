import java.util.ArrayList;

public class PatriciaT {
private PTNode root;
private int size;
private int wordNum;
/**
 * creates the Patricia Tree
 */
public PatriciaT()
	{
		root = new PTNode("");
		size = 0;
		wordNum = 0;
	}
/**
 * Returns true if the Patricia Trie is empty
 * @return boolean true if empty
 */
public boolean isEmpty()
	{
		return size == 0; //this could also be if root == null
	}
	/**
	 * Returns how many nodes are in the Patricia Trie
	 * @return int size
	 */
	public int size()
	{
	return size;
	}
	public int sizex(){
		int size = 0;
		for(PTNode node : root.getList()) {
			for(PTNode x : node.getList()) {
				size += sizex(x);
			}
		}
		return size;
	}
	private int sizex(PTNode node) {
		int size = 0;
		for(PTNode n : node.getList())
			sizex(n);
			size++;
		return size;
	}
	public int wordNum() {
		return wordNum;
	}
	public void add(String word) {
		add(word, root);
		wordNum++;
	}
	public void add(String word, PTNode node)
	{
		String sub = word.substring(0, 1);
		if(contains(sub, node)) {
			if(word.substring(1).length() != 0) {
			add(word.substring(1), getNodeList(sub, node)); //this is a recursive call
			node.addUsed();
			//size++;
			if(node.timesUsed() == 1) {
				size++;
				}
			}
		}
		else
		{
		    PTNode n = new PTNode(sub); 
		    node.addToList(n);
		    if(word.substring(1).length() != 0)
		    {
		    	add(word.substring(1), getNodeList(sub, node));
		    	node.addUsed();
		    	//size++;
		    	if(node.timesUsed() == 1) {
					//size++;
				}
		    	//size++;	
		    }
		    else {}
		    //if(node.timesUsed() == 1)
		    //{
		    size++;
		    System.out.println("TEARS");
		   // }
		}
	}
	/**
	 * the starter remove
	 * @param s
	 * @return
	 */
	public void remove(String s)
	{
		String sub = s.substring(0,1);
		if(contains(sub, root)) {
			PTNode node = getNodeList(sub, root);
			if(s.substring(1).length() != 0) {
				remove(s.substring(1), node);
				System.out.println("THE");
			}
			wordNum--;
		}
			//eturn ;
		
	}
	public void remove(String s, PTNode n) { 
		System.out.println("WHYYYYY");
		String sub = s.substring(0,1);
		if(contains(sub, n)) {
			PTNode nod = getNodeList(s.substring(1), n);
			remove(s.substring(1), n);
			size--;
			System.out.println("DEATH");
			}
		else
			{
				size--;
				System.out.println("CRY");
				n = null;
		}
		
	}
	/**
	 * returns true if String s is in the Patricia Trie
	 * @param s The String to be found
	 * @return boolean true if String s is found
	 */
	public boolean contains(String s, PTNode node)
	{
		ArrayList<PTNode> list = node.getList();
		for(PTNode nod : list) {
			if(nod.getInfo().equals(s))
			return true;
		}
		return false;
	}
	/**
	 * this will return the information in a root's arraylist
	 * @param node
	 * @return
	 */
	public String get()
	{
		String info = "";
		for(PTNode nod : root.getList())
			info += nod.getInfo() + " ";
		return info;
		
	}
	public String get(String n) {
		PTNode node = new PTNode(n.substring(0, 1));
		String tada = get(node);
		return tada;
	}
	private String get(PTNode n) {
		String info = "";
		for(PTNode nod : n.getList()) {
			info += nod.getInfo() + " ";
		}
		return info;
	}
	/**
	 * returns the String s if in the patricia trie
	 * @param s The String to be found
	 * @return String s if the word is found
	 */
	public PTNode getNodeList(String s, PTNode al) 
	{
		ArrayList<PTNode> list = al.getList();
		for(PTNode nod : list) {
			if(nod.getInfo().equals(s))
				return nod;
		}
		return null;
	}
	public String toString()
	{
		String toString = "";
		
		return toString;
	}
}