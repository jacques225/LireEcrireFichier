package fr.epsi.montpellier;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class GenerateIndex
{
    private String filename;
    private final List<String> identifiantsAngent = new ArrayList<>();
    public GenerateIndex(String filename)
    {
        this.filename = filename;
    }
    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename)
    {
        this.filename = filename;
    }
    public void addIdentifiant(String identifiant)
    {
        identifiantsAngent.add(identifiant);
    }


    public void generateHTML() throws Exception {
        // La taille du buffer par défaut est de 8192 caractères

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));
        bufferedWriter.write("<html lang='fr'>");
        bufferedWriter.write("<head>");
      //  bufferedWriter.write("<center>");
        bufferedWriter.write("<h1> Bienvenue Chez GO security </h1> ");
        bufferedWriter.write("<center>");
        bufferedWriter.write("<style>");
        bufferedWriter.write("body { background-color: #1c87c9;}");
        bufferedWriter.write("</style>");
        bufferedWriter.write("<body>");
        bufferedWriter.write("<img src='./AcroRd32_v8kOD3555C.png' border =3>");
        bufferedWriter.write("<center>");
        bufferedWriter.write("<h2>Liste des agents de surveillance</h2>");
        bufferedWriter.write("<center>");
        for (String agent : identifiantsAngent)
        {
            bufferedWriter.write("<a href=' "+agent+"/"+ agent + ".html'>" + agent + "</a><br />");
        }
        bufferedWriter.write("</body>");
        bufferedWriter.write("</html>");
        bufferedWriter.close();
    }
}
