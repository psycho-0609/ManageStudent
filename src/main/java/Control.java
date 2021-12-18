import java.util.List;
import java.util.Scanner;

public class Control {

    private Service service;
    Scanner scanner = new Scanner(System.in);

    public Control(){
        service = new Service();
    }

    public void getAllStudent(){
        List<Student> studentList = service.getAllStudent();
        System.out.println("----------Danh sach sinh vien---------");
        System.out.print("ID");
        System.out.print("\t\t\t");
        System.out.print("Name");
        System.out.print("\t\t\t");
        System.out.print("Ngay sinh");
        System.out.print("\t\t\t");
        System.out.print("Gioi tinh");
        System.out.print("\t\t\t");
        System.out.print("Dia chi");
        System.out.print("\t\t\t");
        System.out.print("So dien thoai");
        System.out.println();
        studentList.forEach(student -> printStudent(student));
    }

    public void insertStudent(){
        System.out.println("----------Them sinh vien moi----------");
        System.out.println("Nhap id");
        String id = scanner.nextLine();
        System.out.println("Nhap ten");
        String name = scanner.nextLine();
        System.out.println("Nhap ngay sinh");
        String dob = scanner.nextLine();
        System.out.println("Nhap gioi tinh");
        String sex = scanner.nextLine();
        System.out.println("Nhap dia chi");
        String address = scanner.nextLine();
        System.out.println("Nhap so dien thoai");
        String phone = scanner.nextLine();
        service.insertStudent(new Student(id, name, dob, sex, address, phone));
    }
    public void searchStudent(){
        System.out.println("----------Tim kiem sinh vien----------");
        System.out.println("Nhap id");
        String id = scanner.nextLine();
        Student student = service.searchStudent(id);
        if(student == null){
            System.out.println("Khong tim thay sinh vien");
        }else{
            System.out.print("ID");
            System.out.print("\t\t\t");
            System.out.print("Name");
            System.out.print("\t\t\t");
            System.out.print("Ngay sinh");
            System.out.print("\t\t\t");
            System.out.print("Gioi tinh");
            System.out.print("\t\t\t");
            System.out.print("Dia chi");
            System.out.print("\t\t\t");
            System.out.print("So dien thoai");
            System.out.println();
            printStudent(student);
        }
    }
    private void printStudent(Student student){
        System.out.print(student.getId());
        System.out.print("\t\t\t");
        System.out.print(student.getName());
        System.out.print("\t\t\t");
        System.out.print(student.getDob());
        System.out.print("\t\t\t");
        System.out.print(student.getSex());
        System.out.print("\t\t\t\t\t");
        System.out.print(student.getAddress());
        System.out.print("\t\t\t");
        System.out.print(student.getPhone());
        System.out.println();
    }
}
