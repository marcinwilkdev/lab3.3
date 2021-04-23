import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main {
    final static String CPP_PATH1 = "/Users/marcin/Documents/programming/java/lab1/./Test";
    final static String CPP_PATH2 = "/Users/marcin/Documents/programming/lab4/lab1_cpp/./main";

    public static void main(String[] args) {
        String arguments;
        String path = CPP_PATH1;

        System.out.println("Podaj argumenty do programu:");
        System.out.print(path + " ");

        try (var in = new Scanner(System.in)) {
            arguments = in.nextLine();
        }

        EventQueue.invokeLater(() -> {
            var frame = new MainFrame(path, arguments);
            frame.setTitle("ProgramCPP");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class MainFrame extends JFrame {
    public MainFrame(String path, String arguments) {
        add(new MainComponent(path, arguments));
        pack();
    }
}

class MainComponent extends JComponent {
    private ProgramCPP program;

    public MainComponent(String path, String arguments) {
        program = new ProgramCPP(path, arguments);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawString("Wynik działania tego programu to:", 50, 50);

        for (int i=0; i<program.getOutputLines().size(); i++) {
            g.drawString(program.getOutputLines().get(i), 50, 50 + g.getFontMetrics().getHeight() * (i + 2));
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 300);
    }
}
