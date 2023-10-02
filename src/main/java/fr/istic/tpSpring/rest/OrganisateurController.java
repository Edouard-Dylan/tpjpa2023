package fr.istic.tpSpring.rest;

import fr.istic.tpSpring.dto.OrganisateurDTO;
import fr.istic.tpSpring.dto.mapper.MapperGlobal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import fr.istic.tpSpring.dao.OrganisateurDao;
import fr.istic.tpSpring.domain.Organisateur;

import java.util.List;

@Controller
@RequestMapping("/orga")
public class OrganisateurController {

    @GetMapping("/{orgaId}")
    @ResponseBody
    public OrganisateurDTO getOrgaById(@PathVariable("orgaId") Long orgaId)  {
        Organisateur orga = organisateurDao.getReferenceById(orgaId);
        OrganisateurDTO orgaDTO = MapperGlobal.INSTANCE.OrganisateurToOrganisateurDTO(orga);
        return orgaDTO;
    }

    @GetMapping("/")
    @ResponseBody
    public List<OrganisateurDTO> getOrgas()  {
        List<Organisateur> organisateurs = organisateurDao.findAll();
        List<OrganisateurDTO> organisateursDTO = MapperGlobal.INSTANCE.OrganisateurToOrganisateurDTO(organisateurs);
        return organisateursDTO;
    }


    @PostMapping("/create")
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

    @PostMapping("/delete")
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