package sk.garwan.todo.web.model;

/**
 * Model for list of notes (ProjectsController)
 * 
 * @author Pavol Dobias
 * 
 */
public class TodoForm {
	
	/**
	 * id projektu
	 */
	private Long id;
	
	/**
	 * nazov projektu
	 */
	private String name;
	
	/**
	 * skratka projektu
	 */
	private String abbreviation;
	
	/**
	 * todo description
	 */
	private String description;
	
	/**
	 * constructor
	 */
	public TodoForm() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the abbreviation
	 */
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * @param abbreviation the abbreviation to set
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
}
