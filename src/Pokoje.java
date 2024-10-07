public class Pokoje {

    private int cisloPokoje;
    private int pocetLuzek;
    private boolean jeVyhledNaMore;
    private boolean jeBalkon;
    private double cenaPokoje;

    public Pokoje(int cisloPokoje,int pocetLuzek, boolean jeVyhledNaMore, boolean jeBalkon, double cenaPokoje) {
        this.cisloPokoje = cisloPokoje;
        this.pocetLuzek = pocetLuzek;
        this.jeVyhledNaMore = jeVyhledNaMore;
        this.jeBalkon = jeBalkon;
        this.cenaPokoje = cenaPokoje;
    }

    public int getPocetLuzek() {
        return pocetLuzek;
    }

    public void setPocetLuzek(int pocetLuzek) {
        this.pocetLuzek = pocetLuzek;
    }

    public int getCisloPokoje() {
        return cisloPokoje;
    }

    public void setCisloPokoje(int cisloPokoje) {
        this.cisloPokoje = cisloPokoje;
    }

    public boolean jeVyhledNaMore() {
        return jeVyhledNaMore;
    }

    public void setJeVyhledNaMore(boolean jeVyhledNaMore) {
        this.jeVyhledNaMore = jeVyhledNaMore;
    }

    public boolean jeBalkon() {
        return jeBalkon;
    }

    public void setJeBalkon(boolean jeBalkon) {
        this.jeBalkon = jeBalkon;
    }

    public double getCenaPokoje() {
        return cenaPokoje;
    }

    public void setCenaPokoje(double cenaPokoje) {
        this.cenaPokoje = cenaPokoje;
    }
}
