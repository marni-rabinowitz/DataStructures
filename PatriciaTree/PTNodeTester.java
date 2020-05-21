
public class PTNodeTester {

	public static void main(String[] args) {
		PTNode node = new PTNode("a");
		PTNode list = new PTNode("app");
		PTNode list1 = new PTNode("ape");
		PTNode list2 = new PTNode("apple");
		System.out.println("Testing toString method");
		System.out.println(node.toString());
		System.out.println("Testing addToList method");
		node.addToList(list);
		node.addToList(list1);
		System.out.println("Testing toString method");
		System.out.println(node.toString());
		list1.addToList(list2);
		System.out.println("Testing toString method");
		System.out.println(node.toString());
		System.out.println("Testing getInfo method");
		System.out.println(node.getInfo());
		System.out.println("Testing setInfo method");
		node.setInfo("b");
		System.out.println(node.getInfo());
		System.out.println("Testing getList method");
		System.out.println(node.getList());
	}

}
