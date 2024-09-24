import java.util.*;
//Design Classes
class Book{
    private String title;
    private String author;
    private String isbn;
    private double price;
    private int stockquantity;
//Constuctor -  The constructor is called when an object of a class is created. It can be used to set initial values for object attributes:
    Book(String title, String author, String isbn, double price,int stockquantity){
    this.title = title;
    this.author = author;
    this.isbn = isbn;
    this.price = price;
    this.stockquantity = stockquantity;
}
//Getter and setter methods

/*The get method returns the value of the variable name.
The set method takes a parameter (newName) and assigns it to the name variable. The this keyword is used to refer to the current object.
However, as the name variable is declared as private, we cannot access it from outside this class:*/

public String getTitle(){
    return title;
}
public void setTitle(String title){
    this.title = title;
}
public String getAuthor(){
    return author;
}
public void setAuthor(String author){
    this.author = author;
}
public String getIsbn(){
    return isbn;
}
public void setIsbn(String isbn){
    this.isbn = isbn;
}
public double getPrice(){
    return price;
}
public void setPrice(double price){
    this.price = price;
}
public int getStockQuantity(){
    return stockquantity;
}
public void setStockQuantity(int stockquantity){
    this.stockquantity = stockquantity;
}
//Override , represent any object as a string, toString() method comes into existence.

public String toString(){
    return "Book [Title = "+ title +", Author = "+ author +",Isbn = "+ isbn +",Price = "+ price +", StockQuantity = "+ stockquantity +" ]";
    }
}
//Book Store Class

class BookStore{
    private List<Book> inventory;

    //Constructor

    BookStore(){
        inventory = new ArrayList<>();
    }
    // Method to add a new book to the inventory
    public void addBook(Book book ){
        inventory.add(book);
        System.out.println("Book added successfully: "+ book);
    }
    // Method to remove a book from the inventory based on its Isbn
    public void removeBook(String isbn){
        for(int i = 0; i< inventory.size(); i++){
            if (inventory.get(i).getIsbn().equals(isbn)){
                System.out.println("Book removed Successfully: "+ inventory.get(i));
                inventory.remove(i);
                return;
            }
        }
    System.out.println("Book with Isbn" + isbn + "Not Found..." ); 
}
// Method to update the stock quantity of a book
public void updateStock(String isbn, int quantity){
    for (Book book : inventory){
        if(book.getIsbn().equals(isbn)){
            book.setStockQuantity(quantity);
            System.out.println("Stock updated for"+ book.getTitle()+ "New Quantity"+ quantity);
            return;
        }
    }
    System.out.println("Book with Isbn" + isbn + " Not Found...");
}
// Method to dispaly all the books currently in the invemtory

public void printInventory(){
    System.out.println("Current Inventory: ");
    for(Book book : inventory){
        System.out.println(book);
        }
    }
}

// Main Method

public class Main{
    public static void main(String[] args){
        // Create an instance of Bookstore
        BookStore bookstore = new BookStore();
        // Adding Books
        bookstore.addBook(new Book("Java Programming","John Doe","1234567890",29.99,10));
        bookstore.addBook(new Book("Data Structure","Jane Smith","0987654321",39.99,5));
        bookstore.printInventory();

    }
}
