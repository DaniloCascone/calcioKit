package model;

import java.math.BigDecimal;
import java.sql.Date;

public class Pagamento {
	private String bic;
	private String cvc;
	private Date dataPagamento;
	private Date dataScadenza;
	private String emailPayPal;
	private String iban;
	private int idOrdine;
	private int idPagamento;
	private BigDecimal importoPagamento;
	private String numeroCarta;
	private String passwordPayPal;
	private String tipoPagamento;
	private String titolareConto;

	public Pagamento() {
	}

	public Pagamento(int idPagamento, Date dataPagamento, BigDecimal importoPagamento, String tipoPagamento,
			String numeroCarta, Date dataScadenza, String cvc, String titolareConto, String iban, String bic,
			String emailPayPal, String passwordPayPal, int idOrdine) {
		this.idPagamento = idPagamento;
		this.dataPagamento = dataPagamento;
		this.importoPagamento = importoPagamento;
		this.tipoPagamento = tipoPagamento;
		this.numeroCarta = numeroCarta;
		this.dataScadenza = dataScadenza;
		this.cvc = cvc;
		this.titolareConto = titolareConto;
		this.iban = iban;
		this.bic = bic;
		this.emailPayPal = emailPayPal;
		this.passwordPayPal = passwordPayPal;
		this.idOrdine = idOrdine;
	}

	// Metodi getter e setter

	public String getBic() {
		return bic;
	}

	public String getCvc() {
		return cvc;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public String getEmailPayPal() {
		return emailPayPal;
	}

	public String getIban() {
		return iban;
	}

	public int getIdOrdine() {
		return idOrdine;
	}

	public int getIdPagamento() {
		return idPagamento;
	}

	public BigDecimal getImportoPagamento() {
		return importoPagamento;
	}

	public String getNumeroCarta() {
		return numeroCarta;
	}

	public String getPasswordPayPal() {
		return passwordPayPal;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public String getTitolareConto() {
		return titolareConto;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public void setEmailPayPal(String emailPayPal) {
		this.emailPayPal = emailPayPal;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}

	public void setIdPagamento(int idPagamento) {
		this.idPagamento = idPagamento;
	}

	public void setImportoPagamento(BigDecimal importoPagamento) {
		this.importoPagamento = importoPagamento;
	}

	public void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}

	public void setPasswordPayPal(String passwordPayPal) {
		this.passwordPayPal = passwordPayPal;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public void setTitolareConto(String titolareConto) {
		this.titolareConto = titolareConto;
	}
}
