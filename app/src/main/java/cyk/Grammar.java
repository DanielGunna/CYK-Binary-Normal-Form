package cyk;

import java.util.List;

public class Grammar {
    private List<Production> production;
    
    public List<Production> getProduction() {
        return production;
    }

    public void setProduction(List<Production> production) {
        this.production = production;
    }
}
