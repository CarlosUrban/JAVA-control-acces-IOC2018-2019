
/**
 *
 * @author Carlos Álvarez
 */
import java.util.Scanner;
import java.util.Formatter;

public class P4_e2_AlvarezU {
    public static final String TIPUS_OP0 = "No abonat";
    public static final String TIPUS_OP1 = "Total";
    public static final String TIPUS_OP2 = "Només piscina";
    public static final String TIPUS_OP3 = "Caps de setmana";
    public static final String GENERE1 = "Noia", GENERE2 = "Noi";
    public static final String ERROR1 = "Codi d'usuari incorrecte", ERROR2 = "Hora introduida incorrecta", ERROR3 = "Minut introduit incorrecte", ERROR4 = "Temps de permanencia introduit incorrecte", ERROR5 = "Genere introduit incorrecte", ERROR6 = "Tipus de soci introduit incorrecte";
    public static final int CODIMIN = 1000, CODIMAX = 4000;
    public static final int HORAMIN = 6, HORAMAX = 21;
    public static final int MINUTMIN = 0, MINUTMAX = 59;
    public static final int PERMANMIN = 1, PERMANMAX = 360;
    public static final int GENEREMIN = 1, GENEREMAX = 2;
    public static final int TIPUSMIN = 0, TIPUSMAX = 3;
    public static final int NUMERO_INTENTS = 3;
    public static final int USUARISMAXIM = 6;
    public static void main(String[] args) {
        //definim resta variables
        //String Tipus[]={TIPUS_OP0,"Total","Només piscina","Caps de setmana"};
        String tipusAbonament[] = {TIPUS_OP0, TIPUS_OP1, TIPUS_OP2, TIPUS_OP3};
        int codi = 0, horaEntrada = 0, minutEntrada = 0, permanencia = 0, genere = 0, tipus = 0;
        int contador = 0, resposta = 0, respostaUsuaris = 0, numeroDades = 0, tipusError = 0;
        String tipusUsuari = "", tipusGenere = "", tipusErrorText = "";
        int sumaTipus = 0;
        boolean tipusErroni = true;
        boolean dadaErronea = false;
        boolean introduirMes = true;
        //definim arrays
        int arrayDades[][] = new int[USUARISMAXIM][6];
        Scanner lector = new Scanner(System.in);
        //Presentem informació
        System.out.println("-CENTRE ESPORTIU-");
        System.out.println("-Introducció de dades-");
        System.out.println();
        //Comencem bucle fins que l'usuai no vulgui introduir mes dades
        do {
            //introducció del codi d'usuari
            while ((!dadaErronea) & (contador < NUMERO_INTENTS)) {
                System.out.print("Codi usuari [" + CODIMIN + "-" + CODIMAX + "]: ");
                tipusErroni = lector.hasNextInt();

                if (tipusErroni) {
                    codi = lector.nextInt();
                    lector.nextLine();
                    if ((codi < CODIMIN) || (codi > CODIMAX)) {
                        dadaErronea = false;
                        contador++;
                        tipusError = 1;
                    } else {
                        contador = 3;
                        dadaErronea = true;
                        arrayDades[numeroDades][0] = codi;
                    }
                }
            }
            contador = 0;
            //Introducció de la hora
            if ((dadaErronea) && (tipusErroni)) {
                dadaErronea = false;
                System.out.println();
                System.out.println("Quan entra?");
                while ((!dadaErronea) & (contador < NUMERO_INTENTS)) {
                    System.out.print("Hora [" + HORAMIN + "-" + HORAMAX + "]:");
                    tipusErroni = lector.hasNextInt();

                    if (tipusErroni) {
                        horaEntrada = lector.nextInt();
                        lector.nextLine();
                        if ((horaEntrada < HORAMIN) || (horaEntrada > HORAMAX)) {
                            dadaErronea = false;
                            contador++;
                            tipusError = 2;
                        } else {
                            contador = 3;
                            dadaErronea = true;
                            arrayDades[numeroDades][1] = horaEntrada;
                        }
                    }

                }
            }
            contador = 0;
            //Introducció del minut
            if ((dadaErronea) && (tipusErroni)) {
                dadaErronea = false;
                while ((!dadaErronea) & (contador < NUMERO_INTENTS)) {
                    System.out.print("Minut [" + MINUTMIN + "-" + MINUTMAX + "]: ");
                    tipusErroni = lector.hasNextInt();

                    if (tipusErroni) {
                        minutEntrada = lector.nextInt();
                        lector.nextLine();
                        if ((minutEntrada < MINUTMIN) || (minutEntrada > MINUTMAX)) {
                            dadaErronea = false;
                            contador++;
                            tipusError = 3;
                        } else {
                            contador = 3;
                            dadaErronea = true;
                            arrayDades[numeroDades][2] = minutEntrada;
                        }
                    }
                }
            }
            contador = 0;
            //Introducció del temps de permanencia
            if ((dadaErronea) && (tipusErroni)) {
                dadaErronea = false;
                while ((!dadaErronea) & (contador < NUMERO_INTENTS)) {
                    System.out.print("Minuts al centre [" + PERMANMIN + "-" + PERMANMAX + "]:");
                    tipusErroni = lector.hasNextInt();

                    if (tipusErroni) {
                        permanencia = lector.nextInt();
                        lector.nextLine();
                        if ((permanencia < PERMANMIN) || (permanencia > PERMANMAX)) {
                            dadaErronea = false;
                            contador++;
                            tipusError = 4;
                        } else {
                            contador = 3;
                            dadaErronea = true;
                            arrayDades[numeroDades][3] = permanencia;
                        }
                    }
                }
            }
            contador = 0;
            //Introducció del genere
            if ((dadaErronea) && (tipusErroni)) {
                System.out.println();
                dadaErronea = false;
                while ((!dadaErronea) & (contador < NUMERO_INTENTS)) {
                    System.out.print("Sexe?\n[1] " + GENERE1 + "\n[2] " + GENERE2 + "\n: ");
                    tipusErroni = lector.hasNextInt();

                    if (tipusErroni) {
                        genere = lector.nextInt();
                        lector.nextLine();
                        if ((genere < GENEREMIN) || (genere > GENEREMAX)) {
                            dadaErronea = false;
                            contador++;
                            tipusError = 5;
                        } else {
                            contador = 3;
                            dadaErronea = true;
                            arrayDades[numeroDades][4] = genere;
                        }
                    }
                }
            }
            contador = 0;
            //Introducció del tipus d'usuari
            if ((dadaErronea) && (tipusErroni)) {
                dadaErronea = false;
                System.out.println();
                while ((!dadaErronea) & (contador < NUMERO_INTENTS)) {
                    System.out.println("Tipus d'usuari:");
                    System.out.println("[0] " + TIPUS_OP0);
                    System.out.println("[1] " + TIPUS_OP1);
                    System.out.println("[2] " + TIPUS_OP2);
                    System.out.println("[3] " + TIPUS_OP3);
                    System.out.print(": ");
                    tipusErroni = lector.hasNextInt();

                    if (tipusErroni) {
                        tipus = lector.nextInt();
                        lector.nextLine();
                        if ((tipus < TIPUSMIN) || (tipus > TIPUSMAX)) {
                            dadaErronea = false;
                            contador++;
                            tipusError = 6;
                        } else {
                            contador = 3;
                            dadaErronea = true;
                            arrayDades[numeroDades][5] = tipus;
                        }
                    }
                }
            }
            contador = 0;
            System.out.println();
            //comprovem que no hi hagi errors i mostrem resultats
            if ((dadaErronea) && (tipusErroni)) {
                numeroDades++;
            } else {
                //Clasifiquem tipus d'error
                switch (tipusError) {
                    case 1:
                        tipusErrorText = ERROR1;
                        break;
                    case 2:
                        tipusErrorText = ERROR2;
                        break;
                    case 3:
                        tipusErrorText = ERROR3;
                        break;
                    case 4:
                        tipusErrorText = ERROR4;
                        break;
                    case 5:
                        tipusErrorText = ERROR5;
                        break;
                    case 6:
                        tipusErrorText = ERROR6;
                        break;
                }
                System.out.println();
                System.out.println("Introducció finalitzada per: " + tipusErrorText);
                dadaErronea = false;
                //introduirMes=false;
            }
            //Si la resposta es positiva torna a començar el bucle
            System.out.print("Vols introduir més dades?\n[0] NO\n[1] SI\n: ");
            resposta = lector.nextInt();
            lector.nextLine();
            if (resposta == 0) {
                introduirMes = false;
            } else {
                introduirMes = true;
                tipusErroni = true;
                dadaErronea = false;
                System.out.println();
            }
        } while (introduirMes);
        System.out.print("Vols mostrar els usuaris endreçats per temps de permanencia?\n[0] NO\n[1] SI\n: ");
        resposta = lector.nextInt();
        lector.nextLine();
        System.out.print("Vols mostrar quants usuaris de cada tipus hi ha?\n[0] NO\n[1] Si\n: ");
        respostaUsuaris = lector.nextInt();
        lector.nextLine();
        System.out.println();
        System.out.println("|CODI|\t|HORA ENTRADA|\t|TEMPS|\t|GENERE|\t|TIPUS USUARI|");
        //Mostrem resultats sense ordenar
        for (int i = 0; i < numeroDades; i++) {
            //Donem nom a tipus d'usuari
            switch (arrayDades[i][5]) {
                case 0:
                    tipusUsuari = TIPUS_OP0;
                    break;
                case 1:
                    tipusUsuari = TIPUS_OP1;
                    break;
                case 2:
                    tipusUsuari = TIPUS_OP2;
                    break;
                case 3:
                    tipusUsuari = TIPUS_OP3;
                    break;
            }
            //Donem nom al genere
            switch (arrayDades[i][4]) {
                case 1:
                    tipusGenere = GENERE1;
                    break;
                case 2:
                    tipusGenere = GENERE2;
                    break;
            }
            System.out.println(" " + arrayDades[i][0] + "\t " + String.format("%02d", arrayDades[i][1])
                    + ":" + String.format("%02d", arrayDades[i][2]) + "\t\t " + arrayDades[i][3] + "m\t " + tipusGenere + "\t\t " + tipusUsuari);
        }
        //Mostrem usuaris introduits
        System.out.println();
        if (numeroDades > 1) {
            System.out.println("S'han introduït " + numeroDades + " usuaris.");
            System.out.println();
        } else {
            System.out.println("S'ha introduït " + numeroDades + " usuari.");
            System.out.println();
        }
        //si la resposta és positiva ordena les dades per permanencia
        if (resposta == 1) {
            for (int i = 0; i < numeroDades - 1; i++) {
                for (int j = i + 1; j < numeroDades; j++) {
                    if (arrayDades[i][3] > arrayDades[j][3]) {
                        // Algoritme Bubble sort per intercanvi de dades en Arrays
                        int canvi = arrayDades[i][3];
                        arrayDades[i][3] = arrayDades[j][3];
                        arrayDades[j][3] = canvi;

                        canvi = arrayDades[i][0];
                        arrayDades[i][0] = arrayDades[j][0];
                        arrayDades[j][0] = canvi;

                        canvi = arrayDades[i][1];
                        arrayDades[i][1] = arrayDades[j][1];
                        arrayDades[j][1] = canvi;

                        canvi = arrayDades[i][2];
                        arrayDades[i][2] = arrayDades[j][2];
                        arrayDades[j][2] = canvi;

                        canvi = arrayDades[i][4];
                        arrayDades[i][4] = arrayDades[j][4];
                        arrayDades[j][4] = canvi;

                        canvi = arrayDades[i][5];
                        arrayDades[i][5] = arrayDades[j][5];
                        arrayDades[j][5] = canvi;
                    }
                }
            }
            System.out.println("|CODI|\t|HORA ENTRADA|\t|TEMPS|\t|GENERE|\t|TIPUS USUARI|");
            //mostrem resultat ordenats
            for (int i = 0; i < numeroDades; i++) {
                //System.out.println();
                //Donem nom a tipus d'usuari
                switch (arrayDades[i][5]) {
                    case 0:
                        tipusUsuari = TIPUS_OP0;
                        break;
                    case 1:
                        tipusUsuari = TIPUS_OP1;
                        break;
                    case 2:
                        tipusUsuari = TIPUS_OP2;
                        break;
                    case 3:
                        tipusUsuari = TIPUS_OP3;
                        break;
                }
                //Donem nom al genere
                switch (arrayDades[i][4]) {
                    case 1:
                        tipusGenere = GENERE1;
                        break;
                    case 2:
                        tipusGenere = GENERE2;
                        break;
                }
                System.out.println(" " + arrayDades[i][0] + "\t " + String.format("%02d", arrayDades[i][1])
                        + ":" + String.format("%02d", arrayDades[i][2]) + "\t\t " + arrayDades[i][3] + "m\t " + tipusGenere + "\t\t " + tipusUsuari);
            }
            System.out.println();
            System.out.println("Usuaris ordenats per temps de permanència");
        }
        // si la resposta es positiva mostrem llistat per tipus
        if (respostaUsuaris == 1) {
            System.out.println("\nUsuaris segons el tipus d'abonament");
            for (int j = 0; j < 4; j++) {
                for (int i = 0; i < numeroDades; i++) {
                    if (arrayDades[i][5] == j) {
                        sumaTipus++;
                    }
                }
                System.out.print("   " + tipusAbonament[j] + ": " + sumaTipus + "\n");
                sumaTipus = 0;
            }
            System.out.println();
        }
    }
}
