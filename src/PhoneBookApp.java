import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PhoneBookApp extends JFrame {

    private static final long serialVersionUID = 1L;

    private final JLabel surnameLabel;
    private final JTextField surnameField;
    private final JLabel phonesLabel;
    private final JTextField phonesField;
    private final JLabel countLabel;
    private final JButton printButton;
    private final JPanel inputPanel;
    private final JPanel outputPanel;
    private final TreeSet<String> phoneBook;

    public PhoneBookApp() {
        // Ініціалізація структури даних телефонної книги
        phoneBook = new TreeSet<>();

        // Ініціалізація компонентів панелі введення
        surnameLabel = new JLabel("Прізвище:");
        surnameField = new JTextField(20);
        phonesLabel = new JLabel("Телефони:");
        phonesField = new JTextField(20);
        countLabel = new JLabel("Кількість записів: 0");
        printButton = new JButton("Друкувати");
        printButton.addActionListener(new PrintButtonListener());
        inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(surnameLabel);
        inputPanel.add(surnameField);
        inputPanel.add(phonesLabel);
        inputPanel.add(phonesField);
        inputPanel.add(countLabel);
        inputPanel.add(printButton);

        // Ініціалізація панелі виведення
        outputPanel = new JPanel(new BorderLayout());

        // Ініціалізація головного вікна
        setTitle("Телефонна книга");
        setLayout(new GridLayout(2, 1));
        add(inputPanel);
        add(outputPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setVisible(true);
    }

    private void clearInputFields() {
        surnameField.setText("");
        phonesField.setText("");
    }

    private void updateCountLabel() {
        countLabel.setText("Кількість записів: " + phoneBook.size());
    }

    private class PrintButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Print phone book contents to console
            System.out.println("Записи в телефонній книзі:");
            for (String entry : phoneBook) {
                System.out.println(entry);
            }
        }
    }

    public static void main(String[] args) {
        new PhoneBookApp();
    }

}
