class SmartShelf {
    private Book[] books;
    private int count;
    SmartShelf(int capacity) {
        books = new Book[capacity];
        count = 0;
    }
    public void addBook(String title) {
        Book newBook = new Book(title);
        books[count] = newBook;
        int i = count - 1;
        while (i >= 0 && books[i].title.compareToIgnoreCase(title) > 0) {
            books[i + 1] = books[i];
            i--;
        }
        books[i + 1] = newBook;
        count++;
        System.out.println("Added: " + title);
    }
    public void printShelf() {
        System.out.print("Shelf: ");
        for (int i = 0; i < count; i++) {
            System.out.print(books[i].title + " | ");
        }
        System.out.println();
    }
}