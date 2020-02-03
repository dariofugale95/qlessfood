package classes;

public class Fattura {

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
