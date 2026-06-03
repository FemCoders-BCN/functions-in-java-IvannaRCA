import java.util.Scanner;

public class DiceJack {
    public static void main(String[] args) {
        /* 
        Reglas del juego:
        - El usuario debe escoger 3 números entre 1 y 6 (incluidos).
        - El usuario debe lanzar los dados una vez, el resultado serán 3 números aleatorios.

        ¿Cuándo gana el usuario?:
        - Cuando la suma de los números escogidos es mayor a la suma de los dados lanzados
        - Y cuando la diferencia entre los dos números anteriores es menor de 5

        ej. 
        - Usuario escoge los números: 1 3 5 (la suma es 9)
        - Usuario lanza dados y salen los números: 3 1 3 (la suma es 7)
        - 9 es mayor a 7 y la diferencia entre los dos números es menor a 5. El usuario gana.

        Requisitos no funcionales (atributos de calidad):
        - Definir las 4 funciones descritas abajo.
        - En el método main escribir el programa (usar condicionales, reusar las funciones creadas, pedir al usuario que ingrese datos y recogerlos).
        */

        // Pasos:
        //  - Pedir al usuario que escoja 3 números.
        Scanner sc = new Scanner(System.in);
        int numResult = 0;
        int rollResult = 0;
        boolean win = false;
        
        /* 1 */
        System.out.print("Iniciando Dice Jack...\n¡Hola coder! Escoge 3 números entre 1 y 6, ambos incluidos.\nPrimer número: ");
        int num1 = 0;
        if (sc.hasNextInt()) {
            num1 = sc.nextInt();
            sc.nextLine();
        } else {
            System.out.println("Debes introducir un número. Saliendo del juego...");
            System.exit(0);
        }
        
        /* 2 */
        System.out.print("Segundo número: ");
        int num2 = 0;
        if (sc.hasNextInt()) {
            num2 = sc.nextInt();
            sc.nextLine();
        } else {
            System.out.println("Debes introducir un número. Saliendo del juego...");
            System.exit(0);
        }

        /* 3 */
        System.out.print("Tercer número: ");
        int num3 = 0;
        if (sc.hasNextInt()) {
            num3 = sc.nextInt();
            sc.nextLine();
        } else {
            System.out.println("Debes introducir un número. Saliendo del juego...");
            System.exit(0);
        }
        
        numResult = num1 + num2 + num3;

        //  - Si el usuario escoge un número fuera del rango, salir del programa (mira en los recursos system exit).
        if (!isLessThanOne(num1, num2, num3) || !isHigherThanSix(num1, num2, num3)) {
            System.exit(0);            
        }

        //  - Si los números son correctos, pedir al usuario si desea lanzar dados.
        System.out.print("¿Deseas lanzar los dados? (si/no): ");
        String res = sc.nextLine();
        
        //  - Si el usuario dice que no, salir del programa.
        switch (res) {
            case "n", "no":
                System.out.println("Saliendo del juego...");
                System.exit(0);
                break;
            //  - Si el usuario dice que si, lanzar dados, hacer los cálculos que indiquen si el usuario ganó o perdió.
            case "s", "si":
                int dice1 = rollDice();
                int dice2 = rollDice();
                int dice3 = rollDice();
                rollResult = dice1 + dice2 + dice3;

                win = userWon(numResult, rollResult);

                System.out.print("Dado 1: " + dice1);
                System.out.print("\nDado 2: " + dice2);
                System.out.print("\nDado 3: " + dice3);
                
                break;
            default:
                System.out.println("Algo falló. Saliendo del juego...");
                System.exit(0);
                break;   
        }
        
        //  - Imprimir la suma de los números escogidos por el usuario y la suma de los números que salieron en los dados.
        System.out.print("\nSuma de los números: " + (numResult));
        System.out.print("\nSuma de los dados: " + rollResult);
        System.out.print("\n");
        //  - Imprimir si el usuario ganó o perdió.
        if (win) {
            System.out.println("¡Has ganado!");
        } else {
            System.out.println("Has perdido... Suerte la próxima vez :)");
        }

        sc.close();
    }


    /**
     * 
     * Function name: isLessThanOne
     * 
     * @param num1 (int)
     * @param num2 (int)
     * @param num3 (int)
     * @return (boolean)
     * 
     * Inside the function:
     * 1. check if numbers are less than 1
     */
     public static boolean isLessThanOne(int num1, int num2, int num3) {
        if ((num1 < 1) || (num2 < 1) || (num3 < 1)) {
            System.out.println("No puedes escoger números más pequeños que 1");
            return false;
        } else {
            return true;
        }
     }

    /**
     * 
     * Function name: isHigherThanSix
     * 
     * @param num1 (int)
     * @param num2 (int)
     * @param num3 (int)
     * @return (boolean)
     * 
     * Inside the function:
     * 1. Check if numbers are greater than 6
     */
     public static boolean isHigherThanSix(int num1, int num2, int num3) {
        if ((num1 > 6) || (num2 > 6) || (num3 > 6)) {
            System.out.println("No puedes escoger números más grandes que 6");
            return false;
        } else {
            return true;
        }
     }

    /**
     * 
     * Function name: userWon
     * 
     * @param sumNumbers (int)
     * @param sumDiceRolls (int)
     * @return (boolean)
     * 
     * Inside the function:
     * 1. check if user numbers are greater than computer numbers and the difference between user numbers and computer numbers are less than 5. 
     */
     public static boolean userWon(int sumNumbers, int sumDiceRolls) {
        if ((sumNumbers > sumDiceRolls) && (sumNumbers - sumDiceRolls <= 5)) {
            return true;
        } else {
            return false;
        }
     }

    /**
     * Function name: rollDice
     * 
     * @return (int)
     * 
     * Inside the function:
     * 1. get random number between 1 and 6
     */
     public static int rollDice() {
        return (int)(Math.random() * 6) + 1;
     }


}
