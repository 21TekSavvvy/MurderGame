
import java.util.*;

public class Game
{
    private  ArrayList <People> living = new ArrayList<People>();
    private  ArrayList <People> dead = new ArrayList<People>();
    private final Scanner in = new Scanner(System.in);
    private HashMap<People,Integer> votes = new HashMap<>();
    private Random r = new Random();

    public  Game ()
    {
        setupVote();
        menu();

    }
    // Set up Menu for the game
    public void menu()
    {



    }
    // Randomize the Killer automatically
    public void randomizeKiller()
    {
        int random = r.nextInt(living.size() - 1) + 1;
        if ((living.get(random).getRole().equalsIgnoreCase("Detective")))
        {
            randomizeKiller();
        }
        else
        {
            living.get(random).setRole("Murderer");
        }
    }
    // Randomize Detective
    public void randomizeDetective()
    {
        int random = r.nextInt(living.size() - 1) + 1;
        if ((living.get(random).getRole().equalsIgnoreCase("Murderer")))
        {
            randomizeDetective();
        }
        else
        {
            living.get(random).setRole("Detective");
        }
    }

    // setup voting and initialize
    public  void setupVote ()
    {
        int count = 0;
        for (People p : living)
        {
            votes.put(p, count);

        }




    }

    //allows players revote before vote closing
    public void revote (People unvoted, People newVote)
    {
        for (People people : living)
        {
            if (people.equals(unvoted))
            {


                votes.compute(people, (key, val)
                        -> (val == null)
                        ? 0
                        : val - 1);
                break;
            }


        }
        for (People people : living)
        {
            if (people.equals(newVote))
            {


                votes.compute(people, (key, val)
                        -> (val == null)
                        ? 1
                        : val + 1);
            }
        }
    }

   // people can vote for a person
    public void vote(People p)
    {
        for (People people : living)
        {
            if (people.equals(p))
            {


                votes.compute(people, (key, val)
                        -> (val == null)
                        ? 0
                        : val + 1);
                break;
            }


        }




    }
    // closes voting and counts the highest vote people and eliminate them
    public  void closeVote()
    {
        ArrayList<People> voted = new ArrayList<>();
        int highest = 0;
        for (Map.Entry<People, Integer> m : votes.entrySet())
        {
            if (highest <m.getValue())
            {
                highest = m.getValue();
            }

        }

        Iterator<Map.Entry<People, Integer>> v = votes.entrySet().iterator();
        while(v.hasNext())
        {
            Map.Entry<People, Integer> map = v.next();
            int mark = map.getValue();
            if (highest == mark)
            {
                voted.add(map.getKey());
            }
        }


//        for (Map.Entry<People, Integer> m : votes.entrySet())
//        {
//            if( m.getValue() == highest)
//            {
//                voted.add(m.getKey());
//            }
//        }

        dead.addAll(voted);
        living.removeAll(voted);

        voted.stream().forEach(x-> votes.remove(x));
//

    }

    // Murder can use to kill a person
    public void kill (String name)
    {

          for (People p : living)
          {
            if (p.getName().equalsIgnoreCase(name))
            {
                dead.add(p);
                votes.remove(p);

            }


          }


          living.removeAll(dead);

    }

    // register people into game
    public void register (People p)
    {

        living.add(p);

    }


    // prints out who is still alive
    public void  printAliveList()
    {
        for (People p : living)
        {
            System.out.printf(p.getName()+ " role: "+p.getRole() +"\n");

        }
    }

    // Prints out who is dead
    public void  printDeadList()
    {
        for (People p : dead)
        {
            System.out.printf(p.getName()+"\n");

        }
    }
    // Prints out voting list
    public String printVotes()
    {
        StringBuilder s = new StringBuilder();
        for (Map.Entry< People, Integer> e :votes.entrySet()) {
            s.append(e.getKey().getName()).append(" votes: ").append(e.getValue());
            s.append(System.getProperty("line.separator"));
        }
        return s.toString();
    }

}
