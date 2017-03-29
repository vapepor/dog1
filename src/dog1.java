
import java.util.logging.Level;
import java.util.logging.Logger;

public class dog1 extends javax.swing.JFrame {

    private Humen humen;//ประกาศคน
    private Dog dog;//ประกาศหมา
    private Police police;//ประกาศตำรวจ
    private Thief thief;//ประกาศโจร
    private Time time;//ประกาศเวลา
    private boolean stop;//หยุด
    private Object obj;//ประกาศobj

    public dog1() { 
        initComponents();
        obj = new Object();
    }

    public class Time extends Thread {//คลาสเวลา

        int i = 0;
        int hour = 0;//นับชั่วโมง
        int date = 1;//นับวัน

        public void run() {

            h0.setText("wake up");//เริ่มคนตื่น
            d0.setText("sleep");//หมาหลับตอนเริ่ม
            p0.setText("wake up");//ตำรวจตื่น
            t0.setText("sleep");//โจรหลับ

            while (!stop) {//ถ้าไม่หยุด ให้เริ่มทำงาน
                try {
                    Thread.sleep(10);//หลับ ไป 10
                    i += 1;
                    if (i == 60) { // + 1 จยกว่าจะครบ 60
                        hour = hour + 1;
                        i = 0;
                    }
                    if (hour == 16) { 
                        synchronized (obj) { //ให้ทำงานในฝั่ง interrup
                            obj.notify();
                        }
                    }
                    if (hour == 24) { //ครบ 24 ชม. คิดเป็น 1 วัน
                        date = date + 1;
                        hour = 0;
                    }
                    date1.setText(String.valueOf(date));//ค่าเก็บเข้ามาดป็น string 
                    time1.setText(String.valueOf(hour));
                    time2.setText(String.valueOf(i));
                } catch (InterruptedException ie) {
                    i = 0;
                    
                    thief.interrupt();
                    break;
                    
                    
                }
            }
        }
    }

    class Humen extends Thread {

        public void run() {
            try {
                while (!stop) {
                    synchronized (obj) {
                        obj.wait();
                    }
                    h0.setText("sleep");//หลับไป 8 ชม
                    Thread.sleep(8000); 
                    h0.setText("wake up");

                }

            } catch (InterruptedException ite) {
                try {
                    sleep(2000);
                    h0.setText("แจ้งตำปู");
                    police.interrupt();
                    sleep(10000); //คนถูกขัดจังหวะเลย เข้าแคส 
                } catch (InterruptedException ex) {
                    Logger.getLogger(dog1.class.getName()).log(Level.SEVERE, null, ex);
                    
                    
                }
            }
        }
    }

    class Dog extends Thread {

        public void run() {
            try {
                while (!stop) {
                    synchronized (obj) {
                        obj.wait();
                    }
                    d0.setText("wake up");
                    Thread.sleep(8000);
                    d0.setText("sleep");
                }
            } catch (InterruptedException ite) {
                try {
                    sleep(1000);
                    d0.setText("เห่า");
                    sleep(10);
                      humen.interrupt();
                } catch (InterruptedException ex) {
                    Logger.getLogger(dog1.class.getName()).log(Level.SEVERE, null, ex);
                  
                }
            }
        }
    }

    class Police extends Thread {

        public void run() {
            try {
                while (!stop) {

                    p0.setText("wake up");
                    Thread.sleep(5000);
                }
                } catch (InterruptedException ite) {
                try {
                    sleep(1000);
                    p0.setText("ตำปูมา");
                    sleep(1500);
                    p0.setText("จับโจรละนะ");
                    stop = true;
                    st.setEnabled(true);
                    in.setEnabled(true);
                } catch (InterruptedException ex) {
                    Logger.getLogger(dog1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    class Thief extends Thread {

        public void run() {
            try {
                while (!stop) {
                    synchronized (obj) {
                        obj.wait();
                    }
                    t0.setText("wake up");
                    Thread.sleep(8000);
                    t0.setText("sleep");

                }
            } catch (InterruptedException ite) {

                try {
                    t0.setText("โจรบุก");
                    sleep(10);
                    dog.interrupt();
                } catch (InterruptedException ex) {
                    Logger.getLogger(dog1.class.getName()).log(Level.SEVERE, null, ex);
                    //dog.interrupt();
                }
            }

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        time1 = new javax.swing.JLabel();
        time2 = new javax.swing.JLabel();
        hm = new javax.swing.JLabel();
        pl = new javax.swing.JLabel();
        tf = new javax.swing.JLabel();
        h0 = new javax.swing.JLabel();
        p0 = new javax.swing.JLabel();
        d0 = new javax.swing.JLabel();
        t0 = new javax.swing.JLabel();
        st = new javax.swing.JButton();
        sp = new javax.swing.JButton();
        date = new javax.swing.JLabel();
        date1 = new javax.swing.JLabel();
        in = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        time1.setText("00");

        time2.setText("00");

        hm.setText("humen");

        pl.setText("police");

        tf.setText("thief");

        h0.setText("-------------");

        p0.setText("-------------");

        d0.setText("-------------");

        t0.setText("-------------");

        st.setText("start");
        st.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stActionPerformed(evt);
            }
        });

        sp.setText("stop");
        sp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spActionPerformed(evt);
            }
        });

        date.setText("date");

        date1.setText("---------");

        in.setText("steal");
        in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inActionPerformed(evt);
            }
        });

        jLabel1.setText("time");

        jLabel2.setText("dog");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(hm)
                                        .addComponent(pl)
                                        .addComponent(tf)
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(st)
                                        .addGap(14, 14, 14)))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(d0, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(h0, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(p0, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(t0, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(sp))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(time1)
                                .addGap(32, 32, 32)
                                .addComponent(time2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(in)
                        .addGap(42, 42, 42))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(date)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(date1)
                        .addGap(126, 126, 126))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(date)
                    .addComponent(date1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(time1)
                    .addComponent(time2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hm)
                    .addComponent(h0))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(d0)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pl)
                    .addComponent(p0))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf)
                    .addComponent(t0))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(st)
                    .addComponent(sp)
                    .addComponent(in))
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stActionPerformed
        /*           Humen h1=new Humen();
         Dog d1=new Dog();
         Police p1=new Police();
         Thief t1=new Thief();
         */
        st.setEnabled(false);
        police = new Police();
        time = new Time();
        thief = new Thief();
        humen = new Humen();
        dog = new Dog();
        police.start();
        humen.start();
        dog.start();
        thief.start();
        stop = false;
        time.start();
    }//GEN-LAST:event_stActionPerformed

    private void inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inActionPerformed
        in.setEnabled(false);
        if (time.hour >= 16 && time.hour <= 24) {
            time.interrupt();
            //dog.interrupt();
            //humen.interrupt();
            //police.interrupt();
        }
    }//GEN-LAST:event_inActionPerformed

    private void spActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spActionPerformed
        // TODO add your handling code here:
        stop = true;
        st.setEnabled(true);
        in.setEnabled(true);
    }//GEN-LAST:event_spActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dog1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dog1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dog1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dog1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dog1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel d0;
    private javax.swing.JLabel date;
    private javax.swing.JLabel date1;
    private javax.swing.JLabel h0;
    private javax.swing.JLabel hm;
    private javax.swing.JButton in;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel p0;
    private javax.swing.JLabel pl;
    private javax.swing.JButton sp;
    private javax.swing.JButton st;
    private javax.swing.JLabel t0;
    private javax.swing.JLabel tf;
    private javax.swing.JLabel time1;
    private javax.swing.JLabel time2;
    // End of variables declaration//GEN-END:variables
}
