package Building;

import Person.Person;
import Person.Walking;
import Player.Bot;
import Player.MyPlayer;
import Utils.ConsoleColors;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Academy extends Building{

    public Academy(int stone, int wood){
        super(stone, wood);
    }

    private ArrayList<Person> persAcademy = new ArrayList<>();

    public ArrayList<Person> getPersAcademy() {
        return persAcademy;
    }
    @Override
    public void welcome(boolean who) {
        System.out.println(ConsoleColors.CYAN_BOLD + "\t\tWelcome to the Academy! Enter the characteristics via enter" + ConsoleColors.RESET);
        int up;
        System.out.println("Health Attack AttackRange Defense Steps");
        int health = 0;
        int attack = 0;
        int rangeAttack = 0;
        int defense = 0;
        int steps = 0;
        if (who) {
            Scanner in = new Scanner(System.in);
            health = Integer.parseInt(in.nextLine());
            attack = Integer.parseInt(in.nextLine());
            rangeAttack = Integer.parseInt(in.nextLine());
            defense = Integer.parseInt(in.nextLine());
            steps = Integer.parseInt(in.nextLine());
        } else {
            Random r = new Random();
            health = r.nextInt(100);
            attack = r.nextInt(100);
            rangeAttack = r.nextInt(100);
            defense = r.nextInt(10);
            steps = r.nextInt(100);
            System.out.println(ConsoleColors.CYAN_BOLD + health + "\t" + attack + "\t" + rangeAttack + "\t" + defense + "\t" + steps + "\t" + (attack/10) + ConsoleColors.RESET);
        }
        persAcademy.add(new Walking(health, attack, rangeAttack, defense, steps, (attack/10), 0, 0, "N"));
    }
    public void catalog(){
        if (!persAcademy.isEmpty()) {
            System.out.println("New type by Academy:\t");
            for (int i = 0; i< persAcademy.size(); i++){
                System.out.print((i+11) + "\t" + persAcademy.get(i).getNum() + "\t");
                System.out.print(persAcademy.get(i).getHealth() + "\t");
                System.out.print(persAcademy.get(i).getAttack() + "\t");
                System.out.print(persAcademy.get(i).getRangeAttack() + "\t");
                System.out.print(persAcademy.get(i).getDefence() + "\t");
                System.out.print(persAcademy.get(i).getSteps() + "\t");
                System.out.print(persAcademy.get(i).getPrice() + "\n");
            }
        }
    }
    @Override
    public void save(FileWriter nFile) throws IOException {
        nFile.write("Academy" + "\t" + getLevel() + "\t");
        for (Person pers : persAcademy) {
            nFile.write(pers.getNum() + "\t" +
                    pers.getHealth() + "\t" + pers.getAttack() + "\t" +
                    pers.getRangeAttack() + "\t" + pers.getDefence() + "\t" +
                    pers.getSteps() + "\t" + pers.getPrice());
        }
    }
    public void load(Scanner scan){

    }
    public void setLevel(){}
}
