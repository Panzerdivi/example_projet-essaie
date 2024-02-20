package view;

import java.util.*;
import java.awt.*;

import javax.swing.*;

import Controler.ControleurProf;
import Model.Prof;

public class PanneauProf extends JPanel {
	private JTextField tfNom , tfAge,tfSpecialite, tfVille ;
	private JLabel lNom , lAge,lSpecialite, lVille;
	private JPanel pNord , plNom ,ptfNom, plAge , ptfAge ,plSpecialite, ptfSpecialite, plVille,ptfVille, pButton;
	private JButton bAjouter;
	private JTable tProfs ;
	private JScrollPane spProfs ;
	private Component lSpecialiste;
	public PanneauProf(){
		Prof p = new Prof();
		ArrayList<Prof> liste = p.read();
		String entete[] ={"Nom", "Age", "Specialité", "Ville"};
		String[][] donnees = new String [ liste.size()][entete.length];
		for(int i = 0 ; i < liste.size(); i++) {
			donnees[i][0] = liste.get(i).getNom();
			donnees[i][1] = "" + liste.get(i).getAge();
			donnees[i][2] = "" + liste.get(i).getSpecialite();
			donnees[i][3] = "" + liste.get(i).getVille();
		}
		TableauModele tm = new TableauModele(donnees, entete);
		this.tProfs = new JTable (tm);
		this.spProfs = new JScrollPane(this.tProfs);
		this.lNom = new JLabel ("Nom : ");
		this.lNom.setFont (new Font("times New Roman", Font.PLAIN, 25));
		this.lAge = new JLabel ("Age : ");
		this.lAge.setFont (new Font("times New Roman", Font.PLAIN, 25));
		this.lSpecialite = new JLabel ("Spécialité : ");
		this.lSpecialite.setFont (new Font("times New Roman", Font.PLAIN, 25));
		this.lVille = new JLabel ("Ville: ");
		this.lVille.setFont (new Font("times New Roman", Font.PLAIN, 25));
		this.tfNom = new JTextField();
		this.tfNom.setPreferredSize(new Dimension(200,25));
		this.tfNom.setForeground(new Color(128,64, 0));
		this.tfAge = new JTextField();
		this.tfAge.setPreferredSize(new Dimension(200,25));
		this.tfAge.setForeground(new Color(128,64, 0));
		this.tfSpecialite = new JTextField();
		this.tfSpecialite.setPreferredSize(new Dimension(200,25));
		this.tfSpecialite.setForeground(new Color(128,64, 0));
		this.tfVille = new JTextField();
		this.tfVille.setPreferredSize(new Dimension(200,25));
		this.tfVille.setForeground(new Color(128,64, 0));
		this.bAjouter = new JButton ("Ajouter");
		this.bAjouter.addActionListener(new ControleurProf(1,this.tfNom , this.tfAge, this.tfSpecialite, this.tfVille, this.tProfs));
		this.plNom = new JPanel();
		this.ptfNom = new JPanel();
		this.plAge = new JPanel();
		this.ptfAge = new JPanel();
		this.plSpecialite = new JPanel();
		this.ptfSpecialite = new JPanel();
		this.plVille = new JPanel();
		this.ptfVille = new JPanel();
		this.pButton = new JPanel();
		this.plNom.add(this.lNom);
		this.ptfNom.add(this.tfNom);
		this.plAge.add(this.lAge);
		this.ptfAge.add(this.tfAge);
		this.plSpecialite.add(this.lSpecialite);
		this.ptfSpecialite.add(this.tfSpecialite);
		this.plVille.add(this.lVille);
		this.ptfVille.add(this.tfVille);
		this.pButton.add(this.bAjouter);
		this.pNord = new JPanel();
		this.pNord.setLayout(new GridLayout (5 , 2));
		this.pNord.add(this.plNom);
		this.pNord.add(this.ptfNom);
		this.pNord.add(this.plAge);
		this.pNord.add(this.ptfAge);
		this.pNord.add(this.plSpecialite);
		this.pNord.add(this.ptfSpecialite);
		this.pNord.add(this.plVille);
		this.pNord.add(this.ptfVille);
		this.pNord.add(new JLabel());
		this.pNord.add(this.pButton);
		this.setLayout(new BorderLayout());
		this.add(this.pNord , BorderLayout.NORTH);
		this.add(this.spProfs, BorderLayout.CENTER);
		this.repaint();
		
		
		
		
		
	}
}
