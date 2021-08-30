package fr.epsi.montpellier;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class GenerateFicheAgent {
    private String filename;
    private String agent;
    private final List<String> identifiantsAgent = new ArrayList<>();
    private final List<String> ListeEquip = new ArrayList<>();

    public GenerateFicheAgent(String filename) {
        this.filename = filename;

    }

    public GenerateFicheAgent() {
        this.filename = filename;
    }


    public String getFilename()
    {
        return filename;
    }

    public void setFilename(String filename)
    {
        this.filename = filename;
    }

    public void addAgent(String Agent)
    {
        identifiantsAgent.add(Agent);
    }
    public void addOutils(String Outils) {ListeEquip.add(Outils);}

    public void generateHTML() throws Exception
    {
        // La taille du buffer par défaut est de 8192 caractères
        BufferedWriter Ecriture = new BufferedWriter(new FileWriter(filename));
        Ecriture.write("<html lang='fr'>");
        Ecriture.write("<body>");
       for ( String agent : identifiantsAgent)
       {
          // data ='./"+agent+".txt'
          // Ecriture.write("<object class='left' width='225' height='150' alt='' title='' style='float:left;margin:0 10px 0 20px;' data='./"+agent+".txt'/>");
           Ecriture.write("<center>");
           Ecriture.write("<img src='./"+agent+".png' >");
       }
       // Ecriture.write("img { class='right' border =3 width='225' height='150' alt='' title='' style='float:right;margin:0 10px 0 20px;'}");

        //Ecriture.write("<center>");
        Ecriture.write("<style>");
        Ecriture.write("body{ background-color: #1c87c9;}");
        Ecriture.write("</style>");
       // Ecriture.write("<center>");
        Ecriture.write("<h2>  Liste des equipement emprunter </h2>");
    //  Ecriture.write("<object border =3 style='float:middle;margin:250 10px 0 300px;' data= ./liste.txt/>");
        String Filename = "./liste.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(Filename));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            Ecriture.write("<div>");
            Ecriture.write("<input type='checkbox' id='" + line + "' name='" + line + "' >");
            Ecriture.write("<label for='" + line + "' >" + line + "</label>");
            Ecriture.write("</div>");
        }
        Ecriture.write("</body>");
        Ecriture.write("</html>");

        //Ecriture.write("<input type ='checkbox' id='test' name='' checked>");
        Ecriture.close();
    }
}
