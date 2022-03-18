package part1;

public class TaxMain {
    public static void main(String[] args){
        Taxpayer taxpayer = new Company();
        TaxManager taxManager = new TaxManager();
        System.out.println("Tax Payer: "+taxManager.addTaxpayer(taxpayer));

        System.out.println("Get Tax : "+taxManager.getTax());
    }
}
