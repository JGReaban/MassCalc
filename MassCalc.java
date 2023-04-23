package MassCalc.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MassCalc extends JFrame {
	
	int height;
	double materialWeight = 47;
	double mass;
	double massToo;
	double buildModifier = 1;
	String calculatedMass;

	private JPanel contentPane;
	private final ButtonGroup buttonGroupBuild = new ButtonGroup();
	private JLabel lblHeight;
	private JSlider sldHeight;
	private JLabel lblMass;
	private JLabel lblMassToo;
	private final ButtonGroup buttonGroupMaterial = new ButtonGroup();
	private JTextField txtMatCustom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MassCalc frame = new MassCalc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MassCalc() {
		setTitle("Mass Calculator for Human Shaped Bodies");
		
		initComponents();
		createEvents();
		calcMass();
		calcMassToo();
		
	}
	
	private void initComponents() {
		// TODO Auto-generated method stub

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 310);
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Height");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setBounds(24, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblHeight = new JLabel("1");
		lblHeight.setBounds(80, 11, 46, 14);
		contentPane.add(lblHeight);
		
		JLabel lblNewLabel_1 = new JLabel("Mass/Weight");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(155, 11, 64, 14);
		contentPane.add(lblNewLabel_1);
		
		lblMass = new JLabel("1");
		lblMass.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblMass.setBounds(256, 11, 123, 14);
		contentPane.add(lblMass);
		
		sldHeight = new JSlider();
		sldHeight.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		sldHeight.setValue(72);
		sldHeight.setMaximum(150);
		sldHeight.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				calcMass();
				calcMassToo();
				
			}

			

			
		});
		sldHeight.setPaintLabels(true);
		sldHeight.setPaintTicks(true);
		sldHeight.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		sldHeight.setBounds(35, 107, 359, 37);
		sldHeight.setMajorTickSpacing(12);
		contentPane.add(sldHeight);
		
		JPanel pnlBuild = new JPanel();
		pnlBuild.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Build", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlBuild.setBounds(10, 46, 414, 50);
		contentPane.add(pnlBuild);
		
		JRadioButton thingButton = new JRadioButton("Thin");
		thingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buildModifier = .75;
				calcMass();
				calcMassToo();
			}
		});
		buttonGroupBuild.add(thingButton);
		pnlBuild.add(thingButton);
		
		JRadioButton lightButton = new JRadioButton("Light");
		lightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buildModifier = .85;
				calcMass();
				calcMassToo();
				
			}
		});
		buttonGroupBuild.add(lightButton);
		pnlBuild.add(lightButton);
		
		JRadioButton averageButton = new JRadioButton("Average");
		averageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buildModifier = 1;
				calcMass();
				calcMassToo();
			}
		});
		
		buttonGroupBuild.add(averageButton);
		averageButton.setSelected(true);
		pnlBuild.add(averageButton);
		
		JRadioButton heavyButton = new JRadioButton("Heavy");
		heavyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buildModifier = 1.20;
				calcMass();
				calcMassToo();
				
			}
		});
		
		buttonGroupBuild.add(heavyButton);
		pnlBuild.add(heavyButton);
		
		JRadioButton athleticButton = new JRadioButton("Athletic");
		athleticButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buildModifier = 1.45;
				calcMass();
				calcMassToo();
			}
		});
		buttonGroupBuild.add(athleticButton);
		pnlBuild.add(athleticButton);
		
		lblMassToo = new JLabel("New label");
		lblMassToo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblMassToo.setBounds(256, 32, 137, 14);
		contentPane.add(lblMassToo);
		
		JPanel pnlMaterial = new JPanel();
		pnlMaterial.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Material", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlMaterial.setBounds(10, 155, 414, 116);
		contentPane.add(pnlMaterial);
		
		JRadioButton rdbtnMatFlesh = new JRadioButton("Flesh");
		rdbtnMatFlesh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				materialWeight = 47;
				calcMass();
				calcMassToo();
			}
		});
		buttonGroupMaterial.add(rdbtnMatFlesh);
		rdbtnMatFlesh.setSelected(true);
		pnlMaterial.add(rdbtnMatFlesh);
		
		JRadioButton rdbtnMatStone = new JRadioButton("Stone");
		rdbtnMatStone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				materialWeight = 170;
				calcMass();
				calcMassToo();
			}
		});
		buttonGroupMaterial.add(rdbtnMatStone);
		pnlMaterial.add(rdbtnMatStone);
		
		JRadioButton rdbtnMatBone = new JRadioButton("Bone");
		rdbtnMatBone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				materialWeight = 115;
				calcMass();
				calcMassToo();
			}
		});
		buttonGroupMaterial.add(rdbtnMatBone);
		pnlMaterial.add(rdbtnMatBone);
		
		JRadioButton rdbtnMatBrass = new JRadioButton("Brass");
		rdbtnMatBrass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				materialWeight = 535;
				calcMass();
				calcMassToo();
			}
		});
		buttonGroupMaterial.add(rdbtnMatBrass);
		pnlMaterial.add(rdbtnMatBrass);
		
		JRadioButton rdbtnMatSilver = new JRadioButton("Silver");
		rdbtnMatSilver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				materialWeight = 655;
				calcMass();
				calcMassToo();
			}
		});
		buttonGroupMaterial.add(rdbtnMatSilver);
		pnlMaterial.add(rdbtnMatSilver);
		
		JRadioButton rdbtnMatGold = new JRadioButton("Gold");
		rdbtnMatGold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				materialWeight = 1205;
				calcMass();
				calcMassToo();
			}
		});
		buttonGroupMaterial.add(rdbtnMatGold);
		pnlMaterial.add(rdbtnMatGold);
		
		JRadioButton rdbtnMatIron = new JRadioButton("Iron");
		rdbtnMatIron.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				materialWeight = 485;
				calcMass();
				calcMassToo();
			}
		});
		buttonGroupMaterial.add(rdbtnMatIron);
		rdbtnMatIron.setToolTipText("Also Steel");
		pnlMaterial.add(rdbtnMatIron);
		
		JRadioButton rdbtnMatLead = new JRadioButton("Lead");
		rdbtnMatLead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				materialWeight = 710;
				calcMass();
				calcMassToo();
			}
		});
		buttonGroupMaterial.add(rdbtnMatLead);
		pnlMaterial.add(rdbtnMatLead);
		
		JRadioButton rdbtnMatGlass = new JRadioButton("Glass");
		rdbtnMatGlass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				materialWeight = 160;
				calcMass();
				calcMassToo();
			}
		});
		buttonGroupMaterial.add(rdbtnMatGlass);
		pnlMaterial.add(rdbtnMatGlass);
		
		JRadioButton rdbtnMatAmber = new JRadioButton("Amber");
		rdbtnMatAmber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				materialWeight = 68;
				calcMass();
				calcMassToo();
			}
		});
		buttonGroupMaterial.add(rdbtnMatAmber);
		pnlMaterial.add(rdbtnMatAmber);
		
		JRadioButton rdbtnMatWood = new JRadioButton("Wood");
		rdbtnMatWood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				materialWeight = 45;
				calcMass();
				calcMassToo();
			}
		});
		buttonGroupMaterial.add(rdbtnMatWood);
		pnlMaterial.add(rdbtnMatWood);
		
		JRadioButton rdbtnMatEbony = new JRadioButton("Ebony");
		rdbtnMatEbony.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				materialWeight = 76;
				calcMass();
				calcMassToo();
			}
		});
		buttonGroupMaterial.add(rdbtnMatEbony);
		pnlMaterial.add(rdbtnMatEbony);
		
		JRadioButton rdbtnMatWax = new JRadioButton("Wax");
		rdbtnMatWax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				materialWeight = 112;
				calcMass();
				calcMassToo();
			}
		});
		buttonGroupMaterial.add(rdbtnMatWax);
		pnlMaterial.add(rdbtnMatWax);
		
		JRadioButton rdbtnMatIce = new JRadioButton("Ice");
		rdbtnMatIce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				materialWeight = 57.2;
				calcMass();
				calcMassToo();
			}
		});
		buttonGroupMaterial.add(rdbtnMatIce);
		pnlMaterial.add(rdbtnMatIce);
		
		JRadioButton rdbtnMatClay = new JRadioButton("Clay");
		rdbtnMatClay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				materialWeight = 140;
				calcMass();
				calcMassToo();
			}
		});
		buttonGroupMaterial.add(rdbtnMatClay);
		pnlMaterial.add(rdbtnMatClay);
		
		JRadioButton rdbtnMatPlatinum = new JRadioButton("Platinum");
		rdbtnMatPlatinum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				materialWeight = 1340;
				calcMass();
				calcMassToo();
			}
		});
		buttonGroupMaterial.add(rdbtnMatPlatinum);
		pnlMaterial.add(rdbtnMatPlatinum);
		
		JRadioButton rdbtnMatCustom = new JRadioButton("Custom");
		rdbtnMatCustom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				materialWeight = Double.parseDouble(txtMatCustom.getText());
				}
				catch (Exception ex){
					materialWeight = 47;
					txtMatCustom.setText("47");
				}
				
				calcMass();
				calcMassToo();
			}
		});
		buttonGroupMaterial.add(rdbtnMatCustom);
		pnlMaterial.add(rdbtnMatCustom);
		
		txtMatCustom = new JTextField();
		txtMatCustom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					materialWeight = Double.parseDouble(txtMatCustom.getText());
					}
					catch (Exception ex){
						materialWeight = 47;
						txtMatCustom.setText("47");
					}
					
					calcMass();
					calcMassToo();
			}
		});
		txtMatCustom.setHorizontalAlignment(SwingConstants.CENTER);
		txtMatCustom.setText("46");
		pnlMaterial.add(txtMatCustom);
		txtMatCustom.setColumns(5);
		
		
		
		
		
		
		
		
	}

	private void createEvents() {
		// TODO Auto-generated method stub
		
	}
	
	private void calcMass() {
		// TODO Auto-generated method stub
		height = sldHeight.getValue();
		lblHeight.setText(Integer.toString(height));
		mass = height * height * height * .0000107 * materialWeight * buildModifier;
		calculatedMass = mass + " lbs.";
		lblMass.setText(calculatedMass);
		
	}
	
	private void calcMassToo() {
		double torsoLength;
		double chestSize;
		
		height = sldHeight.getValue();
		lblHeight.setText(Integer.toString(height));
		
		torsoLength = height * .2647;
		chestSize = height * .5588;
		
		mass = chestSize / 6.28;
		mass = mass * mass;
		mass = mass * 3.12;
		mass = mass * torsoLength;
		mass = mass / .35;
		mass = mass / 1748;
		mass = mass * materialWeight * buildModifier;
		
		calculatedMass = mass + " lbs.";
		lblMassToo.setText(calculatedMass);
		
	}
	
	
}
