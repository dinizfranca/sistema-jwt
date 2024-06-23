package com.mfd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfd.dtos.UsuarioDto;
import com.mfd.models.UsuarioModel;
import com.mfd.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<UsuarioDto> listarTodos() {
		List<UsuarioModel> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(UsuarioDto::new).toList();
	}

	public UsuarioDto buscaId(Long id) {
		return new UsuarioDto(usuarioRepository.findById(id).get());
	}

	public void inserir(UsuarioDto usuarioDto) {
		UsuarioModel usuarioModel = new UsuarioModel(usuarioDto);
		usuarioRepository.save(usuarioModel);
	}

	public UsuarioDto alterar(UsuarioDto usuarioDto) {
		UsuarioModel usuarioModel = new UsuarioModel(usuarioDto);
		return new UsuarioDto(usuarioRepository.save(usuarioModel));
	}

	public void excluir(Long id) {
		UsuarioModel usuarioModel = usuarioRepository.findById(id).get();
		usuarioRepository.delete(usuarioModel);
	}

}
