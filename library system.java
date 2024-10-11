import java.util.*;
class library{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int [] bookid=new int[100];          // Use parallel arrays to store book IDs, titles, authors, and borrowing status. 
        String[] title=new String[100];
        String[]author=new String[100];
        boolean[] isborrowed=new boolean[100];
        int bookcount=0;
        
        
        while (true) {                                         
            System.out.println("\nLibrary Management System");   //DISPLAY MENU   
            System.out.println("1. Add New Book");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Generate Report of Borrowed Books");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline


        switch (choice) {

            case 1:             // to add book
                if (bookcount<100) {
                    System.out.println("ENTER BOOK ID FOR ADD BOOK");
                    int ID=sc.nextInt();
                    System.out.println("ENTER BOOK TITLE");
                    String TITLE=sc.nextLine();
                    sc.nextLine();   //consume new line
                    System.out.println("ENTER AUTHOR NAME FOR ADD BOOK");
                    String AUTHOR=sc.nextLine();
                    
                    bookid[bookcount]=ID;
                    title[bookcount]=TITLE;
                    author[bookcount]=AUTHOR;
                    isborrowed[bookcount]=false;
                    bookcount++;
                    System.out.println("BOOK added succesfully");
                }
                else{
                    System.out.println("FULL");
                }
                
                break;

            case 2:             //to borrow a book
            System.out.print("Enter Book ID to borrow: ");
            int borrowId = sc.nextInt();
            boolean foundBorrow = false;
            for (int i = 0; i < bookcount; i++) {
                if (bookid[i] == borrowId) {
                    foundBorrow = true;
                    if (isborrowed[i]) {
                        System.out.println("This book is already borrowed.");
                    } else {
                        isborrowed[i] = true;
                        System.out.println("You have borrowed the book: " + title[i]);
                    }
                    break;
                }
            }
            if (!foundBorrow) {
                System.out.println("Book not found!");
            }
            break;


            case 3:     //return the book
            System.out.println("enter bookid to return ");
            int returnid=sc.nextInt();
            boolean foundReturn=false;
            for(int i = 0; i < bookcount; i++){
                if (returnid==bookid[i]) {
                    foundReturn=true;
                    if (!isborrowed[i]) {
                        System.out.println("this book was not borrowed");
                    }else {
                        isborrowed[i] = false;
                        System.out.println("You have returned the book: " + title[i]);
                    }
                    break;
                }
            if (!foundReturn) {
                System.out.println("book not found");
            }  
            break;
        }
             

            case 4:
            System.out.println("\nList of Borrowed Books:");    // borrow book list
            boolean borrowedBooksExist = false;
            for (int i = 0; i < bookcount; i++) {
                if (isborrowed[i]) {
                    System.out.println("ID: " + bookid[i] + " | Title: " + title[i] + " | Author: " + author[i]);
                    borrowedBooksExist = true;
                }
            }
            if (!borrowedBooksExist) {
                System.out.println("No books are currently borrowed.");
            }
            break;

            case 5:
                System.out.println("exit system");

            default:
                System.out.println("invalid number");    


                    
                
            }
                
                
        }  
                             
    
    }
}

              
                

        
                
                 
                


            
                
            
