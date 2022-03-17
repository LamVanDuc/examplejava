package australiancricket.modul;

public class TournamentIncome extends BookingIncome implements GradeBonus{

    @Override
    public double calculateGradeBonus() {
        double bonus = super.calculateTax(super.getSalary()) * GradeBonusPercent/ 100;
        return bonus;
    }
}
