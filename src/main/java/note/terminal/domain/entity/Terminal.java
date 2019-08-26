package note.terminal.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "bank", "name" }) })
public class Terminal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String bank;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String username;

	@Column(nullable = false, length = 100)
	private String password;

	@Column(nullable = false)
	private String addressLogin;

	@Column(nullable = false)
	private String addressSupply;

	@Column(nullable = false)
	private Integer updateStockInMinute;

	@Column(nullable = false)
	private Integer updateStockQuantity;

	public void setUpdateStockInMinute(Integer updateStockInMinute) {
		this.updateStockInMinute = updateStockInMinute;
	}

	public Integer getUpdateStockInMinute() {
		return updateStockInMinute;
	}

	public void setUpdateStockQuantity(Integer updateStockQuantity) {
		this.updateStockQuantity = updateStockQuantity;
	}

	public Integer getUpdateStockQuantity() {
		return updateStockQuantity;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setAddressLogin(String addressLogin) {
		this.addressLogin = addressLogin;
	}

	public String getAddressSupply() {
		return addressSupply;
	}

	public void setAddressSupply(String addressSupply) {
		this.addressSupply = addressSupply;
	}

	public String getAddressLogin() {
		return addressLogin;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBank() {
		return bank;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
