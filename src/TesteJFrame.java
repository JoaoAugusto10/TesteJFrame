import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class TesteJFrame extends JFrame implements ActionListener{
        JLabel nome,rg,cpf,logradouro,endereco;
	JTextField txtNome,txtRg,txtCpf,txtLogradouro,txtEndereco;
	JButton btnGravar, btnSair;
	
	public TesteJFrame(){
		setTitle("Primeira Janela Swing");//Titulo da janela
		setSize(700,350);		//tamanho da janela		
		setLayout(null);// anula o layout padrao
		int alt = 40;
		getContentPane().setBackground(new Color(242,198,238));
		nome = criarJLabel("Nome", 10 , 110, 270, alt);
		txtNome = criarTexto(70 , 110, 590, alt);
                rg = criarJLabel("RG", 360 , 50, 270, alt);
                txtRg = criarTexto(390 , 50, 270, alt);
                cpf= criarJLabel("CPF", 10 , 50, 270, alt);
                txtCpf=criarTexto(70 , 50, 270, alt);
                logradouro = criarJLabel("Logradouro", 10 , 170, 270, alt);
                txtLogradouro = criarTexto(130 , 170, 70, alt);
                endereco = criarJLabel("Endereço", 220 , 170, 270, alt);
                txtEndereco = criarTexto(320 , 170, 340, alt);
		int rodape = getHeight()-80;
		int distEsq = getWidth()/2;
		int larg = 150;
                Color c = JColorChooser.showDialog(null,  
				"Escolha uma cor", Color.lightGray);
		getContentPane().setBackground(c);
		btnGravar 	= criarBotao("Gravar", 'G',150, rodape,larg, alt );
		btnSair 	= criarBotao("Sair", 'S',330, rodape , larg , alt );
		centralizar();
		setVisible(true);//Exibindo a janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private JButton criarBotao(String string, char c, int distEsq, int rodape, int larg, int altura) {
		JButton b1 = new JButton(string);
		b1.setBounds(distEsq, 240, larg, altura); //D Esq, D Topo, larg, alt
		b1.setBackground(new Color(0,0,170));
		b1.setForeground(Color.YELLOW);
		b1.setFont(new Font("Helvetica", Font.BOLD, 18));
		b1.setToolTipText("Botão " + string);
		b1.setHorizontalAlignment(0);
		b1.setVerticalAlignment(0);
//		b1.setEnabled(false); //Botão desabilitado.
		b1.setMnemonic(c);  //Tecla de atalho
		b1.addActionListener((ActionListener) this);
		add(b1);
		return b1;
	}
	private JTextField criarTexto(int desq, int dtopo, int larg, int alt) {
		JTextField jt = new JTextField();
		jt.setBounds(desq, dtopo, larg, alt);
		jt.setForeground(Color.blue);
//		jt.setText("Insira texto aqui");
//		jt.setHorizontalAlignment(4);
		add(jt);
		return jt;
	}
	public JLabel criarJLabel(String string, int desq, int dtopo, int larg, int alt){
		JLabel jl = new JLabel(string);
//		jl.setText("JLabel inserido");
		jl.setLocation(desq, dtopo);	//dist esq e topo
		jl.setSize(larg, alt);	//larg e alt do rótulo
//		jl.setOpaque(true);		//fundo opcao
//		jl.setBackground(new Color(255,255,255)); //cor fundo
		jl.setForeground(new Color(110,182,145));	//cor fonte
		jl.setFont(new Font("Courier new", Font.BOLD, 18));//nome, estilo e tamanho da fonte
//		jl.setToolTipText("JLabel Exemplo"); //dica de texto
//		jl.setHorizontalAlignment(SwingConstants.LEFT);//alinhamento horizontal
//		jl.setVerticalAlignment(SwingConstants.TOP);//alinhamento vertical
		add(jl);
		return jl;
	}
	
	public static void main(String [] args){
		new TesteJFrame();
	}	
	public void centralizar(){
		Dimension screen = //obtém a altura e largura da resolução vídeo
				Toolkit.getDefaultToolkit().getScreenSize();		
		Dimension janela = getSize();//obtém a altura e largura da minha janela
		if (janela.height > screen.height)
			setSize(janela.width, screen.height);
		if (janela.width > screen.width)
			setSize(screen.width, janela.height);
		setLocation((screen.width - janela.width)/2, 
				(screen.height - janela.height)/2);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnSair)
			System.exit(0);		
	}
        
}