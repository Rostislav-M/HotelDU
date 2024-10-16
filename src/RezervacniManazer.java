import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RezervacniManazer {

    private List<Rezervace> seznamRezervaci = new ArrayList<>();
    //Získání rezervace se zadaným indexe
    public Rezervace getBooking(int index){ //
        return seznamRezervaci.get(index);

    }
    //Získání seznamu rezervací: getBookings()
    public List<Rezervace> getSeznamRezervaci() {
        return seznamRezervaci;
    }

    //Vymazání seznamu rezervací: clearBookings()
    public void clearBookings() {
        seznamRezervaci.clear();
    }

    //Vložení nové rezervace do seznamu
    public void addBooking(Rezervace rezervace) {
       seznamRezervaci.add(rezervace);

    }
    public void vypsaniInformaceOvsechRezervacich() {
        System.out.println("Vypsání všech rezervací: ");
        for (Rezervace rezervace : seznamRezervaci) {
            System.out.println("Hosté: " + rezervace.getSeznamHostu() + " " + " pokoj číslo: " + rezervace.getPokoje().getCisloPokoje() + ", Informace o pokoji: " + "Počet lůžek: " + rezervace.getPokoje().getPocetLuzek()+ ", Má balkon: " + (rezervace.getPokoje().jeBalkon() ? "ano" : "ne") +", Má výhled na moře: "+ (rezervace.getPokoje().jeVyhledNaMore() ? "ano" : "ne") + ", Cena pokoje: " + rezervace.getPokoje().getCenaPokoje()+", " + "Pobyt od:  " + rezervace.getZacatekRezervace().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + ", " + "do: " + rezervace.getKonecRezervace().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + " " + "Typ pobytu: " +rezervace.getTypPobytu());
        }
    }
    // Získání počtu pracovních rezervací
    public int getNumberOfWorkingBookings() {
        int i=0;
        for (Rezervace rezervace : seznamRezervaci) {

        if(rezervace.getTypPobytu()==Rezervace.TypPobytu.PRACOVNI){
                i++;
            }
        }
        return i;
    }
    //  Průměrný počet hostů na rezervaci
    public double getAverageGuests() {   //
        double pocetrezervací=0;
        double soucet=0;
        for (Rezervace rezervace : seznamRezervaci) {
            pocetrezervací++;
            soucet+=rezervace.getGuestsCount();
        }
        return soucet/pocetrezervací;
    }

    //Vrať prvních n rekreačních rezervací
    public List<Rezervace> getTopNHolidayBookings(int n){
     List<Rezervace> list = new ArrayList<>();
     int pocetRekreacnich=0;

        for (Rezervace rezervace : seznamRezervaci) {
            if(rezervace.getTypPobytu()==Rezervace.TypPobytu.REKREACNI && pocetRekreacnich<n){
                pocetRekreacnich++;
                list.add(rezervace);
            }
            }

        return list;
    }

    //  Ve třídě BookingManager připrav metodu printGuestStatistics, která vypíše:
    //  celkový počet rezervací sjedním hostem,
    //  celkový počet rezervací se dvěma hosty,
    //  a celkový počet rezervací svíce než dvěma hosty.
    public void printGuestStatistics(){  //// Výpis statistik hostů
        int jedenHost=0;
        int dvaHoste=0;
        int viceNezDvaHoste=0;
        for (Rezervace rezervace : seznamRezervaci) {
            if(rezervace.getGuestsCount()==1){
                jedenHost++;
            }
            if(rezervace.getGuestsCount()==2){
                dvaHoste++;
            }
            if(rezervace.getGuestsCount()>2){
                viceNezDvaHoste++;
            }

        }
        System.out.println("Počet rezervací s jedním hostem: " + jedenHost);
        System.out.println("Počet rezervací s dvěma hosty: " + dvaHoste);
        System.out.println("Počet rezervací s více hosty: " + viceNezDvaHoste);
    }







}







