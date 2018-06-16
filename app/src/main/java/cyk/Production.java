package cyk;

import java.util.List;

public class Production {
    private List<String> terminals;
    private List<Production> nonTerminals;

    public List<String> getTerminals() {
        return terminals;
    }

    public void setTerminals(List<String> terminals) {
        this.terminals = terminals;
    }

    public List<Production> getNonTerminals() {
        return nonTerminals;
    }

    public void setNonTerminals(List<Production> nonTerminals) {
        this.nonTerminals = nonTerminals;
    }
}
