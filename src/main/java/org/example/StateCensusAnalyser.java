package org.example;

public class StateCensusAnalyser {

    CensusLoader loader = new CensusLoader();

    public int loadCensusData(String filePath) throws CensusException {
        return loader.loadCSVData(CSVStateCensus.class, filePath);
    }

    public int loadStateCodeData(String filePath) throws CensusException {
        return loader.loadCSVData(CSVStates.class, filePath);
    }
}