package datamanagement;

/**
 * The main controller class for the CheckGrade application;
 * this class initiates the GUI and directs the flow of data. 
 */
public class CheckGradeController
{

  private CheckGradeUI checkGradeUI_;
  private String       unitCode_;
  private Integer      studentId_;
  private boolean      isChanged_;



  public CheckGradeController()
  {
  }



  /**
   * This method creates the Graphical User Interface, the function passes in
   * the initial GUI state and sets initial list values.
   */
  public void execute ()
  {
    checkGradeUI_ = new CheckGradeUI (this);
    ListUnitsController listUnitsController = new ListUnitsController ();

    checkGradeUI_.setUnitComboState (false);
    checkGradeUI_.setStudentComboState (false);
    checkGradeUI_.setCheckButtonState (false);
    checkGradeUI_.setChangeButtonState (false);
    checkGradeUI_.setSaveButtonState (false);
    checkGradeUI_.setSaveButtonState (false);
    checkGradeUI_.refresh ();

    listUnitsController.listUnits (checkGradeUI_);
    checkGradeUI_.setVisible (true);
    checkGradeUI_.setUnitComboState (true);
  }



  /**
   * Sets the Student comboBox with list of students based on unit code
   * 
   * @param unitCode
   *          the unit code to get student enrolment information for.
   */
  public void selectUnit (String unitCode)
  {

    if (unitCode.equals ("NONE"))
      checkGradeUI_.setStudentComboState (false);
    else {
      ListStudentsController listStudentsController =
          new ListStudentsController ();
      
      listStudentsController.listStudents (checkGradeUI_, unitCode);
      unitCode_ = unitCode;
      checkGradeUI_.setStudentComboState (true);
    }
    checkGradeUI_.setCheckButtonState (false);
  }



  /**
   * Set GUI results text fields based on student selected
   * 
   * @param studentId
   *          the selected student
   */
  public void selectStudent (Integer studentId)
  {

    studentId_ = studentId;

    if (studentId_.intValue () == 0) {
      checkGradeUI_.refresh ();
      checkGradeUI_.setCheckButtonState (false);
      checkGradeUI_.setChangeButtonState (false);
      checkGradeUI_.setResultTextState (false);
      checkGradeUI_.setSaveButtonState (false);
    }
    else {
      Student student = StudentManager.get ().getStudent (studentId);

      StudentUnitRecord record = student.getUnitRecord (unitCode_);

      checkGradeUI_.setRecord (record);
      checkGradeUI_.setCheckButtonState (true);
      checkGradeUI_.setChangeButtonState (true);
      checkGradeUI_.setResultTextState (false);
      checkGradeUI_.setSaveButtonState (false);
      isChanged_ = false;
    }
  }



  /**
   * Checks the student grade based on assignment and exam results
   * 
   * @param assignment1Mark
   *          is the result the student obtained in assignment1
   * @param assignment2Mark
   *          is the result the student obtained in assignment2
   * @param examMark
   *          is the result the student obtained in exam
   * @return the overall grade the student is to receive based on results
   */
  public String checkGrade (float assignment1Mark, float assignment2Mark,
      float examMark)
  {
    Unit unit = UnitManager.UM ().getUnit (unitCode_);
    String grade = unit.getGrade (assignment1Mark, assignment2Mark, examMark);
    checkGradeUI_.setChangeButtonState (true);
    checkGradeUI_.setResultTextState (false);
    if (isChanged_) {
      checkGradeUI_.setSaveButtonState (true);
    }
    return grade;
  }



  /**
   * Set's the state of GUI to enable editing results text fields
   */
  public void enableChangeMarks ()
  {
    checkGradeUI_.setChangeButtonState (false);
    checkGradeUI_.setSaveButtonState (false);
    checkGradeUI_.setResultTextState (true);
    isChanged_ = true;
  }



  /**
   * Stores the results from the text fields to the iStudent record
   * 
   * @param assignment1Mark
   *          is the result the student obtained in assignment1
   * @param assignment2Mark
   *          is the result the student obtained in assignment2
   * @param examMark
   *          is the result the student obtained in exam
   */
  public void saveGrade (float assignment1Mark, float assignment2Mark,
      float examMark)
  {
    Student student = StudentManager.get ().getStudent (studentId_);

    StudentUnitRecord record = student.getUnitRecord (unitCode_);
    record.setAsg1 (assignment1Mark);
    record.setAsg2 (assignment2Mark);
    record.setExam (examMark);
    StudentUnitRecordManager.instance ().saveRecord (record);
    checkGradeUI_.setChangeButtonState (true);
    checkGradeUI_.setResultTextState (false);
    checkGradeUI_.setSaveButtonState (false);
  }
}
