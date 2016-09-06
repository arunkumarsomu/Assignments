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





