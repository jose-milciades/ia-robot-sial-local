package com.edi.ia.robotsial.modelo;



public class ExpedienteVO {

	private int idExpediente;
	private int idCargaDemanda;
	private String numeroCredito;
	private String urlExpediente;
	private String nombreArchivo;
	private String etapa;
	private String fecha;
	private String estatus;
	private String tipoDeProcesoDemanda;
	private String numExpediente;
	private String estadoJuzgado;
	private String municipioJuzgado;
	private String tipoDeJuicio;
	private String juzgado;
	private String montoAvaluoPesos;
	private String fechaAvaluo;
	private String estadoNotaria;
	private String municipioNotaria;
	private String nombreDeNotario;
	private String numNotaria;
	private String fechaExpiraSentencia;
	private String fechaSentencia;
	private String unidadDeValuacionOPerito;
	private String fechaVencimientoAvaluo;
	private String superficieConstruccion;
	private String entidadUbicacionInmuebleGarantia;
	private String municipioUbicacionInmuebleGarantia;
	private String coloniaInmuebleGarantia;
	private String calleYNumeroInmuebleGarantia;
	private String cpInmuebleGarantia;
	private String fechaAprobacionRemate;
	private String fechaRemateFirme;
	private String cantidadPosturaLegalPesos;
	private String fechaSentenciaInterlocutoriaIncidenteLiquidacion;
	private String saldoTotalReconocidoAFavorInfonavitALaFechaPesos;
	private String fechaAdmisionDemanda;
	private String numeroPoderPleitosYCobranzas;
	private String nombreApoderadoInfonavit;
	
	private String montoAdjudicacion;
	private String numAlmoneda;
	private String fechaEmplazamiento;
	private String montoTotalSentencia;
	private String monedaSentencia;
	private String tipoCambioSentencia;
	
	
	private String domicilioLocalizado;
	private String estadoVivienda;
	private String habitada;
	private String ventanas;
	private String muebles;
	private String medidor_de_luz;
	private String medidor_de_agua;
	private String autos;
	
	private String personaContactada;
	private String motivoNoPago;
	private String quiereMantenerHogar;
	private String capacidadDePago;
	
	private String comentario;
	private String latitud;
	private String longitud;

	private String cargarDictamenAdicional;

	public String getCargarDictamenAdicional() {
		return cargarDictamenAdicional;
	}

	public void setCargarDictamenAdicional(final String cargarDictamenAdicional) {
		this.cargarDictamenAdicional = cargarDictamenAdicional;
	}

	public String getPersonaContactada() {
		return personaContactada;
	}

	public void setPersonaContactada(String personaContactada) {
		this.personaContactada = personaContactada;
	}

	public String getMotivoNoPago() {
		return motivoNoPago;
	}

	public void setMotivoNoPago(String motivoNoPago) {
		this.motivoNoPago = motivoNoPago;
	}

	public String getQuiereMantenerHogar() {
		return quiereMantenerHogar;
	}

	public void setQuiereMantenerHogar(String quiereMantenerHogar) {
		this.quiereMantenerHogar = quiereMantenerHogar;
	}

	public String getCapacidadDePago() {
		return capacidadDePago;
	}

	public void setCapacidadDePago(String capacidadDePago) {
		this.capacidadDePago = capacidadDePago;
	}

	public String getMontoAdjudicacion() {
		return montoAdjudicacion;
	}

	public void setMontoAdjudicacion(String montoAdjudicacion) {
		this.montoAdjudicacion = montoAdjudicacion;
	}

	public String getNumAlmoneda() {
		return numAlmoneda;
	}

	public void setNumAlmoneda(String numAlmoneda) {
		this.numAlmoneda = numAlmoneda;
	}

	public String getFechaEmplazamiento() {
		return fechaEmplazamiento;
	}

	public void setFechaEmplazamiento(String fechaEmplazamiento) {
		this.fechaEmplazamiento = fechaEmplazamiento;
	}

	public String getMontoTotalSentencia() {
		return montoTotalSentencia;
	}

	public void setMontoTotalSentencia(String montoTotalSentencia) {
		this.montoTotalSentencia = montoTotalSentencia;
	}

	public String getMonedaSentencia() {
		return monedaSentencia;
	}

	public void setMonedaSentencia(String monedaSentencia) {
		this.monedaSentencia = monedaSentencia;
	}

	public String getTipoCambioSentencia() {
		return tipoCambioSentencia;
	}

	public void setTipoCambioSentencia(String tipoCambioSentencia) {
		this.tipoCambioSentencia = tipoCambioSentencia;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getDomicilioLocalizado() {
		return domicilioLocalizado;
	}

	public void setDomicilioLocalizado(String domicilioLocalizado) {
		this.domicilioLocalizado = domicilioLocalizado;
	}

	public String getEstadoVivienda() {
		return estadoVivienda;
	}

	public void setEstadoVivienda(String estadoVivienda) {
		this.estadoVivienda = estadoVivienda;
	}


	public String getHabitada() {
		return habitada;
	}

	public void setHabitada(String habitada) {
		this.habitada = habitada;
	}

	public String getVentanas() {
		return ventanas;
	}

	public void setVentanas(String ventanas) {
		this.ventanas = ventanas;
	}

	public String getMuebles() {
		return muebles;
	}

	public void setMuebles(String muebles) {
		this.muebles = muebles;
	}

	public String getMedidor_de_luz() {
		return medidor_de_luz;
	}

	public void setMedidor_de_luz(String medidor_de_luz) {
		this.medidor_de_luz = medidor_de_luz;
	}

	public String getMedidor_de_agua() {
		return medidor_de_agua;
	}

	public void setMedidor_de_agua(String medidor_de_agua) {
		this.medidor_de_agua = medidor_de_agua;
	}

	public String getAutos() {
		return autos;
	}

	public void setAutos(String autos) {
		this.autos = autos;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getIdExpediente() {
		return idExpediente;
	}

	public void setIdExpediente(int idExpediente) {
		this.idExpediente = idExpediente;
	}

	public int getIdCargaDemanda() {
		return idCargaDemanda;
	}

	public void setIdCargaDemanda(int idCargaDemanda) {
		this.idCargaDemanda = idCargaDemanda;
	}
	
	public String getEtapa() {
		return etapa;
	}

	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getTipoDeProcesoDemanda() {
		return tipoDeProcesoDemanda;
	}

	public void setTipoDeProcesoDemanda(String tipoDeProcesoDemanda) {
		this.tipoDeProcesoDemanda = tipoDeProcesoDemanda;
	}

	public String getNumExpediente() {
		return numExpediente;
	}

	public void setNumExpediente(String numExpediente) {
		this.numExpediente = numExpediente;
	}

	public String getEstadoJuzgado() {
		return estadoJuzgado;
	}

	public void setEstadoJuzgado(String estadoJuzgado) {
		this.estadoJuzgado = estadoJuzgado;
	}

	public String getMunicipioJuzgado() {
		return municipioJuzgado;
	}

	public void setMunicipioJuzgado(String municipioJuzgado) {
		this.municipioJuzgado = municipioJuzgado;
	}

	public String getTipoDeJuicio() {
		return tipoDeJuicio;
	}

	public void setTipoDeJuicio(String tipoDeJuicio) {
		this.tipoDeJuicio = tipoDeJuicio;
	}

	public String getJuzgado() {
		return juzgado;
	}

	public void setJuzgado(String juzgado) {
		this.juzgado = juzgado;
	}

	public String getMontoAvaluoPesos() {
		return montoAvaluoPesos;
	}

	public void setMontoAvaluoPesos(String montoAvaluoPesos) {
		this.montoAvaluoPesos = montoAvaluoPesos;
	}

	public String getFechaAvaluo() {
		return fechaAvaluo;
	}

	public void setFechaAvaluo(String fechaAvaluo) {
		this.fechaAvaluo = fechaAvaluo;
	}

	public String getEstadoNotaria() {
		return estadoNotaria;
	}

	public void setEstadoNotaria(String estadoNotaria) {
		this.estadoNotaria = estadoNotaria;
	}

	public String getMunicipioNotaria() {
		return municipioNotaria;
	}

	public void setMunicipioNotaria(String municipioNotaria) {
		this.municipioNotaria = municipioNotaria;
	}

	public String getNombreDeNotario() {
		return nombreDeNotario;
	}

	public void setNombreDeNotario(String nombreDeNotario) {
		this.nombreDeNotario = nombreDeNotario;
	}

	public String getNumNotaria() {
		return numNotaria;
	}

	public void setNumNotaria(String numNotaria) {
		this.numNotaria = numNotaria;
	}

	public String getFechaExpiraSentencia() {
		return fechaExpiraSentencia;
	}

	public void setFechaExpiraSentencia(String fechaExpiraSentencia) {
		this.fechaExpiraSentencia = fechaExpiraSentencia;
	}

	public String getFechaSentencia() {
		return fechaSentencia;
	}

	public void setFechaSentencia(String fechaSentencia) {
		this.fechaSentencia = fechaSentencia;
	}

	public String getUnidadDeValuacionOPerito() {
		return unidadDeValuacionOPerito;
	}

	public void setUnidadDeValuacionOPerito(String unidadDeValuacionOPerito) {
		this.unidadDeValuacionOPerito = unidadDeValuacionOPerito;
	}

	public String getFechaVencimientoAvaluo() {
		return fechaVencimientoAvaluo;
	}

	public void setFechaVencimientoAvaluo(String fechaVencimientoAvaluo) {
		this.fechaVencimientoAvaluo = fechaVencimientoAvaluo;
	}

	public String getSuperficieConstruccion() {
		return superficieConstruccion;
	}

	public void setSuperficieConstruccion(String superficieConstruccion) {
		this.superficieConstruccion = superficieConstruccion;
	}

	public String getEntidadUbicacionInmuebleGarantia() {
		return entidadUbicacionInmuebleGarantia;
	}

	public void setEntidadUbicacionInmuebleGarantia(String entidadUbicacionInmuebleGarantia) {
		this.entidadUbicacionInmuebleGarantia = entidadUbicacionInmuebleGarantia;
	}

	public String getMunicipioUbicacionInmuebleGarantia() {
		return municipioUbicacionInmuebleGarantia;
	}

	public void setMunicipioUbicacionInmuebleGarantia(String municipioUbicacionInmuebleGarantia) {
		this.municipioUbicacionInmuebleGarantia = municipioUbicacionInmuebleGarantia;
	}

	public String getColoniaInmuebleGarantia() {
		return coloniaInmuebleGarantia;
	}

	public void setColoniaInmuebleGarantia(String coloniaInmuebleGarantia) {
		this.coloniaInmuebleGarantia = coloniaInmuebleGarantia;
	}

	public String getCalleYNumeroInmuebleGarantia() {
		return calleYNumeroInmuebleGarantia;
	}

	public void setCalleYNumeroInmuebleGarantia(String calleYNumeroInmuebleGarantia) {
		this.calleYNumeroInmuebleGarantia = calleYNumeroInmuebleGarantia;
	}

	public String getCpInmuebleGarantia() {
		return cpInmuebleGarantia;
	}

	public void setCpInmuebleGarantia(String cpInmuebleGarantia) {
		this.cpInmuebleGarantia = cpInmuebleGarantia;
	}

	public String getFechaAprobacionRemate() {
		return fechaAprobacionRemate;
	}

	public void setFechaAprobacionRemate(String fechaAprobacionRemate) {
		this.fechaAprobacionRemate = fechaAprobacionRemate;
	}

	public String getFechaRemateFirme() {
		return fechaRemateFirme;
	}

	public void setFechaRemateFirme(String fechaRemateFirme) {
		this.fechaRemateFirme = fechaRemateFirme;
	}

	public String getCantidadPosturaLegalPesos() {
		return cantidadPosturaLegalPesos;
	}

	public void setCantidadPosturaLegalPesos(String cantidadPosturaLegalPesos) {
		this.cantidadPosturaLegalPesos = cantidadPosturaLegalPesos;
	}

	public String getFechaSentenciaInterlocutoriaIncidenteLiquidacion() {
		return fechaSentenciaInterlocutoriaIncidenteLiquidacion;
	}

	public void setFechaSentenciaInterlocutoriaIncidenteLiquidacion(
			String fechaSentenciaInterlocutoriaIncidenteLiquidacion) {
		this.fechaSentenciaInterlocutoriaIncidenteLiquidacion = fechaSentenciaInterlocutoriaIncidenteLiquidacion;
	}

	public String getSaldoTotalReconocidoAFavorInfonavitALaFechaPesos() {
		return saldoTotalReconocidoAFavorInfonavitALaFechaPesos;
	}

	public void setSaldoTotalReconocidoAFavorInfonavitALaFechaPesos(
			String saldoTotalReconocidoAFavorInfonavitALaFechaPesos) {
		this.saldoTotalReconocidoAFavorInfonavitALaFechaPesos = saldoTotalReconocidoAFavorInfonavitALaFechaPesos;
	}

	public String getFechaAdmisionDemanda() {
		return fechaAdmisionDemanda;
	}

	public void setFechaAdmisionDemanda(String fechaAdmisionDemanda) {
		this.fechaAdmisionDemanda = fechaAdmisionDemanda;
	}

	public String getNumeroPoderPleitosYCobranzas() {
		return numeroPoderPleitosYCobranzas;
	}

	public void setNumeroPoderPleitosYCobranzas(String numeroPoderPleitosYCobranzas) {
		this.numeroPoderPleitosYCobranzas = numeroPoderPleitosYCobranzas;
	}

	public String getNombreApoderadoInfonavit() {
		return nombreApoderadoInfonavit;
	}

	public void setNombreApoderadoInfonavit(String nombreApoderadoInfonavit) {
		this.nombreApoderadoInfonavit = nombreApoderadoInfonavit;
	}


	public String getUrlExpediente() {
		return urlExpediente;
	}

	public void setUrlExpediente(String urlExpediente) {
		this.urlExpediente = urlExpediente;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getNumeroCredito() {
		return numeroCredito;
	}

	public void setNumeroCredito(String numeroCredito) {
		this.numeroCredito = numeroCredito;
	}
}
