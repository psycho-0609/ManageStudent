import java.util.List;

public class Service {

    private Repository repository;

    public Service(){
        repository = new Repository();
    }

    public List<Student> getAllStudent(){
        return repository.getAllStudent();
    }

    public void insertStudent(Student student){
        if(repository.search(student.getId()) != null){
            System.out.println("ID da ton tai");
        }else{
            repository.insertStudent(student);
        }
    }

    public Student searchStudent(String id){
        return repository.search(id);
    }
}
