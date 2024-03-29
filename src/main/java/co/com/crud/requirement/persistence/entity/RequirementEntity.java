package co.com.crud.requirement.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "requisito")
public class RequirementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "requisito_inicial_code_seq")
    @SequenceGenerator(name = "requisito_inicial_code_seq", sequenceName = "requisito_inicial_code_seq", allocationSize = 1)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private Integer proyectoId;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 3000)
    private String descripcion;

    @Column(nullable = false, length = 12)
    private String tipoRequisito;

    @Column(nullable = false)
    private boolean calificado;

}