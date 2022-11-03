package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/recoveryroom")
public class RecoveryRoomController {
    private final RecoveryRoomService recoveryRoomService;
    
    private static final String VIEWS_ROOM_CREATE = "recoveryroom/createOrUpdateRecoveryRoomForm";
    private static final String VIEWS_ROOM_LISTS = "rooms/RoomList";
    
    @ModelAttribute("RecoveryRoomTypes")
    public List<RecoveryRoomType> populateRoomTypes() {
        return this.recoveryRoomService.getAllRecoveryRoomTypes();
    }
    
    @Autowired
    public RecoveryRoomController(RecoveryRoomService recoveryRoomService) {
    	this.recoveryRoomService=recoveryRoomService;
    }
    
    @GetMapping
    public ModelAndView showRoomList() {
        ModelAndView mav = new ModelAndView(VIEWS_ROOM_LISTS);
        mav.addObject("rooms", recoveryRoomService.getAll());
        return mav;
    }
    
    @GetMapping("/create")
    public ModelAndView createRoom() {
    	ModelAndView model = new ModelAndView(VIEWS_ROOM_CREATE);
    	model.addObject("recoveryRoom", new RecoveryRoom());
    	return model;
    }
    
    @PostMapping("/create")
    public ModelAndView creationForm(@Valid RecoveryRoom recoveryRoom, BindingResult result) {
    	ModelAndView model;
    	if(result.hasErrors()) {
    		model = new ModelAndView(VIEWS_ROOM_CREATE);
    		model.addObject("recoveryRoom", recoveryRoom);
    		model.addObject("types", recoveryRoomService.getAllRecoveryRoomTypes());
    	} else {
    		//this.recoveryRoomService.save(recoveryRoom);
    		model=new ModelAndView("welcome");
    	}
    	return model;
    }
}
