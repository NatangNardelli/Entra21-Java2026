package For;

public class numeros {
    public static void main(String[] args) {

        System.out.println("Numero Pares de 1 a 10: ");
        for (int i = 1; i <= 10; i++) {

            if (i % 2 == 0) {
                System.out.println(i);

            }
        }
        System.out.println("\nNumeros Impares de 1 a 10: ");
        for (int b = 1; b <= 10; b++) {

            if (b % 2 != 0) {
                System.out.println(b);

            }

        }
        System.out.println("\nSoma dos Numeros de 1 a 10: ");
        int soma = 0;
        for (int i = 0; i <= 10; i++) {
            soma += i;
            System.out.println("Número: " + i);
        }
        System.out.println("Soma: " + soma);

    }
}
