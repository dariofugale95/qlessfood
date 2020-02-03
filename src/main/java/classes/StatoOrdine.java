package classes;

public abstract class StatoOrdine {

    protected Ordine ordine;

    private static final int NUOVO = 0;

    private static int IN_PREPARAZIONE = 1;

    private static final int PRONTO = 2;

    private static final int PAGATO = 3;

    public abstract void gestioneStatoOrdine();

}
