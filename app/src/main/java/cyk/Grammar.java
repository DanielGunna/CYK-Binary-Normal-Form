package cyk;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grammar {
    private Set<Production> productions;
    private Production initialProduction;

    public Set<Production> getProductions() {
        return productions;
    }

    @Override
    public String toString() {
        String toString = "";
        for (Production p : productions) {
            toString += String.format("%s -> %s", p.getName(), p.getRightSide()) + "\n";
        }
        return toString;
    }

    public void addProduction(Production production) {
        if (productions == null) {
            productions = new HashSet<>();
            initialProduction = production;
        }
        productions.add(production);
    }

    public void addProductions(List<Production> production) {
        if (productions == null) {
            productions = new HashSet<>();
            initialProduction = production.get(0);
        }
        productions.addAll(production);
    }
}