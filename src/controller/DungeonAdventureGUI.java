/* DungeonAdventureGUI.java */

package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The GUI for Dungeon Adventure.
 * 
 * @author Chris Nichol
 * @version Spring 2022
 */
public class DungeonAdventureGUI extends JPanel {

	/**
	 * Generated Serial ID for serialization.
	 */
	private static final long serialVersionUID = 2015752850961490616L;
	
	/** The window title. */
    private static final String TITLE = "Dungeon Adventure";
    
    /** A ToolKit. */
    private static final Toolkit KIT = Toolkit.getDefaultToolkit();
    
    /** The list of movement buttons. */
    private List<JButton> myMovementButtons;
    
    /**
     * Initializes the GUI.
     */
    public DungeonAdventureGUI() {
        super();
        setLayout(new BorderLayout());
        buildComponents();
        layoutComponents();
    }
    
    /**
     * Creates a new button.
     * 
     * @param buttonName the name overlayed on the button
     * @return returns the newly created button
     */
    private JButton createButton(final String buttonName) {
        final JButton button = new JButton(buttonName);
        button.setEnabled(false);
        return button;
    }
    
    /**
     * Instantiate the graphical components.
     */
    private void buildComponents() {
        
        // create the movement buttons
        myMovementButtons = new ArrayList<JButton>();
        myMovementButtons.add(createButton("UP")); // 0 - UP
        myMovementButtons.add(createButton("DN")); // 1 - DOWN
        myMovementButtons.add(createButton("LF")); // 2 - LEFT
        myMovementButtons.add(createButton("RT")); // 3 - RIGHT
    }
    
    /**
     * Sets up the graphical components.
     */
    private void layoutComponents() {

        // add the filter buttons to a panel
        final JPanel topPanel = new JPanel(new FlowLayout());
        for (final JButton button : myMovementButtons) {
            topPanel.add(button);
        }
        add(topPanel, BorderLayout.NORTH);
    }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public static void generateGUI() {
        final DungeonAdventureGUI mainPanel = 
                        new DungeonAdventureGUI();
        
        // A size for the JFrame.
        //final Dimension frameSize = new Dimension(400, 400);
        
        // set properties of the frame
        final JFrame window = new JFrame(TITLE);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setMinimumSize(new Dimension());
        window.setContentPane(mainPanel);
        window.pack();
        window.setMinimumSize(window.getSize());
        window.setLocation(
            (int) (KIT.getScreenSize().getWidth() / 2 - window.getWidth() / 2),
            (int) (KIT.getScreenSize().getHeight() / 2 - window.getHeight() / 2));
        window.setVisible(true);
        }
        
}