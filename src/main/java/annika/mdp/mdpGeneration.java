package annika.mdp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class mdpGeneration {

	// TODO: insert startdate, enddate, newEnddate and redaktionsschluss of mdp in
	// format: DD.MM.YYYY

	static String startdate = "22.02.2020";
	static String enddate = "05.04.2020";
	static String number = "165";
	static String newStartdate = enddate;
	static String newEnddate = "17.03.2020";
	static String redaktionsschluss = "21.03.2020";
	
	// output in: C:/Users/annik/Documents/mdp/TexDateien/TexDatei.txt with number
	static String output = "C:/Users/annik/Documents/mdp/TexDateien/TexDatei" + number + ".txt";

	public static void main(String[] args) {
		try {
			BufferedWriter bw = new BufferedWriter(
					new FileWriter(output));
			kopfZeile(bw);
			titel(bw, startdate, enddate, number);
			fill(bw, startdate, enddate);
			fussZeile(bw, newStartdate, newEnddate, redaktionsschluss);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void kopfZeile(BufferedWriter bw) {
		try {
			//packages einbinden
			bw.write("\\documentclass[11pt,a4paper,twocolumn]{article}");
			bw.newLine();
			bw.write("\\usepackage{times}");
			bw.newLine();
			bw.write("\\usepackage{color}");
			bw.newLine();
			bw.write("\\usepackage{pgfplots, pgfplotstable}");
			bw.newLine();
			bw.write("\\usepackage[utf8]{inputenc}");
			bw.newLine();
			bw.write("\\usepackage[T1]{fontenc}");
			bw.newLine();
			bw.write("\\usepackage{hyperref}");
			bw.newLine();
			bw.write("\\usepackage{pdflscape}");
			bw.newLine();
			bw.write("\\usepackage{hyperref}");
			bw.newLine();
			bw.write("\\usepackage[landscape=true, left=1cm,right=1cm,top=2cm,bottom=2cm,bindingoffset=5mm]{geometry}");
			bw.newLine();
			bw.write("\\usepackage{soulutf8}");
			bw.newLine();
			bw.write("\\usepackage{setspace}");
			bw.newLine();
			bw.write("\\pgfplotsset{compat=1.8}");
			bw.newLine();
			bw.newLine();
			
			// document beginnen
			// beide bilder einbinden vom mdp
			bw.write("\\begin{document}");
			bw.newLine();
			bw.newLine();
			bw.write("\\raggedbottom");
			bw.newLine();
			bw.newLine();
			bw.write("\\setuldepth{a}");
			bw.newLine();
			bw.newLine();
			bw.write("\\begin{figure}[!htp]");
			bw.newLine();
			bw.write("\t\\centering");
			bw.newLine();
			bw.write("\t\\includegraphics[width=10cm]{kopf1}");
			bw.newLine();
			bw.write("\t\\label{fig:kopf1}");
			bw.newLine();
			bw.write("\\end{figure}");
			bw.newLine();
			bw.newLine();
			bw.write("\\begin{figure}[!htp]");
			bw.newLine();
			bw.write("\t\\centering");
			bw.newLine();
			bw.write("\t\\includegraphics[width=10cm]{kopf2}");
			bw.newLine();
			bw.write("\t\\label{fig:kopf2}");
			bw.newLine();
			bw.write("\\end{figure}");
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void titel(BufferedWriter bw, String startdate, String enddate, String number) {
		try {
			// Titel und Nummer schreiben
			bw.newLine();
			bw.write("\\begin{center}");
			bw.newLine();
			bw.write("\\textbf{\\Large{für die Zeit vom " + startdate + " - " + enddate + "}}");
			bw.newLine();
			bw.newLine();
			bw.write("\\textbf{\\Large{Nr. " + number + "}}");
			bw.newLine();
			bw.write("\\end{center}");
			bw.newLine();
			bw.newLine();
			bw.write("\\par\\noindent\\rule{\\linewidth}{2pt}");
			bw.newLine();
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void fussZeile(BufferedWriter bw, String newStartdate, String newEnddate, String redaktionsschluss) {
		try {
			// Kasten unten definieren
			bw.newLine();
			bw.write("\\vspace*{\\fill}");
			bw.newLine();
			bw.write("\\begin{center}");
			bw.newLine();
			bw.write("\\par\\noindent\\rule{\\linewidth}{0.4pt}");
			bw.newLine();
			bw.write(
					"\\small{\\textit{Verbindlich sind in Bezug auf die Zeiten der Gottesdienste, soweit nicht anders angegeben, nur die Angaben in den Pfarrnachrichten!}}");
			bw.newLine();
			bw.write("\\par\\noindent\\rule{\\linewidth}{0.4pt}");
			bw.newLine();
			bw.write(
					"\\small{\\textit{Die Wünsche für die Messdienerpläne sind abzugeben bei Marina und Annika Österdiekhoff – Feldhagen 5 – 33129 Delbrück – annika.oesterdiekhoff@ewe.net}}");
			bw.newLine();
			bw.write("\\end{center}");
			bw.newLine();
			bw.write("\\fbox{\\parbox{\\linewidth}{\\centering Der nächste Messdienerplan gilt vom " + newStartdate
					+ " – " + newEnddate + " \\\\ Redaktionsschluss ist am " + redaktionsschluss + ".}}");
			bw.newLine();
			bw.newLine();
			bw.write("\\end{document}");
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void fill(BufferedWriter bw, String startdate, String enddate) {
		try {
			BufferedReader brLeiterrunde = new BufferedReader(
					new FileReader("C:/Users/annik/Documents/mdp/MDPLeiterrundeTransponiert.csv"));
			BufferedReader brMessdiener = new BufferedReader(
					new FileReader("C:/Users/annik/Documents/mdp/MDPMessdienerTransponiert.csv"));

			//Zeilen, Zellen und Namen der Leiterrunde
			String nextLineLeiterrunde = brLeiterrunde.readLine();
			String[] cellsLeiterrunde = nextLineLeiterrunde.split(";");
			Map<Integer, String> nameMapLeiterrunde = new HashMap<Integer, String>();
			// Name Leiterrunde
			for (int i = 13; i < cellsLeiterrunde.length; i++) {
				nameMapLeiterrunde.put(i, cellsLeiterrunde[i]);
			}

			//Zeilen, Zellen und Namen der Messdiener
			String nextLineMessdiener = brMessdiener.readLine();
			String[] cellsMessdiener = nextLineMessdiener.split(";");
			Map<Integer, String> nameMapMessdiener = new HashMap<Integer, String>();
			// Name Messdiener
			for (int i = 12; i < cellsMessdiener.length; i++) {
				nameMapMessdiener.put(i, cellsMessdiener[i]);
			}

			// bis zur Zeile laufen, die das akutelle Startdate beinhaltet
			while (!cellsLeiterrunde[0].equals(startdate)) {
				nextLineLeiterrunde = brLeiterrunde.readLine();
				cellsLeiterrunde = nextLineLeiterrunde.split(";");
			}
			
			// bis zur Zeile laufen, die das akutelle Startdate beinhaltet
			while (!cellsMessdiener[0].equals(startdate)) {
				nextLineMessdiener = brMessdiener.readLine();
				cellsMessdiener = nextLineMessdiener.split(";");
			}

			String oldDate = "";
			// TODO: abfragen des enddates!
			// guckt sich die Zeilen an, bis die erste Zelle einer Zeile leer ist. 
			while (!cellsLeiterrunde[0].equals("")) {
				// checken ob die Metadaten vorhanden sind 
				if (cellsLeiterrunde.length > 13 && cellsMessdiener.length > 12) {
					// check ob die Metadaten in beiden Excel Tabellen gleich sind 
					if (cellsLeiterrunde[0].equals(cellsMessdiener[0]) &&
					// wochentag
							cellsLeiterrunde[6].equals(cellsMessdiener[5]) &&
							// name tag
							cellsLeiterrunde[7].equals(cellsMessdiener[6]) &&
							// uhrzeit
							cellsLeiterrunde[8].equals(cellsMessdiener[7]) &&
							// name messe
							cellsLeiterrunde[9].equals(cellsMessdiener[8]) &&
							// treffen
							cellsLeiterrunde[10].equals(cellsMessdiener[9]) &&
							// anbetung
							cellsLeiterrunde[11].equals(cellsMessdiener[10]) &&
							// besonderes
							cellsLeiterrunde[12].equals(cellsMessdiener[11])) {
						// schreib den Wochentag
						// falls 2 Messen an einem Tag, abprüfen, ob das Datum schon geschrieben wurde
						if (!oldDate.equals(cellsLeiterrunde[0])) {
							writeWochentag(bw, cellsLeiterrunde[6], cellsLeiterrunde[0], cellsLeiterrunde[7]);
						}
						// falls früher Treffen, Treffen einfügen
						if (!cellsLeiterrunde[10].equals("")) {
							writeTreffen(bw, cellsLeiterrunde[10]);
						}
						// schreib die Messe
						writeMesse(bw, cellsLeiterrunde[8], cellsLeiterrunde[9]);
						// schreib die Personen
						// erstmal messdiener für die messe in liste sammeln
						ArrayList<Integer> zeros = new ArrayList<Integer>();
						ArrayList<Integer> normalosLeiterrunde = new ArrayList<Integer>();
						ArrayList<Integer> normalosMessdiener = new ArrayList<Integer>();
						ArrayList<Integer> flambeauxMessdiener = new ArrayList<Integer>();

						// Leiterrunden Messdiener sammeln
						for (int i = 13; i < cellsLeiterrunde.length; i++) {
							if (cellsLeiterrunde[i].equals("1")) {
								zeros.add(i);
							}
							if (cellsLeiterrunde[i].equals("2")) {
								normalosLeiterrunde.add(i);
							}
						}

						// Messdiener sammeln
						for (int i = 12; i < cellsMessdiener.length; i++) {
							if (cellsMessdiener[i].equals("1")) {
								normalosMessdiener.add(i);
							}
							if (cellsMessdiener[i].equals("2")) {
								flambeauxMessdiener.add(i);
							}
						}

						// wenn in der Messe keine Besonderheit ist
						if (cellsLeiterrunde[12].equals("")) {
							// zeros in file schreiben
							writeZero(bw, zeros, nameMapLeiterrunde, cellsLeiterrunde[11]);

							// normalos der Leiterrunde in file schreiben --> eventuell keine normalos vorhanden
							if (!normalosLeiterrunde.isEmpty()) {
								writeNormal(bw, normalosLeiterrunde, nameMapLeiterrunde, true);
							}
							
							// flambeaux der Messdiener in file schreiben --> eventuell keine flambeaux vorhanden
							if(!flambeauxMessdiener.isEmpty()) {
								if(!normalosMessdiener.isEmpty()) {
									writeNormal(bw, flambeauxMessdiener, nameMapMessdiener, true);
								} else {
									writeNormal(bw, flambeauxMessdiener, nameMapMessdiener, false);
								}
							}
							// normalos der Messdiener in file schreiben
							writeNormal(bw, normalosMessdiener, nameMapMessdiener, false);
							

						} else {
							// bei Besonderheit gibt es eventuell Zero
							if(!zeros.isEmpty()) {
								writeZero(bw, zeros, nameMapLeiterrunde, cellsLeiterrunde[11]);
								writeBesonderes(bw, true);
							} else {
								writeBesonderes(bw, false);
							}
						}
						
					} else {
						System.err.println("Metadaten stimmen nicht überein!");
					}
				} else {
					System.err.println("Error: " + cellsLeiterrunde[0]);
				}
				
				// altes Datum speichern, für mehrere Messe an einem Tag
				oldDate = cellsLeiterrunde[0];
				
				// alten Wochentag speichern, um einen Linie nur bei der letzten Messe eines Tages zu machen 
				String oldWochentag = "";
				if(cellsLeiterrunde.length >= 6) {
					oldWochentag = cellsLeiterrunde[6];
				} else {
					System.err.println("Error");
				}
				nextLineLeiterrunde = brLeiterrunde.readLine();
				cellsLeiterrunde = nextLineLeiterrunde.split(";");
				nextLineMessdiener = brMessdiener.readLine();
				cellsMessdiener = nextLineMessdiener.split(";");
				
				// Linie machen, außer der Tag ist ein Samstag oder es gibt mehrere Messe an dem Tag --> dann erst hinter
				// der letzen Messe
				if(!oldWochentag.equals("Sa") && !oldDate.equals(cellsLeiterrunde[0])) {
					writeLinie(bw);
				}
			}
			brLeiterrunde.close();
			brMessdiener.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeWochentag(BufferedWriter bw, String wochentag, String datum, String name) {
		try {
			bw.newLine();
			bw.newLine();
			bw.write("\\textbf{\\ul{" + wochentag + ". " + datum);
			
			// eventuell hat der Tag einen Namen
			if (!name.equals("")) {
				bw.write(": " + name);
			}
			bw.write("}}");
			bw.newLine();
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeMesse(BufferedWriter bw, String uhrzeit, String nameMesse) {
		try {
			bw.newLine();
			bw.newLine();
			bw.write("\\textbf{" + uhrzeit + " Uhr " + nameMesse + ":}");
			bw.newLine();
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeTreffen(BufferedWriter bw, String uhrzeitTreffen) {
		try {
			bw.newLine();
			bw.write("\\textbf{" + uhrzeitTreffen + " Uhr Treffen}");
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeZero(BufferedWriter bw, ArrayList<Integer> zeros, Map<Integer, String> nameMap,
			String anbetung) {
		try {

			bw.write("\\begin{tabular}{p{1.5cm}p{5cm}l}");
			bw.newLine();

			// Falls es eine Anbetung gibt, diese hinter Zeros hinzufügen
			String addAnbetung = "";
			if (anbetung.equals("ja")) {
				addAnbetung = " (16:15h)";
			}

			if (zeros.size() == 1) {
				bw.write("& \\ul{" + nameMap.get(zeros.get(0)) + addAnbetung + "} \\\\[0.25\\normalbaselineskip]");
				bw.newLine();
			
			// gerade Anzahl von Zeros 
			} else if ((zeros.size() % 2) == 0) {
				for (int i = 0; i < zeros.size(); i += 2) {
					bw.write("& \\ul{" + nameMap.get(zeros.get(i)) + addAnbetung + "} & \\ul{"
							+ nameMap.get(zeros.get(i + 1)) + addAnbetung + "}");
					// bei der letzten Zeile soll am Ende mini absatz sein
					if (!((i + 2) == zeros.size())) {
						bw.write(" \\\\");
						bw.newLine();
					} else {
						bw.write(" \\\\[0.25\\normalbaselineskip]");
						bw.newLine();
					}
				}
			
			// ungerade Anzahl von Zeros, der letzte Zero hat in der Tab Umgebung eine leere Stelle
			} else if (!((zeros.size() % 2) == 0)) {
				for (int i = 0; i < zeros.size() - 1; i += 2) {
					bw.write("& \\ul{" + nameMap.get(zeros.get(i)) + addAnbetung + "} & \\ul{"
							+ nameMap.get(zeros.get(i + 1)) + addAnbetung + "}" + " \\\\");
					bw.newLine();
				}
				// bei der letzten Zeile soll am Ende mini absatz sein
				bw.write("& \\ul{" + nameMap.get(zeros.get(zeros.size() - 1)) + addAnbetung + "} & \\\\[0.25\\normalbaselineskip]");
				bw.newLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeNormal(BufferedWriter bw, ArrayList<Integer> normalos, Map<Integer, String> nameMap, boolean gibtFolgende) {
		try {
			
			// siehe Kommentare bei writeZero
			
			if (normalos.size() == 1) {
				bw.write("& " + nameMap.get(normalos.get(0)) + " & \\\\[0.25\\normalbaselineskip]");
			} else if ((normalos.size() % 2) == 0) {
				for (int i = 0; i < normalos.size(); i += 2) {
					bw.write("& " + nameMap.get(normalos.get(i)) + " & " + nameMap.get(normalos.get(i + 1)));
					// bei der letzten Zeile soll am Ende mini absatz sein
					if (!((i + 2) == normalos.size())) {
						bw.write(" \\\\");
						bw.newLine();
					} else {
						bw.write(" \\\\[0.25\\normalbaselineskip]");
						bw.newLine();
					}
				}
			} else if (!((normalos.size() % 2) == 0)) {
				for (int i = 0; i < normalos.size() - 1; i += 2) {
					bw.write("& " + nameMap.get(normalos.get(i)) + " & " + nameMap.get(normalos.get(i + 1))
							+ " \\\\");
					bw.newLine();
				}
				bw.write("& " + nameMap.get(normalos.get(normalos.size() - 1)) + " & \\\\[0.25\\normalbaselineskip]");
			}

			bw.newLine();
			
			if(gibtFolgende == false) {
				bw.write("\\end{tabular}");
				bw.newLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeBesonderes(BufferedWriter bw, boolean withZero) {
		try {
			// bei Besonderheit kursiv schreiben 
			if(withZero == false) {
				bw.write("\\begin{tabular}{p{1.5cm}p{5cm}l}");
				bw.newLine();
			}
			bw.write("& \\textit{Es dien...} & \\\\");
			bw.newLine();
			bw.write("\\end{tabular}");
			bw.newLine();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeLinie(BufferedWriter bw) {
		try {
			bw.newLine();
			bw.newLine();
			bw.write("\\par\\noindent\\rule{\\linewidth}{0.4pt}");
			bw.newLine();
			bw.newLine();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}