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
	// output in: C:/Users/annik/Documents/mdp/TexDateien/TexDatei.txt with number
	static String startdate = "22.02.2020";
	static String enddate = "05.04.2020";
	static String number = "165";
	static String newStartdate = enddate;
	static String newEnddate = "17.03.2020";
	static String redaktionsschluss = "21.03.2020";

	public static void main(String[] args) {
		try {
			BufferedWriter bw = new BufferedWriter(
					new FileWriter("C:/Users/annik/Documents/mdp/TexDateien/TexDatei" + number + ".txt"));
			kopfZeile(bw);
			titel(bw, startdate, enddate, number);
			name(bw, startdate, enddate);
			fussZeile(bw, newStartdate, newEnddate, redaktionsschluss);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void kopfZeile(BufferedWriter bw) {
		try {
			bw.write("\\documentclass[11pt,a4paper]{article}");
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
			bw.write("\\pgfplotsset{compat=1.8}");
			bw.newLine();
			bw.newLine();
			bw.write("\\newenvironment{nstabbing}");
			bw.newLine();
			bw.write("\t{\\setlength{\\topsep}{-\\parskip}%");
			bw.newLine();
			bw.write("\t\\setlength{\\partopsep}{0pt}%");
			bw.newLine();
			bw.write("\t\\tabbing}");
			bw.newLine();
			bw.write("\t{\\endtabbing}");
			bw.newLine();
			bw.newLine();
			bw.write("\\begin{document}");
			bw.newLine();
			bw.newLine();
			bw.write("\\begin{figure}[!htp]");
			bw.newLine();
			bw.write("\t\\centering");
			bw.newLine();
			bw.write("\t\\includegraphics[width=13cm]{kopf1}");
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
			bw.write("\t\\includegraphics[width=13cm]{kopf2}");
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
			bw.write("\\par\\noindent\\rule{\\textwidth}{2pt}");
			bw.newLine();
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void fussZeile(BufferedWriter bw, String newStartdate, String newEnddate, String redaktionsschluss) {
		try {
			bw.newLine();
			bw.write("\\vspace*{\\fill}");
			bw.newLine();
			bw.write("\\begin{center}");
			bw.newLine();
			bw.write("\\par\\noindent\\rule{\\textwidth}{0.4pt}");
			bw.newLine();
			bw.write(
					"\\small{\\textit{Verbindlich sind in Bezug auf die Zeiten der Gottesdienste, soweit nicht anders angegeben, nur die Angaben in den Pfarrnachrichten!}}");
			bw.newLine();
			bw.write("\\par\\noindent\\rule{\\textwidth}{0.4pt}");
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

	public static void name(BufferedWriter bw, String startdate, String enddate) {
		try {
			BufferedReader brLeiterrunde = new BufferedReader(
					new FileReader("C:/Users/annik/Documents/mdp/MDPLeiterrundeTransponiert.csv"));
			BufferedReader brMessdiener = new BufferedReader(
					new FileReader("C:/Users/annik/Documents/mdp/MDPMessdienerTransponiert.csv"));

			String nextLineLeiterrunde = brLeiterrunde.readLine();
			String[] cellsLeiterrunde = nextLineLeiterrunde.split(";");
			Map<Integer, String> nameMapLeiterrunde = new HashMap<Integer, String>();
			// Name Leiterrunde
			for (int i = 13; i < cellsLeiterrunde.length; i++) {
				nameMapLeiterrunde.put(i, cellsLeiterrunde[i]);
			}

			String nextLineMessdiener = brMessdiener.readLine();
			String[] cellsMessdiener = nextLineMessdiener.split(";");
			Map<Integer, String> nameMapMessdiener = new HashMap<Integer, String>();
			// Name Messdiener
			for (int i = 12; i < cellsMessdiener.length; i++) {
				nameMapMessdiener.put(i, cellsMessdiener[i]);
			}

			while (!cellsLeiterrunde[0].equals(startdate)) {
				nextLineLeiterrunde = brLeiterrunde.readLine();
				cellsLeiterrunde = nextLineLeiterrunde.split(";");
			}

			while (!cellsMessdiener[0].equals(startdate)) {
				nextLineMessdiener = brMessdiener.readLine();
				cellsMessdiener = nextLineMessdiener.split(";");
			}

			String oldDate = "";
			// change to enddate!
			while (!cellsLeiterrunde[0].equals("")) {
				// 36 elements for Leiterrunde
				// Metadaten vorhanden?
				if (cellsLeiterrunde.length > 13 && cellsMessdiener.length > 12) {
					// check if metadaten are the same! --> datum
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
						bw.newLine();
						// schreib den Wochentag
						// falls 2 Messen an einem Tag
						if (!oldDate.equals(cellsLeiterrunde[0])) {
							writeWochentag(bw, cellsLeiterrunde[6], cellsLeiterrunde[0], cellsLeiterrunde[7]);
						}
						bw.newLine();
						// eventuell früher Treffen
						if (!cellsLeiterrunde[10].equals("")) {
							writeTreffen(bw, cellsLeiterrunde[10]);
						}
						bw.newLine();
						// schreib die Messe
						writeMesse(bw, cellsLeiterrunde[8], cellsLeiterrunde[9]);
						bw.newLine();
						// schreib die Messdiener
						// erstmal messdiener für die messe in liste sammeln
						// wenn keine Besonderheit ist
						ArrayList<Integer> zeros = new ArrayList<Integer>();
						ArrayList<Integer> normalosLeiterrunde = new ArrayList<Integer>();
						ArrayList<Integer> normalosMessdiener = new ArrayList<Integer>();

						for (int i = 13; i < cellsLeiterrunde.length; i++) {
							if (cellsLeiterrunde[i].equals("1")) {
								zeros.add(i);
							}
							if (cellsLeiterrunde[i].equals("2")) {
								normalosLeiterrunde.add(i);
							}
						}

						for (int i = 12; i < cellsMessdiener.length; i++) {
							if (cellsMessdiener[i].equals("1")) {
								normalosMessdiener.add(i);
							}
						}

						if (cellsLeiterrunde[12].equals("")) {
							// zeros in file schreiben
							writeZero(bw, zeros, nameMapLeiterrunde, cellsLeiterrunde[11]);

							// normalos der Leiterrunde in file schreiben
							if (!normalosLeiterrunde.isEmpty()) {
								writeNormal(bw, normalosLeiterrunde, nameMapLeiterrunde);
							}
							// normalos der Messdiener in file schreiben
							writeNormal(bw, normalosMessdiener, nameMapMessdiener);
						} else {
							if(!zeros.isEmpty()) {
								writeZero(bw, zeros, nameMapLeiterrunde, cellsLeiterrunde[11]);
							}
							writeBesonderes(bw);
						}
						
					} else {
						System.err.println("Metadaten stimmen nicht überein!");
					}
				} else {
					System.err.println("Error: " + cellsLeiterrunde[0]);
				}
				oldDate = cellsLeiterrunde[0];
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
				
				// Linie machen
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
			bw.write("\\textbf{\\underline{" + wochentag + ". " + datum);
			if (!name.equals("")) {
				bw.write(": " + name);
			}
			bw.write("}}");
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeMesse(BufferedWriter bw, String uhrzeit, String nameMesse) {
		try {
			bw.newLine();
			bw.write("\\textbf{" + uhrzeit + " Uhr " + nameMesse + ":}");
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

			bw.write("\\begin{nstabbing}");
			bw.newLine();
			bw.write("\\hspace*{2.5cm}\\=\\hspace*{5cm}\\= \\kill");
			bw.newLine();

			String addAnbetung = "";
			if (anbetung.equals("ja")) {
				addAnbetung = " (16:15 Uhr)";
			}

			if (zeros.size() == 1) {
				bw.write("\\> \\underline{" + nameMap.get(zeros.get(0)) + addAnbetung + "} \\>");
			} else if ((zeros.size() % 2) == 0) {
				for (int i = 0; i < zeros.size(); i += 2) {
					bw.write("\\> \\underline{" + nameMap.get(zeros.get(i)) + addAnbetung + "} \\> \\underline {"
							+ nameMap.get(zeros.get(i + 1)) + addAnbetung + "}");
					if (!((i + 2) == zeros.size())) {
						bw.write(" \\\\");
						bw.newLine();
					}
				}
			} else if (!((zeros.size() % 2) == 0)) {
				for (int i = 0; i < zeros.size() - 1; i += 2) {
					bw.write("\\> \\underline{" + nameMap.get(zeros.get(i)) + addAnbetung + "} \\> \\underline {"
							+ nameMap.get(zeros.get(i + 1)) + addAnbetung + "}" + " \\\\");
					bw.newLine();
				}
				bw.write("\\> \\underline{" + nameMap.get(zeros.get(zeros.size() - 1)) + addAnbetung + "} \\>");
			}

			bw.write("\\end{nstabbing}");
			bw.newLine();
			bw.write("\\vspace{0.2cm}");
			bw.newLine();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeNormal(BufferedWriter bw, ArrayList<Integer> normalos, Map<Integer, String> nameMap) {
		try {
			bw.write("\\begin{nstabbing}");
			bw.newLine();
			bw.write("\\hspace*{2.5cm}\\=\\hspace*{5cm}\\= \\kill");
			bw.newLine();

			if (normalos.size() == 1) {
				bw.write("\\> " + nameMap.get(normalos.get(0)) + " \\> ");
			} else if ((normalos.size() % 2) == 0) {
				for (int i = 0; i < normalos.size(); i += 2) {
					bw.write("\\> " + nameMap.get(normalos.get(i)) + " \\> " + nameMap.get(normalos.get(i + 1)));
					if (!((i + 2) == normalos.size())) {
						bw.write(" \\\\");
						bw.newLine();
					}
				}
			} else if (!((normalos.size() % 2) == 0)) {
				for (int i = 0; i < normalos.size() - 1; i += 2) {
					bw.write("\\> " + nameMap.get(normalos.get(i)) + " \\> " + nameMap.get(normalos.get(i + 1))
							+ " \\\\");
					bw.newLine();
				}
				bw.write("\\> " + nameMap.get(normalos.get(normalos.size() - 1)) + " \\> ");
			}

			bw.newLine();
			bw.write("\\end{nstabbing}");
			bw.newLine();
			bw.write("\\vspace{0.2cm}");
			bw.newLine();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeBesonderes(BufferedWriter bw) {
		try {
			bw.write("\\begin{nstabbing}");
			bw.newLine();
			bw.write("\\hspace*{2.5cm}\\=\\hspace*{5cm}\\= \\kill");
			bw.newLine();
			bw.write("\\> \\textit{Es dien...} \\> \\\\");
			bw.newLine();
			bw.write("\\end{nstabbing}");
			bw.newLine();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeLinie(BufferedWriter bw) {
		try {
			bw.newLine();
			bw.newLine();
			bw.write("\\par\\noindent\\rule{\\textwidth}{0.4pt}");
			bw.newLine();
			bw.newLine();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}