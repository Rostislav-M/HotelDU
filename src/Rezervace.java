import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Rezervace {

    private List<Hoste> seznamHostu = new ArrayList<>();
    private Pokoje pokoje;
    private LocalDate zacatekRezervace;
    private LocalDate konecRezervace;
    private TypPobytu typPobytu;

    public enum TypPobytu {
        PRACOVNI,
        REKREACNI
    }

    public Rezervace(List<Hoste> seznamHostu, Pokoje pokoje, LocalDate zacatekRezervace, LocalDate konecRezervace, TypPobytu typPobytu) {
        if (seznamHostu== null || seznamHostu.isEmpty())  {
            throw new IllegalArgumentException("U rezervace musí být registrovaný minimálně jeden host");
        }

        this.seznamHostu = seznamHostu;
        this.pokoje = pokoje;
        this.zacatekRezervace = zacatekRezervace;
        this.konecRezervace = konecRezervace;
        this.typPobytu = typPobytu;

    }

      public Pokoje getPokoje() {
        return pokoje;
    }

    public void setPokoje(Pokoje pokoje) {
        this.pokoje = pokoje;
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

    public List<Hoste> getSeznamHostu() {
        return seznamHostu;
    }

    public void setSeznamHostu(List<Hoste> seznamHostu) {
        this.seznamHostu = seznamHostu;
    }
}
