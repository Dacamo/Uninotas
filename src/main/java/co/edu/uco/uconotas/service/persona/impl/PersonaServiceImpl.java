package co.edu.uco.uconotas.service.persona.impl;

import co.edu.uco.uconotas.entity.PersonaEntity;
import co.edu.uco.uconotas.entity.TipoDocumentoIdentidadEntity;
import co.edu.uco.uconotas.model.TipoDocumentoIdentidad;
import co.edu.uco.uconotas.repository.PersonaRepository;
import co.edu.uco.uconotas.repository.TipoDocumentoRepository;
import co.edu.uco.uconotas.service.persona.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    public PersonaEntity findById(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public List<PersonaEntity> findAll() {
        return personaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public void save(PersonaEntity personaEntity) {
        personaRepository.save(personaEntity);
    }

    @Override
    public List<PersonaEntity> findByNroDocumentoAndTipoDocumentoIdentidad(Integer Id, String NroDocumento) {
        TipoDocumentoIdentidadEntity documento = tipoDocumentoRepository.findById(Id).orElse(null);

        return personaRepository.findByTipoDocumentoIdentidadAndNroDocumento(documento, NroDocumento);
    }

}
