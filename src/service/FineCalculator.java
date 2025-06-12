package service;

import java.sql.Date;

public class FineCalculator {
    public static long calculateFine(Date borrowDate, Date returnDate) {
        long daysLate = (returnDate.getTime() - borrowDate.getTime()) / (1000 * 60 * 60 * 24) - 14;
        return daysLate > 0 ? daysLate * 10 : 0;
    }
}
