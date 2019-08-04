INSERT INTO Employee (emp_id, name, mobile, address, hour_wage)
VALUES (1, 'Ewan', '0432332321', 'Sydney', 20);
INSERT INTO Employee (emp_id, name, mobile, address, hour_wage)
VALUES (2, 'LuLu', '0477787771', 'TAS', 30);
INSERT INTO Employee (emp_id, name, mobile, address, hour_wage)
VALUES (3, 'Euphy', '0475555511', 'MEL', 20);


INSERT INTO customer (cus_id, name, mobile, address)
VALUES (1, 'Tim', '0931323231', 'TAIWAN');
INSERT INTO customer (cus_id, name, mobile, address)
VALUES (2, 'Misa', '0469969611', 'Japan');
INSERT INTO customer (cus_id, name, mobile, address)
VALUES (3, 'Andy', '0499696551', 'French');

INSERT INTO event (event_seq, emp_id, cus_id, start_time, end_time)
VALUES (1, 1, 1, '2019-07-22 08:00:00', '2019-07-23 15:00:00');
INSERT INTO event (event_seq, emp_id, cus_id, start_time, end_time)
VALUES (2, 1, 2, '2019-07-26 08:00:00', '2019-07-26 15:00:00');
INSERT INTO event (event_seq, emp_id, cus_id, start_time, end_time)
VALUES (3, 2, 3, '2019-07-18 08:00:00', '2019-07-18 14:00:00');
INSERT INTO event (event_seq, emp_id, cus_id, start_time, end_time)
VALUES (4, 3, 3, '2019-07-15 08:00:00', '2019-07-15 16:00:00');

INSERT INTO wage (wage_seq, emp_id, start_time, end_time, wage, event_seq, work_hour)
VALUES (1, 1, '2019-07-22 08:00:00', '2019-07-22 16:00:00', 160, 1, 8);
INSERT INTO wage (wage_seq, emp_id, start_time, end_time, wage, event_seq, work_hour)
VALUES (2, 1, '2019-07-23 08:00:00', '2019-07-23 15:00:00', 140, 1, 7);
INSERT INTO wage (wage_seq, emp_id, start_time, end_time, wage, event_seq, work_hour)
VALUES (3, 1, '2019-07-26 08:00:00', '2019-07-26 16:00:00', 140, 2, 7);
INSERT INTO wage (wage_seq, emp_id, start_time, end_time, wage, event_seq, work_hour)
VALUES (4, 2, '2019-07-18 08:00:00', '2019-07-18 14:00:00', 180, 3, 6);
INSERT INTO wage (wage_seq, emp_id, start_time, end_time, wage, event_seq, work_hour)
VALUES (5, 3, '2019-07-15 08:00:00', '2019-07-15 16:00:00', 160, 4, 8);
