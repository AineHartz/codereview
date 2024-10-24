import java.util.*;

public class Election 
{	
	PriorityQueue<Node> heap = new PriorityQueue<Node>(Collections.reverseOrder());
	int p;
	
	public Election(int p)
	{
		this.p = p;
	}
	
	public void initializeCandidates(LinkedList<String> candidates)
	{
		//I got this bit of code from https://www.geeksforgeeks.org/priority-queue-in-reverse-order-in-java/.
		//It's meant to make the priorityqueue into a max heap, as opposed to a min heap. 
		
		for(String i: candidates)
		{
			Node node = new Node(0, i);
			heap.add(node);
		}
	}
	
	public void castVote(String candidate)
	{
		Node[] temp = new Node[heap.size()];
		temp = heap.toArray(temp);
		
		boolean done = false;
		PriorityQueue<Node> tempheap = new PriorityQueue<Node>(Collections.reverseOrder());
		
		for(int i = 0; i < temp.length && done == false ; i++)
		{
			if(temp[i].person.equals(candidate))
			{
				temp[i].votes++;
				done = true;
			}
		}
		
		for(int i = 0; i < temp.length; i++)
		{
			tempheap.add(temp[i]);
		}
		
		heap = tempheap;
	}
	
	public void randomVote()
	{
		Random rand = new Random();
		int temp = rand.nextInt(heap.size() + 1);
		int i = 0;
		PriorityQueue<Node> tempheap = heap;
		
		
		while(i != temp)
		{
			tempheap.poll();
			i++;
		}
		
		Node tempnode = tempheap.poll();
		
		castVote(tempnode.person);
	}
	
	public void rigElection(String candidate)
	{
		Node[] temp = new Node[heap.size()];
		temp = heap.toArray(temp);
		PriorityQueue<Node> tempheap = new PriorityQueue<Node>(Collections.reverseOrder());
		
		for(int i = 0; i < temp.length; i++)
		{
			if(temp[i].person.equals(candidate))
			{
				temp[i].votes = p;
			}
			
			else
			{
				temp[i].votes = 0;
			}
		}
		
		for(int i = 0; i < temp.length; i++)
		{
			tempheap.add(temp[i]);
		}
		
		heap = tempheap;
	}
	
	public String[] getTopKCandidates(int k)
	{
		PriorityQueue<Node> tempheap = new PriorityQueue<Node>(heap);
		String[] answer = new String[k];
		int i = 0;
		
		while(i != k && tempheap.peek() != null)
		{
			answer[i] = tempheap.poll().person;
			i++;
		}
		
		for(int j = 0; j < answer.length; j++)
		{
			System.out.println(answer[j]);
		}
		
		System.out.println("\n");
		
		return answer;
	}
	
	public void auditElection()
	{
		Node[] temp = new Node[heap.size()];
		temp = heap.toArray(temp);
		
		for(int i = 0; i < temp.length; i++)
		{
			System.out.println("Candidate: " + temp[i].person + ", votes: " + temp[i].votes + ".");
		}
		
		System.out.println("\n");
	}
}
