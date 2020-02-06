# qlessfood
Progetto di Ingegneria del Software


## 1) Inserire un nuovo menu:
```bash
Selezionare "1" => Admin Access
Selezionare "1" => Gestione Menu
Selezionare "1" => Inserisci un Nuovo Menu
Selezionare "0|1" => Tipologia (pranzo o cena) del menu
Inserire la data nel formato indicato [dd/mm/yyyy]
Inserire il prezzo per il menu (solo numero)
Inserire fino a 3° portata di frutta una descrizione della portata (esempio: pasta al sugo)
```

## 2) Inserire un nuovo token sconto:
```bash
Selezionare "1" => Admin Access
Selezionare "2" => Gestione Token-Sconto
Inserire il nome del Token (esempio 10, int)
Inserire il numero di pasti (esempio 10, int)
Confermare digitando "y"
```
## 3) Registrazione cliente 
```bash
Selezionare "2" => Cliente Access
Selezionare "2" => Register 
Inserire i dati del cliente (username, email e password)
```

## 4) Prenotazione
```bash
Selezionare "2" => Client Access
Selezionare "1" => Login
Immettere i dati del cliente appena registrato
Selezionare "1" => "prenotazione di un pasto da effetti mense
Inserire la data del pasto nel formato [dd/mm/yyyy]
Inserire la tipologia 

A questo punto il sistema mostra tutte le portate disponibili per quel menu
inserire gli id di 6 portate, una per ogni tipo di pasto.

Seleziona fascia oraria nel formato [dd/mm/yyyy] => ATTENZIONE è un BUG DA CORREGGERE. 
Selezionare il tipo del pagamento 
Confermare
```




