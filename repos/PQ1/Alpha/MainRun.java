import java.util.Scanner;

public class MainRun
{
    public static void main(String[] args)
    {
        DoublyLinkedList doublelinkedlist = new DoublyLinkedList();
        for(int index = 0; index < 7; index++)
        {
            System.out.println("Please enter a country name below:");
            //Get country name
            Scanner scanner1 = new Scanner(System.in);
            String location1 = scanner1.nextLine();
            Country country1 = new Country(location1);
            
            
            System.out.println("Please enter a city name of that country below:");
            //Get city of that country name
            Scanner scanner2 = new Scanner(System.in);
            location1 = scanner1.nextLine();
            Country.City city1 = country1.new City(location1);
            
            //Add to double linked list
            doublelinkedlist.addNode(country1,city1);
        }

        //print results too check if results are correct
        doublelinkedlist.printNodes();
    }

}
