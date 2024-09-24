public class People
{

    private  String role;
    private  boolean isAlive;
    private String name;

     public People (String n, String r, Boolean alive )
     {
         setName(n);
         setAlive(alive);
         setRole(r);

     }

    public boolean isAlive() {
        return isAlive;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String get_status (){
         return (isAlive()) ? "is alive" : "is dead" ;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
