package model;

import java.sql.Date;

public class BorrowRecord {
    private int id;
    private int bookId;
    private int userId;
    private Date borrowDate;
    private Date returnDate;

    public BorrowRecord(int id, int bookId, int userId, Date borrowDate, Date returnDate) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public int getId() { return id; }
    public int getBookId() { return bookId; }
    public int getUserId() { return userId; }
    public Date getBorrowDate() { return borrowDate; }
    public Date getReturnDate() { return returnDate; }

    @Override
    public String toString() {
        return id + " | Book ID: " + bookId + " | User ID: " + userId + 
               " | Borrowed: " + borrowDate + " | Returned: " + returnDate;
    }
}
