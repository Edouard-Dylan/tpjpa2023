package fr.istic.tpSpring.rest;


import fr.istic.tpSpring.dto.RDVDTO;
import fr.istic.tpSpring.dto.mapper.MapperGlobal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import fr.istic.tpSpring.dao.RDVDao;
import fr.istic.tpSpring.domain.RDV;

import java.util.List;

@Controller
@RequestMapping("/rdv")
public class RDVController {

    @Autowired
    private RDVDao rdvDao;

    @GetMapping("/{rdvId}")
    @ResponseBody
    public RDVDTO getRDVById(@PathVariable("rdvId") Long rdvId)  {
        RDV rdv = rdvDao.getReferenceById(rdvId);
        RDVDTO rdvDTO = MapperGlobal.INSTANCE.RDVToRDVDTO(rdv);
        return rdvDTO;
    }

    @GetMapping("/")
    @ResponseBody
    public List<RDVDTO> getRDVs()  {
        List<RDV> rdvs = rdvDao.findAll();
        List<RDVDTO> rdvsDTO = MapperGlobal.INSTANCE.RDVToRDVDTO(rdvs);
        return rdvsDTO;
    }

    @PostMapping("/create")
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

    @PostMapping("/delete")
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