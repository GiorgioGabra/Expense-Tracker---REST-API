# Expense-Tracker---REST-API
Un'applicazione backend sviluppata in **Java e Spring Boot** per la gestione e il monitoraggio delle spese personali.  Questo progetto espone delle API REST che permettono di gestire utenti (Clienti) e registrare le loro spese quotidiane, calcolando automaticamente i totali.

Funzionalità Principali

* **Gestione Clienti:** Registrazione di nuovi clienti nel sistema.
* **Gestione Spese:** Associazione di una o più spese a uno specifico cliente (Relazione `@ManyToOne`).
* **Calcolo Automatico:** Endpoint dedicato per calcolare la somma totale delle spese di un singolo cliente tramite una Custom Query JPQL.
* **Cancellazione:** Rimozione sicura delle spese errate dal database.

Tecnologie Utilizzate

* **Linguaggio:** Java 21
* **Framework:** Spring Boot (Spring Web)
* **Database:** MySQL
* **ORM:** Hibernate / Spring Data JPA
* **Build Tool:** Maven
* **Test API:** Thunder Client / Postman
