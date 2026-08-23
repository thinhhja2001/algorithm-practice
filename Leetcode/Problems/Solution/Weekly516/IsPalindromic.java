package Weekly516;

public class IsPalindromic {

  public static String toBinaryString(Character c) {
    int number = (int) c;
    int paddingLength = 8;
    String binaryStr = Integer.toBinaryString(number);
    return String.format("%" + paddingLength + "s", binaryStr).replace(' ', '0');
  }

  public static boolean isPalindromic(String s) {
    StringBuilder sb = new StringBuilder();
    for(Character c: s.toCharArray()){
      String str = toBinaryString(c);
      sb.append(str);
    }

    for(int i=0;i<sb.length()/2;i++){
      if(sb.charAt(i)!=sb.charAt(sb.length()-1-i)){
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String s = "abccba";
    System.out.println(isPalindromic(s));
  }
}
