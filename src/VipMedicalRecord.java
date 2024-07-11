public class VipMedicalRecord extends MedicalRecord{
    int typeVip;
    double durationVip;

    public VipMedicalRecord(int typeVip, double durationVip) {
        this.typeVip = typeVip;
        this.durationVip = durationVip;
    }

    public VipMedicalRecord(int number, String codeMedicalRecord, String namePatient, String hospitalizedDay, String hospitalDischargeDate, String reasonForHospitalization, int typeVip, double durationVip) {
        super(number, codeMedicalRecord, namePatient, hospitalizedDay, hospitalDischargeDate, reasonForHospitalization);
        this.typeVip = typeVip;
        this.durationVip = durationVip;
    }

    public double getDurationVip() {
        return durationVip;
    }

    public void setDurationVip(double durationVip) {
        this.durationVip = durationVip;
    }

    public int getTypeVip() {
        return typeVip;
    }

    public void setTypeVip(int typeVip) {
        this.typeVip = typeVip;
    }

    @Override
    public String toString() {
        return super.toString() + "," +
                this.typeVip + "," +
                this.durationVip;
    }
}

