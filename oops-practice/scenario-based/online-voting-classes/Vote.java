public class Vote {
    private Voter voter;
    private Candidate candidate;
    public Vote(Voter voter, Candidate candidate) {
        this.voter = voter;
        this.candidate = candidate;
    }
    public Candidate getCandidate() {
        return candidate;
    }
    public Voter getVoter() {
        return voter;
    }
}