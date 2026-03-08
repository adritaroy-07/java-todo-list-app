import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TodoApp {

    public static void main(String[] args) {

        JFrame frame = new JFrame("To-Do List");

        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(listModel);

        JTextField taskField = new JTextField(15);

        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");

        JPanel panel = new JPanel();

        panel.add(taskField);
        panel.add(addButton);
        panel.add(deleteButton);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);

        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        addButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String task = taskField.getText();

                if(!task.equals("")){

                    listModel.addElement(task);
                    taskField.setText("");

                }

            }

        });

        deleteButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                int index = taskList.getSelectedIndex();

                if(index != -1){

                    listModel.remove(index);

                }

            }

        });

    }
}