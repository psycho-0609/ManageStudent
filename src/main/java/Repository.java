import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Repository {

    public List<Student> getAllStudent() {
        ResultSet rs;
        List<Student> listStudent = new ArrayList<>();
        String sql = "Select * from tbl_hssinhvien";
        try {
            Connection con = ConnectionDB.getConnection();
            Statement statement = con.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()){
                listStudent.add(mappingData(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listStudent;
    }

    public Student insertStudent(Student student) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("insert into tbl_hssinhvien(id, name, dob, sex, address, phone)");
        sqlBuilder.append("values ('" + student.getId() + "','" + student.getName() + "','" + student.getDob() + "',");
        sqlBuilder.append("'" + student.getSex() + "', '" + student.getAddress() + "' ,'" + student.getPhone() + "')");
        System.out.println(sqlBuilder.toString());
        try {
            Connection con = ConnectionDB.getConnection();
            Statement statement = con.createStatement();

            statement.execute(sqlBuilder.toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    public Student search(String id) {
        Student student = null;
        String sql = "select * from tbl_hssinhvien where id = " + id;
        ResultSet rs;
        try {
            Connection con = ConnectionDB.getConnection();
            Statement statement = con.createStatement();
            rs = statement.executeQuery(sql);
            if(rs.next()){
                student = mappingData(rs);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    public Student mappingData(ResultSet rs) throws SQLException {
        Student student = new Student();
        student.setId(rs.getString("id"));
        student.setName(rs.getString("name"));
        student.setSex(rs.getString("sex"));
        student.setAddress(rs.getString("address"));
        student.setDob(rs.getString("dob"));
        student.setPhone(rs.getString("phone"));
        return student;
    }


}
