package sk.garwan.todo.services.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sk.garwan.dao.NoteDao;
import sk.garwan.dbmodel.Note;
import sk.garwan.todo.services.NotesService;

/**
 * Service implementation for calling DAO layer
 * 
 * @author Pavol Dobias
 *
 */
public class NotesServiceImpl implements NotesService {

	@Autowired
	private NoteDao noteDao;


	/**
	 * Metoda returns all todo notes
	 * 
	 * @return List<Note>
	 */
	public List<Note> findAll() {
		return noteDao.findAllNotes();
	}

	/**
	 * Method delete note
	 * 
	 * @param projectId
	 */
	public void deleteNote(Long id) {
		noteDao.delete(id);
	}
	
	/**
	 * Metoda pre vytvorenie noveho projektu
	 * 
	 * @param newProject
	 */
	public void createProject(Note newProject) {
		noteDao.create(newProject);
	}


	/**
	 * Metoda pre editaciu existujuceho projektu
	 * 
	 * @param editedProject
	 */
	public void editProject(Note editedProject) {
		noteDao.edit(editedProject);
	}

	/**
	 * @return the projectDao
	 */
	public NoteDao getNoteDao() {
		return noteDao;
	}

	/**
	 * @param noteDao the projectDao to set
	 */
	public void setNoteDao(NoteDao noteDao) {
		this.noteDao = noteDao;
	}

	
}
