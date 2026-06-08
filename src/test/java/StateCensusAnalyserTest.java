import org.example.StateCensusAnalyser;

public class StateCensusAnalyserTest {

    String CORRECT_CENSUS_FILE = "C:\\Data\\StateCensus.csv";
    String WRONG_FILE = "C:\\Data\\WrongFile.csv";
    String WRONG_TYPE = "C:\\Data\\StateCensus.txt";
    String WRONG_DELIMITER = "C:\\Data\\WrongDelimiter.csv";
    String WRONG_HEADER = "C:\\Data\\WrongHeader.csv";

    // ✅ TC1.1
    @Test
    public void givenCensusCSV_WhenCorrect_ShouldReturnCount() {
        try {
            StateCensusAnalyser analyser = new StateCensusAnalyser();
            int count = analyser.loadCensusData(CORRECT_CENSUS_FILE);
            Assert.assertEquals(29, count);
        } catch (Exception e) {
            Assert.fail();
        }
    }
}