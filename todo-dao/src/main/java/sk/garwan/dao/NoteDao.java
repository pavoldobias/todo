package sk.garwan.dao;


import java.util.List;

import sk.garwan.dbmodel.Note;


/**
 * DAO of {@link Note}.
 * 
 * @author Pavol Dobias
 * 
 */
public interface NoteDao {
	
	/**
	 * return all notes
	 * @param 
	 * @return List<Note>
	 * 
	 */
	public List<Note> findAllNotes();

	
	/**
	 * delete note from DB
	 * @param id
	 * @return void
	 * 
	 */
	public void delete(Long id);
	
	
	/**
	 * create new Note
	 * @param newNote
	 * @return void
	 * 
	 */
	public void create(Note newNote);
	
	
	/**
	 * edit existing note
	 * @param editedNote
	 * @return void
	 * 
	 */
	public void edit(Note editedNote);
	
}
