package hust.project.gioimon.adm_service.repository.jdbc;

import hust.project.gioimon.adm_service.exceptions.custom.UserDoesNotExistException;
import hust.project.gioimon.adm_service.exceptions.custom.UsernameExistedException;
import hust.project.gioimon.adm_service.model.dto.response.LoginResponseDTO;
import hust.project.gioimon.adm_service.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Repository
public class UserRepository extends BaseRepository {
    public LoginResponseDTO addUser(String username, String password) {
        String sql = "SELECT ID FROM USERS WHERE USERNAME = :USERNAME";
        Map<String, Object> params = new HashMap<>();
        params.put("USERNAME", username);
        Long id = queryForObject(sql, params, Long.class);
        if (id != null) {
            throw new UsernameExistedException("USER NAME EXISTED");
        }

        sql = "INSERT INTO USERS (USERNAME, PASSWORD, ACCESS_TOKEN) VALUES(:USERNAME,:PASSWORD, :TOKEN)";
        params.put("PASSWORD", StringUtil.Hash(password));
        params.put("TOKEN", StringUtil.generateToken());

        executeSqlDatabase(sql, params);
        return getUser(username, password);
    }

    public LoginResponseDTO getUser(String username, String password) {
        log.info("^^^^^^^^" + username + password);
        String hashedPassword = StringUtil.Hash(password);
        String sql = """
                    SELECT ID, ACCESS_TOKEN FROM USERS
                    WHERE
                    USERNAME = :USERNAME
                    AND PASSWORD = :PASSWORD
                    AND FLAG_STATUS = :FLAG_STATUS
                """;
        Map<String, Object> params = new HashMap<>();
        params.put("USERNAME", username);
        params.put("PASSWORD", hashedPassword);
        params.put("FLAG_STATUS", 1);
        LoginResponseDTO rpDTO = queryForObject(sql, params, LoginResponseDTO.class);
        if (rpDTO == null) throw new UserDoesNotExistException("USER DOES NOT EXIST");
        return rpDTO;
    }

}
