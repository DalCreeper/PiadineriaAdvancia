# PiadineriaAdvancia
Progetto di esercitazione sullo sviluppo di web app

Un venditore di piadine ha richiesto la creazione di un sito in cui i propri dipendenti possano realizzare le piadine che comporranno le opzioni per i clienti partendo da un insieme di ingredienti predefiniti.

---

## Modello Piadina

Ogni piadina sarà composta da:
- **Una tipologia di impasto** (es. classica, senza glutine, integrale…)
- **Zero o più condimenti** (maionese, ketchup, philadelphia…)
- **Zero o più ingredienti aggiuntivi** (insalata, pomodoro…)
- **Una o più tipologie di carne** (pollo, maiale, manzo, prosciutto…)

---

## Struttura Web Application

Il sito dovrà essere accessibile previo login con una username/password. L’applicazione sarà composta da almeno due pagine:
1. **Pagina di Login**.
2. **Pagina Principale** in cui si potrà interagire con l’applicativo.

---

### Struttura Login

- **Form** per inserire username/password.
- **Bottone** per eseguire l’accesso.
- **Messaggi di errore** per credenziali errate.
- **Gestione sessioni**:
  - Accesso alla home senza login reindirizza automaticamente alla pagina di login.
  - Login già eseguito reindirizza automaticamente alla home senza richiedere un nuovo login.

---

### Struttura Homepage

Dopo l’autenticazione, si accederà alla **homepage** che fornirà:
1. **Prospetto del menu attualmente presente**.
2. **Form** per la selezione degli elementi che comporranno una piadina e il suo inserimento nel menu.

---

#### Prospetto Menu

Per ogni piadina saranno mostrate:
- Nome assegnato alla piadina.
- Impasto utilizzato.
- Base di carne utilizzata.
- Condimenti utilizzati.
- Elementi opzionali aggiunti.
- Prezzo.
- Impiegato che ha inserito la piadina.

> Sarà presente un tasto per rimuovere la piadina dal menu.

---

#### Form Aggiunta Piadina

Il form permetterà:
- Inserire un **nome** per la piadina.
- **Selezionare gli elementi** tramite elenchi a tendina.
- **Descrizione breve, quantità e prezzo** per ogni ingrediente.

> Il prezzo finale sarà calcolato sommando il costo degli ingredienti. Ogni ingrediente potrà essere inserito una sola volta e la quantità non sarà modificabile rispetto al valore standard.

---

## Steps Progetto

Lo sviluppo sarà suddiviso in fasi. Al termine di ogni fase, il progetto sarà condiviso tramite GitHub per revisioni e test.

### **Step 1**
- Implementazione della login.
- Meccanismo di redirezione automatica.
- Creazione di credenziali hard-coded (senza database).

---

### **Step 2**
- Collegamento della web application a un database Oracle tramite JDBC.
- Creazione di un insieme di utenze nel database.

---

### **Step 3**
- Realizzazione della homepage.
- Uso di JDBC e database Oracle per la persistenza dei dati.

---

### **Step 4**
- Migrazione del meccanismo di persistenza da JDBC a **Hibernate ORM**.

---

### **Step 5**
- Migrazione del meccanismo di persistenza da Hibernate ORM a **JPA + Hibernate**.

---

### **Step 6**
- Implementazione di interfacce REST per:
  - CRUD sugli elementi per comporre una piadina.
  - CRUD sulle credenziali degli utenti.

---

### **Step 7**
- Implementazione di interfacce SOAP per:
  - CRUD sugli elementi per comporre una piadina.
  - CRUD sulle credenziali degli utenti.
  - Ottenere il menu.

---

### **Step 8**
- Realizzazione di un secondo applicativo locale con **Spring Batch** per:
  - Interfacciarsi con l’interfaccia SOAP del servizio.
  - Stampare un PDF del menu.

---

## Linee Guida Generali

- **Pagine di presentazione**: realizzate con JSP, con possibilità di usare Javascript, Ajax, CSS, Bootstrap.
- **Repository GitHub**: il progetto sarà mantenuto su un repository GitHub.
- **Architettura MVC**: per organizzare il codice.

---
