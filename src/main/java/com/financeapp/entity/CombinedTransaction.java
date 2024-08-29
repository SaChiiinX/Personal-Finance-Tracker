package com.financeapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "combinedTransaction")
public class CombinedTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long combinedTransaction;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "transactionId", referencedColumnName = "transactionId", nullable = false)
    private Transaction transaction;
    
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "recurringTransactionId", referencedColumnName = "recurringTransactionId", nullable = false)
    private RecurringTransaction recurringTransaction;


    public CombinedTransaction(Transaction transaction, RecurringTransaction recurringTransaction){
        this.transaction = transaction;
        this.recurringTransaction = recurringTransaction;
    }

    public Transaction getTransaction() { return transaction; }
    public void setTransaction(Transaction transaction) { this.transaction = transaction; }
    public RecurringTransaction getRecurringTransaction() { return recurringTransaction; }
    public void setRecurringTransaction(RecurringTransaction recurringTransaction) { this.recurringTransaction = recurringTransaction; }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

        CombinedTransaction other = (CombinedTransaction) obj;

        if(!transaction.equals(other.transaction))
            return false;

        if(!recurringTransaction.equals(other.recurringTransaction))
            return false;

        return true;
    }

    public String toString(){
        return "CombineTransaction{" + "\n" +
                transaction.toString() + "\n" + 
                recurringTransaction.toString() + '\'' +
                '}';
    }
}
