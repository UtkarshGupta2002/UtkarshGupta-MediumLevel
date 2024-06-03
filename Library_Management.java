import java.util.*;

class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isBorrowed;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = false;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isBorrowed() { return isBorrowed; }
    public void borrow() { isBorrowed = true; }
    public void returnBook() { isBorrowed = false; }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Borrowed: " + isBorrowed;
    }
}

class Member {
    private String name;
    private String memberId;
    private List<Book> borrowedBooks;

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getMemberId() { return memberId; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }
    public void borrowBook(Book book) { borrowedBooks.add(book); }
    public void returnBook(Book book) { borrowedBooks.remove(book); }

    @Override
    public String toString() {
        return "Name: " + name + ", Member ID: " + memberId + ", Borrowed Books: " + borrowedBooks.size();
    }
}

class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void registerMember(Member member) {
        members.add(member);
    }

    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public Member searchMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equalsIgnoreCase(memberId)) {
                return member;
            }
        }
        return null;
    }

    public void borrowBook(String memberId, String bookTitle) {
        Member member = searchMemberById(memberId);
        Book book = searchBookByTitle(bookTitle);

        if (member != null && book != null && !book.isBorrowed()) {
            book.borrow();
            member.borrowBook(book);
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book cannot be borrowed.");
        }
    }

    public void returnBook(String memberId, String bookTitle) {
        Member member = searchMemberById(memberId);
        Book book = searchBookByTitle(bookTitle);

        if (member != null && book != null && book.isBorrowed()) {
            book.returnBook();
            member.returnBook(book);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book cannot be returned.");
        }
    }

    public void overdueNotifications() {
        for (Member member : members) {
            if (!member.getBorrowedBooks().isEmpty()) {
                System.out.println("Member " + member.getName() + " has overdue books.");
            }
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("The Great ", "F. Scott ", "123456789");
        Book book2 = new Book("To Kill a Mockingbird", "Harper", "987654321");

        Member member1 = new Member("John Adam", "M001");
        Member member2 = new Member("Jane Wipe", "M002");

        library.addBook(book1);
        library.addBook(book2);

        library.registerMember(member1);
        library.registerMember(member2);

        library.borrowBook("M001", "The Great");
        library.returnBook("M001", "The Great");

        library.overdueNotifications();
    }
}
