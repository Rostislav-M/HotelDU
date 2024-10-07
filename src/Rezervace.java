import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Rezervace {

    List<Hoste> seznamHostu = new ArrayList<>();
    Pokoje pokoje;
    LocalDate zacatekRezervace;
    LocalDate konecRezervace;
    String typPobytu;

    public Rezervace(List<Hoste> seznamHostu, Pokoje pokoje, LocalDate zacatekRezervace, LocalDate konecRezervace, String typPobytu) {
        this.seznamHostu = seznamHostu;
        this.pokoje = pokoje;
        this.zacatekRezervace = zacatekRezervace;
        this.konecRezervace = konecRezervace;

        if (typPobytu.equals("pracovní") || typPobytu.equals("rekreační")) {
            this.typPobytu = typPobytu;
        } else {
            throw new IllegalArgumentException("Neplatný typ pobytu, typ pobytu musí být pracovní nebo rekreační");
        }
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

    public String getTypPobytu() {
        return typPobytu;
    }

    public void setTypPobytu(String typPobytu) {
        if (typPobytu.equals("pracovní") || typPobytu.equals("rekreační")){
            this.typPobytu = typPobytu;
        } else {
             throw new IllegalArgumentException("Neplatný typ pobytu, typ pobytu musí být pracovní nebo rekreační");
        }
    }

    public List<Hoste> getSeznamHostu() {
        return seznamHostu;
    }

    public void setSeznamHostu(List<Hoste> seznamHostu) {
        this.seznamHostu = seznamHostu;
    }
}
