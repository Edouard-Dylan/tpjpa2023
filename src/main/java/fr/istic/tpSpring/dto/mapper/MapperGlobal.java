package fr.istic.tpSpring.dto.mapper;

import fr.istic.tpSpring.domain.Organisateur;
import fr.istic.tpSpring.domain.Professionnel;
import fr.istic.tpSpring.domain.RDV;
import fr.istic.tpSpring.dto.OrganisateurDTO;
import fr.istic.tpSpring.dto.ProfessionnelDTO;
import fr.istic.tpSpring.dto.RDVDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MapperGlobal {

    MapperGlobal INSTANCE = Mappers.getMapper(MapperGlobal.class);

    ProfessionnelDTO professionnelToProfessionnelDTO(Professionnel professionnel);

    List<ProfessionnelDTO> professionnelToProfessionnelDTO(List<Professionnel> professionnels);

    @Mapping(target = "idOrganisateur", source = "organisateur.id")
    RDVDTO RDVToRDVDTO(RDV rdv);

    List<RDVDTO> RDVToRDVDTO(List<RDV> rdv);

    OrganisateurDTO OrganisateurToOrganisateurDTO(Organisateur organisateur);

    List<OrganisateurDTO> OrganisateurToOrganisateurDTO(List<Organisateur> organisateur);
}
