package com.financeapp.entity;

import jakarta.persistence.*;
import java.time.*;
@Entity
@Table(name = "recurringTransactions")
public class RecurringTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recurringTransactionId;
    private Long transactionId;
    private RecurrencePattern recurrencePattern;
    private LocalDate startDate;
    private LocalDate endDate;

    public RecurringTransaction(Long transactionId, RecurrencePattern recurrencePattern, LocalDate startDate, LocalDate endDate){
        this.transactionId = transactionId;
        this.recurrencePattern = recurrencePattern;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public RecurringTransaction(Long recurringTransactionId, Long transactionId, RecurrencePattern recurrencePattern, LocalDate startDate, LocalDate endDate){
        this.recurringTransactionId = recurringTransactionId;
        this.transactionId = transactionId;
        this.recurrencePattern = recurrencePattern;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getRecurringTransactionId(){ return recurringTransactionId; }
    public void setRecurringTransactionId(Long recurringTransactionId) { this.recurringTransactionId = recurringTransactionId; }
    public Long getTransactionId() { return transactionId; }
    public void setTransactionId(Long transactionId) { this.transactionId = transactionId; }
    public RecurrencePattern getReccurrencePattern() { return recurrencePattern; }
    public void setReccurrencePattern(RecurrencePattern recurrencePattern) { this.recurrencePattern = recurrencePattern; }
    public LocalDate getstartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

        RecurringTransaction other = (RecurringTransaction) obj;
        if (recurringTransactionId == null) {
			if (other.recurringTransactionId != null)
				return false;
		} else if (!recurringTransactionId.equals(other.recurringTransactionId))
			return false;

        if (transactionId == null) {
			if (other.transactionId != null)
				return false;
		} else if (!transactionId.equals(other.transactionId))
			return false;

        if (recurrencePattern == null) {
			if (other.recurrencePattern != null)
				return false;
		} else if (!recurrencePattern.equals(other.recurrencePattern))
			return false;

        if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;

        if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;

        return true;
    }

    @Override
    public String toString(){
        return "RecurringTransaction{" +
                "recurringTransactionId='" + recurringTransactionId +
                ", transactionId='" + transactionId +
                ", reccurencePattern='" + recurrencePattern +
                ", startDate='" + startDate +
                ", endDate='" + endDate + '\'' +
                '}';
    }
    
}
