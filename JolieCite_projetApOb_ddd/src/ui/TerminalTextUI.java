package ui;

public class TerminalTextUI {

    public TerminalTextUI() {
    }

    public void run(){
        // initialize/load the application and domain

        System.out.println("--- Gestionnaire de salle d'évènement de JoliCité ---");

        showPrincipalAction();

        //get the terminal command
        //TODO ...
        int commandNumber = 0;

        //switch to know what to do
        switch(commandNumber){
            case 1:
                //TODO
                break;
            case 2:
                //TODO
                break;
            case 3:
                //TODO
                break;
            case 4:
                //TODO
                break;
            case 5:
                //TODO
                break;

            default:
                //TODO something ?
                System.out.println("Action non reconnu, réessayer !");
                showPrincipalAction();
        }
    }

    private void showPrincipalAction() {
        System.out.println("> Liste des actions");
        System.out.println("1) Afficher le calendrier de la semaine");
        System.out.println("2) Afficher un jour");
        System.out.println("3) Creer un évènement");
        System.out.println("4) Associer un évènement à un jour");
        System.out.println("5) Retirer un évènement à un jour");
    }
}
