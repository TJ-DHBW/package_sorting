## TODO

#### Pakete _LuisaT-mgh_

Paket - 24000 Stück - 4 mit explosives.
    als csv gespeichert.


Box - hält Pakete
    als CSV gespeichert.


Palette - hält Boxen
    als CSV gespeichert.


LKW - mit Anhänger - Anhänger hält Paletten
    als CSV gespeichert.

---
#### Paketzentrum _TJ-DHBW_

Paketsortierzentrum - mit zentraler Steuereinheit, Entladezonen, parkzonen, sortieranlage

Zentrale Steuereinheit - mit Eventbus - mit Rollen

---
#### Steuerung des Paketzentrums _TJ-DHBW_

Mitarbeiter - mit Rollen und IDCard

IDCard - verschlüsselter Magnetstreifen - mit Status und Sperrung

Lesegerät - Liest IDCard und PIN

TERMINAL >.<
    über Proxy auf ZS steuern der Sortieranlage. - Proxy mit berechtigungen.

Commands für die Sortieranlage - init, next, shutdown, show statistics, lock, unlock, change searchAlgorithm

---
#### "Arbeitsplätze" des Paketzentrums

Parkzone mit Fahrzeugen - an ZS angeschlossen

Entladezone - an ZS angeschlossen

Zwischenlagerung - zwischen Sortieranlage und Entladung

---
#### Sortieranlage

Sortieranlage: Roboter, Lagerplatz für leere Boxen, Lagerplatz für leere Paletten, Lagerbahnen für Pakete mit Sensoren, Sortierbahnen

Scanner - Sortierbahn wird von Scanner nach exp!os:ve untersucht.


---

## Complete Task

Ein Paket ist charakterisiert durch [i] alphanumerische 6-stellige id aus dem Zeichenpool [a-z, 0-9],[ii]content (L: 25, B: 10, H: 10) mit einer Länge von zufällig gewählten 2500 aus dem Pool [a-z | .| : | - | !],  [iii]  sechsstelliger  zip_code  aus dem Bereich [01067-99998],  [iv]type  aus dem Bereich[NORMAL | EXPRESS | VALUE] und [v]weight aus dem Bereich [1.00 bis 5.00]. Die Verteilung fürtype ist [i] NORMAL: 80%, [ii] EXPRESS: 15% und [iii] VALUE: 5%. Es sind  24.000 Pakete  zuerzeugen und zu mischen (shuffle). Es ist einmalig eine CSV-Datei base_package.csv im Format[id],[content],[zip_code],[type] mit 24.000 Zeilen zu erstellen. In vier ausgewählten Paketen istim content die Zeichenkette  exp!os:ve an einer beliebigen Stelle zu integrieren.Eine  Box  ist charakterisiert durch alphanumerische 5-stellige id aus dem Zeichenpool [a-z, 0-9]und hat eine Kapazität für 40 Pakete. Eine Box hat fünf Ebenen. Eine Ebene hat auf der linken undrechte Seite eine Kapazität für je vier (hintereinander angeordnete) Pakete. Die 24.000 Paketesind sukzessive auf  600 Boxen  zu verteilen. Es ist einmalig eine  CSV-Datei base_box.csv imFormat [box_id],[package_id] mit 600 Zeilen zu erstellen.Eine Palette ist charakterisiert durch eine fortlaufende nummerische id (beginnend bei 1) und hat2x2 Positionen. Jede Position hat eine Kapazität für drei (aufeinandergestapelte) Boxen. Die 600Boxen sind sukzessive auf 50 Paletten zu verteilen. Es ist einmalig eine CSV-Datei base_pallet.csv im Format [pallet_id],[position],[level],[box_id] zu erstellen. Bsplw. bedeutet 1,2,2,23 dassdie Box 23 auf der Palette 1 an der Position 2 und der Ebene 2 gelagert ist.Ein LKW ist charakterisiert durch eine alphanumerische 4-stellige id aus dem Bereich [A-Z,0-9] undhat einen Anhänger. Der Anhänger hat auf der linken und rechten Seite eine Kapazität für je fünf(hintereinander angeordnete) Paletten. Zu Simulationszwecken werden sukzessive fünf LKW mitje 10 Paletten  beladen.   Es   ist   einmalig   eine  CSV-Datei im Format [truck_id],[left | right],[position],[pallet_id] zu erstellen.Das Paketsortierzentrum verfügt über [i] eine zentrale Steuerungseinheit (ZS), [ii] sieben Zonenfür die Entladung von LKW, [iii] eine Parkzone für fünf autonome Fahrzeuge für den Transport vonPaletten sowie [iv] eine Sortieranlage. Die ZS verwaltet den EventBus basierend auf Google Guava.Bezüglich Zugriff und Berechtigungen für die ZS werden die Rollen[i] Supervisor, [ii] Administrator,[iii] Operator und [iv] Data Analyst unterschieden.Supervisor, Administrator, Operator und Data Analyst sind Mitarbeiter. Mitarbeiter ist charakterisiertdurch  [i]  ganzzahlige  id  und  [ii]name. Supervisor hat zusätzlich das boolesche Attribut isSenior.Administrator hat zusätzlich das Attribut profile mit den zulässigen Werten A, B und C.Jedem Mitarbeiter (Employee) ist eine IDCard zugeordnet. Der Mitarbeiter kennt die IDCard, dieIDCard jedoch nicht den Mitarbeiter. Auf einem der IDCard zugeordneten Magnetstreifen (L: 100,B:   1)   wird   die   Zeichenkette   [id];[name];[role];[pin][super   pin]   verschlüsselt   gespeichert.   Für   dieVerschlüsselung stehen die Strategien (Strategy) AES und DES zur Verfügung. In einer zentralenConfiguration – realisiert als Enumeration – wird der angewandte Algorithmus definiert.Das Terminal verfügt über ein Lesegerät für die IDCard. Der Mitarbeiter zieht seine IDCard durchdas Lesegerät und wird danach aufgefordert seine PIN einzugeben. Die IDCard hat die StatusActive,  Locked  und  Invalid  (State).   Initial   hat   die   IDCard   den   Status  Active.   Bei   dreimaligerEingabe einer inkorrekten PIN wechselt die IDCard in den Status  Locked  und die Eingabe der Super-PIN   ist   erforderlich.   Bei   zweimaliger   Eingabe   einer   inkorrekten   SuperPIN   wechselt   dieIDCard in den Status Invalid. Eine IDCard im Status Invalid wird vom Lesegerät abgewiesen undes ist keinerlei Eingabe von PIN/SuperPIN mehr möglich.Über das Terminal mit einem zwischengelagerten Proxy auf die ZS wird die Sortieranlage mit denKommandos (Command) [i]init, [ii]next, [iii]shutdown, [iv]lock, [v]unlock, [vi]show statistics und[vii]  change  search  algorithm   to [bm  |  kmp]  gesteuert. Folgende Berechtigungen  sind  auf   demProxy konfiguriert [i] Supervisor | alle Befehle, [ii] Administrator | shutdown und show statistics, [iii]Operator   |  next  und  show   statistics  und  [iv]Data   Scientist  |  show   statistics.   Die   Kommandoswerden über ein Terminal mit einem TouchPad abgesetzt.Mit init werden die fünf LKW mit je einem Anhänger auf Basis der CSV-Dateien erstellt und in einerWartezone mit fünf Positionen nebeneinander geparkt. Mit  next  fährt der nächste LKW zu einerzufällig ausgewählten Zone für die Entladung. Mit shutdown werden die Sensoren an der Zone fürdie Entladung der LKW deaktiviert sowie die Komponenten bei den Scanner entladen. Mit lock undunlock wird die Sortieranlage ge-/entsperrt. Mit show statistics wird ein Bericht mit den Informa-tionen erstellt (Builder) [i] Aktuelles Datum und Uhrzeit, [ii] Anzahl der aktuell abgefertigten LKW,[iii]  Anzahl der aktuell gescannten Pakete gruppiert nach  type  und  [iv]  Pakete mit gefährlichemGegenstand exp!os:ve. Dieser Bericht wird in eine Textdatei report.txt gespeichert.In einer Parkzone befinden sich fünf autonome Fahrzeuge für den Transport von Paletten von derZone für die Entladung der LKW zum vorgelagerten Roboter der Sortieranlage. Die autonomenFahrzeuge sind über einen EventBus mit der ZS verbunden.Jede  Zone  für   die  Entladung  eines  LKW  ist   mit   einem   Sensor   (Observer)   ausgestattet.   BeiAnkunft eines LKW wird die ZS automatisch informiert. Die ZS sendet ein Event mit der ID derZone an ein zufällig ausgewählte autonomes Fahrzeug.Vor   der  Sortieranlage  existiert   ein  Bereich  für   die  Zwischenlagerung von Paletten.   DieserBereich hat 5 Positionen. Jede Position hat eine Kapazität für maximal zwei aufeinandergestapeltePaletten. Das beauftragte autonome Fahrzeug entlädt vollständig den LKW und transportiert diePaletten zu dem Bereich für die Zwischenlagerung. Nach der Entladung fährt das autonome Fahr-zeug zurück zum Parkplatz in der Parkzone. Nach Ankunft sendet das autonome Fahrzeug einEvent an die ZS, dass der LKW entladen wurde.Die   Sortieranlage   verfügt   über  [i]  einen   vorgelagerten   Roboter,  [ii]  einen   Lagerplatz   für   leereBoxen, [iii] einen Lagerplatz für leere Paletten, [iv] acht Lagerbahnen mit einer Kapazität von je 600Paketen, [v] einen Sensor für die Messung des Füllgrades einer Lagerbahn, [vi] drei Sortierbahnenmit den Zuständigkeiten Normal, Express und Value.Die ZS sendet ein Event an den vorgelagerten Roboter der Sortieranlage. Der Roboter entnimmtsukzessive die Boxen von der Palette, entleert diese und füllt die acht Lagerbahnen sukzessiveauf. Jede Lagerbahn verfügt über einen Sensor (Observer). Ist eine Lagerbahn befüllt, wird vomSensor ein Event an die ZS kommuniziert.Hat die zentrale Steuerungseinheit von allen acht Bahnen ein Event erhalten, sendet die ZS einEvent   für   die   Sortierung   nach   Normal,   Express   und  Value  (Chain of Responsibility)   in   einezuständige Sortierbahn. Im Rahmen der Sortierung werden die Sortierbahnen sukzessive geleert.Jede Sortierbahn verfügt über einen Scanner bezüglich dem verbotenen Gegenstand exp!os:ve.Dem Scanner stehen zwei dynamisch austauschbare Komponenten packageSortingCenter.sortingFacility.sortingLanes.BoyerMoore und RabinKarpzur Verfügung. Mit dem Kommando change search algorithm wird der angewandte Algorithmus füralle eingesetzten einheitlich geändert.