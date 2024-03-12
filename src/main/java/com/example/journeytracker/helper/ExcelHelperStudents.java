package com.example.journeytracker.helper;

import com.example.journeytracker.entity.StudentPersonel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelperStudents {
    public static boolean checkExcelFormat(MultipartFile file) {
        String contentType = file.getContentType();
        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return true;
        }
    }

    public static List<StudentPersonel> convertExcelToListOfStudents(InputStream is) {
        List<StudentPersonel> studentList = new ArrayList<>();
        try {

            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheetAt(0);

            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {
                Row row = iterator.next();
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cells = row.iterator();
                int cid = 0;
                StudentPersonel student = new StudentPersonel();
                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    switch (cid) {
                        case 1:
                            student.setStudentName(cell.getStringCellValue());
                            break;
                        case 2:
                            student.setScholarNo(cell.getStringCellValue());
                            break;
                        case 3:
                            student.setStudentPassword(cell.getStringCellValue());
                            break;
                        case 4:
                            student.setStudentEnrollmentNo(cell.getStringCellValue());
                            break;
                        case 5:
                            student.setStudentCollegeEmail(cell.getStringCellValue());
                            break;
                         
                        default:
                            break;
                    }
                    cid++;
                }
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }
}
