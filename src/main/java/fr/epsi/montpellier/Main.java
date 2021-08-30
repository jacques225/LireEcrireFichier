package fr.epsi.montpellier;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main
{

    public static void main(String[] args)

    {

        ListEequip("./liste.txt");
        read("./staff.txt");
        readAgent("./staff.txt");


    }

    private static void ListEequip(String Filename)
    {
        try
        {
            GenerateFicheAgent Liste = new GenerateFicheAgent();
            // Nom du fichier (ici sous Linux)
            // Ouverture du buffer de lecture lié au fichier
            BufferedReader bufferedReader = new BufferedReader(new FileReader(Filename));
            // Lecture du fichier
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                Liste.addOutils(line);
                System.out.println("Outils = " + line);
            }
            // Fermeture
            bufferedReader.close();
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

                                                    //    Creation HTML agent
    private static void read(String fileName) {
        try {
            // Ouverture du fichier
            FileInputStream fileInputStream = new FileInputStream(fileName);
            // Ouverture du flux lié au fichier en UTF_8
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            // Ouverture du buffer de lecture lié au flux précédent
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // Création du fichier HTML
            GenerateIndex indexHTML = new GenerateIndex("./index.html");


            // Lecture du fichier
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                indexHTML.addIdentifiant(line);

            }


            //Fermeture
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();

            //Génération du fichier HTML
            indexHTML.generateHTML();

            //FicheAgent.generateHTML();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


                                        //    Creation HTML agent
    private static void readAgent(String fileNameAgent)
    {
        try {
            // Ouverture du fichier
            FileInputStream fileInputStream = new FileInputStream(fileNameAgent);
            // Ouverture du flux lié au fichier en UTF_8
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            // Ouverture du buffer de lecture lié au flux précédent
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


            String tours;
            while ((tours = bufferedReader.readLine()) != null) {

                GenerateFicheAgent ficheAgent = new GenerateFicheAgent("./" + tours + "/" + tours + ".html");
                ficheAgent.addAgent(tours);
                ficheAgent.generateHTML();
            }

            //Fermeture
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();


            //FicheAgent.generateHTML();
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception)
        {
            exception.printStackTrace();
        }

        // lecture du fichier liste .txt

    }


}
