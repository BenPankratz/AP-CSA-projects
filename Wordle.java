import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;



class Main {
  public static void main(String[] args) {
    // create an arrayList of allTheWords
    ArrayList<String> allTheWords = importFile("englishwords.txt");
    String[][] guesses = new String[12][5];
    int row = 0;
    System.out.print("Guess a 5 letter word:");
    String answer = fiveLetterWord(allTheWords).toUpperCase();
    Scanner keyboard = new Scanner(System.in);
    String[] letters = new String[26];
    for(int i = 0; i < 26; i++){
      letters[i] = "" + (char)(97 + i);
      letters[i] = letters[i].toUpperCase();
}
    for(int i=0; i<guesses.length; i+=2){
      Fill(letters, answer,  row, guesses, keyboard, allTheWords);
      row += 2;
    }
    }


public static String fiveLetterWord(ArrayList<String> allTheWords){
  ArrayList<String> words = new ArrayList<String>();
  for(String word : allTheWords){
    if(word.length() == 5){
      words.add(word);
    }
  }
  return words.get((int)(Math.random() * words.size() + 1));
}

public static void Fill(String[] letters, String answer, int row, String[][] guesses, Scanner keyboard, ArrayList<String> words){
  String guess = keyboard.nextLine();
  Boolean check = check(guess, words);
  while(!check){
    System.out.print("Not a real word, Guess again: ");
    guess = keyboard.nextLine();
    check = check(guess, words);
  }  
  System.out.print("|");
  for(int i=0; i<guess.length(); i++){
    guesses[row][i]=guess.substring(i, i+1);
    System.out.print(guesses[row][i]);
    for(int j=0; j<letters.length; j++){
      if(letters[j].equals(guesses[row][i])){
        letters[j] = "#";
      }
    }
    }
  row ++;
  System.out.println("|");
  String hints = check(guess, answer);
  System.out.print("|");
  for(int k=0; k<hints.length(); k++){
    guesses[row][k]=hints.substring(k, k+1);
    System.out.print(guesses[row][k]);
    }
  row ++;
  System.out.println("|");
  Print(letters);
  if(answer.equals(guess)){
    System.out.println("Game over, you win. Great job");
    }else if(row<11){
    System.out.print("Guess again:");
    }else{
    System.out.println("Game Over, You Lose");
    }
  
}

public static boolean check(String g, ArrayList<String> w){
  boolean check = false;
  for(int i=0; i<w.size(); i++){
    if(w.get(i).equals(g.toLowerCase())){
      check = true;
    }
  }
  return check;
}
  
public static String check(String guess, String word){
  String hints = "";
  for(int i=0; i<5; i++){
    if(guess.charAt(i) == word.charAt(i)){
      hints += "*";
    }else if(guess.charAt(i) == word.charAt(0) || guess.charAt(i) == word.charAt(2) || guess.charAt(i) == word.charAt(2) || guess.charAt(i) == word.charAt(3) || guess.charAt(i) == word.charAt(4)){
      hints += "@";
    }else{
      hints += "x";
    }
  }
  return hints;
}

public static void Print(String[] x){
  System.out.print("Letters left: ");
  for(int i=0; i<x.length; i++){
    System.out.print(" " + x[i]);
  }
  System.out.println();
}


  
  public static ArrayList<String> importFile(String fileName){
    ArrayList<String> words = new ArrayList<>();
    try {
      File myObj = new File(fileName);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        words.add(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return words;
  }
}
