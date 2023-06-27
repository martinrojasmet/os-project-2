package classes;

/**
 *
 * @author samer
 */
public class Utils {
    // AI constants
    public static String waitingStatus = "Esperando";
    public static String decidingStatus = "Decidiendo";
    public static String announcingStatus = "Anunciando resultado";
    
    public static double winProbability = 0.4;
    public static double drawProbability = 0.27;
    public static double notAbleToRaceProbability = 0.33;
    
    public static String win = "Ganador";
    public static String draw = "Empate";
    public static String notAbleToRace = "No se realizó la carrera";
    
    // Vehicle constants
    public static int bodyworkProbability = 60;
    public static int chasisProbability = 70;
    public static int motorProbability = 50;
    public static int wheelProbability = 40;
    
    // Administrator constants
    public static double addNewVehicleProbability = 0.8;
    public static double leaveReinforcementQueueProbability = 0.4;    
    public static int counterVehicle = 8;
    public static int revisionCycles = 2;
}
