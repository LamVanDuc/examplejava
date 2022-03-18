package australiancricket.modul;

public class TournamentIncome extends Booking implements GradeBonus{

    private String name;
    private int grade;
    private int rade;
    private double bonus;


    public TournamentIncome(){}
    public TournamentIncome(String name, int grade , int rade){
        this.name = name;
        this.grade = grade;
        this.rade = rade ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getRade() {
        return rade;
    }

    public void setRade(int rade) {
        this.rade = rade;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double calculateGradeBonus(double income) {
        bonus = (income /100)* GradeBonusPercent;
        return bonus;
    }

    @Override
    public void displayDetails() {

        System.out.println("      Bonus: " + bonus);
        System.out.println("      Grade: "+grade);
        System.out.println("       rade: "+rade);

    }



}
