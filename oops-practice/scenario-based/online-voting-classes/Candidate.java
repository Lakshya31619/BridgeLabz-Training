public class Candidate {
    private int candidateId;
    private String name;
    private int votes;
    public Candidate(int candidateId, String name) {
        this.candidateId = candidateId;
        this.name = name;
        this.votes = 0;
    }
    public int getCandidateId() {
        return candidateId;
    }
    public String getName() {
        return name;
    }
    public void addVote() {
        votes++;
    }
    public int getVotes() {
        return votes;
    }
}