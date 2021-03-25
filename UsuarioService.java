package services;

import java.util.ArrayList;
import java.util.List;
//import java.util.Random;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import models.Usuario;

@Named
@ApplicationScoped
public class UsuarioService {

    List<Usuario> Usuarios;

 // INICIALIZA DATATABLE SIN DATOS
    @PostConstruct
    public void init() {
        Usuarios = new ArrayList<>();
        //Usuarios.add(new Usuario("123456","Jefferson","Orrala","0321456987","22"));
    }

    // OBTIENE LISTA DE LOS USUARIOS
    public List<Usuario> getUsuarios() {
        return new ArrayList<>(Usuarios);
    }

    /*public List<Usuario> getUsuarios(int size) {

        if (size > Usuarios.size()) {
            Random rand = new Random();

            List<Usuario> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(Usuarios.size());
                randomList.add(Usuarios.get(randomIndex));
            }

            return randomList;
        }

        else {
            return new ArrayList<>(Usuarios.subList(0, size));
        }

    }

	public List<Usuario> getClonedUsuarios(int size) {
		List<Usuario> results = new ArrayList<>();
		List<Usuario> originals = getUsuarios(size);
		for (Usuario original : originals) {
			results.add(original.clone());
		}
		return results;
	}*/
}