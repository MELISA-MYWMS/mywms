/*
 * Copyright (c) 2006 - 2010 LinogistiX GmbH
 * 
 *  www.linogistix.com
 *  
 *  Project myWMS-LOS
 */
package de.linogistix.reports.gui.component;

import de.linogistix.reports.res.ReportsBundleResolver;
import org.openide.util.NbBundle;



/**
 *
 * @author  trautm
 */
public class BOExportWizardSelectionJPanel extends javax.swing.JPanel {

    /** Creates new form BOExportWizardSelectionJPanel */
    public BOExportWizardSelectionJPanel() {
        initComponents();
        allOption.setVisible(false);
        
        questionLabel.setText(NbBundle.getMessage(ReportsBundleResolver.class,"BOExportWizard.questionLabel"));
        selectedOption.setText(NbBundle.getMessage(ReportsBundleResolver.class,"BOExportWizard.selectedOption"));
        allOption.setText(NbBundle.getMessage(ReportsBundleResolver.class,"BOExportWizard.allOption"));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        selectedOption = new javax.swing.JRadioButton();
        allOption = new javax.swing.JRadioButton();
        questionLabel = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        buttonGroup1.add(selectedOption);
        selectedOption.setSelected(true);
        selectedOption.setText("null");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        add(selectedOption, gridBagConstraints);

        buttonGroup1.add(allOption);
        allOption.setText("null");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        add(allOption, gridBagConstraints);

        questionLabel.setText("null");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(questionLabel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JRadioButton allOption;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel questionLabel;
    javax.swing.JRadioButton selectedOption;
    // End of variables declaration//GEN-END:variables

}
