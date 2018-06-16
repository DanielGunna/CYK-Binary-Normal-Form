
import cyk.Grammar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class CykChecker {

    /* The 2 dimensional table for the CYK algorithm */
    private static ArrayList<String>[][] table;

    /**
     * variables are in the form of (0 U 1)+
     * They are stored in the HashMap as (0 U 1)+ maps { (0 U 1)+, (0 U 1)+ }
     */
    private HashMap<String, String[]> variables;

    /**
     * terminals are in the form of (a U b)
     * They are stored in the hashmap in the form: (0 U 1)+ maps (a U b)
     */
    private HashMap<String, Character> terminals;

    /* The start variable */
    private static String startVariable;


    public CykChecker() {
        this.variables = new HashMap<>();
        this.terminals = new HashMap<>();
    }


    private Grammar convertoTo2NF(Grammar grammar) {
        return null;
    }

    private boolean cyk(String w) {
        int length = w.length();
        table = new ArrayList[length][];
        for (int i = 0; i < length; ++i) {
            table[i] = new ArrayList[length];
            for (int j = 0; j < length; ++j)
                table[i][j] = new ArrayList<String>();
        }
        for (int i = 0; i < length; ++i) {
            Set<String> keys = terminals.keySet();
            for (String key : keys) {
                if (terminals.get(key).charValue() == w.charAt(i))
                    table[i][i].add(key);
            }
        }
        for (int l = 2; l <= length; ++l) {
            for (int i = 0; i <= length - l; ++i) {
                int j = i + l - 1;
                for (int k = i; k <= j - 1; ++k) {
                    Set<String> keys = variables.keySet();
                    for (String key : keys) {
                        String[] values = variables.get(key);
                        if (table[i][k].contains((values[0]))
                                && table[k + 1][j].contains(values[1]))
                            table[i][j].add(key);
                    }
                }
            }
        }
        if (table[0][length - 1].contains(startVariable)) // we started from 0
            return true;
        return false;
    }
}
