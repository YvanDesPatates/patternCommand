package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

public class CommandeRemplacer extends CommandeDocument {

    public CommandeRemplacer(Document document, String[] parameters) {
        super(document, parameters);
    }

    @Override
    public void executer() {
        if (parameters.length < 4) {
            System.err.println("format attendu : remplacer;0;5;nouveau texte");
        }
        try {
            int debut = Integer.parseInt(parameters[1]);
            int fin = Integer.parseInt(parameters[2]);
            document.remplacer(debut, fin, parameters[3]);
        }
        catch (NumberFormatException e){
            System.err.println("les arguments deux et trois doivent être des entiers\n format attendu : remplacer;0;5;nouveau texte");
        }

    }
}
