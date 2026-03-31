public class ElectionServiceImpl extends ElectionService {
    private Voter[] voters;
    private Candidate[] candidates;
    private Vote[] votes;
    private int voterCount;
    private int candidateCount;
    private int voteCount;
    public ElectionServiceImpl() {
        voters = new Voter[5];
        candidates = new Candidate[5];
        votes = new Vote[10];
        voterCount = 0;
        candidateCount = 0;
        voteCount = 0;
    }
    public void registerVoter(Voter voter) {
        voters[voterCount++] = voter;
        System.out.println("Voter registered: " + voter.getName());
    }
    public void addCandidate(Candidate candidate) {
        candidates[candidateCount++] = candidate;
        System.out.println("Candidate added: " + candidate.getName());
    }
    public void castVote(Voter voter, Candidate candidate) throws DuplicateVoteException {
        if (voter.hasVoted()) {
            throw new DuplicateVoteException( "Voter " + voter.getName() + " has already voted!");
        }
        Vote vote = new Vote(voter, candidate);
        votes[voteCount++] = vote;
        candidate.addVote();
        voter.markVoted();
        System.out.println(voter.getName() + " voted for " + candidate.getName());
    }
    public void declareResult() {
        System.out.println("\n----- Election Results -----");
        for (int i = 0; i < candidateCount; i++) {
            System.out.println(candidates[i].getName() + " → Votes: " + candidates[i].getVotes());
        }
        String winner = "";
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < candidateCount; i++) {
            if (candidates[i].getVotes() > max) {
                max = candidates[i].getVotes();
                winner = candidates[i].getName();
            }
        }
        System.out.println("The winner of election is : " + winner);
    }
}