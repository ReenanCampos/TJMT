package com.projeto.repository;

import com.projeto.config.Conexao;
import com.projeto.model.Visitante;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VisitanteRepository {
    public int salvar(Visitante v) {
        String sql = "INSERT INTO visitante (nome, motivo, horario_entrada, aprovado) VALUES (?, ?, ?, false)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, v.getNome());
            stmt.setString(2, v.getMotivo());
            stmt.setTimestamp(3, Timestamp.valueOf(v.getHorarioEntrada()));
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao salvar visitante: " + e.getMessage());
        }

        return 0;
    }

    public Visitante buscarPorId(int id) {
        String sql = "SELECT * FROM visitante WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Visitante v = new Visitante();
                v.setId(rs.getInt("id"));
                v.setNome(rs.getString("nome"));
                v.setMotivo(rs.getString("motivo"));
                v.setHorarioEntrada(rs.getTimestamp("horario_entrada").toLocalDateTime());
                Timestamp saida = rs.getTimestamp("horario_saida");
                if (saida != null) {
                    v.setHorarioSaida(saida.toLocalDateTime());
                }
                v.setAprovado(rs.getBoolean("aprovado"));
                return v;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar visitante: " + e.getMessage());
        }

        return null;
    }

    public void aprovarEntrada(int id) {
        String sql = "UPDATE visitante SET aprovado = true WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao aprovar entrada: " + e.getMessage());
        }
    }

    public void registrarSaida(int id, LocalDateTime horarioSaida) {
        String sql = "UPDATE visitante SET horario_saida = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setTimestamp(1, Timestamp.valueOf(horarioSaida));
            stmt.setInt(2, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao registrar saída: " + e.getMessage());
        }
    }

    // Listar visitantes presentes
    public List<Visitante> listarPresentes() {
        List<Visitante> lista = new ArrayList<>();
        String sql = "SELECT * FROM visitante WHERE horario_saida IS NULL AND aprovado = true";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Visitante v = new Visitante();
                v.setId(rs.getInt("id"));
                v.setNome(rs.getString("nome"));
                v.setMotivo(rs.getString("motivo"));
                v.setHorarioEntrada(rs.getTimestamp("horario_entrada").toLocalDateTime());
                v.setAprovado(rs.getBoolean("aprovado"));
                lista.add(v);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar visitantes: " + e.getMessage());
        }

        return lista;
    }
}
