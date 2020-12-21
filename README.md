# OPENWEATHER: Servizio Metereologico

### Descrizione
Il progetto relizzato è un serivizio metereologico sulle 10 città Americane più importanti:
* San Francisco
* Las Vegas
* Seattle
* Los Angeles 
* Miami
* New York
* Chicago
* New Orleans
* Boston
* Washington

La sua funzionalità è quella di riportare dati riguardanti temperature e umidità attuali di una singola città o di tutte le città sopra elencate.

Inoltre si ha la possibiltà di restituire statistiche periodiche settimanali oppure personalizzabili.
> **Nota**: il range personalizzabile rientra nell'arco dei sette giorni.

#### Specifiche
Il progetto si basa sul concetto di Web Service, ovvero la possbilità tramite un client (es. Postman) di acquisire i dati richiesti attraverso un protocollo di comunicazione HTTP; 
Questo tramite l'applicativo SpringBoot, un progetto del freamwork Spring, che consente tramite l'appoggio server di Tomcat di generare un'host locale (di default *localHost:8080*).

Per l'acquisizione dei dati di cui necessitavamo riguardanti le temperature e le umidità, abbiamo sfruttato le API OpenWeather (`api.openweathermap.org/data/2.5/weather?id={city id}&appid={API key}`) che mettevano a disposizione i valori giornalieri aggiornati.

Il Data-Set è rappresentato da un file formato Json, nella quale sono state salvate le informazioni relative ai giorni passati. Inoltre tramite una funzionalità di autosalvataggio, il file verrà caricato nuovamente di specifiche aggiornate ogni 2 ore.
> **Nota**: i dati sono stati necessareiamente salvati per mancanza di API che restituissero informazioni passate.

## Request 

La seguente tabella rappresenta le possibili chiamate GET o POST che è possibile richiamare tramite un API testing:

|    TIPO        |ROTTA                          |DESCRIZIONE                                |
|----------------|-------------------------------|-------------------------------------------|
|GET             |/metadati                      |restituisce i dati di tutte le città in esame al tempo attuale       |
|GET             |/citta?city="nome"             |restituisce temperature e umidità di una singola città richiesta tramite un parametro   |
|POST            |/stats?body     |restituisce una statistica su temperature e umidita (minime e massime) in un periodo specificato, rispettando i filtri nel body della richiesta |

In particolare le funzioni filtro possibili sono:

|   BODY         |TIPO DI DATO                   |FUNZIONAMENTO                              |
|----------------|-------------------------------|-------------------------------------------|
|hum             |Boolean                        |parametro per la richiesta dell'umidità    |
|temp            |Boolean                        |parametro per la richiesta della temperatura |
|period          |Intger                         |intervallo di tempo della statistica       |

### Controlli
* **Controllo GET** `http://localhost:8080/metadati`: esegue la chimata al metodo **Rest_allCities**, il quale avvierà il metodo `Download_allCities` contenuto nella classe **API_allCities**, consentendo il download delle info da API e la successiva restituzione elaborata.
* **Controllo GET** `http://localhost:8080/citta?city="nome"`:
* **Controllo POST** `http://localhost:8080/stats`:
## Software

* [Eclipse](https://www.eclipse.org/) - ambiente di sviluppo integrato
* [Spring Boot](https://spring.io/projects/spring-boot) - framework per  sviluppo applicazioni Java
* [Maven](https://maven.apache.org/) - strumento di gestione di progetti

## Autori

* **Mazzi Andrè** - [GitHub](https://github.com/Mazzi-Andre)
* **Mariotti Manuel** - [GitHub](https://github.com/Manuel-Mariotti)
