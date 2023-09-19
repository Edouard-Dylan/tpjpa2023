package fr.istic.tpSpring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.istic.tpSpring.dao.OrganisateurDao;
import fr.istic.tpSpring.domain.Organisateur;

import java.util.List;

@Controller
public class OrganisateurController {

    @RequestMapping("/{orgaId}")
    @ResponseBody
    public Organisateur getOrgaById(@PathVariable("orgaId") Long orgaId)  {
        return (Organisateur) organisateurDao.getReferenceById(orgaId);
    }

    @RequestMapping("/")
    @ResponseBody
    public List<Organisateur> getOrgas()  {
        return (List<Organisateur>) organisateurDao.findAll();
    }


    @RequestMapping("/create")
    @ResponseBody
    public String addOrga(Organisateur orga) {
        // add Organisateur
        try{
            organisateurDao.save(orga);
        }catch (Exception e){
            return "Erreur lors de la création de l'organisateur";
        }
        return "Organisateur créer avec succès.";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String deleteOrga(Organisateur orga) {
        // add Organisateur
        try{
            organisateurDao.delete(orga);
        }catch (Exception e){
            return "Erreur lors de la suppression de l'organisateur";
        }
        return "Organisateur supprimer avec succès.";
    }

    @Autowired
    private OrganisateurDao organisateurDao;
}