package fr.istic.tpSpring.rest;

import fr.istic.tpSpring.dto.ProfessionnelDTO;
import fr.istic.tpSpring.dto.mapper.MapperGlobal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import fr.istic.tpSpring.dao.ProfessionnelDao;
import fr.istic.tpSpring.domain.Professionnel;

import java.util.List;

@Controller
@RequestMapping("/pro")
public class ProfessionnelController {

    @GetMapping("/{proId}")
    @ResponseBody
    public ProfessionnelDTO getProById(@PathVariable("proId") Long proId)  {
        Professionnel pro = professionnelDao.getReferenceById(proId);
        ProfessionnelDTO proDTO = MapperGlobal.INSTANCE.professionnelToProfessionnelDTO(pro);
        return proDTO;
    }

    @GetMapping("/")
    @ResponseBody
    public List<ProfessionnelDTO> getPros()  {
        List<Professionnel> pros = professionnelDao.findAll();
        List<ProfessionnelDTO> prosDTO = MapperGlobal.INSTANCE.professionnelToProfessionnelDTO(pros);
        return prosDTO;
    }

    @PostMapping("/create")
    @ResponseBody
    public String addPro(@RequestBody Professionnel pro) {
        // add professionnel
        System.out.println(pro);
        try{
            professionnelDao.save(pro);
        }catch (Exception e){
            return "Erreur lors de la création du Professionnel.";
        }
        return "Professionnel créer avec succès.";
    }

    @PostMapping("/delete")
    @ResponseBody
    public String deletePro(@RequestBody Professionnel pro) {
        // add professionnel
        try{
            professionnelDao.delete(pro);
        }catch (Exception e){
            return "Erreur lors de la suppression du Professionnel.";
        }
        return "Professionnel supprimer avec succès.";
    }

    @Autowired
    private ProfessionnelDao professionnelDao;
}