import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecordManager {
    List<MedicalRecord> medicalRecords;
    File file = new File("data/medical_records.csv");

    public void saveToFile() {

        try( BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (MedicalRecord medicalRecord : medicalRecords) {
                bufferedWriter.write(medicalRecord.toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadToFile() {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) ;
            String[] data = line.split(",");
            int number = Integer.parseInt(data[0]);
            String codeMedicalRecord = data[1];
            String namePatient = data[2];
            String hospitalizedDay = data[3];
            String hospitalDischargeDate = data[4];
            String reasonForHospitalization = data[5];


            if (data.length==7) {
                double hospitalFees = Double.parseDouble(data[6]);
                MedicalRecord regularMedicalRecord = new RegularMedicalRecord(number, codeMedicalRecord, namePatient, hospitalizedDay, hospitalDischargeDate, reasonForHospitalization, hospitalFees);
                medicalRecords.add(regularMedicalRecord);
            }
            if (data.length == 8) {
                int typeVip = Integer.parseInt(data[7]);
                double durationVip = Double.parseDouble(data[8]);
                MedicalRecord vipMedicalRecord =new VipMedicalRecord(number, codeMedicalRecord, namePatient, hospitalizedDay, hospitalDischargeDate, reasonForHospitalization,typeVip,durationVip);
                medicalRecords.add(vipMedicalRecord);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MedicalRecordManager() {
        this.medicalRecords = new ArrayList<>();
    }

    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecords.add(medicalRecord);
        saveToFile();

    }

    public int searchByNumber(int number) {
        for (int i = 0; i < medicalRecords.size(); i++) {
            MedicalRecord medicalRecord = medicalRecords.get(i);
            if (medicalRecord.getNumber() == number) {
                return i;
            }
        }
        return -1;
    }

    public MedicalRecord searchByNumber1(int number) {
        for (MedicalRecord medicalRecord : medicalRecords) {
            if (medicalRecord.getNumber() == number) {
                return medicalRecord;
            }
        }
        return null;
    }

    public void deleteMedicalRecord(int number) {
        int index = searchByNumber(number);
        if (index == -1) {
            System.out.println("ko tim thay vi tri can xoa");
        } else {
            medicalRecords.remove(index);
            saveToFile();
        }
    }

    public void showMedicalRecord() {
        for (MedicalRecord medicalRecord : medicalRecords) {
            System.out.println(medicalRecord);
        }
    }
}