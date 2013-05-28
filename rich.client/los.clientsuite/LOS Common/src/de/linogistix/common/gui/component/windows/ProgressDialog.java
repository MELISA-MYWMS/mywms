/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.linogistix.common.gui.component.windows;

import de.linogistix.common.gui.gui_builder.windows.AbstractProgressDialog;
import de.linogistix.common.res.CommonBundleResolver;
import java.awt.Frame;
import javax.swing.SwingUtilities;
import org.openide.util.NbBundle;
import org.openide.windows.WindowManager;

/**
 *
 * @author Parhs Rozakhs
 */
public final class ProgressDialog extends AbstractProgressDialog {

    private static ProgressDialog instance = null;
    private Frame parent;

    private ProgressDialog(Frame parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
    }

    private void initialize(){

        waitMessageLabel.setText(NbBundle.getMessage(CommonBundleResolver.class, "AbstractProgressDialog.waitMessageLabel.text"));
        instance.setTitle(NbBundle.getMessage(CommonBundleResolver.class, "AbstractProgressDialog.title"));
        instance.invalidate();
        instance.validate();
        instance.repaint();
        setLocationRelativeTo(parent); //center in parent window
    }

    public void setProgress(int progress, String Message) {   
            setBarProgress(progress, Message);
        if (progress>99) instance.dispose(); //when 100% close the dialog
    }

    public void setProgress(int progress) {
        setBarProgress(progress, null );
        if (progress>99) instance.dispose(); //when 100% close the dialog
    }

    public void DialogShow() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                instance.setVisible(true);
            }
        });
            initialize();
    }

    public synchronized static ProgressDialog getInstance() {
        if (instance == null) {
            instance = new ProgressDialog(WindowManager.getDefault().getMainWindow(), true); //create instance in case it does not exist
        }
        return instance;
    }
/*
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
*/

}
