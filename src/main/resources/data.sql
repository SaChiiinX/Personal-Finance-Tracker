create table account (
    accountId bigint primary key auto_increment,
    username varchar(255) not null unique,
    password varchar(255) not null
);

create table expenseRecord (
    expenseId bigint primary key auto_increment,
    accountId bigint not null, 
    budget decimal(10,2) not null,
    spent decimal(10,2) not null,
    foreign key (accountId) references account(accountId)
);

create table transaction (
    transactionId bigint primary key auto_increment,
    accountId bigint not null,
    amount decimal(10, 2) not null,
    transactionType ENUM('INCOME', 'EXPENSE') not null,
    category varchar(255) not null,
    transactionDate date not null,
    foreign key (accountId) references account(accountId)
);

create table recurringTransaction (
    recurringTransactionId bigint primary key auto_increment,
    transactionId bigint not null,
    recurrencePattern ENUM('DAILY', 'WEEKLY', 'MONTHLY', 'BI_WEEKLY', 'QUARTERLY', 'SEMI-YEARLY', 'YEARLY') not null,
    startDate date not null,
    endDate date, 
    foreign key (transactionId) references transactions(transactionId)
);

create table combinedTransaction (
    id bigint primary key auto_increment,
    accountId bigint not null,
    transactionId bigint not null,
    amount decimal(10, 2) not null,
    transactionType enum('INCOME', 'EXPENSE') not null,
    category varchar(255) not null,
    transactionDate date not null,
    recurringTransactionId bigint not null,
    recurrencePattern enum('DAILY', 'WEEKLY', 'MONTHLY', 'BI_WEEKLY', 'QUARTERLY', 'SEMI_YEARLY', 'YEARLY') not null,
    startDate date not null,
    endDate date,
    foreign key (transactionId) references transactions(transactionId) on delete cascade,
    foreign key (recurringTransactionId) references recurringTransactions(recurringTransactionId) on delete cascade,
    foreign key (accountId) references account(accountId)
);
