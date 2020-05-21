
public class PatriciaTTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PatriciaT pt = new PatriciaT();
		System.out.println("SIZE METHOD expected 0");
		System.out.println(pt.size());
		pt.add("ape");
		pt.add("apple");
		pt.add("cat");
		pt.add("tiger");
		System.out.println(pt.size() + " Size expected = 14");
		System.out.println(pt.sizex()+ " SIZE X");
		System.out.println(pt.wordNum() + " Words expected = 4");
		System.out.println(pt.get());
		System.out.println(pt.get("tiger"));
		pt.remove("apple");
		System.out.println(pt.get("cat"));
		pt.remove("ape");
		System.out.println(pt.size() + " Size expected = 8");
		System.out.println(pt.sizex()+ " SIZE X");
		System.out.println(pt.wordNum() + " Words expected = 2");
		
		}

}
