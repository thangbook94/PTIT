/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apply.Memento;

public class NguyenDinhThang3a {

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor(new TextWindow());
        textEditor.write("Thangbook\n");
        textEditor.write("Avsdfs\n");
        textEditor.hitSave();
        textEditor.write("rsdfs\n");
        textEditor.hitUndo();
        if (textEditor.print().equals("Thangbook\nAvsdfs\n")) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }

    }
}
