package fr.istic.tpSpring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.istic.tpSpring.dao.ProfessionnelDao;
import fr.istic.tpSpring.domain.Professionnel;

import java.util.List;

@Controller
public class ProfessionnelController {

    @RequestMapping("/{proId}")
    @ResponseBody
    public Professionnel getProById(@PathVariable("proId") Long proId)  {
        return (Professionnel) professionnelDao.getReferenceById(proId);
    }

    @RequestMapping("/")
    @ResponseBody
    public List<Professionnel> getPros()  {
        return (List<Professionnel>) professionnelDao.findAll();
    }

    @RequestMapping("/create")
    @ResponseBody
    public String addPro(Professionnel pro) {
        // add professionnel
        try{
            professionnelDao.save(pro);
        }catch (Exception e){
            return "Erreur lors de la création du Professionnel.";
        }
        return "Professionnel créer avec succès.";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String deletePro(Professionnel pro) {
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