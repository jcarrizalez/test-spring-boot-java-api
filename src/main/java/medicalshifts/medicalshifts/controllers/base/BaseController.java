package medicalshifts.medicalshifts.controllers.base;

import jakarta.validation.Valid;
import medicalshifts.medicalshifts.entities.Base;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

public interface BaseController<E extends Base, ID extends Serializable>
{
    public ResponseEntity<? extends Object> index();
    public ResponseEntity<? extends Object> index(Pageable pageable);
    public ResponseEntity<?> show(@PathVariable ID id);
    public ResponseEntity<?> save(@Valid @RequestBody E entity);
    public ResponseEntity<?> update(@PathVariable ID id, @Valid @RequestBody E entity);
    public ResponseEntity<?> delete(@PathVariable ID id);
}
