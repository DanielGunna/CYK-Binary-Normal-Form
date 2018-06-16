package cyk;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GrammarWrapper {
    @Expose
    @SerializedName("structure")
    private GrammarStructure grammarStructure;

    public GrammarWrapper(GrammarStructure grammarStructure) {
        this.grammarStructure = grammarStructure;
    }

    public GrammarStructure getGrammarStructure() {
        return grammarStructure;
    }

    public void setGrammarStructure(GrammarStructure grammarStructure) {
        this.grammarStructure = grammarStructure;
    }
}
