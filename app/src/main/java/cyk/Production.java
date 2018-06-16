package cyk;

import java.util.List;

public class Production {

    private String name;
    private List<String> terminals;
    private List<ProductionWrapper> nonTerminals;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTerminals() {
        return terminals;
    }

    public void setTerminals(List<String> terminals) {
        this.terminals = terminals;
    }

    public List<ProductionWrapper> getNonTerminals() {
        return nonTerminals;
    }

    public void setNonTerminals(List<ProductionWrapper> nonTerminals) {
        this.nonTerminals = nonTerminals;
    }
}
