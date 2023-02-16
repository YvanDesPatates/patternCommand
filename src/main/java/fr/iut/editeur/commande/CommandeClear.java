package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

public class CommandeClear extends CommandeDocument{

    public CommandeClear(Document document, String[] parameters) {
        super(document, parameters);
    }

    @Override
    public void executer() {
        String end = String.valueOf(document.getTexte().length());
        new CommandeEffacer(document, new String[]{"effacer", "1", end}).executer();
    }
}
