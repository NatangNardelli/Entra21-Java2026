package For;
public class aulafor {
    public static void main(String[] args) {
        int soma = 0;
        for (int i = 1; i <= 5; i++) {
            soma += i;
            System.out.println("Número: " + i);
        }
        System.out.println("Soma: " + soma);
    }
}