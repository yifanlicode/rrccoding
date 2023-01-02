/*
 * Name: YifanLi
 * Program: Full Stack Web Development
 * Course: WEBD-1009 Programming 1
 * Created: 2022-10-12
 * Updated: 2022-10-12
 */          


import java.util.Scanner;

public class SentencesType {
    public static void main(String[] args) {


        // reads a sentence from the keyboard.

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a sentence complete with punctuation:\n ");
        String sentence = keyboard.nextLine();

        
        //The sentence is {sentence type}
        String lastChar = sentence.substring(sentence.length() - 1);
        String sentenceType;

        switch (lastChar)
        {
            case ".":
                sentenceType = "declarative";
                break;
            case "?":
                sentenceType = "interrogative";
                break;
            case "!":
                sentenceType = "imperative";
                break;
            default:
                sentenceType = "other";
                break;
        }

        // print the sentence type
        System.out.printf("The sentence is %s ", sentenceType );
    }
}






