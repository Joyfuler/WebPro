package practice;

import java.awt.print.Book;
import java.util.Scanner;

public class BookMain {
    public static void main(String[] args) {
        BookLib[] books = {new BookLib("890?…-101-1?„±", "java", "?™ê¸¸ë™"),
                new BookLib("110?„±-111-1?„±", "dbms", "?‹ ê¸¸ë™"),
                new BookLib("110?…-123-2?…Œ", "web", "?œ ê¸¸ë™"),
                new BookLib("770?…-123-2?…Œ", "jsp", "ê³ ê¸¸?™"),
                new BookLib("110?…-123-2?…Œ", "spring", "ê¹?ê¸¸ë™")};

        int inputNum;
        int idx;
        String bookTitle, borrower, checkOutDate;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("?‹¤?–‰?•˜ê³? ?‹¶?? ê¸°ëŠ¥?„ ?„ ?ƒ?•´ì£¼ì„¸?š”. 1 - ??ì¶? | 2 - ë°˜ë‚© | 3 - ì±? listì¡°íšŒ | 0 - ì¢…ë£Œ");
            inputNum = scanner.nextInt();
            switch (inputNum) {
                case 1: // ??ì¶?
                    System.out.println("??ì¶œí•˜ê³? ?‹¶?? ì±? ?´ë¦„ì„ ?…? ¥?•´ì£¼ì„¸?š”.");
                    bookTitle = scanner.next();
                    for (idx = 0; idx <= books.length; idx++) {
                        if (bookTitle.equals(books[idx].getBookTitle())) {
                            break;
                        }
                    }
                    if (idx == books.length) {
                        System.out.println("?˜„?¬ ë³´ìœ ?•˜ì§? ?•Š?? ?„?„œ?…?‹ˆ?‹¤.");

                    } else {
                        if (books[idx].getState() == BookLib.STATE_BORROWED) {
                            System.out.println("?´ë¯? ??ì¶œì¤‘?¸ ?„?„œ?…?‹ˆ?‹¤.");
                        } else {
                            System.out.println("??ì¶œí•˜?‹œ?Š” ë¶„ì˜ ?„±?•¨?„ ?…? ¥?•´ì£¼ì„¸?š”.");
                            borrower = scanner.next();
                            System.out.println("??ì¶œí•˜?Š” ?¼?ë¥? ? ?–´ì£¼ì„¸?š”.");
                            checkOutDate = scanner.next();
                            books[idx].checkOut(borrower, checkOutDate);

                        }
                    }
                    break;
                case 2:
                    System.out.println("ë°˜ë‚©?•˜? ¤?Š” ?„?„œ ?´ë¦„ì„ ?…? ¥?•´ì£¼ì„¸?š”.");
                    bookTitle = scanner.next();
                    for (idx = 0; idx < books.length; idx++) {
                        if (bookTitle.equals(books[idx].getBookTitle())) {
                            break;
                        }
                    }
                    if (idx == books.length) {
                        System.out.println("?š”ì²??•˜?‹  ?„?„œ?˜ ? •ë³´ê? ?—†?Šµ?‹ˆ?‹¤.");
                    } else {
                        books[idx].checkIn();
                    }
                    break;
                case 3:
                    System.out.println("?„?„œê´??˜ ì±? ë¦¬ìŠ¤?Š¸?Š” ?•„?˜?? ê°™ìŠµ?‹ˆ?‹¤.");
                    for (int i = 0; i < books.length; i++) {
                        books[i].printState();
                    }
                    break;
            }
        } while (inputNum != 0) ;
        System.out.println("?´?š©?•´ ì£¼ì…”?„œ ê°ì‚¬?•©?‹ˆ?‹¤.");
        scanner.close();
        }

    }



