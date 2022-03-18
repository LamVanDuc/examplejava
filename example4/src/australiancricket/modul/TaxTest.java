package australiancricket.modul;

public class TaxTest {
    public static void main(String[] args) {
        Booking.Player player = new Booking.Player("abc123456");
        BookingIncome playerIncome = new BookingIncome(player.getName(), 50000);
        TournamentIncome playerTournament = new TournamentIncome(player.getName(), 10,100);
        playerIncome.calculateTax(playerIncome.getSalary());
        playerTournament.calculateGradeBonus(playerIncome.getIncom());

        playerIncome.displayDetails();
        playerTournament.displayDetails();
        System.out.println("----------------------------------------------------------------");
        System.out.println("total: "+ (playerTournament.getBonus() + playerIncome.getIncom()));

    }
}
