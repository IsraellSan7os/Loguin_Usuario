package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.JDBC;
import java.awt.SystemColor;
import java.awt.Color;

public class LoginView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textLoguin;
    private JPasswordField textSenha;
    private JDBC dao = new JDBC(); // Instanciando a classe JDBC
    private Connection con;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginView frame = new LoginView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public LoginView() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                status();
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 363);
        setResizable(false);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setToolTipText("Digite seu loguin");
        contentPane.setBackground(new Color(192, 192, 192));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblBemVindo = new JLabel("Tela de loguin");
        lblBemVindo.setFont(new Font("Verdana", Font.PLAIN, 30));
        lblBemVindo.setBounds(122, 10, 247, 40);
        contentPane.add(lblBemVindo);

        JLabel lblLoguin = new JLabel("Loguin:");
        lblLoguin.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblLoguin.setBounds(31, 96, 67, 25);
        contentPane.add(lblLoguin);

        textLoguin = new JTextField();
        textLoguin.setBounds(129, 91, 240, 30);
        contentPane.add(textLoguin);
        textLoguin.setColumns(10);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblSenha.setBounds(31, 190, 67, 25);
        contentPane.add(lblSenha);

        textSenha = new JPasswordField();
        textSenha.setToolTipText("");
        textSenha.setBounds(129, 185, 240, 30);
        contentPane.add(textSenha);
        textSenha.setColumns(10);

        JButton btnCadastra = new JButton("Entra");
        btnCadastra.setFont(new Font("Tahoma", Font.PLAIN, 28));
        btnCadastra.setBounds(158, 262, 169, 40);
        contentPane.add(btnCadastra);

        // Configuração do evento do botão "Cadastrar"
        btnCadastra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String login = textLoguin.getText();
                String senha = new String(textSenha.getPassword());

                if (adicionarUsuario(login, senha)) {
                    JOptionPane.showMessageDialog(LoginView.this, "Usuário cadastrado com sucesso!", "Sucesso",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(LoginView.this, "Erro ao cadastrar o usuário.", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // Método que envia as informações do usuário para o banco de dados
    public boolean adicionarUsuario(String email, String senha) {
        String sql = "INSERT INTO usuario (email, senha) VALUES (?, ?)";

        try (Connection con = dao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, senha);

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar usuário: " + e.getMessage());
            return false;
        }
    }

    // Método para verificar status da conexão
    public void status() {
        try {
            con = dao.conectar();
            if (con == null) {
                System.out.println("Erro de conexão");
            } else {
                System.out.println("Banco de dados conectado");
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception erro) {
            System.out.println(erro);
        }
    }
}
