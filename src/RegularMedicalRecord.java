public class RegularMedicalRecord extends MedicalRecord{
    private double hospitalFees;

    public RegularMedicalRecord(double hospitalFees) {
        this.hospitalFees = hospitalFees;
    }

    public RegularMedicalRecord(int number, String codeMedicalRecord, String namePatient, String hospitalizedDay, String hospitalDischargeDate, String reasonForHospitalization, double hospitalFees) {
        super(number, codeMedicalRecord, namePatient, hospitalizedDay, hospitalDischargeDate, reasonForHospitalization);
        this.hospitalFees = hospitalFees;
    }

    public double getHospitalFees() {
        return hospitalFees;
    }

    public void setHospitalFees(double hospitalFees) {
        this.hospitalFees = hospitalFees;
    }

    @Override
    public String toString() {
        return super.toString() + "," +
                this.hospitalFees;
    }
}
