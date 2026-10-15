import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class vendasVIEW extends JFrame {
    private final JTable listaVendas;
    private final JButton btnVoltar;

    public vendasVIEW() {
        setTitle("Vendas");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel(new BorderLayout(12, 16));
        painel.setBorder(new EmptyBorder(20, 20, 20, 20));
        JLabel titulo = new JLabel("Produtos vendidos");
        titulo.setFont(titulo.getFont().deriveFont(Font.BOLD, 18f));
        painel.add(titulo, BorderLayout.NORTH);

        DefaultTableModel modelo = new DefaultTableModel(new String[]{"ID", "Nome", "Valor", "Status"}, 0) {
            @Override
            public boolean isCellEditable(int linha, int coluna) {
                return false;
            }
        };
        listaVendas = new JTable(modelo);
        painel.add(new JScrollPane(listaVendas), BorderLayout.CENTER);

        btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(evento -> dispose());
        JPanel rodape = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        rodape.add(btnVoltar);
        painel.add(rodape, BorderLayout.SOUTH);

        setContentPane(painel);
        setSize(600, 360);
        setLocationRelativeTo(null);
        carregarVendas(modelo);
    }

    private void carregarVendas(DefaultTableModel modelo) {
        try {
            for (ProdutosDTO produto : new ProdutosDAO().listarProdutosVendidos()) {
                modelo.addRow(new Object[]{produto.getId(), produto.getNome(), produto.getValor(), produto.getStatus()});
            }
        } catch (IllegalStateException erro) {
            JOptionPane.showMessageDialog(this, "Não foi possível consultar as vendas.");
        }
    }
}
