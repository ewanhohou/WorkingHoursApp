DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS event;
DROP TABLE IF EXISTS wage;


CREATE TABLE employee
(
    emp_id    INT PRIMARY KEY auto_increment,
    name      VARCHAR,
    mobile    VARCHAR,
    address   VARCHAR,
    hour_wage DECIMAL
);

CREATE TABLE customer
(
    cus_id  INT PRIMARY KEY auto_increment,
    name    VARCHAR,
    mobile  VARCHAR,
    address VARCHAR
);

CREATE TABLE event
(
    event_seq  INT PRIMARY KEY auto_increment,
    emp_id     INT,
    cus_id     INT,
    start_time DATETIME,
    end_time   DATETIME,
    CONSTRAINT employee_event_emp_id_fk_id FOREIGN KEY (emp_id) REFERENCES employee (emp_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT customer_event_cus_id_fk_id FOREIGN KEY (cus_id) REFERENCES customer (cus_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE wage
(
    wage_seq   INT PRIMARY KEY auto_increment,
    emp_id     INT,
    start_time DATETIME,
    end_time   DATETIME,
    wage       DECIMAL,
    event_seq  INT,
    work_hour  DECIMAL,
    CONSTRAINT employee_wage_emp_id_fk_id FOREIGN KEY (emp_id) REFERENCES employee (emp_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT event_wage_seq_fk_id FOREIGN KEY (event_seq) REFERENCES event (event_seq) ON DELETE CASCADE ON UPDATE CASCADE

);