package com.simicul.smf.model;

class Fraudulent {
    boolean fraudulent;
    int level;
    String source;
}

public class Analysis {
    public Fraudulent isFraudulent(StringBuilder content) {
        Fraudulent fraudulent = new Fraudulent();

        fraudulent.fraudulent = true;
        fraudulent.level = 5;
        fraudulent.source = "hc";

        return fraudulent;
    }
}
