import java.io.Serializable;

public class rutina implements Serializable{
	private String usuario;
	private String tipoPiel;
	private boolean tieneAcne;
	private boolean tieneSensibilidad;
	private boolean tieneRosacea;
	private int edad;
	
	
	public rutina(String usuario, String tipoPiel, boolean tieneAcne, boolean tieneSensibilidad, boolean tieneRosacea,
			int edad) {
		this.usuario = usuario;
		this.tipoPiel = tipoPiel;
		this.tieneAcne = tieneAcne;
		this.tieneSensibilidad = tieneSensibilidad;
		this.tieneRosacea = tieneRosacea;
		this.edad = edad;
	}

	public rutina() {
		// TODO Auto-generated constructor stub
	}

	//LIMPIEZA
	//no tiene acne, tipo de piel
	public String limpiar(String tipoPiel, boolean tieneAcne, boolean tieneSensibilidad) {
		String limpieza = "";
        if (tipoPiel.equals("seca")) {
        	limpieza = "Usa un limpiador hidratante y suave para piel seca.";
        } else if (tipoPiel.equals("grasa")) {
        	limpieza ="Usa un limpiador a base de gel que controle la grasa.";
        } else if (tipoPiel.equals("mixta")) {
        	limpieza ="Usa un limpiador equilibrado que no reseque ni aumente la grasa.";
        } else if (tipoPiel.equals("normal")) {
        	limpieza ="Usa un limpiador suave que mantenga el balance natural de la piel.";
        }
        //tiene acne y/o rosacea
        if (tieneAcne || tieneSensibilidad) {
        	limpieza ="Se recomienda un limpiador con ingredientes como ácido salicílico para controlar el acné.";
        }
        return limpieza;
    }
	
	//TONICO FACIAL
	
	public String tonificar(String tipoPiel) {
		String tonico = "";
        if (tipoPiel.equals("seca")) {
        	tonico ="Usa un tónico hidratante que no contenga alcohol.";
        } else if (tipoPiel.equals("grasa")) {
        	tonico ="Usa un tónico astringente para controlar la producción de grasa.";
        } else if (tipoPiel.equals("mixta")) {
        	tonico ="Usa un tónico que equilibre las zonas secas y grasas.";
        } else if (tipoPiel.equals("normal")) {
        	tonico ="Usa un tónico suave para mantener el equilibrio.";
        }
        return tonico;
    }
	
	// TRATAMIENTO PROBLEMAS ESPECIFICOS
    public String tratamientos(String tipoPiel, boolean tieneRosacea, boolean tieneAcne) {
    	String tratamiento = "";
        if (tieneRosacea) {
        	tratamiento ="Aplica un tratamiento calmante para la rosácea con ingredientes como aloe vera o niacinamida.";
        }
        if (tieneAcne) {
        	tratamiento ="Aplica un tratamiento para el acné con ingredientes como peróxido de benzoilo o ácido salicílico.";
        }
        if (!tieneRosacea && !tieneAcne) {
        	tratamiento ="No es necesario aplicar tratamientos específicos.";
        }
        return tratamiento;
    }

 // HIDRATACION FACIAL
    public String hidratar(String tipoPiel, int edad) {
        String hidratacion = "";
        if (tipoPiel.equals("seca")) {
        	hidratacion ="Usa una crema hidratante intensa.";
        } else if (tipoPiel.equals("grasa")) {
        	hidratacion ="Usa un hidratante ligero o en gel que controle la grasa.";
        } else if (tipoPiel.equals("mixta")) {
        	hidratacion ="Usa un hidratante equilibrado que hidrate sin dejar la piel grasosa.";
        } else if (tipoPiel.equals("normal")) {
        	hidratacion ="Usa un hidratante ligero que mantenga el equilibrio natural de la piel.";
        }
        return hidratacion;
    }
    
    public String protectorSolar(String tipoPiel, int edad) {
        String proteccionSolar = "";
        if (edad >= 13 && edad <= 19) {
        	proteccionSolar ="Usa un protector solar con un SPF de al menos 30. Si tienes acné, que sea no comedogénico.";
        } else if (edad >= 20 && edad <= 29) {
        	proteccionSolar ="Usa un protector solar con SPF de 30 o más. Prefiere uno con antioxidantes para prevenir daño.";
        } else if (edad >= 30 && edad <= 39) {
        	proteccionSolar ="Sigue usando SPF de al menos 30. Considera protectores solares con ingredientes antiedad.";
        } else if (edad >= 40 && edad <= 49) {
        	proteccionSolar ="Usa un protector solar con SPF de al menos 30. Los ingredientes antioxidantes pueden ayudar a proteger del envejecimiento.";
        } else if (edad >= 50) {
        	proteccionSolar ="Usa un protector solar con SPF de 50 o más. Prefiere uno que ofrezca protección contra el daño solar y el envejecimiento.";
        }
        return proteccionSolar;
    }

	public String getTipoPiel() {
		return tipoPiel;
	}

	public void setTipoPiel(String tipoPiel) {
		this.tipoPiel = tipoPiel;
	}

	public boolean isTieneAcne() {
		return tieneAcne;
	}

	public void setTieneAcne(boolean tieneAcne) {
		this.tieneAcne = tieneAcne;
	}

	public boolean isTieneSensibilidad() {
		return tieneSensibilidad;
	}

	public void setTieneSensibilidad(boolean tieneSensibilidad) {
		this.tieneSensibilidad = tieneSensibilidad;
	}

	public boolean isTieneRosacea() {
		return tieneRosacea;
	}

	public void setTieneRosacea(boolean tieneRosacea) {
		this.tieneRosacea = tieneRosacea;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
    
    
}

