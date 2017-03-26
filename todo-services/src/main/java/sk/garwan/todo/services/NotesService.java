package sk.garwan.todo.services;

import java.util.List;

import sk.garwan.dbmodel.Note;


/**
 * interface with CRUD methods for notes
 * 
 * @author Pavol Dobias
 *
 */
public interface NotesService {

	/**
	 * Metoda returns all todo notes
	 * 
	 * @return List<Note>
	 */
	List<Note> findAll();
	
	/**
	 * Metoda for delete note
	 * 
	 * @param id
	 */
	void deleteNote(Long id);
	
	
	/**
	 * Metoda pre vytvorenie noveho projektu
	 * 
	 * @param newProject
	 */
	void createProject(Note newProject);
	
	/**
	 * Metoda pre editaciu existujuceho projektu
	 * 
	 * @param editedProject
	 */
	void editProject(Note editedProject);

}
