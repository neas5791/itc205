package datamanagement;
        public class ListStudentsController {
private StudentManager sm;
public ListStudentsController() {sm = StudentManager.get();}
            public void listStudents( StudentLister lister, String unitCode ) {
    lister.clearStudents();
                StudentMap students = sm.getStudentsByUnit( unitCode );
for (Integer id : students.keySet() ) lister.addStudent(students.get(id));}}
