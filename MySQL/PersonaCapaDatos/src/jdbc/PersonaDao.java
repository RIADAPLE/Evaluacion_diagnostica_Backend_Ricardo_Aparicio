package jdbc;

import dto.PersonaDTO;

import java.sql.SQLException;
import java.util.List;

public interface PersonaDao {
    public int insert(PersonaDTO persona)
            throws SQLException;
    public int update(PersonaDTO persona)
            throws SQLException;
    public int delete(PersonaDTO perrsona)
            throws SQLException;
    public List<PersonaDTO> select()
            throws SQLException;

}
