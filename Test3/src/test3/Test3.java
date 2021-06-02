package test3;

import java.awt.event.ActionEvent;
import org.jfree.chart.ChartPanel;
import java.awt.event.ActionListener;
import javax.swing.WindowConstants;
import javax.swing.JOptionPane;

public class Test3 extends javax.swing.JFrame implements ActionListener 
{
ChartPanel chartPanel;
picha p1 = new picha();

public Test3() 
 {
   initComponents();
 }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                formComponentRemoved(evt);
            }
        });

        jTextField1.setText("eg = C:\\Users\\jayti\\OneDrive\\Documents");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Actual");
        jButton1.setFocusable(false);

        jLabel1.setText("ENTER A VALID PATH PRESENT IN YOUR SYSTEM");

        jButton2.setText("General");
        jButton2.setFocusable(false);

        jLabel2.setText("GRAPH TYPES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(56, 56, 56))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentAdded

    private void formComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentRemoved
   //     // TODO add your handling code here:
    }//GEN-LAST:event_formComponentRemoved

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    
  public static void main(String args[]) 
  {     
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {  
             new Test3().go();         
            }          
        });
    }
   
  
  
  
private void go()        
{ Test3 t1 = new Test3();
    jButton1.addActionListener(t1); 
    jButton2.addActionListener(t1); 
    t1.setTitle("Storage Graph");
    t1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    t1.setVisible(true);    
}




  @Override
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==jButton1)
                {   
                  String path = jTextField1.getText();
                  String direc = p1.rec(path);
                  if(direc.contains("correct")==true)
                  {
                   String result1 = p1.inputs("Actual Storage Graph of the provided path"); 
                   if(result1.contains("available")==true)
                   {   
                    p1.pack();
                    p1.setVisible(true);
                   }
                   else
                   {
                     JOptionPane.showMessageDialog(rootPane,"Not a single File present in the directory","Message",JOptionPane.INFORMATION_MESSAGE); 
                   }
                  }
                 else
                 {
                  JOptionPane.showMessageDialog(rootPane,direc,"Message",JOptionPane.INFORMATION_MESSAGE);   
                 }
                }
            
     
                if(e.getSource()==jButton2)
                {   
                  String path = jTextField1.getText();
                  String direc = p1.rec(path);
                  if(direc.contains("correct")==true)
                  {
                  String result2 = p1.inputs2("General Distribution Graph of the memory for the provided path");    
                   if(result2.contains("available")==true)
                   {
                    p1.pack();
                    p1.setVisible(true);
                   }
                   else
                   {
                    JOptionPane.showMessageDialog(rootPane,"Not a single File present in the directory","Message",JOptionPane.INFORMATION_MESSAGE); 
                   }
                  }
                 else
                 {
                  JOptionPane.showMessageDialog(rootPane,direc,"Message",JOptionPane.INFORMATION_MESSAGE);  
                 }
                }
                        
            }
            
            

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton jButton1;
    private static javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
