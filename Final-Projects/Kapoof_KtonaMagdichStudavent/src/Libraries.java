import java.util.InputMismatchException;

/*
* Name: Adam Ktona, Tyler Magdich, Deshawn Studavent
* Description: Helpful methods to simplify code
*/
public class Libraries {
    public static void displayHeader(String input) {
        System.out.print("/---------------------* " + input + " *---------------------\\\n");
    }
    
    public static double currencyRound(double input) {
        Math.round((input * 100) / 100.0);
        return input;
    }
    
    public static void displayLogo() {
        // Credit: http://www.patorjk.com/software/taag/#p=display&f=Crazy&t=KAPOOF!
        
        System.out.println("-=---=--=---=--=---=--=---=--=---=--=---=--=---=--=---=--=---=--=---=--=---=--=---=--=---=--=---=-\n");
        System.out.println("                                                    .-\'\'\'-.        .-\'\'\'-.               ___   ");
        System.out.println("                                                   \'   _    \\     \'   _    \\          .\'/   \\  ");
        System.out.println("     .                  _________   _...._       /   /` \'.   \\  /   /` \'.   \\        / /     \\ ");
        System.out.println("   .\'|                  \\        |.\'      \'-.   .   |     \\  \' .   |     \\  \'   _.._ | |     | ");
        System.out.println(" .\'  |                   \\        .\'```\'.    \'. |   \'      |  \'|   \'      |  \'.\' .._|| |     | ");
        System.out.println("<    |            __      \\      |       \\     \\\\    \\     / / \\    \\     / / | \'    |/`.   .\' ");
        System.out.println(" |   | ____    .:--.\'.     |     |        |    | `.   ` ..\' /   `.   ` ..\' /__| |__   `.|   |  ");
        System.out.println(" |   | \\ .\'   / |   \\ |    |      \\      /    .     \'-...-\'`       \'-...-\'`|__   __|   ||___|  ");
        System.out.println(" |   |/  .    `\" __ | |    |     |\\`\'-.-\'   .\'                                | |      |/___/  ");
        System.out.println(" |    /\\  \\    .\'.\'\'| |    |     | \'-....-\'`                                  | |      .\'.--.  ");
        System.out.println(" |   |  \\  \\  / /   | |_  .\'     \'.                                           | |     | |    | ");
        System.out.println(" \'    \\  \\  \\ \\ \\._,\\ \'/\'-----------\'                                         | |     \\_\\    / ");
        System.out.println("\'------\'  \'---\'`--\'  `\"                                                       |_|      `\'\'--\'  ");
        System.out.println("\n-=---=--=---=--=---=--=---=--=---=--=---=--=---=--=---=--=---=--=---=--=---=--=---=--=---=--=---=-\n\n");
    }
}
