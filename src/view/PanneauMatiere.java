package view;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import Controler.ControleurMatiere;
import Model.Matiere;
import Model.Prof;

public class PanneauMatiere extends JPanel{
	private JTextField tfIntitule, tfVh;
	private JComboBox<String> cbIdp;
	private JLabel lIntitule, lVh, lIdp;
	private JPanel pNord, plIntitule, ptfIntitule, plVh, ptfVh, plIdp,pcbIdp,pButton;
	private JButton bAjouter;
	private JTable tMatieres;
	private JScrollPane spMatieres;
	public PanneauMatiere(){
		Matiere m = new Matiere();
		ArrayList<Matiere> liste = m.read();
		String[] entete = {"Intitule","VH","Idp"};
		String[][] donnees = new String[liste.size()][entete.length];
		for(int i = 0; i< liste.size(); i++){
			donnees[i][0] = liste.get(i).getIntitule();
			donnees[i][1] = "" + liste.get(i).getVh();
			donnees[i][2] = "" + liste.get(i).getIdp();
		}
		TableauModele tm = new TableauModele(donnees, entete);
		this.tMatieres = new JTable(tm);
		this.spMatieres = new JScrollPane(this.tMatieres);
		this.lIntitule = new JLabel("Intitulé :  ");
		this.lIntitule.setFont(new Font("Time New Roman", Font.PLAIN, 25));
		this.lVh = new JLabel("VH : ");
		this.lVh.setFont(new Font("Time New Roman", Font.PLAIN, 25));
		this.lIdp = new JLabel("Idp : ");
		this.lIdp.setFont(new Font("Time New Roman", Font.PLAIN, 25));
		this.tfIntitule = new JTextField();
		this.tfIntitule.setPreferredSize(new Dimension(200, 25));
		this.tfIntitule.setForeground(new Color(255, 128, 0));
		this.tfVh = new JTextField();
		this.tfVh.setPreferredSize(new Dimension(200, 25));
		this.tfVh.setForeground(new Color(255, 128, 0));
		this.cbIdp = new JComboBox<String>();
		this.cbIdp.setPreferredSize(new Dimension(200, 25));
		this.cbIdp.setForeground(new Color(255, 128, 0));
		Prof p = new Prof();
		ArrayList<Prof> listeProfs = p.read();
		for(int i=0; i< listeProfs.size(); i++){
			this.cbIdp.addItem(listeProfs.get(i).getIdp() + " - " + listeProfs.get(i).getNom());
		}
		this.bAjouter = new JButton("Ajouter");
		this.bAjouter.addActionListener(new ControleurMatiere(1, this.tfIntitule, this.tfVh, this.cbIdp, this.tMatieres));
		this.plIntitule = new JPanel();
		this.ptfIntitule = new JPanel();
		this.plVh = new JPanel();
		this.ptfVh = new JPanel();
		this.plIdp = new JPanel();
		this.pcbIdp = new JPanel();
		this.pButton = new JPanel();
		this.plIntitule.add(this.lIntitule);
		this.ptfIntitule.add(this.tfIntitule);
		this.plVh.add(this.lVh);
		this.ptfVh.add(this.tfVh);
		this.plIdp.add(this.lIdp);
		this.pcbIdp.add(this.cbIdp);
		this.pButton.add(this.bAjouter);
		this.pNord = new JPanel();
		this.pNord.setLayout(new GridLayout(4, 2));
		this.pNord.add(this.plIntitule);
		this.pNord.add(this.ptfIntitule);
		this.pNord.add(this.plVh);
		this.pNord.add(this.ptfVh);
		this.pNord.add(this.plIdp);
		this.pNord.add(this.pcbIdp);
		this.pNord.add(new JLabel());
		this.pNord.add(this.pButton);
		this.setLayout(new BorderLayout());
		this.add(this.pNord, BorderLayout.NORTH);
		this.add(this.spMatieres, BorderLayout.CENTER);
		this.repaint();
	}
}