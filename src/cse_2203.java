
import static java.lang.Thread.sleep;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sadman
 */
public class cse_2203 extends javax.swing.JFrame {

    /**
     * Creates new form cse_2203
     */
  String student_id;
    String questionid="1";
    String ans;
    int marks=0;
    int correct=0;
    int wrong=0;
    String c;
    Timer time;
    int second;
    int minute;
    String ddSecond,ddMinute;
    DecimalFormat dFormat=new DecimalFormat("00");
    boolean state=true;
    public void timer(){
    state = true;
        Thread t = new Thread(){
          public void run(){
              for(;;){
                  if(state == true){
                      try{
                          sleep(1000);
                          second--;
                          ddSecond = dFormat.format(second);
                          ddMinute = dFormat.format(minute);
                          minuteL.setText(""+ddMinute);
                          secondL.setText(""+ddSecond);
                          if(second == -1){
                              second = 59;
                              minute--;
                              ddSecond = dFormat.format(second);
                              ddMinute = dFormat.format(minute);
                              minuteL.setText(""+ddMinute);
                              secondL.setText(""+ddSecond);
                          }
                          if(minute == 0 && second == 0){
                            
                             JOptionPane.showMessageDialog(null,"Times up for your exam");
                               state=false;
                           try
                           {
                             database_connection dc=new database_connection();
                             String a=String.valueOf(marks);
                             String b=String.valueOf(correct);
                             String c=String.valueOf(wrong);
                             String d="Cse 2203";
                             String q ="insert into total_mcq_marks values('"+student_id+"','"+d+"','"+a+"','"+b+"','"+c+"')";
                             dc.state.executeUpdate(q);
                           }
                           catch(Exception e)
                           {
                             JOptionPane.showMessageDialog(null,e);
                           }
                             setVisible(false);
                             new cse_2201_sub(student_id).setVisible(true);
                          }
                      }
                      catch(Exception e){
                        e.printStackTrace();
                      }
                  }
                  else{
                      break;
                  }
              }
          }  
        };
        t.start();
    }
      
    public cse_2203(String a) {
       initComponents();
        this.setLocationRelativeTo(null);
        student_id=a;
        String course="Cse 2203";
        try
        {
             database_connection dc=new database_connection();
            ResultSet  rs=dc.state.executeQuery("select * from time where Course_No='"+course+"'");
            while(rs.next())
            {
                String xx=rs.getString(2);
                String yy=rs.getString(3);
                minute=Integer.valueOf(xx);
                second=Integer.valueOf(yy);
            }
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null,e);
        }
        timer();
        submitbutton.setVisible(false);
        try{
            database_connection dc=new database_connection();
            ResultSet rs=dc.state.executeQuery("SELECT COUNT(*) AS rowcount FROM cse_2203");
            rs.next();
            c=rs.getString("rowcount");
            int d=Integer.valueOf(c);
            d++;
            c=String.valueOf(d);
            rs=dc.state.executeQuery("select * from cse_2203 where question_no='"+questionid+"'");
            while(rs.next())
            {
                  idlabel.setText(""+questionid);
                  questionlabel.setText(rs.getString(2));
                  op1rb.setText(rs.getString(3));
                  op2rb.setText(rs.getString(4));
                  op3rb.setText(rs.getString(5));
                  op4rb.setText(rs.getString(6));
                  ans=rs.getString(7);
            }
        }
        catch(Exception e)
        {
              JOptionPane.showMessageDialog(null,e);
        }
    }
        public void answercheck()
        {
          String studentans="";
          if(op1rb.isSelected())
          {
              studentans=op1rb.getText();
          }
          else if(op2rb.isSelected())
          {
              studentans=op2rb.getText();
          }
          else if(op3rb.isSelected())
          {
              studentans=op3rb.getText();
          }
          else if(op4rb.isSelected())
          {
              studentans=op4rb.getText();
          }
          else{}
          if(studentans.equals(ans))
          {
              correct++;
              marks++;
          }
          else
          {
              wrong++;
          }
          int questionid1=Integer.parseInt(questionid);
          questionid1++;
          questionid=String.valueOf(questionid1);
          /*op1rb.setSelected(false);
          op2rb.setSelected(false);
          op3rb.setSelected(false);
          op4rb.setSelected(false);*/
          buttongroup.clearSelection();
          if(questionid.equals(c))
          {
             nextbutton.setVisible(false);
             submitbutton.setVisible(true);
          }
          question();
         }
        public void question()
        {
            try{
            database_connection dc=new database_connection();
            ResultSet rs=dc.state.executeQuery("select * from cse_2203 where question_no='"+questionid+"'");
            while(rs.next())
            {
                  idlabel.setText(""+questionid);
                  questionlabel.setText(rs.getString(2));
                  op1rb.setText(rs.getString(3));
                  op2rb.setText(rs.getString(4));
                  op3rb.setText(rs.getString(5));
                  op4rb.setText(rs.getString(6));
                  ans=rs.getString(7);
            }
        }
        catch(Exception e)
        {
              JOptionPane.showMessageDialog(null,e);
        }
       }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        buttongroup = new javax.swing.ButtonGroup();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        questionlabel = new javax.swing.JLabel();
        idlabel = new javax.swing.JLabel();
        submitbutton = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        op1rb = new javax.swing.JRadioButton();
        op2rb = new javax.swing.JRadioButton();
        op3rb = new javax.swing.JRadioButton();
        op4rb = new javax.swing.JRadioButton();
        jPanel19 = new javax.swing.JPanel();
        minuteL = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        secondL = new javax.swing.JLabel();
        nextbutton = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(36, 47, 65));

        jPanel2.setBackground(new java.awt.Color(0, 18, 50));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 481, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 152, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(0, 18, 50));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 704, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 114, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(0, 18, 50));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(0, 18, 50));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(0, 18, 50));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(0, 18, 50));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 393, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(248, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel16.setBackground(new java.awt.Color(36, 47, 65));

        jPanel17.setBackground(new java.awt.Color(0, 18, 50));

        questionlabel.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        questionlabel.setForeground(new java.awt.Color(255, 255, 255));
        questionlabel.setText("Question");

        idlabel.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        idlabel.setForeground(new java.awt.Color(255, 255, 255));
        idlabel.setText("No");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(idlabel)
                .addGap(18, 18, 18)
                .addComponent(questionlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(questionlabel, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addComponent(idlabel))
                .addContainerGap())
        );

        submitbutton.setBackground(new java.awt.Color(0, 18, 50));
        submitbutton.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        submitbutton.setText("Submit");
        submitbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitbuttonMouseClicked(evt);
            }
        });
        submitbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitbuttonActionPerformed(evt);
            }
        });

        jPanel18.setBackground(new java.awt.Color(0, 18, 50));

        op1rb.setBackground(new java.awt.Color(0, 18, 50));
        buttongroup.add(op1rb);
        op1rb.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        op1rb.setForeground(new java.awt.Color(255, 255, 255));
        op1rb.setText("Option 1");
        op1rb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op1rbActionPerformed(evt);
            }
        });

        op2rb.setBackground(new java.awt.Color(0, 18, 50));
        buttongroup.add(op2rb);
        op2rb.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        op2rb.setForeground(new java.awt.Color(255, 255, 255));
        op2rb.setText("Option 2");
        op2rb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op2rbActionPerformed(evt);
            }
        });

        op3rb.setBackground(new java.awt.Color(0, 18, 50));
        buttongroup.add(op3rb);
        op3rb.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        op3rb.setForeground(new java.awt.Color(255, 255, 255));
        op3rb.setText("Option 3");
        op3rb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op3rbActionPerformed(evt);
            }
        });

        op4rb.setBackground(new java.awt.Color(0, 18, 50));
        buttongroup.add(op4rb);
        op4rb.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        op4rb.setForeground(new java.awt.Color(255, 255, 255));
        op4rb.setText("Option 4");
        op4rb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op4rbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addContainerGap(29, Short.MAX_VALUE)
                        .addComponent(op1rb, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(op4rb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(op2rb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(op3rb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(op1rb, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(op2rb, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(op3rb, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(op4rb, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jPanel19.setBackground(new java.awt.Color(0, 18, 50));

        minuteL.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        minuteL.setForeground(new java.awt.Color(255, 255, 255));
        minuteL.setText("min");

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(":");

        secondL.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        secondL.setForeground(new java.awt.Color(255, 255, 255));
        secondL.setText("sec");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(minuteL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(secondL)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minuteL)
                    .addComponent(jLabel1)
                    .addComponent(secondL))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        nextbutton.setBackground(new java.awt.Color(0, 18, 50));
        nextbutton.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        nextbutton.setText("Next");
        nextbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextbuttonMouseClicked(evt);
            }
        });
        nextbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextbuttonActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(0, 18, 50));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cse 2203 quiz");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel2)
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(nextbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(submitbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap(364, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(149, 149, 149)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(81, 81, 81))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitbuttonMouseClicked
        state=false;
        try
        {
            database_connection dc=new database_connection();
            String a=String.valueOf(marks);
            String b=String.valueOf(correct);
            String c=String.valueOf(wrong);
            String d="Cse 2203";
            String q = "insert into total_mcq_marks values('"+student_id+"','"+d+"','"+a+"','"+b+"','"+c+"')";
            dc.state.executeUpdate(q);
            this.setVisible(false);
            new cse_2203_sub(student_id).setVisible(true);
        }
        catch(Exception e)
        {
              JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_submitbuttonMouseClicked

    private void submitbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitbuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submitbuttonActionPerformed

    private void op1rbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op1rbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_op1rbActionPerformed

    private void op2rbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op2rbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_op2rbActionPerformed

    private void op3rbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op3rbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_op3rbActionPerformed

    private void op4rbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op4rbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_op4rbActionPerformed

    private void nextbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextbuttonMouseClicked
        answercheck();
    }//GEN-LAST:event_nextbuttonMouseClicked

    private void nextbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextbuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nextbuttonActionPerformed

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
            java.util.logging.Logger.getLogger(cse_2203.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cse_2203.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cse_2203.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cse_2203.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new cse_2203().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttongroup;
    private javax.swing.JLabel idlabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel minuteL;
    private javax.swing.JButton nextbutton;
    private javax.swing.JRadioButton op1rb;
    private javax.swing.JRadioButton op2rb;
    private javax.swing.JRadioButton op3rb;
    private javax.swing.JRadioButton op4rb;
    private javax.swing.JLabel questionlabel;
    private javax.swing.JLabel secondL;
    private javax.swing.JButton submitbutton;
    // End of variables declaration//GEN-END:variables
}
