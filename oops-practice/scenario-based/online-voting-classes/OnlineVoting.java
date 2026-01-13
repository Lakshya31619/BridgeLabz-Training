public class OnlineVoting {
    public static void main(String[] args) {
        ElectionService election = new ElectionServiceImpl();
        Voter v1 = new Voter(1, "Arpit Bala");
        Voter v2 = new Voter(2, "Dank Rishu");
        Candidate c1 = new Candidate(1, "BJP");
        Candidate c2 = new Candidate(2, "Congress");
        election.registerVoter(v1);
        election.registerVoter(v2);
        election.addCandidate(c1);
        election.addCandidate(c2);
        try {
            election.castVote(v1, c1);
            election.castVote(v2, c1);
            election.castVote(v1, c2);
        } catch (DuplicateVoteException e) {
            System.out.println("Error: " + e.getMessage());
        }
        election.declareResult();
    }
}