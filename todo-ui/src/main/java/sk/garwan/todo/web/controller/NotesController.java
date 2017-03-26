package sk.garwan.todo.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sk.garwan.dao.NoteDao;
import sk.garwan.dbmodel.Note;
import sk.garwan.todo.services.NotesService;
import sk.garwan.todo.web.model.TodoForm;


/**
 * controller for managing/displaying list of notes
 * 
 * @author Pavol Dobias
 * 
 */
@Controller
@RequestMapping(value = "/notes")
public class NotesController {

	List<Note> notes;

	@Autowired
	NoteDao noteDao;

	@Autowired
	NotesService notesService;

	public NotesService getNotesService() {
		return notesService;
	}

	public void setNotesService(NotesService notesService) {
		this.notesService = notesService;
	}

	private NotesController() {
	}
	
	/**
	 * Display list of notes
	 * 
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param notesForm
	 * @return
	 */
	@RequestMapping(value = { "/list" })
	public ModelAndView list(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse,
			@ModelAttribute("notesForm") TodoForm notesForm) {

		ModelAndView modelAndView = new ModelAndView("notes.list");
		modelAndView.addObject("notesForm", notesForm);

		setNotes(getNotesService().findAll());

		modelAndView.addObject("notes", getNotes());
		modelAndView.addObject("id", notesForm.getId());
		return modelAndView;
	}

	/**
	 * Edit note & save
	 * 
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param notesForm
	 * @return
	 */
	@RequestMapping(value = { "/edit" })
	public String edit(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse,
			@ModelAttribute("notesForm") TodoForm notesForm) {

		Note editedNote = new Note();
		editedNote.setAbbreviation(notesForm.getAbbreviation());
		editedNote.setDescription(notesForm.getDescription());
		editedNote.setName(notesForm.getName());
		editedNote.setId(notesForm.getId());
		getNotesService().editProject(editedNote);
		
		return "redirect:/notes/list";
	}
	
	/**
	 * Create new note
	 * 
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param notesForm
	 * @return
	 */
	@RequestMapping(value = { "/create" })
	public String create(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse,
			@ModelAttribute("notesForm") TodoForm notesForm) {

		Note newProject = new Note();
		newProject.setAbbreviation(notesForm.getAbbreviation());
		newProject.setDescription(notesForm.getDescription());
		newProject.setName(notesForm.getName());
		getNotesService().createProject(newProject);
		
		return "redirect:/notes/list";
	}

	/**
	 * Delete note
	 * 
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param notesForm
	 * @return
	 */
	@RequestMapping(value = { "/delete" })
	public String delete(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse,
			@ModelAttribute("notesForm") TodoForm notesForm) {

		Long id = Long.valueOf(httpServletRequest
				.getParameter("id"));
		getNotesService().deleteNote(id);

		return "redirect:/notes/list";
	}

	/**
	 * @return the notes
	 */
	public List<Note> getNotes() {
		return notes;
	}

	/**
	 * @param notes to set
	 */
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

}
