package mains;

import javax.swing.*;
import javax.swing.SpringLayout;
import java.awt.Container;

public class ExemplosSpringLayout extends JFrame {
    // Houni SpringLayout - hetha layout mta3 swing yemchi b resort (kima resort mta3 soussa)
    private SpringLayout springLayout;

    public ExemplosSpringLayout() {
        super("Exemple SpringLayout"); // Ism mta3 la fenêtre
        initComponents(); // Na3mlou appel l méthode d'initialisation
    }

    /* Houni méthode mta3 initialisation les composants */
    private void initComponents() {
        // Na3mlou instance mta3 SpringLayout (resort layout)
        springLayout = new SpringLayout();
        getContentPane().setLayout(springLayout); // N7otou layout l content pane

        // Nzidou les composants f silsila (kima formulaire)
        Container lastContainer = addRow(null, "Civilité", 
            new JComboBox<>(new String[] {"Madame", "Monsieur"})); // Combobox mta3 titre
        lastContainer = addRow(lastContainer, "Nom", new JTextField()); // Champ texte mta3 ism
        lastContainer = addRow(lastContainer, "Prénom", new JTextField()); // Champ texte mta3 prenom
        lastContainer = addRow(lastContainer, "Adresse", new JTextField(), 20); // Champ texte mta3 adresse
        
        // Nzidou les boutons louta (OK w Annuler)
        addButtons(new JButton("OK"), new JButton("Annuler"));
        
        setSize(300, 250); // Taille mta3 la fenêtre (300 largeur, 250 hauteur)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ki n9elbou la fenêtre, l'app tfaskh
    }

    /**
     * Méthode mta3 ajout ligne f formulaire
     * @param topContainer Conteneur précédent (ken fama)
     * @param titre Libellé mta3 ligne
     * @param component Composant (JTextField, JComboBox, etc.)
     * @return Le composant ajouté (bech nesta3mlou f positionnement)
     */
    private Container addRow(Container topContainer, String titre, JComponent component) {
        // Na3mlou libellé
        JLabel label = new JLabel(titre);
        label.setLabelFor(component); // Na3mlou liaison libellé-composant
        this.add(label); // Nzidou libellé l fenêtre
        
        /* Configuration positionnement libellé */
        // Libellé ykoun 20px mel gouch (WEST)
        springLayout.putConstraint(SpringLayout.WEST, label, 20, SpringLayout.WEST, getContentPane());
        
        if (topContainer == null) {
            // Ken fama conteneur précédent, libellé ykoun 20px mel fou9
            springLayout.putConstraint(SpringLayout.NORTH, label, 20, SpringLayout.NORTH, getContentPane());
        } else {
            // Ken fama conteneur précédent, libellé ykoun 10px louta mel composant précédent
            springLayout.putConstraint(SpringLayout.NORTH, label, 10, SpringLayout.SOUTH, topContainer);
        }
        
        /* Configuration positionnement composant */
        // Composant ykoun 15px mel droite libellé
        springLayout.putConstraint(SpringLayout.WEST, component, 15, SpringLayout.EAST, label);
        // Composant ykoun 20px mel ymin (EAST)
        springLayout.putConstraint(SpringLayout.EAST, component, -20, SpringLayout.EAST, getContentPane());
        
        if (topContainer == null) {
            // Première ligne - composant ykoun 20px mel fou9
            springLayout.putConstraint(SpringLayout.NORTH, component, 20, SpringLayout.NORTH, getContentPane());
        } else {
            // Lignes suivantes - composant ykoun 10px louta mel composant précédent
            springLayout.putConstraint(SpringLayout.NORTH, component, 10, SpringLayout.SOUTH, topContainer);
        }
        
        this.add(component); // Nzidou composant l fenêtre
        return component; // Nraj3ou composant bech nesta3mlou f lignes jeyin
    }

    /**
     * Méthode mta3 ajout boutons f louta
     * @param buttons Les boutons l nheb nzidhom (OK, Annuler)
     */
    private void addButtons(JButton... buttons) {
        JPanel panel = new JPanel(); // Na3mlou panel mta3 les boutons
        for (JButton button : buttons) {
            panel.add(button); // Nzidou kol bouton l panel
        }
        this.add(panel); // Nzidou panel l fenêtre
        
        /* Positionnement panel louta */
        // Panel ykoun 20px mel louta (SOUTH)
        springLayout.putConstraint(SpringLayout.SOUTH, panel, -20, SpringLayout.SOUTH, getContentPane());
        // Panel ykoun 20px mel ymin (EAST)
        springLayout.putConstraint(SpringLayout.EAST, panel, -20, SpringLayout.EAST, getContentPane());
    }

    /* Méthode principale */
    public static void main(String[] args) {
        // Nesta3mlou invokeLater bech n3amilou interface f thread mta3 swing
        SwingUtilities.invokeLater(() -> {
            ExemplosSpringLayout frame = new ExemplosSpringLayout(); // Na3mlou instance
            frame.setVisible(true); // Nharjou la fenêtre
        });
    }
}