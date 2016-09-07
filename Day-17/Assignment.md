alter table student add ( gpa decimal(5,1) , sat integer CHECK (sat >= 400 and sat <= 1600) , major_id integer );

mysql> explain student;
+---------------------+--------------+------+-----+---------+-------+
| Field               | Type         | Null | Key | Default | Extra |
+---------------------+--------------+------+-----+---------+-------+
| id                  | int(11)      | NO   | PRI | NULL    |       |
| first_name          | varchar(30)  | NO   |     | NULL    |       |
| last_name           | varchar(30)  | NO   |     | NULL    |       |
| years_of_experience | int(11)      | NO   |     | NULL    |       |
| start_date          | date         | NO   |     | NULL    |       |
| gpa                 | decimal(5,1) | YES  |     | NULL    |       |
| sat                 | int(11)      | YES  |     | NULL    |       |
| major_id            | int(11)      | YES  |     | NULL    |       |
+---------------------+--------------+------+-----+---------+-------+
8 rows in set (0.00 sec)


alter table student drop column years_of_experience;

mysql> explain student;
+------------+--------------+------+-----+---------+-------+
| Field      | Type         | Null | Key | Default | Extra |
+------------+--------------+------+-----+---------+-------+
| id         | int(11)      | NO   | PRI | NULL    |       |
| first_name | varchar(30)  | NO   |     | NULL    |       |
| last_name  | varchar(30)  | NO   |     | NULL    |       |
| start_date | date         | NO   |     | NULL    |       |
| gpa        | decimal(5,1) | YES  |     | NULL    |       |
| sat        | int(11)      | YES  |     | NULL    |       |
| major_id   | int(11)      | YES  |     | NULL    |       |
+------------+--------------+------+-----+---------+-------+
7 rows in set (0.00 sec)


mysql> explain major;
+-----------+-------------+------+-----+---------+-------+
| Field     | Type        | Null | Key | Default | Extra |
+-----------+-------------+------+-----+---------+-------+
| id        | int(11)     | NO   | PRI | NULL    |       |
| name      | varchar(50) | YES  |     | NULL    |       |
| sat_score | int(11)     | YES  |     | NULL    |       |
+-----------+-------------+------+-----+---------+-------+
3 rows in set (0.00 sec)


mysql> explain major_class_xref;
+----------+---------+------+-----+---------+-------+
| Field    | Type    | Null | Key | Default | Extra |
+----------+---------+------+-----+---------+-------+
| id       | int(11) | NO   | PRI | NULL    |       |
| major_id | int(11) | YES  | MUL | NULL    |       |
| class_id | int(11) | YES  | MUL | NULL    |       |
+----------+---------+------+-----+---------+-------+
3 rows in set (0.00 sec)

mysql> explain class;
+---------------+-------------+------+-----+---------+-------+
| Field         | Type        | Null | Key | Default | Extra |
+---------------+-------------+------+-----+---------+-------+
| id            | int(11)     | NO   | PRI | NULL    |       |
| name          | varchar(30) | YES  |     | NULL    |       |
| instructor_id | int(11)     | YES  | MUL | NULL    |       |
+---------------+-------------+------+-----+---------+-------+
3 rows in set (0.00 sec)

mysql> explain instructor;
+--------------+-------------+------+-----+---------+-------+
| Field        | Type        | Null | Key | Default | Extra |
+--------------+-------------+------+-----+---------+-------+
| id           | int(11)     | NO   | PRI | NULL    |       |
| first_name   | varchar(30) | YES  |     | NULL    |       |
| last_name    | varchar(30) | YES  |     | NULL    |       |
| major_id     | int(11)     | YES  | MUL | NULL    |       |
| years_of_exp | int(11)     | YES  |     | NULL    |       |
| tenured      | tinyint(1)  | YES  |     | NULL    |       |
+--------------+-------------+------+-----+---------+-------+
6 rows in set (0.00 sec)

create table student_class_xref  (id int primary key, student_id int, foreign key(student_id) references student(id), class_id int, foreign key (class_id) references class(id) );

mysql> explain student_class_xref;
+------------+---------+------+-----+---------+-------+
| Field      | Type    | Null | Key | Default | Extra |
+------------+---------+------+-----+---------+-------+
| id         | int(11) | NO   | PRI | NULL    |       |
| student_id | int(11) | YES  | MUL | NULL    |       |
| class_id   | int(11) | YES  | MUL | NULL    |       |
+------------+---------+------+-----+---------+-------+
3 rows in set (0.00 sec)


alter table assignment add ( class_id int , foreign key (class_id) references class(id) ) ;

mysql> explain assignment;
+----------------+---------+------+-----+---------+-------+
| Field          | Type    | Null | Key | Default | Extra |
+----------------+---------+------+-----+---------+-------+
| id             | int(11) | NO   | PRI | NULL    |       |
| student_id     | int(11) | NO   | MUL | NULL    |       |
| assignment_nbr | int(11) | NO   |     | NULL    |       |
| grade_id       | int(11) | YES  | MUL | NULL    |       |
| class_id       | int(11) | YES  | MUL | NULL    |       |
+----------------+---------+------+-----+---------+-------+
5 rows in set (0.00 sec)


mysql> select * from major;
+----+------------------+-----------+
| id | name             | sat_score |
+----+------------------+-----------+
|  1 | General Business |       800 |
|  2 | Accounting       |      1000 |
|  3 | Finance          |      1100 |
|  4 | Math             |      1300 |
|  5 | Engineering      |      1350 |
|  6 | Education        |       900 |
|  7 | General Studies  |       500 |
+----+------------------+-----------+
7 rows in set (0.00 sec)

mysql> select * from instructor;
+----+------------+-----------+----------+--------------+---------+
| id | first_name | last_name | major_id | years_of_exp | tenured |
+----+------------+-----------+----------+--------------+---------+
|  1 | Aaron      | Test      |        1 |            2 |       1 |
|  2 | Peter      | Test      |        2 |           21 |       1 |
|  3 | Claire     | Test      |        3 |           12 |       1 |
|  4 | John       | Test      |        4 |            3 |       1 |
|  5 | Steph      | Test      |        5 |            5 |       1 |
|  6 | Mike       | Test      |        6 |            8 |       1 |
|  7 | Daniel     | Test      |        7 |            9 |       1 |
|  8 | Xtra       | Test      |        4 |            1 |       0 |
+----+------------+-----------+----------+--------------+---------+
8 rows in set (0.00 sec)


mysql> select * from class;
+----+----------------------+---------------+
| id | name                 | instructor_id |
+----+----------------------+---------------+
|  1 | English 101          |             6 |
|  2 | English 102          |             6 |
|  3 | English 103          |             6 |
|  4 | English 201          |             6 |
|  5 | English 202          |             6 |
|  6 | English 203          |             6 |
|  7 | English 301          |             6 |
|  8 | English 302          |             6 |
|  9 | English 303          |             6 |
| 10 | Math 201             |             4 |
| 11 | Math 202             |             4 |
| 12 | Math 203             |             4 |
| 13 | Math 204             |             4 |
| 14 | Math 301             |             4 |
| 15 | Math 302             |             4 |
| 16 | Math 303             |             4 |
| 17 | Math 304             |             4 |
| 18 | History 101          |             7 |
| 19 | History 201          |             7 |
| 20 | History 301          |             7 |
| 21 | Computer Science 311 |             5 |
| 22 | Computer Science 312 |             5 |
| 23 | Computer Science 313 |             5 |
| 24 | Computer Science 441 |             5 |
| 25 | Computer Science 442 |             5 |
| 26 | Computer Science 443 |             5 |
| 27 | Psychology 101       |             1 |
| 28 | Psychology 102       |             1 |
| 29 | Psychology 231       |             1 |
| 30 | Psychology 232       |             1 |
| 31 | Education 221        |             2 |
| 32 | Education 222        |             2 |
| 33 | Education 223        |             2 |
| 34 | Education 351        |             2 |
| 35 | Education 352        |             2 |
| 36 | Education 353        |             2 |
+----+----------------------+---------------+
36 rows in set (0.00 sec)


mysql> select * from major_class_xref;
+----+----------+----------+
| id | major_id | class_id |
+----+----------+----------+
|  1 |        1 |        1 |
|  2 |        1 |        5 |
|  3 |        1 |       10 |
|  4 |        2 |       11 |
|  5 |        2 |       12 |
|  6 |        2 |       18 |
|  7 |        3 |       21 |
|  8 |        3 |       36 |
|  9 |        3 |        2 |
| 10 |        4 |        3 |
| 11 |        4 |       13 |
| 12 |        4 |       34 |
| 13 |        5 |       14 |
| 14 |        5 |       15 |
| 15 |        5 |       16 |
| 16 |        6 |       34 |
| 17 |        6 |       35 |
| 18 |        6 |       36 |
| 19 |        6 |       35 |
| 20 |        7 |       18 |
| 21 |        7 |       19 |
| 22 |        7 |        9 |
+----+----------+----------+
22 rows in set (0.00 sec)


mysql> select * from student;
+-----+------------+-----------+------------+------+------+----------+
| id  | first_name | last_name | start_date | gpa  | sat  | major_id |
+-----+------------+-----------+------------+------+------+----------+
| 100 | Eric       | Ephram    | 2016-03-31 |  3.8 | 1200 |        1 |
| 110 | Greg       | Gould     | 2016-09-30 |  3.9 | 1300 |        2 |
| 120 | Adam       | Ant       | 2016-06-02 |  4.0 | 1600 |        3 |
| 130 | Howard     | Hess      | 2016-02-28 |  3.4 |  900 |        4 |
+-----+------------+-----------+------------+------+------+----------+
4 rows in set (0.00 sec)

	
mysql> select * from student_class_xref;
+----+------------+----------+
| id | student_id | class_id |
+----+------------+----------+
|  1 |        100 |        1 |
|  2 |        100 |        2 |
|  3 |        100 |        3 |
|  4 |        100 |        4 |
|  5 |        110 |        5 |
|  6 |        110 |        6 |
|  7 |        110 |        7 |
|  8 |        110 |        8 |
|  9 |        120 |        9 |
| 10 |        120 |       10 |
| 11 |        120 |       11 |
| 12 |        120 |       12 |
| 13 |        130 |       13 |
| 14 |        130 |       14 |
| 15 |        130 |       15 |
| 16 |        130 |       16 |
+----+------------+----------+
16 rows in set (0.00 sec)

mysql> select * from assignment;
+----+------------+----------------+----------+----------+
| id | student_id | assignment_nbr | grade_id | class_id |
+----+------------+----------------+----------+----------+
|  1 |        110 |             10 |        0 |        1 |
|  2 |        120 |             11 |        1 |        2 |
|  3 |        130 |             11 |        2 |        3 |
|  6 |        110 |             11 |        3 |        4 |
+----+------------+----------------+----------+----------+
4 rows in set (0.00 sec)



