package models;

import java.io.Serializable;
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

    private String status;

    private String descriptionTicket;

    private String priorityTicket;

    private String caseOwner;
    
    private String dealsTicket;
    
    private String dueDateTicket;
    
    public Usuario() {}

    public Usuario(String status, String descriptionTicket, String priorityTicket, String caseOwner, String dealsTicket, String dueDateTicket) {
        this.status = status;
        this.descriptionTicket = descriptionTicket;
        this.priorityTicket = priorityTicket;
        this.caseOwner = caseOwner;
        this.dealsTicket = dealsTicket;
        this.dueDateTicket = dueDateTicket;
    }

    public Usuario clone() {
    	return new Usuario(getstatus(), getdescriptionTicket(), getpriorityTicket(), getcaseOwner(), getdealsTicket(),getdueDateTicket());
    }

    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }

    public String getdescriptionTicket() {
		return descriptionTicket;
	}
    
    public void setdescriptionTicket(String descriptionTicket) {
		this.descriptionTicket = descriptionTicket;
	}
    
    public String getpriorityTicket() {
		return priorityTicket;
	}
    
    public void setpriorityTicket(String priorityTicket) {
		this.priorityTicket = priorityTicket;
	}
    
    public String getcaseOwner() {
		return caseOwner;
	}
    
    
    public void setcaseOwner(String caseOwner) {
		this.caseOwner = caseOwner;
	}
    
    public String getdealsTicket() {
		return dealsTicket;
	}
    
    public void setdealsTicket(String dealsTicket) {
		this.dealsTicket = dealsTicket;
	}
    
    public String getdueDateTicket() {
    	return dueDateTicket;
	}

	public void setdueDateTicket(String dueDateTicket) {
		this.dueDateTicket = dueDateTicket;
	}

	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        if (status == null) {
            return other.status == null;
        } else return status.equals(other.status);
    }	
}