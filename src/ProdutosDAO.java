import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutosDAO {
    public boolean cadastrarProduto(ProdutosDTO produto) {
        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";
        try (Connection conn = new conectaDAO().connectDB();
                PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());
            return prep.executeUpdate() == 1;
        } catch (SQLException erro) {
            throw new IllegalStateException("Nao foi possivel cadastrar o produto.", erro);
        }
    }

    public ArrayList<ProdutosDTO> listarProdutos() {
        return new ArrayList<>();
    }
}
