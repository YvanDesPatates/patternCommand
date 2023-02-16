package fr.iut.editeur.commande.invoker;

import fr.iut.editeur.commande.CommandeDocument;
import fr.iut.editeur.commande.CommandeRemplacer;
import fr.iut.editeur.document.Document;

public class CommandeMajuscule extends CommandeDocument {

    public CommandeMajuscule(Document document, String[] parameters) {
        super(document, parameters);
    }

    @Override
    public void executer() {
        int debut, fin;
        try {
            debut = Integer.parseInt(parameters[1]);
            fin = Integer.parseInt(parameters[2]);
        }
        catch (NumberFormatException e){
            System.err.println("les arguments deux et trois doivent être des entiers\n format attendu : majuscule;0;5");
            return;
        }
        if (debut > document.getTexte().length() || fin > document.getTexte().length()){
            System.err.println("les index fournis sont trop grands et dépassent la longueur du texte d'origine");
            return;
        }
        String newText = document.getTexte().substring(debut, fin).toUpperCase();
        parameters = new String[]{"remplacer", parameters[1], parameters[2], newText};
        new CommandeRemplacer(document, parameters).executer();
    }
}
