package fr.istic.tpSpring.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.istic.tpSpring.dao.RDVDao;
import fr.istic.tpSpring.domain.RDV;

import java.util.List;

@Controller
public class RDVController {

    @Autowired
    private RDVDao rdvDao;

    @RequestMapping("/{rdvId}")
    @ResponseBody
    public RDV getRDVById(@PathVariable("rdvId") Long rdvId)  {
        // return pet
        return (RDV) rdvDao.getReferenceById(rdvId);
    }

    @RequestMapping("/")
    @ResponseBody
    public List<RDV> getRDVs()  {
        return (List<RDV>) rdvDao.findAll();
    }


    @RequestMapping("/create")
    @ResponseBody
    public String addRDV(RDV rdv) {
        // add RDV
        try{
            rdvDao.save(rdv);
        }catch (Exception e){
            return "Erreur lors de la création du RDV.";
        }
        return "RDV créer avec succès.";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String deleteRDV(RDV rdv) {
        // add RDV
        try{
            rdvDao.delete(rdv);
        }catch (Exception e){
            return "Erreur lors de la suppression du RDV.";
        }
        return "RDV créer avec succès.";
    }
}