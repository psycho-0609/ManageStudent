import java.util.Scanner;

public class Menu {

    private Control control;
    Scanner scanner = new Scanner(System.in);
    public Menu(){
        control = new Control();
    }

    public void run(){
        while (true){
            printMenu();
            System.out.println("Nhap lua chon");
            int choice = scanner.nextInt();
            switch (choice){
                case 1: control.getAllStudent();
                    break;
                case 2: control.insertStudent();
                    break;
                case 3: control.searchStudent();
                    break;
                case 4: System.exit(0);
                    break;
                default:
                    System.out.println("Vui long nhap dung lua chon");
                    break;
            }
        }
    }

    private void printMenu(){
        System.out.println("----------Menu---------");
        System.out.println("1. Danh sach sinh vien");
        System.out.println("2. Them moi sinh vien");
        System.out.println("3. Tim kiem sinh vien");
        System.out.println("4. Thoat");
        System.out.println("-----------------------");
    }


}
