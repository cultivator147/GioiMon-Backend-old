package hust.project.gioimon.gm_stories.service.repository.jdbc;

import hust.project.gioimon.gm_stories.client.model.BaseResultSelect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Repository
@Slf4j
public class BaseRepository {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    public Boolean executeSqlDatabase(String queryString, Map<String, Object> mapParams) {
        boolean result = true;
        try {
            jdbcTemplate.update(queryString, mapParams);
        } catch (DataAccessException e) {
            result = false;
        }
        return result;
    }
    public <T> T queryForObject(String queryString, Map<String, Object> mapParam, Class<T> className) {
        try {
            if (className.isAssignableFrom(Long.class) || className.isAssignableFrom(Integer.class) || className.isAssignableFrom(Double.class) || className.isAssignableFrom(String.class)) {
                return jdbcTemplate.queryForObject(queryString, mapParam, className);
            } else {
                return (T) jdbcTemplate.queryForObject(queryString, mapParam, new BeanPropertyRowMapper(className));
            }
        } catch (EmptyResultDataAccessException e) {
            log.error("Error queryForObject {}", e.getMessage());
            return null;
        }
    }
    public <T> List<T> getListData(String queryString, Map<String, Object> mapParam, Class<T> className) {
        try {
            if (className.isAssignableFrom(Long.class) || className.isAssignableFrom(Integer.class) || className.isAssignableFrom(Double.class) || className.isAssignableFrom(String.class)) {
                return jdbcTemplate.queryForList(queryString, mapParam, className);
            } else {
                return jdbcTemplate.query(queryString, mapParam, new BeanPropertyRowMapper(className));
            }
        } catch (EmptyResultDataAccessException e) {
            log.error("Error getListData list {}", e.getMessage());
            return new ArrayList<>();
        }
    }
    public <T> List<T> getListData(String queryString, Map<String, Object> mapParams, Class<T> className, Integer startPage, Integer pageSize){
        startPage = startPage == null || startPage < 0 ? 0 : startPage;
        pageSize = pageSize == null || pageSize < 0 ? 10 : pageSize;
        StringBuilder sqlPage = new StringBuilder();
//        sqlPage.append(" SELECT * FROM ( ");
        sqlPage.append(queryString);
//        sqlPage.append(" ) a ");
//        sqlPage.append(String.format(" OFFSET %d ROWS FETCH NEXT %d ROWS ONLY ", startPage * pageSize, pageSize));
        sqlPage.append(String.format(" LIMIT %d OFFSET %d", pageSize, startPage * pageSize));
        return getListData(sqlPage.toString(), mapParams, className);
    }
    public <T> Page<T> getPage(String queryString, Map<String, Object> mapParams, Integer startPage, Integer pageSize, Class<T> className, String sortBy, String direction){
        try {
            startPage = startPage == null || startPage < 0 ? 0 : startPage;
            pageSize = pageSize == null || pageSize < 0 ? 10 : pageSize;
            StringBuilder sqlPage = new StringBuilder();
//            sqlPage.append(" SELECT * FROM ( ");
            sqlPage.append(queryString);
//            sqlPage.append(" ) a ");
            if(sortBy != null && !sortBy.isEmpty()){
                sqlPage.append(String.format("ORDER BY %s %s", sortBy, direction));
            }
//            sqlPage.append(String.format(" OFFSET %d ROWS FETCH NEXT %d ROWS ONLY ", startPage * pageSize, pageSize));
            sqlPage.append(String.format(" LIMIT %d OFFSET %d", pageSize, startPage * pageSize));
            String sqlCount = "SELECT COUNT(1) FROM (" + queryString + ") AS COUNT_RESULT";
            Long records = jdbcTemplate.queryForObject(sqlCount, mapParams, Long.class);
            List<T> resultQuery = getListData(sqlPage.toString(), mapParams, className);
            Pageable pageable = PageRequest.of(startPage, pageSize);
            return new PageImpl<>(resultQuery, pageable, records == null ? 0L : records);
        } catch (NumberFormatException e) {
            log.error("Error getListPagination {}", e.getMessage());
            return null;
        }
    }
    public <T> Page<T> getPage(String queryString, Map<String, Object> mapParams, Integer startPage, Integer pageSize, Class<T> className){
        try {
            startPage = startPage == null || startPage < 0 ? 0 : startPage;
            pageSize = pageSize == null || pageSize < 0 ? 10 : pageSize;
            StringBuilder sqlPage = new StringBuilder();
//            sqlPage.append(" SELECT * FROM ( ");
            sqlPage.append(queryString);
//            sqlPage.append(" ) a ");
//            sqlPage.append(String.format(" OFFSET %d ROWS FETCH NEXT %d ROWS ONLY ", startPage * pageSize, pageSize));
            sqlPage.append(String.format(" LIMIT %d OFFSET %d", pageSize, startPage * pageSize));
            String sqlCount = "SELECT COUNT(1) FROM (" + queryString + ") AS COUNT_RESULT";
            Long records = jdbcTemplate.queryForObject(sqlCount, mapParams, Long.class);
            List<T> resultQuery = getListData(sqlPage.toString(), mapParams, className);
            Pageable pageable = PageRequest.of(startPage, pageSize);
            return new PageImpl<>(resultQuery, pageable, records == null ? 0L : records);
        } catch (NumberFormatException e) {
            log.error("Error getListPagination {}", e.getMessage());
            return null;
        }
    }
}
