package cyk;

import java.util.ArrayList;
import java.util.List;

public class Production {

    private String name;
    private List<String> terminals;
    private List<Production> nonTerminals;
    private boolean isReference;
    private String rightSide;

    public Production(ProductionWrapper pw) {
        name = pw.getLeftSide();
        terminals = new ArrayList<>();
        nonTerminals = new ArrayList<>();
        rightSide = pw.getRightSide();
        findTerminalsAndNonTerminals(pw.getRightSide());
    }

    public String getRightSide() {
        return rightSide;
    }

    public Production(String pw) {
        name = pw;
        isReference = true;
    }

    private void findTerminalsAndNonTerminals(String pw) {
        for (int x = 0; x < pw.length(); x++) {
            if (Character.isUpperCase(pw.charAt(x))) {
                nonTerminals.add(new Production(pw));
            } else {
                terminals.add(String.valueOf(pw.charAt(x)));
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", name, rightSide);
    }

    public boolean isReference() {
        return isReference;
    }

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

    public List<Production> getNonTerminals() {
        return nonTerminals;
    }

    public void setNonTerminals(List<Production> nonTerminals) {
        this.nonTerminals = nonTerminals;
    }

    public void setReference(boolean reference) {
        isReference = reference;
    }
}
