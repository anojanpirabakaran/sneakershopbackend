# HouseOfKickz-Backend
Dieses README dokumentiert die Schritte, die notwendig sind, um das HouseOfKickz-Backend lokal zum Laufen zu bringen.


# Systemarchitektur
Die Systemarchitektur von HouseofKickz ist eine 3-tier Architekur, die durch drei Ebenen definiert ist: Presentation, Business und Data Access Layer.


# Voraussetzungen
Seien Sie sicher, das Sie JAVA JDK VERSION 11 haben.
Wählen Sie in den "Project Structure" unter "Project SDK" JDK 11.

Sie werden sicher einen Docker Container brauchen. Auf dem Docker Container sollte PostgreSQL auf Port 5432 laufen.
Wenn Sie noch keinen haben, erstellen Sie einen mit diesem Command:
`docker run --name testcontainer -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -d postgres`

Der Benutzername und das Password sind beide "postgres".
Wenn Sie Lust hätten das Password zu ändern, gehen Sie im Projekt unter "application.properties".


# Setup
Clonen Sie dieses Projekt auf ihren Rechner. Öffnen Sie das Projekt mit IntelliJ.
Da Gradle noch nicht heruntergeladen ist, müssen Sie einen Build & Run vornehmen. Drücken Sie im IntelliJ auf das grüne Play Button.
Nun sollte Gradle heruntergeladen sein, und es sollte kein Fehler mehr im Programm auftauchen. Nun öffnen Sie die Gradle Funktionen und wählen Sie hier unter "Tasks/application" die Funktion "bootRun".
Jetzt wird das Backend richtig gestartet. Stellen Sie sicher das der Docker-Container lauft.

Nun müssen Sie eine neue Verbindung anlegen. Drücken Sie oben auf das Kabel und wählen Sie nun PostgreSQL. Nun erscheint ein kleines Fenster und geben Sie dort nun den DB-Username und Passwort ein. Nun sind sie mit dem DBeaver verbunden.
Der Benutername und das Password sind "postgres".

Öffnen Sie Ihren Browser und geben Sie: localhost:8080/client ein.
Nun sollten Sie auf der Seite ein leeres Array sehen --> [ ]


# Probleme
- Container neu starten und schauen ob der Container lauft.
- IntelliJ und Spring Boot neu starten.
- Connection zu DBeaver überprüfen.
- Alle Tabellen in der Datenbank löschen und Backend neu laufen lassen
- Wenn Sie ein JDBC / Hibernate Fehler haben, starten Sie den Docker-Container.
