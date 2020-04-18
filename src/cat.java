import java.lang.Math;
import java.util.Scanner;
public class cat {
    public static void main(String[] args){
        String ofk, name = "1", breed = "2", name2 = "3", breed2 = "4", a;
        boolean pass1, pass2, pass3, pass4, pass5, pass6;
        int max = 2;
        int min = 1;
        int player, number_player, number;
        int range = max - min + 1;
        Scanner in = new Scanner(System.in);
        pass3 = true;
        System.out.print("\n"+"Rules of the game:" + "\n" +
                "Home cat: must earn 50 money, or 100 happiness" + "\n" +
                "Street cat: must save world, for this street cat must hate 50 people" + "\n" +
                "But - 1 happiness of a home's cat reduces 1 hate street's cat" + "\n" +
                "And street's cat must Thief Home's cat money, and" + "\n" +
                "if Home's cat has less than 0 money, he's loser " + "\n" +
                "Now you choose a cat and dream his name and breed, after this " + "\n"+
                "You choose quantity players (1 or 2)" + "\n"+ "\n"+
                "Choose a cat, pls, \"1\" - Home's cat, \"2\" - Street cat " + "\n");
        do {
            player = in.nextInt();
            a = in.nextLine();
            if (player == 1) {
                do {
                    System.out.println("Player 1: Enter your cat's name and, after press \"Enter\", enter breed and press \"Enter\"");
                    name = in.next();
                    a = in.nextLine();
                    breed = in.next();
                    a = in.nextLine();
                    Home_cats first = new Home_cats(name, breed);
                    first.display();
                    do {
                        System.out.println("\n" + "This is your input data, isn't it? Please press y(yes) or n(no), and press \"Enter\"");
                        ofk = in.nextLine();
                        if (ofk.equals("y")) {
                            pass1 = true;
                            pass2 = true;
                        } else if (ofk.equals("n")) {
                            pass1 = false;
                            pass2 = true;
                        } else {
                            System.out.println("Your not pressed \"y\" or \"n\", pls press again");
                            pass1 = false;
                            pass2 = false;
                        }
                    } while (pass2 == false);

                } while (pass1 == false);
                do {
                    System.out.println("Player 2: Enter your cat's name and, after press \"Enter\", enter breed and press \"Enter\"");
                    name2 = in.next();
                    a = in.nextLine();
                    breed2 = in.next();
                    a = in.nextLine();
                    Street_cats second = new Street_cats(name2, breed2);
                    second.display();
                    do {
                        System.out.println("\n" + "This is your input data, isn't it? Please press y(yes) or n(no), and press \"Enter\"");
                        ofk = in.nextLine();
                        if (ofk.equals("y")) {
                            pass1 = true;
                            pass2 = true;
                        } else if (ofk.equals("n")) {
                            pass1 = false;
                            pass2 = true;
                        } else {
                            System.out.println("Your not pressed \"y\" or \"n\", pls press again");
                            pass1 = false;
                            pass2 = false;
                        }
                    } while (pass2 == false);

                } while (pass1 == false);
                pass4 = true;
            } else if (player == 2) {
                do {
                    System.out.println("Player 1: Enter your cat's name and, after press \"Enter\", enter breed and press \"Enter\"");
                    name2 = in.next();
                    a = in.nextLine();
                    breed2 = in.next();
                    a = in.nextLine();
                    Street_cats second = new Street_cats(name2, breed2);
                    second.display();
                    do {
                        System.out.println("\n" + "This is your input data, isn't it? Please press y(yes) or n(no), and press \"Enter\"");
                        ofk = in.nextLine();
                        if (ofk.equals("y")) {
                            pass1 = true;
                            pass2 = true;
                        } else if (ofk.equals("n")) {
                            pass1 = false;
                            pass2 = true;
                        } else {
                            System.out.println("Your not pressed \"y\" or \"n\", pls press again");
                            pass1 = false;
                            pass2 = false;
                        }
                    } while (pass2 == false);
                } while (pass1 == false);
                do {
                    System.out.println("Player 2: Enter your cat's name and, after press \"Enter\", enter breed and press \"Enter\"");
                    name = in.next();
                    a = in.nextLine();
                    breed = in.next();
                    a = in.nextLine();
                    Home_cats first = new Home_cats(name, breed);
                    first.display();
                    do {
                        System.out.println("\n" + "This is your input data, isn't it? Please press y(yes) or n(no), and press \"Enter\"");
                        ofk = in.nextLine();
                        if (ofk.equals("y")) {
                            pass1 = true;
                            pass2 = true;
                        } else if (ofk.equals("n")) {
                            pass1 = false;
                            pass2 = true;
                        } else {
                            System.out.println("Your not pressed \"y\" or \"n\", pls press again");
                            pass1 = false;
                            pass2 = false;
                        }
                    } while (pass2 == false);
                    pass4 = true;

                } while (pass1 == false);
            } else {
                System.out.println("Your not pressed \"1\" or \"2\", pls press again");
                pass4 =false;
            }
        }while(pass4 == false);
        do {
            System.out.println("choose quantity players (1 or 2), \"1\" - 1 player, \"2\" - 2 players");
            number_player = in.nextInt();
            if (number_player==1){
                System.out.println("Great! 1 Player start a game ");
                    pass5 = true;
            }
            else if(number_player ==2){
                System.out.println("Great! 2 Players game ");
                pass5 =true;
            }
            else{
                System.out.println("Your not pressed \"1\" or \"2\", pls press again");
                pass5 = false;
            }
        }while(pass5 ==false);
        Home_cats first = new Home_cats(name, breed);
        Street_cats second = new Street_cats(name2, breed2);
        if (player == 1) {
            System.out.println("READY PLAYER ONE!!!!!!!!");
            do {
                if (pass3 == true) {
                    System.out.println("Your can pressed \"1\" or \"2\", press 1 = layOnSofa - +3 money +1 happy , press 2 = spoilShoes +4 happy -3 money");
                    do {
                        number = in.nextInt();
                        a = in.nextLine();

                        if (number==1) {
                            first.layOnSofa();
                            pass6 = true;
                        } else if (number==2) {
                            first.spoilShoes();
                            pass6 = true;
                        } else {
                            System.out.println("Your not pressed \"1\" or \"2\", pls press again");
                            pass6 = false;
                        }
                    }while(pass6 == false);
                    System.out.println("Now your have this parametrs: ");
                    first.display();
                    System.out.println();
                    pass3 = false;
                }
                if (pass3 == false) {
                    System.out.println("Your can pressed \"1\" or \"2\", press 1 = attack Home's cat - steal 2 money, press 2 = hate_people - +3");
                    do {
                        if (number_player == 2){
                            number = in.nextInt();
                            a = in.nextLine();
                            }
                        else {
                            number = (int)(Math.random() * range) + min;
                            System.out.println("I choose " + number);
                        }
                        if (number==1) {
                            first.attack();
                            pass6 = true;
                        } else if (number==2) {
                            second.hate_people();
                            pass6 = true;
                        } else {
                            System.out.println("Your not pressed \"1\" or \"2\", pls press again");
                            pass6 = false;
                        }
                    }while(pass6 == false);
                    System.out.println("Now your have this parametrs: ");
                    second.display();
                    System.out.println("hate_people: " + (second.getHate_people()-first.get_happy()) +"\t" + "money home's cat:  "+ first.get_money() +"\t" + "\n");
                    pass3 = true;
                }
            } while (first.get_happy() < 50 && first.get_money() < 100 && first.get_money()>0 && (second.getHate_people()-first.get_happy())<50);
        }
        if (player == 2) {
            System.out.println("READY PLAYER ONE!!!!!!!!");
            do {
                if (pass3 == false) {
                    System.out.println("Your can pressed \"1\" or \"2\", press 1 = layOnSofa - +2 money +1 happy , press 2 = spoilShoes +2 happy -2 money");
                    do {
                        if (number_player == 2) {
                            number = in.nextInt();
                            a = in.nextLine();
                        } else {
                            number = (int) (Math.random() * range) + min;
                            System.out.println("I choose " + number);
                        }
                        if (number == 1) {
                            first.layOnSofa();
                            pass6 = true;
                        } else if (number == 2) {
                            first.spoilShoes();
                            pass6 = true;
                        } else {
                            System.out.println("Your not pressed \"1\" or \"2\", pls press again");
                            pass6 = false;
                        }
                    } while (pass6 == false);
                    System.out.println("Now your have this parametrs: ");
                    first.display();
                    System.out.println();
                    pass3 = true;
                }
                if (pass3 == true) {
                    System.out.println("Your can pressed \"1\" or \"2\", press 1 = attack Home's cat - steal 2 money, press 2 = hate_people - +3");
                    do {
                        number = in.nextInt();
                        a = in.nextLine();
                        if (number == 1) {
                            first.attack();
                            pass6 = true;
                        } else if (number == 2) {
                            second.hate_people();
                            pass6 = true;
                        } else {
                            System.out.println("Your not pressed \"1\" or \"2\", pls press again");
                            pass6 = false;
                        }
                    } while (pass6 == false);
                    System.out.println("Now your have this parametrs: ");
                    second.display();
                    System.out.println("hate_people: " + (second.getHate_people() - first.get_happy()) + "\t" + "money home's cat:  " + first.get_money() + "\t" + "\n");
                    pass3 = false;
                }
            } while (first.get_happy() < 50 && first.get_money() < 100 && first.get_money() > 0 && (second.getHate_people()-first.get_happy()) < 50);
        }
        if(first.get_money()<0 && second.getHate_people()>50){
            System.out.println("Great Street cat save the world - you win");
            System.out.println("Home's cat no one needs - you lose ");
        }
        if (first.get_happy() > 50 && first.get_money() > 100){
            System.out.println("Great Home's cat didn’t allow to save the world, and they will rule people until the end of time - you win");
            System.out.println("Street cat remained useless to anyone - you lose");
        }
        }
    }

abstract class Cats {
    Scanner in = new Scanner(System.in);
    private String name;
    public String getName(){return name;}
    private String breed;
    public String getBreed(){return breed;}
    public Cats (String name, String breed){
        this.name = name;
        this.breed = breed;
    }
}
class Home_cats extends Cats{
    private int money = 20;
    private int happy = 0;
    public Home_cats (String name, String breed){
        super(name, breed);
    }
    public void layOnSofa (){
        this.happy = happy + 1;
        this.money = money +2;
    }
    public void spoilShoes(){
        this.happy = happy +2;
        this.money = money -2;
    }
    public void attack(){
        this.money = money-2;
    }
    public void display(){
        System.out.printf("cat: %s \t breed: %s \t happy: %s\t money: %s\t",
                super.getName(),super.getBreed(),happy, money);
        System.out.println();
    }
    public int get_happy(){
        return this.happy;
    }
    public int get_money(){
        return this.money;
    }
}
class Street_cats extends Cats {
        Home_cats first = new Home_cats("first","second" );
        private int hate_people = 0;
        public Street_cats (String name, String breed){
            super(name, breed);
        }
        public void hate_people(){
            this.hate_people = hate_people + 3;
        }
        public void display(){
            System.out.printf("cat: %s \t breed: %s \t ",
                    super.getName(),super.getBreed());
        }
        public int getHate_people(){
            return this.hate_people;
        }
}