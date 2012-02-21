package com.hp.it.cas.match.address;

import com.hp.it.cas.match.address.engine.CharacterScript.Analysis;

public class MockData {
    private String source;
    private Analysis analysis;
    
    public MockData(String src, Analysis analysis){
        this.source = src;
        this.analysis = analysis;
    }
    
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public Analysis getAnalysis() {
        return analysis;
    }
    public void setAnalysis(Analysis analysis) {
        this.analysis = analysis;
    }
}
