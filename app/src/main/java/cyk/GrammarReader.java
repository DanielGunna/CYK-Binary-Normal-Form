package cyk;

import com.google.gson.Gson;
import org.json.JSONObject;
import org.json.XML;

import java.io.BufferedReader;
import java.io.FileReader;

public class GrammarReader {

    public Grammar readGrammarFromFile(String file) {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            StringBuilder reader = new StringBuilder();
            String line;
            while ((line = fileReader.readLine()) != null) {
                reader.append(line);
            }
            return fillGrammar(convertXmlToObject(reader.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Grammar fillGrammar(GrammarWrapper grammarWrapper) {
        Grammar grammar = new Grammar();
        for(ProductionWrapper pw : grammarWrapper.getGrammarStructure().getProductionWrappers()){
            grammar.addProduction(new Production(pw));
        }
        return grammar;
    }


    private GrammarWrapper convertXmlToObject(String xmlFile) throws Exception {
        JSONObject jsonObject;
        GrammarWrapper grammarWrapper = null;
        try {
            jsonObject = XML.toJSONObject(xmlFile);
            grammarWrapper = new Gson().fromJson(jsonObject.toString(), GrammarWrapper.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return grammarWrapper;
    }


}
