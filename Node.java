
public class Node implements Comparable<Node>
{
	int votes;
	String person;
	
	public Node(int i, String j)
	{
		votes = i;
		person = j;
	}
	
	//This override came from here, mostly: https://stackoverflow.com/questions/29380093/priorityqueue-insert-with-priority
    @Override public int compareTo(Node other) 
    {
	    return Integer.compare(this.votes, other.votes);
	}
}
