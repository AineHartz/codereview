import java.util.LinkedList;

public class ElectionSystem 
{
	public static void main(String[] args)
	{
		LinkedList<String> candidates = new LinkedList();
		
		candidates.add("Marcus Fenix");
		candidates.add("Dominic Santiago");
		candidates.add("Damon Baird");
		candidates.add("Cole Train");
		candidates.add("Anya Stroud");
		
		Election election = new Election(5);
		election.initializeCandidates(candidates);
		
		election.castVote("Cole Train");
		election.castVote("Cole Train");
		election.castVote("Marcus Fenix");
		election.castVote("Anya Stroud");
		election.castVote("Anya Stroud");	
		
		election.getTopKCandidates(3);
		
		election.rigElection("Marcus Fenix");
		
		election.getTopKCandidates(3);
		
		election.auditElection();	
	}
}
