



public class Main {
    public static void main(String[] args) {
      People frankie =  new People("Frankie", "Living", true);
      People lucifer =  new People("Lucifer", "Living", true);
      People asura =  new People("Asura", "Living", true);
      People purps =  new People("Purps", "Living", true);
      Game g = new Game();
      g.register(lucifer);
      g.register(purps);
      g.register(frankie);
      g.register(asura);
      g.randomizeKiller();
      g.randomizeDetective();
      g.printAliveList();
      System.out.println();

      g.setupVote();
      System.out.println("voting");
      g.vote(asura);
      g.vote(asura);

      System.out.println(g.printVotes());
      g.revote(asura, purps);
      System.out.println("new vote:");
      System.out.println(g.printVotes());
      g.closeVote();
      System.out.println("Closed voting");
      System.out.println(g.printVotes());
      System.out.printf("\nAlive\n");
      g.printAliveList();
      System.out.printf("\nDead\n");
      g.printDeadList();


    }
}