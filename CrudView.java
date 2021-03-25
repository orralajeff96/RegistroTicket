package utils;

//import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;
//import java.util.UUID;
import services.UsuarioService;

import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

//import javax.inject.Named;
import org.primefaces.PrimeFaces;
import models.Usuario;

@ManagedBean(name="crudView")
@ViewScoped
public class CrudView implements Serializable {

    private static final long serialVersionUID = 1L;

	private List<Usuario> Usuarios;

	private String selectedOption;
	private Usuario selectedUsuario;

    private List<Usuario> selectedUsuarios;

    @Inject
    private UsuarioService UsuarioService;

    // INICIALIZA DATATABLE SIN REGISTROS  
    @PostConstruct
    public void init() {
        this.Usuarios = this.UsuarioService.getUsuarios();
        //this.Usuarios = this.UsuarioService.getClonedUsuarios(100);
    }

    public List<Usuario> getUsuarios() {
        return Usuarios;
    }

    public Usuario getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(Usuario selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }

    public List<Usuario> getSelectedUsuarios() {
        return selectedUsuarios;
    }

    public void setSelectedUsuarios(List<Usuario> selectedUsuarios) {
        this.selectedUsuarios = selectedUsuarios;
    }

    public void openNew() {
    	System.out.println("Instanciando Usuario");
        this.selectedUsuario = new Usuario();
    }

    // METODO QUE GUARDA INFORMACION DEL CLIENTE
    public void saveUsuario() {
    	System.out.println(this.selectedUsuario.getdueDateTicket());
    	// SI EL ID ES NULO CREA USUARIO, CASO CONTRARIO SE ACTUALIZA
    	if (this.selectedUsuario.getstatus() == null) {
        	this.selectedUsuario.setstatus("Open");
        	//this.selectedUsuario.setdueDateTicket(LocalDateTime.now().toString()); // ENVIA FECHA DE REGISTRO
            this.Usuarios.add(this.selectedUsuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario Agregado"));
        }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario Actualizado"));
        }

        // OCULTA CUADRO DE DIALOGO DETALLE USUARIO
    	PrimeFaces.current().executeScript("PF('manageUsuarioDialog').hide()");
    	// ACTUALIZA DATABLE CON LA INFORMACION REGISTRADA/ACTUALIZADA
        PrimeFaces.current().ajax().update("form:messages", "form:dt-usuarios");
    }

    // METODO QUE ELIMINA USUARIO
    public void deleteUsuario() {
        this.Usuarios.remove(this.selectedUsuario);
        this.selectedUsuario = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario Eliminado"));
        // ACTUALIZA DATABLE CON LA INFORMACION ELIMINADA
        PrimeFaces.current().ajax().update("form:messages", "form:dt-usuarios");
    }

    // METODO QUE RETORNA MENSAJE DE LOS USUARIOS MULTIPLES SELECCIONADOS
    public String getDeleteButtonMessage() {
        if (hasSelectedUsuarios()) {
            int size = this.selectedUsuarios.size();
            return size > 1 ? size + " Usuarios seleccionados" : "1 Usuario seleccionado";
        }

        return "Eliminar";
    }

    // METODO QUE OBTIENE LOS USUARIOS SELECCIONADOS
    public boolean hasSelectedUsuarios() {
        return this.selectedUsuarios != null && !this.selectedUsuarios.isEmpty();
    }

    // METODO QUE ELIMINA LOS USUARIOS MULTIPLES QUE FUERON SELECCIONADOS
    public void deleteSelectedUsuarios() {
        this.Usuarios.removeAll(this.selectedUsuarios);
        this.selectedUsuarios = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuarios Eliminados"));
        // ACTUALIZA DATATABLE CON LA INFORMACION DE TODOS LOS USUARIOS ELIMINADO
        PrimeFaces.current().ajax().update("form:messages", "form:dt-usuarios");
        PrimeFaces.current().executeScript("PF('dtUsuarios').clearFilters()");
    }
    
    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }

}