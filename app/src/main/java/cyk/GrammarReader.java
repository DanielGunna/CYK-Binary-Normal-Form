package cyk;

import com.google.gson.Gson;
import org.json.JSONObject;
import org.json.XML;

import java.io.BufferedReader;
import java.io.FileReader;

public class GrammarReader {

    public GrammarStructure readGrammarFromFile(String file) {
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

    private GrammarStructure fillGrammar(GrammarWrapper grammarWrapper) {
        return null;
    }


    private GrammarWrapper convertXmlToObject(String xmlFile) throws Exception {
        JSONObject jsonObject;
        GrammarWrapper automaton = null;
        try {
            jsonObject = XML.toJSONObject(xmlFile);
            automaton = new Gson().fromJson(cleanUpJson(jsonObject.toString()), GrammarWrapper.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return automaton;
    }

    private String cleanUpJson(String xmlContent) {
        return xmlContent;
    }
}
