package visitorsList;
import java.util.Scanner;

public class Menu {
	List list = new List();
	Scanner reader ;
	Scanner position ;
	Scanner quantity ;
	int answer;
	int userId = 0;
	
    public Menu(){
        start();
    }
    public void start() {
        reader = new Scanner(System.in);
        position = new Scanner(System.in);
        quantity = new Scanner(System.in);
        System.out.println(
                "WELCOME TO INIS"
                        +"\n"+"Press [1] to insert a new person in the first position"
                        +"\n"+"Press [2] to insert a new person with no priority"
                        +"\n"+"Press [3] to insert choosing a position"
                        +"\n"+"Press [4] to show all records in the list"
                        +"\n"+"Press [5] to remove the first record from the list"
                        +"\n"+"Press [6] to remove the last record from the list"
                        +"\n"+"Press [7] to remove one record at the desired position on the list"
                        +"\n"+"Press [8] to remove many records on the list"
                        +"\n"+"Press [9] to search for ID on the list"
                        +"\n"+"Press [10] Quit the program");
        try {
            readUser();
        } catch (Exception e){
            System.out.println("Please type an option as shown in the Menu");
            start();
        }
        switch(answer) {
            case 1: userId++;
            list.addBeggin(immigrantReceive(userId));
                System.out.println("\nAdded with success");
                start();
                break;
            case 2: userId++;
            list.addEnd(immigrantReceive(userId));
                System.out.println("\nAdded with success");
                start();
                break;
            case 3: userId++;
            System.out.println("Type the position, please :");
            int position1 = position.nextInt();
            list.addAt(immigrantReceive(userId),position1);
                System.out.println("\nAdded with success");
                start();
                break;
            case 4: list.showAll();
                start();
                break;
            case 5: list.deleteAtBegin();
                start();
                break;
            case 6: list.deleteAtEnd();
                start();
                break;
            case 7:
                System.out.println("Type the position, please :");
                int position2 = position.nextInt();
                list.deleteAtPosiiton(position2);
                start();
                break;
            case 8:
                System.out.println("Type the quantity to delete, please :");
                int position3 = position.nextInt();
                list.deleteMany(position3);
                start();
                break;
            case 9:
                System.out.println("Type the Id to search, please:");
                int position4 = position.nextInt();
                list.searchId(position4);
                start();
                break;
            case 10:
                System.out.println("Thanks for using INIS program");
                System.exit(0);
        }
    }
    public void readUser() {
        answer = reader.nextInt();
    }
    public Immigrant immigrantReceive(int personID) {
        reader = new Scanner(System.in);
        String firstName;
        String lastName;
        String passport;
        String dateOfArrival;
        
        System.out.println("Type First name please: ");
        firstName = reader.next();
        System.out.println("\nType Last name please: ");
        lastName = reader.next();
        System.out.println("\nType Passport Number please: ");
        passport = reader.next();
        System.out.println("\nType Date of Arrival please: ");
        dateOfArrival = reader.next();

        Immigrant guest = new Immigrant(personID,firstName,lastName,passport,dateOfArrival);
        return guest;
    }
}
