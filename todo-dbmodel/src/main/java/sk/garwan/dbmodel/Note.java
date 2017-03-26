package sk.garwan.dbmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

//import org.hibernate.annotations.GenericGenerator;

/**
 * domenovy objekt pre Projekt
 * 
 * @author Pavol Dobias
 * 
 */
@Entity
//@Table(name = "todo", schema = "garwan")
//@org.hibernate.annotations.Table(appliesTo = "todo")
//@NamedQueries( { @NamedQuery(name = "todo.findAllNotes", query = "from todo") })
public class Note {

	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "todo.id")
//	@GenericGenerator(name = "todo.id", strategy = "identity")
	private Long id;

	@Column(name = "name", length = 8192)
	@Lob
	private String name;
	
	@Column(name = "description", length = 8192)
	@Lob
	private String description;
	
	@Column(name = "abbreviation", length = 8192)
	@Lob
	private String abbreviation;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
