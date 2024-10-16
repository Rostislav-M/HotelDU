import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //hotelDU2engeto();

        RezervacniManazer rezervacniManazer = new RezervacniManazer();
        fillBookings(rezervacniManazer); // Naplnění rezervací

        System.out.println("Počet pracovních pobytů: " +rezervacniManazer.getNumberOfWorkingBookings());
        System.out.println("\n" + "Průměrný počet hostů na rezervaci: " +rezervacniManazer.getAverageGuests());
        System.out.println("\n" + "Prvních osm rekreačních rezervací: ");
        List<Rezervace> topHolidayBookings = rezervacniManazer.getTopNHolidayBookings(8);
        for (Rezervace rezervace : topHolidayBookings) {
            System.out.println(rezervace.getFormat());
        }
        System.out.println("\n" + "Statistiky hostů: ");
        rezervacniManazer.printGuestStatistics();
        System.out.println("\n" + "Počet pracovních pobytů: " + rezervacniManazer.getNumberOfWorkingBookings());

        System.out.println(("\n" + "Formátovaný výpis všech rezervací v systému: "));
        for(Rezervace rezervace : rezervacniManazer.getSeznamRezervaci()){
            System.out.println(rezervace.getFormattedSummary());
        }



    }


    public static void fillBookings(RezervacniManazer rezervacniManazer) {
            Host karel = new Host("Karel", "Dvořák", LocalDate.of(1990, 5, 15));
            //Jiný pan Karel Dvořák
            Host jinyKarel = new Host("Karel", "Dvořák", LocalDate.of(1979, 1, 3));
            Host karolina = new Host("Karolína", "Tmavá", LocalDate.of(2000, 11, 3));

            // Vytvoření seznamu hostů
            List<Host> seznamHostu1 = new ArrayList<>();
            seznamHostu1.add(karel);

            List<Host> seznamHostu2 = new ArrayList<>();
            seznamHostu2.add(jinyKarel);

            List<Host> seznamHostu3 = new ArrayList<>();
            seznamHostu3.add(karolina);
            seznamHostu3.add(karel);

            List<Host> seznamHostu4 = new ArrayList<>();
            seznamHostu4.add(karolina);

            // Vytvoření pokojů
            Pokoj pokoj3 = new Pokoj(3, 2, true, false, BigDecimal.valueOf(2400.0));
            Pokoj pokoj2 = new Pokoj(2, 2, true, true, BigDecimal.valueOf(1000.0));

            // Karel Dvořák (1. rezervace)
            Rezervace rezervace1 = new Rezervace(seznamHostu1, pokoj3, LocalDate.of(2023, 6, 1), LocalDate.of(2023, 6, 7), Rezervace.TypPobytu.PRACOVNI);
            rezervacniManazer.addBooking(rezervace1);

            // jiný Karel Dvořák (2. rezervace)
            Rezervace rezervace2 = new Rezervace(seznamHostu2, pokoj2, LocalDate.of(2023, 7, 18), LocalDate.of(2023, 7, 21), Rezervace.TypPobytu.REKREACNI);
            rezervacniManazer.addBooking(rezervace2);

            // Karolína Tmavá (3. rezervace)
            Rezervace rezervace3 = new Rezervace(seznamHostu3, pokoj3, LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 31), Rezervace.TypPobytu.PRACOVNI);
            rezervacniManazer.addBooking(rezervace3);

            // Smyčka pro 10 dvoudenních rezervací pro srpen
            int n=0;
            for(int i=0; i<10; i++) {
                Rezervace r1_r10 = new Rezervace(seznamHostu4, pokoj2,LocalDate.of(2023,8,1+n), LocalDate.of(2023,8,2+n), Rezervace.TypPobytu.REKREACNI);
                n=n+2;
                rezervacniManazer.addBooking(r1_r10);
            }



        }

         /* private static void hotelDU2engeto() {

        //vytvoření hostů
        Host host1 = new Host("Adéla", "Malíková", LocalDate.of(1993, 3, 13));
        Host host2 = new Host("Jan","Dvořáček", LocalDate.of(1995, 5, 5));

        //testhost pak smazat
        Host host3 = new Host("TEST","TEST", LocalDate.of(1995, 5, 5));

        //Změna datumu narození
        host2.setDatumNarozeni(LocalDate.of(1995,4,5));

        //Vypsání hostů
        System.out.println(host1.getJmeno() + " " + host1.getPrijmeni() + " datum narození: "  + host1.getDatumNarozeni().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        System.out.println(host2.getJmeno() + "  " + host2.getPrijmeni() + " datum narození: " + host2.getDatumNarozeni().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));

        //Přidání pokojů
        Pokoj pokoj1 = new Pokoj(1, 1,true, true, BigDecimal.valueOf(1000.0));
        Pokoj pokoj2 = new Pokoj(2, 1,true, true, BigDecimal.valueOf(1000.0));
        Pokoj pokoj3=  new Pokoj(3, 3,true, false, BigDecimal.valueOf(2400.0));

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

        //jen na test pak smazat
        List<Host> seznamHostu3= new ArrayList<>();
        seznamHostu3.add(host3);

        //Přidání rezervace pro Adelu
        //Pridani rezervace pro Adelu a Jana
        Rezervace rezervace1= new Rezervace(seznamHostu1,pokoj1, LocalDate.of(2021, 7,19), LocalDate.of(2021, 7,26), Rezervace.TypPobytu.REKREACNI);
        Rezervace rezervace2 = new Rezervace(seznamHostu2,pokoj3, LocalDate.of(2021, 9, 1), LocalDate.of(2021, 9 , 14), Rezervace.TypPobytu.PRACOVNI);

        Rezervace rezervace3= new Rezervace(seznamHostu1,pokoj1, LocalDate.of(2021, 7,19), LocalDate.of(2021, 7,26), Rezervace.TypPobytu.REKREACNI);
        Rezervace rezervace4= new Rezervace(seznamHostu1,pokoj1, LocalDate.of(2021, 7,19), LocalDate.of(2021, 7,26), Rezervace.TypPobytu.REKREACNI);
        Rezervace rezervace5= new Rezervace(seznamHostu1,pokoj1, LocalDate.of(2021, 7,19), LocalDate.of(2021, 7,26), Rezervace.TypPobytu.REKREACNI);
        Rezervace rezervace6= new Rezervace(seznamHostu1,pokoj1, LocalDate.of(2021, 7,19), LocalDate.of(2021, 7,26), Rezervace.TypPobytu.REKREACNI);
        Rezervace rezervace7= new Rezervace(seznamHostu1,pokoj1, LocalDate.of(2021, 7,19), LocalDate.of(2021, 7,26), Rezervace.TypPobytu.REKREACNI);
        Rezervace rezervace8= new Rezervace(seznamHostu1,pokoj1, LocalDate.of(2021, 7,19), LocalDate.of(2021, 7,26), Rezervace.TypPobytu.REKREACNI);
        Rezervace rezervace9= new Rezervace(seznamHostu1,pokoj1, LocalDate.of(2021, 7,19), LocalDate.of(2021, 7,26), Rezervace.TypPobytu.REKREACNI);
        Rezervace rezervace10= new Rezervace(seznamHostu3,pokoj1, LocalDate.of(2021, 7,19), LocalDate.of(2021, 7,26), Rezervace.TypPobytu.REKREACNI);

        //Vytvoření správce rezervací
        RezervacniManazer rezervacniManazer = new RezervacniManazer();

        //Přidání rezervací do správce
        rezervacniManazer.addBooking(rezervace1);
        rezervacniManazer.addBooking(rezervace2);
        rezervacniManazer.addBooking(rezervace3);
        rezervacniManazer.addBooking(rezervace4);
        rezervacniManazer.addBooking(rezervace5);
        rezervacniManazer.addBooking(rezervace6);
        rezervacniManazer.addBooking(rezervace7);
        rezervacniManazer.addBooking(rezervace8);
        rezervacniManazer.addBooking(rezervace9);
        rezervacniManazer.addBooking(rezervace10);

        //Vypsaní všech rezevací
        rezervacniManazer.vypsaniInformaceOvsechRezervacich();

        System.out.println();
        System.out.println("**********************************");
        System.out.println(rezervacniManazer.getAverageGuests());

        System.out.println();
        System.out.println("**********************************");
        System.out.println(rezervacniManazer.getTopNHolidayBookings(8));


   }*/


}