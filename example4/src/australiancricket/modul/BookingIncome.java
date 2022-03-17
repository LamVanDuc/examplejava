package australiancricket.modul;

public class BookingIncome extends Booking implements Tax{

    private double salary;
    private double incom;
     Booking book = new Booking();
     Booking.Player player = new Player();

    public BookingIncome(){
    }
    public BookingIncome(String name,double salary){

        this.salary = salary;
        this.player.displayDetails(name);

    }

    @Override
    public double calculateTax(double salary)
        {
            double calculateTax  = (salary * taxPercent) /100;
            return calculateTax;
        }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getIncom() {
        return incom;
    }

    public void setIncom(double incom) {
        this.incom = incom;
    }

    public Booking getBook() {
        return book;
    }

    public void setBook(Booking book) {
        this.book = book;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
