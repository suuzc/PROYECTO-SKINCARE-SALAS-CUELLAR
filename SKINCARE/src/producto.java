import java.io.Serializable;

public class producto implements Serializable{
	private String usuario;
    private String tipoPiel;
    private boolean tieneAcne;
    private boolean tieneSensibilidad;
    private boolean tieneRosacea;
    private int edad;
    private String nombre;
 
    public producto(String usuario, String tipoPiel, boolean tieneAcne, boolean tieneSensibilidad, boolean tieneRosacea,
			int edad) {
    	this.usuario = usuario;
		this.tipoPiel = tipoPiel;
		this.tieneAcne = tieneAcne;
		this.tieneSensibilidad = tieneSensibilidad;
		this.tieneRosacea = tieneRosacea;
		this.edad = edad;
	}

	public producto() {
		// TODO Auto-generated constructor stub
	}

	// Método de Limpieza
    public String limpiar(String tipoPiel, boolean tieneAcne, boolean tieneSensibilidad) {
        String limpieza = "";
        if (tipoPiel.equals("seca")) {
            limpieza = "Usa un limpiador hidratante como 'CeraVe Hydrating Cleanser' o 'La Roche-Posay Toleriane Hydrating Gentle Cleanser'.";
        } else if (tipoPiel.equals("grasa")) {
            limpieza = "Usa un limpiador a base de gel como 'CeraVe Foaming Cleanser' o 'La Roche-Posay Effaclar Gel Moussant'.";
        } else if (tipoPiel.equals("mixta")) {
            limpieza = "Usa un limpiador equilibrado como 'Bioderma Sebium Gel Moussant' o 'Garnier Micellar Water'.";
        } else if (tipoPiel.equals("normal")) {
            limpieza = "Usa un limpiador suave como 'CeraVe Hydrating Cleanser' o 'Neutrogena Ultra Gentle Cleanser'.";
        }
        // Si tiene acné o sensibilidad
        if (tieneAcne || tieneSensibilidad) {
            limpieza = "Se recomienda un limpiador con ácido salicílico como 'Neutrogena Oil-Free Acne Wash' o 'Paula’s Choice Clear Pore Normalizing Cleanser'.";
        }
        return limpieza;
    }
 
    // Método de Tonificación
    public String tonificar(String tipoPiel) {
        String tonico = "";
        if (tipoPiel.equals("seca")) {
            tonico = "Usa un tónico hidratante como 'Klairs Supple Preparation Unscented Toner' o 'L'Oréal HydraFresh Alcohol-Free Toner'.";
        } else if (tipoPiel.equals("grasa")) {
            tonico = "Usa un tónico astringente como 'Pixi Glow Tonic' o 'Thayers Witch Hazel Alcohol-Free Toner'.";
        } else if (tipoPiel.equals("mixta")) {
            tonico = "Usa un tónico equilibrante como 'The Ordinary Glycolic Acid Toning Solution' o 'La Roche-Posay Effaclar Clarifying Solution'.";
        } else if (tipoPiel.equals("normal")) {
            tonico = "Usa un tónico suave como 'Thayers Witch Hazel Alcohol-Free Toner'.";
        }
        return tonico;
    }
 
    // Método de Tratamientos para problemas específicos
    public String tratamientos(String tipoPiel, boolean tieneRosacea, boolean tieneAcne) {
        String tratamiento = "";
        if (tieneRosacea) {
            tratamiento = "Aplica un tratamiento calmante como 'Avene Antirougeurs Fort Relief Concentrate' o 'La Roche-Posay Rosaliac AR Intense'.";
        }
        if (tieneAcne) {
            tratamiento = "Aplica un tratamiento para el acné como 'Paula’s Choice 2% BHA Liquid Exfoliant' o 'La Roche-Posay Effaclar Duo+'.";
        }
        if (!tieneRosacea && !tieneAcne) {
            tratamiento = "No es necesario aplicar tratamientos específicos.";
        }
        return tratamiento;
    }
 
    // Método de Hidratación
    public String hidratar(String tipoPiel, int edad) {
        String hidratacion = "";
        if (tipoPiel.equals("seca")) {
            hidratacion = "Usa una crema hidratante intensa como 'CeraVe Moisturizing Cream' o 'Neutrogena Hydro Boost Gel-Cream (piel seca)'.";
        } else if (tipoPiel.equals("grasa")) {
            hidratacion = "Usa un hidratante ligero como 'Neutrogena Hydro Boost Water Gel (piel grasa)' o 'The Ordinary Natural Moisturizing Factors + HA'.";
        } else if (tipoPiel.equals("mixta")) {
            hidratacion = "Usa un hidratante equilibrado como 'Clinique Moisture Surge 72-Hour' o 'Bioderma Hydrabio Gel-Crème'.";
        } else if (tipoPiel.equals("normal")) {
            hidratacion = "Usa un hidratante ligero como 'CeraVe Moisturizing Cream' o 'Neutrogena Hydro Boost Water Gel'.";
        }
        return hidratacion;
    }
 
    // Método de Protector Solar
    public String protectorSolar(String tipoPiel, int edad) {
        String proteccionSolar = "";
        if (edad >= 13 && edad <= 19) {
            proteccionSolar = "Usa un protector solar como 'Neutrogena Hydro Boost Water Gel Lotion SPF 30' o 'EltaMD UV Clear SPF 46'.";
        } else if (edad >= 20 && edad <= 29) {
            proteccionSolar = "Usa un protector solar con antioxidantes como 'La Roche-Posay Anthelios Melt-in Milk SPF 60' o 'Neutrogena Hydro Boost Water Gel Lotion SPF 30'.";
        } else if (edad >= 30 && edad <= 39) {
            proteccionSolar = "Usa un protector solar con propiedades antiedad como 'La Roche-Posay Anthelios Melt-in Milk SPF 60'.";
        } else if (edad >= 40 && edad <= 49) {
            proteccionSolar = "Usa un protector solar con antioxidantes como 'Neutrogena Hydro Boost Water Gel SPF 30'.";
        } else if (edad >= 50) {
            proteccionSolar = "Usa un protector solar de amplio espectro SPF 50 como 'La Roche-Posay Anthelios Melt-in Milk SPF 60'.";
        }
        return proteccionSolar;
    }
 
    // Getters y Setters
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


