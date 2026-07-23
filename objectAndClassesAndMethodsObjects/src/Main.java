void main() {
    Author author1 = new Author("Anton", "Chehov");
    Author author2 = new Author("Lev", "Tolstoy");

    Book book1 = new Book(
            "Palata №6",
            author1,
            2001
    );
    Book book2 = new Book(
            "Voyna i mir",
            author2,
            2004
    );

    System.out.println(book2);
    book2.setYearOfPublication(2020);

    System.out.println(book2);
}
