package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.Test;

import dao.UserPosDAO;
import model.Userposjava;

public class TesteBancoJDBC {

	@Test
	public void initBanco() {
		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userposjava = new Userposjava();

		userposjava.setNome("Mateus");
		userposjava.setEmail("mateus@gmail.com");

		userPosDAO.salvar(userposjava);
	}

	@Test // lista todos os objetos
	public void initListar() {
		UserPosDAO dao = new UserPosDAO();
		try {
			List<Userposjava> list = dao.listar();
			for (Userposjava userposjava : list) {
				System.out.println(userposjava);
				System.out.println("-------------------------------");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Test
	public void initBuscar() {
		UserPosDAO dao = new UserPosDAO();

		try {
			Userposjava userposjava = dao.buscar(5L);
			System.out.println(userposjava);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void initAtualizar() {
		try {

			UserPosDAO dao = new UserPosDAO();

			Userposjava objetoBanco = dao.buscar(5L);

			objetoBanco.setNome("Nome mudado com o método Atualizar");
			dao.atualizar(objetoBanco);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void initDeletar() {
		try {
			
			UserPosDAO dao = new UserPosDAO();
			dao.deletar(6L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
