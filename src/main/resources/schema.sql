CREATE TABLE IF NOT EXISTS departments(
id LONG AUTO_INCREMENT primary KEY,
department_name VARCHAR(255)
);

CREATE TABLE  IF NOT EXISTS employees(
id LONG AUTO_INCREMENT primary KEY,
name VARCHAR(255),
position VARCHAR(255),
department_id LONG,
FOREIGN KEY (department_id) REFERENCES departments(id)
);


CREATE TABLE IF NOT EXISTS projects (
    id LONG AUTO_INCREMENT PRIMARY KEY,
    project_name VARCHAR(255)
);

CREATE TABLE  IF NOT EXISTS employee_project(
employee_id LONG,
project_id LONG,
FOREIGN KEY (employee_id) REFERENCES employees(id),
FOREIGN KEY (project_id) REFERENCES projects(id),
PRIMARY KEY (employee_id, project_id)
);