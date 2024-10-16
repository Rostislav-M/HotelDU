import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Rezervace {
    private Host host;
    private List<Host> seznamHostu = new ArrayList<>();
    private Pokoj pokoj;
    private LocalDate zacatekRezervace;
    private LocalDate konecRezervace;
    private TypPobytu typPobytu;

    public enum TypPobytu {
        PRACOVNI,
        REKREACNI
    }

   public Host getHost (){
       return host;

  }


    public Rezervace(List<Host> seznamHostu, Pokoj pokoj, LocalDate zacatekRezervace, LocalDate konecRezervace, TypPobytu typPobytu) {
        if (seznamHostu== null || seznamHostu.isEmpty())  {
            throw new IllegalArgumentException("U rezervace musí být registrovaný minimálně jeden host");
        }

        this.seznamHostu = seznamHostu;
        this.host = seznamHostu.get(0);
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

    public int getGuestsCount(){
        int pocetHostu=0;
        for(Host host : seznamHostu){
            pocetHostu++;
        }
        return pocetHostu;
    }


    public void setSeznamHostu(List<Host> seznamHostu) {
        if (seznamHostu == null || seznamHostu.isEmpty()) {
            throw new IllegalArgumentException("Seznam hostů nesmí být null nebo prázdný");
        }
        this.seznamHostu = seznamHostu;
    }
    public int getBookingLength(){
        return zacatekRezervace.until(konecRezervace).getDays();
    }
    //Cena rezervace
    public BigDecimal getTotalPrice(){
        BigDecimal totalPrice;
        return totalPrice= pokoj.getCenaPokoje().multiply(BigDecimal.valueOf(getBookingLength()));
    }

    public String getFormat(){
        String format = "Rezervace pro:"+getHost().getJmeno() + " " + getHost().getPrijmeni() + " ("
                        + getHost().getDatumNarozeni() + "), " +" na: " + pokoj.getCisloPokoje() +
                         ", termín " + " " + getZacatekRezervace() + " -" + " " + getKonecRezervace() +
                        ", pracovní pobyt: " + (getTypPobytu().equals(TypPobytu.PRACOVNI) ?  "ano" : "ne");
        return format;
    }

    public String getFormattedSummary() {
      String format = getZacatekRezervace() + " až " + getKonecRezervace() + ": "
                    + getHost().getJmeno() + " " + getHost().getPrijmeni() + " ("
                    + getHost().getDatumNarozeni() + ")"
                    +"[" +getGuestsCount()+ ", " + (pokoj.jeVyhledNaMore() ? "ano" : "ne")
                     + "]" + " za " + getTotalPrice();

        return format;


    }

}
