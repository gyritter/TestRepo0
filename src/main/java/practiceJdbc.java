public class practiceJdbc {

    //EGYEDI ÉRTÉKEKET SZÁMOL
    //SELECT COUNT(DISTINCT Trait) As Count FROM RESULTS WHERE name = ?

    //SELECT COUNT(DISTINCT Trait) As Count FROM RESULTS WHERE name = 'aaa';


    //MEGSZÁMOLJA A NEM ÜRES REKORDOKAT
    //SQL SELECT COUNT(column_name)
    //SELECT COUNT(name) FROM employee_table;
    //It will return the total number of names of employee_table. But null fields will not be counted.



    //MEGSZÁMOLJA A REKORDOKAT
    //SQL SELECT COUNT(*)
    //SELECT COUNT(*) FROM employee_table;
    //The "select count(*) from table" is used to return the number of records in table.


    //EGYEDI ÉRTÉKEKET SZÁMOL
    //SQL SELECT COUNT(DISTINCT column_name)
    //SELECT COUNT(DISTINCT name) FROM employee_table;
    //It will return the total distinct names of employee_table.

    //MAXOT KERES
    //PreparedStatement stat;
    //ResultSet rs;
    //String sql = "SELECT MAX(id) AS max_id FROM home";
    //stat = conn.prepareStatement(sql);


    //ÖSSZEGEZ
    // conn.prepareStatement("Select Sum(points_earned) as sum_points FROM house_points WHERE house_name =?");


    //RENDEZ
    // conn.prepareStatement("SELECT lower(NAME) as name FROM dog_types WHERE lower(country) = lower(?) ORDER BY NAME");
}