package ru.cinimex.csb.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TRANSFORMRESULT database table.
 * 
 */
@Entity
@Table(name = "TRANSFORMRESULT",schema="ACSBUS")
@NamedQuery(name="Transformresult.findAll", query="SELECT t FROM Transformresult t")
public class Transformresult implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sid;

	@Lob
	private String payload;

	public Transformresult() {
	}

	public int getSid() {
		return this.sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getPayload() {
		return this.payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

}