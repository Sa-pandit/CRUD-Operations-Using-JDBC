import javax.imageio.plugins.tiff.ExifTIFFTagSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Students {
    public static void main(String[] args) {


        try {
            String MySqlDriver = "com.mysql.cj.jdbc.Driver";
            String MySqlUrl = "jdbc:mysql://localhost:3306/test";
            System.out.println("Connecting to database...");

            Class.forName(MySqlDriver);
            Connection con = DriverManager.getConnection(MySqlUrl, "root", "root");
            PreparedStatement ps = con.prepareStatement("create table if not exists students1 (Id int ,name varchar(50), Course varchar(100), age int)");
            int count = ps.executeUpdate();
            System.out.println("Student information");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Student ID");
            int id = sc.nextInt();
            System.out.println("Enter Student Name");
            String name = sc.next();
            System.out.println("Enter Student Course");
            String course = sc.next();
            System.out.println("Enter Student Age");
            int age = sc.nextInt();


            int choice;
            do {

                System.out.println("1. Add Student info");
                System.out.println("2. Update Student");
                System.out.println("3. Delete Student");
                System.out.println("4. All Records");
                System.out.println("5. Exit");
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        PreparedStatement check1 =
                                con.prepareStatement("SELECT Id FROM students1 WHERE Id = ?");
                        check1.setInt(1, id);
                        ResultSet rs1 = check1.executeQuery();

                        if (rs1.next()) {
                            System.out.println(" Please enter valid Id (Id already exists)");
                        } else {
                            PreparedStatement pst =
                                    con.prepareStatement(
                                            "INSERT INTO students1 (Id, name, Course, age) VALUES (?,?,?,?)");

                            pst.setInt(1, id);
                            pst.setString(2, name);
                            pst.setString(3, course);
                            pst.setInt(4, age);

                            pst.executeUpdate();
                            System.out.println(" Student record added successfully");
                        }
                        break;


                    case 2:

                        PreparedStatement check2 =
                                con.prepareStatement("SELECT Id FROM students1 WHERE Id = ?");
                        check2.setInt(1, id);
                        ResultSet rs2 = check2.executeQuery();

                        if (rs2.next()) {

                            System.out.println("Enter Student ID");
                            int id2 = sc.nextInt();

                            System.out.println("Enter new Student Name:");
                            String newName = sc.next();

                            System.out.println("Enter new Student Course:");
                            String newCourse = sc.next();

                            System.out.println("Enter new Student Age:");
                            int newAge = sc.nextInt();

                            PreparedStatement pst1 =
                                    con.prepareStatement(
                                            "UPDATE students1 SET name = ?, Course = ?, age = ? WHERE Id = ?");

                            pst1.setString(1, name);
                            pst1.setString(2, course);
                            pst1.setInt(3, age);
                            pst1.setInt(4, id);

                            pst1.executeUpdate();
                            System.out.println("Student record updated successfully");
                        } else {
                            System.out.println(" Invalid Id, record not found");
                        }
                        break;

                    case 3:

                        System.out.println("Enter Student Id to delete:");
                        int deleteId = sc.nextInt();

                        PreparedStatement check3 =
                                con.prepareStatement("SELECT Id FROM students1 WHERE Id = ?");
                        check3.setInt(1, id);
                        ResultSet rs3 = check3.executeQuery();

                        if (rs3.next()) {
                            PreparedStatement pst2 =
                                    con.prepareStatement("DELETE FROM students1 WHERE Id = ?");
                            pst2.setInt(1, id);
                            pst2.executeUpdate();
                            System.out.println(" Student record deleted");
                        } else {
                            System.out.println(" Invalid Id, record not found");
                        }
                        break;

                    case 4:
                        PreparedStatement pst4 =
                                con.prepareStatement("SELECT * FROM students1");
                        ResultSet rs4 = pst4.executeQuery();

                        System.out.println("ID\tName\tCourse\tAge");
                        System.out.println("---------------------------");

                        while (rs4.next()) {
                            System.out.println(
                                    rs4.getInt("Id") + "\t" +
                                            rs4.getString("name") + "\t" +
                                            rs4.getString("Course") + "\t" +
                                            rs4.getInt("age")
                            );
                        }
                        break;

                    case 5:

                                System.out.println("Exiting program...");
                                break;
                }
           } while (choice!= 5);


        } catch (Exception e) {
            e.printStackTrace();


        }

    }


}




