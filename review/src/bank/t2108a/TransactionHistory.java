package bank.t2108a;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TransactionHistory {

    private long id ;
    private LocalDate dayTranding;
    private String description;
    private String beneficiaryAccount;
    private long money;

    public TransactionHistory( String description, String beneficiaryAccount, long money) {
        this.id = idGennerate.getNewID();
        this.dayTranding = LocalDate.now();
        this.description = description;
        this.beneficiaryAccount = beneficiaryAccount;
        this.money = money;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDayTranding() {
        return dayTranding;
    }

    public void setDayTranding(LocalDate dayTranding) {
        this.dayTranding = dayTranding;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBeneficiaryAccount() {
        return beneficiaryAccount;
    }

    public void setBeneficiaryAccount(String beneficiaryAccount) {
        this.beneficiaryAccount = beneficiaryAccount;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }



    public String toString(){
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return id + " - "+ dayTranding.format(myFormat)+ " - "+ description +" - "+ Controller.formatMoney(money)+" - "+beneficiaryAccount+"\n";
    }
}
