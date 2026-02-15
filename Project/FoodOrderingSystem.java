import java.util.*;
class FoodItem 
{
    String name;
    double price;
    FoodItem(String name, double price) 
	{
        this.name = name;
        this.price = price;
    }
}
class Menu 
{
    private final List<FoodItem> foodItems = new ArrayList<>();
    void addFoodItem(String name, double price) 
	{
        foodItems.add(new FoodItem(name, price));
    }
    void displayMenu() 
	{
        System.out.println("\n----- Menu -----");
        for (int i = 0; i < foodItems.size(); i++) 
		{
            System.out.println((i + 1) + ". " + foodItems.get(i).name + " - $" + foodItems.get(i).price);
        }
    }
    FoodItem getFoodItem(int index) 
	{
        if (index >= 0 && index < foodItems.size()) 
		{
            return foodItems.get(index);
        }
        return null;
    }
}
class Order 
{
    private final List<FoodItem> orderedItems = new ArrayList<>();
    private double totalAmount = 0;
    void addItem(FoodItem item) 
	{
        if (item != null) 
		{
            orderedItems.add(item);
            totalAmount += item.price;
        }
    }
    void displayOrder() 
	{
        System.out.println("\n----- Your Order -----");
        for (FoodItem item : orderedItems) 
		{
            System.out.println(item.name + " - $" + item.price);
        }
        System.out.println("Total: $" + totalAmount);
    }
}
class Customer 
{
    String name;
    String phone;
    Customer(String name, String phone) 
	{
        this.name = name;
        this.phone = phone;
    }
}
public class FoodOrderingSystem 
{
    public static void main(String[] args) 
	{
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        Order order = new Order();
        menu.addFoodItem("Burger", 5.99);
        menu.addFoodItem("Pizza", 8.99);
        menu.addFoodItem("Pasta", 7.49);
        menu.addFoodItem("Salad", 4.99);
        menu.addFoodItem("Noodles", 4.99);
        menu.addFoodItem("Sandwich", 4.99);
        menu.addFoodItem("French Fries", 8.99);
        menu.addFoodItem("Pav Bhaji", 9.99);
        menu.addFoodItem("Biryani", 19.99);
        menu.addFoodItem("Chips", 6.99);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your phone number: ");
        String phone = scanner.nextLine();
        Customer customer = new Customer(name, phone);
        while (true) 
		{
            menu.displayMenu();
            System.out.print("Enter item number to order (0 to finish): ");
            int choice = scanner.nextInt();
            if (choice == 0) break;
            FoodItem item = menu.getFoodItem(choice - 1);
            if (item != null) 
			{
                order.addItem(item);
                System.out.println(item.name + " added to your order.");
            } 
			else 
			{
                System.out.println("Invalid selection, try again.");
            }
        }
        order.displayOrder();
        System.out.println("\nThank you for ordering, " + customer.name + "!");
    }
}