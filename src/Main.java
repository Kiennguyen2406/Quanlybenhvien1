import java.util.DuplicateFormatFlagsException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MedicalRecordManager medicalRecordManager = new MedicalRecordManager();
        while (true) {

            Menu.menuSelect();

            int choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case 1:
                    try {
                        creatMedicalRecord(scanner,medicalRecordManager);
                    }catch (DuplicateFormatFlagsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    deteleMedicalRecord(scanner,medicalRecordManager);
                    break;
                case 3:
                    medicalRecordManager.showMedicalRecord();
                    break;
                case 4:
                    System.out.println("end");
                    System.exit(0);
                    break;
                default:
                    System.out.println("lua chon ko phu hop");
                    break;
            }
        }
    }

    public static void creatMedicalRecord(Scanner scanner,MedicalRecordManager medicalRecordManager)throws DuplicateFormatFlagsException {
        Menu.menuServiceSelection();
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice != 1 && choice != 2) {
            throw new IllegalArgumentException("Lựa chọn không hợp lệ.");
        }
            System.out.println("Nhập so thứ tự : ");
            int number = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập mã bệnh án : ");
            String codeMedicalRecord = scanner.nextLine();
            System.out.println("Nhập tên bệnh nhân: ");
            String namePatient = scanner.nextLine();
            System.out.println("Nhập ngày nhập viện : ");
            String hospitalizedDay = scanner.nextLine();
            System.out.println("Nhập ngày ra viện : ");
            String hospitalDischargeDate = scanner.nextLine();
            System.out.println("Nhập lý do nhập viện: ");
            String reasonForHospitalization = scanner.nextLine();

            if (choice == 1) {
                System.out.println("phi nhap vien");
                double hospitalFees = Integer.parseInt(scanner.nextLine());
                MedicalRecord newMedicalRecord = new RegularMedicalRecord(number, codeMedicalRecord, namePatient, hospitalizedDay, hospitalDischargeDate, reasonForHospitalization, hospitalFees);
                medicalRecordManager.addMedicalRecord(newMedicalRecord);
                System.out.println("Them moi benh an thuong thanh cong");
            }
            else if (choice == 2) {
                System.out.println("Loai vip(1/2/3):");
                int typeVip = Integer.parseInt(scanner.nextLine());
                System.out.println("Ngay het han vip");
                double durationVip = Double.parseDouble(scanner.nextLine());
                MedicalRecord newMedicalRecord = new VipMedicalRecord(number, codeMedicalRecord, namePatient, hospitalizedDay, hospitalDischargeDate, reasonForHospitalization, typeVip, durationVip);
                medicalRecordManager.addMedicalRecord(newMedicalRecord);
                System.out.println("them moi benh an vip thanh cong");
            }
                ;

    }
    public static void deteleMedicalRecord(Scanner scanner,MedicalRecordManager medicalRecordManager) {
        System.out.println("Nhập số thứ tự bệnh án cần xóa: ");
        int number = Integer.parseInt(scanner.nextLine());
        Menu.menuYesOrNoDelete();
        String choice = scanner.nextLine();
        if (choice.equals("Yes") ) {
            medicalRecordManager.deleteMedicalRecord(number);
            System.out.println("Xoa thanh cong");
        }if (choice.equals("No")) {
            System.out.println("Quay tro lai man hinh chinh");
        }

    }
}
