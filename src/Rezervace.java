import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Rezervace {

    private List<Host> seznamHostu = new ArrayList<>();
    private Pokoj pokoj;
    private LocalDate zacatekRezervace;
    private LocalDate konecRezervace;
    private TypPobytu typPobytu;

    public enum TypPobytu {
        PRACOVNI,
        REKREACNI
    }

    public Rezervace(List<Host> seznamHostu, Pokoj pokoj, LocalDate zacatekRezervace, LocalDate konecRezervace, TypPobytu typPobytu) {
        if (seznamHostu== null || seznamHostu.isEmpty())  {
            throw new IllegalArgumentException("U rezervace musí být registrovaný minimálně jeden host");
        }

        this.seznamHostu = seznamHostu;
        this.pokoj = pokoj;
        this.zacatekRezervace = zacatekRezervace;
        this.konecRezervace = konecRezervace;
        this.typPobytu = typPobytu;

    }

      public Pokoj getPokoje() {
        return pokoj;
    }

    public void setPokoje(Pokoj pokoj) {
        this.pokoj = pokoj;
    }

    public LocalDate getZacatekRezervace() {
        return zacatekRezervace;
    }

    public void setZacatekRezervace(LocalDate zacatekRezervace) {
        this.zacatekRezervace = zacatekRezervace;
    }

    public LocalDate getKonecRezervace() {
        return konecRezervace;
    }

    public void setKonecRezervace(LocalDate konecRezervace) {
        this.konecRezervace = konecRezervace;
    }

    public TypPobytu getTypPobytu() {
        return typPobytu;
    }

    public void setTypPobytu(TypPobytu typPobytu) {
        this.typPobytu = typPobytu;
    }

    public List<Host> getSeznamHostu() {
        return seznamHostu;
    }

    public void setSeznamHostu(List<Host> seznamHostu) {
        if (seznamHostu == null || seznamHostu.isEmpty()) {
            throw new IllegalArgumentException("Seznam hostů nesmí být null nebo prázdný");
        }
        this.seznamHostu = seznamHostu;
    }
}
