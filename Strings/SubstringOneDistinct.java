package Strings;

public class SubstringOneDistinct {
  public static int subs(String str){
    int count = 1;
    int sum = 1;
    for(int i=1; i<str.length(); i++){
      if(str.charAt(i) == str.charAt(i-1)){
        count++;
      } else {
        count = 1;
      }
      sum+=count;
    }
    return sum;
  }
  public static void main(String[] args) {
    System.out.println(subs("hellloooo"));;
  }
}
