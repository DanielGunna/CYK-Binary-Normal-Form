package cyk;

import cyk.Grammar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class CykChecker {


    private Grammar convertTo2NF(Grammar grammar) {
        Grammar converted = new Grammar();
        for (Production p : grammar.getProductions()) {
            if (p.getNonTerminals().size() > 2) {
                convertProduction(p);
            }
        }
        return converted;
    }

    private List<Production> convertProduction(Production p) {
        ArrayList<String> processed = new ArrayList<>();
        List<Production> production = new ArrayList<>();
        String proc = p.getRightSide();
        for (int count = 1; count < p.getRightSide().length(); count = (p.getRightSide().length() % 2 == 0 ? count + 2 : count + 1)) {
            String prev = String.valueOf(p.getRightSide().charAt(count - 1));
            String next = String.valueOf(p.getRightSide().charAt(count));
            if (!processed.contains(prev)) {
                processed.add(prev);
                processed.add(next);
                production.add(new Production(new ProductionWrapper(String.format("%s(%s%s)", p.getName(), prev, next), prev + next)));
                if (p.getRightSide().length() % 2 != 0)
                    production.add(new Production(new ProductionWrapper(p.getName(), String.format("%s(%s%s)", p.getName(), prev, next) + p.getRightSide().charAt(count + 1))));
            }else{
                
            }
        }
        return null;
    }


    public void checkSentence(String s, Grammar grammar) {
        Grammar converted = convertTo2NF(grammar);
    }
}
