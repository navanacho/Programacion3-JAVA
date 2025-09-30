package Entites;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //crear Entity
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("miBase");
        EntityManager em = emf.createEntityManager();

        //insertar pacientes
        em.getTransaction().begin();
        Paciente p1 = Paciente.builder()
                        .nombre("Pepe")
                        .apellido("Sanchez")
                        .DNI(4585255)
                        .edad(25)
                        .obraSocial("Medife")
                        .fechaNacimiento(LocalDate.of(2001,04,05))
                        .genero('M')
                        .build();
        Paciente p2 = Paciente.builder()
                        .nombre("Julieta")
                        .apellido("Nana")
                        .DNI(44856962)
                        .edad(23)
                        .obraSocial("Prevencion Salud")
                        .fechaNacimiento(LocalDate.of(2000,11,25))
                        .genero('F')
                        .build();
        Paciente p3  = Paciente.builder()
                        .nombre("Martin")
                        .apellido("Pepin")
                        .DNI(24856521)
                        .edad(88)
                        .obraSocial("Osep")
                        .fechaNacimiento(LocalDate.of(1987,01,01))
                        .genero('M')
                        .build();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit();

        //insertar medicos
        em.getTransaction().begin();
        Medico c1 = Medico.builder()
                        .nombre("Diego")
                        .apellido("Castro")
                        .edad(45)
                        .especialidad("Cirujano")
                        .matricula("C2SC5")
                        .build();
        Medico c2 = Medico.builder()
                        .nombre("Martina")
                        .apellido("Perez")
                        .edad(38)
                        .especialidad("Dermatologo")
                        .matricula("B3JD4")
                        .build();
        em.persist(c1);
        em.persist(c2);
        em.getTransaction().commit();

        //insertar consultas
        em.getTransaction().begin();
        Consulta d1 = Consulta.builder()
                        .fecha(LocalDate.of(2025, 9, 23))
                        .diagnostico("Piel reseca, falta de hidratación")
                        .build();
        Consulta d2 = Consulta.builder()
                        .fecha(LocalDate.of(2025, 5, 14))
                        .diagnostico("Cruce de ligamentos en rodilla izquierda")
                        .build();
        Consulta d3 = Consulta.builder()
                        .fecha(LocalDate.of(2025, 8, 3))
                        .diagnostico("Fractura craneal")
                        .build();
        Consulta d4 = Consulta.builder()
                        .fecha(LocalDate.of(2025, 4, 8))
                        .diagnostico("Alergias varias")
                        .build();
        em.persist(d1);
        em.persist(d2);
        em.persist(d3);
        em.persist(d4);
        em.getTransaction().commit();

        //insertar historiales clinicos
        em.getTransaction().begin();
        HistoriaClinica a1 = HistoriaClinica.builder()
                        .descripcion("Paciente con antecedentes de alergias estacionales y asma leve.")
                        .build();
        HistoriaClinica a2 = HistoriaClinica.builder()
                        .descripcion("Paciente con historial de fracturas óseas múltiples debido a accidentes deportivos.")
                        .build();
        em.persist(a1);
        em.persist(a2);
        em.getTransaction().commit();

        //insertar medicamentos
        em.getTransaction().begin();
        Medicamento z1 = Medicamento.builder()
                        .nombre("Paracetamol")
                        .droga("analgesico")
                        .pesoEnGramos(600)
                        .build();
        Medicamento z2 = Medicamento.builder()
                        .nombre("Ibuprofeno")
                        .droga("antiinflamatorio")
                        .pesoEnGramos(400)
                        .build();
        Medicamento z3 = Medicamento.builder()
                        .nombre("Amoxicilina")
                        .droga("antibiotico")
                        .pesoEnGramos(500)
                        .build();
        em.persist(z1);
        em.persist(z2);
        em.persist(z3);
        em.getTransaction().commit();


        //consultas
        List<Paciente> paciente = em.createQuery(
                        "SELECT p FROM Paciente p WHERE p.edad > 30", Paciente.class)
                .getResultList();
        paciente.forEach(System.out::println);

        Medico medico = em.find(Medico.class, 1L);
        List<Consulta> consultas = em.createQuery(
                "SELECT c FROM Consulta c WHERE c.medico = :medico", Consulta.class)
                .setParameter("medico", medico)
                .getResultList();
        consultas.forEach(System.out::println);

        List<Medicamento> medicamentos = em.createQuery(
                        "SELECT m FROM Medicamento m JOIN m.pacientes p WHERE p.id = :id", Medicamento.class)
                .setParameter("id", 1L)
                .getResultList();
        medicamentos.forEach(System.out::println);

        List<Object[]> resultados = em.createQuery(
                "SELECT c.diagnostico, c.paciente.nombre FROM Consulta c", Object[].class)
                .getResultList();
        for (Object[] fila : resultados) {
            String diagnostico = (String) fila[0];
            String nombrePaciente = (String) fila[1];}

        Double promedio = em.createQuery(
                "SELECT AVG(p.edad) FROM Paciente p", Double.class)
                .getSingleResult();
        System.out.println("Promedio de edad de los pacientes: " + promedio);

        List<Paciente> pacientes =em.createQuery(
                "SELECT p FROM Paciente p WHERE  p.obraSocial = :obraSocial", Paciente.class)
                .setParameter("obraSocial", "Medife")
                .getResultList();
        pacientes.forEach(System.out::println);

        List<Object[]> resultados2 = em.createQuery(
                "SELECT m.nombre, COUNT(c) FROM Medico m LEFT JOIN m.consultas c GROUP BY m.nombre",
                Object[].class).getResultList();
        for (Object[] fila : resultados2) {
            String nombreMedico = (String) fila[0];
            Long cantidadConsultas = (Long) fila[1];
            System.out.println("Médico: " + nombreMedico + ", Cantidad de consultas: " + cantidadConsultas);
        }

        List<Object[]> resultados3 = em.createQuery(
                "SELECT p.nombre, h.descripcion FROM Paciente p JOIN p.historiaClinica h",
                Object[].class).getResultList();
        for (Object[] fila : resultados3) {
            String nombrePaciente = (String) fila[0];
            String descripcionHistoria = (String) fila[1];
            System.out.println("Paciente: " + nombrePaciente + ", Historia Clínica: " + descripcionHistoria);
        em.close();
        emf.close();


    }
}}
