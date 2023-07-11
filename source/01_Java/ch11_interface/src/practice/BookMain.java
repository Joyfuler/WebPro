package practice;

import java.awt.print.Book;
import java.util.Scanner;

public class BookMain {
    public static void main(String[] args) {
        BookLib[] books = {new BookLib("890?��-101-1?��", "java", "?��길동"),
                new BookLib("110?��-111-1?��", "dbms", "?��길동"),
                new BookLib("110?��-123-2?��", "web", "?��길동"),
                new BookLib("770?��-123-2?��", "jsp", "고길?��"),
                new BookLib("110?��-123-2?��", "spring", "�?길동")};

        int inputNum;
        int idx;
        String bookTitle, borrower, checkOutDate;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("?��?��?���? ?��?? 기능?�� ?��?��?��주세?��. 1 - ??�? | 2 - 반납 | 3 - �? list조회 | 0 - 종료");
            inputNum = scanner.nextInt();
            switch (inputNum) {
                case 1: // ??�?
                    System.out.println("??출하�? ?��?? �? ?��름을 ?��?��?��주세?��.");
                    bookTitle = scanner.next();
                    for (idx = 0; idx <= books.length; idx++) {
                        if (bookTitle.equals(books[idx].getBookTitle())) {
                            break;
                        }
                    }
                    if (idx == books.length) {
                        System.out.println("?��?�� 보유?���? ?��?? ?��?��?��?��?��.");

                    } else {
                        if (books[idx].getState() == BookLib.STATE_BORROWED) {
                            System.out.println("?���? ??출중?�� ?��?��?��?��?��.");
                        } else {
                            System.out.println("??출하?��?�� 분의 ?��?��?�� ?��?��?��주세?��.");
                            borrower = scanner.next();
                            System.out.println("??출하?�� ?��?���? ?��?��주세?��.");
                            checkOutDate = scanner.next();
                            books[idx].checkOut(borrower, checkOutDate);

                        }
                    }
                    break;
                case 2:
                    System.out.println("반납?��?��?�� ?��?�� ?��름을 ?��?��?��주세?��.");
                    bookTitle = scanner.next();
                    for (idx = 0; idx < books.length; idx++) {
                        if (bookTitle.equals(books[idx].getBookTitle())) {
                            break;
                        }
                    }
                    if (idx == books.length) {
                        System.out.println("?���??��?�� ?��?��?�� ?��보�? ?��?��?��?��.");
                    } else {
                        books[idx].checkIn();
                    }
                    break;
                case 3:
                    System.out.println("?��?���??�� �? 리스?��?�� ?��?��?? 같습?��?��.");
                    for (int i = 0; i < books.length; i++) {
                        books[i].printState();
                    }
                    break;
            }
        } while (inputNum != 0) ;
        System.out.println("?��?��?�� 주셔?�� 감사?��?��?��.");
        scanner.close();
        }

    }



