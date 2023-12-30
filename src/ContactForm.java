import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {

    private final JTextField name_field, email_field;
    private final JRadioButton male;
    private final JCheckBox check;

    public ContactForm() {
        super("Контактная форма");
        super.setBounds(200, 100, 300, 230);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(5, 2, 2, 10));

        JLabel name = new JLabel("Введите имя:");
        name_field = new JTextField("", 1);
        JLabel email = new JLabel("Введите email:");
        email_field = new JTextField("@", 1);

        container.add(name);
        container.add(name_field);
        container.add(email);
        container.add(email_field);

        male = new JRadioButton("Мужской");
        JRadioButton female = new JRadioButton("Женский");
        check = new JCheckBox("Согласен", false);
        JButton send_button = new JButton("Отправить");

        male.setSelected(true);
        container.add(male);
        container.add(female);

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        container.add(check);
        container.add(send_button);

        send_button.addActionListener(new ButtonEventManager());
    }

    class ButtonEventManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = name_field.getText();
            String email = email_field.getText();

            String isMale = "Мужской";
            if (!male.isSelected())
                isMale = "Женский";

            boolean checkBox = check.isSelected();

            JOptionPane.showMessageDialog(null, "Ваша почта: " + email + "\nВаш пол: " + isMale + "\nВы согласны? " + checkBox, "Привет " + name,JOptionPane.PLAIN_MESSAGE);
        }
    }

}
