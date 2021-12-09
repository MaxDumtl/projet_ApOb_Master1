package ui;

import application.*;
import domain.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Set;

import javax.sound.sampled.SourceDataLine;

public class TerminalTextUI {

    private BagOfCommands bagOfCommands;
    private RoomService roomService;
    private Worker worker;

    private RoomRepository roomRepository;

    private boolean done = false;

    public TerminalTextUI(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public void run(){
        // initialize/load the application and domain
        intializeApplication();

        System.out.println("--- Gestionnaire de salle d'évènement de JoliCité ---");

        showPrincipalAction();

        //run the worker
        Thread thread = new Thread(this.worker, "Worker thread");
        thread.start();

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

                showWeekProgram(2021, 11, entry);
                break;
            case "2": // Afficher un jour
                int weekNumber = 0;
                int dayNumber = 0;
                scannerWeek = new Scanner(System.in);

                System.out.println("Rentrez le numéro de semaine que vous souhaitez sélectionner");
                lineWeek = scannerWeek.nextLine();
                weekNumber = Integer.parseInt(lineWeek);
                System.out.println("Rentrez le numéro du jour que vous souhaitez afficher (1 = lundi, ..., 7 = dimanche)");
                lineWeek = scannerWeek.nextLine();
                dayNumber = Integer.parseInt(lineWeek) - 1;//TODO debugg and check if it correctly to the good day number

                showDayProgram(2021, 11, dayNumber);
                break;

            case "3": // Afficher la liste des événements
                showEvents();
                break;
            
            case "4": // Afficher la liste des salles
                showRooms();
                break;

            case "5": // Associer un évènement à un jour
                //TODO
                int maxIdEvent = this.roomRepository.getNumEvent();
                Scanner scannerEventHour = new Scanner(System.in);
                               
                int hourEvent = 0;
                int eventNumber = 0;
                
                System.out.println("Rentrez le numéro de l'événement que vous voulez programmer");
                String lineEvent = scannerEventHour.nextLine();
                eventNumber = Integer.parseInt(lineEvent);
                
                while(eventNumber < 1 || eventNumber > maxIdEvent){
                    System.out.println("L'événement que vous avez saisi est invalide veuillez recommencer");
                    
                    lineEvent = scannerEventHour.nextLine();
                    eventNumber = Integer.parseInt(lineEvent);
                }

                System.out.println("Rentrez l'heure à laquelle vous voulez programmer votre événement au formet 24h");
                String lineHour = scannerEventHour.nextLine();
                hourEvent = Integer.parseInt(lineHour);
                
                while(hourEvent < 1 || hourEvent > 24){
                    System.out.println("L'heure que vous avez saisie est invalide veuillez recommencer");
                    
                    lineHour = scannerEventHour.nextLine();
                    hourEvent = Integer.parseInt(lineHour);
                }

                addEventToRoom(eventNumber, hourEvent);
                System.out.println("L'événement " + eventNumber + " à été programmé");
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

    private void showEvents() {
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd/MMMM/yyyy");
        Set<Event> listEvents = this.roomRepository.getEvents();
        
        System.out.println("************************************************************************************************************************************************");
        System.out.println("Liste des événements****************************************************************************************************************************");
        System.out.println("************************************************************************************************************************************************");

        for(Event currentEvent : listEvents){
            if(currentEvent instanceof Concert){
                Concert currentConcert = (Concert)currentEvent;
                System.out.println("("+currentConcert.getId()+") Concert | Artiste : " + currentConcert.getArtist().getName() + " -  Date : " + dayFormat.format(currentConcert.getDate().getTime()) + " -  Capacité : " + currentConcert.getCapacity());
            }
            else{
                PieceTheatre currentPiece = (PieceTheatre)currentEvent;
                System.out.println("("+currentPiece.getId()+") Pièce de Théatre | Nom : " + currentPiece.getTitle() + " -  Dates : du " + dayFormat.format(currentPiece.getBeginDate().getTime()) +"-"+ dayFormat.format(currentPiece.getEndingDate().getTime())  + " -  Capacité : " + currentPiece.getCapacity());
            }
        }

        System.out.println("************************************************************************************************************************************************");
    }

    private void showRooms() {
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd/MMMM/yyyy");
        Set<Room> listRoom = this.roomRepository.getRooms();
        
        System.out.println("************************************");
        System.out.println("Liste des salles********************");
        System.out.println("************************************");

        for(Room currentRoom : listRoom){
            System.out.println("(" + currentRoom.getId() + ") " + currentRoom.getName() + " -  Capacité : " + currentRoom.getCapacity());
        }

        System.out.println("************************************");

    }

    private void showPrincipalAction() {
        System.out.println("> Liste des actions");
        System.out.println("1) Afficher le calendrier de la semaine");
        System.out.println("2) Afficher un jour");
        System.out.println("3) Afficher la liste des événements");
        System.out.println("4) Afficher la liste des salles");
        System.out.println("5) Programmer un événement");
        System.out.println("aide) Affiche la liste des commandes");
    }

    private void intializeApplication() {
        this.bagOfCommands = new BagOfCommands();
        this.roomService = new RoomService(this.bagOfCommands);
        this.worker = new Worker(this.bagOfCommands);
    }

    private void showWeekProgram(int year, int month, int numWeek){
        System.out.println("==================================================================================");
        for (int i = 0; i < 7; i++) {
            // showDayProgram(year, month, i);
        }
        System.out.println("==================================================================================");
    }

    private void showDayProgram(int year, int month, int day){
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE /dd/MMMM/yyyy");
        SimpleDateFormat eventFormat = new SimpleDateFormat("HH : mm");

        Calendar searchedDay = new GregorianCalendar(year, month - 1, day);
        System.out.println(dayFormat.format(searchedDay.getTime()));
        System.out.println("=================================================================");

        for(int i = 0; i < roomRepository.getNumRoom(); i++){
            Set<Event> eventsForThisDay = roomRepository.findByDay(i, year, month, day);

            System.out.println("---");
            System.out.print(roomRepository.findById(i).getName() + " : ");
            for(Event currentEvent : eventsForThisDay){
                System.out.print("[ " + eventFormat.format(currentEvent.getProgrammedDay().getTime()) + " ]");
            }
            System.out.println("---");
        }
    }

    public void addEventToRoom(int idEvent, int hourEvent){
        this.bagOfCommands.pushCommand(new CommandAddEventToRoom(this.roomRepository, idEvent, hourEvent));
    }
}
