

public class Patient extends Midterm {

    private String lName, fName, address, injuryLocation, injuryType;
    private int patientID, injurySeverity, age, ageGroup;

    public Patient () {
        lName= "";
        fName= "";
        address = "";
        injuryLocation = "";
        injuryType = "";
        patientID = 0;
        injurySeverity = 0;
        age = 0;
		ageGroup = 0;

    }
    public Patient(String ln, String fn, String a, String il, String it, int p, int is, int ag, int group){
        lName = ln;
        fName = fn;
        address = a;
        injuryLocation = il;
        injuryType = it;
        patientID = p;
        injurySeverity = is;
        age = ag;
		ageGroup = group;
    }
    public void returnPatient() {
        getLName();
        getFName();
        getAddress();
        getAge();
		getAgeGroup();
        getPatientID();
        getInjuryLocation();
        getInjuryType();
        getInjurySeverity();
    }
    //setters
    public void setLName(String ln){
        lName = ln;
    }
    public void setFName(String fn){
        fName = fn;
    }
    public void setAddress(String ad){
        address = ad;
    }
    public void setInjuryLocation(String il){
        injuryLocation= il;
    }
    public void setInjuryType(String it){
        injuryType = it;
    }
    public void setPatientID(int pid){
        patientID = pid;
    }
    public void setInjurySeverity(int is){
        injurySeverity = is;
    }
    public void setAge(int ag) {
        age = ag;
    }
	    public void setAgeGroup(int ag) {
        ageGroup = ag;
    }
    //getters
    public String getLName(){
        return lName;
    }
    public String getFName(){
        return fName;
    }
    public String getAddress(){
        return address;
    }
    public String getInjuryLocation(){
        return injuryLocation;
    }
    public String getInjuryType(){
        return injuryType;
    }
    public int getPatientID(){
        return patientID;
    }
    public int getInjurySeverity(){
        return injurySeverity;
    }
    public int getAge() {
        return age;
    }
    public int getAgeGroup() {
        return ageGroup;
    }
}

