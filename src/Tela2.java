import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Tela2 extends Fundo{


        //tela2 = tela de boas vindas
        JFrame tela2 = new JFrame();

        //ImageIcon fundo = new ImageIcon(getClass().getResource("BlackPurple.jpg"));

        JLabel label2 = new JLabel(fundo);
        JLabel label3 = new JLabel();

        JButton continuar = new JButton();

        Tela2(){

                /*_______________Buttons_______________*/

                continuar.setVisible(true);
                continuar.setText("Continuar");
                continuar.setOpaque(false);
                continuar.setBackground(Color.magenta);
                continuar.setForeground(Color.white);
                continuar.setFont(new Font("Colibri",Font.PLAIN, 30));
                continuar.setBounds(520,420,250,70);
                continuar.setHorizontalAlignment(JLabel.CENTER);
                continuar.setVerticalAlignment(JLabel.BOTTOM);

                continuar.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                               if (e.getSource()==continuar){
                                       tela2.dispose();
                                       new Tela3();

                                }
                        }
                });




                /*_______________Labels_______________*/

                label2.setSize(1280,720);
                label2.setOpaque(true);
                label2.setVisible(true);

                label3.setVisible(true);
                label3.setBounds(0,0,1280,720);
                label3.setText("Bem-Vindo!");
                label3.setFont(new Font("Colibri",Font.BOLD, 70));
                label3.setForeground(Color.white);
                label3.setHorizontalTextPosition(JLabel.CENTER);
                label3.setVerticalTextPosition(JLabel.BOTTOM);
                label3.setHorizontalAlignment(JLabel.CENTER);
                label3.setVerticalAlignment(JLabel.CENTER);

                label3.setOpaque(false);
                label3.add(continuar);

                label2.add(label3);
                label2.add(continuar);



                /*_______________Frames_______________*/

                tela2.setVisible(true);
                tela2.setForeground(new Color(0x44014F));
                tela2.setBackground(new Color(0x44014F));
                tela2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                tela2.setResizable(false);
                tela2.setSize(1280,720);
                tela2.setTitle("MovieTime");
                tela2.add(label2);



        }

}
