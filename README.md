# OPENWEATHER: Java Project

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
Questo tramite l'applicativo SpringBoot, un progetto del freamwork Spring, che consente tramite l'appoggio server di Tomcat di generare un'host locale (di default *localHost:8080* ).

Per l'acquisizione dei dati di cui necessitavamo riguardanti le temperature e le umidità, abbiamo sfruttato le API OpenWeather( `api.openweathermap.org/data/2.5/weather?id={city id}&appid={API key}` ) che mettevano a disposizione i valori giornalieri aggiornati.

Il Data-Set è rappresenztato da un file formato Json