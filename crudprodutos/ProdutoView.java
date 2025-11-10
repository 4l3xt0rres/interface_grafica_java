package crudprodutos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class ProdutoView extends JFrame {
    private ProdutoController controller = new ProdutoController();

    private JTextField nomeField = new JTextField(10);
    private JTextField precoField = new JTextField(10);
    private JTextField quantidadeField = new JTextField(10);
    private JTable tabela;
    private DefaultTableModel modelo;
     
    public ProdutoView() {
        JPanel form = new JPanel();
        setTitle("Gerenciador de Produtos");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setLayout(new BorderLayout());
        
        form.add(new JLabel("Nome:"));
        form.add(nomeField);
        form.add(new JLabel("Preço:"));
        form.add(precoField);
        form.add(new JLabel("Qtd:"));
        form.add(quantidadeField);

        JButton addBtn = new JButton("Adicionar");
        JButton updateBtn = new JButton("Atualizar");
        JButton removeBtn = new JButton("Remover");

        form.add(addBtn);
        form.add(updateBtn);
        form.add(removeBtn);
        add(form, BorderLayout.NORTH);

        modelo = new DefaultTableModel(new Object[]{"ID", "Nome", "Preço", "Qtd"}, 0);
        tabela = new JTable(modelo);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        
        addBtn.addActionListener(e -> {
            try {
                String nome = nomeField.getText();
                double preco = Double.parseDouble(precoField.getText());
                int qtd = Integer.parseInt(quantidadeField.getText());
                controller.adicionar(new Produto(0, nome, qtd, preco));
                limparCampos();
                listar();
                JOptionPane.showMessageDialog(this, "Produto adicionado!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro nos dados!");
            }
        });

        updateBtn.addActionListener(e -> {
            int linha = tabela.getSelectedRow();
            if (linha >= 0) {
                int id = (int) modelo.getValueAt(linha, 0);
                String nome = nomeField.getText();
                double preco = Double.parseDouble(precoField.getText());
                int qtd = Integer.parseInt(quantidadeField.getText());
                if (controller.atualizar(id, new Produto(id, nome, qtd, preco))) {
                    listar();
                    limparCampos();
                    JOptionPane.showMessageDialog(this, "Produto atualizado!");
                }
            } else JOptionPane.showMessageDialog(this, "Selecione um produto!");
        });

        removeBtn.addActionListener(e -> {
            int linha = tabela.getSelectedRow();
            if (linha >= 0) {
                int id = (int) modelo.getValueAt(linha, 0);
                controller.remover(id);
                listar();
                JOptionPane.showMessageDialog(this, "Produto removido!");
            } else JOptionPane.showMessageDialog(this, "Selecione um produto!");
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
            int linha = tabela.getSelectedRow();
            if (linha >= 0) {
                nomeField.setText(modelo.getValueAt(linha, 1).toString());
                precoField.setText(modelo.getValueAt(linha, 2).toString());
                quantidadeField.setText(modelo.getValueAt(linha, 3).toString());
        }
    }
});

    }
    private void listar() {
        modelo.setRowCount(0);
        for (Produto p : controller.listar()) {
            modelo.addRow(new Object[]{p.getId(), p.getNome(), p.getPreco(), p.getQuantidade()});
        }
    }
    

    private void limparCampos() {
        nomeField.setText("");
        precoField.setText("");
        quantidadeField.setText("");
    }

    public static void main(String[] args) {
        new ProdutoView().setVisible(true);
    }
}
