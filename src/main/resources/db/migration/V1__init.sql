DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS transactions;

CREATE SEQUENCE customer_id_seq AS INTEGER START WITH 1000 INCREMENT BY 1;
CREATE TABLE customer (
  customer_id INT,
  first_name VARCHAR(300) NOT NULL,
  last_name VARCHAR(300) NOT NULL,
  PRIMARY KEY(customer_id)
);


CREATE SEQUENCE account_number_seq AS INTEGER START WITH 1234596789 INCREMENT BY 1;
CREATE TABLE account (
  account_number INT,
  account_name VARCHAR(300) ,
  account_type VARCHAR(10),
  balance_date DATE,
  currency VARCHAR(3),
  opening_avl_balance DECIMAL (15,2),
  customer_id INT NOT NULL,
  PRIMARY KEY(account_number),
  FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);


CREATE SEQUENCE transactions_seq AS INTEGER START WITH 1 INCREMENT BY 1;
CREATE TABLE transactions (
  id INT,
  value_date DATE,
  currency VARCHAR(3),
  debit_amount DECIMAL (15,2),
  credit_amount DECIMAL (15,2),
  dr_cr_indicator VARCHAR(6),
  transaction_narrative VARCHAR(400),
  account_number INT,
  PRIMARY KEY(id),
  FOREIGN KEY (account_number) REFERENCES account(account_number)
);



INSERT INTO customer (customer_id, first_name, last_name) VALUES
  (NEXTVAL('customer_id_seq'), 'Darshana', 'Wimal'),
  (NEXTVAL('customer_id_seq'), 'Kiyaan', 'Seth');

INSERT INTO account (account_number, account_name, account_type, balance_date, currency, opening_avl_balance, customer_id) VALUES
  (NEXTVAL('account_number_seq'), 'SGSavings726', 'Savings', DATE '2018-11-08', 'SGD', 84327.51, CURRVAL('customer_id_seq')),
  (NEXTVAL('account_number_seq'), 'AUSavings933', 'Savings', DATE '2018-11-08', 'AUD', 88005.93, CURRVAL('customer_id_seq')),
  (NEXTVAL('account_number_seq'), 'AUCurrent433', 'Current', DATE '2018-11-08', 'AUD', 38010.62, CURRVAL('customer_id_seq')),
  (NEXTVAL('account_number_seq'), 'SGCurrent166', 'Current', DATE '2018-11-08', 'SGD', 50664.65, CURRVAL('customer_id_seq')),
  (NEXTVAL('account_number_seq'), 'AUCurrent374', 'Current', DATE '2018-11-08', 'AUD', 41327.28, CURRVAL('customer_id_seq')),
  (NEXTVAL('account_number_seq'), 'AUSavings938', 'Savings', DATE '2018-11-08', 'AUD', 48928.79, CURRVAL('customer_id_seq')),
  (NEXTVAL('account_number_seq'), 'SGSavings842', 'Savings', DATE '2018-11-08', 'SGD', 72117.53, CURRVAL('customer_id_seq')),
  (NEXTVAL('account_number_seq'), 'AUSavings253', 'Savings', DATE '2018-11-08', 'AUD', 20588.16, CURRVAL('customer_id_seq')),
  (NEXTVAL('account_number_seq'), 'AUCurrent754', 'Current', DATE '2018-11-08', 'AUD', 88794.48, CURRVAL('customer_id_seq')),
  (NEXTVAL('account_number_seq'), 'SGCurrent294', 'Current', DATE '2018-11-08', 'SGD', 5906.55, CURRVAL('customer_id_seq')),
  (NEXTVAL('account_number_seq'), 'AUCurrent591', 'Current', DATE '2018-11-08', 'AUD', 92561.68, CURRVAL('customer_id_seq'));


INSERT INTO transactions (id, value_date, currency, debit_amount, credit_amount, dr_cr_indicator, account_number) VALUES
    (NEXTVAL('transactions_seq'), DATE '2012-01-12', 'USD',  null, 9540.98, 'Credit', CURRVAL('account_number_seq')),
    (NEXTVAL('transactions_seq'), DATE '2012-01-12', 'USD',  null, 7497.82, 'Credit', CURRVAL('account_number_seq')),
    (NEXTVAL('transactions_seq'), DATE '2012-01-12', 'USD',  null, 5564.79, 'Credit', CURRVAL('account_number_seq')),
    (NEXTVAL('transactions_seq'), DATE '2012-01-12', 'USD',  null, 8136.18, 'Credit', CURRVAL('account_number_seq')),
    (NEXTVAL('transactions_seq'), DATE '2012-01-12', 'USD',  null, 9442.46, 'Credit', CURRVAL('account_number_seq')),
    (NEXTVAL('transactions_seq'), DATE '2012-01-12', 'USD',  null, 7614.45, 'Credit', CURRVAL('account_number_seq')),
    (NEXTVAL('transactions_seq'), DATE '2012-01-12', 'USD',  null, 3311.55, 'Credit', CURRVAL('account_number_seq')),
    (NEXTVAL('transactions_seq'), DATE '2012-01-12', 'USD',  null, 9186.09, 'Credit', CURRVAL('account_number_seq')),
    (NEXTVAL('transactions_seq'), DATE '2012-01-12', 'USD',  null, 1905.86, 'Credit', CURRVAL('account_number_seq')),
    (NEXTVAL('transactions_seq'), DATE '2012-01-12', 'USD',  null, 197.78, 'Credit', CURRVAL('account_number_seq')),
    (NEXTVAL('transactions_seq'), DATE '2012-01-12', 'USD',  null, 8430.49, 'Credit', CURRVAL('account_number_seq')),
    (NEXTVAL('transactions_seq'), DATE '2012-01-12', 'USD',  null, 8.33, 'Credit', CURRVAL('account_number_seq'));