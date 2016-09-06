1. mysql> select first_name,last_name from student;
+------------+-----------+
| first_name | last_name |
+------------+-----------+
| Eric       | Ephram    |
| Greg       | Gould     |
| Adam       | Ant       |
| Howard     | Hess      |
| Charles    | Caldwell  |
| James      | Joyce     |
| Doug       | Dumas     |
| Kevin      | Kraft     |
| Frank      | Fountain  |
| Brian      | Biggs     |
+------------+-----------+
10 rows in set (0.00 sec)


2. mysql> select * from student where years_of_experience < 8;
+-----+------------+-----------+---------------------+------------+
| id  | first_name | last_name | years_of_experience | start_date |
+-----+------------+-----------+---------------------+------------+
| 100 | Eric       | Ephram    |                   2 | 2016-03-31 |
| 110 | Greg       | Gould     |                   6 | 2016-09-30 |
| 120 | Adam       | Ant       |                   5 | 2016-06-02 |
| 130 | Howard     | Hess      |                   1 | 2016-02-28 |
| 140 | Charles    | Caldwell  |                   7 | 2016-05-07 |
| 170 | Kevin      | Kraft     |                   3 | 2016-04-15 |
| 190 | Brian      | Biggs     |                   4 | 2015-12-25 |
+-----+------------+-----------+---------------------+------------+
7 rows in set (0.00 sec)


3. mysql> select last_name, start_date , id from student order by 1;
+-----------+------------+-----+
| last_name | start_date | id  |
+-----------+------------+-----+
| Ant       | 2016-06-02 | 120 |
| Biggs     | 2015-12-25 | 190 |
| Caldwell  | 2016-05-07 | 140 |
| Dumas     | 2016-07-04 | 160 |
| Ephram    | 2016-03-31 | 100 |
| Fountain  | 2016-01-31 | 180 |
| Gould     | 2016-09-30 | 110 |
| Hess      | 2016-02-28 | 130 |
| Joyce     | 2016-08-27 | 150 |
| Kraft     | 2016-04-15 | 170 |
+-----------+------------+-----+
10 rows in set (0.00 sec)


4. mysql> select * from student where first_name IN ( "Adam", "James", "Frank") order by last_name desc;
+-----+------------+-----------+---------------------+------------+
| id  | first_name | last_name | years_of_experience | start_date |
+-----+------------+-----------+---------------------+------------+
| 150 | James      | Joyce     |                   9 | 2016-08-27 |
| 180 | Frank      | Fountain  |                   8 | 2016-01-31 |
| 120 | Adam       | Ant       |                   5 | 2016-06-02 |
+-----+------------+-----------+---------------------+------------+
3 rows in set (0.00 sec)



5. mysql> select first_name, last_name , start_date from student where ( start_date BETWEEN "2016-01-01" and "2016-06-30" ) order by 3 desc;
+------------+-----------+------------+
| first_name | last_name | start_date |
+------------+-----------+------------+
| Adam       | Ant       | 2016-06-02 |
| Charles    | Caldwell  | 2016-05-07 |
| Kevin      | Kraft     | 2016-04-15 |
| Eric       | Ephram    | 2016-03-31 |
| Howard     | Hess      | 2016-02-28 |
| Frank      | Fountain  | 2016-01-31 |
+------------+-----------+------------+
6 rows in set (0.04 sec)




6. mysql> alter table assignment add foreign key (grade_id) references grade(grade_id);
Query OK, 0 rows affected (1.14 sec)
Records: 0  Duplicates: 0  Warnings: 0


7. mysql> explain assignment;
+----------------+---------+------+-----+---------+-------+
| Field          | Type    | Null | Key | Default | Extra |
+----------------+---------+------+-----+---------+-------+
| id             | int(11) | NO   | PRI | NULL    |       |
| student_id     | int(11) | NO   | MUL | NULL    |       |
| assignment_nbr | int(11) | NO   |     | NULL    |       |
| grade_id       | int(11) | YES  | MUL | NULL    |       |
+----------------+---------+------+-----+---------+-------+
4 rows in set (0.00 sec)


8. mysql> select * from assignment;
+----+------------+----------------+----------+
| id | student_id | assignment_nbr | grade_id |
+----+------------+----------------+----------+
|  1 |        110 |             10 |        0 |
|  2 |        120 |             11 |        1 |
|  3 |        130 |             11 |        2 |
|  4 |        140 |             11 |        3 |
|  5 |        150 |             11 |        4 |
|  6 |        110 |             11 |        3 |
+----+------------+----------------+----------+
6 rows in set (0.00 sec)



9. mysql> explain grade;
+-------------+-------------+------+-----+---------+-------+
| Field       | Type        | Null | Key | Default | Extra |
+-------------+-------------+------+-----+---------+-------+
| grade_id    | int(11)     | NO   | PRI | NULL    |       |
| grade_value | varchar(50) | YES  |     | NULL    |       |
+-------------+-------------+------+-----+---------+-------+
2 rows in set (0.04 sec)



10. mysql> select * from grade;
+----------+-----------------------------+
| grade_id | grade_value                 |
+----------+-----------------------------+
|        0 | Not graded                  |
|        1 | Incomplete                  |
|        2 | Complete and Unsatisfactory |
|        3 | Complete and Satisfactory   |
|        4 | Exceeds expectations        |
+----------+-----------------------------+
5 rows in set (0.00 sec)



11. mysql> insert assignment values(7, 200, 11, 3);
ERROR 1452 (23000): Cannot add or update a child row: a foreign key constraint fails (`tiy`.`assignment`, CONSTRAINT `assignment_ibfk_1` FOREIGN
KEY (`student_id`) REFERENCES `student` (`id`))




12. mysql> insert assignment values(7, 120, 12, 7);
ERROR 1452 (23000): Cannot add or update a child row: a foreign key constraint fails (`tiy`.`assignment`, CONSTRAINT `assignment_ibfk_2` FOREIGN
KEY (`grade_id`) REFERENCES `grade` (`grade_id`))


