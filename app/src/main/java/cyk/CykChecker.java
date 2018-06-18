package cyk;

import java.util.ArrayList;
import java.util.List;

public class CykChecker {


    private ArrayList<Production> convertedProductions;

    private Grammar convertTo2NF(Grammar grammar) {
        Grammar converted = new Grammar();
        for (Production p : grammar.getProductions()) {
            if (p.getNonTerminals().size() > 2) {
                convertProduction(p);
                converted.addProductions(convertedProductions);
            } else {
                converted.addProduction(p);
            }
        }
        return converted;
    }

    private List<Production> convertProduction(Production p) {
        convertedProductions = new ArrayList<>();
        rightDerivation(getProductionAsNode(p, "X"), 0);
        return convertedProductions;
    }

    private Node getProductionAsNode(Production p, String nameR) {
        Production right = new Production(new ProductionWrapper(p.getRightSide().length() == 2 ?
                String.valueOf(p.getRightSide().charAt(p.getRightSide().length() - 1)) : nameR,
                p.getRightSide().substring(1, p.getRightSide().length())));
        Production left = new Production(String.valueOf(p.getRightSide().charAt(0)));
        return new Node(p, new Node(left, null, null), new Node(right, null, null));
    }

    private void rightDerivation(Node node, int coutName) {
        Production p = node.getProduction();
        Production pr = node.getRight().getProduction();
        Production pl = node.getLeft().getProduction();
        if (p.getRightSide().length() > 2) {
            convertedProductions.add(new Production(new ProductionWrapper(p.getName(), pl.getName() + pr.getName())));
            rightDerivation(getProductionAsNode(node.getRight().getProduction(), "X_" + coutName), ++coutName);
        } else if (pr.getRightSide().length() == 1) {
            convertedProductions.add(new Production(new ProductionWrapper(p.getName(), pl.getName() + pr.getName())));
        }
    }


    public void checkSentence(String s, Grammar grammar) {
        Grammar converted = convertTo2NF(grammar);
    }
}
