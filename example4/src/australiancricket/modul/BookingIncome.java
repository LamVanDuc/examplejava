package australiancricket.modul;

public class BookingIncome extends Booking implements Tax{

    private double salary = 0;
    private String name;
    private double incom = 0;
    private double tax  = 0;

    public BookingIncome(){
    }
    public BookingIncome(String name,double salary){
        this.name = name;
        this.salary = salary;

    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
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


    @Override
    public double calculateTax(double salary)
    {
        tax = (salary / 100) *10;
        incom = salary - tax;
        return tax;
    }

    @Override
    public void displayDetails(){
//        calculateTax(getSalary());


        System.out.println("Name player: "+getName());
        System.out.println("     Salary: "+getSalary());
        System.out.println("        Tax: "+ tax);
        System.out.println("     income: " + incom);

    }
}
