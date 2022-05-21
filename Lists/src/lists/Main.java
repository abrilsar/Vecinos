
package lists;

public class Main {

    public static void main(String[] args) {
        Book book1 = new Book("Harry Potter", "J.K Rowling", "123");
        Book book2 = new Book("El Señor de los Anillos", "Pepe Grillo", "456");
        Book book3 = new Book("100 años de Soledad", "Gabriel García Márquez", "789");
        List list = new List(null);
        list.insertLast(book1);
        list.insertLast(book2);
        list.insertLast(book3);
        list.insertFirst(book3);

//      System.out.println("Lista: " + list.getElement(i).);
        }
    }
