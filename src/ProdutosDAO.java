import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
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

    public boolean venderProduto(int id) {
        String sql = "UPDATE produtos SET status = ? WHERE id = ? AND (status IS NULL OR status <> ?)";
        try (Connection conn = new conectaDAO().connectDB();
                PreparedStatement prep = conn.prepareStatement(sql)) {
            prep.setString(1, "Vendido");
            prep.setInt(2, id);
            prep.setString(3, "Vendido");
            return prep.executeUpdate() == 1;
        } catch (SQLException erro) {
            throw new IllegalStateException("Não foi possível vender o produto.", erro);
        }
    }

    public ArrayList<ProdutosDTO> listarProdutos() {
        ArrayList<ProdutosDTO> produtos = new ArrayList<>();
        String sql = "SELECT id, nome, valor, status FROM produtos ORDER BY id";
        try (Connection conn = new conectaDAO().connectDB();
                PreparedStatement prep = conn.prepareStatement(sql);
                ResultSet resultado = prep.executeQuery()) {
            while (resultado.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(resultado.getInt("id"));
                produto.setNome(resultado.getString("nome"));
                produto.setValor(resultado.getInt("valor"));
                produto.setStatus(resultado.getString("status"));
                produtos.add(produto);
            }
            return produtos;
        } catch (SQLException erro) {
            throw new IllegalStateException("Nao foi possivel listar os produtos.", erro);
        }
    }
}
