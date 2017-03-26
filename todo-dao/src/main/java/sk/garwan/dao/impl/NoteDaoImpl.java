package sk.garwan.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import sk.garwan.dao.NoteDao;
import sk.garwan.dbmodel.Note;

/**
 * Implementation of {@link NoteDaoImpl}.
 * 
 * @author Pavol Dobias
 */
@Repository
public class NoteDaoImpl extends HibernateDaoSupport implements NoteDao {

	List<Note> notes;

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	private static NoteDaoImpl instance;

	private NoteDaoImpl() {
	}

	// static block initialization for exception handling
	static {
		try {
			instance = new NoteDaoImpl();

			EmbeddedDatabase db = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
					.addScript("db/create-db.sql").addScript("db/insert-data.sql").build();

			getInstance().setNamedParameterJdbcTemplate(new NamedParameterJdbcTemplate(db));

		} catch (Exception e) {
			throw new RuntimeException("Exception occured in creating singleton instance");
		}
	}

	public static NoteDaoImpl getInstance() {
		return instance;
	}

	/**
	 * return list of all Todo Notes 
	 * 
	 * @param
	 * @return List<Note>
	 * 
	 */
	public List<Note> findAllNotes() {

		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "SELECT * FROM todo";

		List<Note> result = getInstance().namedParameterJdbcTemplate.query(sql, params, new UserMapper());
		for (Note project : result) {
			System.out.println("id:" + project.getId() + ", name:" + project.getName() + ", shortcut:" + project.getAbbreviation() + ", description:" + project.getDescription());
		}

		setNotes(result);

		return getNotes();
		// return
		// this.getHibernateTemplate().findByNamedQuery("project.findAllProjects");
	}

	/**
	 * method for delete Note from list
	 * 
	 * @param id
	 * @return void
	 * 
	 */
	public void delete(Long id) {
		for (Note project : getNotes()) {
			if (project.getId().equals(id)) {
				String sql = "DELETE FROM todo WHERE ID='" + id + "'";

				List<Note> todos = sqlUpdate(sql);

				setNotes(todos);
			}
		}

		// this.getHibernateTemplate().delete(project);
	}

	/**
	 * method for update/delete
	 * 
	 * @param params
	 * @param sql
	 * @return
	 */
	private List<Note> sqlUpdate(String sql) {
		List<Note> todos = new ArrayList<>();
		Map<String, Object> params = new HashMap<String, Object>();

		int result = getInstance().namedParameterJdbcTemplate.update(sql, params);

		if (result == 1) {
			sql = "SELECT * FROM todo";
			todos = getInstance().namedParameterJdbcTemplate.query(sql, params, new UserMapper());

		}

		return todos;
	}

	/**
	 * Metoda pre editaciu existujuceho projektu
	 * 
	 * @param editedProject
	 * @return void
	 * 
	 */
	public void edit(Note editedProject) {
		for (Note project : getNotes()) {
			if (project.getId().equals(editedProject.getId())) {

				String sql = "DELETE FROM todo WHERE ID='" + project.getId() + "';";
				sqlUpdate(sql);

				sql = "INSERT INTO todo VALUES ('" + editedProject.getId() + "','" + editedProject.getName() + "','"
						+ editedProject.getAbbreviation() + "','" + editedProject.getDescription() + "' );";

				List<Note> todos = sqlUpdate(sql);

				setNotes(todos);
			}
		}

	}

	/**
	 * metohod for create note
	 * 
	 * @param newNote
	 * @return void
	 * 
	 */
	public void create(Note newNote) {
		// TODO generate unique ID

		newNote.setId(Long.valueOf(getNotes().size()));

		String sql = "INSERT INTO todo VALUES ('" + newNote.getId() + "','" + newNote.getName() + "','" + newNote.getAbbreviation() + "','" + newNote.getDescription() + "' );";

		List<Note> todos = sqlUpdate(sql);
		setNotes(todos);

		// this.getHibernateTemplate().delete(project);
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	private static final class UserMapper implements RowMapper<Note> {

		public Note mapRow(ResultSet rs, int rowNum) throws SQLException {
			Note note = new Note();
			note.setId(rs.getLong("id"));
			note.setName(rs.getString("name"));
			note.setAbbreviation(rs.getString("abbreviation"));
			note.setDescription(rs.getString("description"));
			return note;
		}
	}

}
