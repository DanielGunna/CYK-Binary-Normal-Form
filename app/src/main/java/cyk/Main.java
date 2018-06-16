package cyk;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Main {

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.addChoosableFileFilter(new FileNameExtensionFilter("Arquivos JFLAP4", ".jff"));
        int returned = chooser.showOpenDialog(null);
        if (returned == JFileChooser.APPROVE_OPTION) {
            new GrammarReader().readGrammarFromFile(chooser.getSelectedFile().getAbsolutePath());
        }
    }
}
