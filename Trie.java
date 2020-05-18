public	class	Main{
	public static void main(String []args){
		Node[]	root=new Node[27];
		String[] input ={"ball","bounce","red","bear","talks","bells"};
		System.out.println(new	Trie().build(input));
	}
}

class	Node{
	Node[]	list=new Node[27];
	boolean	endingFlag=false;
	int count=0;
	@Override
    	public String toString() { 
		StringBuilder sb = new StringBuilder();
		sb.append("Node[] : ").append(this.list).append("\n");
		sb.append("count : ").append(this.count).append("\n");
		sb.append("endingFlag : ").append(this.endingFlag).append("\n");
		return sb.toString();
    	}
}

class	Trie{
	Node[]	build(String[] input){
		Node[]	root=new Node[27];
		for(String a:input){
			int count=1;Node newNode;
			if(root[a.charAt(0)-'a']==null){
				newNode=new Node();
				root[a.charAt(0)-'a'] = newNode;
			}else{
				newNode=root[a.charAt(0)-'a'];
			}
			newNode.count+=1;newNode.endingFlag=true;
			for(char c:a.toCharArray()){
				if(count==1){count=0;continue;}
				
				newNode.endingFlag=false;
				newNode.count-=1;
				Node	Node1;
				if(newNode.list[c-'a']==null){
					Node1=new Node();
				}else{
					Node1=newNode.list[c-'a'];
				}
				
				Node1.endingFlag=true;
				Node1.count+=1;
				
				newNode=Node1;
			}System.out.println(newNode);
		}
		return	root;
	}
	
}

