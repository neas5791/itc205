ITC205 Team12 Repository

Class/Variable old name -> Class/Variable new name
			* Classes outside scope effected

Class name changes
cgCTL 	-> CheckGradeController
	* Main
cgUI	-> CheckGradeUI

CheckGradeUI.Refresh3 - > refresh
	* CheckGradeController
	* CheckGradeUI
CheckGradeController.cuc -> unit
	* CheckGradeController

CheckGradeUI jButton1 -> jButtonChange
CheckGradeUI jButton2 -> jButtonCheck
CheckGradeUI jButton3 -> jButtonSave
CheckGradeUI jLabel2 -> jLabelAsg1
CheckGradeUI jLabel3 -> jLabelAsg2
CheckGradeUI jLabel4 -> jLabelExam
CheckGradeUI jLabel5 -> jLabelGrade
CheckGradeUI jTextField1 -> jTextFieldAsg1
CheckGradeUI jTextField2 -> jTextFieldAsg2
CheckGradeUI jTextField3 -> jTextFieldExam
CheckGradeUI uM -> unitComboBox
CheckGradeUI rM -> studentComboBox
CheckGradeUI jComboBox1 -> jComboBoxUnit
CheckGradeUI jComboBox2 -> jComboBoxStudent

CheckGradeUI f1 -> fAsg1
CheckGradeUI f2 -> fAsg2
CheckGradeUI f3 -> fExam

CheckGradeUI jComboBox1ItemStateChanged() -> unitComboBoxItemStateChanged()
CheckGradeUI jComboBox2ItemStateChanged() -> studentComboBoxItemStateChanged()

CheckGradeUI jButton1ActionPerformed() -> changeButtonActionPerformed()
CheckGradeUI jButton2ActionPerformed() -> checkButtonActionPerformed()
CheckGradeUI jButton3ActionPerformed() -> saveButtonActionPerformed()

CheckGradeUI.clearUnits() added javadocs
CheckGradeUI.clearStudents() added javadocs
CheckGradeUI.addUnit() added javadocs

Added javax.swing object imports

Applied Tyson's Formatter to CheckGradeUI
Refactor CheckGradeUI.jLabel1 - jLabelTitle
Refactor CheckGradeUI.jPanel1 -> selectUnitPanel
Refactor CheckGradeUI.jPanel1Layout -> unitPanelLayout
Refactor CheckGradeUI.jPanel2 -> selectStudentPanel
Refactor CheckGradeUI.jPanel2Layout -> studentPanelLayout
Refactor CheckGradeUI.jPanel3 -> markPanel
Refactor CheckGradeUI.jPanel2Layout -> markPanelLayout

Added comments showing what the style guide private variable names will be refactored to
Refactor CheckGradeUI.jPanel4 -> gradePanel
Refactor CheckGradeUI.jPanel4Layout -> gradeLayoutPanel


CheckGradeUI.setState1 - > setUnitComboState
    * CheckGradeController
CheckGradeUI.setState2 - > setStudentComboState
    * CheckGradeController
CheckGradeUI.setState3 - > setCheckButtonState
    * CheckGradeController
CheckGradeUI.setState4 - > setChangeButtonState
    * CheckGradeController
CheckGradeUI.setState5 - > setResultTextState
    * CheckGradeController
CheckGradeUI.setState6 - > setSaveButtonState
    * CheckGradeController
        
Final refactor of private variables in CheckGradeUI to include


Applied Tyson's formatting to interfaces class IStudentLister
Applied Tyson's formatting to interfaces class IUnitLister
CheckGradeController boolean changed -> Private boolean isChanged


CheckGradeController.luCTL -> listUnitController
CheckGradeController.lsCTL -> listStudentController
CheckGradeController.unit -> CheckGradeController.subjectUnitCode
Re worded some previously added Javadocs in CheckGradeUI
Refactored method variables and added Javadocs
Removed IUnit iUnit = UnitManager.UM().getUnit(subjectUnitCode); from CheckGradeController.saveGrade

CheckGradeController.unitSelected(String) -> selectUnit(String)
    *CheckGradeUI
CheckGradeController.studentSelected(Integer) -> selectStudent(Integer)
    *CheckGradeUI
Refactor CheckGradeController private variables with _
Refactor (Event evt) variables -> (Event event)

Team meeting change
subjectUnitCode -> unitCode