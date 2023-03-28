import java.util.LinkedList;

public class Main {
    private interface Votes {
        int upvotes();
        int downvotes();
    }

    @FunctionalInterface
    private interface VoteCounter {
        int getVoteCount(Votes votes);
    }

    private static VoteCounter counter = theVotes -> theVotes.upvotes() - theVotes.downvotes();

    private static void getVoteCount(Votes votes) {
        System.out.println(counter.getVoteCount(votes));
    }

    public static void main(String[] args) {
        LinkedList<Votes> votes = new LinkedList<>();

        votes.add(new Votes() {
            @Override
            public int upvotes() {
                return 13;
            }

            @Override
            public int downvotes() {
                return 0;
            }
        });

        votes.add(new Votes() {
            @Override
            public int upvotes() {
                return 2;
            }

            @Override
            public int downvotes() {
                return 33;
            }
        });

        votes.add(new Votes() {
            @Override
            public int upvotes() {
                return 132;
            }

            @Override
            public int downvotes() {
                return 132;
            }
        });

//        https://javabydeveloper.com/java-8-double-colon-operator/
        votes.forEach(Main::getVoteCount);
    }
}
