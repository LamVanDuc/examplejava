package australiancricket.modul;

public abstract class Booking {


    public static class Player{
        //
        public String namePlayer;
        //constructor
        public Player(){}

        public Player(String namePlayer){
            this.namePlayer = namePlayer;
        }

        //setter and getter
        public void setName(String name){
            this.namePlayer = name;
        }public String getName(){
            return this.namePlayer;
        }
    }
    // display method
    public abstract void displayDetails();
}


