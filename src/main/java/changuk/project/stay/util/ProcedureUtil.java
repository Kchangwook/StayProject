package changuk.project.stay.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProcedureUtil {

  //region Injected beans (via a RequiredArgsConstructor)
  private final EntityManager em;
  //endregion 

  /**
   * Calls a stored procedure via JPA and retrieves a single implicit result set (in DBs that
   * support them e.g. MS SQL or MySQL). The call is not dependent on a DB dialect. Be
   * aware that large result sets should be paginated and not entirely read to memory. Recreates
   * StoredProcedureQuery instance and its parameters on each call.
   * To execute MS SQL SPs performing multiple queries, SET NOCOUNT ON.
   *
   * @param procedureName stored procedure name, optionally qualified per DB syntax
   * @param resultClass converts (maps) each result set row into instances of resultClass via JPA
   * @param spArgs stored procedure arguments, supplied positionally (optional SP arguments at the
   * end of the list could be omitted)
   * @param <T> class of row instances converted per JPA
   * @return the entire result set
   */
  public <T> List<T> queryViaStoredProc(String procedureName, Class<T> resultClass,
      Object... spArgs) {
    StoredProcedureQuery spq = em.createStoredProcedureQuery(procedureName, resultClass);
    int pos = 0;
    for (Object arg : spArgs) {
      spq.registerStoredProcedureParameter(++pos, arg.getClass(), ParameterMode.IN);
      spq.setParameter(pos, arg);
    }
    return spq.getResultList();
  }

  /**
   * Calls a stored procedure via JPA and retrieves only the top row of a single implicit result
   * set (in DBs that support them e.g. MS SQL or MySQL).
   * Assumes that result set has at least one row.
   * The call is not dependent on a DB dialect.
   * Be aware that large result sets should be paginated and not entirely read to memory.
   * Recreates StoredProcedureQuery instance and its parameters on each call.
   * To execute MS SQL SPs performing multiple queries, SET NOCOUNT ON.
   *
   * @param procedureName stored procedure name, optionally qualified per DB syntax
   * @param resultClass converts (maps) each result set row into instances of resultClass via JPA
   * @param spArgs stored procedure arguments, supplied positionally (optional SP arguments at the
   * end of the list could be omitted)
   * @param <T> class of row instances converted per JPA
   * @return the entire result set
   */
  public <T> T queryTopRowViaStoredProc(String procedureName, Class<T> resultClass,
      Object... spArgs) {
    return queryViaStoredProc(procedureName, resultClass, spArgs).get(0);
  }
}