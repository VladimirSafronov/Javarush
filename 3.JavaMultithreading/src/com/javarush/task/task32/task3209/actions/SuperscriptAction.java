package com.javarush.task.task32.task3209.actions;

import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

public class SuperscriptAction extends StyledEditorKit.StyledTextAction {


    /**
     * Creates a new StyledTextAction from a string action name.
     *
     */
    public SuperscriptAction() {
        super("Надстрочный знак");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
