package com.github.hortykut.hortykut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.hortykut.hortykut.model.Produto;
import com.github.hortykut.hortykut.repository.ProdutoRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")	
public class ProdutoController {
	
    @Autowired
    private ProdutoRepository produtoRepository ;
    
    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Produto> buscarProdutoPorId(@PathVariable Long id) {
      return produtoRepository.findById(id);
    }
    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }
   @PutMapping
    public Produto atualizarProduto(@RequestBody Produto produtoAtualizado) {
        Optional<Produto> produtoExistente = produtoRepository.findById(produtoAtualizado.getId());

        if (produtoExistente.isPresent()) {
            Produto produto = produtoExistente.get();
            produto.setProduto(produtoAtualizado.getProduto());
            produto.setResponsavel(produtoAtualizado.getResponsavel());
            produto.setValor(produtoAtualizado.getValor());
         produto.setDescricao(produtoAtualizado.getDescricao());
        produto.setFoto(produtoAtualizado.getFoto());
            return produtoRepository.save(produto);
        } else {
            throw new IllegalArgumentException("ID do usuário inválido: " + produtoAtualizado.getId());
        }
    }
    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }
}
