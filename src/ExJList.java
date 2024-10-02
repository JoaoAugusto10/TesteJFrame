import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
import javax.swing.event.*;

public class ExJList extends JFrame implements ListSelectionListener, ActionListener {  
    JLabel l1;  
    JTextField t1;    
    JButton bquant, bindice, bclear;
    JList<String> lista; // Criando objeto Lista    
    DefaultListModel<String> listModel; 

    public static void main(String args[]) {
        new ExJList();
    }

    public ExJList() {
        setSize(400, 300);
        setTitle("Usando o JList");        
        l1 = criarRotulo("Escolha um Esporte"); 
        t1 = criarTexto();        
        
        String esportes[] = {"Futebo","Basquete","HandBall","Volei","Tenis"};
        listModel = criarListaModelo(esportes); // container com os itens        
        lista = criarLista(listModel); // adicionando o listModel na Lista.        

        // Criando painel do tipo barra de rolagem
        JScrollPane painel = new JScrollPane(lista); 
        setLayout(new GridLayout(6, 1)); // Criando um Layout do tipo Grid 
        add(painel);        
        
        bquant = criarBotao("Quantidade de itens");        
        bindice = criarBotao("Índice selecionado");        
        bclear = criarBotao("Remove item");    

        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JList<String> criarLista(DefaultListModel<String> listModel) {
        JList<String> lista = new JList<>(listModel); // adicionando o listModel na Lista.
        lista.setForeground(Color.RED);
        lista.setFont(new Font("Courier New", Font.BOLD, 18));
        lista.addListSelectionListener(this); // Adicionando o evento na lista
        return lista;
    }

    private JLabel criarRotulo(String texto) {
        JLabel jl = new JLabel(texto);
        jl.setFont(new Font("Courier New", Font.BOLD, 18));
        add(jl);    
        return jl;
    }

    private JTextField criarTexto() {
        JTextField txt = new JTextField();
        txt.setForeground(Color.BLUE);
        txt.setFont(new Font("Courier New", Font.BOLD, 18));    
        txt.addActionListener(this);
        add(txt);    
        return txt;
    }

    private JButton criarBotao(String texto) {
        JButton botao = new JButton(texto);
        botao.addActionListener(this); 
        botao.setFont(new Font("Courier New", Font.BOLD, 18));
        botao.setForeground(Color.BLUE);
        add(botao);
        return botao;
    }

    private DefaultListModel<String> criarListaModelo(String[] frutas) {
        DefaultListModel<String> lista = new DefaultListModel<>();        
        for (String fruta : frutas) {
            lista.addElement(fruta);
        }        
        return lista;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == t1) {
            listModel.addElement(t1.getText());  // adiciona itens à lista
            t1.setText(""); // Limpa a caixa de texto
        } 
        if (e.getSource() == bquant)
            t1.setText("Quantidade: " + listModel.getSize());
        if (e.getSource() == bindice)
            t1.setText("Índice selecionado: " + lista.getSelectedIndex());
        if (e.getSource() == bclear) {
            int resp = JOptionPane.showConfirmDialog(null,
                "Confirma a exclusão do item: " + lista.getSelectedValue());
            if (resp == JOptionPane.YES_OPTION) {
                int index = lista.getSelectedIndex();
                l1.setText("Removido: " + lista.getSelectedValue());
                listModel.remove(index); 
            }    
        }        
    }

    public void valueChanged(ListSelectionEvent e) {
        l1.setText("Índice Selecionado: " + lista.getSelectedValue()); 
    }
}

