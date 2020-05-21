import java.util.ArrayList;

public class PTNode {
	private String info;
	private ArrayList<PTNode> ar;
	private int numUsed;
	//private PTNode node;
	/**
	 * this creates the Node for the Patricia Tree and sets the given info and creates the arraylist the node references
	 * @param String info
	 */
	public PTNode(String info) {
		this.info = info;
		ar = new ArrayList<PTNode>();
		numUsed = 0;
	}
	/**
	 * This returns the info that the node holds
	 *  @return String info
	 */
	public String getInfo()
	{
		return info;
	}
	public void addUsed() {
		numUsed++;
	}
	public void removeUsed() {
		numUsed--;
	}
	public int timesUsed() {
		return numUsed;
	}
	/**
	 * this returns the list that the Node references
	 * @return ArrayList<PTNode> ar
	 */
	public ArrayList<PTNode> getList()
	{
		return ar;
	}
	/**
	 * Sets the info for the node
	 * @param String s
	 */
	public void setInfo(String s)
	{
		info = s;
	}
	/**
	 * adds a node to the list the list that the current node references
	 */
	public void addToList(PTNode node) 
	{
		ar.add(node);
	}
	/**
	 * returns the current node
	 * @return PTNode node
	 */
	public String toString()
	{
		return "Info: " + info + " ArrayList: " + ar;
	}
}
