package classes;

public class Fattura {

    private static long IdFattura=0;
    private boolean TipoPagamento;
    private double Totale;

    public Fattura() {
        IdFattura++;
    }

    public Fattura(boolean tipoPagamento, double totale) {
        IdFattura++;
        TipoPagamento = tipoPagamento;
        Totale = totale;
    }

    public long getIdFattura() {
        return IdFattura;
    }

    public void setIdFattura(long idFattura) {
        IdFattura = idFattura;
    }

    public boolean isTipoPagamento() {
        return TipoPagamento;
    }

    public void setTipoPagamento(boolean tipoPagamento) {
        TipoPagamento = tipoPagamento;
    }

    public double getTotale() {
        return Totale;
    }

    public void setTotale(double totale) {
        Totale = totale;
    }

    private Cliente cliente;

    private Ordine ordine;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    public Fattura newFattura(boolean TipoPagamento, double Totale) {
        return null;
    }
}
