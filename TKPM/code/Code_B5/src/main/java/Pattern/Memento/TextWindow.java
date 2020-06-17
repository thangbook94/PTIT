/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.Memento;

public class TextWindow {

    private StringBuilder currentText;

    public TextWindow() {
        this.currentText = new StringBuilder();
    }

    public String getCurrentText() {
        return currentText.toString();
    }

    public void addText(String text) {
        currentText.append(text);
    }

    public TextWindowState save() {
        return new TextWindowState(currentText.toString());
    }

    public void restore(TextWindowState save) {
        currentText = new StringBuilder(save.getText());
    }
}
