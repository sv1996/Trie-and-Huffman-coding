class TrieNode{
	char data;
	boolean isTerminating;
	TrieNode children[];

public TrieNode(char data){
	this.data = data;
	isTerminating =false;
	children = new TrieNode[26];
}
class Trie{
	private   TrieNode root;
	
	public   Trie(){
		root = new TrieNode('\0');
	}
}	
}

public class TrieUse {
	public static void add(String word){
	 
		add(root  ,word);
	}
	private static void add(TrieNode root ,String word){
	if(word.length()==0){
		root.isTerminating= true;
		return ;
	}
	int childIndex= word.charAt(0)-'a';
	TrieNode child = root.children[childIndex];
	if(child== null){
		child = new TrieNode(word.charAt(0));
		root.children[childIndex]=child;
	}
		add(child ,word.substring(1));
		
	}
	public static boolean search(String word){
		return searchHelper(root , word);
	}
	private boolean searchHelper(TrieNode root ,String word){
		if(word.length()==0){
			return root.isTerminating;
		}
		int childIndex=word.charAt(0)-'a';
		TrieNode child =root.children[childIndex];
		if(root==null){
			return false;
		}
		return searchHelper(child , word.substring(1));
	}
	public static void main(String[] args) {
		TrieUse t = new TrieUse();
		t.add("this");
		t.add("news");
		System.out.print(t.search("news"));
		

	}	
}


