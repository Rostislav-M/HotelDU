import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RezervacniManazer {

    private List<Rezervace> seznamRezervaci = new ArrayList<>();

    public void pridaniRezervace(Rezervace rezervace) {
       seznamRezervaci.add(rezervace);

    }
    public void vypsaniInformaceOvsechRezervacich() {
        System.out.println("Vypsání všech rezervací: ");
        for (Rezervace rezervace : seznamRezervaci) {
            System.out.println("Hosté: " + rezervace.getSeznamHostu().toString() + " " + " pokoj číslo: " + rezervace.getPokoje().getCisloPokoje() + ", Informace o pokoji: " + "Počet lůžek: " + rezervace.getPokoje().getPocetLuzek()+ ", Má balkon: " + (rezervace.getPokoje().jeBalkon() ? "ano" : "ne") +", Má výhled na moře: "+ (rezervace.getPokoje().jeVyhledNaMore() ? "ano" : "ne") + ", Cena pokoje: " + rezervace.getPokoje().getCenaPokoje()+", " + "Pobyt od:  " + rezervace.getZacatekRezervace().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + ", " + "do: " + rezervace.getKonecRezervace().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + " " + "Typ pobytu: " +rezervace.getTypPobytu());
        }
    }




}







