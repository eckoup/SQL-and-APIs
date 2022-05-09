package com.techelevator.projects.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProject(Long projectId) {
		Project project = null;
		String sql = "SELECT project_id, name, from_date, to_date FROM project WHERE project_id = ?;";
		SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql, projectId);
		if (sqlRowSet.next()) {
		project = mapRowToProject(sqlRowSet);
		}
		return project;
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> projects = new ArrayList<>();
		String sql = "select project_id, name, from_date, to_date FROM project;";
		SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql);
		while (sqlRowSet.next()) {
			projects.add(mapRowToProject(sqlRowSet));

		}
		return projects;
	}

	@Override
	public Project createProject(Project newProject) {
		String sql = "INSERT INTO project (name, from_date, to_date)" +
		"VALUES (?, ?, ?) RETURNING project_id";
		Long projectId = jdbcTemplate.queryForObject(sql, Long.class, newProject.getName(), newProject.getFromDate(), newProject.getToDate());
		newProject.setId(projectId);
		return newProject;
	}

	@Override
	public void deleteProject(Long projectId) {
		String deleteFKProjectSql = "DELETE FROM project_employee WHERE project_id = ?;";
		jdbcTemplate.update(deleteFKProjectSql, projectId);

		String deleteProjectSql = "DELETE FROM project WHERE project_id = ?;";
		jdbcTemplate.update(deleteProjectSql, projectId);

	}

	private Project mapRowToProject (SqlRowSet set){
		Project project = new Project();
		project.setId(set.getLong("project_id"));
		project.setName(set.getString("name"));
		if (set.getDate("from_date") != null) {
			project.setFromDate(set.getDate("from_date").toLocalDate());
		}
		if (set.getDate("to_date") != null) {
			project.setToDate(set.getDate("to_date").toLocalDate());
		}
		return project;
	}

}
