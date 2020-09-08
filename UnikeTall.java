import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Created by Gauseeban on 13.07.2020.
 */
public class UnikeTall {
    // Deklarasjon av array for lagring av tilfeldige heltall

    private int[] tabell;

    /*Konstruktør som mottar arrayets lengde som parameter og oppretter arrayet.*/

    public UnikeTall(int lengde){
        tabell = new int[lengde];

        // Velger å fylle arrayet med tilfeldige tall rett i konstruktøren
        fyllArrayMedTilfeldigeTall();
    }

    /*Metode som skal undersøke om et gitt tall finnes i arrayet fra før.
      Tallet det letes etter skal mottas som parameter.
      Metoden skal returnere true hvis tallet finnes i arrayet.
      Hvis ikke skal metoden returnere false.*/

    private boolean finnesIArray(int tall) {
        for (int i = 0; i < tabell.length; i++) {
            if (tabell[i] == tall){
                return true;
            }
        }
        return false;
    }

    /*Metoden som skal fylle arrayet med tilfeldige tall mellom 100 og 999,
      begge grenser inkludert. Metoden skal gjøre dette på en måte
      som sikrer at alle tallene er forskjellige. Metoden skal ikke ha
      parametre og heller ikke returnere noen verdi.
      Tips bruk (int)(Math.random()*(900)+100) for å generere tallene mellom 100 999*/

    private void fyllArrayMedTilfeldigeTall(){
        int i = 0;
        while(i < tabell.length){
            int tilfeldigTall = (int)(Math.random()*900 +100);

            if (!finnesIArray(tilfeldigTall)){
                tabell[i] = tilfeldigTall;
                i++;
            }
        }
    }

    // Metoden som finner og returnerer det minste tallet i arrayet.
    private int minst(){
        int minstVerdi = tabell[0];

        for(int i = 1; i < tabell.length; i++){
            if (tabell[i] < minstVerdi){
                minstVerdi = tabell[i];
            }
        }
        return minstVerdi;
    }

    // Metoden som finner og returnerer det største tallet i arrayet.
    private int storst(){
        int storstVerdi = tabell[0];

        for(int i = 1; i < tabell.length; i++){
            if (tabell[i] > storstVerdi){
                storstVerdi = tabell[i];
            }
        }
        return storstVerdi;
    }

    /*Metoden som beregner og returnerer den gjennomsnittlige verdiern
      (double-verdien) av tallene i arrayet. */

    private double gjennomsnitt() {
        double sum = 0;
        for(int value : tabell){
            sum += value;
        }

        return sum / tabell.length;
    }

    /*Metoden som viser tallene i arrayet i en meldingsboks.
      I tillegg skal det, i meldingsboksen, skrives ut opplysninger om hvilket tall som er
      minst, hvilket som er størst, og hva som er gjennomsnittsverdien. Gjennomsnittsverdien
      skal skrives ut med en desimal. Bruk gjerne String.format("%.2f,tall") til dette.
      Legg inn mellomrom mellom tallene og skriv ut et passende antall tall per linje. */

    public void visInformasjon(){
        String utMelding = "";

        for(int i = 0; i < tabell.length; i++){
            utMelding += tabell[i] + " ";

            //Linjeskift hvert 8ende tall
            // i + 1 gjør at vi unngår å få linjeskift når i er 0 fordi 0 % 8 = 0
            if ((i + 1) % 8 == 0){
                utMelding += "\n";
            }
        }

        // Legger til et par linjeskift etter tallene
        utMelding += "\n\n";

        utMelding += "Minste tall er " + minst() + "\n"
                + "Største tall er " + storst() + "\n"
                + "Gjennomsnittsverdien er " + String.format("%.2f", gjennomsnitt()) + "\n";
        showMessageDialog(null, utMelding);
    }

}
