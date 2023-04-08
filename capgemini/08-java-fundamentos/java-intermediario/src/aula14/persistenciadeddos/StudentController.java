package aula14.persistenciadeddos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentController {

	public void save(Student student) {
		String sql = "INSERT INTO student (name, course, grade) " + 
				"VALUES (?,?,?)";
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = ConnectionFactory.getConnection();
			st = con.prepareStatement(sql);

			st.setString(1, student.getName());
			st.setString(2, student.getCourse());
			st.setDouble(3, student.getGrade());
			st.execute();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao salvar " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, st);
		}

	}
	
	public void update(Student student) {
		String sql = "UPDATE student SET name = ?, course = ?, " +
				"grade = ? WHERE id = ? ";
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = ConnectionFactory.getConnection();
			st = con.prepareStatement(sql);

			st.setString(1, student.getName());
			st.setString(2, student.getCourse());
			st.setDouble(3, student.getGrade());
			st.setInt(4,  student.getId());
			st.execute();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao atualizar " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, st);
		}

	}	
	
	public void removeById(int id) {
		String sql = "DELETE FROM student WHERE id = ?";
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = ConnectionFactory.getConnection();
			st = con.prepareStatement(sql);
			st.setInt(1, id);
			boolean removed = st.execute();
				
			if (removed)
				System.out.println("Success");

		} catch (Exception e) {
			throw new RuntimeException("Erro ao remover " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, st);
		}
	}	
	
	public Student getById(int id) {
		String sql = "SELECT * FROM student WHERE id = ?";
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;		
		Student student = new Student();

		try {
			con = ConnectionFactory.getConnection();
			st = con.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if (rs.next()) {
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setCourse(rs.getString("course"));
				student.setGrade(rs.getDouble("grade"));
			} 

		} catch (Exception e) {
			throw new RuntimeException("Erro ao consultar " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, st);
		}

		return student;
	}	

	public List<Student> getAll() {
		String sql = "SELECT * FROM student";
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		List<Student> students = new ArrayList<Student>();

		try {
			con = ConnectionFactory.getConnection();
			st = con.prepareStatement(sql);
			rs = st.executeQuery();

			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setCourse(rs.getString("course"));
				student.setGrade(rs.getDouble("grade"));

				students.add(student);
			}

		} catch (Exception e) {
			throw new RuntimeException("Erro ao consultar " + e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, st);
		}

		return students;
	}
}