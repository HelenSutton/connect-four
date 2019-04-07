package connectfour;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.concurrent.atomic.AtomicBoolean;
public class ConnectFourFrame extends JFrame {
//    int turn = 1;
//    ConnectFourComponent connectFourComponent = new ConnectFourComponent();
//    public void playerwent(int row){
//        if (connectFourComponent.droppeice(turn,row)){
//            if (turn == 1){turn = 2;}
//            else {turn=1;}
//        }
//    }

    public ConnectFourFrame() {
        ConnectFourComponent connectFourComponent = new ConnectFourComponent();

        setTitle("Touro Golf");
        setSize(1100,970);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JPanel root = new JPanel();
        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout(FlowLayout.LEADING, 70, 0));


        JButton row1 = new JButton("Drop");
        buttons.add(row1);

        JButton row2 = new JButton("Drop");
        buttons.add(row2);

        JButton row3 = new JButton("Drop");
        buttons.add(row3);
        JButton row4 = new JButton("Drop");
        buttons.add(row4);
        JButton row5 = new JButton("Drop");
        buttons.add(row5);
        JButton row6 = new JButton("Drop");
        buttons.add(row6);
        JButton row7 = new JButton("Drop");
        buttons.add(row7);

        JPanel bottom = new JPanel();
        JButton newGame= new JButton("New Game");
        bottom.add(newGame);





        root.setLayout(new BorderLayout());

        root.add(connectFourComponent, BorderLayout.CENTER);
        root.add(buttons,BorderLayout.NORTH);
        root.add(bottom, BorderLayout.SOUTH);
        newGame.addActionListener(e->{
            connectFourComponent.newGame();
        });
        row1.addActionListener(e->{
           connectFourComponent.droppeice(0);

        });
        row2.addActionListener(e->{
            connectFourComponent.droppeice(1);

        });
        row3.addActionListener(e->{
            connectFourComponent.droppeice(2);

        });
        row4.addActionListener(e->{
            connectFourComponent.droppeice(3);

        });
        row5.addActionListener(e->{
            connectFourComponent.droppeice(4);

        });
        row6.addActionListener(e->{
            connectFourComponent.droppeice(5);

        });
        row7.addActionListener(e->{
            connectFourComponent.droppeice(6);

        });




        setContentPane(root);
    }
}
