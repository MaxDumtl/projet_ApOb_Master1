package ui;

import application.*;
import domain.*;
import infrastructure.*;

import java.util.Scanner;

public class TerminalTextUI {

    //OK : on cree un bag
    //OK : on cree un service on lui passe le bag aveec le constructeur
    //OK : on cree le worker et on lui psse le bag via constrcuteur
    //OK : on lance le worker.run
    //on boucle infinie sur service pour le manipuler (dans this.run() )
    //  \_ le worker tournera et executera les commmandes

    private BagOfCommands bagOfCommands;
    private RoomService roomService;
    private Worker worker;

    private RoomRepository roomRepository;

    private boolean done = false;

    public TerminalTextUI(RoomRepository roomRepository) {
        //TODO
        this.roomRepository = roomRepository;
    }

    public void run(){
        // initialize/load the application and domain
        intializeApplication();

        System.out.println("--- Gestionnaire de salle d'évènement de JoliCité ---");

        showPrincipalAction();

        //run the worker
        this.worker.run();

        //read the console and execute principal action with a loop
        while (!done) {
            executePrincipalCommand();
        }

    }

    private void executePrincipalCommand() {
        //read the "command" in the terminal
        Scanner scanner = new Scanner(System.in);//Scanner to read the console
        String line = scanner.nextLine();

        //switch to know what action to do
        switch(line){
            case "1": // Afficher le calendrier de la semaine
                //TODO
                int entry = 0;
                Scanner scannerWeek = new Scanner(System.in);

                System.out.println("Rentrez le numéro de semaine que vous souhaitez afficher");
                String lineWeek = scannerWeek.nextLine();
                entry = Integer.parseInt(lineWeek);
                
                while(entry < 1 || entry > 4){
                    System.out.println("Votre saisie est invalide veuillez recommencer");
                    
                    lineWeek = scannerWeek.nextLine();
                    entry = Integer.parseInt(lineWeek);
                }

                affichWeekProgram(2021, 11, entry);
                break;
            case "2": // Afficher un jour
                //TODO
                break;
            case "3": // Creer un évènement
                //TODO
                break;
            case "4": // Associer un évènement à un jour
                //TODO
                break;
            case "5": // Retirer un évènement à un jour
                //TODO
                break;

            case "aide": // Afficher la liste des commandes
                showPrincipalAction();
                break;

            case "stop":
                this.done = true;
                break;

            default:
                System.out.println("Action non reconnu, réessayer !");
                showPrincipalAction();
                break;
        }
    }

    private void showPrincipalAction() {
        System.out.println("> Liste des actions");
        System.out.println("1) Afficher le calendrier de la semaine");
        System.out.println("2) Afficher un jour");
        System.out.println("3) Creer un évènement");
        System.out.println("4) Associer un évènement à un jour");
        System.out.println("5) Retirer un évènement à un jour");
        System.out.println("aide) Affiche la liste des commandes");
    }

    private void intializeApplication() {
        this.bagOfCommands = new BagOfCommands();
        this.roomService = new RoomService(this.bagOfCommands);
        this.worker = new Worker(this.bagOfCommands);
    }

    private void affichWeekProgram(int year, int month, int numWeek){
        System.out.println("==================================================================================");
         
        for(int i = 0; i < roomRepository.getNumRoom(); i++){
            roomRepository.findByDay(i, year, month, numWeek);
        }
        
        
        System.out.println("==================================================================================");
    }
}
