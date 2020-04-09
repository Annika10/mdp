# MDP Programm

# Grobes Vorgehen 

1. Excel ausfüllen 

2. Im Java Programm die oberste Zeilen ausfüllen und Programm ausführen

3. In TexMaker die Outputdatei kompilieren

# Detailliertes Vorgehen

## Excel ausfüllen:

Wichtig: Die Excel Tabellen müssen sich unter dem Namen "MDPLeiterrundeTransponiert" und "MDPMessdienerTransponiert" im Ordner "C:\Users\annik\Documents\mdp" befinden und als ".csv" gespeichert sein!
Falls das geändert werden soll in der Methode "fill" die Dateipfade im BufferedReader ändern!

### Aufbau der Excel Tabelle

Die 1. Zeile der Excel beinhaltet den vollständigen Namen der Messdiener.
Diese werden für das Programm benötigt.
In der 2. und 3. Zeile sind die Namen noch mal nach Vor- und Nachnamen getrennt, um eine bessere Übersicht für die auszufüllende Person zu bekommen. 
In der 4. Zeile ist das Jahr angegeben, in dem die Person Messdiener wurde. 
Diese Angabe ist ebenfalls nur für den Benutzer der Excel nötig.
Die 4. Zeile enthält ebenfalls die Überschriften für die 1. Spalten. 
Diese werden unten in den "Regeln fürs Ausfüllen der Excel Tablle" erklärt. 
Die Grundidee ist, dass es pro **Messe** eine Zeile gibt. 
Das heißt, dass es auch mehrere Zeilen für einen **Tag** geben kann. 
In der Zeile werden dann die Zellen in den Spalten gefüllt, in denen die Messdiener dienen sollen. 

Wichtig: der aktuelle Messdienerplan muss immer in den letzten Zeilen sein.
Das heißt, dass nach dem aktuellen Messdienerplan immer eine leere Zeile folgen muss, bzw. zumindest die 1. Zelle leer sein muss. 
Es ist nicht möglich schon weitere Daten einzutragen. 

### Regeln fürs Ausfüllen der Excel Tabelle

Zum Bearbeiten der Excel Tabelle immer die ".xlsx" Datei öffnen und auch speichern und erst dann die Datei auch als ".csv" speichern. 
Grund dafür ist, dass man durch das Speichern als ".csv" Informationen verliert, wie zum Beispiel bedingte Formatierungen.

Die nicht fett geschrieben Wörter, sind optionale Felder.
- **Datum**: Das Datum muss das Format TT.MM.YYYY haben
- Name Tag: Hier angeben, wie der Tag heißt, z.B. "1. Sonntag im Jahreskreis". Die Zelle kann auch leer bleiben, falls es keinen Namen für den Tag gibt
- **Uhrzeit**: Die Uhrzeit der Messe muss das Format hh:mm haben
- **Name Messe**:  Der Name der Messe ist zum Beispiel "Vorabendmesse"
- Treffen: Falls es ein früheres Treffen gibt, hier die Uhrzeit des Treffens eintragen im Format: hh:mm 
- Anbetung: Falls es eine Anbetung gibt, hier "ja" eintragen. Die Anbetung ist immer festgelegt für die Zeros um 16:15 Uhr! Falls es anders sein sollte, im Latex Code ändern!
- Besonderheit: Besonderheiten sind für Messen mit anderen Messdienern, wie zum Beipiel "es dient der karnevalsverein". Dafür in die Zelle ein "ja" eintragen. Es wir nur nach einem Zero gesucht und gegebenenfalls hingeschrieben. Ansonsten wird "Es dien..." in kursiv hingeschrieben. Hier **muss** manuell der Latex Code mit der Besonderheit geändert werden. 

Die 2-6 bzw. 2-5 sind nur für die ausfüllenden Personen und werden vom Java Programm nicht beachtet. 
- Leiterrunde: in die ersten drei Zeilen trägt man die **Anzahl** der Zeros, Weihrauchmessdiener (WR) und Messdiener der Kreuzgruppe (KG) ein. 
- Messdiener: in die ersten beiden Zeilen trägt man die **Anzahl** der normalen Altardiener (AD) und den eventuellen Flambeaux-Messdiener (Flam) ein. 
In diese Felder werden nur Zahlen eingetragen. 
Falls keine Messdiener in dem Bereich benötigt werden, kann man die Zelle leer lassen oder eine "0" reinschreiben. 
Die Spalte danach ("sum") berechnet automatisch die Summe in Excel. 
Die Spalte dahinter ("checksum") berechnet, wie viele Messdiener auch wirklich eingeteilt wurden. 
Wenn die beiden Summen gleich sind, wurden passend viele Messdiener eingeteilt und das Datum wird grün hinterlegt.  

Zuletzt teilt man die Leiterrunde und Messdiener ein. 
- Leiterrunde: für einen Zero trägt man eine "1" in die passende Zelle ein, für Weihrauch- oder Kreuzgruppenmessdiener eine "2"
- Messdiener: für normale Altardiener trägt man eine "1" in die passende Zelle ein, für besondere oder Flambeauxmessdiener eine "2". 

**Wichtig:** Wenn man unterschiedliche Zahlen einträgt kommt immer ein Absatz zwischen die Personen!
Außerdem kommen immer erst die Zeros und dann die restlichen Messdiener der Leiterrunde, dann die Flambeauxmessdiener und dann die normalen Altarmessdiener. 

Absagen: Für Absagen einfach eine "0" oder etwas beliebiges anders außer "1" oder "2" in die passende Zelle eintragen. 

Hinweis: Die letzte Spalte muss immer die Endcolumn sein. 
Diese ist notwendig für die Programmierung.
Ihr Ende ist erstmal auf Zeile 1000 festgelegt, kann aber beliebig erweitert werden. 

Am Ende die Bearbeitung der Excel immer in der ".csv" speichern!

## Regeln für Java Programm

Als nächstes muss das Java Programm ausgeführt werden.
Dafür muss die Klasse "mdpGeneration.java" erst modifiziert und dann kompiliert und ausgeführt werden.
Folgende Modifikationen sind möglich, dabei sind die Wörter in Sternchen auf jeden Fall nötig zu ändern:
	
	static String startdate = "**DD.MM.YYYY**";
	static String enddate = "**DD.MM.YYYY**";
	static String number = "**Nummer**";
	static String newStartdate = enddate;
	static String newEnddate = "**DD.MM.YYYY**";
	static String redaktionsschluss = "**DD.MM.YYYY**";
	static String output = "C:/Users/annik/Documents/mdp/TexDateien/TexDatei" + number + ".txt";

In den Anführungsstrichen ist die Modifikation in dem vorgegebenen Format nötig. 

**Wichtig:** Das startdate **muss** auf jeden Fall in der Exceldatei vorhanden sein, ansonsten verfällt das Programm in eine Endlosschleife!

## Regeln für den Latex Code

Im letzten Schritt muss der Text aus der Output Datei in TexMaker kopiert werden und ausgeführt werden.
Hier sind möglicherweise noch letzte manuelle Änderungen nötig.
- 1. Besonderheiten: 
