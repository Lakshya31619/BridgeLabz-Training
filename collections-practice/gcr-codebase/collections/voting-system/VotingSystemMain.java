public class VotingSystemMain {
    public static void main(String[] args) {
        VoteStore store = new VoteStore();
        VoteOrder order = new VoteOrder();
        VoteResult result = new VoteResult();
        store.addVote("Modi");
        order.record("Modi", store.getVotes().get("Modi"));
        store.addVote("Rahul");
        order.record("Rahul", store.getVotes().get("Rahul"));
        store.addVote("Modi");
        order.record("Modi", store.getVotes().get("Modi"));
        store.addVote("Akhilesh");
        order.record("Akhilesh", store.getVotes().get("Akhilesh"));
        store.addVote("Rahul");
        order.record("Rahul", store.getVotes().get("Rahul"));
        order.display();
        result.displaySorted(store.getVotes());
    }
}