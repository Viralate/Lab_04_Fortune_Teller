import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private JLabel titleLabel;
    private JTextArea fortuneArea;
    private JScrollPane scrollPane;
    private JButton readFortuneButton;
    private JButton quitButton;
    private ArrayList<String> fortunes;
    private int previousFortuneIndex = -1;

    public FortuneTellerFrame() {
        // Set the title of the JFrame
        setTitle("Fortune Teller");
        
        // Create the components
        createComponents();
        
        // Layout the components
        layoutComponents();
        
        // Set frame settings
        setFrameSettings();
    }

    private void createComponents() {
        // Top panel components
        titleLabel = new JLabel("Fortune Teller", JLabel.CENTER);
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/fortuneteller.jpg"));
        titleLabel.setIcon(icon);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 48));

        // Middle panel components
        fortuneArea = new JTextArea(10, 30);
        fortuneArea.setFont(new Font("SansSerif", Font.PLAIN, 16));
        fortuneArea.setEditable(false);
        scrollPane = new JScrollPane(fortuneArea);
        
        // Bottom panel components
        readFortuneButton = new JButton("Read My Fortune!");
        quitButton = new JButton("Quit");

        // Create an array of fortunes
        fortunes = new ArrayList<>();
        fillFortunes();
    }

    private void fillFortunes() {
        // Add at least 12 humorous fortunes
        fortunes.add("You will have a great day!");
        fortunes.add("Good fortune will find you soon.");
        fortunes.add("You will encounter a pleasant surprise.");
        fortunes.add("A new opportunity is on the horizon.");
        fortunes.add("Someone will bring joy into your life.");
        fortunes.add("You are about to embark on an exciting adventure.");
        fortunes.add("An unexpected event will bring you happiness.");
        fortunes.add("Fortune favors the brave.");
        fortunes.add("A thrilling time is in your near future.");
        fortunes.add("You will find what you are looking for.");
        fortunes.add("Your kindness will lead you to success.");
        fortunes.add("A smile is your key to good luck.");
    }

    private void layoutComponents() {
        // Set layout manager
        setLayout(new BorderLayout());
        
        // Add components to the frame
        add(titleLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        
        // Bottom panel with buttons
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.add(readFortuneButton);
        bottomPanel.add(quitButton);
        add(bottomPanel, BorderLayout.SOUTH);
        
        // Action listeners for the buttons
        readFortuneButton.addActionListener(this::displayFortune);
        quitButton.addActionListener(e -> System.exit(0));
    }

    private void displayFortune(ActionEvent e) {
        Random random = new Random();
        int currentFortuneIndex;
        
        // Make sure the new fortune is not the same as the previous one
        do {
            currentFortuneIndex = random.nextInt(fortunes.size());
        } while (currentFortuneIndex == previousFortuneIndex);
        
        // Display the fortune in the text area
        fortuneArea.append(fortunes.get(currentFortuneIndex) + "\n");
        previousFortuneIndex = currentFortuneIndex;
    }

    private void setFrameSettings() {
        // Set the size of the frame to 3/4 of the screen width
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize(screenSize.width * 3 / 4, screenSize.height / 2);
        
        // Center the frame on the screen
        setLocationRelativeTo(null);
        
        // Make sure the program closes when the user exits
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Make the frame visible
        setVisible(true);
    }
}
