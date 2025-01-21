package DivideNConquer;

import java.util.Scanner;

public class CalculatePower {
  public static int calculatePower(int base, int exp) {
    if (exp == 0) {
      return 1;
    }
    int temp = calculatePower(base, exp / 2);
    // If the exponent is even
    if (exp % 2 == 0) {
      return temp * temp;
    } else {
      if (exp > 0) {
        // If the exponent is positive
        return base * temp * temp;
      } else {
        // If the exponent is negative
        return (temp * temp) / base;
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the base: ");
    int base = sc.nextInt();
    System.out.println("Enter the exponent: ");
    int exp = sc.nextInt();
    System.out.println("Power: " + calculatePower(base, exp));
    sc.close();
  }
}
