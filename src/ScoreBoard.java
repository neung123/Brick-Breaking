import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreBoard {

    private String SCORE_BOARD = "data/scoreboard.txt";
    public ArrayList<Person> people = new ArrayList<>();

    public ScoreBoard(){
        readScoreBoard();
    }

    public void addPerson(Person p){
        people.add(p);
        sortByScore();
        writeScoreBoard();
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void toFive(){

        while (people.size()>5){ people.remove(people.size()-1) ;}

    }

    public void sortByScore(){

        for(int i = 0; i < people.size(); i++){
            for(int j = 0; j < people.size(); j++) {
                if (people.get(i).getScore() > people.get(j).getScore()) {
                    Person p1 = people.get(i);

                    people.set(i, people.get(j));
                    people.set(j, p1);
                }
            }
        }

        toFive();
    }


    public void readScoreBoard(){

        Scanner reader = new Scanner(ScoreBoard.class.getResourceAsStream(SCORE_BOARD));

        while (reader.hasNextLine()){

            String str = reader.nextLine();
            String[] statement = str.split(":");

            String name = statement[0].trim();
            int score = Integer.parseInt(statement[1].trim());

            Person person = new Person(name, score);

            people.add(person);

        }


    }

    public void writeScoreBoard(){


        File file = new File(SCORE_BOARD);
        FileOutputStream out = null;

        try {
            out = new FileOutputStream(file);

        } catch (FileNotFoundException e) {
            SCORE_BOARD = "src/data/scoreboard.txt";

            try {
                file = new File(SCORE_BOARD);
                out = new FileOutputStream(file);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }

        }

        PrintStream pout = new PrintStream(out);
        for(int i = 0; i < people.size(); i++) pout.println(people.get(i).toString());

        pout.close();
    }

    public boolean checkIfHigher(int score){

        if (score == 0) return false;

        if (people.size()<5) return true;

        for(Person p: people){
            if(score > p.getScore()) return true;
        }
        return false;
    }


}
