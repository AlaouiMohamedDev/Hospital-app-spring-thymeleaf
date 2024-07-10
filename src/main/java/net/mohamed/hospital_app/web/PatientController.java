package net.mohamed.hospital_app.web;

import net.mohamed.hospital_app.entities.Patient;
import net.mohamed.hospital_app.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name="page",defaultValue = "0") int page,
                        @RequestParam(name="size",defaultValue = "5") int size,
                        @RequestParam(name="keyword",defaultValue = "") String kw){
        Page<Patient> pagePatients = patientRepository.findByFirstNameContainsIgnoreCaseOrLastNameContainsIgnoreCase(kw,kw,PageRequest.of(page,size));
        model.addAttribute("listPatients",pagePatients.getContent());
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",kw);
        return "patients";
    }

    @GetMapping("/deletePatient")
    public String delete(@RequestParam(name="id") Long idPatient,String page,String keyword){
        patientRepository.deleteById(idPatient);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }
}
