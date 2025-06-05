public class Main {

   public static void main(String[] args) {

      String firstName = "Harry";
      String lastName = "Potter";
      String fullName = firstName + " " + lastName;
      System.out.println("Full name: " + fullName);
      System.out.println("Length: " + fullName.length());
      System.out.println("First Character: " + fullName.charAt(0));
      System.out.println("Index of 'r': " + fullName.indexOf('r'));

      String sentence = "Learning Java is fun!";
      System.out.println("First word: " + sentence.substring(0, 8));
      System.out.println("Second word: " + sentence.substring(9, 13));
      System.out.println("Last word: " + sentence.substring(17));

      String csvData = "apple,banana,grape,orange";
      String[] fruits = csvData.split(",");
      for (int i = 0; i < fruits.length; i++) {
         System.out.println("Fruit " + (i + 1) + ":" + fruits[i]);
      }

      String sentence2 = "The quick brown fox";
      sentence2 = sentence2.replace("quick", "slow").replace(" ", "_");
      System.out.println("Modified sentence: " + sentence2);

      String sentence3 = "The quick brown fox";
      System.out.println("Modified sentence: " + sentence3.replace("quick", "slow").replace(" ", "_"));

      String newStr = null;
      if (newStr == null) {
         System.out.println("The string is null, cannot compute length.");
      } else {
         System.out.println("Length of string: " + newStr.length());
   }

   String empStr = "";
      System.out.println("Empty string length: " + empStr.length());




    }
}
