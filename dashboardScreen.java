import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicScrollBarUI;

@SuppressWarnings({ "removal", "serial" })
public class dashboardScreen extends JFrame {

	static JLayeredPane layeredPaneDashboard = new JLayeredPane();

	public static JFrame dashboardFrame = new JFrame();
	public static JPanel dashboardJPanel = new JPanel();

	// Scroll Panes
	static JScrollPane scrollPaneAll = new JScrollPane();
	static JScrollPane scrollPaneFilipino = new JScrollPane();
	static JScrollPane scrollPaneItalian = new JScrollPane();
	static JScrollPane scrollPaneChinese = new JScrollPane();
	static JScrollPane scrollPaneJapanese = new JScrollPane();

	// For animation
	static private final int animationDuration = 3; // Ads Animation duration in milliseconds
	static private final int animationSteps = 60;

	// User
	public static JLabel name = new JLabel();

	// Side Panel Animation
	static JLabel greenBarBG = new JLabel(new ImageIcon("greenBar.png"));
	static Timer slideToHome;
	static Timer slideToRecipe;
	static Timer slideToMeal;

	// Side Panel Buttons
	static JButton homeButton = new JButton();
	static JButton recipeButton = new JButton();
	static JButton mealButton = new JButton();
	static JButton logout = new JButton();

	// Choices Button
	static JButton all = new JButton();
	static JButton filipino = new JButton();
	static JButton italian = new JButton();
	static JButton chinese = new JButton();
	static JButton japanese = new JButton();

	static ImageIcon allIcon = new ImageIcon("All.png");
	static ImageIcon filipinoIcon = new ImageIcon("Filipino.png");
	static ImageIcon italianIcon = new ImageIcon("Italian.png");
	static ImageIcon chineseIcon = new ImageIcon("Chinese.png");
	static ImageIcon japaneseIcon = new ImageIcon("Japanese.png");

	// For meantime code | design only
	static JPanel contentAll = new JPanel();
	static JPanel contentFilipino = new JPanel();
	static JPanel contentItalian = new JPanel();
	static JPanel contentChinese = new JPanel();
	static JPanel contentJapanese = new JPanel();

	// BG
	static JLabel dashboardBG = new JLabel(new ImageIcon("dashboard.png"));
	static JLabel recipeBG = new JLabel(new ImageIcon("recipe.png"));
	static JLabel mealPlanBG = new JLabel(new ImageIcon("mealPlan.png"));

	static void runDashboard() {

		// Side Panel Buttons
		homeButton.addActionListener(e -> {
			slideToHome.start();

			resetChoiceIcons();
			resetScrollPane();
			resetBg();

			all.setIcon(allIcon);
			scrollPaneAll.getViewport().setViewPosition(new Point(0, 0));
			scrollPaneAll.setVisible(true);

			dashboardBG.setVisible(true);
		});

		recipeButton.addActionListener(e -> {
			slideToRecipe.start();

			resetChoiceIcons();
			resetScrollPane();
			resetBg();

			all.setIcon(allIcon);
			scrollPaneAll.getViewport().setViewPosition(new Point(0, 0));
			scrollPaneAll.setVisible(true);

			recipeBG.setVisible(true);
		});

		mealButton.addActionListener(e -> {
			slideToMeal.start();

			resetChoiceIcons();
			resetScrollPane();
			resetBg();

			mealPlanBG.setVisible(true);
		});

		// For logout
		logout();

		// Choices Button listner
		all.addActionListener(e -> {
			resetChoiceIcons();
			resetScrollPane();
			all.setIcon(allIcon);
			scrollPaneAll.setVisible(true);
		});

		filipino.addActionListener(e -> {
			resetChoiceIcons();
			resetScrollPane();
			filipino.setIcon(filipinoIcon);
			scrollPaneFilipino.setVisible(true);
		});

		italian.addActionListener(e -> {
			resetChoiceIcons();
			resetScrollPane();
			italian.setIcon(italianIcon);
			scrollPaneItalian.setVisible(true);
		});

		chinese.addActionListener(e -> {
			resetChoiceIcons();
			resetScrollPane();
			chinese.setIcon(chineseIcon);
			scrollPaneChinese.setVisible(true);
		});

		japanese.addActionListener(e -> {
			resetChoiceIcons();
			resetScrollPane();
			japanese.setIcon(japaneseIcon);
			scrollPaneJapanese.setVisible(true);
		});

		// Animation Green Bar
		slideToHome = new Timer(animationDuration, new ActionListener() {

			private int step = 0;
			private int initialY;

			@Override
			public void actionPerformed(ActionEvent e) {

				if (step == 0) {
					initialY = greenBarBG.getLocation().y;
				}
				step++;
				// Apply easing function (cubic easing out) to the step
				float t = (float) step / animationSteps;
				float easedStep = 1 - (1 - t) * (1 - t) * (1 - t);
				int y = Math.round(initialY + ((78 - initialY) * easedStep));

				greenBarBG.setLocation(0, y);

				if (y == 78) { // Stop the timer
					slideToHome.stop();
					step = 0;
				}
			}
		});

		slideToRecipe = new Timer(animationDuration, new ActionListener() {

			private int step = 0;
			private int initialY;

			@Override
			public void actionPerformed(ActionEvent e) {

				if (step == 0) {
					initialY = greenBarBG.getLocation().y;
				}
				step++;
				// Apply easing function (cubic easing out) to the step
				float t = (float) step / animationSteps;
				float easedStep = 1 - (1 - t) * (1 - t) * (1 - t);
				int y = Math.round(initialY + ((119 - initialY) * easedStep));

				greenBarBG.setLocation(0, y);

				if (y == 119) { // Stop the timer
					slideToRecipe.stop();
					step = 0;
				}
			}
		});

		slideToMeal = new Timer(animationDuration, new ActionListener() {

			private int step = 0;
			private int initialY;

			@Override
			public void actionPerformed(ActionEvent e) {

				if (step == 0) {
					initialY = greenBarBG.getLocation().y;
				}
				step++;
				// Apply easing function (cubic easing out) to the step
				float t = (float) step / animationSteps;
				float easedStep = 1 - (1 - t) * (1 - t) * (1 - t);
				int y = Math.round(initialY + ((158 - initialY) * easedStep));

				greenBarBG.setLocation(0, y);

				if (y == 158) { // Stop the timer
					slideToMeal.stop();
					step = 0;
				}
			}
		});

	}

	static void resetChoiceIcons() {
		all.setIcon(null);
		filipino.setIcon(null);
		italian.setIcon(null);
		chinese.setIcon(null);
		japanese.setIcon(null);
	}

	static void resetScrollPane() {
		scrollPaneAll.setVisible(false);
		scrollPaneFilipino.setVisible(false);
		scrollPaneItalian.setVisible(false);
		scrollPaneChinese.setVisible(false);
		scrollPaneJapanese.setVisible(false);
	}

	static void resetBg() {
		dashboardBG.setVisible(false);
		recipeBG.setVisible(false);
		mealPlanBG.setVisible(false);
	}

	static void logout() {

		JButton logoutButton = new JButton("Logout");
		logoutButton.setFont(createAccount.buttonFont);
		logoutButton.setBackground(Color.WHITE);
		logoutButton.setFocusPainted(false);
		logoutButton.setBorderPainted(true);

		JButton noButton = new JButton("No");
		noButton.setFont(createAccount.buttonFont);
		noButton.setBackground(Color.WHITE);
		noButton.setFocusPainted(false);
		noButton.setBorderPainted(true);

		logout.addActionListener(e -> {

			Object[] options = { logoutButton, noButton };
			UIManager.put("OptionPane.messageFont", new Font("Open Sans Bold", Font.TRUETYPE_FONT, 15));
			JOptionPane pane = new JOptionPane("Are you sure you want to Logout?", JOptionPane.QUESTION_MESSAGE,
					JOptionPane.OK_OPTION, null, options);
			JDialog dialog = pane.createDialog("Logout confirmation");

			logoutButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dialog.dispose();
					mainScreen.mainFrame.setVisible(true);
					dashboardFrame.setVisible(false);

					// Reset All properties here....
					greenBarBG.setBounds(0, 78, 223, 37);
					resetChoiceIcons();
					resetScrollPane();
					resetBg();
					dashboardBG.setVisible(true);
					all.setIcon(allIcon);
					scrollPaneAll.setVisible(true);
					scrollPaneAll.getViewport().setViewPosition(new Point(0, 0));
				}
			});
			noButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dialog.dispose();
				}
			});
			dialog.setVisible(true);
		});

	}

	static void createDashboard() {

		dashboardFrame.setSize(1366, 768); // Best Size for GUI system
		dashboardFrame.setUndecorated(true);
		dashboardFrame.setVisible(true);

		dashboardJPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				int cornerRadius = 35; // The roundness of the Frame
				int width = getWidth();
				int height = getHeight();

				g2.setColor(new Color(0, 0, 0, 0));
				g2.fillRoundRect(0, 0, width, height, cornerRadius, cornerRadius);
			}
		};

		dashboardFrame.setContentPane(dashboardJPanel);
		dashboardFrame.getContentPane().setLayout(null);
		dashboardFrame.setBackground(new Color(0, 0, 0, 0));
		dashboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dashboardFrame.setLocationRelativeTo(null);

		// Background
		dashboardBG.setBounds(0, 0, 1366, 768);
		recipeBG.setBounds(0, 0, 1366, 768);
		mealPlanBG.setBounds(0, 0, 1366, 768);

		recipeBG.setVisible(false);
		mealPlanBG.setVisible(false);

		JLabel buttonsBG = new JLabel(new ImageIcon("dashboardSide.png"));
		buttonsBG.setBounds(0, 0, 223, 768);

		greenBarBG.setBounds(0, 78, 223, 37);
//		greenBarBG.setBounds(0, 119, 223, 37);
//		greenBarBG.setBounds(0, 158, 223, 37);

		JPanel mainButtonsPanel = new JPanel();
		mainButtonsPanel.setLayout(null);
		mainButtonsPanel.setBackground(new Color(0, 0, 0, 0));
		mainButtonsPanel.setBounds(0, 63, 222, 686);

		JLabel greatings = new JLabel("Welcome,");
		greatings.setFont(new Font("Poppins SemiBold", Font.TRUETYPE_FONT, 23));
		greatings.setForeground(Color.WHITE);

		name.setFont(new Font("Poppins SemiBold", Font.TRUETYPE_FONT, 23));
		name.setForeground(Color.WHITE);

		greatings.setBounds(10, 220, 200, 25);
		name.setBounds(10, 245, 200, 30);

		// Side Buttons
		homeButton.setBounds(7, 78, 206, 37);
		homeButton.setBorderPainted(false);
		homeButton.setContentAreaFilled(false);
		homeButton.setOpaque(false);

		recipeButton.setBounds(7, 119, 206, 37);
		recipeButton.setBorderPainted(false);
		recipeButton.setContentAreaFilled(false);
		recipeButton.setOpaque(false);

		mealButton.setBounds(7, 158, 206, 37);
		mealButton.setBorderPainted(false);
		mealButton.setContentAreaFilled(false);
		mealButton.setOpaque(false);

		logout.setBounds(7, 716, 206, 37);
		logout.setBorderPainted(false);
		logout.setContentAreaFilled(false);
		logout.setOpaque(false);

		// Choices Button
		all.setBounds(549, 238, 92, 32);
		all.setIcon(allIcon);
		all.setBorderPainted(false);
		all.setContentAreaFilled(false);
		all.setOpaque(false);

		filipino.setBounds(641, 238, 92, 32);
		filipino.setBorderPainted(false);
		filipino.setContentAreaFilled(false);
		filipino.setOpaque(false);

		italian.setBounds(733, 238, 92, 32);
		italian.setBorderPainted(false);
		italian.setContentAreaFilled(false);
		italian.setOpaque(false);

		chinese.setBounds(823, 238, 92, 32);
		chinese.setBorderPainted(false);
		chinese.setContentAreaFilled(false);
		chinese.setOpaque(false);

		japanese.setBounds(912, 238, 92, 32);
		japanese.setBorderPainted(false);
		japanese.setContentAreaFilled(false);
		japanese.setOpaque(false);

		// Add Cursor
		homeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		recipeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mealButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		all.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		filipino.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		italian.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chinese.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		japanese.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		// Layered Panel
		layeredPaneDashboard.setSize(dashboardJPanel.getSize());
		dashboardJPanel.add(layeredPaneDashboard);

		// Add & Customized Scroll Pane
		scrollPaneAll.setBounds(231, 288, 1123, 470);
		scrollPaneAll.setBorder(BorderFactory.createEmptyBorder());
		scrollPaneAll.getVerticalScrollBar().setUI(new CustomScrollBarUI());
		scrollPaneAll.getHorizontalScrollBar().setUI(new CustomScrollBarUI());
		scrollPaneAll.getVerticalScrollBar().setPreferredSize(new Dimension(13, Integer.MAX_VALUE));

		scrollPaneAll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneAll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneAll.setWheelScrollingEnabled(true);
		scrollPaneAll.getVerticalScrollBar().setUnitIncrement(8);

		scrollPaneFilipino.setBounds(231, 288, 1123, 470);
		scrollPaneFilipino.setBorder(BorderFactory.createEmptyBorder());
		scrollPaneFilipino.getVerticalScrollBar().setUI(new CustomScrollBarUI());
		scrollPaneFilipino.getHorizontalScrollBar().setUI(new CustomScrollBarUI());
		scrollPaneFilipino.getVerticalScrollBar().setPreferredSize(new Dimension(13, Integer.MAX_VALUE));

		scrollPaneFilipino.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneFilipino.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneFilipino.setWheelScrollingEnabled(true);
		scrollPaneFilipino.getVerticalScrollBar().setUnitIncrement(8);
		scrollPaneFilipino.setVisible(false);

		scrollPaneItalian.setBounds(231, 288, 1123, 470);
		scrollPaneItalian.setBorder(BorderFactory.createEmptyBorder());
		scrollPaneItalian.getVerticalScrollBar().setUI(new CustomScrollBarUI());
		scrollPaneItalian.getHorizontalScrollBar().setUI(new CustomScrollBarUI());
		scrollPaneItalian.getVerticalScrollBar().setPreferredSize(new Dimension(13, Integer.MAX_VALUE));

		scrollPaneItalian.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneItalian.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneItalian.setWheelScrollingEnabled(true);
		scrollPaneItalian.getVerticalScrollBar().setUnitIncrement(8);
		scrollPaneItalian.setVisible(false);

		scrollPaneChinese.setBounds(231, 288, 1123, 470);
		scrollPaneChinese.setBorder(BorderFactory.createEmptyBorder());
		scrollPaneChinese.getVerticalScrollBar().setUI(new CustomScrollBarUI());
		scrollPaneChinese.getHorizontalScrollBar().setUI(new CustomScrollBarUI());
		scrollPaneChinese.getVerticalScrollBar().setPreferredSize(new Dimension(13, Integer.MAX_VALUE));

		scrollPaneChinese.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneChinese.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneChinese.setWheelScrollingEnabled(true);
		scrollPaneChinese.getVerticalScrollBar().setUnitIncrement(8);
		scrollPaneChinese.setVisible(false);

		scrollPaneJapanese.setBounds(231, 288, 1123, 470);
		scrollPaneJapanese.setBorder(BorderFactory.createEmptyBorder());
		scrollPaneJapanese.getVerticalScrollBar().setUI(new CustomScrollBarUI());
		scrollPaneJapanese.getHorizontalScrollBar().setUI(new CustomScrollBarUI());
		scrollPaneJapanese.getVerticalScrollBar().setPreferredSize(new Dimension(13, Integer.MAX_VALUE));

		scrollPaneJapanese.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneJapanese.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneJapanese.setWheelScrollingEnabled(true);
		scrollPaneJapanese.getVerticalScrollBar().setUnitIncrement(8);
		scrollPaneJapanese.setVisible(false);

		// For meantime code | design only
		JLabel bgAll = new JLabel(new ImageIcon("allEx.png"));
		JLabel bgFilipino = new JLabel(new ImageIcon("filipinoEx.png"));
		JLabel bgItalian = new JLabel(new ImageIcon("italianEx.png"));
		JLabel bgChinese = new JLabel(new ImageIcon("chineseEx.png"));
		JLabel bgJapanese = new JLabel(new ImageIcon("japaneseEx.png"));

		// Adding the design
		bgAll.setBounds(0, 0, 1105, 566);
		contentAll.setBackground(new Color(238, 240, 244));
		contentAll.add(bgAll);
		scrollPaneAll.setViewportView(contentAll);

		bgFilipino.setBounds(0, 0, 1105, 286);
		contentFilipino.setBackground(new Color(238, 240, 244));
		contentFilipino.add(bgFilipino);
		scrollPaneFilipino.setViewportView(contentFilipino);

		bgItalian.setBounds(0, 0, 1105, 286);
		contentItalian.setBackground(new Color(238, 240, 244));
		contentItalian.add(bgItalian);
		scrollPaneItalian.setViewportView(contentItalian);

		bgChinese.setBounds(0, 0, 1105, 286);
		contentChinese.setBackground(new Color(238, 240, 244));
		contentChinese.add(bgChinese);
		scrollPaneChinese.setViewportView(contentChinese);

		bgJapanese.setBounds(0, 0, 1105, 286);
		contentJapanese.setBackground(new Color(238, 240, 244));
		contentJapanese.add(bgJapanese);
		scrollPaneJapanese.setViewportView(contentJapanese);

		// Dashboard BG & Side panel buttons
		layeredPaneDashboard.add(dashboardBG, new Integer(0));
		layeredPaneDashboard.add(recipeBG, new Integer(0));
		layeredPaneDashboard.add(mealPlanBG, new Integer(0));
		layeredPaneDashboard.add(mainButtonsPanel, new Integer(0));
		layeredPaneDashboard.add(greenBarBG, new Integer(1));
		layeredPaneDashboard.add(buttonsBG, new Integer(2));
		layeredPaneDashboard.add(greatings, new Integer(2));
		layeredPaneDashboard.add(name, new Integer(2));
		layeredPaneDashboard.add(homeButton, new Integer(3));
		layeredPaneDashboard.add(recipeButton, new Integer(3));
		layeredPaneDashboard.add(mealButton, new Integer(3));
		layeredPaneDashboard.add(logout, new Integer(3));

		// Choices Buttons
		layeredPaneDashboard.add(all, new Integer(3));
		layeredPaneDashboard.add(filipino, new Integer(3));
		layeredPaneDashboard.add(italian, new Integer(3));
		layeredPaneDashboard.add(chinese, new Integer(3));
		layeredPaneDashboard.add(japanese, new Integer(3));

		// Scroll Panes
		layeredPaneDashboard.add(scrollPaneAll, new Integer(3));
		layeredPaneDashboard.add(scrollPaneFilipino, new Integer(3));
		layeredPaneDashboard.add(scrollPaneItalian, new Integer(3));
		layeredPaneDashboard.add(scrollPaneChinese, new Integer(3));
		layeredPaneDashboard.add(scrollPaneJapanese, new Integer(3));

		runDashboard();
	}

//	public static void main(String[] args) {
//		createDashboard();
//	}

}

class CustomScrollBarUI extends BasicScrollBarUI {
	private final int radius = 9;

	@Override
	protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//		g2.setPaint(new GradientPaint(0, thumbBounds.y, new Color(230, 230, 230), thumbBounds.width, thumbBounds.y,
//				new Color(190, 190, 190)));
		g2.setPaint(new Color(17, 130, 59));
		g2.fillRoundRect(thumbBounds.x + 2, thumbBounds.y + 2, thumbBounds.width - 4, thumbBounds.height - 4, radius,
				radius);
		g2.setColor(new Color(150, 150, 150));
		g2.dispose();
	}

	@Override
	protected JButton createDecreaseButton(int orientation) {
		return createZeroButton();
	}

	@Override
	protected JButton createIncreaseButton(int orientation) {
		return createZeroButton();
	}

	@Override
	protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
		g.setColor(new Color(238, 240, 244));
		g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
	}

	private JButton createZeroButton() {
		JButton button = new JButton();
		Dimension zeroDim = new Dimension(0, 0);
		button.setPreferredSize(zeroDim);
		button.setMinimumSize(zeroDim);
		button.setMaximumSize(zeroDim);
		return button;
	}
}
