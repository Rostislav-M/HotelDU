import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //vytvoření hostů
        Host host1 = new Host("Adéla", "Malíková", LocalDate.of(1993, 3, 13));
        Host host2 = new Host("Jan","Dvořáček", LocalDate.of(1995, 5, 5));

        //Změna datumu narození
        host2.setDatumNarozeni(LocalDate.of(1995,4,5));

        //Vypsání hostů
        System.out.println(host1.getJmeno() + " " + host1.getPrijmeni() + " datum narození: "  + host1.getDatumNarozeni().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        System.out.println(host2.getJmeno() + "  " + host2.getPrijmeni() + " datum narození: " + host2.getDatumNarozeni().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));

        //Přidání pokojů
        Pokoj pokoj1 = new Pokoj(1, 1,true, true, 1000.0);
        Pokoj pokoj2 = new Pokoj(2, 1,true, true, 1000.0);
        Pokoj pokoj3=  new Pokoj(3, 3,true, false, 2400.0);

        //Vypsání pokojů
        System.out.println("Vypsání pokojů: ");
        System.out.print("Pokoj číslo: " + pokoj1.getCisloPokoje() + " " +  "Má balkon: " + (pokoj1.jeBalkon() ? "ano" : "ne") +  ", " + "Má výhled na moře: " + (pokoj1.jeVyhledNaMore() ? "ano" : "ne") + ", cena pokoje:  " + pokoj1.getCenaPokoje() +"\n");
        System.out.print("Pokoj číslo: " + pokoj2.getCisloPokoje() + " " +  "Má balkon: " + (pokoj2.jeBalkon() ? "ano" : "ne") +  ", " + "Má výhled na moře: " + (pokoj2.jeVyhledNaMore() ? "ano" : "ne") + ", cena pokoje:  " + pokoj2.getCenaPokoje() +"\n");
        System.out.print("Pokoj číslo: " + pokoj3.getCisloPokoje() + " " +  "Má balkon: " + (pokoj3.jeBalkon() ? "ano" : "ne") +  ", " + "Má výhled na moře: " + (pokoj3.jeVyhledNaMore() ? "ano" : "ne") + ", cena pokoje:  " + pokoj3.getCenaPokoje() +"\n" +"\n");

        // Vytvoření seznamu hostů a přidání hostů do seznamu
        List<Host> seznamHostu1 = new ArrayList<>();
        seznamHostu1.add(host1);
        List<Host> seznamHostu2 = new ArrayList<>();
        seznamHostu2.add(host1);
        seznamHostu2.add(host2);

        //Přidání rezervace pro Adelu
        //Pridani rezervace pro Adelu a Jana
        Rezervace rezervace1= new Rezervace(seznamHostu1,pokoj1, LocalDate.of(2021, 7,19), LocalDate.of(2021, 7,26), Rezervace.TypPobytu.REKREACNI);
        Rezervace rezervace2 = new Rezervace(seznamHostu2,pokoj3, LocalDate.of(2021, 9, 1), LocalDate.of(2021, 9 , 14), Rezervace.TypPobytu.PRACOVNI);

        //Vytvoření správce rezervací
        RezervacniManazer rezervacniManazer = new RezervacniManazer();

        //Přidání rezervací do správce
        rezervacniManazer.pridaniRezervace(rezervace1);
        rezervacniManazer.pridaniRezervace(rezervace2);

        //Vypsaní všech rezevací
        rezervacniManazer.vypsaniInformaceOvsechRezervacich();





    }

}