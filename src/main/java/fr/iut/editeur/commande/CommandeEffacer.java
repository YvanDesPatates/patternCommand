package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

public class CommandeEffacer extends CommandeDocument{

    public CommandeEffacer(Document document, String[] parameters) {
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
            System.err.println("les arguments deux et trois doivent être des entiers\n format attendu : effacer;0;5");
            return;
        }
        if (debut > document.getTexte().length() || fin > document.getTexte().length()){
            System.err.println("les index fournis sont trop grands et dépassent la longueur du texte d'origine");
            return;
        }
        parameters = new String[]{"remplacer", parameters[1], parameters[2], ""};
        new CommandeRemplacer(document, parameters).executer();
    }
}
