INSERT INTO Employee (emp_id, name, mobile, address, hour_wage)
VALUES (1, 'Ewan', '043233232', 'Sydney', 24);
INSERT INTO Employee (emp_id, name, mobile, address, hour_wage)
VALUES (2, 'LuLu', '047778777', 'TAS', 30);
INSERT INTO Employee (emp_id, name, mobile, address, hour_wage)
VALUES (3, 'Euphy', '04755555', 'MEL', 20);


INSERT INTO customer (cus_id, name, mobile, address)
VALUES (1, 'Tim', '093132323', 'TAIWAN');
INSERT INTO customer (cus_id, name, mobile, address)
VALUES (2, 'Misa', '04699696', 'Japan');
INSERT INTO customer (cus_id, name, mobile, address)
VALUES (3, 'Andy', '049969655', 'French');

INSERT INTO event (event_seq, emp_id, cus_id, start_time, end_time)
VALUES (1, 1, 1, '2019-07-22 08:00:00', '2019-07-26 16:00:00');
INSERT INTO event (event_seq, emp_id, cus_id, start_time, end_time)
VALUES (2, 1, 2, '2019-07-15 08:00:00', '2019-07-26 15:00:00');
INSERT INTO event (event_seq, emp_id, cus_id, start_time, end_time)
VALUES (3, 2, 3, '2019-07-08 08:00:00', '2019-07-19 17:00:00');
INSERT INTO event (event_seq, emp_id, cus_id, start_time, end_time)
VALUES (4, 3, 3, '2019-07-15 08:00:00', '2019-07-19 18:30:00');

INSERT INTO wage (wage_seq, emp_id, start_time, end_time, wage)
VALUES (1, 1, '2019-07-22 08:00:00', '2019-07-26 16:00:00', 960);


