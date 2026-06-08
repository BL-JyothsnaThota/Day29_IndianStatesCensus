package org.example;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.util.Iterator;

public class CensusLoader {

    public <E> int loadCSVData(Class<E> csvClass, String filePath) throws CensusException {
        try {
            FileReader reader = new FileReader(filePath);

            CsvToBean<E> csvToBean = new CsvToBeanBuilder<E>(reader)
                    .withType(csvClass)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<E> iterator = csvToBean.iterator();

            int count = 0;
            while (iterator.hasNext()) {
                iterator.next();
                count++;
            }

            return count;

        } catch (RuntimeException e) {
            throw new CensusException("CSV format issue", CensusException.ExceptionType.DELIMITER_ISSUE);
        } catch (Exception e) {
            if (filePath.contains(".csv"))
                throw new CensusException("File Problem", CensusException.ExceptionType.FILE_NOT_FOUND);
            else
                throw new CensusException("Wrong File Type", CensusException.ExceptionType.INCORRECT_FILE_TYPE);
        }
    }
}