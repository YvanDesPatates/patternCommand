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
            return;
        }

        int debut, fin;
        try {
            debut = Integer.parseInt(parameters[1]);
            fin = Integer.parseInt(parameters[2]);
        }
        catch (NumberFormatException e){
            System.err.println("les arguments deux et trois doivent être des entiers\n format attendu : remplacer;0;5;nouveau texte");
            return;
        }
        if (debut > document.getTexte().length() || fin > document.getTexte().length()){
            System.err.println("les index fournis sont trop grands et dépassent la longueur du texte d'origine");
            return;
        }

        document.remplacer(debut, fin, parameters[3]);
        super.executer();
    }
}
