/*
 * Copyright (c) 2006 - 2010 LinogistiX GmbH
 * 
 *  www.linogistix.com
 *  
 *  Project myWMS-LOS
 */
package de.linogistix.wmsprocesses.processes.movement.gui.component;

import de.linogistix.common.gui.gui_builder.AbstractFooterPanel;
import de.linogistix.wmsprocesses.res.WMSProcessesBundleResolver;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import org.netbeans.api.javahelp.Help;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;

/**
 *
 * @author artur
 */
public class FooterPanel extends AbstractFooterPanel {
    TopComponentPanel topComponentPanel;

    public FooterPanel(TopComponentPanel topComponentPanel) {
        this.topComponentPanel = topComponentPanel;
        postInit();
    }

  /*  @Override
    public List<JButton> getButtonList() {
        List<JButton> buttonList = super.getButtonList();
        
        JButton createMovementButton = new JButton();
        
        createMovementButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        createMovementButton.setText(NbBundle.getMessage(WMSProcessesBundleResolver.class,"Create Movement Order"));
        createMovementButton.setMnemonic(NbBundle.getMessage(WMSProcessesBundleResolver.class, "CreateMovement.mnemonic").charAt(0));
        
        buttonList.add(0, createMovementButton);
        
        return buttonList;
        
    }*/
    
    private void postInit() {
        super.okButton.setText(NbBundle.getMessage(WMSProcessesBundleResolver.class,"Create order and start"));
        super.okButton.setMnemonic(NbBundle.getMessage(WMSProcessesBundleResolver.class, "CreateOrderAndStart.mnemonic").charAt(0));
        super.clearButton.setText(NbBundle.getMessage(WMSProcessesBundleResolver.class,"Clear"));
        super.clearButton.setMnemonic(NbBundle.getMessage(WMSProcessesBundleResolver.class, "Clear.mnemonic").charAt(0));
    }


    @Override
    protected void okButtonActionPerformedListener(ActionEvent evt) {
        topComponentPanel.centerPanel.process(true);
    }

    @Override
    protected void clearButtonActionPerformedListener(ActionEvent evt) {
        topComponentPanel.centerPanel.clear();
    }

      @Override
    protected void flatButtonActionPerformedListener(ActionEvent evt) {
        Help help = (Help) Lookup.getDefault().lookup(Help.class);
        help.showHelp(topComponentPanel.topComponent.getHelpCtx());
    }
}
