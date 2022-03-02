package com.company;


import java.util.Scanner;



public class Main {


    // Cæsar Shift-værdi:
    char[] shiftArrayIndex = {' ', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V','W','X', 'Y','Z', 'Æ','Ø','Å','A','B','C'};
    /* -----------------------------------*/
    // Array - Alfabet indhold:
    char[] letterArrayIndex = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S','T','U', 'V','W', 'X','Y','Z','Æ','Ø','Å'};
    /* -----------------------------------*/



    Scanner reader = new Scanner(System.in);


    public void showMenu() throws InterruptedException {

        System.out.println("");
        System.out.println("");
        System.out.println("----------------------------------------");
        System.out.println("  Velkommen til kryptering programmet:");
        System.out.println("----------------------------------------");
        Thread.sleep(2000);
        System.out.println("");
        System.out.println(" | Vælg et af kryptering systemerne |");
        System.out.println("");
        System.out.println("------------------------------");
        System.out.println(" [0]. Kryptering systemerne ?");
        System.out.println("------------------------------");
        System.out.println("");
        System.out.println(" [1]. Ceasar   - Kryptering.");
        System.out.println(" [2]. Vigenere - Kryptering. ");
        System.out.println("");
        System.out.println(" [5]. Luk programmet.");
        System.out.println("-------------------------------------");
        System.out.print(" [Indtast]: ");


        int menuValg = reader.nextInt();



    switch ( menuValg ) {

    case 1:
        Thread.sleep(500);
        System.out.println("");
        System.out.println("");
        System.out.println("-----------------------");
        System.out.println(" [ Ceasar kryptering ]:");
        System.out.println("-----------------------");
        System.out.println("");
        System.out.println(" [0]. Hovedmenu.");
        System.out.println("");
        System.out.println(" [1]. Krypter    - 'Almen tekst' ");
        System.out.println(" [2]. Dekrypter  - 'Code  tekst' ");
        System.out.println("");
        System.out.println("-------------------------------------");
        System.out.print(" [Indtast]: ");


        int ceasar_Valg = reader.nextInt();


        /* ------------------------------------------------------------ */


        switch ( ceasar_Valg ) {

            case 0:

                showMenu();
                Thread.sleep(1000);

                break;


            case 1:

                // userInput_ceasarKryptering (kryptering)
                userInput_ceasarKryptering();


            break;


             case 2:

            // userInput_ceasarDekryptering (kryptering)
            userInput_ceasarDekryptering();

            break;



    }

            break;

        /* ------------------------------------------------------------ */


    case 2:

        Thread.sleep(500);
        System.out.println("");
        System.out.println("");
        System.out.println("-------------------------");
        System.out.println(" [ Vigenere kryptering ]:");
        System.out.println("-------------------------");
        System.out.println("");
        System.out.println(" [1]. Krypter    - 'Almen tekst' ");
        System.out.println(" [2]. Dekrypter  - 'Code  tekst' ");
        System.out.println("");
        System.out.println(" [0]. Hovedmenu.");
        System.out.println("-------------------------------------");
        System.out.print(" [Indtast]: ");


        int vigenere_Valg = reader.nextInt();


        switch ( vigenere_Valg ) {



            case 0:

                showMenu();
                Thread.sleep(1000);

                break;



            case 1:

                // userInput_vigenereKryptering (kryptering)
                userInput_vigenereKryptering();

                break;


            case 2:

                // userInput_vigenereDekryptering (kryptering)
                userInput_vigenereDekryptering();

                break;



        }



            break;

        /* ------------------------------------------------------------ */



    case 5:

        System.out.println("");
        System.out.println("------------------------");
        System.out.println("- Programmet lukkes... -");
        System.out.println("------------------------");
        System.out.println("");
        Thread.sleep(2000);
        System.exit(0);


        break;


    default:

        System.out.println("");
        System.out.println("------------------------");
        System.out.println("- Du indtastet forkert -");
        System.out.println("------------------------");
        System.out.println("");
        Thread.sleep(2000);

        showMenu();

}



    }

    /* ------------------------------------------------------------ */
    /* ------------------------------------------------------------ */
    /* ------------------------------------------------------------ */


    public void userInput_ceasarKryptering () throws InterruptedException {

        Scanner reader_krypt = new Scanner(System.in);

        // NOTE:
        // Oplevet Scanner debug fejlen her. --> At readder.nextInt() overtager en reader.nextLine. Eller omvendt ??
        // Derfor en Scanner er tiføjet inde i metoden. Enten globalt eller i en metode.

        System.out.println("");
        System.out.println("-------------------------");
        System.out.println("Ceasar kryptering sektion:");
        System.out.println("-------------------------");
        System.out.println("");
        System.out.print("Indtast din Almen tekst her: ");

        String ceasar_KryptTekst = reader_krypt.nextLine();  // Bruger input af plaintekst.

        convert_Letters_ceasar( ceasar_KryptTekst );        // Krypter teksten.

        display_ceasarKryptering( ceasar_KryptTekst );      // Viser den krypteret tekst.

        showMenu();                                         // Komme tilbage til menuen --> No Deadend.

        // NOTE:
        // convert_Letters_ceasar( ceasar_KryptTekst ).sout [Enter];
        // Ved at indtaste .sout til sidst i metoden --> Klik Enter. Er det



    }

    public String convert_Letters_ceasar  ( String ceasar_KryptTekst ) {


        String resultat = " ";


        for (int i = 0; i < ceasar_KryptTekst.length(); i++) {

            char etBogstav_Krypt = ceasar_KryptTekst.charAt(i);

            char krypt = kryptEtTegn(etBogstav_Krypt);

            resultat = resultat + krypt;


        }

        return resultat;
    }



public char kryptEtTegn (char etBogstav_Krypt) {


    char  tekstÆndring_Krypt = ' ';

    for (int i = 0; i < letterArrayIndex.length; i++) {

        if (etBogstav_Krypt == letterArrayIndex[i]) { // De er placeret i samme række af Array'et.

            // NOTE:
            // for loop gennemgår ens parametre fra en variable = char etBogstav fra en anden metode.
            // til at sammenligne ens alfabet Array --> letterArrayIndex. char etBogstav er samme index række som ens letterArrayIndex.
            // letterArrayIndex[i] --> selve i'et omfanger/sammenkæder ens loop gennemgang.


            tekstÆndring_Krypt = shiftArrayIndex[i];

            // NOTE:
            // Det er muligt, at lave letterArrayIndex[i + 3] --> For at lave en Shiftværdi.
            // Men mit ShiftVærdi Array ovenover er endnu mere direkte indikeret.

            return tekstÆndring_Krypt;
        }


    }

    return '?';
}



    public String display_ceasarKryptering ( String ceasar_KryptTekst ) throws InterruptedException {

        System.out.println("");
        System.out.println("");
        System.out.println("Code tekst:");
        System.out.println("-----------------------------");
        System.out.println(convert_Letters_ceasar(ceasar_KryptTekst.toUpperCase()));
        System.out.println("-----------------------------");
        Thread.sleep(3000);


        return ceasar_KryptTekst;

    }

    /* ------------------------------------------------------------ */
    /* ------------------------------------------------------------ */
    /* ------------------------------------------------------------ */


    public void userInput_ceasarDekryptering () throws InterruptedException {


        // TODO - Dekryptering struktur.

        Scanner reader_dekrypt = new Scanner(System.in);


        System.out.println("");
        System.out.println("----------------------------");
        System.out.println("Ceasar Dekryptering sektion:");
        System.out.println("----------------------------");
        System.out.println("");
        System.out.print("Indtast din Code tekst her: ");

        String ceasar_DekryptTekst = reader_dekrypt.nextLine();  // Bruger input af codetekst.

        convert_Numbers_ceasar( ceasar_DekryptTekst );          // Derypter teksten.

        display_ceasarDekryptering( ceasar_DekryptTekst );        // Viser den dekrypteret tekst.

        showMenu();                                             // Komme tilbage til menuen --> No Deadend.




    }


    public String convert_Numbers_ceasar ( String ceasar_DekryptTekst ) {

        // TODO - implementere struktur.

        String resultat = " ";


        for (int i = 0; i < ceasar_DekryptTekst.length(); i++) {

            char etBogstav_Dekrypt = ceasar_DekryptTekst.charAt(i);

            char dekrypt = DekryptEtTegn(etBogstav_Dekrypt);

            resultat = resultat + dekrypt;


        }

        return resultat;
    }



    public char DekryptEtTegn (char etBogstav_Dekrypt) {


        char  tekstÆndring_DeKrypt = ' ';

        for (int i = 0; i < shiftArrayIndex.length; i++) {

            if (etBogstav_Dekrypt == shiftArrayIndex[i]) {


                tekstÆndring_DeKrypt = letterArrayIndex[i];



                return tekstÆndring_DeKrypt;
            }


        }

        return '?';
    }



    public String display_ceasarDekryptering (String ceasar_DekryptTekst) throws InterruptedException {


        // TODO - display Dekryptering struktur.

        System.out.println("");
        System.out.println("");
        System.out.println("Almen tekst:");
        System.out.println("-----------------------------");
        System.out.println(convert_Numbers_ceasar(ceasar_DekryptTekst.toUpperCase()));
        System.out.println("-----------------------------");
        Thread.sleep(3000);


        return ceasar_DekryptTekst;


    }



    /* ------------------------------------------------------------ */
    /* ------------------------------------------------------------ */
    /* ------------------------------------------------------------ */
    /* ------------------------------------------------------------ */
    /* ------------------------------------------------------------ */
    /* ------------------------------------------------------------ */


    public void userInput_vigenereKryptering () throws InterruptedException {

        // TODO - Kryptering struktur.


        System.out.println("");
        System.out.println("-----------------------------------------");
        System.out.println("Vigenere kryptering - Under konstruktion!");
        System.out.println("-----------------------------------------");

        showMenu();
    }

    public void display_vigenereKryptering () {

        // TODO - display kryptering struktur.

        System.out.println("");
        System.out.println("-------------------------");
        System.out.println("Vigenere display kryptering sektion:");
        System.out.println("-------------------------");
        System.out.println("");



    }

    public void userInput_vigenereDekryptering () throws InterruptedException {

        // TODO - Dekryptering struktur.

        System.out.println("");
        System.out.println("-------------------------------------------");
        System.out.println("Vigenere Dekryptering - Under konstruktion!");
        System.out.println("-------------------------------------------");

        showMenu();
    }

    public void display_vigenereDekryptering () {

        // TODO - display kryptering struktur.

        System.out.println("");
        System.out.println("-------------------------");
        System.out.println("Vigenere display dekryptering sektion:");
        System.out.println("-------------------------");
        System.out.println("");



    }



    public void convert_Letters_vigenere () {

        // TODO - implementere struktur.

        // ?????


    }

    public void convert_Numbers_vigenere () {

        // TODO - implementere struktur.

        // ?????


    }


    /* ------------------------------------------------------------ */
    /* ------------------------------------------------------------ */
    /* ------------------------------------------------------------ */
    /* ------------------------------------------------------------ */
    /* ------------------------------------------------------------ */
    /* ------------------------------------------------------------ */



    public static void main(String[] args) throws InterruptedException {


        Main Enigma = new Main();

        Enigma.showMenu();
        // System.out.println();

        // Enigma.userInput_ceasarKryptering();
        // Enigma.userInput_ceasarDekryptering();


      //  System.out.println(Enigma.convert_Letters_ceasar("ABCDEFG"));
       // System.out.println();


    }
}
