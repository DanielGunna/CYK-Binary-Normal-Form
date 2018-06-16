package cyk;

import java.util.List;

public class Grammar {
    private List<Production> productions;

    public List<Production> getProductionWrapper() {
        return productions;
    }

    public void setProductionWrapper(List<Production> productions) {
        this.productions = productions;
    }
}
