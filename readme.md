# Spring Boot Final

Je hebt bij de vorige opdracht 4 CRUD endpoints aangemaakt Nu gaan we dit soort endpoints gebruiken met een oefen-database van een dierenwinkel.

In de src>main>resources vind je een .sql file. Open deze met MySQL workbench en voer deze uit om een oefen-database aan te maken.

Vervolgens is het ook belangrijk dat je de application.properties file aanvult met informatie over jouw MySQL connectie - de URL, username en password.

Je zal zien dat deze applicatie al deels functioneel is - het kan de pets al uit de database plukken. Speel zelf even rond met de Swagger documentatie en bekijk de classes die gebruikt worden.

## Opdracht

De dierenwinkel bewaart ook informatie over de eigenaren van de dieren. Deze informatie is te vinden in de tabel customers. Maak voor deze tabel CRUD endpoints aan.

Let op - als je een nieuwe klant aanmaakt moet je naast de naam ook een username/password doorgeven. Wanneer je data van een klant opvraagt moet het password natuurlijk niet meegegeven worden!

Zorg er ook voor dat de huisdieren naast de naam ook hun eigenaar en soort als informatie meegeven.

Zorg ook dat alle http status codes correct worden teruggegeven!