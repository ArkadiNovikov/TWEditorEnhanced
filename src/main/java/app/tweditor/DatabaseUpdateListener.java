package app.tweditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class DatabaseUpdateListener
        implements ActionListener, DocumentListener {

    @Override
    public void actionPerformed(ActionEvent ae) {
        if ((Main.database != null) && (!Main.dataChanging)) {
            Main.dataModified = true;
            Main.mainWindow.setTitle(null);
        }
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        if ((Main.database != null) && (!Main.dataChanging)) {
            Main.dataModified = true;
            Main.mainWindow.setTitle(null);
        }
    }

    @Override
    public void insertUpdate(DocumentEvent de) {
        if ((Main.database != null) && (!Main.dataChanging)) {
            Main.dataModified = true;
            Main.mainWindow.setTitle(null);
        }
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        if ((Main.database != null) && (!Main.dataChanging)) {
            Main.dataModified = true;
            Main.mainWindow.setTitle(null);
        }
    }
}
