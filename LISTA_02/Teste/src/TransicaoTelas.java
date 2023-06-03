import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransicaoTelas extends JFrame implements ActionListener {
    private JPanel cards;
    private CardLayout cardLayout;

    public TransicaoTelas() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Criação dos painéis para cada tela
        JPanel tela1 = new JPanel();
        JLabel label1 = new JLabel("Tela 1");
        tela1.add(label1);

        JPanel tela2 = new JPanel();
        JLabel label2 = new JLabel("Tela 2");
        tela2.add(label2);

        // Criação do painel de cartões (contêiner dos painéis)
        cards = new JPanel(new CardLayout());
        cards.add(tela1, "Tela 1");
        cards.add(tela2, "Tela 2");

        // Criação do botão de próximo
        JButton proximoButton = new JButton("Próximo");
        proximoButton.addActionListener(this);

        // Adiciona o painel de cartões e o botão ao frame
        setLayout(new BorderLayout());
        add(cards, BorderLayout.CENTER);
        add(proximoButton, BorderLayout.SOUTH);

        cardLayout = (CardLayout) cards.getLayout(); // Obtém o CardLayout

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cardLayout.next(cards); // Avança para a próxima tela
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TransicaoTelas::new);
    }
}