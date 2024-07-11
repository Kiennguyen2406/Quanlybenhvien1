public class MedicalRecord {
    private int number;
    private String codeMedicalRecord;
    private String namePatient;

    private String hospitalizedDay;
    private String hospitalDischargeDate;
    private String reasonForHospitalization;

    public MedicalRecord() {
    }

    public MedicalRecord(int number, String codeMedicalRecord, String namePatient, String hospitalizedDay, String hospitalDischargeDate, String reasonForHospitalization) {
        this.number = number;
        this.codeMedicalRecord = codeMedicalRecord;
        this.namePatient = namePatient;
        this.hospitalizedDay = hospitalizedDay;
        this.hospitalDischargeDate = hospitalDischargeDate;
        this.reasonForHospitalization = reasonForHospitalization;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCodeMedicalRecord() {
        return codeMedicalRecord;
    }

    public void setCodeMedicalRecord(String codeMedicalRecord) {
        this.codeMedicalRecord = codeMedicalRecord;
    }

    public String getNamePatient() {
        return namePatient;
    }

    public void setNamePatient(String namePatient) {
        this.namePatient = namePatient;
    }

    public String getHospitalizedDay() {
        return hospitalizedDay;
    }

    public void setHospitalizedDay(String hospitalizedDay) {
        this.hospitalizedDay = hospitalizedDay;
    }

    public String getHospitalDischargeDate() {
        return hospitalDischargeDate;
    }

    public void setHospitalDischargeDate(String hospitalDischargeDate) {
        this.hospitalDischargeDate = hospitalDischargeDate;
    }

    public String getReasonForHospitalization() {
        return reasonForHospitalization;
    }

    public void setReasonForHospitalization(String reasonForHospitalization) {
        this.reasonForHospitalization = reasonForHospitalization;
    }

    @Override
    public String toString() {
        return  number + "," +
                 codeMedicalRecord + ',' +
                 namePatient + ',' +
                 hospitalizedDay + ',' +
                 hospitalDischargeDate + ',' +
                 reasonForHospitalization
                ;
    }
}
