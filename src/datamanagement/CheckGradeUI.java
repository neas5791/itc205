package datamanagement;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

/**
 * The graphical user interface for the CheckGrade application.
 */
public class CheckGradeUI extends JFrame implements UnitLister, StudentLister
{

  private CheckGradeController checkGradeController_;

  private float   assignment1Mark_;
  private float   assignment2Mark_;
  private float   examMark_;
  private Integer studentId_;

  // javax.swing objects
  private DefaultComboBoxModel<String> unitsComboBoxModel_;
  private DefaultComboBoxModel<String> studentsComboBoxModel_;
  private JComboBox<String>            unitsComboBox_;
  private JComboBox<String>            studentsComboBox_;

  private JButton changeButton_;
  private JButton checkButton_;
  private JButton saveButton_;

  private JLabel titleLabel_;
  private JLabel assignment1Label_;
  private JLabel assignment2Label_;
  private JLabel examLabel_;
  private JLabel gradeLabel_;
  private JLabel errorLabel_;

  private JPanel unitsPanel_;
  private JPanel studentsPanel_;
  private JPanel recordPanel_;
  private JPanel gradePanel_;

  private JTextField assignment1MarkTextField_;
  private JTextField assignment2MarkTextField_;
  private JTextField examMarkTextField_;



  /**
   * Creates new instance of CheckGradeUI object.
   * 
   * @param checkGradeController
   *          the controller class for this Model-View-Controller member
   */
  public CheckGradeUI(CheckGradeController checkGradeController)
  {
    checkGradeController_  = checkGradeController;
    unitsComboBoxModel_    = new DefaultComboBoxModel<String> (new String[0]);
    studentsComboBoxModel_ = new DefaultComboBoxModel<String> (new String[0]);

    initializeComponents ();
    unitsComboBox_.setModel (unitsComboBoxModel_);
    studentsComboBox_.setModel (studentsComboBoxModel_);
    errorLabel_.setText ("");
  }



  private void initializeComponents ()
  {

    titleLabel_               = new JLabel ();
    assignment1Label_         = new JLabel ();
    assignment2Label_         = new JLabel ();
    examLabel_                = new JLabel ();
    gradeLabel_               = new JLabel ();

    unitsComboBox_            = new JComboBox<String> ();
    studentsComboBox_         = new JComboBox<String> ();

    assignment1MarkTextField_ = new JTextField ();
    assignment2MarkTextField_ = new JTextField ();
    examMarkTextField_        = new JTextField ();

    changeButton_             = new JButton ();
    checkButton_              = new JButton ();
    saveButton_               = new JButton ();

    unitsPanel_               = new JPanel ();
    studentsPanel_            = new JPanel ();
    recordPanel_              = new JPanel ();
    gradePanel_               = new JPanel ();

    setDefaultCloseOperation (EXIT_ON_CLOSE);

    titleLabel_.setFont (new Font ("Tahoma", 0, 16));

    titleLabel_.setText ("Check Grade UI");

    unitsPanel_.setBorder (BorderFactory.createTitledBorder ("Unit"));

    unitsComboBox_.setModel (unitsComboBoxModel_);

    unitsComboBox_.addItemListener (new ItemListener () {
      public void itemStateChanged (ItemEvent event)
      {
        unitComboBoxItemStateChanged (event);
      }
    });

    GroupLayout unitPanelLayout = new GroupLayout (unitsPanel_);

    unitsPanel_.setLayout (unitPanelLayout);

    unitPanelLayout.setHorizontalGroup (unitPanelLayout
        .createParallelGroup (GroupLayout.Alignment.LEADING)
        .addGroup (unitPanelLayout.createSequentialGroup ().addContainerGap ()
            .addComponent (unitsComboBox_, GroupLayout.PREFERRED_SIZE, 185,
                GroupLayout.PREFERRED_SIZE)
            .addContainerGap (GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

    unitPanelLayout.setVerticalGroup (
        unitPanelLayout.createParallelGroup (GroupLayout.Alignment.LEADING)
            .addGroup (unitPanelLayout.createSequentialGroup ()
                .addComponent (unitsComboBox_, GroupLayout.PREFERRED_SIZE,
                    GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap (GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

    studentsPanel_.setBorder (BorderFactory.createTitledBorder ("Student"));

    studentsComboBox_.setModel (studentsComboBoxModel_);

    studentsComboBox_.addItemListener (new ItemListener () {
      public void itemStateChanged (ItemEvent event)
      {
        studentComboBoxItemStateChanged (event);
      }
    });

    GroupLayout studentPanelLayout = new GroupLayout (studentsPanel_);

    studentsPanel_.setLayout (studentPanelLayout);

    studentPanelLayout.setHorizontalGroup (
        studentPanelLayout.createParallelGroup (GroupLayout.Alignment.LEADING)
            .addGroup (studentPanelLayout.createSequentialGroup ()
                .addContainerGap ()
                .addComponent (studentsComboBox_, GroupLayout.PREFERRED_SIZE,
                    185, GroupLayout.PREFERRED_SIZE)
                .addContainerGap (GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

    studentPanelLayout.setVerticalGroup (
        studentPanelLayout.createParallelGroup (Alignment.LEADING)
            .addGroup (studentPanelLayout.createSequentialGroup ()
                .addComponent (studentsComboBox_, GroupLayout.PREFERRED_SIZE,
                    GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap (GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

    recordPanel_.setBorder (BorderFactory.createTitledBorder ("Marks"));

    assignment1Label_.setText ("Asg1:");

    assignment2Label_.setText ("Asg2:");

    examLabel_.setText ("Exam:");

    assignment1MarkTextField_.setEditable (false);
    assignment1MarkTextField_.addKeyListener (new KeyAdapter () {
      public void keyTyped (KeyEvent event)
      {
        jTextFieldKeyTyped (event);
      }
    });

    assignment2MarkTextField_.setEditable (false);
    assignment2MarkTextField_.addKeyListener (new KeyAdapter () {
      public void keyTyped (KeyEvent event)
      {
        jTextFieldKeyTyped (event);
      }
    });

    examMarkTextField_.setEditable (false);
    examMarkTextField_.addKeyListener (new KeyAdapter () {
      public void keyTyped (KeyEvent event)
      {
        jTextFieldKeyTyped (event);
      }
    });

    changeButton_.setText ("Change");
    changeButton_.addActionListener (new ActionListener () {
      public void actionPerformed (ActionEvent event)
      {
        changeButtonActionPerformed (event);
      }
    });

    checkButton_.setText ("Check Grade");

    checkButton_.setActionCommand ("checkGrade");

    checkButton_.addActionListener (new ActionListener () {
      public void actionPerformed (ActionEvent event)
      {
        saveButtonActionPerformed (event);
      }
    });

    GroupLayout resultRecordPanelLayout = new GroupLayout (recordPanel_);

    resultRecordPanelLayout.setHorizontalGroup (
        resultRecordPanelLayout.createParallelGroup (Alignment.LEADING)
            .addGroup (resultRecordPanelLayout.createSequentialGroup ()
                .addGroup (resultRecordPanelLayout
                    .createParallelGroup (Alignment.LEADING)
                    .addGroup (resultRecordPanelLayout.createSequentialGroup ()
                        .addContainerGap ().addComponent (assignment1Label_)
                        .addPreferredGap (ComponentPlacement.RELATED)
                        .addComponent (assignment1MarkTextField_,
                            GroupLayout.PREFERRED_SIZE, 59,
                            GroupLayout.PREFERRED_SIZE)
                        .addGap (18).addComponent (assignment2Label_))
                    .addGroup (resultRecordPanelLayout.createSequentialGroup ()
                        .addGap (85).addComponent (changeButton_,
                            GroupLayout.PREFERRED_SIZE, 84,
                            GroupLayout.PREFERRED_SIZE)))
                .addGap (18)
                .addGroup (resultRecordPanelLayout
                    .createParallelGroup (Alignment.TRAILING)
                    .addGroup (resultRecordPanelLayout.createSequentialGroup ()
                        .addComponent (assignment2MarkTextField_,
                            GroupLayout.PREFERRED_SIZE, 59,
                            GroupLayout.PREFERRED_SIZE)
                        .addGap (18).addComponent (examLabel_))
                    .addComponent (checkButton_))
                .addGap (18).addComponent (examMarkTextField_,
                    GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                .addGap (15)));

    resultRecordPanelLayout.setVerticalGroup (resultRecordPanelLayout
        .createParallelGroup (Alignment.LEADING)
        .addGroup (resultRecordPanelLayout.createSequentialGroup ()
            .addGroup (resultRecordPanelLayout
                .createParallelGroup (Alignment.BASELINE)
                .addComponent (assignment1Label_)
                .addComponent (assignment1MarkTextField_,
                    GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE)
                .addComponent (assignment2Label_)
                .addComponent (assignment2MarkTextField_,
                    GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE)
                .addComponent (examLabel_).addComponent (examMarkTextField_,
                    GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE))
            .addPreferredGap (ComponentPlacement.UNRELATED)
            .addGroup (
                resultRecordPanelLayout.createParallelGroup (Alignment.BASELINE)
                    .addComponent (changeButton_).addComponent (checkButton_))
                .addContainerGap ()));

    recordPanel_.setLayout (resultRecordPanelLayout);

    gradePanel_.setBorder (BorderFactory.createTitledBorder ("Grade"));

    gradeLabel_.setFont (new Font ("Tahoma", 0, 24)); // NOI18N
    gradeLabel_.setForeground (new Color (255, 0, 0));
    gradeLabel_.setHorizontalAlignment (SwingConstants.CENTER);
    gradeLabel_.setText ("grade");

    GroupLayout gradePanelLayout = new GroupLayout (gradePanel_);
    gradePanel_.setLayout (gradePanelLayout);
    gradePanelLayout.setHorizontalGroup (
        gradePanelLayout.createParallelGroup (GroupLayout.Alignment.LEADING)
            .addComponent (gradeLabel_, GroupLayout.Alignment.TRAILING,
                GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE));
    gradePanelLayout.setVerticalGroup (
        gradePanelLayout.createParallelGroup (GroupLayout.Alignment.LEADING)
            .addGroup (gradePanelLayout.createSequentialGroup ()
                .addGap (34, 34, 34).addComponent (gradeLabel_)
                .addContainerGap (43, Short.MAX_VALUE)));

    errorLabel_ = new JLabel ();
    errorLabel_.setText ("Error message");
    errorLabel_.setForeground (Color.RED);
    errorLabel_.setFont (new Font ("Tahoma", Font.PLAIN, 12));

    saveButton_.setText ("Save");
    saveButton_.addActionListener (new ActionListener () {
      public void actionPerformed (ActionEvent event)
      {
        checkButtonActionPerformed (event);
      }
    });

    GroupLayout layout = new GroupLayout (getContentPane ());

    layout.setHorizontalGroup (layout.createParallelGroup (Alignment.LEADING)
        .addGroup (layout.createSequentialGroup ()
            .addGroup (layout.createParallelGroup (Alignment.LEADING)
                .addGroup (layout.createSequentialGroup ().addContainerGap ()
                    .addComponent (errorLabel_, GroupLayout.DEFAULT_SIZE, 400,
                        Short.MAX_VALUE))
            .addGroup (layout.createSequentialGroup ().addContainerGap ()
                .addGroup (layout.createParallelGroup (Alignment.LEADING, false)
                    .addComponent (recordPanel_, GroupLayout.DEFAULT_SIZE,
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup (layout.createSequentialGroup ().addGroup (layout
                        .createParallelGroup (Alignment.LEADING)
                        .addComponent (unitsPanel_, GroupLayout.PREFERRED_SIZE,
                            GroupLayout.DEFAULT_SIZE,
                            GroupLayout.PREFERRED_SIZE)
                        .addComponent (studentsPanel_,
                            GroupLayout.PREFERRED_SIZE,
                            GroupLayout.DEFAULT_SIZE,
                            GroupLayout.PREFERRED_SIZE))
                        .addGap (18).addComponent (gradePanel_,
                            GroupLayout.PREFERRED_SIZE,
                            GroupLayout.DEFAULT_SIZE,
                            GroupLayout.PREFERRED_SIZE))))
            .addGroup (layout.createSequentialGroup ().addGap (157)
                .addComponent (titleLabel_))
            .addGroup (layout.createSequentialGroup ().addGap (165)
                .addComponent (saveButton_, GroupLayout.PREFERRED_SIZE, 86,
                    GroupLayout.PREFERRED_SIZE)))
            .addContainerGap ()));

    layout.setVerticalGroup (layout.createParallelGroup (Alignment.LEADING)
        .addGroup (layout.createSequentialGroup ().addContainerGap ()
            .addComponent (titleLabel_).addGap (13)
            .addGroup (layout.createParallelGroup (Alignment.LEADING)
                .addGroup (layout.createSequentialGroup ()
                    .addComponent (unitsPanel_, GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap (ComponentPlacement.RELATED)
                    .addComponent (studentsPanel_, GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addComponent (gradePanel_, GroupLayout.PREFERRED_SIZE,
                    GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap (ComponentPlacement.RELATED,
                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent (recordPanel_, GroupLayout.PREFERRED_SIZE,
                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap (ComponentPlacement.RELATED)
            .addComponent (saveButton_).addGap (11).addComponent (errorLabel_,
                GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
            .addContainerGap ()));

    getContentPane ().setLayout (layout);

    pack ();
  }



  private void unitComboBoxItemStateChanged (ItemEvent event)
  {
    String unitCode = (String) unitsComboBox_.getSelectedItem ();

    refresh ();

    clearStudents ();

    if (event.getStateChange () == ItemEvent.SELECTED) {

      String noUnitSelected;
      noUnitSelected = (String) unitsComboBox_.getItemAt (0);

      if (unitCode.equals (noUnitSelected))
        unitCode = "NONE";

      checkGradeController_.selectUnit (unitCode);

    }
  }



  private void studentComboBoxItemStateChanged (ItemEvent event)
  {
    refresh ();

    String student = (String) studentsComboBox_.getSelectedItem ();

    if (event.getStateChange () == ItemEvent.SELECTED) {

      if (student.equals ((String) studentsComboBox_.getItemAt (0))) {
        studentId_ = new Integer (0);
        checkGradeController_.selectStudent (studentId_);
      }
      else {
        studentId_ = new Integer (student.split ("\\s")[0]);
      }

      checkGradeController_.selectStudent (studentId_);
    }
  }



  private void saveButtonActionPerformed (ActionEvent event)
  {
    // Get text values from JTextField
    String assignment1TextField  = assignment1MarkTextField_.getText ();
    String assignment2TextField  = assignment2MarkTextField_.getText ();
    String examTextField         = examMarkTextField_.getText ();

    // Parse the text values to class variables
    assignment1Mark_  = Float.parseFloat (assignment1TextField);
    assignment2Mark_  = Float.parseFloat (assignment2TextField);
    examMark_         = Float.parseFloat (examTextField);

    try {
      String grade;

      grade = checkGradeController_
                .checkGrade (assignment1Mark_, assignment2Mark_, examMark_);

      gradeLabel_.setText (grade);
    }
    catch (RuntimeException exception) {
      errorLabel_.setText (exception.getMessage ());
    }
  }



  private void changeButtonActionPerformed (ActionEvent event)
  {
    checkGradeController_.enableChangeMarks ();

    gradeLabel_.setText ("");
  }



  private void checkButtonActionPerformed (ActionEvent event)
  {
    float assignment1Mark;
    float assignment2Mark;
    float examMark;

    // Get text values from JTextField
    String assignment1TextField = assignment1MarkTextField_.getText ();
    String assignment2TextField = assignment2MarkTextField_.getText ();
    String examTextField        = examMarkTextField_.getText ();

    assignment1Mark             = Float.parseFloat (assignment1TextField);
    assignment2Mark             = Float.parseFloat (assignment2TextField);
    examMark                    = Float.parseFloat (examTextField);

    errorLabel_.setText ("");

    try {
      checkGradeController_.saveGrade (assignment1Mark, assignment2Mark,
          examMark);
    }
    catch (RuntimeException exception) {
      errorLabel_.setText (exception.getMessage ());
    }
  }



  private void jTextFieldKeyTyped (KeyEvent event)
  {
    gradeLabel_.setText ("");
    errorLabel_.setText ("");
  }



  /**
   * Removes all unit elements from the GUI unit ComboBox object. iUnitLister
   * interface requirement.
   **/
  public void clearUnits ()
  {
    unitsComboBoxModel_.removeAllElements ();
    unitsComboBoxModel_.addElement ("<none selected>");
    clearStudents ();
  }



  /**
   * Removes all student elements from the GUI student ComboBox object.
   * iStudentLister interface requirement.
   **/
  public void clearStudents ()
  {
    studentsComboBoxModel_.removeAllElements ();
    studentsComboBoxModel_.addElement ("<none selected>");
  }



  /**
   * Add IUnit element to the GUI unitComboBox object list.
   * 
   * @param unit
   *          the unit to be added to ComboBox
   **/
  public void addUnit (Unit unit)
  {
    unitsComboBoxModel_.addElement (unit.getUnitCode ());
  }



  /**
   * Adds a IStudent to the Student ComboBox
   * 
   * @param student
   *          is the IStudent object to be added
   * @see datamanagement.StudentLister#addStudent(datamanagement.Student)
   */
  public void addStudent (Student student)
  {
    studentsComboBoxModel_.addElement (student.getID ().toString () + " : "
        + student.getFirstName () + " " + student.getLastName ());
  }



  /**
   * Sets the results TextBox values to contain results found in
   * StudentUnitRecord object
   * 
   * @param studentUnitRecord
   *          the StudentUnitReocrd object containing the results
   */
  public void setRecord (StudentUnitRecord studentUnitRecord)
  {
    float assignment1Mark = studentUnitRecord.getAsg1 ();
    float assignment2Mark = studentUnitRecord.getAsg2 ();
    float examMark        = studentUnitRecord.getExam ();
    
    assignment1MarkTextField_.setText (String.valueOf (assignment1Mark));
    assignment2MarkTextField_.setText (String.valueOf (assignment2Mark));
    examMarkTextField_.setText (String.valueOf (examMark));
    gradeLabel_.setText ("");
  }



  /**
   * Resets the GUI interface to default state
   */
  public void refresh ()
  {
    assignment1MarkTextField_.setText ("");
    assignment2MarkTextField_.setText ("");
    examMarkTextField_.setText ("");
    gradeLabel_.setText ("");
    errorLabel_.setText ("");
    assignment1MarkTextField_.setEditable (false);
    assignment2MarkTextField_.setEditable (false);
    examMarkTextField_.setEditable (false);
  }



  /**
   * Sets the unit ComboBox is editable state
   * 
   * @param isEnabled
   *          is the editable state true/false
   */
  public void setUnitComboState (boolean isEnabled)
  {
    unitsComboBox_.setEnabled (isEnabled);
    errorLabel_.setText ("");
  }



  /**
   * Sets the student ComboBox is editable state
   * 
   * @param isEnabled
   *          is the editable state true/false
   */
  public void setStudentComboState (boolean isEnabled)
  {
    studentsComboBox_.setEnabled (isEnabled);
    errorLabel_.setText ("");
  }



  /**
   * Sets the check button's editable state
   * 
   * @param isEnabled
   *          is the editable state true/false
   */
  public void setCheckButtonState (boolean isEnabled)
  {
    checkButton_.setEnabled (isEnabled);
  }



  /**
   * Sets the change button's enabled state
   * 
   * @param isEnabled
   *          is the editable state true/false
   */
  public void setChangeButtonState (boolean isEnabled)
  {
    changeButton_.setEnabled (isEnabled);
  }



  /**
   * Sets the input text result fields editable state
   * 
   * @param isEnabled
   *          is the editable state true/false
   */
  public void setResultTextState (boolean isEnabled)
  {
    assignment1MarkTextField_.setEditable (isEnabled);
    assignment2MarkTextField_.setEditable (isEnabled);
    examMarkTextField_.setEditable (isEnabled);
  }



  /**
   * Sets the save button's enabled state
   * 
   * @param isEnabled
   *          is the editable state true/false
   */
  public void setSaveButtonState (boolean isEnabled)
  {
    saveButton_.setEnabled (isEnabled);
  }
}
