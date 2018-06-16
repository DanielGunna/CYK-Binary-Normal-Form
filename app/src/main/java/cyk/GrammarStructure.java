package cyk;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GrammarStructure {
    @Expose
    @SerializedName("production")
    private List<ProductionWrapper> productionWrappers;
    @Expose
    @SerializedName("type")
    private String grammarType;

    public List<ProductionWrapper> getProductionWrappers() {
        return productionWrappers;
    }

    public void setProductionWrappers(List<ProductionWrapper> productionWrappers) {
        this.productionWrappers = productionWrappers;
    }

    public String getGrammarType() {
        return grammarType;
    }

    public void setGrammarType(String grammarType) {
        this.grammarType = grammarType;
    }
}
