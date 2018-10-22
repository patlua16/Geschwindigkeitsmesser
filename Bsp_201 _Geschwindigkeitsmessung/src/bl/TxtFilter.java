/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author floha
 */
public class TxtFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        String extension = null;
        if (f.isDirectory()) {
            return true;
        }
        String s = f.getName();
        int i = s.lastIndexOf('.');
        if (i > 0 && i < s.length() - 1) {
            extension = s.substring(i + 1).toLowerCase();
        }
        return (extension != null && extension.equals("txt"));
    }

    @Override
    public String getDescription() {
        return "Text Files (*.txt)";
    }

}
